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


function Login() {

    const userInfo = React.useContext(userContext);
    const useDark = React.useContext(darkContext);
    const navigate = useNavigate();

    const [email, setEmail] = React.useState('');
    const [password, setPassword] = React.useState('');

    const [loading, setLoading] = React.useState(false);


    const authenticate = () => {

        setLoading(true);
        /*
        fetch('http://localhost:5000/authenticate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                password: password
            })
        })

        .then(response => response.json();

        */

        return true;
    };

    const submitEvent = () => {
            
            if (authenticate()) {
    
                userInfo.setAuth(true);
                userInfo.setUser(email);
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
                value={email}
                onChange={(e) => setEmail(e.target.value)}
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
