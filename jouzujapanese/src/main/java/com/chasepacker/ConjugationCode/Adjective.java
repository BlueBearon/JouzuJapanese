package com.chasepacker.ConjugationCode;
public interface Adjective extends Word{

    /**
     * Conjugation for Formal Positive Present/Future
     * @return string result
     */
    public String formalPositivePresent();

    /**
     * Conjugation for Formal Positive Past
     * @return string result
     */
    public String formalPositivePast();

    /**
     * Conjugation for Formal Negative Present/Future
     * @return string result
     */
    public String formalNegativePresent();

    /**
     * Conjugation for Formal Negative Past
     * @return string result
     */
    public String formalNegativePast();

    /**
     * Conjugation for Casual Positive Present/Future
     * @return string result
     */
    public String casualPositivePresent();

    /**
     * Conjugation for Casual Positive Past
     * @return string result
     */
    public String casualPositivePast();

    /**
     * Conjugation for Casual Negative Present/Future
     * @return string result
     */
    public String casualNegativePresent();

    /**
     * Conjugation for Casual Negative Past
     * @return string result
     */
    public String casualNegativePast();

    /**
     * Conjugatino for te form
     * @return string result
     */
    public String te();


    /**
     * Returns the requested conjugation of the adjective.
     * Uses switch statement to determine which conjugation to return.
     * @param conjugationType
     */
    public String getConjugation(ConjugationType conjugationType);

    
}
