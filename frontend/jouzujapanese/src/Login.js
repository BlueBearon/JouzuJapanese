import * as React from 'react';
import { Button } from '@mui/material';
import { userContext } from './App';
import { darkContext } from './App';
import { TextField } from '@mui/material';
import { Box } from '@mui/material';
import { Typography } from '@mui/material';
import { Alert } from '@mui/material';
import { CircularProgress } from '@mui/material';
import { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import apiCall from './APIFunctions';

// URL for the login endpoint
let loginEndpoint = "login";

/**
 * Login component for user authentication.
 * 
 * This component renders a login form and handles the authentication process.
 * It uses Material-UI components for styling and React hooks for state management.
 */
function Login() {
    // Contexts for user information and theme
    const userInfo = React.useContext(userContext);
    const useDark = React.useContext(darkContext);
    const navigate = useNavigate();

    // State variables for form inputs and status messages
    const [username, setUsername] = React.useState('');
    const [password, setPassword] = React.useState('');
    const [loading, setLoading] = React.useState(false);
    const [error, setError] = React.useState('');

    /**
     * Handles the authentication process.
     * 
     * Sends a POST request to the login endpoint with the username and password.
     * Updates the state based on the response.
     */
    const authenticate = async () => {

        console.log("********************************************");
        console.log("Authenticating user");


        setLoading(true);
        setError('');
    
        try {
            const result = await apiCall(loginEndpoint, 'POST', { username, password });

            console.log("Login successful: ", result);
            console.log("Token: ", result.token);
            console.log("********************************************");
    
            userInfo.setAuth(true);
            userInfo.setUser(username);
            localStorage.setItem('token', result.token);
            navigate('/');
        } catch (error) {
            if (error.response && error.response.data) {
                console.error("Login failed: ", error.response.data.error);
                console.log("********************************************");
                setError(error.response.data.error || 'Invalid email or password');
            } else {
                console.error("Login failed: ", error.message);
                console.log("********************************************");
                setError('An error occurred. Please try again.');
            }
        } finally {
            setLoading(false);
        }
    };


    const testOtherEndpoint = async () => { 

    }

    /**
     * Handles form submission.
     * 
     * Prevents the default form submission behavior and calls the authenticate function.
     * 
     * @param {React.FormEvent} e - The form submission event.
     */
    const handleSubmit = (e) => {
        e.preventDefault();
        authenticate();
    };

    return (
        <Box
            sx={{
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

            <form onSubmit={handleSubmit}>
                <TextField
                    label="Email"
                    variant="outlined"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    sx={{ marginBottom: '1rem' }}
                    fullWidth
                />

                <TextField
                    label="Password"
                    variant="outlined"
                    type="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    sx={{ marginBottom: '1rem' }}
                    fullWidth
                />

                {error && (
                    <Alert severity="error" sx={{ marginBottom: '1rem' }}>
                        {error}
                    </Alert>
                )}

                <Button
                    variant="contained"
                    type="submit"
                    sx={{ marginBottom: '1rem' }}
                    disabled={loading}
                    fullWidth
                >
                    {loading ? <CircularProgress size={24} /> : 'Login'}
                </Button>
            </form>

            <Typography variant="body2" sx={{ marginTop: '1rem' }}>
                Don't have an account? <Link to="/register">Register</Link>
            </Typography>

        </Box>
    );
}

export default Login;