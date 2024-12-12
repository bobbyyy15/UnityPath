package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VolunteerMatchingDB {
    private static final String URL = "jdbc:mysql://localhost:3306/volunteermatchingdb";
    private static final String USER = "root";
    private static final String PASSWORD = "qwerty";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}