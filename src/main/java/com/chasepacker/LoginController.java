package com.chasepacker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DBManager dbManager;

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

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody LoginRequest req) {
        if (dbManager.userExists(req.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }

        String encodedPassword = passwordEncoder.encode(req.getPassword());
        try {
            dbManager.createNewUser(req.getUsername(), encodedPassword);
            return ResponseEntity.ok("User registered successfully");
        } catch (DBManager.UsernameExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

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

class LoginRequest {
    private String username;
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}