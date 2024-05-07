/**
 * @file HomePage.js
 * 
 * @fileoverview This file contains the HomePage component, which contains the home page for the website.
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */

import * as React from 'react';
import "./css/HomePage.css";
import { Link } from "react-router-dom";

/**
 * The HomePage component, which contains the home page for the website.
 * Contains the name of the website and the links to the other activities.
 * @returns The HomePage component, which contains the home page for the website.
 */
function HomePage()
{
    return(
        
        <div id = "Content" className = "twoSection">{/*Divide into two sections, left and right*/}

            <div id = "left" className = "section">{/*Name of the website*/}
                <div className = "LargeTitle">上手</div>
                <div className = "subTitle">Jouzu</div>
            </div>

            <div id = "right" className = "section">{/*Links to the other activities*/}
                <Link to="/KanaPractice/hiragana" className="largeButton">ひらがな Hiragana</Link>
                <Link to="/KanaPractice/katakana" className="largeButton">カタカナ Katakana</Link>
                <Link to="/ConjugationPractice/verb" className="largeButton">Verb Conjugation</Link>
                <Link to="/ConjugationPractice/adjective" className="largeButton">Adjective Conjugation</Link>
            </div>
        </div>

    );
}

export default HomePage;

