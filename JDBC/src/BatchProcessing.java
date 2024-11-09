import java.sql.*;

public class BatchProcessing {
    private static final String url = "jdbc:mysql://localhost:3306/prasudb";
    private static final String user = "root";
    private static final String password = "Prasu@3598";

    public static void main(String[] args) {

        // Loading MySQL JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found.", e);
        }

        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            // Disable auto-commit for batch processing
            connection.setAutoCommit(false);

            // CREATE operation (Batch Insert multiple students)
            String createQuery = "INSERT INTO student (name, age, marks) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(createQuery)) {

                preparedStatement.setString(1, "Aarav");
                preparedStatement.setInt(2, 22);
                preparedStatement.setDouble(3, 92.0);
                preparedStatement.addBatch(); // Add to batch

                preparedStatement.setString(1, "Meera");
                preparedStatement.setInt(2, 21);
                preparedStatement.setDouble(3, 85.3);
                preparedStatement.addBatch(); // Add to batch

                preparedStatement.setString(1, "Ravi");
                preparedStatement.setInt(2, 23);
                preparedStatement.setDouble(3, 78.9);
                preparedStatement.addBatch(); // Add to batch

                // Execute the batch of inserts
                int[] rowsInserted = preparedStatement.executeBatch();

                // Commit the transaction
                connection.commit();

                // Print success message
                System.out.println("Successfully inserted " + rowsInserted.length + " new students.");
            } catch (SQLException e) {
                // If any error occurs, roll back the transaction
                connection.rollback();
                System.out.println("Error during batch insert: " + e.getMessage());
            }

            // SELECT operation (Read all students)
            String readQuery = "SELECT * FROM student";
            try (PreparedStatement preparedStatement = connection.prepareStatement(readQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Displaying data from ResultSet
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    double marks = resultSet.getDouble("marks");

                    System.out.println(id + " " + name + " " + age + " " + marks);
                }
            } catch (SQLException e) {
                System.out.println("Error during SELECT operation: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
