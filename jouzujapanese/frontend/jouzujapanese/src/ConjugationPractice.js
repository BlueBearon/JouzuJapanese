import React from "react";
import TopElements from "./TopElements";
import ConjugationQuestion from "./ConjugationQuestion";
import CorrectAnswer from "./CorrectAnswer";
import WrongAnswer from "./WrongAnswer";
import Options from "./Options";
import axios from 'axios';

import { useState, useEffect, useRef } from 'react';

let apiLink = "http://localhost:8080"


function OLDretrieveVerbQuestion(options)
{
    //Will be replaced by call to backend

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


function retrieveVerbQuestion(options)
{
    console.log("ConjugationPractice.js: Retrieving Verb Question");

    return OLDretrieveVerbQuestion(options);

    axios.get(apiLink + "/api/verbConjugation", {params: {options: options}})
        .then(response => {
            console.log(response);

            let result = [response.data.answer, response.data.hiragana, response.data.conjugation];
            return result;
        })
        .catch(error => {
            console.log(error);
            alert("Error retrieving verb question");
            return OLDretrieveVerbQuestion(options);
        }); 
}

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

    return possibleQuestions[Math.floor(Math.random() * possibleQuestions.length)];

}
function retrieveAdjectiveQuestion(options)
{
    console.log("ConjugationPractice.js: Retrieving Adjective Question");

    return OLDretrieveAdjectiveQuestion(options);

    axios.get(apiLink + "/api/adjectiveConjugation", {params: {options: options}})
        .then(response => {
            console.log(response);

            let result = [response.data.answer, response.data.hiragana, response.data.conjugation];
            return result;
        })
        .catch(error => {
            console.log(error);
            alert("Error retrieving adjective question");
            return OLDretrieveAdjectiveQuestion(options);
        });

}




function ConjugationPractice(props)
{

    console.log("ConjugationPractice.js: Rendering Conjugation Practice");

    const [state, setState] = useState(0);
    const userResponse = useRef("");
    const questionCount = useRef(0);
    const correct = useRef(0);
    const question = useRef([]);
    const questionType = useRef("verb");
    const [showOptions, setShowOptions] = useState(false);
    const renders = useRef(0);

    useEffect(() => {
        renders.current += 1;
        console.log("ConjugationPractice.js: ConjugationPractice Renders: " + renders.current);
    });

   const verbOptions = useRef(
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
   )

    function changeVerbOptions(options)
    {
        verbOptions.current = [...options];
        
        setShowOptions(false);
    }

    const adjectiveOptions = useRef(
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

    function changeAdjectiveOptions(options)
    {

        adjectiveOptions.current = [...options];
        
        setShowOptions(false);
    }

    function checkAnswer(answer)
    {
        userResponse.current = answer;

        questionCount.current += 1;

        if(answer === question.current[0])
        {
            correct.current +=1;
            console.log("ConjugationPractice.js: Answer is correct, setting state to 1");
            setState(1);
        }
        else
        {
            console.log("ConjugationPractice.js: Answer is wrong, setting state to 2");
            setState(2);
        }
    }

    function test(answer)
    {
        console.log("ConjugationPractice.js: Testing");

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

        console.log("ConjugationPractice.js: newQuestion() called. Question Type: " + props.type);
        if(props.type === "verb")
        {
            question.current = retrieveVerbQuestion(verbOptions.current);
        }
        else
        {
            question.current = retrieveAdjectiveQuestion(adjectiveOptions.current);
        }

        if(state !== 0)
        {
            console.log("ConjugationPractice.js: State is not 0. Setting state to 0");
            setState(0);
        }
    }

    if(props.type !== questionType.current)
    {
        console.log("ConjugationPractice.js: Type changed");
        questionType.current = props.type;
        questionCount.current = 0;
        correct.current = 0;

        newQuestion();
        setState(0);
    }

    useEffect(() => {

        setShowOptions(false);
        newQuestion();

    }, [props.type]);


    if(state === 0)
    {
        console.log("ConjugationPractice.js: Rendering Question");

        if(question.current.length === 0)
        {
            newQuestion();
        }

        return (
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <ConjugationQuestion params = {question.current[2]} word = {question.current[1]}  checkAnswer={test}/>
                {showOptions && <Options options = {props.type === "verb" ? verbOptions.current : adjectiveOptions.current} submit = {props.type === "verb" ? changeVerbOptions : changeAdjectiveOptions} set = {props.type}/>}
            </div>
        );
    }
    else if(state === 1)
    {
        console.log("ConjugationPractice.js: Rendering Correct Answer");
        return(
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <CorrectAnswer question = {question.current[2]} correctAnswer ={question.current[0]} next = {() => newQuestion()}/>
                {showOptions && <Options options = {props.type === "verb" ? verbOptions.current : adjectiveOptions.current} submit = {props.type === "verb" ? changeVerbOptions : changeAdjectiveOptions} set = {props.type}/>}
            </div>
        );
    }
    else
    {
        console.log("ConjugationPractice.js: Rendering Wrong Answer");
        return(
            <div className = "questionSection">
                <TopElements correct = {correct.current} questions = {questionCount.current} openOptions = {() => setShowOptions(true)}/>
                <WrongAnswer question = {question.current[2]} userAnswer = {userResponse.current} correctAnswer ={question.current[0]} next = {() => newQuestion()}/>
                {showOptions && <Options options = {props.type === "verb" ? verbOptions : adjectiveOptions} submit = {props.type === "verb" ? changeVerbOptions : changeAdjectiveOptions} set = {props.type}/>}
            </div>
        );
    }

    
    
}

export default ConjugationPractice;