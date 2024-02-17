/**
 * @file About.js
 * 
 * This file contains the About component, explaining the purpose of the program.
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */

import React from 'react';


/**
 * The About component, explaining the purpose of the program. Simply returns a div with the information.
 * @returns A div containing the information about the program
 */
function About()
{
    return(
        <div>
            <h1>About</h1>
            <p>Author: Chase Packer</p>
            <p>Version: 0.1</p>
            <br></br>
            <p>This Program is designed to help beginner Japanese students by providing ways to Practice Japanese 
            lanuguage skills aside from just memorizing vocabulary.
            </p>
            <br></br>
            <p>Currently the program has 4 practices: Hiragana Practice and Katakana practice for those that are
                attempting to learn the Japanese writing system, and Verb Conjugation Practice and Adjective Conjugation.
            </p>
        </div>
    );
}

export default About;