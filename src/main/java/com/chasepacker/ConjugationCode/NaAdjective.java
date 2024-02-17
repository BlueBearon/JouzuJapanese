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
    public String formalPositivePresent() {
        //add です
        return hiragana + "です";
    }

    @Override
    public String formalPositivePast() {
        // Add でした
        return hiragana + "でした";
    }

    @Override
    public String formalNegativePresent() {
        // add じゃないです
        return hiragana + "じゃないです";
    }

    @Override
    public String formalNegativePast() {
        // add じゃなかったです
        return hiragana + "じゃなかったです";
    }

    @Override
    public String casualPositivePresent() {
        // add だ
        return hiragana + "だ";
    }

    @Override
    public String casualPositivePast() {
        // add だった
        return hiragana + "だった";
    }

    @Override
    public String casualNegativePresent() {
        // add じゃない
        return hiragana + "じゃない";
    }

    @Override
    public String casualNegativePast() {
        // add じゃなかった
        return hiragana + "じゃなかった";
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
        return hiragana + "で";
    }

    @Override
    public String toString()
    {
        return hiragana;
    }

    @Override
    public String getConjugation(ConjugationType conjugationType) {
       
        switch(conjugationType)
        {
            case CASUAL_POSITIVE_PRESENT:
                return casualPositivePresent();
            case CASUAL_NEGATIVE_PRESENT:
                return casualNegativePresent();
            case CASUAL_POSITIVE_PAST:
                return casualPositivePast();
            case CASUAL_NEGATIVE_PAST:
                return casualNegativePast();
            case FORMAL_POSITIVE_PRESENT:
                return formalPositivePresent();
            case FORMAL_NEGATIVE_PRESENT:
                return formalNegativePresent();
            case FORMAL_POSITIVE_PAST:
                return formalPositivePast();
            case FORMAL_NEGATIVE_PAST:
                return formalNegativePast();
            case TE:
                return te();
            default:
                return "Error";
        }
    }
    
}
