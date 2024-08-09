/**
 * DBManager.java
 * 
 * Description: This class is used to manage the database
 * 
 * Author: Chase Packer
 * Date: 2024-08-01
 * Version 1.0
 * 
 * NOT FOR REUSE WITHOUT PERMISSION
 */


package com.chasepacker;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * DBManager
 * 
 * This class is used to manage the database
 */
public class DBManager {


    
   
    // Database Credentials ********************************************************************************

        // Database URL
        String databaseURL = "jdbc:sqlserver://jouzudb.database.windows.net:1433;database=JouzuDB;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";


        // We are using two different connections to the database in order to separate the permissions of the two connections
        // This is to ensure that the user data is not compromised by a SQL Injection attack on the diary data.

        // Connection for handling user data (Greater Permissions)
        private String userHandler_dbUsername = "jouzuroot";
        private String userHandler_dbPassword = "s5flcrlC0yohlkEFl_1w";
        private Connection userHandler_dbConnection = null;



        // Connection for handling diary data (Lesser Permissions i.e. Cannot read or delete information from users table)
        private String diaryHandler_dbUsername = "diaryHandler";
        private String diaryHandler_dbPassword = "zizosPOHEPis1Isw@cRo";
        private Connection diaryHandler_dbConnection = null;


    // ****************************************************************************************************


    // Database Queries ************************************************************************************

        //SQL Schemata


        /*
           CREATE TABLE Account (
                username VARCHAR(10) PRIMARY KEY,
                hashed_password VARCHAR(64),
            );

            
            CREATE TABLE DiaryEntry (
                username VARCHAR(10),
                entry_date DATE,
                content VARCHAR(800),
                PRIMARY KEY (username, entry_date),
                FOREIGN KEY (username) REFERENCES User(username)
            );
        */



        // User Handler Queries

            // Check if a user exists
            private String userExistsQuery = "SELECT * FROM Account WHERE username = ?;";

            // Check if a password is correct
            private String passwordCorrectQuery = "SELECT * FROM Account WHERE username = ? AND hashed_password = ?;";

            // Create a new user
            private String createUserQuery = "INSERT INTO Account (username, hashed_password) VALUES (?, ?);";

            // Delete a user
            private String deleteUserQuery = "DELETE FROM Account WHERE username = ?;";

            // Update a user
            private String updateUserQuery = "UPDATE Account SET hashed_password = ? WHERE username = ?;";

        // Diary Handler Queries

            // Get a diary entry
            private String getDiaryEntryQuery = "SELECT * FROM DiaryEntry WHERE username = ? AND entry_date = ?;";

            // Create a diary entry
            private String createDiaryEntryQuery = "INSERT INTO DiaryEntry (username, entry_date, content) VALUES (?, ?, ?);";

            // Update a diary entry
            private String updateDiaryEntryQuery = "UPDATE DiaryEntry SET content = ? WHERE username = ? AND entry_date = ?;";

            // Delete a diary entry
            private String deleteDiaryEntryQuery = "DELETE FROM DiaryEntry WHERE username = ? AND entry_date = ?;";

            // Get diary dates
            private String getDiaryDatesQuery = "SELECT entry_date FROM DiaryEntry WHERE username = ? AND entry_date >= ? AND entry_date <= ?;";


    // ****************************************************************************************************


    // Constructor
    public DBManager() throws ConnectionFailedException{

        try{ // Attempt to connect to the database

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            this.userHandler_dbConnection = DriverManager.getConnection(databaseURL, userHandler_dbUsername, userHandler_dbPassword);
            this.diaryHandler_dbConnection = DriverManager.getConnection(databaseURL, diaryHandler_dbUsername, diaryHandler_dbPassword);
        }
        catch(ClassNotFoundException e)
        {
            throw new ConnectionFailedException("Driver does not exist to handle Database.  " + e.getMessage());
        }
        catch(SQLException e)
        {
            throw new ConnectionFailedException("Attempted creating connections to database, but failed.  " + e.getMessage());
        }
        
    }

    public class ConnectionFailedException extends Exception {
        public ConnectionFailedException(String message) {
            super(message);
        }
    }

