/**
 * @fileoverview This file contains the TopElements component. This component contains the score and options button at the top of the screen.
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2021
 */

import * as React from 'react';
import "./css/TopElements.css";
import { darkContext } from './App';
import '@fontsource/klee-one';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import { styled } from '@mui/material/styles';
import { Typography } from '@mui/material';
import SettingsIcon from '@mui/icons-material/Settings';


/**
 * This function renders the TopElements component, which contains the score and options button at the top of the screen.
 * @param {*} props: correct: the number of correct answers, questions: the number of questions answered, openOptions: the function called when the options button is pressed
 * @returns The TopElements component
 */
function OldTopElements(props)
{

    var percent = props.questions === 0 ? 0 : props.correct/props.questions;//Calculate the percentage of questions answered correctly, if no questions have been answered, set the percentage to 0

    return (//The score is displayed at the top right of the screen, the options button is displayed at the top left of the screen
        <div id = "topElements" className = "topElements">

            <div id = "topButtons" className = "topButtons">
                <button id = "optionsButton" className = "topButton" onClick = {() => props.openOptions()}><img className = "answericon" src="/options.svg" alt="Options"></img></button>
            </div>

            <div id = "score" className = "score">
                <div id = "outOf" className = "outOf">{props.correct}/{props.questions}</div>
                <div id = "percentage" className = "percentage">{Math.round(percent * 100)}%</div>
            </div>
        </div>
        
    );
}

/**
 * This function renders the TopElements component with Material UI styling, which contains the score and options button at the top of the screen.
 * @param {*} props: correct: the number of correct answers, questions: the number of questions answered, openOptions: the function called when the options button is pressed
 * @returns The TopElements component with Material UI styling
 */
function TopElements({correct, questions, openOptions})
{

    const darkMode = React.useContext(darkContext).darkMode;//Get the darkMode variable from the darkContext

    var percent = questions === 0 ? 0 : correct/questions;//Calculate the percentage of questions answered correctly, if no questions have been answered, set the percentage to 0

    return (

        <Box

        sx = {{
            display: 'flex',
            flexDirection: 'row',
            justifyContent: 'space-between',
            width: '100%',
            height: '8vh',
            padding: '0vh 3vw'
        }}
        >

            <Box

                sx = {{
                    display: 'flex',
                    flexDirection: 'row',
                    justifyContent: 'flex-start',
                    width: '50%',
                    height: '100%'
                }}
            >

                <SettingsIcon
                sx = {{
                    display: 'flex',
                    flexDirection: 'row',
                    justifyContent: 'flex-start',
                    width: '40px',
                    height: '40px',
                    color: darkMode ? 'white' : 'black'
                }}

                onClick = {() => openOptions()}
                />

            </Box>

            <Box

                sx = {{
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'flex-end',
                    justifyContent: 'flex-start',
                    width: '50%',
                    height: '100%'
                }}
            >

                <Typography
                sx={
                    {
                        variant: 'h4',
                        fontFamily: 'klee one',
                        fontSize: '2rem',
                        color: darkMode ? 'white' : 'black'
                    }
                }
                >
                    {correct}/{questions}
                </Typography>

                <Typography
                sx={
                    {
                        variant: 'h4',
                        fontFamily: 'klee one',
                        fontSize: '2rem',
                        color: darkMode ? 'white' : 'black'
                    }
                }
                >
                    {Math.round(percent * 100)}%
                </Typography>

            </Box>
            
        </Box>

    );


}


export default TopElements;
