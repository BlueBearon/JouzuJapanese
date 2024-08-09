package com.chasepacker;

import java.sql.*;
import java.util.List;

import static org.junit.Assert.*;

import com.chasepacker.DBManager.ConnectionFailedException;
import com.chasepacker.DBManager.UsernameDoesNotExistException;
import com.chasepacker.DBManager.UsernameExistsException;

import java.util.Map;
import org.junit.Test;

public class DBManagerTest {

    private DBManager dbManager;

    public void setUp(){

        try {
            dbManager = new DBManager();
        } catch (ConnectionFailedException e) {
            e.printStackTrace();
            fail("Connection failed: " + e.getMessage());
        }
    }

    public void tearDown() {
        try {
            dbManager.closeConnections();
            dbManager = null;
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error closing connections: " + e.getMessage());
        }
    }


    @Test
    public void testDBManager() {

        setUp();
        assertNotNull(dbManager);
        tearDown();
    }



    @Test 
    public void testTablesExist(){
        setUp();

        List<String> tables;

        try {
            tables = dbManager.checkExistingTables();
            // tables should contain Account and DiaryEntry
            assertTrue(tables.contains("Account"));
            assertTrue(tables.contains("DiaryEntry"));
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Error checking if tables exist: " + e.getMessage());
        }

        tearDown();
    }

    @Test
    public void testUserExists() throws SQLException {
        String username = "testUser";

        setUp();

        try {
            assertFalse(dbManager.userExists(username));
            dbManager.createNewUser(username, "password");
            assertTrue(dbManager.userExists(username));
            dbManager.deleteUser(username);
            assertFalse(dbManager.userExists(username));
        } catch (UsernameExistsException u) {
            u.printStackTrace();
            assertTrue(false);
        } catch (UsernameDoesNotExistException u) {
            u.printStackTrace();
            assertTrue(false);
        }

        tearDown();
    }

    @Test
    public void testPasswordCorrect() throws SQLException {
        String username = "testUser";
        String password = "password";

        setUp();

        try {
            dbManager.createNewUser(username, password);
            assertTrue(dbManager.passwordCorrect(username, password));
            assertFalse(dbManager.passwordCorrect(username, "wrongPassword"));
            dbManager.deleteUser(username);
        } catch (UsernameExistsException u) {
            u.printStackTrace();
            fail("Error creating user: " + u.getMessage());
        } catch (UsernameDoesNotExistException u) {
            u.printStackTrace();
            fail("Error deleting user: " + u.getMessage());
        }

        tearDown();
    }

    @Test
    public void testCreateNewUser() throws SQLException {
        String username = "testUser";
        String password = "password";

        setUp();

        // Successful creation, should work
        try {
            dbManager.createNewUser(username, password);
            assertTrue(dbManager.userExists(username));
        } catch (UsernameExistsException u) {
            u.printStackTrace();
            fail("Error creating user: " + u.getMessage());
        }

        // Duplicate creation, should throw exception
        try {
            dbManager.createNewUser(username, password);
            fail("Error: Duplicate user created");
        } catch (UsernameExistsException u) {
            // Expected
        }

        try{
            dbManager.deleteUser(username);
        } catch (UsernameDoesNotExistException u) {
            u.printStackTrace();
            fail("Error deleting user: " + u.getMessage());
        }

        tearDown();
    }

    @Test
    public void testDeleteUser() throws SQLException {
        String username = "testUser";
        String password = "password";

        setUp();

        try {
            dbManager.createNewUser(username, password);
            assertTrue(dbManager.userExists(username));
            dbManager.deleteUser(username);
            assertFalse(dbManager.userExists(username));
        } catch (UsernameExistsException u) {
            u.printStackTrace();
            fail("Error creating user: " + u.getMessage());
        } catch (UsernameDoesNotExistException u) {
            u.printStackTrace();
            fail("Error deleting user: " + u.getMessage());
        }

        tearDown();
    }

    @Test
    public void testUpdateUser() throws SQLException {
        String username = "testUser";
        String password = "password";
        String newPassword = "newPassword";

        setUp();

        try {
            dbManager.createNewUser(username, password);
            assertTrue(dbManager.userExists(username));
            dbManager.updateUser(username, newPassword);
            assertTrue(dbManager.passwordCorrect(username, newPassword));
            dbManager.deleteUser(username);
        } catch (UsernameExistsException u) {
            u.printStackTrace();
            fail("Error creating user: " + u.getMessage());
        } 
        catch (UsernameDoesNotExistException u) {
            u.printStackTrace();
            fail("Error deleting user: " + u.getMessage());
        }

        tearDown();
    }

    @Test
    public void testGetDiaryEntry() throws SQLException {
        String username = "testUser";
        String password = "password";
        String date = "2021-01-01";
        String entry = "This is a test entry";

        setUp();

        try {
            dbManager.createNewUser(username, password);
            dbManager.createDiaryEntry(username, date, entry);
            assertEquals(entry, dbManager.getDiaryEntry(username, date));
            dbManager.deleteDiaryEntry(username, date);
            dbManager.deleteUser(username);
        } catch (UsernameExistsException u) {
            u.printStackTrace();
            fail("Error creating user: " + u.getMessage());
        } catch (UsernameDoesNotExistException u) {
            u.printStackTrace();
            fail("Error deleting user: " + u.getMessage());
        }

        tearDown();
    }

