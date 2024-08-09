import axios from 'axios';

// Base API link (you might need to define this or import it from a config file)
const baseAPILink = 'http://your-api-base-url.com';

// Axios-based API call function
async function apiCall(endpoint, method, data) {
    const url = `${baseAPILink}${endpoint}`;
    const options = {
        method: method,
        headers: {
            'Content-Type': 'application/json',
        },
        data: data // 'data' is used for the request body in axios
    };

    try {
        const response = await axios(url, options);
        return response.data;
    } catch (error) {
        console.error("API call failed:", error);
        throw error; // Re-throw the error to handle it in the calling function
    }
}

export default apiCall;