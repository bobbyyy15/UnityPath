import java.sql.*;

public class DataBaseConnection {
    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Your connection code here
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
