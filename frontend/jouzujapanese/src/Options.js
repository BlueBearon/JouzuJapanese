/**
 * @fileoverview This file contains the Options component. This component displays the options for the practice sets.
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */

import * as React from 'react';
import './css/Options.css';
import { Typography } from '@mui/material';
import { darkContext } from './App';
import Box from '@mui/material/Box';
import { TextField } from '@mui/material';
import RightArrow from '@mui/icons-material/ArrowForward';
import Close from '@mui/icons-material/Close';
import Check from '@mui/icons-material/Check';
import '@fontsource/klee-one';
import Button from '@mui/material/Button';
import Checkbox from '@mui/material/Checkbox';
import FormControlLabel from '@mui/material/FormControlLabel';

/**
 * This function renders the Options component, which displays the options for the practice sets. It also handles the logic for the options.
 * @param {*} props: options: the current options, submit: the function called when the user presses the submit button, set: the set of options to display
 * @returns The Options component
 */
function Options(props)
{

    //Hook to store the current options
    const [options, setOptions] = React.useState(props.options);

    //Set options to the current options passed in from the parent component
    React.useEffect(() => {

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

    /**
     * Validate the verb tense options.
     * At least one verb tense must be selected.
     * If the user tries to deselect all verb tenses, the one they tried to deselect will be reselected.
     * @param {*} index 
     * @param {*} newOptions 
     */
    function validateVerbTense(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[5] === false && newOptions[6] === false)
        {
            newOptions[index] = true;
            alert("At least one verb tense must be selected.");
        }
    }

    /**
     * Validate the verb polarity options.
     * At least one verb polarity must be selected.
     * If the user tries to deselect all verb polarities, the one they tried to deselect will be reselected.
     * @param {*} index 
     * @param {*} newOptions 
     */
    function validateVerbPolarity(index, newOptions)
    {
        newOptions[index] = !newOptions[index];
        
        if(newOptions[7] === false && newOptions[8] === false)
        {
            newOptions[index] = true;
            alert("At least one verb polarity must be selected.");
        }
    }

    /**
     * Validate the verb form options.
     * At least one verb form must be selected.
     * If the user tries to deselect all verb forms, the one they tried to deselect will be reselected.
     * @param {*} index 
     * @param {*} newOptions
     */
    function validateVerbForm(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[9] === false && newOptions[10] === false && newOptions[11] === false && newOptions[12] === false && newOptions[13] === false)
        {
            newOptions[index] = true;
            alert("At least one verb form must be selected.");
        }
    }

    /**
     * Validate the verb options. Depending on the index of the option that was changed, call the appropriate validation function.
     * @param {*} index 
     * @param {*} newOptions 
     */
    function verbValidation(index, newOptions)
    {
        if(index < 3)//Ru, U, or Irregular
        {
            validateVerbType(index, newOptions);
        }
        else if(index < 5)//Casual or Formal
        {
            validateVerbFormality(index, newOptions);
        }
        else if(index < 7)//Present or Past
        {
            validateVerbTense(index, newOptions);
        }
        else if(index < 9)//Affirmative or Negative
        {
            validateVerbPolarity(index, newOptions);
        }
        else//Regular, Potential, Passive, Causative, or Volitional
        {
            validateVerbForm(index, newOptions);
        }
    }

    /**
     * Validate the adjective type options.
     * At least one adjective type must be selected.
     * If the user tries to deselect all adjective types, the one they tried to deselect will be reselected.
     * @param {*} index 
     * @param {*} newOptions 
     */
    function validateAdjectiveType(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[0] === false && newOptions[1] === false)
        {
            newOptions[index] = true;
            alert("At least one adjective type must be selected.");
        }
    }

    /**
     * Validate the adjective formality options.
     * At least one adjective formality must be selected.
     * If the user tries to deselect all adjective formalities, the one they tried to deselect will be reselected.
     * @param {*} index 
     * @param {*} newOptions 
     */
    function validateAdjectiveFormality(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[2] === false && newOptions[3] === false)
        {
            newOptions[index] = true;
            alert("At least one adjective formality must be selected.");
        }
    }

    /**
     * Validate the adjective tense options.
     * At least one adjective tense must be selected.
     * If the user tries to deselect all adjective tenses, the one they tried to deselect will be reselected.
     * @param {*} index 
     * @param {*} newOptions 
     */
    function validateAdjectiveTense(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[4] === false && newOptions[5] === false)
        {
            newOptions[index] = true;
            alert("At least one adjective tense must be selected.");
        }
    }

    /**
     * Validate the adjective polarity options.
     * At least one adjective polarity must be selected.
     * If the user tries to deselect all adjective polarities, the one they tried to deselect will be reselected.
     * @param {*} index 
     * @param {*} newOptions 
     */
    function validateAdjectivePolarity(index, newOptions)
    {
        newOptions[index] = !newOptions[index];
        
        if(newOptions[6] === false && newOptions[7] === false)
        {
            newOptions[index] = true;
            alert("At least one adjective polarity must be selected.");
        }
    }

    /**
     * Validate the kana type options.
     * At least one kana type must be selected.
     * If the user tries to deselect all kana types, the one they tried to deselect will be reselected.
     * @param {*} index 
     * @param {*} newOptions 
     */
    function validateKanaType(index, newOptions)
    {
        newOptions[index] = !newOptions[index];

        if(newOptions[0] === false && newOptions[1] === false)
        {
            newOptions[index] = true;
            alert("At least one kana type must be selected.");
        }
    }

    /**
     * Validate the kana character options.
     * No validation is needed for this option.
     * @param {*} index 
     * @param {*} newOptions 
     */
    function validatekanaChars(index, newOptions)
    {
        newOptions[index] = !newOptions[index];
    }

    /**
     * Validate the adjective options. Depending on the index of the option that was changed, call the appropriate validation function.
     * @param {*} index 
     * @param {*} newOptions 
     */
    function adjectiveValidation(index, newOptions)
    {
        if(index < 2)//I or Na
        {
            validateAdjectiveType(index, newOptions);
        }
        else if(index < 4)//Casual or Formal
        {
            validateAdjectiveFormality(index, newOptions);
        }
        else if(index < 6)//Present or Past
        {
            validateAdjectiveTense(index, newOptions);
        }
        else//Affirmative or Negative
        {
            validateAdjectivePolarity(index, newOptions);
        }
    }

    /**
     * Validate the kana options. Depending on the index of the option that was changed, call the appropriate validation function.
     * @param {*} index 
     * @param {*} newOptions 
     */
    function kanaValidation(index, newOptions)
    {
        if(index < 2)//Kana to Romanji or Romanji to Kana
        {
            validateKanaType(index, newOptions);
        }
        else//Dakuten and Handakuten or Extended
        {
            validatekanaChars(index, newOptions);
        }
    }


    /**
     * Change the options based on the index of the option that was changed and the set of options.
     * @param {*} index 
     */
    function changeOptions(index)
    {
        var newOptions = [...options];//Copy the current options

        if(props.set == "verb")//If the set is verb, call the verb validation function
        {
            verbValidation(index, newOptions);
        }
        else if(props.set == "adjective")//If the set is adjective, call the adjective validation function
        {
            adjectiveValidation(index, newOptions);
        }
        else if(props.set == "kana")//If the set is kana, call the kana validation function
        {
            kanaValidation(index, newOptions);
        }

        setOptions(newOptions);//Set the options to the new options

    }


    return(
        
        <div className="options">
            <div  className = "optionsTopSection">
                <button className = "closeOptionsButton" onClick = {() => props.submit(options)}><img className = "closeOptionsButton" src = "/closeButton.svg" alt = "X" /></button>
                {/*The close button is displayed at the top left of the screen. Uses parent submit function to give options to parent*/}
                <div className = "optionsTitle">Options</div>
            </div>
            {props.set == "verb" && 
            <div className = "optionsSection">
                <div className = "optionsColumn">
                    <div className = "option">
                        <input type="checkbox" id="ruVerbs" name="ruVerbs" checked={options[0]} onChange={() => {changeOptions(0)}}/>
                        <label for="ruVerbs">Include Ru Verbs</label>
                    </div>
                    <div className = "option">
                        <input type="checkbox" id="uVerbs" name="uVerbs" checked={options[1]} onChange={() => {changeOptions(1)}}/>
                        <label for="uVerbs">Include U Verbs</label>
                    </div>
                    <div className = "option">
                        <input type="checkbox" id="irregularVerbs" name="irregularVerbs" checked={options[2]} onChange={() => {changeOptions(2)}}/>
                        <label for="irregularVerbs">Include Irregular Verbs</label>
                    </div>
                    <br />
                    <div className = "option">
                        <input type="checkbox" id="casualForm" name="casualForm" checked={options[3]} onChange={() => {changeOptions(3)}}/>
                        <label for="casualForm">Include Casual Form</label>
                    </div>
                    <div className = "option">
                        <input type="checkbox" id="formalForm" name="formalForm" checked={options[4]} onChange={() => {changeOptions(4)}}/>
                        <label for="formalForm">Include Formal Form</label>
                    </div>
                </div>
                <div className = "optionsColumn">
                    <div className = "option">
                        <input type="checkbox" id="presentTense" name="presentTense" checked={options[5]} onChange={() => {changeOptions(5)}}/>
                        <label for="presentTense">Include Present Tense</label>
                    </div>
                    <div className = "option">
                        <input type="checkbox" id="pastTense" name="pastTense" checked={options[6]} onChange={() => {changeOptions(6)}}/>
                        <label for="pastTense">Include Past Tense</label>
                    </div>
                    <br />
                    <div className = "option">
                        <input type="checkbox" id="affirmativeForm" name="affirmativeForm" checked={options[7]} onChange={() => {changeOptions(7)}}/>
                        <label for="affirmativeForm">Include Affirmative Form</label>
                    </div>
                    <div className = "option">
                        <input type="checkbox" id="negativeForm" name="negativeForm" checked={options[8]} onChange={() => {changeOptions(8)}}/>
                        <label for="negativeForm">Include Negative Form</label>
                    </div>
                </div>
                <div className = "optionsColumn">
                    <div className = "option">
                        <input type="checkbox" id="regularForm" name="regularForm" checked={options[9]} onChange={() => {changeOptions(9)}}/>
                        <label for="regularForm">Include Regular Form</label>
                    </div>
                    <div className = "option">
                        <input type="checkbox" id="potentialForm" name="potentialForm" checked={options[10]} onChange={() => {changeOptions(10)}}/>
                        <label for="potentialForm">Include Potential Form</label>
                    </div>
                    <div className = "option">
                        <input type="checkbox" id="passiveForm" name="passiveForm" checked={options[11]} onChange={() => {changeOptions(11)}}/>
                        <label for="passiveForm">Include Passive Form</label>
                    </div>
                    <div className = "option">
                        <input type="checkbox" id="causativeForm" name="causativeForm" checked={options[12]} onChange={() => {changeOptions(12)}}/>
                        <label for="causativeForm">Include Causative Form</label>
                    </div>
                    <div className = "option">
                        <input type="checkbox" id="volitionalForm" name="volitionalForm" checked={options[13]} onChange={() => {changeOptions(13)}}/>
                        <label for="volitionalForm">Include Volitional Form</label>
                    </div>
                </div>
            </div>
            }
            {props.set == "adjective" &&
            <div className = "optionsSection">
                <div className = "optionsColumn">
                    <div className = "option">
                        <input type="checkbox" id="iAdjectives" name="iAdjectives" checked={options[0]} onChange={() => {changeOptions(0)}}/>
                        <label for="iAdjectives">Include I Adjectives</label>
                    </div>
                    <div className = "option">
                        <input type="checkbox" id="naAdjectives" name="naAdjectives" checked={options[1]} onChange={() => {changeOptions(1)}}/>
                        <label for="naAdjectives">Include Na Adjectives</label>
                    </div>
                    <br />
                    <div className = "option">
                        <input type="checkbox" id="casualForm" name="casualForm" checked={options[2]} onChange={() => {changeOptions(2)}}/>
                        <label for="casualForm">Include Casual Form</label>
                    </div>
                    <div className = "option">
                        <input type="checkbox" id="formalForm" name="formalForm" checked={options[3]} onChange={() => {changeOptions(3)}}/>
                        <label for="formalForm">Include Formal Form</label>
                    </div>
                </div>
                <div className = "optionsColumn">
                    <div className = "option">
                        <input type="checkbox" id="presentTense" name="presentTense" checked={options[4]} onChange={() => {changeOptions(4)}}/>
                        <label for="presentTense">Include Present Tense</label>
                    </div>
                    <div className = "option">
                        <input type="checkbox" id="pastTense" name="pastTense" checked={options[5]} onChange={() => {changeOptions(5)}}/>
                        <label for="pastTense">Include Past Tense</label>
                    </div>
                    <br />
                    <div className = "option">
                        <input type="checkbox" id="affirmativeForm" name="affirmativeForm" checked={options[6]} onChange={() => {changeOptions(6)}}/>
                        <label for="affirmativeForm">Include Affirmative Form</label>
                    </div>
                    <div className = "option">
                        <input type="checkbox" id="negativeForm" name="negativeForm" checked={options[7]} onChange={() => {changeOptions(7)}}/>
                        <label for="negativeForm">Include Negative Form</label>
                    </div>
                </div>
            </div>
            } 
            {props.set == "kana" &&
                <div className = "optionsSection">
                    <div className = "optionsColumn">
                        <div className = "option">
                            <input type="checkbox" id="kanaToRomanji" name="kanaToRomanji" checked={options[0]} onChange={() => {changeOptions(0)}}/>
                            <label for="kanaToRomanji">Include Kana to Romanji</label>
                        </div>
                        <div className = "option">
                            <input type="checkbox" id="romanjiToKana" name="romanjiToKana" checked={options[1]} onChange={() => {changeOptions(1)}}/>
                            <label for="romanjiToKana">Include Romanji to Kana</label>
                        </div>
                    </div>
                    <div className = "optionsColumn">
                        <div className = "option">
                            <input type="checkbox" id="dakutenhandakuten" name="dakutenhandakuten" checked={options[2]} onChange={() => {changeOptions(2)}}/>
                            <label for="dakutenhandakuten">Include Dakuten and Handakuten</label>
                        </div>
                        <div className = "option">
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