/**
 * @fileoverview CorrectAnswer.js is a component that displays the correct answer
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */


import React from "react";
import "./Result.css";

/**
 * The CorrectAnswer component displays the correct answer for a question.
 * Contains the question and the correct answer.
 * @param {*} props question: the question, correctAnswer: the correct answer, next: function to go to the next question
 * @returns The CorrectAnswer component, which displays the correct answer for a question.
 */
function CorrectAnswer(props)
{
    return(
        <div className = "correctAnswer">
            <div id = "correctText" className = "correctText">Correct</div>{/*Correct text*/}
            <div id = "question" className = "question">{ props.question }</div>{/*Conjugation question*/}
            <div id = "answerBox" className = "answerBox">{/*Correct answer*/}
                <img className = "answericon" src= "/Correct.svg" alt="Correct"></img>
                <div id = "AnswerText" className = "AnswerText">{ props.correctAnswer }</div>
            </div>
            <button id = "nextButton" className = "submitButton"
            onClick = {() => props.next()}>&#8594;</button>{/*Next button*/}
        </div>
    );
}

export default CorrectAnswer;