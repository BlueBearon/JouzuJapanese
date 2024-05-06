/**
 * @file ConjugationQuestion.js
 * 
 * @fileoverview This file contains the ConjugationQuestion component. This component is responsible for rendering the conjugation question.
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */


import * as React from 'react';
import "./css/ConjugationQuestion.css";
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import { styled } from '@mui/material/styles';
import { Typography } from '@mui/material';
import { darkContext } from './App';
import { TextField } from '@mui/material';
import RightArrow from '@mui/icons-material/ArrowForward';
import '@fontsource/klee-one';

/**
 * The ConjugationQuestion component, responsible for rendering the conjugation question.
 * Contains the conjugation parameters, the word to conjugate, and the user input box.
 * @param {*} props params: the conjugation parameters, word: the word to conjugate, checkAnswer: function to check the answer
 * @returns The ConjugationQuestion component, responsible for rendering the conjugation question.
 */
function OldConjugationQuestion(props)
{

    //Hooks
    const [userInput, updateInput] = React.useState("");//User input for the conjugation question
    const renders = React.useRef(0);

    return (//The conjugation question
        <div id = "question" className = "conjugationquestion">

            <div id = "conjugationParameters" className = "conjugationParameters">{props.params}</div>{/*Conjugation parameters*/}
            <div id = "conjugationWord" className = "conjugationWord">{props.word}</div>{/*Word to conjugate*/}
            <div id = "userInput" className = "userInput">
                <input 
                id = "userInputBox" 
                className = "userInputBox" 
                type = "text" 
                name = "userInputBox" 
                value = {userInput}
                onChange = {event => updateInput(event.target.value)}
                ></input>{/*User input box*/}
                <button 
                id = "submitButton" 
                className = "submitButton"
                onClick = {() => props.checkAnswer(userInput)}
                >&rarr;</button>{/*Submit button*/}
            </div>

        </div>
    );
}


/**
 * The ConjugationQuestion component, responsible for rendering the conjugation question.
 * Contains the conjugation parameters, the word to conjugate, and the user input box.
 * 
 * This version uses the new Material UI styling.
 *
 * @param {*} params: the conjugation parameters
 * @param {*} word: the word to conjugate
 * @param {*} checkAnswer: function to check the answer
 * @returns The ConjugationQuestion component, responsible for rendering the conjugation question.
 */
function ConjugationQuestion({params, word, checkAnswer})
{
    //Hooks
    const [userInput, updateInput] = React.useState("");//User input for the conjugation question
    const renders = React.useRef(0);

    const darkMode = React.useContext(darkContext).darkMode;//Get the darkMode variable from the darkContext

    return (
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
                gap: '2%',
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
                        color: darkMode ? 'white' : 'black'
                    }
                }
                >
                    {params}
                </Typography>
            </Box>

            <Box
            sx = {{
                display: 'flex',
                flexDirection: 'row',
                justifyContent: 'center',
                alignItems: 'center',
                justifyItems: 'center',
                gap: '2%',
                padding: '2%',
                width: '100%',
                height: '10%'
            }}
            >
                <Typography
                variant = 'h4'
                sx={
                    {
                        fontFamily: 'klee one',
                        fontSize: '2rem',
                        color: darkMode ? 'white' : 'black'
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
                    width: '25vw'
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

export default ConjugationQuestion;