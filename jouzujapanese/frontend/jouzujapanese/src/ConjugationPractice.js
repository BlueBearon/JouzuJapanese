import React from "react";
import TopElements from "./TopElements";
import ConjugationQuestion from "./ConjugationQuestion";
import CorrectAnswer from "./CorrectAnswer";
import WrongAnswer from "./WrongAnswer";

import { useState, useEffect, useRef } from 'react';


function retrieveVerbQuestion(options)
{
    //Will be replaced by call to backend

    console.log("Retrieving Verb Question");

    //return ["たべられます", "たべる", "Potential Formal Positive Present"];

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

function retrieveAdjectiveQuestion(options)
{
    //Will be replaced by call to backend

    console.log("Retrieving Adjective Question");

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

    return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];

}




function ConjugationPractice(props)
{

    console.log("Rendering Conjugation Practice");

    const [state, setState] = useState(0);
    const userResponse = useRef("");
    const questionCount = useRef(0);
    const correct = useRef(0);
    const question = useRef([]);
    const questionType = useRef("verb");

    console.log(props.type);


    function checkAnswer(answer)
    {
        userResponse.current = answer;

        questionCount.current += 1;

        if(answer === question.current[0])
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
        if(props.type === "verb")
        {
            question.current = retrieveVerbQuestion();
        }
        else
        {
            question.current = retrieveAdjectiveQuestion();
        }

        return (
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current}/>
                <ConjugationQuestion params = {question.current[2]} word = {question.current[1]}  checkAnswer={test}/>
            </div>
        );
    }
    else if(state === 1)
    {
        console.log("Rendering Correct Answer");
        return(
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current}/>
                <CorrectAnswer question = {question.current[2]} correctAnswer ={question.current[0]} next = {newQuestion}/>

            </div>
        );
    }
    else
    {
        console.log("Rendering Wrong Answer");
        return(
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current}/>
                <WrongAnswer question = {question.current[2]} userAnswer = {userResponse.current} correctAnswer ={question.current[0]} next = {newQuestion}/>
            </div>
        );
    }

    
    
}

export default ConjugationPractice;