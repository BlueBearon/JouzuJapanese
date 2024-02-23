


const ROMANJI = [
    "a", "i", "u", "e", "o",  
    "ka", "ki", "ku", "ke", "ko",
    "sa", "shi", "su", "se", "so",
    "ta", "chi", "tsu", "te", "to",
    "na", "ni", "nu", "ne", "no",
    "ha", "hi", "fu", "he", "ho",
    "ma", "mi", "mu", "me", "mo",
    "ra", "ri", "ru", "re", "ro",
    "ya", "yu", "yo", "wa", "wo", "n",
    "ga", "gi", "gu", "ge", "go",
    "za", "ji", "zu", "ze", "zo",
    "da", "dji", "dzu", "de", "do",
    "ba", "bi", "bu", "be", "bo",  
    "pa", "pi", "pu", "pe", "po",
    "kya", "kyu", "kyo",
    "sha", "shu", "sho",
    "cha", "chu", "cho",
    "nya", "nyu", "nyo",
    "hya", "hyu", "hyo",
    "mya", "myu", "myo",
    "rya", "ryu", "ryo",
    "gya", "gyu", "gyo",
    "jya", "jyu", "jyo",
    "bya", "byu", "byo",
    "pya", "pyu", "pyo"
];

const HIRAGANA = [
    "あ", "い", "う", "え", "お",  
    "か", "き", "く", "け", "こ",
    "さ", "し", "す", "せ", "そ",
    "た", "ち", "つ", "て", "と",
    "な", "に", "ぬ", "ね", "の",
    "は", "ひ", "ふ", "へ", "ほ",
    "ま", "み", "む", "め", "も",
    "ら", "り", "る", "れ", "ろ",
    "や", "ゆ", "よ", "わ", "を", "ん",
    "が", "ぎ", "ぐ", "げ", "ご",
    "ざ", "じ", "ず", "ぜ", "ぞ",
    "だ", "ぢ", "づ", "で", "ど",
    "ば", "び", "ぶ", "べ", "ぼ",  
    "ぱ", "ぴ", "ぷ", "ぺ", "ぽ",
    "きゃ", "きゅ", "きょ",
    "しゃ", "しゅ", "しょ",
    "ちゃ", "ちゅ", "ちょ",
    "にゃ", "にゅ", "にょ",
    "ひゃ", "ひゅ", "ひょ",
    "みゃ", "みゅ", "みょ",
    "りゃ", "りゅ", "りょ",
    "ぎゃ", "ぎゅ", "ぎょ",
    "じゃ", "じゅ", "じょ",
    "びゃ", "びゅ", "びょ",
    "ぴゃ", "ぴゅ", "ぴょ"   
];



const KATAKANA = [
    "ア", "イ", "ウ", "エ", "オ",
    "カ", "キ", "ク", "ケ", "コ",
    "サ", "シ", "ス", "セ", "ソ",
    "タ", "チ", "ツ", "テ", "ト",
    "ナ", "ニ", "ヌ", "ネ", "ノ",
    "ハ", "ヒ", "フ", "ヘ", "ホ",
    "マ", "ミ", "ム", "メ", "モ",
    "ラ", "リ", "ル", "レ", "ロ",
    "ヤ", "ユ", "ヨ", "ワ", "ヲ", "ン",
    "ガ", "ギ", "グ", "ゲ", "ゴ",
    "ザ", "ジ", "ズ", "ゼ", "ゾ",
    "ダ", "ヂ", "ヅ", "デ", "ド",   
    "バ", "ビ", "ブ", "ベ", "ボ",  
    "パ", "ピ", "プ", "ペ", "ポ",   
    "キャ", "キュ", "キョ",
    "シャ", "シュ", "ショ",
    "チャ", "チュ", "チョ",
    "ニャ", "ニュ", "ニョ",
    "ヒャ", "ヒュ", "ヒョ",
    "ミャ", "ミュ", "ミョ",
    "リャ", "リュ", "リョ",
    "ギャ", "ギュ", "ギョ",
    "ジャ", "ジュ", "ジョ",
    "ビャ", "ビュ", "ビョ",
    "ピャ", "ピュ", "ピョ",
];



/**
 * Hashmap that contains the conversions between each hiragana and its romanji counterpart.
 * Romanji is the key and hiragana is the value.
 * 
 * Cannot be used until Word.setupMap() has been called.
 */
let ROMATOHIRA = new Map();


/**
 * Hashmap that contains the conversions between each hiragana and its romanji counterpart.
 * Hiragana is the key and romanji is the value.
 * 
 * Cannot be used until Word.setupMap() has been called.
 */
let HIRATOROMA = new Map();


/**
 * Marks whether or not the hashmaps have been initialized.
 * When setupMap() is called, the value becomes true and the maps
 * are not reinitialized after that point.
 */
let setup = false;


/**
* Uses the Hiragana and romanji string arrays, to create the hashmaps used for converting
* between the two writing systems.
* 
* Will be called by first conversion request
*/
function setupMap() {
    for(let i =  0; i < ROMANJI.length; i++) {
        ROMATOHIRA.set(ROMANJI[i], HIRAGANA[i]);
        HIRATOROMA.set(HIRAGANA[i], ROMANJI[i]);
    }
    setup = true;
}

/**
 * Converts a word in romaji to a word in hiragana.
 * Scans romaji word and replaces alphabet letters with their hiragana counterpart.
 * 
 * @param romaji word to be converted
 * @return String of word in hiragana
 */
function romajiParser(romaji) {
    if(!setup) setupMap();
    
    let res = "";
    let token = "";
    let index =  0;

    while(index < romaji.length) {
        token = "";

        while(!ROMATOHIRA.has(token)) {
            token += romaji.charAt(index);
            index++;

            if(index < romaji.length && token.length ===  1 && token === romaji.charAt(index)) {
                token = "";
                res += "っ";
            }
        }

        if(token === "n" && index < romaji.length) {
            let check = token + romaji.charAt(index);
            if(ROMATOHIRA.has(check)) {
                index++;
                res += ROMATOHIRA.get(check);
            } else {
                res += ROMATOHIRA.get(token);
            }
        } else {
            res += ROMATOHIRA.get(token);
        }
    }

    return res;
}


/**
 * Converts a word or phrase from hiragana to romanji.  Scans the given string and
 * converts each hiragana to its romanji counterpart.
 * 
 * @param hiragana String to be converted
 * @return converted romanji string
 */
function hiraganaParser(hiragana) {
    if(!setup) setupMap();

    let res = "";
    let len = hiragana.length;
    let smalltsu = false;
    let index =  0;

    while(index < len) {
        let checkString = "";
        if(index +  1 < len) {
            checkString = hiragana.charAt(index) + hiragana.charAt(index+1);
        }

        let toadd = "";
        
        if(HIRATOROMA.has(checkString)) {
            toadd = HIRATOROMA.get(checkString);
            if(smalltsu) {
                res += toadd.charAt(0) + toadd;
                smalltsu = false;
            } else {
                res += toadd;
            }
            index +=  2;
        } else if(hiragana.charAt(index) === 'っ') {
            smalltsu = true;
            index++;
        } else {
            toadd = HIRATOROMA.get(hiragana.charAt(index));
            if(smalltsu) {
                res += toadd.charAt(0) + toadd;
                smalltsu = false;
            } else {
                res += toadd;
            }
            index++;
        }
    }

    return res;
}


module.exports = {
    romajiParser,
    hiraganaParser
}
