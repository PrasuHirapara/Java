import Model.MVC_Student;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mvc")
public class MVC_StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MVC_Student> students = new ArrayList<>();

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/prasudb";
        String user = "root";
        String password = "Prasu@3598";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // Read query
            String selectQuery = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");
                students.add(new MVC_Student(id, name, age, marks));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Set data in request scope
        request.setAttribute("students", students);

        // Forward to the JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("MVC_Student.jsp");
        dispatcher.forward(request, response);
    }
}