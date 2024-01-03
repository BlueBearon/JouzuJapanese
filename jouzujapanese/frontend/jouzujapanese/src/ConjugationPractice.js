import React from "react";
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function ConjugationPractice()
{
    return(
        <Routes>
            <Route path = "/verb" element = {<VerbConjugation />} />
            <Route path = "/adjective" element = {<AdjectiveConjugation />} />
        </Routes>
    );
}

export default ConjugationPractice;