<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JDBC in JSP</title>
</head>
<body>
<h1>Student Records</h1>
<%
    // Database connection details
    String url = "jdbc:mysql://localhost:3306/prasudb";
    String user = "root";
    String password = "Prasu@3598";

    // JDBC connection and CRUD operations
    Connection connection = null;
    Statement statement = null;

    try {
        // Loading driver (optional for modern JDBC)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Creating connection
        connection = DriverManager.getConnection(url, user, password);

        // Creating statement
        statement = connection.createStatement();

        // Example CRUD Operations

        // Update query
        String updateQuery = "UPDATE student SET marks = 95 WHERE name = 'preet'";
        int updateCount = statement.executeUpdate(updateQuery);
        out.println("<h3>Updated Records: " + updateCount + "</h3>");

        // Delete query
        String deleteQuery = "DELETE FROM student WHERE id = 3";
        int deleteCount = statement.executeUpdate(deleteQuery);
        out.println("<h3>Deleted Records: " + deleteCount + "</h3>");

        // Read query
        String selectQuery = "SELECT * FROM student";
        ResultSet resultSet = statement.executeQuery(selectQuery);

        // Displaying student records
        out.println("<h3>Student Records:</h3>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Age</th><th>Marks</th></tr>");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            double marks = resultSet.getDouble("marks");

            out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + age + "</td><td>" + marks + "</td></tr>");
        }
        out.println("</table>");
    } catch (Exception e) {
        out.println("<h3>Error: " + e.getMessage() + "</h3>");
    } finally {
        // Cleaning up resources
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            out.println("<h3>Cleanup Error: " + e.getMessage() + "</h3>");
        }
    }
%>
</body>
</html>