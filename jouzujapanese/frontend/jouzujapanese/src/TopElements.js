/**
 * @fileoverview This file contains the TopElements component. This component contains the score and options button at the top of the screen.
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2021
 */

import React from "react";
import "./css/TopElements.css";

/**
 * This function renders the TopElements component, which contains the score and options button at the top of the screen.
 * @param {*} props: correct: the number of correct answers, questions: the number of questions answered, openOptions: the function called when the options button is pressed
 * @returns The TopElements component
 */
function TopElements(props)
{
    var percent = props.questions === 0 ? 0 : props.correct/props.questions;//Calculate the percentage of questions answered correctly, if no questions have been answered, set the percentage to 0

    return (//The score is displayed at the top right of the screen, the options button is displayed at the top left of the screen
        <div id = "topElements" className = "topElements">

            <div id = "topButtons" className = "topButtons">
                <button id = "optionsButton" className = "topButton" onClick = {() => props.openOptions()}><img className = "answericon" src="/options.svg" alt="Options"></img></button>
            </div>

            <div id = "score" className = "score">
                <div id = "outOf" className = "outOf">{props.correct}/{props.questions}</div>
                <div id = "percentage" className = "percentage">{Math.round(percent * 100)}%</div>
            </div>
        </div>
        
    );
}

export default TopElements;