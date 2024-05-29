package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    private static final String URL = "jdbc:postgresql://localhost:5432/store";
    private static final String USER = "yourUsername";  // Schimbă cu numele tău de utilizator
    private static final String PASSWORD = "yourPassword";  // Schimbă cu parola ta

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
