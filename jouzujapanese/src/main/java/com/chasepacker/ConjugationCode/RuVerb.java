package com.chasepacker.ConjugationCode;
public class RuVerb implements Verb{

    private int type;
    private String kanji;
    private String hiragana;
    private String romanji;
    private String meaning;


    private String cutRu(String result)
    {
        return result.substring(0, result.length()-2);
    }


    public RuVerb(String kan, String hira, String roma, String mean)
    {
        type = 2;
        kanji = kan;
        hiragana = hira;
        romanji = roma;
        meaning = mean;
    }


    @Override
    public String forPosPres() {
        
        String result = romanji;

        //cut off ru
        result = cutRu(result);

        //add masu
        result += "masu";

        return result;
    }

    @Override
    public String forPosPast() {
        
        String result = romanji;

        //cut off ru
        result = cutRu(result);

        //add mashita
        result += "mashita";

        return result;
    }

    @Override
    public String forPosCan() {
        
        String result = romanji;

        //cut off ru
        result = cutRu(result);

        //add raremasu
        result += "raremasu";

        return result;
    }

    @Override
    public String forPosCaus() {
        
        String result = romanji;

        result = cutRu(result);

        result += "sasemasu";

        return result;
    }

    @Override
    public String forPosPass() {

        //For ru verbs, Passive form is the same as the Potential form
        //ex. たべるーたべられます
       
        return forPosCan();
        
    }

    @Override
    public String forNegPres() {
        
        String result = romanji;

        //cut off ru
        result = cutRu(result);
        
        //add masen
        result += "masen";

        return result;
    }

    @Override
    public String forNegPast() {
      
        String result = romanji;

        //cut off ru
        result = cutRu(result);
        //add masendeshita
        result += "masendeshita";

        return result;
    }

    @Override
    public String forNegCan() {
        
        String result = romanji;

        //Cut of ru
        result = cutRu(result);

        //add raremasen
        result += "raremasen";

        return result;
    }

    @Override
    public String forNegCaus() {
        
        String result = romanji;

        result = cutRu(result);

        result += "sasemasen";

        return result;
    }

    @Override
    public String forNegPass() {

        //Same as potential form
        
        return forNegCan();
    }

    @Override
    public String casPosPres() {
        
        return romanji;
    }

    @Override
    public String casPosPast() {
        String result = romanji;
        
        //remove ru
        result = cutRu(result);

        //add ta
        result += "ta";
        return result;
    }

    @Override
    public String casPosCan() {
        
        String result = romanji;

        //remove ru
        result = cutRu(result);

        //add rareru
        result += "rareru";
        return result;
    }

    @Override
    public String casPosCaus() {
        
        String result = romanji;

        result = cutRu(result);

        result += "saseru";

        return result;
    }

    @Override
    public String casPosPass() {
        
        //same as potential form
        
        return casPosCan();
    }

    @Override
    public String casNegPres() {
        String result = romanji;

        //remove ru
        result = cutRu(result);

        //add nai
        result += "nai";

        return result;
    }

    @Override
    public String casNegPast() {
        String result = romanji;

        //remove ru
        result = cutRu(result);

        //add nakatta
        result += "nakatta";

        return result;
    }

    @Override
    public String casNegCan() {
        String result = romanji;

        //remove ru
        result = cutRu(result);

        //add rarenai
        result+= "rarenai";
        return result;
    }

    @Override
    public String casNegCaus() {
        
        String result = romanji;

        result = cutRu(result);

        result += "sasenai";
        return result;
    }

    @Override
    public String casNegPass() {
        //Same as potential form
        return casNegCan();
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

        //remove ru
        result = cutRu(result);

        //add te
        result += "te";
        
        return result;
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

        String result = romanji;

        result = result.substring(0, result.length()-1);

        result += "eba";

        return result;
        
    }


    @Override
    public String negBa() {

        String result = casNegPres();
        
        return result.substring(0, result.length()-1) + "kereba";
    }
    
}
