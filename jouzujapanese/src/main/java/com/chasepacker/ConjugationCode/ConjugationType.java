package com.chasepacker.ConjugationCode;


public enum ConjugationType {
    CASUAL_POSITIVE_PRESENT,
    CASUAL_NEGATIVE_PRESENT,
    CASUAL_POSITIVE_PAST,
    CASUAL_NEGATIVE_PAST,
    FORMAL_POSITIVE_PRESENT,
    FORMAL_NEGATIVE_PRESENT,
    FORMAL_POSITIVE_PAST,
    FORMAL_NEGATIVE_PAST,
    TE,
    POTENTIAL,
    PASSIVE,
    CAUSATIVE,
    VOLITIONAL,
    POTENTIAL_CASUAL_NEGATIVE_PRESENT,
    POTENTIAL_CASUAL_POSITIVE_PAST,
    POTENTIAL_CASUAL_NEGATIVE_PAST,
    POTENTIAL_FORMAL_POSITIVE_PRESENT,
    POTENTIAL_FORMAL_NEGATIVE_PRESENT,
    POTENTIAL_FORMAL_POSITIVE_PAST,
    POTENTIAL_FORMAL_NEGATIVE_PAST,
    PASSIVE_CASUAL_NEGATIVE_PRESENT,
    PASSIVE_CASUAL_POSITIVE_PAST,
    PASSIVE_CASUAL_NEGATIVE_PAST,
    PASSIVE_FORMAL_POSITIVE_PRESENT,
    PASSIVE_FORMAL_NEGATIVE_PRESENT,
    PASSIVE_FORMAL_POSITIVE_PAST,
    PASSIVE_FORMAL_NEGATIVE_PAST,
    CAUSATIVE_CASUAL_NEGATIVE_PRESENT,
    CAUSATIVE_CASUAL_POSITIVE_PAST,
    CAUSATIVE_CASUAL_NEGATIVE_PAST,
    CAUSATIVE_FORMAL_POSITIVE_PRESENT,
    CAUSATIVE_FORMAL_NEGATIVE_PRESENT,
    CAUSATIVE_FORMAL_POSITIVE_PAST,
    CAUSATIVE_FORMAL_NEGATIVE_PAST,
    VOLITIONAL_FORMAL;

    /**
     * Returns the ConjugationType from the string
     * @param text
     * @return
     */
    public static ConjugationType fromString(String text) {
        if (text != null) {
            for (ConjugationType b : ConjugationType.values()) {
                if (text.equalsIgnoreCase(b.toString())) {
                    return b;
                }
            }
        }
        return null;
    }

    @Override
    public String toString()
    {
        switch(this)
        {
            case CASUAL_POSITIVE_PRESENT:
                return "Casual Positive Present";
            case CASUAL_NEGATIVE_PRESENT:
                return "Casual Negative Present";
            case CASUAL_POSITIVE_PAST:
                return "Casual Positive Past";
            case CASUAL_NEGATIVE_PAST:
                return "Casual Negative Past";
            case FORMAL_POSITIVE_PRESENT:
                return "Formal Positive Present";
            case FORMAL_NEGATIVE_PRESENT:
                return "Formal Negative Present";
            case FORMAL_POSITIVE_PAST:
                return "Formal Positive Past";
            case FORMAL_NEGATIVE_PAST:
                return "Formal Negative Past";
            case TE:
                return "Te";
            case POTENTIAL:
                return "Potential Form";
            case PASSIVE:
                return "Passive Form";
            case CAUSATIVE:
                return "Causative Form";
            case VOLITIONAL:
                return "Volitional Form";
            case POTENTIAL_CASUAL_NEGATIVE_PRESENT:
                return "Potential Casual Negative Present";
            case POTENTIAL_CASUAL_POSITIVE_PAST:
                return "Potential Casual Positive Past";
            case POTENTIAL_CASUAL_NEGATIVE_PAST:
                return "Potential Casual Negative Past";
            case POTENTIAL_FORMAL_POSITIVE_PRESENT:
                return "Potential Formal Positive Present";
            case POTENTIAL_FORMAL_NEGATIVE_PRESENT:
                return "Potential Formal Negative Present";
            case POTENTIAL_FORMAL_POSITIVE_PAST:
                return "Potential Formal Positive Past";
            case POTENTIAL_FORMAL_NEGATIVE_PAST:
                return "Potential Formal Negative Past";
            case PASSIVE_CASUAL_NEGATIVE_PRESENT:
                return "Passive Casual Negative Present";
            case PASSIVE_CASUAL_POSITIVE_PAST:
                return "Passive Casual Positive Past";
            case PASSIVE_CASUAL_NEGATIVE_PAST:
                return "Passive Casual Negative Past";
            case PASSIVE_FORMAL_POSITIVE_PRESENT:
                return "Passive Formal Positive Present";
            case PASSIVE_FORMAL_NEGATIVE_PRESENT:
                return "Passive Formal Negative Present";
            case PASSIVE_FORMAL_POSITIVE_PAST:
                return "Passive Formal Positive Past";
            case PASSIVE_FORMAL_NEGATIVE_PAST:
                return "Passive Formal Negative Past";
            case CAUSATIVE_CASUAL_NEGATIVE_PRESENT:
                return "Causative Casual Negative Present";
            case CAUSATIVE_CASUAL_POSITIVE_PAST:
                return "Causative Casual Positive Past";
            case CAUSATIVE_CASUAL_NEGATIVE_PAST:
                return "Causative Casual Negative Past";
            case CAUSATIVE_FORMAL_POSITIVE_PRESENT:
                return "Causative Formal Positive Present";
            case CAUSATIVE_FORMAL_NEGATIVE_PRESENT:
                return "Causative Formal Negative Present";
            case CAUSATIVE_FORMAL_POSITIVE_PAST:
                return "Causative Formal Positive Past";
            case CAUSATIVE_FORMAL_NEGATIVE_PAST:
                return "Causative Formal Negative Past";
            case VOLITIONAL_FORMAL:
                return "Volitional Formal";
            default:
                return "Error: Invalid Conjugation Type";
        }
    }
}

