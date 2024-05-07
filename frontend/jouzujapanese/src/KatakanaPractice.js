/**
 * @file KatakanaPractice.js
 * This file contains the KatakanaPractice component
 * This component is the main component for the katakana practice page
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */



import * as React from 'react';
import "./css/Practice.css";
import TopElements from "./TopElements";
import CorrectAnswer from "./CorrectAnswer";
import WrongAnswer from "./WrongAnswer";
import KanaQuestion from "./KanaQuestion";
import Options from "./Options";
import axios from 'axios';
import { darkContext } from './App';
import '@fontsource/klee-one';
import Box from '@mui/material/Box';


//IMPORTANT: MAKE SURE THE BACKEND IS RUNNING BEFORE RUNNING THE FRONTEND
let apiLink = "https://jouzujapanesebackend-768f8f815a31.herokuapp.com/api/katakana";//Link to backend
let apiBackupLink = "http://localhost:8080/api/katakana";

/**
 * Retrieves a katakana question if backend is non-responsive
 * @param {*} options 
 * @returns 
 */
function OLDretrieveKatakanaQuestion(options)
{
    //Will be replaced by call to backend

    console.log("Retrieving Katakana Question");

    //random number 0 or 1
    var random = Math.floor(Math.random() * 2);

    var possibleQuestions;

    if (options[0] && (!options[1] || random === 0))
    {
        //return ["タ", "ta", "KANA"];
        possibleQuestions = [
            ["タ", "ta", "KANA"],
            ["イ", "i", "KANA"],
            ["カ", "ka", "KANA"],
            ["ヌ", "nu", "KANA"],
            ["セ", "se", "KANA"],
            ["ロ", "ro", "KANA"],
            ["ミ", "mi", "KANA"],
            ["ネ", "ne", "KANA"],
            ["ユ", "yu", "KANA"],
            ["ヲ", "wo", "KANA"],
            ["ガ", "ga", "KANA"],
            ["ヂ", "ji", "KANA"],
            ["ブ", "bu", "KANA"],
            ["ポ", "po", "KANA"]
        ];

        return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];
    }
    else
    {
        //return ["ta", "タ", "ROMANJI"];
        possibleQuestions = [
            ["ta", "タ", "ROMANJI"],
            ["i", "イ", "ROMANJI"],
            ["ka", "カ", "ROMANJI"],
            ["nu", "ヌ", "ROMANJI"],
            ["se", "セ", "ROMANJI"],
            ["ro", "ロ", "ROMANJI"],
            ["mi", "ミ", "ROMANJI"],
            ["ne", "ネ", "ROMANJI"],
            ["yu", "ユ", "ROMANJI"],
            ["wo", "ヲ", "ROMANJI"],
            ["ga", "ガ", "ROMANJI"],
            ["ji", "ヂ", "ROMANJI"],
            ["bu", "ブ", "ROMANJI"],
            ["po", "ポ", "ROMANJI"]
        ];

        return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];
    }
    

}


/**
 * Retrieves a katakana question from the backend
 * @param {*} options 
 * @returns 
 */
const retrieveQuestion = (options) =>
{
    console.log("KatakanaPractice.js: Retrieving Katakana Question");

    //Options to be sent to backend
    var optionsObject = {
        params: {
            "kanaToRomanji": options[0], 
            "romanjiToKana": options[1],
            "dakutenhandakuten": options[2],
            "extended": options[3]
        }
    };

    return axios.get(apiLink, optionsObject)
        .then(response => {//If successful
            console.log(response);

            let result = [response.data.question, response.data.answer, response.data.type];//Set question to the api response
            return result;
        }
        ).catch(error => {
            console.log(error);
            
            return axios.get(apiBackupLink).then(response => {//If backend fails with options, try again with default options
                console.log(response);

                let result = [response.data.question, response.data.answer, response.data.type];
                return result;
            }
            ).catch(error => {//If backend fails with default options, try again with old function
                console.log(error);
                return OLDretrieveKatakanaQuestion(options);
            });
        });

}


/**
 * The component for the katakana practice page.
 * Contains the top elements (score, options, etc.), the question, and the correct/wrong answer screens, as well as the options modal
 * @returns KatakanaPractice component
 */
function KatakanaPractice()
{
    //Hooks********************************************************************************/
    //Manages which screen is displayed 0: Question, 1: Correct Answer, 2: Wrong Answer
    const [screen, setScreen] = React.useState(0);
    //Manages the question being displayed [0]: Answer, [1]: Katakana, [2]: Conjugation Parameters
    const [question, setQuestion] = React.useState([]);
    //Manages whether the options modal is on screen or not, false: not on screen, true: on screen
    const [showOptions, setShowOptions] = React.useState(false);
    //The user's response to the question
    const userResponse = React.useRef("");
    //The number of questions answered
    const questionCount = React.useRef(0);
    //The number of questions answered correctly
    const correct = React.useRef(0);
    //The options for Katakana
    const options = React.useRef(
    [
        true, //includeKatakana
        true, //includeRomaji
        true, //dakutenhandakuten
        true  //extended
    ]
    );

    //Manages whether the loading screen is on screen or not, false: not on screen, true: on screen
    const [loading, setLoading] = React.useState(true);

    //Context********************************************************************************/
    const darkMode = React.useContext(darkContext).darkMode;//Get the darkMode variable from the darkContext

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
    React.useEffect(() => {
        retrieveQuestion(options.current).then(result => 
            {
                setQuestion(result);
                setLoading(false);
            });
    }, []);

    if(loading)
    {
        return( //TopElements, Loading, Options
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
        return ( //TopElements, KanaQuestion, Options
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
                    <KanaQuestion word = {question[0]} type = {question[2]} kana = "katakana" checkAnswer={checkAnswer}/>
                    {showOptions && <Options options = {options.current} submit = {changeOptions} set = "kana"/>}

                </Box>
            </Box>

        );
    }
    else if(screen === 1)//Correct Answer Screen
    {
        return(//TopElements, CorrectAnswer, Options
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
                    <CorrectAnswer question = {question[0]} correctAnswer ={question[1]} next = {newQuestion}/>
                    {showOptions && <Options options = {options.current} submit = {changeOptions} set = "kana"/>}
                </Box>
            </Box>
        );
    }
    else//Wrong Answer Screen
    {
        return( //TopElements, WrongAnswer, Options
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
                    <WrongAnswer question = {question[0]} userAnswer = {userResponse.current} correctAnswer ={question[1]} next = {newQuestion}/>
                    {showOptions && <Options options = {options.current} submit = {changeOptions} set = "kana"/>}
                </Box>
            </Box>
        );
    }



}

export default KatakanaPractice;