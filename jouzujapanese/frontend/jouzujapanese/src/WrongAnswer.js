import React from "react";

function WrongAnswer()
{
    return(
        <WrongAnswer className = "wrongAnswer">
            <div id = "wrongText" class = "wrongText">Incorrect</div>
            <div id = "question" class = "question"></div>
            <div id = "givenAnswer" class = "answerBox">
                <img className = "answericon" src= "Assets/Incorrect.png" alt="Incorrect"></img>
                <div id = "incorrectAnswerText" class = "AnswerText"></div>
            </div>
            <div id = "correctAnswer" class = "answerBox">
                <img className = "answericon" src= "Assets/Correct.png" alt="Correct"></img>
                <div id = "correctAnswerText" class = "AnswerText"></div>
            </div>
            <button id = "nextButton" class = "submitButton">&#8594</button>
        </WrongAnswer>
    );
}

export default WrongAnswer;