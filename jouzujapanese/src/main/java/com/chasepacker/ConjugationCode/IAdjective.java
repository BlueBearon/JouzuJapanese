package com.chasepacker.ConjugationCode;
public class IAdjective implements Adjective{

    private int type;
    private String kanji;
    private String hiragana;
    private String romanji;
    private String meaning;

    public IAdjective(String kan, String hira, String roma, String mean)
    {
        type = 0;
        kanji = kan;
        hiragana = hira;
        romanji = roma;
        meaning = mean;

    }

    private String removei(String result)
    {
        return result.substring(0, result.length()-1);
    }

    @Override
    public String formalPositivePresent() {
        String result = hiragana;

        //add です
        result += "です";
        
        return result;
    }

    @Override
    public String formalPositivePast() {
        String result = hiragana;

        //call casPosPast()
        result = casualPositivePast();
        //add です
        result+= "です";
        return result;
    }

    @Override
    public String formalNegativePresent() {
        String result = hiragana;

        //call casNegPres
        result = casualNegativePresent();
        //add です
        result+= "です";
        return result;
    }

    @Override
    public String formalNegativePast() {
        String result = hiragana;

        //call casNegPast
        result = casualNegativePast();
        //add です
        result += "です";
        return result;
    }

    @Override
    public String casualPositivePresent() {
        
        return hiragana;
    }

    @Override
    public String casualPositivePast() {
        String result = hiragana;

        //remove i
        result = removei(result);
        //add かった
        result+= "かった";
        return result;
    }

    @Override
    public String casualNegativePresent() {
        String result = hiragana;

        //remove i
        result = removei(result);
        //add くない
        result += "くない";
        return result;
    }

    @Override
    public String casualNegativePast() {
        String result = hiragana;

        //remove i
        result = removei(result);
        //add くなかった
        result += "くなかった";
        return result;
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
    public String te() {
        String result = hiragana;

        //remove i
        result = removei(result);
        //replace with kute
        result+= "くて";
        return result;
    }

    @Override
    public String toString()
    {
        return hiragana;
    }
    
}
