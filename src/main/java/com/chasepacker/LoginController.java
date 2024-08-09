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

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.chasepacker.DBManager.ConnectionFailedException;

import jakarta.annotation.PostConstruct;

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
    private PasswordEncoder passwordEncoder; // Used to encode the user's password

    @Autowired
    private DBManager dbManager; // Used to interact with the database


    @PostConstruct
    public void init()
    {
        try {
            dbManager = new DBManager();
        } catch (ConnectionFailedException e) {
            e.printStackTrace();
        }
        
    }


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
        Map<String, String> response = new HashMap<>();
        try {
            String token = validateLogin(req);
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }


    @PostMapping("/login/token")
    public ResponseEntity<Map<String, String>> loginWithToken(@RequestBody TokenLoginRequest req) {
        Map<String, String> response = new HashMap<>();
        try {
            TokenValidationResponse tokenValidationResponse = TokenUtil.validateToken(req.getToken());
            if (tokenValidationResponse.isValid()) {
                response.put("username", tokenValidationResponse.getUsername());
                return ResponseEntity.ok(response);
            } else {
                response.put("error", "Invalid token");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } catch (Exception e) {
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

        try{
            if (dbManager.userExists(req.getUsername())) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
            }
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        

        String encodedPassword = passwordEncoder.encode(req.getPassword());
        try {
            dbManager.createNewUser(req.getUsername(), encodedPassword);
            return ResponseEntity.ok("User registered successfully");
        } catch (DBManager.UsernameExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
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
    private String validateLogin(LoginRequest req) throws Exception {
        if (!dbManager.userExists(req.getUsername())) {
            throw new Exception("User does not exist");
        }

        if (!dbManager.passwordCorrect(req.getUsername(), req.getPassword())) {
            throw new Exception("Invalid password");
        }

        // Generate Token (this is a placeholder, implement your token generation logic)
        return "generated_token";
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

class TokenLoginRequest {
    private String token;

    public TokenLoginRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}