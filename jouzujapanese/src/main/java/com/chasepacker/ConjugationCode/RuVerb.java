package com.chasepacker.ConjugationCode;
public class RuVerb implements Verb{

    private int type;
    private String kanji;
    private String hiragana;
    private String romanji;
    private String meaning;

    public RuVerb(String kan, String hira, String roma, String mean)
    {
        type = 2;
        kanji = kan;
        hiragana = hira;
        romanji = roma;
        meaning = mean;
    }


    @Override
    public String getKanji() {
        
        return kanji;
    }


    @Override
    public String getHiragana() {
        
        return hiragana;
    }


    @Override
    public String getRomanji() {
        
        return romanji;
    }


    @Override
    public String getEngMeaning() {
        
        return meaning;
    }


    @Override
    public int getType() {
        
        return type;
    }


    @Override
    public String casualPositivePresent() {
          
        return hiragana;
    }


    @Override
    public String casualNegativePresent() {
        
        //remove る
        String result = hiragana.substring(0, hiragana.length()-1);

        //add ない
        result += "ない";

        return result;
    }


    @Override
    public String casualPositivePast() {
        
        String result = hiragana;

        //remove る
        result = result.substring(0, result.length()-1);

        //add た
        result += "た";

        return result;
    }


    @Override
    public String casualNegativePast() {
        
        String result = hiragana;

        //remove る
        result = result.substring(0, result.length()-1);

        //add なかった
        result += "なかった";

        return result;
    }


    @Override
    public String formalPositivePresent() {
        
        String result = hiragana;

        //remove る
        result = result.substring(0, result.length()-1);

        //add ます
        result += "ます";

        return result;
    }


    @Override
    public String formalNegativePresent() {
        
        String result = hiragana;

        //remove る
        result = result.substring(0, result.length()-1);

        //add ません
        result += "ません";

        return result;
    }


    @Override
    public String formalPositivePast() {
        
        String result = hiragana;

        //remove る
        result = result.substring(0, result.length()-1);

        //add ました
        result += "ました";

        return result;

    }
    @Override
    public String formalNegativePast() {
        
        String result = hiragana;

        //remove る
        result = result.substring(0, result.length()-1);

        //add ませんでした
        result += "ませんでした";

        return result;
    }


    @Override
    public String te() {
        
        String result = hiragana;

        //remove る
        result = result.substring(0, result.length()-1);

        //add て
        result += "て";
        
        return result;
    }


    @Override
    public String potential() {
        
        String result = hiragana;

        //remove る
        result = result.substring(0, result.length()-1);

        //add られる
        result += "られる";

        return result;
    }


    @Override
    public String passive() {
        
        String result = hiragana;

        //remove る
        result = result.substring(0, result.length()-1);

        //add られる
        result += "られる";

        return result;
    }


    @Override
    public String causative() {
        
        String result = hiragana;

        //remove る
        result = result.substring(0, result.length()-1);

        //add させる
        result += "させる";

        return result;
    }

    @Override
    public String volitional() {
        
        String result = hiragana;

        //remove る
        result = result.substring(0, result.length()-1);

        //add よう
        result += "よう";

        return result;
    }
    
}
