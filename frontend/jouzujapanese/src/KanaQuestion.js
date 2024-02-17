/**
 * @fileoverview This file contains the KanaQuestion component. This component is used to display a question
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */

import React, {useState, useRef} from "react";
import "./css/KanaQuestion.css";
import HiraganaKeyboard from "./HiraganaKeyboard";
import KatakanaKeyboard from "./KatakanaKeyboard";

/**
 * The KanaQuestion component, which is used to display a question and get the user's answer
 * @param {*} props : type: the type of question, kana: the type of kana, word: the word to be displayed, checkAnswer: the function to check the user's answer
 * @returns The KanaQuestion component, which is used to display a question and get the user's answer
 */
function KanaQuestion(props)
{
    const [userInput, updateInput] = useState("");
    const keyboardInput = useRef("");


    console.log("User Input: " + userInput);

    console.log("props.type: " + props.type);
    console.log("props.kana: " + props.kana);


    /**
     * Updates the keyboard input
     * @param {*} result: the result of the keyboard input
     */
    function updateKeyboardInput(result)
    {
        keyboardInput.current = result;
        console.log("User Input: " + keyboardInput.current);
    }
    
    //Display depends on the type of question
    if(props.type === "KANA")//Kana to Romanji
    {
        return(//Display the kana and the user's input box
            <div className = "kanaquestion">
                <div id = "kana" className = "kana">{props.word}</div>
                <div id = "userInput" className = "kanaUserInput">
                 <input id = "userInputBox" className = "kanaInputBox" type = "text" name = "userInputBox" value = {userInput.current}
                 onChange={event => updateInput(event.target.value)}></input>{/*give callback function to update the user's input*/}
                 <button id = "submitButton" className = "submitButton"
                 onClick = {() => props.checkAnswer(userInput)}>&rarr;</button>{/*callback function to check the user's answer*/}
                </div>
            </div>
        );
    }
    else//Romanji to Kana
    {
        if(props.kana === "hiragana")//Display the hiragana keyboard
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
        else//Display the katakana keyboard
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