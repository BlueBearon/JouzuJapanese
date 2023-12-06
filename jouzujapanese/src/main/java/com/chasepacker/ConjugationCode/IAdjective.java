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
        return result.substring(0, result.length()-2);
    }

    @Override
    public String forPosPres() {
        String result = romanji;

        //add desu
        result += "desu";
        
        return result;
    }

    @Override
    public String forPosPast() {
        String result = romanji;

        //call casPosPast()
        result = casPosPast();
        //add desu
        result+= "desu";
        return result;
    }

    @Override
    public String forNegPres() {
        String result = romanji;

        //call casNegPres
        result = casNegPres();
        //add desu
        result+= "desu";
        return result;
    }

    @Override
    public String forNegPast() {
        String result = romanji;

        //call casNegPast
        result = casNegPast();
        //add desu
        result += "desu";
        return result;
    }

    @Override
    public String casPosPres() {
        
        return romanji;
    }

    @Override
    public String casPosPast() {
        String result = romanji;

        //remove i
        result = removei(result);
        //add katta
        result+= "katta";
        return result;
    }

    @Override
    public String casNegPres() {
        String result = romanji;

        //remove i
        result = removei(result);
        //add kunai
        result += "kunai";
        return result;
    }

    @Override
    public String casNegPast() {
        String result = romanji;

        //remove i
        result = removei(result);
        //add kunakatta
        result += "kunakatta";
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
        String result = romanji;

        //remove i
        result = removei(result);
        //replace with kute
        result+= "kute";
        return result;
    }

    @Override
    public String toString()
    {
        return romanji;
    }
    
}
