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

import apiCall from './APIFunctions';

// API Links
let baseAPILink = "https://jouzujapanesebackend-768f8f815a31.herokuapp.com/api/";
let backendAPILink = "http://localhost:8080/diary/";

// API Endpoints
let getEntryEndpoint = "getEntry";
let createEntryEndpoint = "createEntry";
let updateEntryEndpoint = "updateEntry";
let deleteEntryEndpoint = "deleteEntry";
let getDiaryDatesEndpoint = "getDiaryDates";

// Data packaging functions
function getEntryDataPackaging(day) {
    return {
        date: day,
        token: localStorage.getItem('token')
    };
}

function diaryEntryDataPackaging(day, content) {
    return {
        date: day,
        entry: content,
        token: localStorage.getItem('token')  
    };
}

function diaryDateDataPackaging(sDate, eDate) {
    return {
        startDate: sDate,
        endDate: eDate,
        token: localStorage.getItem('token')
    };
}





function Diary() {

    const navigate = useNavigate();
    const userInfo = React.useContext(userContext);

    //Default to today's date
    const [diaryDate, setDiaryDate] = React.useState(new Date());
    const [editorState, setEditorState] = React.useState(() => EditorState.createEmpty());

    //Dates with diary entries, in a O(1) lookup structure
    const datesWithEntries = React.useRef(new Set());

    const useDark = React.useContext(darkContext).darkMode;
    const darkShade = '#282c34';
    const token = localStorage.getItem('token');


    //For the initial load and when the date changes
        //Get the list of dates with diary entries for the current month
        //Get the diary entry for the current date


    const updateDatesWithEntries = async () => {

        const startDate = new Date(diaryDate.getFullYear(), diaryDate.getMonth(), 1);
        const endDate = new Date(diaryDate.getFullYear(), diaryDate.getMonth() + 1, 0);

        const data = diaryDateDataPackaging(startDate, endDate);


        try
        {
            console.log("Getting diary dates: ");

            let response = await apiCall(getDiaryDatesEndpoint, 'GET', data);

            console.log("Response: ", response);

            //Clear current set
            datesWithEntries.current.clear();

            //Add the dates to the set

            let dates = response.dates.split(", ");

            for(let i = 0; i < dates.length; i++){

                datesWithEntries.current.add(new Date(dates[i]));

            }

            
        }
        catch(error)
        {
            
            if(error.response && error.response.data)
            {
                console.error("Error getting diary dates: ", error.response.data.error);
            }
            else
            {
                console.error("Error getting diary dates: ", error.message);
            }
        }


    };


    //Get list of dates with diary entries for the current month
    React.useEffect(() => {

        updateDatesWithEntries();

    }, [diaryDate]);


    /**
     * Clears the content of the editor
     *
     */
    const clearContent = () => {
        setEditorState(() => EditorState.createEmpty());

        //Clear the unique kanji set
        uniqueKanji.clear();
    };

    /**
     * Saves the content of the editor to the database
     * 
     * If the content is empty, delete the entry
     * 
     * If the entry already exists, update it
     * 
     * If the entry does not exist, create it
     * 
     */
    const save = async () => {

        const content = editorState.getCurrentContent().getPlainText();

        const data = diaryEntryDataPackaging(diaryDate, content);

        let update = datesWithEntries.current.has(diaryDate);

        let empty = content.length === 0;

        if(empty && update){

            apiCall(deleteEntryEndpoint, 'POST', data);

            datesWithEntries.current.delete(diaryDate);
  
        }
        else if(update){

            apiCall(updateEntryEndpoint, 'POST', data);

        }
        else{

            apiCall(createEntryEndpoint, 'POST', data);

            datesWithEntries.current.add(diaryDate);

        }

    };

    /**
     * Updates the unique kanji count
     * 
     * @returns {number} The number of unique kanji in the editor
     * 
     */
    const updateKanjiCount = () => {

        const content = editorState.getCurrentContent().getPlainText();

        for(let i = 0; i < content.length; i++){

            if(content.charCodeAt(i) >= 19968 && content.charCodeAt(i) <= 40869){

                uniqueKanji.add(content.charAt(i));

            }
    
        }

        return uniqueKanji.size;
    
    };

    /**
     * Handles the date change in the diary
     * 
     * Saves the current diary entry, clears the editor, 
     * and retrieves the diary entry for the given date
     * 
     * 
     * @param {*} date 
     */
    const handleDateChange = async (date) => {


        try{

            console.log("Changing date: ", date);

            //Save the current diary entry
            console.log("Saving current entry: ");
            save();
            console.log("Current entry saved.");

            //Clear the editor, but not the data for the day
            console.log("Clearing editor: ");
            setEditorState(() => EditorState.createEmpty());
            console.log("Editor cleared.");

            //Update the diary date
            console.log("Updating diary date: ");
            setDiaryDate(date);
            console.log("Diary date updated.");

            //Retrieve the diary entry for the given date
            console.log("Retrieving diary entry: ");
            retrieveDiaryEntry(date);
            console.log("Diary entry retrieved.");

        }
        catch(error)
        {
            console.error("Error changing date: ", error.message);
        }
        
        
    };

    /**
     * Checks if there is a diary entry for the given date
     * 
     * @param {*} date 
     * @returns {boolean} True if there is a diary entry for the given date, false otherwise
     */
    const checkDiaryEntry = (date) => {

        return datesWithEntries.current.has(date);

    };

    /**
     * Retrieves the diary entry for the given date
     * 
     * @param {*} date
     * 
     * @returns {string} The diary entry for the given date
     * 
     */
    const retrieveDiaryEntry = async (date) => {

        const data = getEntryDataPackaging(date);

        let response = await apiCall(getEntryEndpoint, 'GET', data);

        setEditorState(() => EditorState.createWithContent(response.entry));

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
                            onClick = {save}
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