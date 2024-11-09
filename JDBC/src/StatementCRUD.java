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