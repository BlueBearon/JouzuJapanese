import React from "react";


function CorrectAnswer(props)
{
    return(
        <div className = "correctAnswer">
            <div id = "correctText" className = "correctText">Correct</div>
            <div id = "question" className = "question">{ props.question }</div>
            <div id = "answerBox" className = "answerBox">
                <img className = "answericon" src= "/Correct.png" alt="Correct"></img>
                <div id = "AnswerText" className = "AnswerText">{ props.correctAnswer }</div>
            </div>
            <button id = "nextButton" className = "submitButton"
            onClick = {() => props.next()}>&#8594;</button>
        </div>
    );
}

export default CorrectAnswer;