/**
 * @fileoverview This file contains the KanaQuestion component. This component is used to display a question
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */

import * as React from 'react';
import "./css/KanaQuestion.css";
import HiraganaKeyboard from "./HiraganaKeyboard";
import KatakanaKeyboard from "./KatakanaKeyboard";
import { darkContext } from './App';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import { styled } from '@mui/material/styles';
import { Typography } from '@mui/material';
import { TextField } from '@mui/material';
import RightArrow from '@mui/icons-material/ArrowForward';
import '@fontsource/klee-one';

/**
 * The KanaQuestion component, which is used to display a question and get the user's answer
 * @param {*} props : type: the type of question, kana: the type of kana, word: the word to be displayed, checkAnswer: the function to check the user's answer
 * @returns The KanaQuestion component, which is used to display a question and get the user's answer
 */
function OldKanaQuestion(props)
{
    const [userInput, updateInput] = React.useState("");
    const keyboardInput = React.useRef("");

    const darkMode = React.useContext(darkContext).darkMode;//Get the darkMode variable from the darkContext


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

function KanaQuestion({type, kana, word, checkAnswer})
{
    const [userInput, updateInput] = React.useState("");
    const keyboardInput = React.useRef("");

    const darkMode = React.useContext(darkContext).darkMode;//Get the darkMode variable from the darkContext

    console.log("User Input: " + userInput);

    console.log("props.type: " + type);
    console.log("props.kana: " + kana);


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
    if(type === "KANA")//Kana to Romanji
    {
        return(
        <Box
        
        sx = {{

            display: 'flex',
            flexDirection: 'column',
            justifyContent: 'center',
            alignItems: 'center',
            justifyItems: 'center',
            height: '76%',
            gap: '2%',
            padding: '2%',
            color: darkMode ? 'white' : 'black',
            
        }}
        >

            <Box
                sx = {{
                    display: 'flex',
                    flexDirection: 'row',
                    justifyContent: 'center',
                    alignItems: 'center',
                    justifyItems: 'center',
                    gap: '4%',
                    width: '100%',
                    height: '10%'
                }}
                >
                    <Typography
                    variant = 'h5'
                    sx={
                        {
                            fontFamily: 'klee one',
                            fontSize: '2rem',
                            color: darkMode ? 'white' : 'black',
                            fontSize: '3rem',
                        }
                    }
                    >
                        {word}
                    </Typography>
            </Box>

            <Box
            sx = {{
                display: 'flex',
                flexDirection: 'row',
                justifyContent: 'center',
                alignItems: 'center',
                justifyItems: 'center',
                width: '100%',
                height: '10%',
                padding: '30%'
            }}
            >
                <TextField
                type = "text" 
                name = "userInputBox" 
                value = {userInput}
                onChange = {event => updateInput(event.target.value)}
                sx = {{
                    backgroundColor: 'white',
                    color: darkMode ? 'white' : 'black',
                    fontFamily: 'klee one',
                    fontSize: '2rem',
                    width: '5vw'
                }}
                ></TextField>{/*User input box*/}
                <Button
                 
                 sx = {{
                    backgroundColor: "#1976D2",
                    color: "white",
                    fontFamily: 'klee one !important',
                    fontSize: '2rem',
                    width: '4vw',
                    height: '6vh',
                    fontSize: '2rem',
                 }}
                
                onClick = {() => checkAnswer(userInput)}
                ><RightArrow/></Button>{/*Submit button*/}
            </Box>
        </Box>
        );
    }
    else
    {
        if(kana === "hiragana")//Display the hiragana keyboard
        {
            
            return(
                <Box
                
                sx = {{

                    display: 'flex',
                    flexDirection: 'column',
                    justifyContent: 'center',
                    alignItems: 'center',
                    justifyItems: 'center',
                    height: '76%',
                    gap: '2%',
                    padding: '2%',
                    color: darkMode ? 'white' : 'black',
                    
                }}
                >
        
                    <Box
                        sx = {{
                            display: 'flex',
                            flexDirection: 'row',
                            justifyContent: 'center',
                            alignItems: 'center',
                            justifyItems: 'center',
                            gap: '4%',
                            width: '100%',
                            height: '10%',
                        }}
                        >
                            <Typography
                            variant = 'h5'
                            sx={
                                {
                                    fontFamily: 'klee one',
                                    fontSize: '2rem',
                                    color: darkMode ? 'white' : 'black',
                                    fontSize: '3rem',
                                }
                            }
                            >
                                {word}
                            </Typography>
                    </Box>
        
                    <Box
                    sx = {{
                        display: 'flex',
                        flexDirection: 'row',
                        justifyContent: 'center',
                        alignItems: 'center',
                        justifyItems: 'center',
                        width: '100%',
                        height: '10%',
                        padding: '20%',
                        color: darkMode ? 'white' : 'black',
                    }}
                    >
                        <HiraganaKeyboard keyboardPress = {updateKeyboardInput}/>
                        <Button
                         
                         sx = {{
                            backgroundColor: "#1976D2",
                            color: "white",
                            fontFamily: 'klee one !important',
                            fontSize: '2rem',
                            width: '4vw',
                            height: '6vh',
                            fontSize: '2rem',
                         }}
                        
                        onClick = {() => checkAnswer(keyboardInput.current)}
                        ><RightArrow/></Button>{/*Submit button*/}
                    </Box>
                </Box>
                );
        }
        else//Display the katakana keyboard
        {
        
            return(
                <Box
                
                sx = {{

                    display: 'flex',
                    flexDirection: 'column',
                    justifyContent: 'center',
                    alignItems: 'center',
                    justifyItems: 'center',
                    height: '76%',
                    gap: '2%',
                    padding: '2%',
                    color: darkMode ? 'white' : 'black',
                    
                }}
                >
        
                    <Box
                        sx = {{
                            display: 'flex',
                            flexDirection: 'row',
                            justifyContent: 'center',
                            alignItems: 'center',
                            justifyItems: 'center',
                            gap: '4%',
                            width: '100%',
                            height: '10%'
                        }}
                        >
                            <Typography
                            variant = 'h5'
                            sx={
                                {
                                    fontFamily: 'klee one',
                                    fontSize: '2rem',
                                    color: darkMode ? 'white' : 'black',
                                    fontSize: '3rem',
                                }
                            }
                            >
                                {word}
                            </Typography>
                    </Box>
        
                    <Box
                    sx = {{
                        display: 'flex',
                        flexDirection: 'row',
                        justifyContent: 'center',
                        alignItems: 'center',
                        justifyItems: 'center',
                        width: '100%',
                        height: '10%',
                        padding: '20%',
                        color: darkMode ? 'white' : 'black',
                    }}
                    >
                        <KatakanaKeyboard keyboardPress = {updateKeyboardInput}/>    
                        <Button
                         
                         sx = {{
                            backgroundColor: "#1976D2",
                            color: "white",
                            fontFamily: 'klee one !important',
                            fontSize: '2rem',
                            width: '4vw',
                            height: '6vh',
                            fontSize: '2rem',
                         }}
                        
                        onClick = {() => checkAnswer(keyboardInput.current)}
                        ><RightArrow/></Button>{/*Submit button*/}
                    </Box>
                </Box>
            );
        }
    }

    
    
    
}


export default KanaQuestion;