package com.chasepacker.ConjugationCode;
public interface Verb extends Word{

    //Base Conjugation Forms
    
    /**
     * Returns the dictionary form of the verb (causal positive present)
     * @return dictionary form of verb
     */
    public String casualPositivePresent();

    /**
     * Returns the casual negative present form of the verb
     * @return  casual negative present form of verb
     */
    public String casualNegativePresent();

    /**
     * Returns the casual positive past form of the verb
     * @return casual positive past form of verb
     */
    public String casualPositivePast();

    /**
     * Returns the casual negative past form of the verb
     * @return casual negative past form of verb
     */
    public String casualNegativePast();

    /**
     * Returns the formal positive present form of the verb
     * @return formal positive present form of verb
     */
    public String formalPositivePresent();

    /**
     * Returns the formal negative present form of the verb
     * @return formal negative present form of verb
     */
    public String formalNegativePresent();

    /**
     * Returns the formal positive past form of the verb
     * @return formal positive past form of verb
     */
    public String formalPositivePast();

    /**
     * Returns the formal negative past form of the verb
     * @return formal negative past form of verb
     */
    public String formalNegativePast();

    /**
     * Returns the te form of the verb
     * @return te form of verb
     */
    public String te();


    //Modifiers

    /**
     * Returns the potential form of the verb
     * @return potential form of verb
     */
    public String potential();

    /**
     * Returns the passive form of the verb
     * @return passive form of verb
     */
    public String passive();

    /**
     * Returns the causative form of the verb
     * @return causative form of verb
     */
    public String causative();

    /**
     * Returns the causative passive form of the verb
     * @return causative passive form of verb
     */
    public String volitional();


    
    
}
