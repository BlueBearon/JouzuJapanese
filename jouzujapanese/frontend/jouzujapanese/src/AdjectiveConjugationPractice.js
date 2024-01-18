/**
 * @fileoverview This file provides the AdjectiveConjugationPractice component. This component is responsible for rendering the adjective conjugation practice page.
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */

import React, {useState, useEffect, useRef} from "react";
import "./css/Practice.css";
import TopElements from "./TopElements.js";
import ConjugationQuestion from "./ConjugationQuestion";
import CorrectAnswer from "./CorrectAnswer";
import WrongAnswer from "./WrongAnswer";
import Options from "./Options";
import axios from 'axios';

let apiLink = "http://localhost:8080/api/adjectiveConjugation";
let apiBackupLink = "http://localhost:8080/api/adjectiveConjugation/optionsFailed";

/**
 * Retrieves an adjective conjugation question if the backend is non-reponsive using
 * a backup list of questions.
 * @param {*} options 
 * @returns 
 */
function OLDretrieveAdjectiveQuestion(options)
{
    //Will be replaced by call to backend

    //return ["たかいです", "たかい", "Formal Positive Present"];

    var possibleQuestions = [
        ["たかいです", "たかい", "Formal Positive Present"],
        ["ねむくなかったです", "ねむい", "Formal Negative Past"],
        ["あつくないです", "あつい", "Formal Negative Present"],
        ["やさしかったです", "やさしい", "Formal Positive Past"],
        ["たのしいです", "たのしい", "Formal Positive Present"],
        ["さびしかったです", "さびしい", "Formal Positive Past"],
        ["しずかでした", "しずか", "Formal Positive Past"],
        ["こわいです", "こわい", "Formal Positive Present"],
        ["あたたかくないです", "あたたかい", "Formal Negative Present"]
        
    ];

    return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];//returns a random question

}

/**
 * Retrieves an adjective conjugation question from the backend.
 * @param {*} options 
 * @returns [answer, hiragana, conjugation] Question for adjective conjugation
 */
function retrieveQuestion(options)
{
    console.log("ConjugationPractice.js: Retrieving Adjective Question");

    //Options object for axios call
    var optionsObject = {
        params: {
            "includeIAdjectives": options[0],
            "includeNaAdjectives": options[1],
            "includeCasualForm": options[2],
            "includeFormalForm": options[3],
            "includePresentTense": options[4],
            "includePastTense": options[5],
            "includeAffirmativeForm": options[6],
            "includeNegativeForm": options[7]
        }
    };

    return axios.get(apiLink, optionsObject)
        .then(response => {//If successful
            console.log(response);

            let result = [response.data.answer, response.data.hiragana, response.data.conjugation];//Set question to the api response
            return result;
        }
        ).catch(error => {
            console.log(error);
            
            return axios.get(apiBackupLink).then(response => {//If backend fails with options, try again with default options
                console.log(response);

                let result = [response.data.answer, response.data.hiragana, response.data.conjugation];
                return result;
            }
            ).catch(error => {//If backend fails with default options, try again with old function
                console.log(error);
                return OLDretrieveAdjectiveQuestion(options);
            });
        });
}


/**
 * This component is responsible for rendering the adjective conjugation practice page. 
 * Composed of the TopElements component, ConjugationQuestion component, CorrectAnswer component, WrongAnswer component, and Options modal.
 * @param {*} props 
 * @returns The adjective conjugation practice page
 */
function AdjectiveConjugationPractice(props)
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
    //The options for adjective conjugation
    const options = useRef(
        [
            true, //includeIAdjectives
            true, //includeNaAdjectives
            true, //includeCasualForm
            true, //includeFormalForm
            true, //includePresentTense
            true, //includePastTense
            true, //includeAffirmativeForm
            true //includeNegativeForm
        ]
    );
    
    //Manages whether the loading screen is on screen or not, false: not on screen, true: on screen
    const [loading, setLoading] = useState(true);

    /**************************************************************************************/
    //Helper Functions*********************************************************************/
    /**
     * Changes the options for adjective conjugation
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



    if(loading)//Loading Screen, if we are waiting for a question to be retrieved
    {
        return(
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <div className = "loading"><img src = "/loading.svg" className = "loadingsvg" alt = "Loading..."></img></div>
            </div>
        );
    }

    if(screen === 0)//Question Screen
    {
        return (//TopElements component, ConjugationQuestion component, and Options modal
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <ConjugationQuestion params = {question[2]} word = {question[1]}  checkAnswer={checkAnswer}/>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = {"adjective"}/>}
            </div>
        );
    }
    else if(screen === 1)//Correct Answer Screen
    {
        console.log("ConjugationPractice.js: Rendering Correct Answer");
        return(//TopElements component, CorrectAnswer component, and Options modal
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <CorrectAnswer question = {question[2]} correctAnswer ={question[0]} next = {() => newQuestion()}/>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = {"adjective"}/>}
            </div>
        );
    }
    else//Wrong Answer Screen
    {
        console.log("ConjugationPractice.js: Rendering Wrong Answer");
        return(//TopElements component, WrongAnswer component, and Options modal
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <WrongAnswer question = {question[2]} userAnswer = {userResponse.current} correctAnswer ={question[0]} next = {() => newQuestion()}/>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = {"adjective"}/>}
            </div>
        );
    }

    //************************************************************************************* */

}

export default AdjectiveConjugationPractice;