package com.chasepacker.ConjugationCode;
import java.util.HashMap;
import java.util.Map;


public interface Word {


    public static final String[] ROMANJI = 
    {"a", "i", "u", "e", "o", 
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
    };

    public static final String[] HIRAGANA = 
    {"あ", "い", "う", "え", "お", 
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
    };

    public static final String[] KATAKANA =
    {"ア", "イ", "ウ", "エ", "オ",
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
    };
  

    /**
     * Hashmap that contains the conversions between each hiragana and its romanji counterpart.
     * Romanji is the key and hiragana is the value.
     * 
     * Cannot be used until Word.setupMap() has been called.
     */
    static Map<String, String> ROMATOHIRA = new HashMap<String, String>();
    
    

    /**
     * Hashmap that contains the conversions between each hiragana and its romanji counterpart.
     * Hiragana is the key and romanji is the value.
     * 
     * Cannot be used until Word.setupMap() has been called.
     */
    static Map<String, String> HIRATOROMA = new HashMap<String, String>();

    static Map<String, String> UTOA = Map.ofEntries(
        Map.entry("う", "わ"),
        Map.entry("く", "か"),
        Map.entry("す", "さ"),
        Map.entry("つ", "た"),
        Map.entry("ぬ", "な"),
        Map.entry("ふ", "は"),
        Map.entry("む", "ま"),
        Map.entry("ゆ", "や"),
        Map.entry("る", "ら"),
        Map.entry("ぐ", "が"),
        Map.entry("ず", "ざ"),
        Map.entry("づ", "だ"),
        Map.entry("ぶ", "ば"),
        Map.entry("ぷ", "ぱ")
    );

    static Map<String, String> UTOE = Map.ofEntries(
        Map.entry("う", "え"),
        Map.entry("く", "け"),
        Map.entry("す", "せ"),
        Map.entry("つ", "て"),
        Map.entry("ぬ", "ね"),
        Map.entry("ふ", "へ"),
        Map.entry("む", "め"),
        Map.entry("ゆ", "い"),
        Map.entry("る", "れ"),
        Map.entry("ぐ", "げ"),
        Map.entry("ず", "ぜ"),
        Map.entry("づ", "で"),
        Map.entry("ぶ", "べ"),
        Map.entry("ぷ", "ぺ")
    );


    static Map<String, String> UTOO = Map.ofEntries(
        Map.entry("う", "お"),
        Map.entry("く", "こ"),
        Map.entry("す", "そ"),
        Map.entry("つ", "と"),
        Map.entry("ぬ", "の"),
        Map.entry("ふ", "ほ"),
        Map.entry("む", "も"),
        Map.entry("ゆ", "よ"),
        Map.entry("る", "ろ"),
        Map.entry("ぐ", "ご"),
        Map.entry("ず", "ぞ"),
        Map.entry("づ", "ど"),
        Map.entry("ぶ", "ぼ"),
        Map.entry("ぷ", "ぽ")
    );

    static Map<String, String> UTOI = Map.ofEntries(
        Map.entry("う", "い"),
        Map.entry("く", "き"),
        Map.entry("す", "し"),
        Map.entry("つ", "ち"),
        Map.entry("ぬ", "に"),
        Map.entry("ふ", "ひ"),
        Map.entry("む", "み"),
        Map.entry("ゆ", "い"),
        Map.entry("る", "り"),
        Map.entry("ぐ", "ぎ"),
        Map.entry("ず", "じ"),
        Map.entry("づ", "ぢ"),
        Map.entry("ぶ", "び"),
        Map.entry("ぷ", "ぴ")
    );

    /**
     * Marks whether or not the hashmaps have been initialized.
     * When setupMap() is called, the value becomes true and the maps
     * are not reinitialized after that point.
     */
    static boolean[] setup = {false};

    

    /**
     * Uses the Hiragana and romanji string arrays, to create the hashmaps used for converting
     * between the two writing systems.
     * 
     * Will be called by first conversion request
     */
    public static void setupMap()
    {
        for(int i = 0; i < ROMANJI.length; i++)
        {
            ROMATOHIRA.put(ROMANJI[i], HIRAGANA[i]);
            HIRATOROMA.put(HIRAGANA[i], ROMANJI[i]);
        }

        setup[0] = true;
    }

   
    /**
     * @return kanji string representation of word
     */
    public String getKanji();
    /**
     * @return hiragana string representation of word
     */
    public String getHiragana();
    /**
     * @return romanji string representation of word
     */
    public String getRomanji();
    /**
     * @return string with english meaning of word
     */
    public String getEngMeaning();