    @Test
    public void testCreateDiaryEntry()
    {
        String username = "testUser";
        String password = "password";
        String date = "2021-01-01";
        String entry = "This is a test entry";

        setUp();

        try {
            dbManager.createNewUser(username, password);
            dbManager.createDiaryEntry(username, date, entry);
            assertEquals(entry, dbManager.getDiaryEntry(username, date));
            dbManager.deleteDiaryEntry(username, date);
            dbManager.deleteUser(username);
        } catch (UsernameExistsException u) {
            u.printStackTrace();
            fail("Error creating user: " + u.getMessage());
        } catch (UsernameDoesNotExistException u) {
            u.printStackTrace();
            fail("Error deleting user: " + u.getMessage());
        }
        catch (SQLException e) {
            e.printStackTrace();
            fail("Error creating diary entry: " + e.getMessage());
        }

        tearDown();
    }

    @Test
    public void testDeleteDiaryEntry()
    {
        String username = "testUser";
        String password = "password";
        String date = "2021-01-01";
        String entry = "This is a test entry";

        setUp();

        try {
            dbManager.createNewUser(username, password);
            dbManager.createDiaryEntry(username, date, entry);
            assertEquals(entry, dbManager.getDiaryEntry(username, date));
            dbManager.deleteDiaryEntry(username, date);
            assertEquals("", dbManager.getDiaryEntry(username, date));
            dbManager.deleteUser(username);
        } catch (UsernameExistsException u) {
            u.printStackTrace();
            fail("Error creating user: " + u.getMessage());
        } catch (UsernameDoesNotExistException u) {
            u.printStackTrace();
            fail("Error deleting user: " + u.getMessage());
        }
        catch (SQLException e) {
            e.printStackTrace();
            fail("Error creating diary entry: " + e.getMessage());
        }

        tearDown();
    }

   @Test
    public void testUpdateDiaryEntry()
    {
        String username = "testUser";
        String password = "password";
        String date = "2021-01-01";
        String entry = "This is a test entry";
        String newEntry = "This is a new test entry";

        setUp();

        try {
            dbManager.createNewUser(username, password);
            dbManager.createDiaryEntry(username, date, entry);
            assertEquals(entry, dbManager.getDiaryEntry(username, date));
            dbManager.updateDiaryEntry(username, date, newEntry);
            assertEquals(newEntry, dbManager.getDiaryEntry(username, date));
            dbManager.deleteDiaryEntry(username, date);
            dbManager.deleteUser(username);
        } catch (UsernameExistsException u) {
            u.printStackTrace();
            fail("Error creating user: " + u.getMessage());
        } catch (UsernameDoesNotExistException u) {
            u.printStackTrace();
            fail("Error deleting user: " + u.getMessage());
        }
        catch (SQLException e) {
            e.printStackTrace();
            fail("Error creating diary entry: " + e.getMessage());
        }

        tearDown();
    }

    @Test
    public void testGetDiaryDates() throws SQLException {
        String username = "testUser";
        String password = "password";
        String startDate = "2021-01-01";
        String endDate = "2021-01-10";

        setUp();

        try {
            dbManager.createNewUser(username, password);

            // Test Case 1: All dates are within the range
            dbManager.createDiaryEntry(username, "2021-01-02", "Entry 1");
            dbManager.createDiaryEntry(username, "2021-01-05", "Entry 2");
            dbManager.createDiaryEntry(username, "2021-01-09", "Entry 3");

            Map<String, String> result = dbManager.getDiaryDates(username, startDate, endDate);
            assertEquals("2021-01-02, 2021-01-05, 2021-01-09", result.get("dates"));

            // Test Case 2: Only some dates are within the range
            dbManager.createDiaryEntry(username, "2020-12-31", "Entry 4");
            dbManager.createDiaryEntry(username, "2021-01-03", "Entry 5");
            dbManager.createDiaryEntry(username, "2021-01-11", "Entry 6");

            result = dbManager.getDiaryDates(username, startDate, endDate);
            assertEquals("2021-01-02, 2021-01-03, 2021-01-05, 2021-01-09", result.get("dates"));


            // Test Case 3: No dates are within the range
            dbManager.createDiaryEntry(username, "2020-12-30", "Entry 7");
            dbManager.createDiaryEntry(username, "2021-01-12", "Entry 8");

            result = dbManager.getDiaryDates(username, startDate, endDate);
            assertEquals("2021-01-02, 2021-01-03, 2021-01-05, 2021-01-09", result.get("dates"));

            // Clean up
            dbManager.deleteDiaryEntry(username, "2021-01-02");
            dbManager.deleteDiaryEntry(username, "2021-01-05");
            dbManager.deleteDiaryEntry(username, "2021-01-09");
            dbManager.deleteDiaryEntry(username, "2020-12-31");
            dbManager.deleteDiaryEntry(username, "2021-01-03");
            dbManager.deleteDiaryEntry(username, "2021-01-11");
            dbManager.deleteDiaryEntry(username, "2020-12-30");
            dbManager.deleteDiaryEntry(username, "2021-01-12");

            dbManager.deleteUser(username);
        } catch (UsernameExistsException u) {
            u.printStackTrace();
            fail("Error creating user: " + u.getMessage());
        } catch (UsernameDoesNotExistException u) {
            u.printStackTrace();
            fail("Error deleting user: " + u.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Error creating diary entry: " + e.getMessage());
        }

        tearDown();
    }

}
