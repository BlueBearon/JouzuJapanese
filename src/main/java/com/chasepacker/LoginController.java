/**
 * LoginController.java
 * 
 * Description: This class is a RestfulAPI used to handle login and registration requests.
 * 
 * Author: Chase Packer
 * Date: 2024-08-01
 * Version: 1.0
 * 
 * NOT FOR REUSE WITHOUT PERMISSION
 */


package com.chasepacker;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


/**
 * LoginController
 * 
 * This class is a RestfulAPI used to handle login and registration requests.
 * 
 * The class has two endpoints:
 * 
 * 1. POST /login
 * 
 * This endpoint is used to validate the user's login credentials. The request
 * body should contain the username and password. If the credentials are valid,
 * the endpoint returns a token. If the credentials are invalid, the endpoint
 * returns an error message.
 * 
 * 2. POST /register
 * 
 * This endpoint is used to register a new user. The request body should contain
 * the username and password. If the username already exists, the endpoint
 * returns an error message. If the user is successfully registered, the
 * endpoint returns a success message.
 * 
 * The class uses the DBManager class to interact with the database. The 
 * PasswordEncoder class is used to encode the user's password before storing it
 * in the database.
 * 
 * The LoginRequest class is a simple POJO used to represent the request body. 
 */
@RestController
public class LoginController {

    @Autowired
    private DBManager dbManager; // Used to interact with the database

    /**
     * This endpoint is used to validate the user's login credentials. The request
     * body should contain the username and password. If the credentials are valid,
     * the endpoint returns a token. If the credentials are invalid, the endpoint
     * returns an error message.
     * @param req - The request body containing the username and password
     * @return - A ResponseEntity containing the token or an error message
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest req) {

        System.out.println("**************************");
        System.out.println("LoginController.java: Recieved login request");
        System.out.println("    Username: " + req.getUsername());
        System.out.println("    Password: " + req.getPassword());




        Map<String, String> response = new HashMap<>();
        try {

            String token = validateLogin(req);

            System.out.println("    Login successful");
            System.out.println("    Token: " + token);
            System.out.println("**************************");


            TokenValidationResponse tokenValidationResponse = TokenUtil.validateToken(token);

            System.out.println("    Token validation response: " + tokenValidationResponse.isValid());

            response.put("token", token);
            return ResponseEntity.ok(response);
        } 
        catch (Exception e) {

            System.out.println("    Login failed");
            System.out.println("    " + e.getMessage());
            System.out.println("**************************");

            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping("/token")
    public ResponseEntity<Map<String, String>> loginWithToken(@RequestBody LoginRequest req) {


        System.out.println("**************************");
        System.out.println("Recieved login with token request");
        System.out.println("Token: " + req.getPassword());


        Map<String, String> response = new HashMap<>();
        try {
            TokenValidationResponse tokenValidationResponse = TokenUtil.validateToken(req.getPassword());

            System.out.println("Token validation response: " + tokenValidationResponse.isValid());

            if (tokenValidationResponse.isValid()) {
                response.put("username", tokenValidationResponse.getUsername());
                
                System.out.println("username: " + tokenValidationResponse.getUsername());
                System.out.println("**************************");

                return ResponseEntity.ok(response);
            } else {

                System.out.println("Invalid token");
                System.out.println("**************************");


                response.put("error", "Invalid token");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } catch (Exception e) {

            System.out.println("Error validating token");
            System.out.println("**************************");

            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    /**
     * This endpoint is used to register a new user. The request body should contain
     * the username and password. If the username already exists, the endpoint
     * returns an error message. If the user is successfully registered, the
     * endpoint returns a success message.
     * @param req - The request body containing the username and password
     * @return - A ResponseEntity containing a success message or an error message
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody LoginRequest req) {

        System.out.println("**************************");
        System.out.println("LoginController.java: Recieved register request");
        System.out.println("    Username: " + req.getUsername());
        System.out.println("    Password: " + req.getPassword());
        System.out.println("");

        try{
            if (dbManager.userExists(req.getUsername())) {

                System.out.println("    Username already exists");
                System.out.println("**************************");


                return ResponseEntity.status(HttpStatus.CONFLICT).body("    Username already exists");
            }

            System.out.println("    Confirmed user does not yet exist, proceeding to create new user");
            System.out.println("");
        }
        catch (Exception e) {

            System.out.println("    Error checking if user exists");
            System.out.println("**************************");


            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        
        try {

            System.out.println("    Attempting database operation to create new user");
            System.out.println("");

            dbManager.createNewUser(req.getUsername(), req.getPassword()); //Password will be encoded by the DBManager

            System.out.println("    User registered successfully");
            System.out.println("**************************");

            return ResponseEntity.ok("User registered successfully");
        } catch (DBManager.UsernameExistsException e) {

            System.out.println("    Username already exists");
            System.out.println("**************************");

            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
        catch (Exception e) {

            System.out.println("    Error registering user");
            System.out.println("");
            System.out.println("    " + e.getMessage());
            System.out.println("**************************");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    public class PasswordIncorrectException extends Exception {
        public PasswordIncorrectException(String message) {
            super(message);
        }
    } 

    /**
     * This method validates the user's login credentials. It checks if the user
     * exists in the database and if the password is correct. If the credentials
     * are valid, it generates a token and returns it.
     * @param req - The request body containing the username and password
     * @return - The generated token
     * @throws Exception - If the user does not exist or the password is incorrect
     */
    private String validateLogin(LoginRequest req) throws UsernameNotFoundException, PasswordIncorrectException, SQLException {
        if (!dbManager.userExists(req.getUsername())) {

            System.out.println("    User does not exist");
            throw new UsernameNotFoundException("User not found");
        }

        // See if username, password pair exists in database
        if (!dbManager.passwordCorrect(req.getUsername(), req.getPassword()))
        {

            System.out.println("    Password incorrect");

            throw new PasswordIncorrectException("Invalid password");
        }

        System.out.println("    Password correct");
        System.out.println("    Generating token");

        String token = TokenUtil.generateToken(req.getUsername());

        System.out.println("    Token generated");

        // Generate Token (this is a placeholder, implement your token generation logic)
        return token;
    }
}

/**
 * LoginRequest
 * 
 * This class is a simple POJO used to represent the request body for the login
 * and register endpoints. It contains the username and password fields.
 */
class LoginRequest {
    private String username;
    private String password;

    /**
     * Constructor
     * @param username
     * @param password
     */
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * getUsername
     * 
     * @return - The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * setUsername
     * 
     * @param username - The username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getPassword
     * 
     * @return - The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword
     * 
     * @param password - The password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}