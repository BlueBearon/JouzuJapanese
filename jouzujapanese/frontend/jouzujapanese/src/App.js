import './Prototype.css';
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './HomePage';
import Header from './Header.js';

function App()
{
    return(
        <Router>
            <head>
                <meta charset = "utf-8"></meta>
                <title>Jouzu Japanese</title>
                <link rel = "stylesheet" href = "Prototype.css"></link>
                <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap"></link>
            </head>
            <Header />
            <Routes>
                <Route path = "/" element = {<HomePage />} />
            </Routes>
            
        </Router>

    );
}

export default App;