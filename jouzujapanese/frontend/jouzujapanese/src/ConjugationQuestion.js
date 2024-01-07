import React, {useState} from "react";

function ConjugationQuestion(props)
{
    const [userInput, updateInput] = useState("");

    return (
        <div id = "question" className = "conjugationquestion">

            <div id = "conjugationParameters" className = "conjugationParameters">{props.params}</div>
            <div id = "conjugationWord" className = "conjugationWord">{props.word}</div>
            <div id = "userInput" className = "userInput">
                <input 
                id = "userInputBox" 
                className = "userInputBox" 
                type = "text" 
                name = "userInputBox" 
                value = {userInput}
                onChange = {event => updateInput(event.target.value)}
                ></input>
                <button 
                id = "submitButton" 
                className = "submitButton"
                onClick = {() => props.checkAnswer(userInput)}
                >&rarr;</button>
            </div>

        </div>
    );
}

export default ConjugationQuestion;