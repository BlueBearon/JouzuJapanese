/**
 * DiaryController.java
 * 
 * Description: This class is a RestfulAPI used to handle diary requests.
 * 
 * Author: Chase Packer
 * Date: 2024-08-01
 * Version: 1.0
 * 
 * NOT FOR REUSE WITHOUT PERMISSION
 */

package com.chasepacker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import java.util.Map;
import java.util.HashMap;



/**
 * Controller for the diary
 * 
 * Uses functions from DBManager.java to interact with the database
 * 
 * The controller has the following endpoints:
 * 
 * 1. GET /diary/getEntry
 * 
 * This endpoint is used to get a diary entry for a specific date. The request
 * should contain the date, username, and token. If the token is valid, the
 * endpoint returns the diary entry. If the token is invalid, the endpoint returns
 * an error message.
 * 
 * 2. POST /diary/createEntry
 * 
 * This endpoint is used to create a new diary entry. The request should contain
 * the username, date, entry, and token. If the token is valid, the endpoint saves
 * the entry to the database. If the token is invalid, the endpoint returns an
 * error message.
 * 
 * 3. POST /diary/updateEntry
 * 
 * This endpoint is used to update an existing diary entry. The request should
 * contain the username, date, entry, and token. If the token is valid, the
 * endpoint updates the entry in the database. If the token is invalid, the
 * endpoint returns an error message.
 * 
 * 4. POST /diary/deleteEntry
 * 
 * This endpoint is used to delete a diary entry. The request should contain the
 * username, date, and token. If the token is valid, the endpoint deletes the entry
 * from the database. If the token is invalid, the endpoint returns an error
 * message.
 * 
 * 5. GET /diary/getDiaryDates
 * 
 * This endpoint is used to get a list of diary dates for a specific user within a
 * date range. The request should contain the user, start date, end date, and
 * token. If the token is valid, the endpoint returns a list of dates. If the token
 * is invalid, the endpoint returns an error message.
 * 
 * The controller uses the DBManager class to interact with the database.
 * 
 * The DiaryEntry class is a simple POJO used to represent the request body.
 * 
 * @see DBManager
 */
@RestController
public class DiaryController {


    @Autowired
    private DBManager dbManager = new DBManager(); // Used to interact with the database

    /**
     * Get a diary entry for a specific date
     * @param date 
     * @param username
     * @param token
     * @return ResponseEntity containing the diary entry or an error message
     */
    @GetMapping("/diary/getEntry")
    public ResponseEntity<Map<String, String>> getEntry(@RequestParam String date, @RequestParam String token)
    {
        Map<String, String> response = new HashMap<>();

        TokenValidationResponse tokenValidationResponse = TokenUtil.validateToken(token);

        //Validate token
        if (!tokenValidationResponse.isValid())
        {
            response.put("error", "Invalid token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        //Get entry from database
        String entry = dbManager.getDiaryEntry(tokenValidationResponse.getUsername(), date);

        response.put("entry", entry);

        return ResponseEntity.ok(response);
        
    }

    /**
     * Create a new diary entry
     * @param entry
     * @return ResponseEntity containing a success message or an error message
     */
    @PostMapping("/diary/createEntry")
    public ResponseEntity<String> createEntry(@RequestBody DiaryEntry entry)
    {
        //Validate token
        if (!entry.validToken())
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        
        //Save entry to database
        dbManager.createDiaryEntry(entry.getUsername(), entry.getDate(), entry.getEntry());

        return ResponseEntity.ok("Entry created successfully");
    }

    /**
     * Update an existing diary entry
     * @param entry
     * @return ResponseEntity containing a success message or an error message
     */
    @PostMapping("/diary/updateEntry")
    public ResponseEntity<String> updateEntry(@RequestBody DiaryEntry entry)
    {
        //Validate token
        if (!entry.validToken())
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        //Update entry in database
        dbManager.updateDiaryEntry(entry.getUsername(), entry.getDate(), entry.getEntry());

        return ResponseEntity.ok("Entry updated successfully");
    }

    /**
     * Delete a diary entry
     * @param entry
     * @return ResponseEntity containing a success message or an error message
     */
    @PostMapping("/diary/deleteEntry")
    public ResponseEntity<String> deleteEntry(@RequestBody DiaryEntry entry)
    {
        //Validate token
        if (!entry.validToken())
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        //Delete entry from database
        dbManager.deleteDiaryEntry(entry.getUsername(), entry.getDate());

        return ResponseEntity.ok("Entry deleted successfully");
    }


    /**
     * Get a list of diary dates for a specific user within a date range
     * @param user
     * @param startDate
     * @param endDate
     * @param token
     * @return ResponseEntity containing a list of dates or an error message
     */
    @GetMapping("/diary/getDiaryDates")
    public ResponseEntity<Map<String, String>> getDiaryDates(@RequestParam String startDate, @RequestParam String endDate, @RequestParam String token)
    {
        Map<String, String> response = new HashMap<>();

        //Validate token
        TokenValidationResponse tokenValidationResponse = TokenUtil.validateToken(token);
        if (!tokenValidationResponse.isValid())
        {
            response.put("error", "Invalid token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        //Get dates from database
        Map<String, String> dates = dbManager.getDiaryDates(tokenValidationResponse.getUsername(), startDate, endDate);

        return ResponseEntity.ok(dates);
        
    }

  
}


/**
 * POJO class used to represent a diary entry
 */
class DiaryEntry
{
    private String date;
    private String entry;
    private String token;
    private TokenValidationResponse tokenValidationResponse;

    /**
     * Constructor
     * @param username
     * @param date
     * @param entry
     * @param token
     */
    public DiaryEntry(String date, String entry, String token)
    {
        this.date = date;
        this.entry = entry;
        this.token = token;
        this.tokenValidationResponse = TokenUtil.validateToken(token);
    }

    /**
     * getUsername
     * @return username
     */
    public String getUsername()
    {
        return tokenValidationResponse.getUsername();
    }

    /**
     * getDate
     * @return date
     */
    public String getDate()
    {
        return date;
    }

    /**
     * getEntry
     * @return entry
     */
    public String getEntry()
    {
        return entry;
    }

    /**
     * getToken
     * @return token
     */
    public String getToken()
    {
        return token;
    }

    /**
     * getTokenValidationResponse
     * @return tokenValidationResponse
     */
    public boolean validToken()
    {
        return tokenValidationResponse.isValid();
    }
}