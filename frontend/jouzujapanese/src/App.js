/**
 * @fileoverview App.js is the main file for the frontend. It contains the routing for the different pages.
 * 
 * Author: Chase Packer
 * 
 * Current as of: 1/17/2024
 */

import * as React from 'react';
import TopBar from './TopBar';
import HomePage from './HomePageNew';
import Login from './Login';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Diary from './Diary';
import HiraganaPractice from './HiraganaPractice';
import KatakanaPractice from './KatakanaPractice';
import AdjectiveConjugationPractice from './AdjectiveConjugationPractice';
import VerbConjugationPractice from './VerbConjugationPractice';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import '@fontsource/klee-one';



export const darkContext = React.createContext({darkMode: false, setDarkMode: () => {}});
export const userContext = React.createContext({user: null, setUser: () => {}, auth: false, setAuth: () => {}});


const propelAuthURL = 'https://31455942.propelauthtest.com';


function App() {

  const [user, setUser] = React.useState(null);
  const [darkMode, setDarkMode] = React.useState(false);
  const [auth, setAuth] = React.useState(false);


  return (
      <div>
        <darkContext.Provider value={{darkMode, setDarkMode}}>
          <userContext.Provider value={{user, setUser, auth, setAuth}}>
            <Router>
              <TopBar setDark = {setDarkMode}/>
              <Routes>
                <Route path="/" element={<HomePage  />} />
                <Route path="/diary" element={<Diary />} />
                <Route path="/login" element={<Login />} />
                <Route path="/HiraganaPractice" element={<HiraganaPractice />} />
                <Route path="/KatakanaPractice" element={<KatakanaPractice />} />
                <Route path="/AdjectiveConjugationPractice" element={<AdjectiveConjugationPractice />} />
                <Route path="/VerbConjugationPractice" element={<VerbConjugationPractice />} />
              </Routes>
            </Router>
          </userContext.Provider>
        </darkContext.Provider>
      </div>

  );
}

export default App;