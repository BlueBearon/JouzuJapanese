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
import { useNavigate } from 'react-router-dom';
import apiCall from './APIFunctions';

// URL for the registration endpoint
let registerLink = "http://localhost:8080/register";

/**
 * Register component for user registration.
 * 
 * This component renders a registration form and handles the registration process.
 * It uses Material-UI components for styling and React hooks for state management.
 */
function Register() {
    // Contexts for user information and theme
    const userInfo = React.useContext(userContext);
    const useDark = React.useContext(darkContext);
    const navigate = useNavigate();

    // State variables for form inputs and status messages
    const [username, setUsername] = React.useState('');
    const [password, setPassword] = React.useState('');
    const [loading, setLoading] = React.useState(false);
    const [error, setError] = React.useState('');
    const [success, setSuccess] = React.useState('');

    /**
     * Handles the registration process.
     * 
     * Sends a POST request to the registration endpoint with the username and password.
     * Updates the state based on the response.
     */
    const register = async () => {
        setLoading(true);
        setError('');
        setSuccess('');

        try {
            const result = await apiCall(registerLink, 'POST', { username, password });

            setSuccess('User registered successfully');
            setTimeout(() => navigate('/login'), 2000);
        } catch (error) {
            if (error.response && error.response.data) {
                setError(error.response.data.error || 'Registration failed');
            } else {
                setError('An error occurred. Please try again.');
            }
        } finally {
            setLoading(false);
        }
    };


    /**
     * Handles form submission.
     * 
     * Prevents the default form submission behavior and calls the register function.
     * 
     * @param {React.FormEvent} e - The form submission event.
     */
    const handleSubmit = (e) => {
        e.preventDefault();
        register();
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
                Register
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

                {success && (
                    <Alert severity="success" sx={{ marginBottom: '1rem' }}>
                        {success}
                    </Alert>
                )}

                <Button
                    variant="contained"
                    type="submit"
                    sx={{ marginBottom: '1rem' }}
                    disabled={loading}
                    fullWidth
                >
                    {loading ? <CircularProgress size={24} /> : 'Register'}
                </Button>
            </form>
        </Box>
    );
}

export default Register;