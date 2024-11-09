import java.sql.*;

public class TransactionExample {
    private static final String url = "jdbc:mysql://localhost:3306/prasudb";
    private static final String user = "root";
    private static final String password = "Prasu@3598";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);

            // Start transaction
            connection.setAutoCommit(false);

            try (Statement statement = connection.createStatement()) {
                // Insert operation
                String insertQuery = "INSERT INTO student (name, age, marks) VALUES ('Ashok', 21, 85.5)";
                statement.executeUpdate(insertQuery);

                // Update operation
                String updateQuery = "UPDATE student SET marks = 90 WHERE name = 'Ashok'";
                statement.executeUpdate(updateQuery);

                // If no errors, commit the transaction
                connection.commit();
                System.out.println("Transaction committed successfully.");

            } catch (SQLException e) {
                // Rollback transaction if any operation fails
                connection.rollback();
                System.out.println("Transaction rolled back due to error: " + e.getMessage());
            } finally {
                connection.setAutoCommit(true); // Restore default auto-commit mode
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}