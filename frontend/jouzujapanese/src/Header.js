import React from "react";
import "./css/Header.css";
import { Link } from "react-router-dom";


/**
 * The Header component, which contains the header for the website, containing the name of the website and the navigation bar.
 * @returns The Header component, which contains the header for the website.
 */
function Header()
{
    return(
        <header className = "header">
            <div className = "Heading"><Link to="/" className="Heading">上手</Link></div>{/*Name of the website*/}

            <div id = "nav" className = "tabs">{/*Navigation bar: Links to other activities*/}
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