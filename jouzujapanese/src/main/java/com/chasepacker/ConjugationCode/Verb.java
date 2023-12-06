package com.chasepacker.ConjugationCode;
public interface Verb extends Word{

    /**
     * Conjugation for Formal Positive Present/Future
     * @return string result
     */
    public String forPosPres();
    /**
     * Conjugation for Formal Positive Past
     * @return string result
     */
    public String forPosPast();
    /**
     * Conjugation for Formal Positive potential
     * @return string result
     */
    public String forPosCan();
    /**
     * Conjugation for Formal Positive Causative
     * @return string result
     */
    public String forPosCaus();
    /**
     * Conjugation for Formal Positive Passive
     * @return string result
     */
    public String forPosPass();
    /**
     * Conjugation for Formal Negative Present/Future
     * @return string result
     */
    public String forNegPres();

    /**
     * Conjugation for Formal Negative Past
     * @return string result
     */
    public String forNegPast();

    /**
     * Conjugation for Formal Negative Potential
     * @return string result
     */
    public String forNegCan();

    /**
     * Conjugation for Formal Negative Causative
     * @return string result
     */
    public String forNegCaus();

    /**
     * Conjugation for Formal Negative Passive
     * @return string result
     */
    public String forNegPass();

    /**
     * Conjugation for Casual Positive Present/Future
     * @return string result
     */
    public String casPosPres();

    /**
     * Conjugation for Casual Positive Past
     * @return string result
     */
    public String casPosPast();

    /**
     * Conjugation for Casual Positive Potential
     * @return string result
     */
    public String casPosCan();

    /**
     * Conjugation for Casual Positive Casuative
     * @return string result
     */
    public String casPosCaus();

    /**
     * Conjugation for Casual Positive Passive
     * @return string result
     */
    public String casPosPass();

    /**
     * Conjugation for Casual Negative Present/Future
     * @return string result
     */
    public String casNegPres();

    /**
     * Conjugation for Casual Negative Past
     * @return string result
     */
    public String casNegPast();

    /**
     * Conjugation for Casual Negative Potential
     * @return string result
     */
    public String casNegCan();

    /**
     * Conjugation for Casual Negative Causative
     * @return string result
     */
    public String casNegCaus();

    /**
     * Conjugation for Casual Negative Passive
     * @return string result
     */
    public String casNegPass();

    /**
     * Conjugation for te form
     * @return string result
     */
    public String te();
    
    /**
     * Conjugation for tara form
     * @return string result
     */
    public String tara();

    /**
     * Conjugation for tari form
     * @return string result
     */
    public String tari();

    /**
     * Conjugation for ba form
     * @return string result
     */
    public String ba();

    /**
     * Conjugation for negative ba form
     * @return string result
     */
    public String negBa();

    
    
}
