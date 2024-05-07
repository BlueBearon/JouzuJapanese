/**
 * @fileoverview This file contains the WrongAnswer component. This component displays the correct answer and the user's answer when the user answers incorrectly.
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */

import * as React from 'react';
import "./css/Result.css";
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import { styled } from '@mui/material/styles';
import { Typography } from '@mui/material';
import { darkContext } from './App';
import { TextField } from '@mui/material';
import RightArrow from '@mui/icons-material/ArrowForward';
import Close from '@mui/icons-material/Close';
import Check from '@mui/icons-material/Check';
import '@fontsource/klee-one';


/**
 * This function renders the WrongAnswer component, which displays the correct answer and the user's answer when the user answers incorrectly.
 * @param {*} props: question: the question that was answered incorrectly, userAnswer: the user's answer, correctAnswer: the correct answer, next: the function called when the user presses the next button
 * @returns The WrongAnswer component
 */
function OldWrongAnswer(props)
{
    return(
        <div className = "wrongAnswer">
            <div id = "wrongText" className = "wrongText">Incorrect</div>{/*The text "Incorrect" is displayed at the top of the screen*/}
            <div id = "question" className = "question">{ props.question }</div>{/*The question that was answered incorrectly is displayed*/}
            <div id = "givenAnswer" className = "answerBox">{/*The user's answer is displayed with a red X*/}
                <img className = "answericon" src= "/Incorrect.svg" alt="Incorrect"></img>
                <div id = "incorrectAnswerText" className = "AnswerText">{ props.userAnswer }</div>
            </div>
            <div id = "correctAnswer" className = "answerBox">{/*The correct answer is displayed with a green checkmark*/}
                <img className = "answericon" src= "/Correct.svg" alt="Correct"></img>
                <div id = "correctAnswerText" className = "AnswerText">{ props.correctAnswer }</div>
            </div>
            <button id = "nextButton" className = "submitButton"
            onClick = {() => props.next()}>&#8594;</button>{/*The next button is displayed at the bottom*/}
        </div>
    );
}


function WrongAnswer({question, userAnswer, correctAnswer, next}) {

    const useDark = React.useContext(darkContext).darkMode;

    return (
        <Box 
        
        sx={
            {
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
                justifyContent: 'center',
                gap: '2vh',
                height: '76%',
                fontFamily: 'klee one',
                backgroundColor: useDark ? '#131F24' : '#fff',
                color: useDark ? '#fff' : '#131F24'

            }
        }
        >
            <Typography variant="h3"
            sx={
                {
                    marginBottom: '1rem',
                    color: 'red',
                    fontFamily: 'klee one'
                }
            }
            >Incorrect</Typography>
            <Typography variant="h5"
            sx={
                {
                    marginBottom: '1rem',
                    color: useDark ? '#fff' : '#131F24',
                    fontFamily: 'klee one'
                }
            }
            >{question}</Typography>
            <Typography variant="h5"
            sx={
                {
                    display: 'flex',
                    flexDirection: 'row',
                    justifyContent: 'center',
                    marginBottom: '1rem',
                    color: useDark ? '#fff' : '#131F24',
                    fontFamily: 'klee one'
                }
            }
            >
                <Close 
                sx={{color
                    : 'red', fontSize: '2rem', marginRight: '1rem'
                }}/> 
                {userAnswer}</Typography>
            <Typography variant="h5"
            sx={
                {
                    display: 'flex',
                    flexDirection: 'row',
                    justifyContent: 'center',
                    marginBottom: '1rem',
                    color: useDark ? '#fff' : '#131F24',
                    fontFamily: 'klee one'
                }
            }>
                <Check 
                sx={{color: 'green', fontSize: '2rem', marginRight: '1rem'}}
                />
                {correctAnswer}
            </Typography>
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
                
                onClick = {() => next()}
                ><RightArrow/></Button>{/*Submit button*/}
        </Box>
    );
}

export default WrongAnswer;