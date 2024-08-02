package com.chasepacker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.Map;
import java.util.HashMap;



/**
 * Controller for the diary
 * 
 * Uses functions from DBManager.java to interact with the database
 * 
 * @see DBManager
 */
@RestController
public class DiaryController {


    private DBManager dbManager = new DBManager();

    /**
     * Validates the token
     * 
     * @param token
     * @return true if token is valid
     */
    private boolean validateToken(String token)
    {
        //Check if token is valid
        return true;
    }


    @GetMapping("/diary/getEntry")
    public ResponseEntity<Map<String, String>> getEntry(@RequestParam String date, @RequestParam String username, @RequestParam String token)
    {
        Map<String, String> response = new HashMap<>();

        //Validate token
        if (!validateToken(token))
        {
            response.put("error", "Invalid token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        //Get entry from database
        String entry = dbManager.getDiaryEntry(username, date);

        response.put("entry", entry);

        return ResponseEntity.ok(response);
        
    }

    @PostMapping("/diary/createEntry")
    public ResponseEntity<String> createEntry(@RequestBody DiaryEntry entry)
    {
        //Validate token
        if (!validateToken(entry.getToken()))
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        //Save entry to database
        dbManager.createDiaryEntry(entry.getUsername(), entry.getDate(), entry.getEntry());

        return ResponseEntity.ok("Entry created successfully");
    }

    @PostMapping("/diary/updateEntry")
    public ResponseEntity<String> updateEntry(@RequestBody DiaryEntry entry)
    {
        //Validate token
        if (!validateToken(entry.getToken()))
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        //Update entry in database
        dbManager.updateDiaryEntry(entry.getUsername(), entry.getDate(), entry.getEntry());

        return ResponseEntity.ok("Entry updated successfully");
    }

    @PostMapping("/diary/deleteEntry")
    public ResponseEntity<String> deleteEntry(@RequestBody DiaryEntry entry)
    {
        //Validate token
        if (!validateToken(entry.getToken()))
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        //Delete entry from database
        dbManager.deleteDiaryEntry(entry.getUsername(), entry.getDate());

        return ResponseEntity.ok("Entry deleted successfully");
    }



    @GetMapping("/diary/getDiaryDates")
    public ResponseEntity<Map<String, String>> getDiaryDates(@RequestParam String user, @RequestParam String startDate, @RequestParam String endDate, @RequestParam String token)
    {
        Map<String, String> response = new HashMap<>();

        //Validate token
        if (!validateToken(token))
        {
            response.put("error", "Invalid token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        //Get dates from database
        Map<String, String> dates = dbManager.getDiaryDates(user, startDate, endDate);

        return ResponseEntity.ok(dates);
        
    }

  
}


class DiaryEntry
{
    private String username;
    private String date;
    private String entry;
    private String token;

    public DiaryEntry(String username, String date, String entry, String token)
    {
        this.username = username;
        this.date = date;
        this.entry = entry;
        this.token = token;
    }

    public String getUsername()
    {
        return username;
    }

    public String getDate()
    {
        return date;
    }

    public String getEntry()
    {
        return entry;
    }

    public String getToken()
    {
        return token;
    }
}
