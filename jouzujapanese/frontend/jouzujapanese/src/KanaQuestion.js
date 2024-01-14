import React, {useState, useRef} from "react";
import HiraganaKeyboard from "./HiraganaKeyboard";
import KatakanaKeyboard from "./KatakanaKeyboard";


function KanaQuestion(props)
{
    const [userInput, updateInput] = useState("");
    const keyboardInput = useRef("");


    console.log("User Input: " + userInput);

    console.log("props.type: " + props.type);
    console.log("props.kana: " + props.kana);


    function updateKeyboardInput(result)
    {
        keyboardInput.current = result;
        console.log("User Input: " + keyboardInput.current);
    }

    if(props.type === "KANA")
    {
        return(
            <div className = "kanaquestion">
                <div id = "kana" className = "kana">{props.word}</div>
                <div id = "userInput" className = "kanaUserInput">
                 <input id = "userInputBox" className = "kanaInputBox" type = "text" name = "userInputBox" value = {userInput.current}
                 onChange={event => updateInput(event.target.value)}></input>
                 <button id = "submitButton" className = "submitButton"
                 onClick = {() => props.checkAnswer(userInput)}>&rarr;</button>
                </div>
            </div>
        );
    }
    else
    {
        if(props.kana === "hiragana")
        {
            return(
                <div className = "kanaquestion">
                    <div id = "kana" className = "kana">{props.word}</div>
                    <div id = "userInput" className = "kanaUserInput">
                        <HiraganaKeyboard keyboardPress = {updateKeyboardInput}/>
                        <button id = "submitButton" className = "submitButton"
                        onClick = {() => props.checkAnswer(keyboardInput.current)}>&rarr;
                        </button>
                    </div>
                </div>
            );
        }
        else
        {
            return(
                <div className = "kanaquestion">
                    <div id = "kana" className = "kana">{props.word}</div>
                    <div id = "userInput" className = "kanaUserInput">
                        <KatakanaKeyboard keyboardPress = {updateKeyboardInput}/>    
                        <button id = "submitButton" className = "submitButton"
                        onClick = {() => props.checkAnswer(keyboardInput.current)}>&rarr;</button>
                    </div>
                </div>
            );
        }
    }

}


export default KanaQuestion;