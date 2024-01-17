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

function App()
{
    return(
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