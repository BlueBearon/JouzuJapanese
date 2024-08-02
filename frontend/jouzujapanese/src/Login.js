import * as React from 'react';
import { Button } from '@mui/material';
import { userContext } from './App';
import { darkContext } from './App';
import { TextField } from '@mui/material';
import { Box } from '@mui/material';
import { Typography } from '@mui/material';
import { Alert } from '@mui/material';
import { AlertTitle } from '@mui/material';
import { CircularProgress } from '@mui/material';
import { useState } from 'react';
import { useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';


let loginLink = "";
let loginTestLink = "http://localhost:8080/login";

let registerLink = "";
let registerTestLink = "http://localhost:8080/register";


function Login() {

    const userInfo = React.useContext(userContext);
    const useDark = React.useContext(darkContext);
    const navigate = useNavigate();

    const [username, setUsername] = React.useState('');
    const [password, setPassword] = React.useState('');

    const [loading, setLoading] = React.useState(false);
    const [error, setError] = React.useState('');


    const authenticate = () => {

        setLoading(true);

        return true;
    };


    const authenticateINPROGRESS = async () => {
        
        setLoading(true);
        setError('');

        try {
            const response = await fetch( loginTestLink, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, password }),
            });

            const result = await response.text();

            if (response.ok) {
                userInfo.setAuth(true);
                userInfo.setUser(username);
                navigate('/');
            } else {
                setError(result);
            }
        } catch (error) {
            setError('An error occurred. Please try again.');
        } finally {
            setLoading(false);
        }




    };

    const registerINPROGRESS = () => {

        setLoading(true);
        setError('');

    };

    const submitEvent = () => {
            
            if (authenticate()) {
    
                userInfo.setAuth(true);
                userInfo.setUser(username);
                navigate('/');
    
            }
    
            else {
    
                setLoading(false);
                return(
    
                    <Alert severity="error">
                        <AlertTitle>Error</AlertTitle>
                        Invalid email or password
                    </Alert>
    
                );
    
            }
    
    };

    

    return(

        <Box

            sx = {{
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
                justifyContent: 'center',
                height: '100vh',
                backgroundColor: useDark.darkMode ? '#333' : '#fff',
                color: useDark.darkMode ? '#fff' : '#333'
            }}

        >

            <Typography variant="h3" gutterBottom
                sx={{
                    marginBottom: '1rem',
                    color: useDark.darkMode ? '#fff' : '#333',
                    fontFamily: 'klee one'
                }}
            >
                上手
            </Typography>

            <TextField
                label="Email"
                variant="outlined"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                sx={{marginBottom: '1rem'}}
            />

            <TextField
                label="Password"
                variant="outlined"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                sx={{marginBottom: '1rem'}}
            />

            <Button
                variant="contained"
                onClick={() => submitEvent()}
                sx={{marginBottom: '1rem'}}

            >
                Login

            </Button>

            


        </Box>




    );


}

export default Login;
