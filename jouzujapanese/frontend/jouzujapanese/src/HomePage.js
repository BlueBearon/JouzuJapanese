import React from 'react';
import { Link } from "react-router-dom";


function HomePage()
{
    return(
        
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

