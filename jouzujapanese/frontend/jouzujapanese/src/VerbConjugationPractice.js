/**
 * @fileoverview This file contains the VerbConjugationPractice component. This component contains the top elements, the question, and the options modal.
 * 
 * The VerbConjugationPractice component is the main component for the verb conjugation practice section of the website. It contains the top elements, the question, and the options modal.
 * 
 * Author: Chase Packer
 * 
 * Date: 1/17/2024
 */

import React, {useState, useEffect, useRef} from "react";
import "./Practice.css";
import TopElements from "./TopElements.js";
import ConjugationQuestion from "./ConjugationQuestion";
import CorrectAnswer from "./CorrectAnswer";
import WrongAnswer from "./WrongAnswer";
import Options from "./Options";
import axios from 'axios';

//The link to the backend
let apiLink = "http://localhost:8080/api/verbConjugation";
let apiBackupLink = "http://localhost:8080/api/verbConjugation/optionsFailed";

/**
 * Back up function for retrieving a verb conjugation question.
 * @param {*} options 
 * @returns 
 */
function OLDretrieveVerbQuestion(options)
{

    var possibleQuestions = [
        ["たべられます", "たべる", "Potential Formal Positive Present"],
        ["のまれました", "のむ", "Passive Formal Positive Past"],
        ["よませます", "よむ", "Causative Formal Positive Present"],
        ["はなされません", "はなす", "Passive Formal Negative Present"],
        ["およげます", "およぐ", "Potential Formal Positive Present"],
        ["しらなかった", "しる", "Casual Negative Past"],
        ["おける", "おく", "Potential Casual Positive Present"],
        ["かえられる", "かえる", "Potential Casual Positive Present"],
        ["かかせます", "かく", "Causative Formal Positive Present"]
    ];

    return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];
}

/**
 * Retrieves a verb conjugation question from the backend.
 * @param {*} options: The options for verb conjugation
 * @returns [answer, hiragana, conjugation]: The answer to the question, the hiragana of the question, and the conjugation parameters of the question
 */
const retrieveQuestion = (options) => 
{
    console.log("ConjugationPractice.js: Retrieving Verb Question");

    //options object for axios call
    var optionsObject = {
        params: {
            "includeRuVerbs": options[0], 
            "includeUVerbs": options[1], 
            "includeIrregularVerbs": options[2], 
            "includeCasualForm": options[3], 
            "includeFormalForm": options[4], 
            "includePresentTense": options[5], 
            "includePastTense": options[6], 
            "includeAffirmativeForm": options[7], 
            "includeNegativeForm": options[8], 
            "includeRegularForm": options[9], 
            "includePotentialForm": options[10], 
            "includePassiveForm": options[11], 
            "includeCausativeForm": options[12], 
            "includeVoliationalForm": options[13], 
            "includeTeForm": options[14]
        }
    };


    return axios.get(apiLink, optionsObject)
        .then(response => {//If the call to the backend is successful, return the answer, hiragana, and conjugation parameters
            console.log(response);

            let result = [response.data.answer, response.data.hiragana, response.data.conjugation];//The answer, hiragana, and conjugation parameters are stored in the response.data object
            return result;
        }
        ).catch(error => {
            console.log(error);
            
            return axios.get(apiBackupLink).then(response => {//If the call fails with options, try again with the default options
                console.log(response);

                let result = [response.data.answer, response.data.hiragana, response.data.conjugation];
                return result;
            }
            ).catch(error => {//If the call fails with default options, try again with the OLDretrieveVerbQuestion function
                console.log(error);
                return OLDretrieveVerbQuestion(options);
            });
        });

}

/**
 * This function renders the VerbConjugationPractice component, which contains the top elements, the question, and the options modal
 * @returns The VerbConjugationPractice component
 */
