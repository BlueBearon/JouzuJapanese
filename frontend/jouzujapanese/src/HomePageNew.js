import * as React from 'react';
import Box from '@mui/material/Box';
import Accordion from '@mui/material/Accordion';
import AccordionActions from '@mui/material/AccordionActions';
import AccordionSummary from '@mui/material/AccordionSummary';
import AccordionDetails from '@mui/material/AccordionDetails';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import backgroundImage from './HomePageBanner.jpg';
import { Typography } from '@mui/material';
import { darkContext } from './App';



function HomePage() {

    const useDark = React.useContext(darkContext).darkMode;



    return(

        <Box
        sx={{
            color: useDark ? '#f5f3e7' : 'black',
            backgroundColor: useDark ? '#333333' : 'white',
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            height: '100vh',
        }}
        >

            <Box
                sx={{
                    backgroundImage: `url(${backgroundImage})`,
                    backgroundSize: 'cover',
                    backgroundPosition: 'center',
                    height: '25rem',
                    display: 'flex',
                    flexDirection: 'column',
                    alignContent: 'center',
                    justifyContent: 'center',
                    fontFamily: 'klee one',
                    fontSize: '3rem',
                    color: 'white',
                    textAlign: 'center',
                    width: '100%',
                }}
            >

                <Typography variant="h1"
                sx={{
                    fontFamily: 'klee one',
                    textShadow: '2px 2px 4px #000000'
                }}>
                    上手へようこそ！
                </Typography>

                <Typography variant="h2"
                sx={{
                    fontFamily: 'klee one',
                    textShadow: '2px 2px 4px #000000',
                }}>
                    Welcome to Jouzu!
                </Typography>
            

            </Box>

            <Accordion

                sx={{
                    color: useDark ? '#f5f3e7' : 'black',
                    backgroundColor: useDark ? '#333333' : 'white',
                    width: '70vw',
                    marginTop: '2rem',
                }}
            >

                <AccordionSummary
                    expandIcon={<ExpandMoreIcon />}
                    aria-controls="panel1a-content"
                    id="panel1a-header"
                    sx={
                        {
                            height: '5rem',
                            fontFamily: 'klee one',
                        
                        }}
                >
                    What is Jouzu?
                </AccordionSummary>
                <AccordionDetails sx={
                    {
                    fontFamily : 'klee one'
                    }
                    }>
                    In Japanese, "上手" (Jouzu) means "skillful" or "good at". Hence, this website aims
                    to provide tools and resources to help you learn and improve at your Japanese skills. 
                    頑張りましょう!Let's do our best!
                </AccordionDetails>
            </Accordion>
            <Accordion
            sx={{
                color: useDark ? '#f5f3e7' : 'black',
                backgroundColor: useDark ? '#333333' : 'white',
                width: '70vw',
            }}
            >

                <AccordionSummary
                    expandIcon={<ExpandMoreIcon />}
                    aria-controls="panel1a-content"
                    id="panel1a-header"
                    sx={
                        {
                            height: '5rem',
                            fontFamily: 'klee one',
                        }}
                >
                    What can I do on this website?
                </AccordionSummary>
                <AccordionDetails sx={
                    {
                    fontFamily : 'klee one'
                    }
                    }>
                    Right now, you can review Lessons on various beginner topics in the Lesson tab.
                    Additionally, you can practice your Japanese writing skills by keeping a daily diary in the Diary tab.
                </AccordionDetails>
            </Accordion>

            <Accordion
            sx={{
                color: useDark ? '#f5f3e7' : 'black',
                backgroundColor: useDark ? '#333333' : 'white',
                width: '70vw',
            }}
            >

                <AccordionSummary
                    expandIcon={<ExpandMoreIcon />}
                    aria-controls="panel1a-content"
                    id="panel1a-header"
                    sx={
                        {
                            height: '5rem',
                            fontFamily: 'klee one',
                        }}
                >   
                    Why a diary?
                </AccordionSummary>

                <AccordionDetails sx={
                    {
                    fontFamily : 'klee one'
                    }
                    }>
                    <Typography variant="body1" sx={{fontFamily: 'klee one'}}>
                        As much as we tend to procrastinate and cram all the content we need to learn the night before a test, learning a language comes down to consistent daily effort.
                    </Typography>
                    <br/>
                    <Typography variant="body1" sx={{fontFamily: 'klee one'}}>
                        We learn best when we regularly practice and are exposed to the language we are trying to learn.
                    </Typography>
                    <br/>
                    <Typography variant="body1" sx={{fontFamily: 'klee one'}}>
                        Hence, if we should practice Japanese daily, why not keep a diary in Japanese? This way, you can practice your writing skills on a regular basis.
                    </Typography>
                    <br/>
                    <Typography variant="body1" sx={{fontFamily: 'klee one'}}>
                        Furthermore, you can look back on your diary entries and see how much you have improved over time.
                    </Typography>
                </AccordionDetails>
            </Accordion>
        </Box>
        

    );

}

export default HomePage;
