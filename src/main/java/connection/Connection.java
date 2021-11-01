package connection;

import java.sql.*;

class Connection {

    public static void main(String[] args) {

        insertStatement();
        selectStatement();
    }

    private static void selectStatement() {
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


    private static void insertStatement() {

        try (java.sql.Connection connection = ConnectionProvider.getConnection()) {
            connection.setAutoCommit(false);
            try {
                final PreparedStatement statement = connection.prepareStatement("INSERT INTO student (id, name, age) VALUES (?, ?, ?) ");
                statement.setInt(1, 2);
                statement.setString(2, "Jan");
                statement.setInt(3, 20);
                statement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
