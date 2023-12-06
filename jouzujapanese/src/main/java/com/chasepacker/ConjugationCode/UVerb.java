package com.chasepacker.ConjugationCode;
public class UVerb implements Verb{

    private int type;
    private String kanji;
    private String hiragana;
    private String romanji;
    private String meaning;
    private char lastchar;


    private String removeu(String result)
    {
        if(lastchar != 'つ')
            return result.substring(0, result.length()-1);
        else
            return result.substring(0, result.length()-3);
    }

    public UVerb(String kan, String hira, String roma, String mean)
    {
        type = 1;
        kanji = kan;
        hiragana = hira;
        romanji = roma;
        meaning = mean;
        lastchar = hiragana.charAt(hiragana.length()-1);
    }

    @Override
    public String forPosPres() {
        String result = romanji;

        //remove u
        result = removeu(result);

        //replace with imasu
        if(lastchar == 'つ')
            result += "chimasu";
        else
            result += "imasu";


        return result;
    }

    @Override
    public String forPosPast() {
       
        String result = romanji;

        //remove u
        result = removeu(result);

        //replace with imashita
        if(lastchar == 'つ')
            result += "chimashita";
        else
            result += "imashita";
        
        return result;
    }

    @Override
    public String forPosCan() {
        String result = romanji;

        //remove u
        result = removeu(result);

        //replace with emasu
        if(lastchar == 'つ')
            result += "temasu";
        else
            result += "emasu";
        return result;
    }

    @Override
    public String forPosCaus() {
        
        String result = romanji;

        result = removeu(result);

        if(lastchar == 'つ')
            result += "tasemasu";
        else if(lastchar == 'う')
            result += "wasemasu";
        else
            result += "asemasu";


        return result;
    }

    @Override
    public String forPosPass() {
        
        String result = romanji;

        result = removeu(result);

        if(lastchar == 'つ')
            result += "taremasu";
        else if(lastchar == 'う')
            result += "waremasu";
        else
            result += "aremasu";
        return result;
    }

    @Override
    public String forNegPres() {
        
        String result = romanji;

        //remove u
        result = removeu(result);

        //replace with imasen
        if(lastchar == 'つ')
            result += "chimasen";
        else
            result += "imasen";

        return result;
    }

    @Override
    public String forNegPast() {
        
        String result = romanji;

        //remove u
        result = removeu(result);

        //replace with imasendeshita
        if(lastchar == 'つ')
            result += "chimasendeshita";
        else
            result += "imasendeshita";

        return result;
    }

    @Override
    public String forNegCan() {
        
        String result = romanji;

        //remove u
        result = removeu(result);

        //replace with emasen
        if(lastchar == 'つ')
            result += "temasen";
        else
            result += "emasen";

        return result;
    }

    @Override
    public String forNegCaus() {
        
        String result = romanji;

        result = removeu(result);

        if(lastchar == 'つ')
            result += "tasemasen";
        else if(lastchar == 'う')
            result += "wasemasen";
        else
            result += "asemasen";
        return result;
    }

    @Override
    public String forNegPass() {
        
        String result = romanji;
        result = removeu(result);

        if(lastchar == 'つ')
            result += "taremasen";
        else if(lastchar == 'う')
            result += "waremasen";
        else
            result += "aremasen";
        return result;
    }

    @Override
    public String casPosPres() {

        return romanji;
    }

    @Override
    public String casPosPast() {
        String result = romanji;

        //call te
        result = te();

        //replace e with a
        result = result.substring(0, result.length()-1);
        result+= "a";

        return result;
    }

    @Override
    public String casPosCan() {
        String result = romanji;

        //remove u
        result = removeu(result);

        //replace with eru
        if(lastchar == 'つ')
            result += "teru";
        else
            result += "eru";

        
        return result;
    }

    @Override
    public String casPosCaus() {
        String result = romanji;

        result = removeu(result);

        if(lastchar == 'つ')
            result += "taseru";
        else if(lastchar == 'う')
            result += "waseru";
        else
            result += "aseru";

        
        return result;
    }

    @Override
    public String casPosPass() {
        
        String result = romanji;
        result = removeu(result);

        if(lastchar == 'つ')
            result += "tareru";
        else if(lastchar == 'う')
            result += "wareru";
        else
            result += "areru";
        return result;
    }

    @Override
    public String casNegPres() {
        String result = romanji;

        //remove u
        result = removeu(result);

        //replace with anai
        if(lastchar == 'つ')
            result += "tanai";
        else if(lastchar == 'う')
            result += "wanai";
        else
            result += "anai";
        
        return result;
    }

    @Override
    public String casNegPast() {
        String result = romanji;

        //remove u
        result = removeu(result);

        //replace with anakatta
        if(lastchar == 'つ')
            result += "tanakatta";
        else if(lastchar == 'う')
            result += "wanakatta";
        else
            result += "anakatta";
        return result;
    }

    @Override
    public String casNegCan() {
        String result = romanji;

        //remove u
        result = removeu(result);

        //replace with enai
        if(lastchar == 'つ')
            result += "tenai";
        else
            result += "enai";
        return result;
    }

    @Override
    public String casNegCaus() {
        
        String result = romanji;
        result = removeu(result);

        if(lastchar == 'つ')
            result += "tasenai";
        else if(lastchar == 'う')
            result += "wasenai";
        else
            result += "asenai";
        return result;
    }

    @Override
    public String casNegPass() {
       
        String result = romanji;

        result = removeu(result);

        if(lastchar == 'つ')
            result += "tarenai";
        else if(lastchar == 'う')
            result += "warenai";
        else
            result += "arenai";
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

        /*
         * る・う・つーーって
         * すーーして
         * くーーいて
         * ぐーーいで
         * む・ぶ・ぬーーんで
         */
        //remove u
        
        int len = result.length();

        if(result.equals("iku"))
            return "itte";

        //replace with form as seen above
        switch(lastchar)
        {
            case 'う':
                result = result.substring(0, len-1);
                result += "tte";
                break;
            case 'る':
                result = result.substring(0, len-2);
                result += "tte";
                break;
            case 'つ':
                result = result.substring(0, len-3);
                result += "tte";
                break;
            case 'す':
                result = result.substring(0, len-2);
                result += "shite";
                break;
            case 'く':
                result = result.substring(0, len-2);
                result += "ite";
                break;
            case 'ぐ':
                result = result.substring(0, len-2);
                result += "ide";
                break;
            default:
                result = result.substring(0, len-2);
                result += "nde";

        }


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

        result = removeu(result);

        if(lastchar == 'つ')
            result += "teba";
        else
            result += "eba";
        return result;
    }

    @Override
    public String negBa() {
        String result = casNegPres();
        
        return result.substring(0, result.length()-1) + "kereba";
    }
    
}
