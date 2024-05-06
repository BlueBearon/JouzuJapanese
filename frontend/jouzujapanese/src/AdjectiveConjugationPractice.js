/**
 * @fileoverview This file provides the AdjectiveConjugationPractice component. This component is responsible for rendering the adjective conjugation practice page.
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */

import * as React from 'react';
import "./css/Practice.css";
import TopElements from "./TopElements.js";
import ConjugationQuestion from "./ConjugationQuestion";
import CorrectAnswer from "./CorrectAnswer";
import WrongAnswer from "./WrongAnswer";
import Options from "./Options";
import axios from 'axios';
import { darkContext } from './App';
import '@fontsource/klee-one';
import Box from '@mui/material/Box';


let apiLink = "https://jouzujapanesebackend-768f8f815a31.herokuapp.com/api/adjectiveConjugation";//Link to backend
let apiBackupLink = "http://localhost:8080/api/adjectiveConjugation";

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
    const [screen, setScreen] = React.useState(0);
    //Manages the question being displayed [0]: Answer, [1]: Hiragana, [2]: Conjugation Parameters
    const [question, setQuestion] = React.useState([]);
    //Manages whether the options modal is on screen or not, false: not on screen, true: on screen
    const [showOptions, setShowOptions] = React.useState(false);
    //The user's response to the question
    const userResponse = React.useRef("");
    //The number of questions answered
    const questionCount = React.useRef(0);
    //The number of questions answered correctly
    const correct = React.useRef(0);
    //The options for adjective conjugation
    const options = React.useRef(
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
    const [loading, setLoading] = React.useState(true);

    //Context********************************************************************************/
    const darkMode = React.useContext(darkContext).darkMode;//Get the darkMode variable from the darkContext


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
    React.useEffect(() => {
        retrieveQuestion(options.current).then(result => 
            {
                setQuestion(result);
                setLoading(false);
            });
    }, []);



    if(loading)//Loading Screen, if we are waiting for a question to be retrieved
    {
        return(
            <Box 

                sx = {{
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                    width: '98%',
                    height: '90vh',
                    backgroundColor: darkMode ? '#131F24' : '#f0f0f0',
                    padding: "2vh 1vw",
                    border: '2px solid blue'
                }}    
            >
                <div className = "loading"><img src = "/loading.svg" className = "loadingsvg" alt = "Loading..."></img></div>
            </Box>
        );
    }

    if(screen === 0)//Question Screen
    {
        return (//TopElements component, ConjugationQuestion component, and Options modal
        <Box
        sx = {{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'center',
            width: '100%',
            height: '91.75vh',
            backgroundColor: darkMode ? '#131F24' : '#f0f0f0',
        }}
        > 
        <Box 

        sx = {{
            display: 'flex',
            flexDirection: 'column',
            justifyContent: 'center',
            alignItems: 'center',
            width: '60%',
            height: '60vh',
            padding: "1vw",
        }}    
        >
            <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
            <ConjugationQuestion params = {question[2]} word = {question[1]}  checkAnswer={checkAnswer}/>
            {showOptions && <Options options = {options.current} submit = {changeOptions} set = {"verb"}/>}
        </Box>
    </Box>
        );
    }
    else if(screen === 1)//Correct Answer Screen
    {
        console.log("ConjugationPractice.js: Rendering Correct Answer");
        return(//TopElements component, CorrectAnswer component, and Options modal
        <Box
        sx = {{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'center',
            width: '100%',
            height: '91.75vh',
            backgroundColor: darkMode ? '#131F24' : '#f0f0f0',
        }}
        > 
            <Box 

            sx = {{
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'center',
                alignItems: 'center',
                width: '60%',
                height: '60vh',
                padding: "1vw",
            }}    
            >
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <CorrectAnswer question = {question[2]} correctAnswer ={question[0]} next = {() => newQuestion()}/>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = {"verb"}/>}
            </Box>
        </Box>
        );
    }
    else//Wrong Answer Screen
    {
        console.log("ConjugationPractice.js: Rendering Wrong Answer");
        return(//TopElements component, WrongAnswer component, and Options modal
        <Box
        sx = {{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'center',
            width: '100%',
            height: '91.75vh',
            backgroundColor: darkMode ? '#131F24' : '#f0f0f0',
        }}
    > 
            <Box 

            sx = {{
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'center',
                alignItems: 'center',
                width: '60%',
                height: '60vh',
                padding: "1vw",
            }}    
            >
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <WrongAnswer question = {question[2]} userAnswer = {userResponse.current} correctAnswer ={question[0]} next = {() => newQuestion()}/>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = {"verb"}/>}

            </Box>

        </Box>
        );
    }

    //************************************************************************************* */

}

export default AdjectiveConjugationPractice;