    /**
     * Returns type of a word.
     * 
     * Adjective:  
     * 1 - い Adjective
     * 2 - な Adjective
     * 
     * Verb:
     * 1 - う Verbs
     * 2 - る Verbs
     * 3 - する・くる Verbs
     * @return int type
     */
    public int getType();

    /**
     * Converts a word in romanji to a word in hiragana.
     * Scans romanji word and replaces alphabet letters with their hiragana counterpart.
     * 
     * @param romanji word to be converted
     * @return String of word in hiragana
     */
    public static String romanjiParser(String romanji)
    {

        if(!setup[0])
            setupMap();
        
        StringBuilder res = new StringBuilder();//Contains the result as we build it
        String token; //Contains the active string we are trying to convert into a hiragana character
        int index = 0;

        while(index < romanji.length())
        {
            token = "";

            while(!ROMATOHIRA.containsKey(token))
            {
                token += romanji.charAt(index);
                index++;

                //Need to check for extended sounds (tta becomes った), 
                //so check to see if next char is the same
                if(index < romanji.length() && token.equals(String.valueOf(romanji.charAt(index))))
                {
                    token = "";
                    res.append("っ");
                }
            }

            //We need to ensure that we don't cut of at n when the actual token should be na, ni, etc.
            if(token.equals("n") && index < romanji.length())
            {
                String check = token + romanji.charAt(index);

                if(ROMATOHIRA.containsKey(check))
                {
                    index++;
                    res.append(ROMATOHIRA.get(check));
                }
                else
                {
                    res.append(ROMATOHIRA.get(token));
                }
            }
            else
            {
                res.append(ROMATOHIRA.get(token));
            }

        }

        return res.toString();
    }

    /**
     * Converts a word or phrase from hiragana to romanji.  Scans the given string and
     * converts each hiragana to its romanji counterpart.
     * 
     * @param hiragana String to be converted
     * @return converted romanji string
     */
    public static String hiraganaParser(String hiragana)
    {
        if(!setup[0])
        setupMap();

        StringBuilder res = new StringBuilder();
        int len = hiragana.length();
        boolean smalltsu = false;

        int index = 0;

        while(index < len)
        {
            
            //Need to check for extended hiragana such as きゅ, so we need to check a character ahead
            String checkString = "";
            if(index + 1 < len)
            {
                checkString = String.valueOf(hiragana.charAt(index)) + String.valueOf(hiragana.charAt(index+1));
            }

            String toadd = "";
            
            if(HIRATOROMA.containsKey(checkString))//If we do have an extended hiragana
            {
                toadd = HIRATOROMA.get(checkString);

                if(smalltsu)//in case of extended sound, we repeat the first char:  って -> tte
                {
                    res.append(toadd.charAt(0) + toadd);
                    smalltsu = false;
                }
                else
                {
                    res.append(toadd);
                }
                
                index+=2;//skip ahead as that is two characters
            }
            else if(hiragana.charAt(index) == 'っ')//if we have an extended sound such as って
            {
                smalltsu = true;//mark flag, so that we can add additional char when we know what it is
                index++;
            }
            else
            {
                toadd = HIRATOROMA.get(String.valueOf(hiragana.charAt(index)));

                if(smalltsu)
                {
                    res.append(toadd.charAt(0) + toadd);
                    smalltsu = false;
                }
                else
                {
                    res.append(toadd);
                }

                index++;
            }

            
        }

        return res.toString();
    }

    /**
     * Given a う hiragana, returns the corresponding あ hiragana
     * @param kana
     * @return
     */
    public static String uToa(String kana)
    {
        return UTOA.get(kana);
    }

    /**
     * Given a う hiragana, returns the corresponding え hiragana
     * @param kana
     * @return
     */
    public static String uToe(String kana)
    {
        return UTOE.get(kana);
    }

    /**
     * Given a う hiragana, returns the corresponding い hiragana
     * @param kana
     * @return
     */
    public static String uToi(String kana)
    {
        return UTOI.get(kana);
    }

    /**
     * Given a う hiragana, returns the corresponding お hiragana
     * @param kana
     * @return
     */
    public static String uToo(String kana)
    {
        return UTOO.get(kana);
    }


    
}
