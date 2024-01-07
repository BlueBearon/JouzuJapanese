import React, {useState, useRef} from "react";
import TopElements from "./TopElements";
import CorrectAnswer from "./CorrectAnswer";
import WrongAnswer from "./WrongAnswer";
import KanaQuestion from "./KanaQuestion";

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

    function newQuestion()
    {
        setState(0);
    }

    console.log("State: " + state);

    if(props.type !== questionType.current)
    {
        questionType.current = props.type;
        questionCount.current = 0;
        correct.current = 0;
    }

    if(state === 0)
    {
        console.log("Rendering Question");

        if(props.type === "hiragana")
        {
            question.current = retrieveHiraganaQuestion([true, true]);
        }
        else
        {
            question.current = retrieveKatakanaQuestion([true, true]);
        }

        return (
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current}/>
                <KanaQuestion word = {question.current[0]} type = {question.current[2]} kana = {props.type} checkAnswer={test}/>
            </div>

        );
    }
    else if(state === 1)
    {
        return(
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current}/>
                <CorrectAnswer question = {question.current[0]} correctAnswer ={question.current[1]} next = {newQuestion}/>

            </div>
        );
    }
    else
    {
        return(
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current}/>
                <WrongAnswer question = {question.current[0]} userAnswer = {userResponse.current} correctAnswer ={question.current[1]} next = {newQuestion}/>

            </div>
        );
    }
}

export default KanaPractice;