    /**
     * Returns list of tables in database
     * @return
     * @throws SQLException
     */
    public List<String> checkExistingTables() throws SQLException
    {
        String[] args = {}; // Arguments for the query

        ResultSet rs = userHandler_executeQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES", args);  // Execute the query

        List<String> tables = new ArrayList<String>();
        // Check if the result set is not empty
        try
        {
            while(rs.next())
            {
                tables.add(rs.getString("TABLE_NAME"));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return tables;
    }

    public void closeConnections() throws SQLException
    {

        if (userHandler_dbConnection != null)
        {
            userHandler_dbConnection.close();
        }

        if (diaryHandler_dbConnection != null)
        {
            diaryHandler_dbConnection.close();
        }
    
    }

    /**
     * executeQuery
     * 
     * This method is used to execute a query on the database
     * 
     * If error is encountered, the method will return null
     * 
     * @param conn
     * @param query
     * @param args
     * @return ResultSet
     */
    private ResultSet executeQuery(Connection conn, String query, String[] args) throws SQLException
    {
        if(conn == null)
        {
            return null;
        }

        try
        {
            PreparedStatement stmt = conn.prepareStatement(query);

            for(int i = 0; i < args.length; i++)
            {
                stmt.setString(i + 1, args[i]);
            }

            return stmt.executeQuery();
        }
        catch(SQLException e)
        {
            throw e;
        }
    }

    /**
     * executeUpdate
     * 
     * This method is used to execute an update query on the database
     * 
     * If error is encountered, the method will return false
     * 
     * @param conn
     * @param query
     * @param args
     * @return boolean
     */
    private boolean executeUpdate(Connection conn, String query, String[] args)
    {
        if(conn == null)
        {
            return false;
        }

        try
        {
            PreparedStatement stmt = conn.prepareStatement(query);

            for(int i = 0; i < args.length; i++)
            {
                stmt.setString(i + 1, args[i]);
            }

            stmt.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * userHandler_executeQuery
     * 
     * Wrapper for executeQuery that uses the userHandler_dbConnection
     * 
     * @param query The query to execute
     * @param args The arguments for the query
     * @return ResultSet The result of the query
     */
    private ResultSet userHandler_executeQuery(String query, String[] args) throws SQLException
    {
        return executeQuery(userHandler_dbConnection, query, args);
    }

    /**
     * userHandler_executeUpdate
     * 
     * Wrapper for executeUpdate that uses the userHandler_dbConnection
     * 
     * @param query The query to execute
     * @param args The arguments for the query
     * @return boolean True if the query was successful, false otherwise
     */
    private boolean userHandler_executeUpdate(String query, String[] args)
    {
        return executeUpdate(userHandler_dbConnection, query, args);
    }

    /**
     * diaryHandler_executeQuery
     * 
     * Wrapper for executeQuery that uses the diaryHandler_dbConnection
     * 
     * @param query The query to execute
     * @param args The arguments for the query
     * @return ResultSet The result of the query
     */
    private ResultSet diaryHandler_executeQuery(String query, String[] args) throws SQLException
    {
        return executeQuery(diaryHandler_dbConnection, query, args);
    }

    /**
     * diaryHandler_executeUpdate
     * 
     * Wrapper for executeUpdate that uses the diaryHandler_dbConnection
     * 
     * @param query The query to execute
     * @param args The arguments for the query
     * @return boolean True if the query was successful, false otherwise
     */
    private boolean diaryHandler_executeUpdate(String query, String[] args)
    {
        return executeUpdate(diaryHandler_dbConnection, query, args);
    }

    /**
     * userExists
     * 
     * This method is used to check if a user exists in the database
     * 
     * @param username The username of the user
     * @return boolean True if the user exists, false otherwise
     */
    public boolean userExists(String username) throws SQLException
    {
        String[] args = {username}; // Arguments for the query

        ResultSet rs = userHandler_executeQuery(userExistsQuery, args);  // Execute the query

        // Check if the result set is not empty
        try
        {
            return rs.next(); // If the result set is not empty, the user exists
        }
        catch(SQLException e) 
        {
            return false;
        }
    }

    /**
     * passwordCorrect
     * 
     * This method is used to check if a password is correct for a given username
     * 
     * @param username The username of the user
     * @param password The password to check
     */
    public  boolean passwordCorrect(String username, String password) throws SQLException
    {
        String[] args = {username, password}; // Arguments for the query

        ResultSet rs = userHandler_executeQuery(passwordCorrectQuery, args);  // Execute the query

        // Check if the result set is not empty
        try
        {
            return rs.next(); // If the result set is not empty, the password is correct
        }
        catch(SQLException e) 
        {
            return false;
        }
    }

    /**
     * UsernameExistsException
     * 
     * This exception is thrown when a username already exists in the database.
     */
    public  class UsernameExistsException extends Exception {
        public UsernameExistsException(String message) {
            super(message);
        }
    }

    /**
     * UsernameDoesNotExistException
     * 
     * This exception is thrown when a username does not exist in the database.
     */
    public  class UsernameDoesNotExistException extends Exception {
        public UsernameDoesNotExistException(String message) {
            super(message);
        }
    }

    /**
     * createNewUser
     * 
     * This method is used to create a new user in the database
     * 
     * @param username The username of the user
     * @param password The password of the user
     * @throws UsernameExistsException Thrown if the username already exists in the database
     */
    public void createNewUser(String username, String password) throws UsernameExistsException, SQLException
    {
        if(userExists(username))
        {
            throw new UsernameExistsException("Username already exists");
        }

        String[] args = {username, password}; // Arguments for the query

        userHandler_executeUpdate(createUserQuery, args);  // Execute the query
    }

    /**
     * deleteUser
     * 
     * This method is used to delete a user from the database
     * 
     * @param username The username of the user
     * @throws UsernameDoesNotExistException Thrown if the username does not exist in the database
     */
    public void deleteUser(String username) throws UsernameDoesNotExistException, SQLException
    {
        if(!userExists(username))
        {
            throw new UsernameDoesNotExistException("Username does not exist");
        }

        String[] args = {username}; // Arguments for the query

        userHandler_executeUpdate(deleteUserQuery, args);  // Execute the query
        
    }

    /**
     * updateUser
     * 
     * This method is used to update a user in the database
     * 
     * @param username The username of the user
     * @param password The new password of the user
     * @throws UsernameDoesNotExistException Thrown if the username does not exist in the database
     */
    public void updateUser(String username, String password) throws UsernameDoesNotExistException, SQLException
    {
        if(!userExists(username))
        {
            throw new UsernameDoesNotExistException("Username does not exist");
        }

        String[] args = {password, username}; // Arguments for the query

        boolean success = userHandler_executeUpdate(updateUserQuery, args);  // Execute the query

        if(!success)
        {
            throw new SQLException("Failed to update user");
        }

        // Verify that the user was updated
        if(!passwordCorrect(username, password))
        {
            throw new SQLException("Failed to update user");
        }
    }


    /**
     * getDiaryEntry
     * 
     * This method is used to get a diary entry from the database
     * 
     * @param username The username of the user
     * @param date The date of the diary entry
     * @return String The content of the diary entry
     */
    public  String getDiaryEntry(String username, String date)
    {
        String[] args = {username, date};

        try
        {

            ResultSet rs = diaryHandler_executeQuery(getDiaryEntryQuery, args);

            if (rs != null && rs.next()) 
            {
                return rs.getString("content");
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }


        return "";
        
    }

    /**
     * createDiaryEntry
     * 
     * This method is used to create a diary entry in the database
     * 
     * @param username The username of the user
     * @param date The date of the diary entry
     * @param entry The content of the diary entry
     * 
     */
    public void createDiaryEntry(String username, String date, String entry)
    {
        String[] args = {username, date, entry}; // Arguments for the query

        diaryHandler_executeUpdate(createDiaryEntryQuery, args);  // Execute the query
    }

    /**
     * updateDiaryEntry
     * 
     * This method is used to update a diary entry in the database
     * 
     * @param user The username of the user
     * @param date The date of the diary entry
     * @param entry The content of the diary entry
     * @return String The content of the diary entry
     */
    public  void updateDiaryEntry(String user, String date, String entry) throws SQLException
    {
        String[] args = {entry, user, date}; // Arguments for the query

        boolean success = diaryHandler_executeUpdate(updateDiaryEntryQuery, args);  // Execute the query

        if(!success)
        {
            throw new SQLException("Failed to update diary entry");
        }
    }

    /**
     * deleteDiaryEntry
     * 
     * This method is used to delete a diary entry from the database
     * 
     * @param user The username of the user
     * @param date The date of the diary entry
     * @return String The content of the diary entry
     */
    public  void deleteDiaryEntry(String user, String date)
    {
        String[] args = {user, date}; // Arguments for the query

        diaryHandler_executeUpdate(deleteDiaryEntryQuery, args);  // Execute the query
    }

    /**
     * getDiaryDates
     * 
     * This method is used to get the dates of diary entries for a user between two dates
     * 
     * @param user
     * @param startDate
     * @param endDate
     * @return {dates: 1-1-2021, 1-2-2021, 1-3-2021, etc.}
     */
    public  Map<String, String> getDiaryDates(String user, String startDate, String endDate) throws SQLException
    {
        String[] args = {user, startDate, endDate}; // Arguments for the query

        ResultSet rs = diaryHandler_executeQuery(getDiaryDatesQuery, args);  // Execute the query

        Map<String, String> result = new HashMap<String, String>();
        List<String> dates = new ArrayList<String>();
        int i = 0;
        // Check if the result set is not empty
        try
        {
            while(rs.next())
            {
                dates.add(rs.getString("entry_date"));
                i++;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }


        // Result Format
        // {dates: 1-1-2021, 1-2-2021, 1-3-2021, etc.}

        String resultString = dates.toString();

        // Remove the brackets from the string
        resultString = resultString.substring(1, resultString.length() - 1);

        result.put("dates", resultString);

        return result;

    }

}
