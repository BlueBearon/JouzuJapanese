import React from "react";
import "./Header.css";
import { Link } from "react-router-dom";

function Header()
{
    return(
        <header className = "header">
            <div className = "Heading"><Link to="/" className="Heading">上手</Link></div>

            <div id = "nav" className = "tabs">
               <Link to="/KanaPractice/hiragana" className="navButton">Hiragana</Link>
               <Link to="/KanaPractice/katakana" className="navButton">Katakana</Link>
               <Link to="/ConjugationPractice/verb" className="navButton">Verb</Link>
               <Link to="/ConjugationPractice/adjective" className="navButton">Adjective</Link>
               <Link to="/About" className="navButton">About</Link>
           </div>

        </header>
    );
}

export default Header;