package com.chasepacker.ConjugationCode;


public class UVerb implements Verb{

    private int type;
    private String kanji;
    private String hiragana;
    private String romanji;
    private String meaning;

    public UVerb(String kan, String hira, String roma, String mean)
    {
        type = 1;
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
        
        String result = hiragana;

        String replacement = Word.uToa(result.substring(result.length()-1));

        result = result.substring(0, result.length()-1);

        result += replacement + "ない";

        return result;
    }


    @Override
    public String casualPositivePast() {
        
        String result = hiragana;

        if(result == "いく")
        {
            return "いった";
        }

        String lastchar = result.substring(result.length()-1);

        switch(lastchar)
        {
            case "う":
                result = result.substring(0, result.length()-1);
                result += "った";
                break;
            case "る":
                result = result.substring(0, result.length()-1);
                result += "った";
                break;
            case "つ":
                result = result.substring(0, result.length()-1);
                result += "った";
                break;
            case "す":
                result = result.substring(0, result.length()-1);
                result += "した";
                break;
            case "く":
                result = result.substring(0, result.length()-1);
                result += "いた";
                break;
            case "ぐ":
                result = result.substring(0, result.length()-1);
                result += "いだ";
                break;
            default:
                result = result.substring(0, result.length()-1);
                result += "んだ";

        }

        return result;
    }


    @Override
    public String casualNegativePast() {
        
        String result = hiragana;

        String replacement = Word.uToa(result.substring(result.length()-1));

        result = result.substring(0, result.length()-1);

        result += replacement + "なかった";

        return result;
    }


    @Override
    public String formalPositivePresent() {
        
        String result = hiragana;

        String replacement = Word.uToi(result.substring(result.length()-1));

        result = result.substring(0, result.length()-1);

        result += replacement + "ます";

        return result;
    }


    @Override
    public String formalNegativePresent() {
        
        String result = hiragana;

        String replacement = Word.uToi(result.substring(result.length()-1));

        result = result.substring(0, result.length()-1);

        result += replacement + "ません";

        return result;
    }


    @Override
    public String formalPositivePast() {
        
        String result = hiragana;

        String replacement = Word.uToi(result.substring(result.length()-1));

        result = result.substring(0, result.length()-1);

        result += replacement + "ました";

        return result;

    }
    @Override
    public String formalNegativePast() {
        
        String result = hiragana;

        String replacement = Word.uToi(result.substring(result.length()-1));

        result = result.substring(0, result.length()-1);

        result += replacement + "ませんでした";

        return result;
    }

    
    @Override
    public String te() {
        
        String result = hiragana;

        if(result == "いく")
        {
            return "いって";
        }

        String lastchar = result.substring(result.length()-1);

        switch(lastchar)
        {
            case "う":
                result = result.substring(0, result.length()-1);
                result += "って";
                break;
            case "る":
                result = result.substring(0, result.length()-1);
                result += "って";
                break;
            case "つ":
                result = result.substring(0, result.length()-1);
                result += "って";
                break;
            case "す":
                result = result.substring(0, result.length()-1);
                result += "して";
                break;
            case "く":
                result = result.substring(0, result.length()-1);
                result += "いて";
                break;
            case "ぐ":
                result = result.substring(0, result.length()-1);
                result += "いで";
                break;
            default:
                result = result.substring(0, result.length()-1);
                result += "んで";

        }

        return result;
        
    }


    @Override
    public String potential() {
        
        String result = hiragana;

        String replacement = Word.uToe(result.substring(result.length()-1));

        result = result.substring(0, result.length()-1);

        result += replacement + "る";

        return result;
    }


    @Override
    public String passive() {
        
        String result = hiragana;

        String replacement = Word.uToa(result.substring(result.length()-1));

        result = result.substring(0, result.length()-1);

        result += replacement + "れる";

        return result;
    }


    @Override
    public String causative() {
        
        String result = hiragana;

        String replacement = Word.uToa(result.substring(result.length()-1));

        result = result.substring(0, result.length()-1);

        result += replacement + "せる";

        return result;
    }


