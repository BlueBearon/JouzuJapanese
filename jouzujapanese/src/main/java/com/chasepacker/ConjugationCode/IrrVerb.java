package com.chasepacker.ConjugationCode;
public class IrrVerb implements Verb{

    private int type;
    private String kanji;
    private String hiragana;
    private String romanji;
    private String meaning;
    private int kuru;

    public IrrVerb(String kan, String hira, String roma, String mean)
    {
        type = 3;
        kanji = kan;
        hiragana = hira;
        romanji = roma;
        meaning = mean;
        kuru = romanji.equals("kuru") ? 1 : 0;
    }


    @Override
    public String forPosPres() {
        
        if(kuru == 1)
            return "kimasu";
        else
            return romanji.replace("suru", "shimasu");
        
    }

    @Override
    public String forPosPast() {
        if(kuru == 1)
            return "kimashita";
        else
            return romanji.replace("suru", "shimashita");
    }

    @Override
    public String forPosCan() {
        if(kuru == 1)
            return "koraremasu";
        else
            return romanji.replace("suru", "dekimasu");
    }

    @Override
    public String forPosCaus() {
        if(kuru == 1)
            return "kosasemasu";
        else
            return romanji.replace("suru", "sasemasu");
    }

    @Override
    public String forPosPass() {
        if(kuru == 1)
            return "koraremasu";
        else
            return romanji.replace("suru", "saremasu");
    }

    @Override
    public String forNegPres() {
        if(kuru == 1)
            return "kimasen";
        else
            return romanji.replace("suru", "shimasen");
    }

    @Override
    public String forNegPast() {
        if(kuru == 1)
            return "kimasendeshita";
        else
            return romanji.replace("suru", "shimasendeshita");
    }

    @Override
    public String forNegCan() {
        if(kuru == 1)
            return "koraremasen";
        else
            return romanji.replace("suru", "dekimasen");
    }

    @Override
    public String forNegCaus() {
        if(kuru == 1)
            return "kosasemasen";
        else
            return romanji.replace("suru", "sasemasen");
    }

    @Override
    public String forNegPass() {
        if(kuru == 1)
            return "koraremasen";
        else
            return romanji.replace("suru", "saremasen");
    }

    @Override
    public String casPosPres() {
        return romanji;
    }

    @Override
    public String casPosPast() {
        if(kuru == 1)
            return "kita";
        else
            return romanji.replace("suru", "shita");
    }

    @Override
    public String casPosCan() {
        if(kuru == 1)
            return "korareru";
        else
            return romanji.replace("suru", "dekiru");
    }

    @Override
    public String casPosCaus() {
        if(kuru == 1)
            return "kosaseru";
        else
            return romanji.replace("suru", "saseru");
    }

    @Override
    public String casPosPass() {
        if(kuru == 1)
            return "korareru";
        else
            return romanji.replace("suru", "sareru");
    }

    @Override
    public String casNegPres() {
        if(kuru == 1)
            return "konai";
        else
            return romanji.replace("suru", "shinai");
    }

    @Override
    public String casNegPast() {
        if(kuru == 1)
            return "konakatta";
        else
            return romanji.replace("suru", "shinakatta");
    }

    @Override
    public String casNegCan() {
        if(kuru == 1)
            return "korarenai";
        else
            return romanji.replace("suru", "dekinai");
    }

    @Override
    public String casNegCaus() {
        if(kuru == 1)
            return "kosasenai";
        else
            return romanji.replace("suru", "sasenai");
    }

    @Override
    public String casNegPass() {
        if(kuru == 1)
            return "korarenai";
        else
            return romanji.replace("suru", "sarenai");
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
        if(kuru == 1)
            return romanji.replace("kuru", "kite");
        else
            return romanji.replace("suru", "shite");
    }

    @Override
    public String toString()
    {
        return romanji;
    }


    @Override
    public String tara() {
        return casPosPast() + "ra";
    }


    @Override
    public String tari() {
        return casPosPast() + "ri";
    }


    @Override
    public String ba() {

        if(kuru == 1)
            return romanji.replace("kuru", "kureba");
        else
            return romanji.replace("suru", "sureba");
        

    }


    @Override
    public String negBa() {
        String result = casNegPres();
        
        return result.substring(0, result.length()-1) + "kereba";
    }
    
}
