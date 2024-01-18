/**
 * @fileoverview App.js is the main file for the frontend. It contains the routing for the different pages.
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */

import React from 'react';
import "./App.css";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './HomePage';
import Header from './Header.js';
import AdjectiveConjugationPractice from './AdjectiveConjugationPractice.js';
import VerbConjugationPractice from './VerbConjugationPractice.js';
import HiraganaPractice from './HiraganaPractice.js';
import KatakanaPractice from './KatakanaPractice.js';
import About from './About.js';

/**
 * The main App component, containing the routing for the different pages.
 * @returns The main App component, containing the routing for the different pages.
 */
function App()
{
    return(//Routing for the different pages, plus the header.  
        <Router>
            <Header />
            <Routes>
                <Route path = "/" element = {<HomePage />} />
                <Route path = "/ConjugationPractice/verb" element = {<VerbConjugationPractice/>} />
                <Route path = "/ConjugationPractice/adjective" element = {<AdjectiveConjugationPractice/>} />
                <Route path = "/KanaPractice/hiragana" element = {<HiraganaPractice />} />
                <Route path = "/KanaPractice/katakana" element = {<KatakanaPractice />} />
                <Route path = "/About" element = {<About />} />
            </Routes>
            
        </Router>

    );
}

export default App;