    @Override
    public String volitional() {
        
        String result = hiragana;

        String replacement = Word.uToo(result.substring(result.length()-1));

        result = result.substring(0, result.length()-1);

        result += replacement + "う";

        return result;
    }

    @Override
    public String potentialCasualNegativePresent() {
        
        String result = potential();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ない
        result += "ない";

        return result;
    }


    @Override
    public String potentialCasualPositivePast() {
        
        String result = potential();

        //remove る
        result = result.substring(0, result.length()-1);

        //add た
        result += "た";

        return result;
    }


    @Override
    public String potentialCasualNegativePast() {
        
        String result = potential();

        //remove る
        result = result.substring(0, result.length()-1);

        //add なかった
        result += "なかった";

        return result;
    }


    @Override
    public String potentialFormalPositivePresent() {
        
        String result = potential();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ます
        result += "ます";

        return result;
    }


    @Override
    public String potentialFormalNegativePresent() {
        
        String result = potential();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ません
        result += "ません";

        return result;
    }


    @Override
    public String potentialFormalPositivePast() {
        
        String result = potential();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ました
        result += "ました";

        return result;
    }


    @Override
    public String potentialFormalNegativePast() {
        
        String result = potential();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ませんでした
        result += "ませんでした";

        return result;
    }


    @Override
    public String passiveCasualNegativePresent() {
        
        String result = passive();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ない
        result += "ない";

        return result;
    }


    @Override
    public String passiveCasualPositivePast() {
        
        String result = passive();

        //remove る
        result = result.substring(0, result.length()-1);

        //add た
        result += "た";

        return result;
    }


    @Override
    public String passiveCasualNegativePast() {
        
        String result = passive();

        //remove る
        result = result.substring(0, result.length()-1);

        //add なかった
        result += "なかった";

        return result;
    }


    @Override
    public String passiveFormalPositivePresent() {
        
        String result = passive();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ます
        result += "ます";

        return result;
    }


    @Override
    public String passiveFormalNegativePresent() {
        
        String result = passive();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ません
        result += "ません";

        return result;
    }


    @Override
    public String passiveFormalPositivePast() {
        
        String result = passive();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ました
        result += "ました";

        return result;
    }


    @Override
    public String passiveFormalNegativePast() {
        
        String result = passive();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ませんでした
        result += "ませんでした";

        return result;
    }


    @Override
    public String causativeCasualNegativePresent() {
        
        String result = causative();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ない
        result += "ない";

        return result;
    }


    @Override
    public String causativeCasualPositivePast() {
        
        String result = causative();

        //remove る
        result = result.substring(0, result.length()-1);

        //add た
        result += "た";

        return result;
    }


    @Override
    public String causativeCasualNegativePast() {
        
        String result = causative();

        //remove る
        result = result.substring(0, result.length()-1);

        //add なかった
        result += "なかった";

        return result;
    }


    @Override
    public String causativeFormalPositivePresent() {
        
        String result = causative();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ます
        result += "ます";

        return result;
    }


    @Override
    public String causativeFormalNegativePresent() {
        
        String result = causative();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ません
        result += "ません";

        return result;
    }


    @Override
    public String causativeFormalPositivePast() {
        
        String result = causative();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ました
        result += "ました";

        return result;
    }


    @Override
    public String causativeFormalNegativePast() {
        
        String result = causative();

        //remove る
        result = result.substring(0, result.length()-1);

        //add ませんでした
        result += "ませんでした";

        return result;
    }

    @Override
    public String volitionalFormal() {
        
        String result = hiragana;

        String replacement = Word.uToi(result.substring(result.length()-1));

        result = result.substring(0, result.length()-1);

        result += replacement + "ましょう";

        return result;

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
            case POTENTIAL:
                return potential();
            case PASSIVE:
                return passive();
            case CAUSATIVE:
                return causative();
            case VOLITIONAL:
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
