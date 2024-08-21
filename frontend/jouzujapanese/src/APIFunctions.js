import axios from 'axios';

// Base API link (you might need to define this or import it from a config file)
const baseAPILink = 'https://jouzujapanese-ara8dvazd4hghshc.eastus-01.azurewebsites.net/';

// Axios-based API call function
async function apiCall(endpoint, method, data) {

    console.log("");
    console.log("Recieved API Request");
    console.log("Endpoint: ", endpoint);
    console.log("");



    const url = `${baseAPILink}${endpoint}`;

    console.log("Full URL is: ", url);
    console.log("");

    let options = {};

    if(method === 'GET') //for GET requests we send parameters
    {
       var optionsObject = {
            params: data
       };

        try {

            const response = await axios(url, {params: data});
            console.log("");
            return response.data;

        }
        catch (error) {
            console.error("API call failed: ", error);
            console.log("");
            throw error; // Re-throw the error to handle it in the calling function
        }

    }
    else // for POST requests we send data
    { 
        options = {
            method: method,
            headers: {
                'Content-Type': 'application/json',
            },
            data: data // 'data' is used for the request body in axios
        };

        try{
            const response = await axios(url, options);
            console.log("");
            return response.data;
        }
        catch (error) {
            console.error("API call failed: ", error);
            console.log("");
            throw error; // Re-throw the error to handle it in the calling function
        }

    }
}




async function validateToken() {

    console.log("********************************************");
    console.log("Validating token");

    let testEndpoint = "token";

    // if token exists, add it to the headers

    const placeholder = "testuser";
    const token = localStorage.getItem('token');

    try {
        const result = await apiCall(testEndpoint, 'POST', { username: placeholder, password: token });
        console.log("API call successful: ", result);


        if(result.username)
        {
            console.log("Token is valid");
            console.log("User: ", result.username);
            console.log("********************************************");
            return result.username;
        }
        else
        {
            console.log("Token is invalid");
            console.log("********************************************");
            return null;
        }

    } catch (error) {
        console.error("API call failed: ", error);
    }

};




export default apiCall;

export { validateToken };
