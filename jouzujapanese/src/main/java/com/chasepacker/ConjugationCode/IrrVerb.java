package com.chasepacker.ConjugationCode;
public class IrrVerb implements Verb{

    private int type;
    private String kanji;
    private String hiragana;
    private String romanji;
    private String meaning;

    public IrrVerb(String kan, String hira, String roma, String mean)
    {
        type = 3;
        kanji = kan;
        hiragana = hira;
        romanji = roma;
        meaning = mean;
    }

    /**
     * Checks if the word ends with suru or kuru
     * @param word
     * @return true if the word ends with suru, false if kuru
     */
    public Boolean isSuru(String word)
    {
        return word.endsWith("する");
    }

    public String cutVerb(String word)
    {
        return word.substring(0, word.length()-2);
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
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "しない";
        }
        else
        {
            return cutVerb(hiragana) + "こない";
        }
       
    }


    @Override
    public String casualPositivePast() {
       
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "した";
        }
        else
        {
            return cutVerb(hiragana) + "きた";
        }
    }


    @Override
    public String casualNegativePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "しなかった";
        }
        else
        {
            return cutVerb(hiragana) + "こなかった";
        } 
    }


    @Override
    public String formalPositivePresent() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "します";
        }
        else
        {
            return cutVerb(hiragana) + "きます";
        }
    }


    @Override
    public String formalNegativePresent() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "しません";
        }
        else
        {
            return cutVerb(hiragana) + "きません";
        }
    }


    @Override
    public String formalPositivePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "しました";
        }
        else
        {
            return cutVerb(hiragana) + "きました";
        }

    }
    @Override
    public String formalNegativePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "しませんでした";
        }
        else
        {
            return cutVerb(hiragana) + "きませんでした";
        }
    }


    @Override
    public String te() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "して";
        }
        else
        {
            return cutVerb(hiragana) + "きて";
        }
    }


    @Override
    public String potential() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "できる";
        }
        else
        {
            return cutVerb(hiragana) + "こられる";
        }
    }


    @Override
    public String passive() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "される";
        }
        else
        {
            return cutVerb(hiragana) + "こられる";
        }
    }


    @Override
    public String causative() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "させる";
        }
        else
        {
            return cutVerb(hiragana) + "こさせる";
        }
    }


    @Override
    public String volitional() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "しよう";
        }
        else
        {
            return cutVerb(hiragana) + "こよう";
        }
    }
    
    
}
