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
     * Returns the potential form of the verb, casual negative present
     * @return passive form of verb
     */
    public String potentialCasualNegativePresent();
    
    /**
     * Returns the potential form of the verb, casual positive past
     * @return
     */
    public String potentialCasualPositivePast();

    /**
     * Returns the potential form of the verb, casual negative past
     * @return
     */
    public String potentialCasualNegativePast();

    /**
     * Returns the potential form of the verb, formal positive present
     * @return
     */
    public String potentialFormalPositivePresent();

    /**
     * Returns the potential form of the verb, formal negative present
     * @return
     */
    public String potentialFormalNegativePresent();

    /**
     * Returns the potential form of the verb, formal positive past
     * @return
     */
    public String potentialFormalPositivePast();

    /**
     * Returns the potential form of the verb, formal negative past
     * @return
     */
    public String potentialFormalNegativePast();

    /**
     * Returns the passive form of the verb
     * @return passive form of verb
     */
    public String passive();

    /**
     * Returns the passive form of the verb, casual negative present
     * @return passive form of verb
     */
    public String passiveCasualNegativePresent();

    /**
     * Returns the passive form of the verb, casual positive past
     * @return passive form of verb
     */
    public String passiveCasualPositivePast();

    /**
     * Returns the passive form of the verb, casual negative past
     * @return passive form of verb
     */
    public String passiveCasualNegativePast();

    /**
     * Returns the passive form of the verb, formal positive present
     * @return passive form of verb
     */
    public String passiveFormalPositivePresent();

    /**
     * Returns the passive form of the verb, formal negative present
     * @return passive form of verb
     */
    public String passiveFormalNegativePresent();

    /**
     * Returns the passive form of the verb, formal positive past
     * @return passive form of verb
     */
    public String passiveFormalPositivePast();

    /**
     * Returns the passive form of the verb, formal negative past
     * @return passive form of verb
     */
    public String passiveFormalNegativePast();

    /**
     * Returns the causative form of the verb
     * @return causative form of verb
     */
    public String causative();

    /**
     * Returns the causative form of the verb, casual negative present
     * @return causative form of verb
     */
    public String causativeCasualNegativePresent();

    /**
     * Returns the causative form of the verb, casual positive past
     * @return causative form of verb
     */
    public String causativeCasualPositivePast();

    /**
     * Returns the causative form of the verb, casual negative past
     * @return causative form of verb
     */
    public String causativeCasualNegativePast();

    /**
     * Returns the causative form of the verb, formal positive present
     * @return causative form of verb
     */
    public String causativeFormalPositivePresent();

    /**
     * Returns the causative form of the verb, formal negative present
     * @return causative form of verb
     */
    public String causativeFormalNegativePresent();

    /**
     * Returns the causative form of the verb, formal positive past
     * @return causative form of verb
     */
    public String causativeFormalPositivePast();

    /**
     * Returns the causative form of the verb, formal negative past
     * @return causative form of verb
     */
    public String causativeFormalNegativePast();

    /**
     * Returns the volitional form of the verb
     * @return volitional passive form of verb
     */
    public String volitional();

    /**
     * Retuns the volitional form of the verb, formal
     * @return volitional form of verb
     */
    public String volitionalFormal();
    


    
    
}
