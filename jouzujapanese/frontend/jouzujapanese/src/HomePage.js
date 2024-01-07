import React from 'react';
import { Link } from "react-router-dom";


function HomePage()
{
    return(
        /*
        <div id = "Content" className = "twoSection">

            <div id = "left" className = "section">
                <div className = "LargeTitle">上手</div>
                <div className = "subTitle">Jouzu</div>
            </div>
            <div id = "right" className = "section">
                <button id="toHiraganaButton" className = "largeButton" onClick={() => window.location.href = "/KanaPractice/hiragana"}>ひらがな Hiragana</button>
                <button id="toKatakanaButton" className = "largeButton" onClick={() => window.location.href = "/KanaPractice/katakana"}>カタカナ Katakana</button>
                <button id="toVerbConjugationButton" className = "largeButton" onClick={() => window.location.href = "/ConjugationPractice/verb"}>Verb Conjugation</button>
                <button id="toAdjectiveConjugationButton" className = "largeButton" onClick={() => window.location.href = "/ConjugationPractice/adjective"}>Adjective Conjugation</button>
            </div>
        </div>
        */

        <div id = "Content" className = "twoSection">

            <div id = "left" className = "section">
                <div className = "LargeTitle">上手</div>
                <div className = "subTitle">Jouzu</div>
            </div>

            <div id = "right" className = "section">
                <Link to="/KanaPractice/hiragana" className="largeButton">ひらがな Hiragana</Link>
                <Link to="/KanaPractice/katakana" className="largeButton">カタカナ Katakana</Link>
                <Link to="/ConjugationPractice/verb" className="largeButton">Verb Conjugation</Link>
                <Link to="/ConjugationPractice/adjective" className="largeButton">Adjective Conjugation</Link>
            </div>
        </div>

    );
}

export default HomePage;

