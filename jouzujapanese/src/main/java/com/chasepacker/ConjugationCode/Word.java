package com.chasepacker.ConjugationCode;
import java.util.HashMap;
import java.util.Map;


public interface Word {

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

    /**
     * Marks whether or not the hashmaps have been initialized.
     * When setupMap() is called, the value becomes true and the maps
     * are not reinitialized after that point.
     */
    static boolean[] setup = {false};

    public static final String[] ROMANJI = 
    {"a", "i", "u", "e", "o", 
    "ka", "ki", "ku", "ke", "ko",
    "ga", "gi", "gu", "ge", "go",
    "sa", "shi", "su", "se", "so",
    "za", "ji", "zu", "ze", "zo",
    "ta", "chi", "tsu", "te", "to",
    "da", "dji", "dzu", "de", "do",
    "na", "ni", "nu", "ne", "no",
    "ha", "hi", "fu", "he", "ho",
    "ba", "bi", "bu", "be", "bo", 
    "pa", "pi", "pu", "pe", "po",
    "ma", "mi", "mu", "me", "mo",
    "ra", "ri", "ru", "re", "ro",
    "ya", "yu", "yo", "wa", "wo", "n",
    "kya", "kyu", "kyo",
    "gya", "gyu", "gyo",
    "sha", "shu", "sho",
    "jya", "jyu", "jyo",
    "cha", "chu", "cho",
    "nya", "nyu", "nyo",
    "hya", "hyu", "hyo",
    "bya", "byu", "byo",
    "pya", "pyu", "pyo",
    "mya", "myu", "myo",
    "rya", "ryu", "ryo"
    };

    public static final String[] HIRAGANA = 
    {"あ", "い", "う", "え", "お", 
    "か", "き", "く", "け", "こ",
    "が", "ぎ", "ぐ", "げ", "ご",
    "さ", "し", "す", "せ", "そ",
    "ざ", "じ", "ず", "ぜ", "ぞ",
    "た", "ち", "つ", "て", "と",
    "だ", "ぢ", "づ", "で", "ど",
    "な", "に", "ぬ", "ね", "の",
    "は", "ひ", "ふ", "へ", "ほ",
    "ば", "び", "ぶ", "べ", "ぼ", 
    "ぱ", "ぴ", "ぷ", "ぺ", "ぽ",
    "ま", "み", "む", "め", "も",
    "ら", "り", "る", "れ", "ろ",
    "や", "ゆ", "よ", "わ", "を", "ん",
    "きゃ", "きゅ", "きょ",
    "ぎゃ", "ぎゅ", "ぎょ",
    "しゃ", "しゅ", "しょ",
    "じゃ", "じゅ", "じょ",
    "ちゃ", "ちゅ", "ちょ",
    "にゃ", "にゅ", "にょ",
    "ひゃ", "ひゅ", "ひょ",
    "びゃ", "びゅ", "びょ",
    "ぴゃ", "ぴゅ", "ぴょ",
    "みゃ", "みゅ", "みょ",
    "りゃ", "りゅ", "りょ"
    };

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


    
}
