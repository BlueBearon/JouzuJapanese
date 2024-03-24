import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import { Typography } from '@mui/material';
import Divider from '@mui/material/Divider';
import Badge from '@mui/material/Badge';
import Calendar from 'react-calendar';
import './Calendar.css';
import ListItemText from '@mui/material/ListItemText';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import { Editor, EditorState } from 'draft-js';
import { darkContext } from './App';
import { userContext } from './App';
import { useNavigate } from 'react-router-dom';



function Diary() {

    const navigate = useNavigate();

    const userInfo = React.useContext(userContext);

    //Default to today's date
    const [diaryDate, setDiaryDate] = React.useState(new Date());

    const [editorState, setEditorState] = React.useState(() => EditorState.createEmpty());

    const useDark = React.useContext(darkContext).darkMode;

    const darkShade = '#282c34';

    const clearContent = () => {
        setEditorState(() => EditorState.createEmpty());
    };

    const save = () => {

        //Save the content of the editor to the database

        //Not Implemented Yet

    };

    const updateKanjiCount = () => {

        const content = editorState.getCurrentContent().getPlainText();

        for(let i = 0; i < content.length; i++){

            if(content.charCodeAt(i) >= 19968 && content.charCodeAt(i) <= 40869){

                uniqueKanji.add(content.charAt(i));

            }
    
        }

        return uniqueKanji.size;
    
    };

    const handleDateChange = (date) => {

        //Save the current diary entry
        //Not Implemented Yet

        //Clear the editor
        clearContent();

        setDiaryDate(date);

        //Retrieve the diary entry for the given date
        //Not Implemented Yet

        
    };

    const checkDiaryEntry = (date) => {

        //Check if there is a diary entry for the given date

        //Not Implemented Yet  
        
        return false;

    };

    const retrieveDiaryEntry = (date) => {

        //Retrieve the diary entry for the given date

        //Not Implemented Yet

    };

    const tileContent = ({ date, view }) => {
        // Check if there is a diary entry for this date
        const hasDiaryEntry = checkDiaryEntry(date);
        // If there is a diary entry and we're in the month view, render a badge
        if (view === 'month' && hasDiaryEntry) {
          return <div className="badge"></div>;;
        }
      };


    React.useEffect(() => {

        if(userInfo.auth === false){

            navigate('/login');

        }   
    }, [userInfo.auth]);

    React.useEffect(() => {
        if(useDark){
            document.documentElement.style.setProperty('--background-color', '#282c34');
            document.documentElement.style.setProperty('--text-color', '#f5f3e7');
        }
        else{
            document.documentElement.style.setProperty('--background-color', '#f5f3e7');
            document.documentElement.style.setProperty('--text-color', 'black');
        }

    }, [useDark]);

    const uniqueKanji = new Set();

    if(userInfo.auth)
    {
        return(
            <Box
                sx={
                    {
                        display: 'flex',
                        flexDirection: 'column',
                        height: '100vh',
                        width: '100vw',
                        backgroundColor: useDark ? darkShade : 'white',
                    
                    }
                }
                >

                <Box
                    sx={
                        {
                            display: 'flex',
                            justifyContent: 'space-around',
                            flexDirection: 'row',
                            height: '50%',
                            width: '100%',
                        }
                    }
                >

                    <Box
                    sx={
                        {
                            width: '35vw',
                            height: '70vh',
                            marginTop: '4rem',
                            borderRadius: '1rem',
                            padding: '1rem',
                        }
                    }
                    >{/*Calendar Box */}

                        <Calendar
                            onChange={handleDateChange}
                            tileContent={tileContent}
                            value={diaryDate}
                            
                        />

                    </Box>



                    <Box
                        sx={{

                            width: '50vw',
                            height: '90vh',

                        }}
                    >

                        <Box
                            sx={
                                {
                                    display: 'flex',
                                    flexDirection: 'row',
                                    justifyContent: 'center',
                                    marginTop: '1rem',
                                }
                            }
                            >

                            <Typography variant="h5"
                                sx={{
                                    fontFamily: 'klee one',
                                    textAlign: 'center',
                                    color: useDark ? '#f5f3e7' : 'black',
                                
                                }}
                            >
                                {diaryDate.toDateString()}
                            </Typography>

                            <Divider orientation="horizontal" flexItem/>

                            </Box>
                    
                        <Box
                        sx={
                            {
                                width: '47vw',
                                height: '70vh',
                                border: useDark ? '1px solid white' : '1px solid black',
                                marginTop: '1rem',
                                borderRadius: '1rem',
                                padding: '1rem',
                                backgroundColor: useDark ? darkShade : '#f5f3e7',
                                color: useDark ? '#f5f3e7' : 'black',
                                display: 'flex',
                                flexDirection: 'column',
                                justifyContent: 'space-between',
                                
                            }
                        }
                        >{/*Diary Box */}

                            <Editor editorState={editorState} onChange={setEditorState} height="55vh"
                            fontFamily = "klee one"/>

        
                        </Box>

                        

                        <Box /*Stats*/ 
                        
                        sx={
                            {
                                display: 'flex',
                                flexDirection: 'row', 
                                marginTop: '1rem',
                                marginLeft: '1rem',
                                marginBottom: '1rem',
                                scrollMarginBottom: '1rem',
                                color: useDark ? '#f5f3e7' : 'black',
                            }
                        }
                        >

                        <Button
                            onClick = {clearContent}
                            sx = {{
                                marginRight: '1rem',
                            }}
                            > 
                                Clear
                        </Button>

                        <Button
                            onClcik = {save}
                            sx = {{
                                marginRight: '1rem',
                            }}
                            >
                                Save
                        </Button>


                            <Box
                            
                            sx={{
                                display: 'flex',
                                flexDirection: 'row',
                            }}>

                            </Box>

                            <Box
                                sx={
                                    {
                                        width: '47vw',
                                        display: 'flex',
                                        flexDirection: 'row',
                                        justifyItems: 'center',

                                    }
                                }
                            >
                                <Box
                                sx={{
                                    display: 'flex',
                                    flexDirection: 'row',
                                    alignItems: 'center',
                                    marginRight: '2rem',
                                
                                }}
                                >
                                    <ListItemAvatar
                                    sx={{
                                        fontFamily: 'klee one',
                                        marginRight: '1rem',
                                    }}>
                                        文字数
                                    </ListItemAvatar>
                                    {/*Secondary color needs to change with everything else in dark mode*/}
                                    <ListItemText primary="Character Count" secondary={editorState.getCurrentContent().getPlainText().length} 
                                    secondaryTypographyProps={{style: {color: useDark ? '#f5f3e7' : 'black'}}}
                                    />
                                </Box>
                                <Box
                                sx={{
                                    display: 'flex',
                                    flexDirection: 'row',
                                    alignItems: 'center',
                                
                                }}
                                >
                                    <ListItemAvatar
                                    sx={{
                                        fontFamily: 'klee one',
                                        marginRight: '0.7rem',
                                    }}>
                                        漢字
                                    </ListItemAvatar>
                                    <ListItemText primary="Unique Kanji" secondary={updateKanjiCount()} 
                                    secondaryTypographyProps={{style: {color: useDark ? '#f5f3e7' : 'black'}}}/>
                                </Box>
                                
                            </Box>

                        </Box>



                    </Box>

                </Box>

            </Box>
        );
    }

    return null;

}

export default Diary;