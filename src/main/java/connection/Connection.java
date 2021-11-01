package connection;

import java.sql.*;

class Connection {

    public static void main(String[] args) {

        try {
            final java.sql.Connection connection = ConnectionProvider.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

            while (resultSet.next()) {

                final int id = resultSet.getInt("id");
                final String name = resultSet.getString("name");
                final int age = resultSet.getInt("age");
                System.out.printf("Student: %d, %s, %d", id, name, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
