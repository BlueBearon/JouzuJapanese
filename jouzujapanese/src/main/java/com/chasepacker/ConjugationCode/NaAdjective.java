package com.chasepacker.ConjugationCode;
public class NaAdjective implements Adjective{

    private int type;
    private String kanji;
    private String hiragana;
    private String romanji;
    private String meaning;

    public NaAdjective(String kan, String hira, String roma, String mean)
    {
        type = 0;
        kanji = kan;
        hiragana = hira;
        romanji = roma;
        meaning = mean;

    }

    @Override
    public String forPosPres() {
        //add desu
        return romanji + "desu";
    }

    @Override
    public String forPosPast() {
        // Add deshita
        return romanji + "deshita";
    }

    @Override
    public String forNegPres() {
        // add jyanaidesu
        return romanji + "jyanaidesu";
    }

    @Override
    public String forNegPast() {
        // add jyanakattadesu
        return romanji + "jyanakattadesu";
    }

    @Override
    public String casPosPres() {
        // add da
        return romanji + "da";
    }

    @Override
    public String casPosPast() {
        // add datta
        return romanji + "datta";
    }

    @Override
    public String casNegPres() {
        // add jyanai
        return romanji + "jyanai";
    }

    @Override
    public String casNegPast() {
        // add jyanakatta
        return romanji + "jyanakatta";
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
        // add "de"
        return romanji + "de";
    }

    @Override
    public String toString()
    {
        return romanji;
    }
    
}