function VerbConjugationPractice()
{

    //Hooks********************************************************************************/
    
    //Manages which screen is displayed 0: Question, 1: Correct Answer, 2: Wrong Answer
    const [screen, setScreen] = useState(0);
    //Manages the question being displayed [0]: Answer, [1]: Hiragana, [2]: Conjugation Parameters
    const [question, setQuestion] = useState([]);
    //Manages whether the options modal is on screen or not, false: not on screen, true: on screen
    const [showOptions, setShowOptions] = useState(false);
    //The user's response to the question
    const userResponse = useRef("");
    //The number of questions answered
    const questionCount = useRef(0);
    //The number of questions answered correctly
    const correct = useRef(0);
    //The options for verb conjugation
    const options = useRef(
    [
        true, //includeRuVerbs
        true, //includeUVerbs
        true, //includeIrregularVerbs
        true, //includeCasualForm
        true, //includeFormalForm
        true, //includePresentTense
        true, //includePastTense
        true, //includeAffirmativeForm
        true, //includeNegativeForm
        true, //includeRegularForm
        true, //includePotentialForm
        true, //includePassiveForm
        true, //includeCausativeForm
        true, //includeVoliationalForm
        true //includeTeForm
    ]
    );

    //Manages whether the loading screen is on screen or not, false: not on screen, true: on screen
    const [loading, setLoading] = useState(true);

    /**************************************************************************************/
    //Helper Functions*********************************************************************/

    /**
     * Changes the options for verb conjugation
     * @param {*} options 
     */
    function changeOptions(newoptions)
    {
        options.current = [...newoptions];
        
        setShowOptions(false);

        newQuestion();
    }

    /**
     * Given a provided answer, checks if it is correct and updates the screen accordingly
     * This function will be passed to the ConjugationQuestion component
     * @param {*} answer 
     */
    function checkAnswer(answer)
    {
        userResponse.current = answer;
        questionCount.current++;

        if(userResponse.current === question[0])
        {
            correct.current++;
            setScreen(1);
        }
        else
        {
            setScreen(2);
        }
    }

    /**
     * Generates a new question and updates the screen accordingly.
     * This function will be passed to the CorrectAnswer and WrongAnswer components
     */
    function newQuestion()
    {

        setLoading(true);
        retrieveQuestion(options.current).then(result => 
            {
                setQuestion(result);
                setLoading(false);
                setScreen(0);
            }
        );
        
    }

    /******************************************************************************************/

    //Render Component******************************************************************

    //Initial question, Rendered once at the beginning
    useEffect(() => {
        retrieveQuestion(options.current).then(result => 
            {
                setQuestion(result);
                setLoading(false);
            });
    }, []);



    if(loading)
    {
        return(//Shows loading screen if the question has not been retrieved yet
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <div className = "loading"><img src = "/loading.svg" className = "loadingsvg" alt = "Loading..."></img></div>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = {"verb"}/>}
            </div>
        );
    }

    if(screen === 0)//Question Screen
    {
        return (//The question is displayed in the center of the screen, with the top elements
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <ConjugationQuestion params = {question[2]} word = {question[1]}  checkAnswer={checkAnswer}/>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = {"verb"}/>}
            </div>
        );
    }
    else if(screen === 1)//Correct Answer Screen
    {
        console.log("ConjugationPractice.js: Rendering Correct Answer");
        return(//The correct answer is displayed in the center of the screen, with the top elements, give information about the correct answer
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <CorrectAnswer question = {question[2]} correctAnswer ={question[0]} next = {() => newQuestion()}/>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = {"verb"}/>}
            </div>
        );
    }
    else//Wrong Answer Screen
    {
        console.log("ConjugationPractice.js: Rendering Wrong Answer");
        return(//Wrong answer screen is displayed if the user's answer was incorrect, Give information about the correct answer
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <WrongAnswer question = {question[2]} userAnswer = {userResponse.current} correctAnswer ={question[0]} next = {() => newQuestion()}/>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = {"verb"}/>}
            </div>
        );
    }

    //************************************************************************************* */

}

export default VerbConjugationPractice;