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

    @Override
    public String potentialCasualNegativePresent() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "できない";
        }
        else
        {
            return cutVerb(hiragana) + "こられない";
        }
    }

    @Override
    public String potentialCasualPositivePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "できた";
        }
        else
        {
            return cutVerb(hiragana) + "こられた";
        }
    }

    @Override
    public String potentialCasualNegativePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "できなかった";
        }
        else
        {
            return cutVerb(hiragana) + "こられなかった";
        }
    }

    @Override
    public String potentialFormalPositivePresent() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "できます";
        }
        else
        {
            return cutVerb(hiragana) + "こられます";
        }
    }

    @Override
    public String potentialFormalNegativePresent() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "できません";
        }
        else
        {
            return cutVerb(hiragana) + "こられません";
        }
    }

    @Override
    public String potentialFormalPositivePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "できました";
        }
        else
        {
            return cutVerb(hiragana) + "こられました";
        }
    }

    @Override
    public String potentialFormalNegativePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "できませんでした";
        }
        else
        {
            return cutVerb(hiragana) + "こられませんでした";
        }
    }

    @Override
    public String passiveCasualNegativePresent() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "されない";
        }
        else
        {
            return cutVerb(hiragana) + "こられない";
        }
    }

    @Override
    public String passiveCasualPositivePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "された";
        }
        else
        {
            return cutVerb(hiragana) + "こられた";
        }
    }

    @Override
    public String passiveCasualNegativePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "されなかった";
        }
        else
        {
            return cutVerb(hiragana) + "こられなかった";
        }
    }

    @Override
    public String passiveFormalPositivePresent() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "されます";
        }
        else
        {
            return cutVerb(hiragana) + "こられます";
        }
    }

    @Override
    public String passiveFormalNegativePresent() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "されません";
        }
        else
        {
            return cutVerb(hiragana) + "こられません";
        }
    }

    @Override
    public String passiveFormalPositivePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "されました";
        }
        else
        {
            return cutVerb(hiragana) + "こられました";
        }
    }

    @Override
    public String passiveFormalNegativePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "されませんでした";
        }
        else
        {
            return cutVerb(hiragana) + "こられませんでした";
        }
    }

    @Override
    public String causativeCasualNegativePresent() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "させない";
        }
        else
        {
            return cutVerb(hiragana) + "こさせない";
        }
    }

    @Override
    public String causativeCasualPositivePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "させた";
        }
        else
        {
            return cutVerb(hiragana) + "こさせた";
        }
    }

    @Override
    public String causativeCasualNegativePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "させなかった";
        }
        else
        {
            return cutVerb(hiragana) + "こさせなかった";
        }
    }

    @Override
    public String causativeFormalPositivePresent() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "させます";
        }
        else
        {
            return cutVerb(hiragana) + "こさせます";
        }
    }

    @Override
    public String causativeFormalNegativePresent() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "させません";
        }
        else
        {
            return cutVerb(hiragana) + "こさせません";
        }
    }

    @Override
    public String causativeFormalPositivePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "させました";
        }
        else
        {
            return cutVerb(hiragana) + "こさせました";
        }
    }

    @Override
    public String causativeFormalNegativePast() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "させませんでした";
        }
        else
        {
            return cutVerb(hiragana) + "こさせませんでした";
        }
    }

    @Override
    public String volitionalFormal() {
        
        if(isSuru(hiragana))
        {
            return cutVerb(hiragana) + "しましょう";
        }
        else
        {
            return cutVerb(hiragana) + "きましょう";
        }
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
            case POTENTIAL_CASUAL_POSITIVE_PRESENT:
                return potential();
            case PASSIVE_CASUAL_POSITIVE_PRESENT:
                return passive();
            case CAUSATIVE_CASUAL_POSITIVE_PRESENT:
                return causative();
            case VOLITIONAL_CASUAL:
                return volitional();
            case POTENTIAL_CASUAL_NEGATIVE_PRESENT:
                return potentialCasualNegativePresent();
            case POTENTIAL_CASUAL_POSITIVE_PAST:
                return potentialCasualPositivePast();
            case POTENTIAL_CASUAL_NEGATIVE_PAST:
                return potentialCasualNegativePast();
            case POTENTIAL_FORMAL_POSITIVE_PRESENT:
                return potentialFormalPositivePresent();
            case POTENTIAL_FORMAL_NEGATIVE_PRESENT:
                return potentialFormalNegativePresent();
            case POTENTIAL_FORMAL_POSITIVE_PAST:
                return potentialFormalPositivePast();
            case POTENTIAL_FORMAL_NEGATIVE_PAST:
                return potentialFormalNegativePast();
            case PASSIVE_CASUAL_NEGATIVE_PRESENT:
                return passiveCasualNegativePresent();
            case PASSIVE_CASUAL_POSITIVE_PAST:
                return passiveCasualPositivePast();
            case PASSIVE_CASUAL_NEGATIVE_PAST:
                return passiveCasualNegativePast();
            case PASSIVE_FORMAL_POSITIVE_PRESENT:
                return passiveFormalPositivePresent();
            case PASSIVE_FORMAL_NEGATIVE_PRESENT:
                return passiveFormalNegativePresent();
            case PASSIVE_FORMAL_POSITIVE_PAST:
                return passiveFormalPositivePast();
            case PASSIVE_FORMAL_NEGATIVE_PAST:
                return passiveFormalNegativePast();
            case CAUSATIVE_CASUAL_NEGATIVE_PRESENT:
                return causativeCasualNegativePresent();
            case CAUSATIVE_CASUAL_POSITIVE_PAST:
                return causativeCasualPositivePast();
            case CAUSATIVE_CASUAL_NEGATIVE_PAST:
                return causativeCasualNegativePast();
            case CAUSATIVE_FORMAL_POSITIVE_PRESENT:
                return causativeFormalPositivePresent();
            case CAUSATIVE_FORMAL_NEGATIVE_PRESENT:
                return causativeFormalNegativePresent();
            case CAUSATIVE_FORMAL_POSITIVE_PAST:
                return causativeFormalPositivePast();
            case CAUSATIVE_FORMAL_NEGATIVE_PAST:
                return causativeFormalNegativePast();
            case VOLITIONAL_FORMAL:
                return volitionalFormal();
            default:
                return "Error";

        }
	}
    
    
}
