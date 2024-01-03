import React from 'react';

function HomePage()
{
    return(
        <div id = "Content" className = "twoSection">

            <div id = "left" className = "section">
                <div className = "LargeTitle">上手</div>
                <div className = "subTitle">Jouzu</div>
            </div>

            <div id = "right" className = "section">
                <button id="toHiraganaButton" className = "largeButton">ひらがな Hiragana</button>
                <button id="toKatakanaButton" className = "largeButton">カタカナ Katakana</button>
                <button id="toVerbConjugationButton" className = "largeButton">Verb Conjugation</button>
                <button id="toAdjectiveConjugationButton" className = "largeButton">Adjective Conjugation</button>
            </div>

            <script src = "HomeNavigation.js"></script>

        </div>

    );
}

export default HomePage;

