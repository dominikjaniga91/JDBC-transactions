package connection;

import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionProvider {

    public static java.sql.Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
