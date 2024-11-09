import java.sql.*;

public class PreparedStatementCRUD {
    private static final String url = "jdbc:mysql://localhost:3306/prasudb";
    private static final String user = "root";
    private static final String password = "Prasu@3598";

    public static void main(String[] args) {

//         Loading MySQL JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found.", e);
        }

        try {
//            creating connection
            Connection connection = DriverManager.getConnection(url, user, password);

//             CREATE operation (Insert a new student)
            String createQuery = "INSERT INTO student (name, age, marks) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(createQuery)) {
//                can be used in while loop for multiple insertion
                preparedStatement.setString(1, "Vansh");
                preparedStatement.setInt(2, 20);
                preparedStatement.setDouble(3, 88.5);
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Successfully inserted a new student.");
                }
            }

//             UPDATE operation (Update marks for 'preet' to 95)
            String updateQuery = "UPDATE student SET marks = ? WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setDouble(1, 96);
                preparedStatement.setString(2, "preet");
                int rowsUpdated = preparedStatement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("Successfully updated marks for 'preet' to 96.");
                }
            }

//             DELETE operation (Delete student with id=3)
            String deleteQuery = "DELETE FROM student WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, 3);
                int rowsDeleted = preparedStatement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("Successfully deleted student with id=3.");
                }
            }

            // READ operation (Select all students)
            String readQuery = "SELECT * FROM student";
            try (PreparedStatement preparedStatement = connection.prepareStatement(readQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    double marks = resultSet.getDouble("marks");

                    System.out.println(id + " " + name + " " + age + " " + marks);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}