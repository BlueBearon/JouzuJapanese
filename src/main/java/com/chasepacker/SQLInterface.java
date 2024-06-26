package com.chasepacker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLInterface {

    private static String databaseURL = "";


    private static Connection getDatabaseConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(databaseURL, "root", "password");
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions or throw them as needed
        }
        return conn;
    }


    private static ResultSet connectQuery(String query, String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getDatabaseConnection();
            pstmt = conn.prepareStatement(query);
            for (int i = 0; i < args.length; i++) {
                pstmt.setString(i + 1, args[i]);
            }
            if (query.trim().toUpperCase().startsWith("SELECT")) {
                rs = pstmt.executeQuery();
            } else {
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
            // Handle exceptions or throw them as needed
        } finally {
            // It's not a good practice to close connection here in real scenarios
            // Consider using try-with-resources or managing connection lifecycle outside this method
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }   

    public static String retrieveDiaryEntry(String user, String date)
    {
        
        String query = "SELECT content FROM DiaryEntry WHERE username = ? AND entry_date = ?;";

        String[] args = {user, date};

        try
        {
            ResultSet rs = connectQuery(query, args);
            return rs.getString("content");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return "";
        }
    }

    public static String createDiaryEntry(String user, String date, String entry)
    {

        String query = "INSERT INTO DiaryEntry (username, entry_date, content) VALUES (?, ?, ?);";

        String[] args = {user, date, entry};

        try
        {
            ResultSet rs = connectQuery(query, args);
            return rs.getString("content");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return "";
        }
    }

    public static String updateDiaryEntry(String user, String date, String entry)
    {
        String query = "UPDATE DiaryEntry SET content = ? WHERE username = ? AND entry_date = ?;";

        String[] args = {user, date, entry};

        try
        {
            ResultSet rs = connectQuery(query, args);
            return rs.getString("content");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return "";
        }
    }

    public static String deleteDiaryEntry(String user, String date)
    {
        String query = "DELETE FROM DiaryEntry WHERE username = ? AND entry_date = ?;";

        String[] args = {user, date};

        try
        {
            ResultSet rs = connectQuery(query, args);
            return rs.getString("content");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return "";
        }
    }

    public static String[] retrieveDiaryDates(String user, String startDate, String endDate)
    {
        String query = "SELECT entry_date FROM DiaryEntry WHERE username = ? AND entry_date >= ? AND entry_date <= ?;";

        String[] args = {user, startDate, endDate};

        try
        {
            ResultSet rs = connectQuery(query, args);
            String[] dates = new String[rs.getFetchSize()];
            int i = 0;
            while (rs.next())
            {
                dates[i] = rs.getString("entry_date");
                i++;
            }
            return dates;
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    
    
}
