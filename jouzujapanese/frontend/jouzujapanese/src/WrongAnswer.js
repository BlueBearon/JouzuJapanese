/**
 * @fileoverview This file contains the WrongAnswer component. This component displays the correct answer and the user's answer when the user answers incorrectly.
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */

import React from "react";
import "./css/Result.css";

/**
 * This function renders the WrongAnswer component, which displays the correct answer and the user's answer when the user answers incorrectly.
 * @param {*} props: question: the question that was answered incorrectly, userAnswer: the user's answer, correctAnswer: the correct answer, next: the function called when the user presses the next button
 * @returns The WrongAnswer component
 */
function WrongAnswer(props)
{
    return(
        <div className = "wrongAnswer">
            <div id = "wrongText" className = "wrongText">Incorrect</div>{/*The text "Incorrect" is displayed at the top of the screen*/}
            <div id = "question" className = "question">{ props.question }</div>{/*The question that was answered incorrectly is displayed*/}
            <div id = "givenAnswer" className = "answerBox">{/*The user's answer is displayed with a red X*/}
                <img className = "answericon" src= "/Incorrect.svg" alt="Incorrect"></img>
                <div id = "incorrectAnswerText" className = "AnswerText">{ props.userAnswer }</div>
            </div>
            <div id = "correctAnswer" className = "answerBox">{/*The correct answer is displayed with a green checkmark*/}
                <img className = "answericon" src= "/Correct.svg" alt="Correct"></img>
                <div id = "correctAnswerText" className = "AnswerText">{ props.correctAnswer }</div>
            </div>
            <button id = "nextButton" className = "submitButton"
            onClick = {() => props.next()}>&#8594;</button>{/*The next button is displayed at the bottom*/}
        </div>
    );
}

export default WrongAnswer;