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
import { Editor, EditorState, ContentState } from 'draft-js';
import { darkContext } from './App';
import { userContext } from './App';
import { useNavigate } from 'react-router-dom';

import apiCall from './APIFunctions';

// API Endpoints
let getEntryEndpoint = "diary/getEntry";
let createEntryEndpoint = "diary/createEntry";
let updateEntryEndpoint = "diary/updateEntry";
let deleteEntryEndpoint = "diary/deleteEntry";
let getDiaryDatesEndpoint = "diary/getDiaryDates";

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
    const [loading, setLoading] = React.useState(true);

    //Dates with diary entries, in a O(1) lookup structure
    const datesWithEntries = React.useRef(new Set());

    const useDark = React.useContext(darkContext).darkMode;
    const darkShade = '#282c34';

    //On Load
    React.useEffect(() => {
            
        if(userInfo.auth === true){
    
            initialLoad();
            
        }
    
    }, []);


    const initialLoad = async () => {

        //Get the dates with diary entries for the current month
        await updateDatesWithEntries();

        //Get the diary entry for the current date
        retrieveDiaryEntry(diaryDate);



    };


    //For the initial load and when the date changes
        //Get the list of dates with diary entries for the current month
        //Get the diary entry for the current date


    const updateDatesWithEntries = async () => {

        //Strings for Microsoft SQL Server
        let startDate = new Date(diaryDate.getFullYear(), diaryDate.getMonth(), 1);
        let endDate = new Date(diaryDate.getFullYear(), diaryDate.getMonth() + 1, 0);

        startDate = startDate.toISOString().split('T')[0];
        endDate = endDate.toISOString().split('T')[0];

        console.log("Start date: ", startDate);
        console.log("End date: ", endDate);


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

            console.log("Dates: ", dates);

            for(let i = 0; i < dates.length; i++){
                datesWithEntries.current.add(dates[i]);
            }

            console.log("Dates with entries: ", datesWithEntries.current);
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

    /**
     * Clears the content of the editor
     *
     */
    const clearContent = () => {
        setEditorState(() => EditorState.createEmpty());

        //Clear the unique kanji set
        uniqueKanji.clear();

        save();
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

        console.log(content);

        let date = diaryDate.toISOString().split('T')[0];

        const data = diaryEntryDataPackaging(date, content);

        console.log("data: ", data);

        let update = datesWithEntries.current.has(date)

        console.log("update: ", update);

        let empty = content.length === 0;

        console.log("empty: ", empty);

        try
        {

            if(empty && update){

                console.log("Deleting entry: ");

                apiCall(deleteEntryEndpoint, 'POST', data);

                console.log("Entry deleted.");

                datesWithEntries.current.delete(diaryDate);

                console.log("Dates with entries: ", datesWithEntries.current);
    
            }
            else if(update){

                console.log("Updating entry: ");

                apiCall(updateEntryEndpoint, 'POST', data);

                console.log("Entry updated.");

            }
            else if (!empty){

                console.log("Creating entry: ");

                apiCall(createEntryEndpoint, 'POST', data);

                console.log("Entry created.");

                datesWithEntries.current.add(diaryDate);

                console.log("Dates with entries: ", datesWithEntries.current);

            }

            updateDatesWithEntries();
        }
        catch(error)
        {
            if(error.response && error.response.data)
            {
                console.error("Error saving diary entry: ", error.response.data.error);
            }
            else
            {
                console.error("Error saving diary entry: ", error.message);
            }
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

            //Update the dates with entries
            console.log("Updating dates with entries: ");
            updateDatesWithEntries();
            console.log("Dates with entries updated.");

            //Retrieve the diary entry for the given date
            console.log("Retrieving diary entry: ");
            retrieveDiaryEntry(date);
            console.log("Diary entry retrieved.");

            //Update the diary date
            console.log("Updating diary date: ");
            setDiaryDate(date);
            console.log("Diary date updated.");


            return true;


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


        //Format date to String for comparison yyyy/mm/dd
        date = date.toISOString().split('T')[0];
    
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

        setLoading(true);

        const data = getEntryDataPackaging(date);

        let response = await apiCall(getEntryEndpoint, 'GET', data);

        const entry = response.entry;

        console.log("Entry: ", entry);

        const contentState = ContentState.createFromText(entry);

        setEditorState(() => EditorState.createWithContent(contentState));

        setLoading(false);

        return entry;

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

                            {loading ? (
                            <Box
                                sx={{
                                    width: '47vw',
                                    height: '70vh',
                                    display: 'flex',
                                    justifyContent: 'center',
                                    alignItems: 'center',
                                    alignSelf: 'center',
                                    alignContent: 'center',
                                }}
                            >
                                {/* Replace this with your loading graphic */}
                                <div><img src = "/loading.svg" className = "loadingsvg" alt = "Loading..."></img></div>
                            </Box>
                        ) : (
                            <Box
                                sx={{
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
                                }}
                            >
                                {/* Diary Box */}
                                <Editor 
                                    editorState={editorState} 
                                    onChange={setEditorState} 
                                    height="55vh"
                                    fontFamily="klee one"
                                />
                            </Box>
                        )}

                        

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