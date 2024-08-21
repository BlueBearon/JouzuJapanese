package com.chasepacker;

import java.sql.*;
import java.util.List;

import com.chasepacker.DBManager.UsernameDoesNotExistException;
import com.chasepacker.DBManager.UsernameExistsException;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBManagerTest {

    @Autowired
    private DBManager dbManager;


    @Test
    public void testDBManager() {

        assertNotNull(dbManager);

    }

    @AfterAll
    public void cleanUp() {

        try {
            dbManager.closeConnections();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }



    @Test 
    public void testTablesExist(){
        
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

        
    }

    @Test
    public void testUserExists() throws SQLException {
        String username = "testUser";

        

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

        
    }

    @Test
    public void testPasswordCorrect() throws SQLException {
        String username = "testUser";
        String password = "password";

        

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

        
    }

    @Test
    public void testCreateNewUser() throws SQLException {
        String username = "testUser";
        String password = "password";

        

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

        
    }

    @Test
    public void testDeleteUser() throws SQLException {
        String username = "testUser";
        String password = "password";

        

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

        
    }

    @Test
    public void testUpdateUser() throws SQLException {
        String username = "testUser";
        String password = "password";
        String newPassword = "newPassword";

        

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

        
    }

    @Test
    public void testGetDiaryEntry() throws SQLException {
        String username = "testUser";
        String password = "password";
        String date = "2021-01-01";
        String entry = "This is a test entry";

        

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

        
    }

    @Test
    public void testCreateDiaryEntry()
    {
        String username = "testUser";
        String password = "password";
        String date = "2021-01-01";
        String entry = "This is a test entry";

        

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

        
    }

    @Test
    public void testDeleteDiaryEntry()
    {
        String username = "testUser";
        String password = "password";
        String date = "2021-01-01";
        String entry = "This is a test entry";

        

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

        
    }

   @Test
    public void testUpdateDiaryEntry()
    {
        String username = "testUser";
        String password = "password";
        String date = "2021-01-01";
        String entry = "This is a test entry";
        String newEntry = "This is a new test entry";

        

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

        
    }

    @Test
    public void testGetDiaryDates() throws SQLException {
        String username = "testUser";
        String password = "password";
        String startDate = "2021-01-01";
        String endDate = "2021-01-10";

        

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

        
    }


    // Test case for inserting japnese characters
    @Test
    public void testJapaneseCharacters() throws SQLException {
        String username = "testUser";
        String password = "password";
        String date = "2021-01-01";
        String entry = "これはテストエントリです";

        

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

        
    }

    //Test case for updating with japanese characters
    @Test
    public void testUpdateDiaryEntryJapanese() throws SQLException {
        String username = "testUser";
        String password = "password";
        String date = "2021-01-01";
        String entry = "これはテストエントリです";
        String newEntry = "これは新しいテストエントリです";

        

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
        } 
        catch (UsernameDoesNotExistException u) {
            u.printStackTrace();
            fail("Error deleting user: " + u.getMessage());
        }

        
    }


}
