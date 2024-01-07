import React from "react";
import HiraganaKeyboard from "./HiraganaKeyboard";
import KatakanaKeyboard from "./KatakanaKeyboard";


function KanaQuestion(props)
{

    if(props.type === "KANA")
    {
        return(
            <div className = "kanaquestion">
                <div id = "kana" className = "kana">{props.word}</div>
                <div id = "userInput" class = "kanaUserInput">
                 <input id = "userInputBox" className = "kanaInputBox" type = "text" name = "userInputBox" value = ""></input>
                 <button id = "submitButton" className = "submitButton">&rarr;</button>
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
                    <div id = "userInput" class = "kanaUserInput">
                        <HiraganaKeyboard />
                        <button id = "submitButton" className = "submitButton">&rarr;</button>
                    </div>
                </div>
            );
        }
        else
        {
            return(
                <div className = "kanaquestion">
                    <div id = "kana" className = "kana">{props.word}</div>
                    <div id = "userInput" class = "kanaUserInput">
                        <KatakanaKeyboard />    
                        <button id = "submitButton" className = "submitButton">&rarr;</button>
                    </div>
                </div>
            );
        }
    }

}


export default KanaQuestion;