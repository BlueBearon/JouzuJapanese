/**
 * @fileoverview This file contains the HiraganaPractice component, which is the main component for the Hiragana Practice page, responsible for rendering the question, correct answer, and wrong answer screens.
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */

import React, {useState, useRef, useEffect} from "react";
import "./css/Practice.css";
import TopElements from "./TopElements";
import CorrectAnswer from "./CorrectAnswer";
import WrongAnswer from "./WrongAnswer";
import KanaQuestion from "./KanaQuestion";
import Options from "./Options";
import axios from 'axios';

let apiLink = "https://jouzujapanesebackend-768f8f815a31.herokuapp.com/api/hiragana";//Link to backend
let apiBackupLink = "http://localhost:8080/api/hiragana";

/**
 * Retrieves a hiragana question if backend is non-responsive
 * @param {*} options options[0]: includeHiraganaToRomanji, options[1]: incluceRomanjiToHiragana, options[2]: dakutenhandakuten, options[3]: extended
 * @returns A hiragana question, in the form [question, answer, type]
 */
function OLDretrieveHiraganaQuestion(options)
{
    console.log("Retrieving Hiragana Question");

    //random number 0 or 1
    var random = Math.floor(Math.random() * 2);

    var possibleQuestions;

    //If the user wants to practice hiragana to romanji, and either romanji to hiragana is not selected or random is 0
    if (options[0] && (!options[1] || random === 0))
    {
        //return ["た", "ta", "KANA"];
        possibleQuestions = [
            ["た", "ta", "KANA"],
            ["い", "i", "KANA"],
            ["か", "ka", "KANA"],
            ["ぬ", "nu", "KANA"],
            ["せ", "se", "KANA"],
            ["ろ", "ro", "KANA"],
            ["み", "mi", "KANA"],
            ["ね", "ne", "KANA"],
            ["ゆ", "yu", "KANA"],
            ["を", "wo", "KANA"],
            ["が", "ga", "KANA"],
            ["ぢ", "ji", "KANA"],
            ["ぶ", "bu", "KANA"],
            ["ぽ", "po", "KANA"]
        ];

        return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];//returns a random question, from the list of possible questions
    }
    else//If the user wants to practice romanji to hiragana, and either hiragana to romanji is not selected or random is 1
    {
        //return ["ta", "た", "ROMANJI"];
        possibleQuestions = [
            ["ta", "た", "ROMANJI"],
            ["i", "い", "ROMANJI"],
            ["ka", "か", "ROMANJI"],
            ["nu", "ぬ", "ROMANJI"],
            ["se", "せ", "ROMANJI"],
            ["ro", "ろ", "ROMANJI"],
            ["mi", "み", "ROMANJI"],
            ["ne", "ね", "ROMANJI"],
            ["yu", "ゆ", "ROMANJI"],
            ["wo", "を", "ROMANJI"],
            ["ga", "が", "ROMANJI"],
            ["ji", "ぢ", "ROMANJI"],
            ["bu", "ぶ", "ROMANJI"],
            ["po", "ぽ", "ROMANJI"]
        ];

        return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];
    }
}

/**
 * Retrieves a hiragana question from the backend, if the backend is responsive
 * @param {*} options 
 * @returns A hiragana question, in the form [question, answer, type]
 */
const retrieveQuestion = (options) =>
{
    console.log("HiraganaPractice.js: Retrieving Hiragana Question");

    //Options object for axios
    var optionsObject = {
        params: {
            "kanaToRomanji": options[0], 
            "romanjiToKana": options[1],
            "dakutenhandakuten": options[2],
            "extended": options[3]
        }
    };

    return axios.get(apiLink, optionsObject)
        .then(response => {//If the backend is responsive
            console.log(response);

            let result = [response.data.question, response.data.answer, response.data.type];//Set result to the question, answer, and type from the response
            return result;
        }
        ).catch(error => {//If backend fails with options, try again with no options
            console.log(error);
            
            return axios.get(apiBackupLink).then(response => {
                console.log(response);

                let result = [response.data.question, response.data.answer, response.data.type];
                return result;
            }
            ).catch(error => {// If backend fails with no options, return a random question
                console.log(error);
                console.log("HiraganaPractice.js: Retrieving Hiragana Question Failed");
                return OLDretrieveHiraganaQuestion(options);
            });
        });

}

/**
 * The HiraganaPractice component is the main component for the Hiragana Practice page, responsible for rendering the question, correct answer, and wrong answer screens.
 * Contains the question, correct answer, and wrong answer screens.
 * @param {*} props 
 * @returns 
 */
function HiraganaPractice(props)
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
    //The options for Hiragana
    const options = useRef(
    [
        true, //includeHiragana
        true, //includeRomaji
        true, //dakutenhandakuten
        true  //extended
    ]
    );

    //Manages whether the loading screen is on screen or not, false: not on screen, true: on screen
    const [loading, setLoading] = useState(true);

    /************************************************************************************************/

    //Helper Functions*******************************************************************************/

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

        if(userResponse.current === question[1])
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

    /************************************************************************************************/

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
        return( //TopElements, Loading, Options
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>{/*Passes the openOptions function to the TopElements component*/}
                <div className = "loading"><img src = "/loading.svg" className = "loadingsvg" alt = "Loading..."></img></div>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = {"kana"}/>}{/*Passes the options and submit function to the Options component*/}
            </div>
        );
    }

    if(screen === 0)//Question Screen
    {
        return ( //TopElements, KanaQuestion, Options
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <KanaQuestion word = {question[0]} type = {question[2]} kana = "hiragana" checkAnswer={checkAnswer}/>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = "kana"/>}
            </div>

        );
    }
    else if(screen === 1)//Correct Answer Screen
    {
        return(//TopElements, CorrectAnswer, Options
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <CorrectAnswer question = {question[0]} correctAnswer ={question[1]} next = {newQuestion}/>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = "kana"/>}
            </div>
        );
    }
    else//Wrong Answer Screen
    {
        return( //TopElements, WrongAnswer, Options
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <WrongAnswer question = {question[0]} userAnswer = {userResponse.current} correctAnswer ={question[1]} next = {newQuestion}/>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = "kana"/>}
            </div>
        );
    }



}

export default HiraganaPractice;