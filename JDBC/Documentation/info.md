# JDBC
JDBC (Java Database Connectivity) is an API in Java that defines how a client may access a database. It provides methods to query and update data in a database.

## Drivers in JDBC
A driver in JDBC is a software component that enables a Java application to interact with a database.

### Types of JDBC Drivers
1. **JDBC-ODBC Bridge Driver**: Connects Java applications to databases via ODBC drivers.
2. **Native-API Partly Java Driver**: Converts JDBC calls to database-specific native calls.
3. **Network Protocol Pure Java Driver**: Translates JDBC calls to a database-independent protocol, communicating through a middleware.
4. **Thin Driver**: A pure Java driver that converts JDBC calls to a database-specific protocol.

## JDBC Components
JDBC components are classes and interfaces in JDBC that manage database connections and execute SQL queries.

#### Key Components
- **DriverManager**: Manages a list of database drivers.
    - `registerDriver()`: Registers a driver.
    - `getConnection()`: Establishes a connection to a specified database.
- **Connection**: Represents a database connection.
    - `createStatement()`: Creates a Statement object.
    - `prepareStatement()`: Creates a PreparedStatement object.
- **Statement and PreparedStatement**: Interfaces for executing SQL queries.
    - **Statement**:
        - `executeQuery()`: Executes a SELECT query.
        - `executeUpdate()`: Executes INSERT, UPDATE, DELETE queries.
    - **PreparedStatement**:
        - `setString(int, String)`: Sets a string parameter for the query.
        - `execute()`: Executes any SQL statement.
- **ResultSet**: Holds the results of a SELECT query.
    - `next()`: Moves to the next row.
    - `getInt(String)`: Retrieves an integer from a column.

### Differences Between Statement and PreparedStatement
| Feature              | Statement                    | PreparedStatement                    |
|----------------------|------------------------------|--------------------------------------|
| Query Compilation    | Compiled each time           | Compiled once, reusable             |
| Parameter Binding    | No parameterization          | Supports parameterization           |
| Security             | Prone to SQL injection       | Safer against SQL injection         |

## Setting up JDBC
1. **Connecting IDE with JDBC**:
   ```java
   Class.forName("com.mysql.cj.jdbc.Driver");
   ```
2. **Load Driver**:
   ```java
   DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
   ```
3. **Create Connection**:
   ```java
   Connection conn = DriverManager.getConnection(url, user, password);
   ```
4. **Create Statement**:
   ```java
   Statement statement = conn.createStatement();
   ```
5. **Execute Query**:
   ```java
   ResultSet rs = stmt.executeQuery("SELECT * FROM student");
   ```

## CRUD Operations Using Statement
```java
import java.sql.*;

public class StatementCRUD {
    private static final String url = "jdbc:mysql://localhost:3306/prasudb";
    private static final String user = "root";
    private static final String password = "Prasu@3598";

    public static void main(String[] args) throws SQLException {

//        Loading driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        
//        use may skip this registration
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        try {
//            creating connection
            Connection connection = DriverManager.getConnection(url, user, password);

//            creating statement
            Statement statement = connection.createStatement();

//            create query and execute
//            creating
//            String crating = String.format("INSERT INTO student (name, age, marks) VALUES ('%s', %d, %f)", "Rudra", 20, 73.00);
//            statement.executeUpdate(crating);

//             Update query - update marks for 'preet' to 95
            String updateQuery = "UPDATE student SET marks = 95 WHERE name = 'preet'";
            int updateCount = statement.executeUpdate(updateQuery);
            if (updateCount > 0) {
                System.out.println("Successfully updated marks for 'preet' to 95.");
            }

//             Delete query - delete student with id=3
            String deleteQuery = "DELETE FROM student WHERE id = 3";
            int deleteCount = statement.executeUpdate(deleteQuery);
            if (deleteCount > 0) {
                System.out.println("Successfully deleted student with id=3.");
            }
//            reading
            String reading = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(reading);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");

                System.out.println(id + " " + name + " " + age + " " + marks);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
}
```
## CRUD Operations Using Prepared Statement
```java
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
```

## Batch Processing in JDBC
Batch processing allows executing multiple queries in a single batch, improving performance.

- **Advantages**: Reduces the number of database hits, faster execution.

### Use Case Example
```java
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

```

## Transactions in JDBC

A transaction in JDBC is a set of SQL operations that are treated as a single unit of work. Either all operations in the transaction succeed, or none do, ensuring database integrity. Transactions are useful for operations that need to be executed together, such as transferring funds between accounts.

### Key Methods in JDBC Transactions

- **setAutoCommit(false)**: Turns off auto-commit mode. By default, JDBC transactions are auto-committed after each statement. Disabling this allows multiple statements to be grouped within a transaction.

- **commit()**: Confirms all changes made during the transaction. Once committed, changes become permanent and are visible to other users.

- **rollback()**: Cancels all changes made since the transaction began, reverting the database to its previous state.

- **setSavepoint()**: Creates a savepoint within the transaction. This allows for a partial rollback to a certain point in the transaction if needed.

- **releaseSavepoint(savepoint)**: Removes a savepoint from the transaction. This can help release resources if the savepoint is no longer needed.

### Example: Using Transactions in JDBC

The following example demonstrates a typical transaction in JDBC where we perform multiple SQL operations, using commit and rollback to manage them as an atomic unit.

```java
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
```