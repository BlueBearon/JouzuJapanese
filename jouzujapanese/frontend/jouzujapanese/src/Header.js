import React from "react";

function Header()
{
    return(
        <header className = "header">
            <div className = "Heading">上手</div>

            <div id = "nav" className = "tabs">
                <button id = "toHiraganaTab" className = "navButton">Hiragana</button>
                <button id = "toKatakanaTab" className = "navButton">Katakana</button>
                <button id = "toVerbConjugationTab" className = "navButton">Verb</button>
                <button id = "toAdjectiveConjugationTab" className = "navButton">Adjective</button>
                <button id = "toAboutTab" className = "navButton">About</button>
            </div>

            <script src = "NavigationBar.js"></script>

        </header>
    );
}

export default Header;