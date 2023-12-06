package com.chasepacker.ConjugationCode;
public interface Adjective extends Word{

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
     * Conjugatino for te form
     * @return string result
     */
    public String te();

    
}
