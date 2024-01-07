import React from "react";

function WrongAnswer(props)
{
    return(
        <div className = "wrongAnswer">
            <div id = "wrongText" className = "wrongText">Incorrect</div>
            <div id = "question" className = "question">{ props.question }</div>
            <div id = "givenAnswer" className = "answerBox">
                <img className = "answericon" src= "/Incorrect.png" alt="Incorrect"></img>
                <div id = "incorrectAnswerText" className = "AnswerText">{ props.userAnswer }</div>
            </div>
            <div id = "correctAnswer" className = "answerBox">
                <img className = "answericon" src= "/Correct.png" alt="Correct"></img>
                <div id = "correctAnswerText" className = "AnswerText">{ props.correctAnswer }</div>
            </div>
            <button id = "nextButton" className = "submitButton"
            onClick = {() => props.next()}>&#8594;</button>
        </div>
    );
}

export default WrongAnswer;