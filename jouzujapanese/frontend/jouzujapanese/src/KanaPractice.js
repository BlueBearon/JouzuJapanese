import React, {useState, useRef, useEffect} from "react";
import TopElements from "./TopElements";
import CorrectAnswer from "./CorrectAnswer";
import WrongAnswer from "./WrongAnswer";
import KanaQuestion from "./KanaQuestion";
import Options from "./Options";

function retrieveHiraganaQuestion(options)
{
    //Will be replaced by call to backend

    console.log("Retrieving Hiragana Question");

    //random number 0 or 1
    var random = Math.floor(Math.random() * 2);

    var possibleQuestions;

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

        return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];
    }
    else
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

function retrieveKatakanaQuestion(options)
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

var mode = 0;
var state = 0;
var question = [];
var userResponse = "";
var questions = 0;
var correct = 0;

function KanaPractice(props)
{

    console.log("Rendering Kana Practice");

    const [state, setState] = useState(0);
    const userResponse = useRef("");
    const questionCount = useRef(0);
    const correct = useRef(0);
    const question = useRef({});
    const questionType = useRef("hiragana");
    const [showOptions, setShowOptions] = useState(false);
    const renders = useRef(0);
    const options = useRef(
        [
            true, //kanaToRomanji
            true, //romanjiToKana
            true, //dakutenhandakuten
            true  //extended
        ]
    );
    
    //Every time the type changes, reset the state and the options
    useEffect(() => {

        console.log("KanaPractice.js: props.type has changed to " + props.type);

        for(var i = 0; i < options.current.length; i++)
        {
            options.current[i] = true;
        }
        
        setShowOptions(false);
        setState(0);
    }, [props.type]);


    //Record number of renders
    useEffect(() => {
        renders.current += 1;
        console.log("KanaPractice Renders: " + renders.current);
    });


    /**
     * Changes the options and hides the options menu
     * @param {*} ops : the new options
     */
    function changeOptions(ops)
    {
        options.current = [...ops];//Copy the new options into the options array

        setShowOptions(false);//Hide the options menu
    }


    /**
     * Checks the user's answer to the question
     * If the answer is correct, the state is set to 1: show CorrectAnswer
     * If the answer is incorrect, the state is set to 2: show WrongAnswer
     * @param {*} answer 
     */
    function checkAnswer(answer)
    {
        userResponse.current = answer;

        questionCount.current += 1;

        if(answer == question.current[1])
        {
            correct.current +=1;
            setState(1);
        }
        else
        {
            setState(2);
        }
    }

    /**
     * Wrapper for checkAnswer, used to test the function
     * @param {*} answer 
     */
    function test(answer)
    {
        console.log("Testing");

        try
        {
            checkAnswer(answer);
        }
        catch(err)
        {
            console.log(err);
        }
    }

    /**
     * Resets the state and retrieves a new question
     */
    function newQuestion()
    {
        setState(0);
    }

    console.log("State: " + state);

    //If props.type has changed, reset the question count and correct count
    if(props.type !== questionType.current)
    {
        questionType.current = props.type;
        questionCount.current = 0;
        correct.current = 0;
    }

    //If the state is 0, show the question
    if(state === 0)
    {
        console.log("Rendering Question");

        if(props.type === "hiragana")
        {
            question.current = retrieveHiraganaQuestion(options.current);
        }
        else
        {
            question.current = retrieveKatakanaQuestion(options.current);
        }

        return (
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <KanaQuestion word = {question.current[0]} type = {question.current[2]} kana = {props.type} checkAnswer={test}/>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = "kana"/>}
            </div>

        );
    }
    else if(state === 1)//If the state is 1, show CorrectAnswer
    {
        return(
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <CorrectAnswer question = {question.current[0]} correctAnswer ={question.current[1]} next = {newQuestion}/>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = "kana"/>}
            </div>
        );
    }
    else //If the state is 2, show WrongAnswer
    {
        return(
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <WrongAnswer question = {question.current[0]} userAnswer = {userResponse.current} correctAnswer ={question.current[1]} next = {newQuestion}/>
                {showOptions && <Options options = {options.current} submit = {changeOptions} set = "kana"/>}
            </div>
        );
    }
}

export default KanaPractice;