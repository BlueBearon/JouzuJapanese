import React from "react";


function CorrectAnswer()
{
    return(
        <CorrectAnswer className = "correctAnswer">
            <div id = "correctText" className = "correctText">Correct</div>
            <div id = "question" className = "question"></div>
            <div id = "answerBox" className = "answerBox">
                <img className = "answericon" src= "Assets/Correct.png" alt="Correct"></img>
                <div id = "AnswerText" class = "AnswerText"></div>
            </div>
            <button id = "nextButton" class = "submitButton">&#8594</button>
        </CorrectAnswer>
    );
}

export default CorrectAnswer;