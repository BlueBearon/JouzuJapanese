/**
 * @file ConjugationQuestion.js
 * 
 * @fileoverview This file contains the ConjugationQuestion component. This component is responsible for rendering the conjugation question.
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */


import React, {useState, useEffect, useRef} from "react";
import "./ConjugationQuestion.css";

/**
 * The ConjugationQuestion component, responsible for rendering the conjugation question.
 * Contains the conjugation parameters, the word to conjugate, and the user input box.
 * @param {*} props params: the conjugation parameters, word: the word to conjugate, checkAnswer: function to check the answer
 * @returns The ConjugationQuestion component, responsible for rendering the conjugation question.
 */
function ConjugationQuestion(props)
{

    //Hooks
    const [userInput, updateInput] = useState("");//User input for the conjugation question
    const renders = useRef(0);

    return (//The conjugation question
        <div id = "question" className = "conjugationquestion">

            <div id = "conjugationParameters" className = "conjugationParameters">{props.params}</div>{/*Conjugation parameters*/}
            <div id = "conjugationWord" className = "conjugationWord">{props.word}</div>{/*Word to conjugate*/}
            <div id = "userInput" className = "userInput">
                <input 
                id = "userInputBox" 
                className = "userInputBox" 
                type = "text" 
                name = "userInputBox" 
                value = {userInput}
                onChange = {event => updateInput(event.target.value)}
                ></input>{/*User input box*/}
                <button 
                id = "submitButton" 
                className = "submitButton"
                onClick = {() => props.checkAnswer(userInput)}
                >&rarr;</button>{/*Submit button*/}
            </div>

        </div>
    );
}

export default ConjugationQuestion;