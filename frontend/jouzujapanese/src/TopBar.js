import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import MenuBookIcon from '@mui/icons-material/MenuBook';
import School from '@mui/icons-material/School';
import DarkModeIcon from '@mui/icons-material/DarkMode';
import LightModeIcon from '@mui/icons-material/LightMode';
import AccountCircle from '@mui/icons-material/AccountCircle';
import Edit from '@mui/icons-material/Edit';
import Switch from '@mui/material/Switch';
import Label from '@mui/material/FormLabel';
import Menu from '@mui/material/Menu';
import MenuItem from '@mui/material/MenuItem';
import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';
import '@fontsource/klee-one';
import { Button } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { darkContext } from './App';
import { userContext } from './App';


function TopBar() {

    const useDark = React.useContext(darkContext);
    const userInfo = React.useContext(userContext);
    //userInfo = {user, setUser, auth, setAuth}
    const navigate = useNavigate();

    const [anchorEl, setAnchorEl] = React.useState(null);
    const open = Boolean(anchorEl);

    const handleMenu = (event) => {
        setAnchorEl(event.currentTarget);
    };

    const handleClose = () => {
        setAnchorEl(null);
    };

    const logOut = () => {
        setAnchorEl(null);

        userInfo.setUser(null);
        userInfo.setAuth(false);

        navigate('/');
    }


    const navigateHome = () => {
            
        navigate('/');
    
    };

    const navigateLessons = () => {

        navigate('/lessons');

    };

    const navigateDiary = () => {

        // Authenticated users can access the Diary page

        //Not Implemented Yet

        //For now just navigate to the Diary page

        navigate('/diary');

    };







    return(

        <Box sx={{ flexGrow: 1 }}>
            <AppBar position="static">
                <Toolbar disableGutters sx={{marginLeft: '1rem', display: 'flex', alignItems: 'center'}}>

                    <Box
                        sx={{ display: 'flex', alignItems: 'center', flexGrow: 1}}
                    >
                        <img src= "JouzuLogo.png" 
                        alt="Jouzu Logo" 
                        width="100" 
                        height="75"
                        onClick={() => navigateHome()}
                        />

                        <Box sx={{ display: { xs: 'none', md: 'flex', marginLeft: '1rem' }}}>
                            <Button color="inherit"
                            sx={{ my: 2, color: 'white', display: 'block', fontFamily: 'klee one', fontSize: '1rem', marginRight: '1rem' }}

                            onClick={() => navigateLessons()}
                            >
                                <Box sx={{ display: 'flex', alignItems: 'center' }}>
                                    <School sx={{marginRight: '0.75rem'}}/>
                                    Lessons
                                </Box>
                            </Button>

                            <Button color="inherit"
                            sx={{ my: 2, color: 'white', display: 'block', fontFamily: 'klee one', fontSize: '1rem', marginRight: '1rem' }}

                            >
                                <Box sx={{ display: 'flex', alignItems: 'center' }}>
                                    <Edit sx={{marginRight: '0.75rem'}}/>
                                    Practice
                                </Box>
                            </Button>

                            {userInfo.auth ? <Button color="inherit"
                                sx={{ my: 2, color: 'white', display: 'block', fontFamily: 'klee one', fontSize: '1rem' }}

                                onClick={() => navigateDiary()}
                            >
                                <Box sx={{ display: 'flex', alignItems: 'center' }}>
                                    <MenuBookIcon sx={{marginRight: '0.75rem'}}/>
                                    Diary
                                </Box>
                            </Button> : null}
                            
                        </Box>
                    </Box>

                    <Box sx = {{ display: 'flex', alignItems: 'center'}}>

                    {/* Dark Mode Switch */}

                    <Box
                    sx={
                        { 
                            display: 'flex', alignItems: 'center', marginRight: '1rem' }
                    }

                    >
                    
                        <Switch
                            color="default"
                            sx={{

                                '& .MuiSwitch-thumb': {backgroundColor: useDark.darkMode ? '#000' : '#fff'},
                                '& .MuiSwitch-track': {backgroundColor: useDark.darkMode ? '#fff' : '#000'},
                                '& .MuiSwitch-switchBase': {color: useDark.darkMode ? '#fff' : '#000'},
                                '& .MuiSwitch-root': {color: useDark.darkMode ? '#fff' : '#000'}



                        
                        }}
                            onChange = {() => useDark.setDarkMode(!useDark.darkMode)}
                        />
                        {
                            useDark.darkMode ? <DarkModeIcon sx={{color: 'white'}}/> : <LightModeIcon sx={{color: 'white'}}/>
                        }

                    </Box>

                    {
                        !userInfo.auth ? 
                        <Button color="inherit"
                            sx={{ my: 2, color: 'white', display: 'block', fontFamily: 'klee one', fontSize: '1rem', marginRight: '1rem'}}

                            onClick={() => navigate('/login')}
                        >
                            Login
                        </Button>
                        :
                        <Button color="inherit"
                            sx={{
                                 my: 2, color: 'white', display: 'block', fontFamily: 'klee one', fontSize: '1rem', marginRight: '1rem',
                                 display: 'flex', alignItems: 'center', justifyItems: 'center'
                                }}

                            onClick={handleMenu}
                        >
                            <AccountCircle
                            sx = {{
                                marginRight: '0.5rem',
                                size: '2rem'

                        }}
                            />
                        </Button>
                        
                    }

                    <Menu
                        anchorEl={anchorEl}
                        open={open ? 'basic-menu' : undefined}
                        aria-haspopup="true"
                        aria-expanded={open ? 'true' : undefined}
                        onClose={handleClose}
                        >
                        <MenuItem onClick={logOut}>Logout</MenuItem>
                    </Menu>




                    </Box>
                    
                </Toolbar>
            </AppBar>
        </Box>


    );


}

export default TopBar;

