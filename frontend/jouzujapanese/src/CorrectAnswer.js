/**
 * @fileoverview CorrectAnswer.js is a component that displays the correct answer
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
 * The CorrectAnswer component displays the correct answer for a question.
 * Contains the question and the correct answer.
 * @param {*} props question: the question, correctAnswer: the correct answer, next: function to go to the next question
 * @returns The CorrectAnswer component, which displays the correct answer for a question.
 */
function OldCorrectAnswer(props)
{
    return(
        <div className = "correctAnswer">
            <div id = "correctText" className = "correctText">Correct</div>{/*Correct text*/}
            <div id = "question" className = "question">{ props.question }</div>{/*Conjugation question*/}
            <div id = "answerBox" className = "answerBox">{/*Correct answer*/}
                <img className = "answericon" src= "/Correct.svg" alt="Correct"></img>
                <div id = "AnswerText" className = "AnswerText">{ props.correctAnswer }</div>
            </div>
            <button id = "nextButton" className = "submitButton"
            onClick = {() => props.next()}>Pizza</button>{/*Next button*/}
        </div>
    );
}

function CorrectAnswer({question, correctAnswer, next}) {
    
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
                    color: 'green',
                    fontFamily: 'klee one'
                }
            }
            >Correct</Typography>
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


export default CorrectAnswer;