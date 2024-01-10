import React, { useState, useEffect, useRef } from 'react';


function Options(props)
{

    const [options, setOptions] = useState(props.options);

    //Set options to the current options passed in from the parent component
    useEffect(() => {

        setOptions(props.options);

    }, [props.options]);

    /**
     * Validate the verb type options.
     * At least one verb type must be selected.
     * If the user tries to deselect all verb types, the one they tried to deselect will be reselected.
     * @param {*} index 
     * @param {*} newOptions 
     */
    function validateVerbType(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[0] === false && newOptions[1] === false && newOptions[2] === false)
        {
            newOptions[index] = true;
            alert("At least one verb type must be selected.");
        }
    }

    /**
     * Validate the verb formality options.
     * At least one verb formality must be selected.
     * If the user tries to deselect all verb formalities, the one they tried to deselect will be reselected.
     * @param {*} index
     * @param {*} newOptions
     * @returns
     */
    function validateVerbFormality(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[3] === false && newOptions[4] === false)
        {
            newOptions[index] = true;
            alert("At least one verb formality must be selected.");
        }
    }


    function validateVerbTense(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[5] === false && newOptions[6] === false)
        {
            newOptions[index] = true;
            alert("At least one verb tense must be selected.");
        }
    }

    function validateVerbPolarity(index, newOptions)
    {
        newOptions[index] = !newOptions[index];
        
        if(newOptions[7] === false && newOptions[8] === false)
        {
            newOptions[index] = true;
            alert("At least one verb polarity must be selected.");
        }
    }

    function validateVerbForm(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[9] === false && newOptions[10] === false && newOptions[11] === false && newOptions[12] === false && newOptions[13] === false)
        {
            newOptions[index] = true;
            alert("At least one verb form must be selected.");
        }
    }

    function verbValidation(index, newOptions)
    {
        if(index < 3)
        {
            validateVerbType(index, newOptions);
        }
        else if(index < 5)
        {
            validateVerbFormality(index, newOptions);
        }
        else if(index < 7)
        {
            validateVerbTense(index, newOptions);
        }
        else if(index < 9)
        {
            validateVerbPolarity(index, newOptions);
        }
        else
        {
            validateVerbForm(index, newOptions);
        }
    }

    function validateAdjectiveType(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[0] === false && newOptions[1] === false)
        {
            newOptions[index] = true;
            alert("At least one adjective type must be selected.");
        }
    }

    function validateAdjectiveFormality(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[2] === false && newOptions[3] === false)
        {
            newOptions[index] = true;
            alert("At least one adjective formality must be selected.");
        }
    }

    function validateAdjectiveTense(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[4] === false && newOptions[5] === false)
        {
            newOptions[index] = true;
            alert("At least one adjective tense must be selected.");
        }
    }

    function validateAdjectivePolarity(index, newOptions)
    {
        newOptions[index] = !newOptions[index];
        
        if(newOptions[6] === false && newOptions[7] === false)
        {
            newOptions[index] = true;
            alert("At least one adjective polarity must be selected.");
        }
    }

    function validateKanaType(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[0] === false && newOptions[1] === false)
        {
            newOptions[index] = true;
            alert("At least one kana type must be selected.");
        }
    }

    function validatekanaChars(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[2] === false && newOptions[3] === false)
        {
            newOptions[index] = true;
            alert("At least one kana character set must be selected.");
        }
    
    }


    function adjectiveValidation(index, newOptions)
    {
        if(index < 2)
        {
            validateAdjectiveType(index, newOptions);
        }
        else if(index < 4)
        {
            validateAdjectiveFormality(index, newOptions);
        }
        else if(index < 6)
        {
            validateAdjectiveTense(index, newOptions);
        }
        else
        {
            validateAdjectivePolarity(index, newOptions);
        }
    }

    function kanaValidation(index, newOptions)
    {
        if(index < 2)
        {
            validateKanaType(index, newOptions);
        }
        else
        {
            validatekanaChars(index, newOptions);
        }
    }


    //Change the options based on the index of the option that was changed and the new value
    function changeOptions(index)
    {
        var newOptions = [...options];

        if(props.set == "verb")
        {
            verbValidation(index, newOptions);
        }
        else if(props.set == "adjective")
        {
            adjectiveValidation(index, newOptions);
        }
        else if(props.set == "kana")
        {
            kanaValidation(index, newOptions);
        }

        setOptions(newOptions);

    }


    return(
        
        <div className="options">
            <div  className = "optionsTopSection">
                <button className = "closeOptionsButton" onClick = {() => props.submit(options)}><img className = "closeOptionsButton" src = "/closeButton.svg" alt = "X" /></button>
                <div className = "optionsTitle">Options</div>
            </div>
            {props.set == "verb" &&
            <div className = "optionsSection">
                <div className = "optionsColumn">
                    <div className = "ruVerbs">
                        <input type="checkbox" id="ruVerbs" name="ruVerbs" checked={options[0]} onChange={() => {changeOptions(0)}}/>
                        <label for="ruVerbs">Include Ru Verbs</label>
                    </div>
                    <div className = "uVerbs">
                        <input type="checkbox" id="uVerbs" name="uVerbs" checked={options[1]} onChange={() => {changeOptions(1)}}/>
                        <label for="uVerbs">Include U Verbs</label>
                    </div>
                    <div className = "irregularVerbs">
                        <input type="checkbox" id="irregularVerbs" name="irregularVerbs" checked={options[2]} onChange={() => {changeOptions(2)}}/>
                        <label for="irregularVerbs">Include Irregular Verbs</label>
                    </div>
                    <br />
                    <div className = "casualForm">
                        <input type="checkbox" id="casualForm" name="casualForm" checked={options[3]} onChange={() => {changeOptions(3)}}/>
                        <label for="casualForm">Include Casual Form</label>
                    </div>
                    <div className = "formalForm">
                        <input type="checkbox" id="formalForm" name="formalForm" checked={options[4]} onChange={() => {changeOptions(4)}}/>
                        <label for="formalForm">Include Formal Form</label>
                    </div>
                </div>
                <div className = "optionsColumn">
                    <div className = "presentTense">
                        <input type="checkbox" id="presentTense" name="presentTense" checked={options[5]} onChange={() => {changeOptions(5)}}/>
                        <label for="presentTense">Include Present Tense</label>
                    </div>
                    <div className = "pastTense">
                        <input type="checkbox" id="pastTense" name="pastTense" checked={options[6]} onChange={() => {changeOptions(6)}}/>
                        <label for="pastTense">Include Past Tense</label>
                    </div>
                    <br />
                    <div className = "affirmativeForm">
                        <input type="checkbox" id="affirmativeForm" name="affirmativeForm" checked={options[7]} onChange={() => {changeOptions(7)}}/>
                        <label for="affirmativeForm">Include Affirmative Form</label>
                    </div>
                    <div className = "negativeForm">
                        <input type="checkbox" id="negativeForm" name="negativeForm" checked={options[8]} onChange={() => {changeOptions(8)}}/>
                        <label for="negativeForm">Include Negative Form</label>
                    </div>
                </div>
                <div className = "optionsColumn">
                    <div className = "regularForm">
                        <input type="checkbox" id="regularForm" name="regularForm" checked={options[9]} onChange={() => {changeOptions(9)}}/>
                        <label for="regularForm">Include Regular Form</label>
                    </div>
                    <div className = "potentialForm">
                        <input type="checkbox" id="potentialForm" name="potentialForm" checked={options[10]} onChange={() => {changeOptions(10)}}/>
                        <label for="potentialForm">Include Potential Form</label>
                    </div>
                    <div className = "passiveForm">
                        <input type="checkbox" id="passiveForm" name="passiveForm" checked={options[11]} onChange={() => {changeOptions(11)}}/>
                        <label for="passiveForm">Include Passive Form</label>
                    </div>
                    <div className = "causativeForm">
                        <input type="checkbox" id="causativeForm" name="causativeForm" checked={options[12]} onChange={() => {changeOptions(12)}}/>
                        <label for="causativeForm">Include Causative Form</label>
                    </div>
                    <div className = "volitionalForm">
                        <input type="checkbox" id="volitionalForm" name="volitionalForm" checked={options[13]} onChange={() => {changeOptions(13)}}/>
                        <label for="volitionalForm">Include Volitional Form</label>
                    </div>
                </div>
            </div>
            }
            {props.set == "adjective" &&
            <div className = "optionsSection">
                <div className = "optionsColumn">
                    <div className = "iAdjectives">
                        <input type="checkbox" id="iAdjectives" name="iAdjectives" checked={options[0]} onChange={() => {changeOptions(0)}}/>
                        <label for="iAdjectives">Include I Adjectives</label>
                    </div>
                    <div className = "naAdjectives">
                        <input type="checkbox" id="naAdjectives" name="naAdjectives" checked={options[1]} onChange={() => {changeOptions(1)}}/>
                        <label for="naAdjectives">Include Na Adjectives</label>
                    </div>
                    <br />
                    <div className = "casualForm">
                        <input type="checkbox" id="casualForm" name="casualForm" checked={options[2]} onChange={() => {changeOptions(2)}}/>
                        <label for="casualForm">Include Casual Form</label>
                    </div>
                    <div className = "formalForm">
                        <input type="checkbox" id="formalForm" name="formalForm" checked={options[3]} onChange={() => {changeOptions(3)}}/>
                        <label for="formalForm">Include Formal Form</label>
                    </div>
                </div>
                <div className = "optionsColumn">
                    <div className = "presentTense">
                        <input type="checkbox" id="presentTense" name="presentTense" checked={options[4]} onChange={() => {changeOptions(4)}}/>
                        <label for="presentTense">Include Present Tense</label>
                    </div>
                    <div className = "pastTense">
                        <input type="checkbox" id="pastTense" name="pastTense" checked={options[5]} onChange={() => {changeOptions(5)}}/>
                        <label for="pastTense">Include Past Tense</label>
                    </div>
                    <br />
                    <div className = "affirmativeForm">
                        <input type="checkbox" id="affirmativeForm" name="affirmativeForm" checked={options[6]} onChange={() => {changeOptions(6)}}/>
                        <label for="affirmativeForm">Include Affirmative Form</label>
                    </div>
                    <div className = "negativeForm">
                        <input type="checkbox" id="negativeForm" name="negativeForm" checked={options[7]} onChange={() => {changeOptions(7)}}/>
                        <label for="negativeForm">Include Negative Form</label>
                    </div>
                </div>
            </div>
            } 
            {props.set == "kana" &&
                <div className = "optionsSection">
                    <div className = "optionsColumn">
                        <div className = "kanaToRomanji">
                            <input type="checkbox" id="kanaToRomanji" name="kanaToRomanji" checked={options[0]} onChange={() => {changeOptions(0)}}/>
                            <label for="kanaToRomanji">Include Kana to Romanji</label>
                        </div>
                        <div className = "romanjiToKana">
                            <input type="checkbox" id="romanjiToKana" name="romanjiToKana" checked={options[1]} onChange={() => {changeOptions(1)}}/>
                            <label for="romanjiToKana">Include Romanji to Kana</label>
                        </div>
                    </div>
                    <div className = "optionsColumn">
                        <div className = "dakutenhandakuten">
                            <input type="checkbox" id="dakutenhandakuten" name="dakutenhandakuten" checked={options[2]} onChange={() => {changeOptions(2)}}/>
                            <label for="dakutenhandakuten">Include Dakuten and Handakuten</label>
                        </div>
                        <div className = "extended">
                            <input type="checkbox" id="extended" name="extended" checked={options[3]} onChange={() => {changeOptions(3)}}/>
                            <label for="extended">Include Extended Kana</label>
                        </div>
                    </div>
                </div>
            }  
        </div>
    );
}

export default Options;