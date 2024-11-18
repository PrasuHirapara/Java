
# Model-View-Controller (MVC) Pattern in JSP and Servlets

The **Model-View-Controller (MVC)** design pattern separates the application logic into three interconnected components: **Model**, **View**, and **Controller**. It is widely used in Java web development to create clean, maintainable, and testable applications.

---

## Components of MVC

### 1. **Model**
- Represents the data and business logic.
- Handles interactions with the database or other data sources.
- Encapsulates the application's state.
- Typically implemented using Java classes.

### 2. **View**
- Responsible for presenting the data to the user.
- Defines the user interface (UI).
- Implemented using JSP.

### 3. **Controller**
- Acts as an intermediary between the Model and View.
- Processes user input and invokes corresponding actions on the Model.
- Implemented using Servlets.

---

## MVC Architecture

Below is an illustration of the MVC architecture in web applications:

![MVC Architecture](https://www.java-samples.com/images/model2architecture.jpg)

---

## Implementing MVC with JSP, Servlets, and JDBC

### Example: **Student Management Application with JDBC**

This example demonstrates a simple Student Management application where students' data is managed using JDBC and displayed on a JSP page.

### **Step 1: Controller (StudentServlet.java)**

```java
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
```

### **Step 2: View (students.jsp)**

```jsp
<%@ page import="java.util.*, Model.MVC_Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Student Records</title>
</head>
<body>
<h1>Student Records</h1>
<%
List<MVC_Student> students = (List<MVC_Student>) request.getAttribute("students");
    if (students != null && !students.isEmpty()) {
        %>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Age</th><th>Marks</th></tr>
    <% for (MVC_Student student : students) { %>
    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getName() %></td>
        <td><%= student.getAge() %></td>
        <td><%= student.getMarks() %></td>
    </tr>
    <% } %>
</table>
<%
        } else {
        %>
<h3>No student records found.</h3>
<%
        }
        %>
</body>
</html>
```

### **Step 3: Model (Student.java)**

```java
public class MVC_Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
```
## Advantages of MVC Pattern

- **Separation of Concerns**: Each component focuses on a specific task, making the application easier to maintain.
- **Scalability**: Allows adding new features without modifying existing code significantly.
- **Testability**: Business logic (Model) can be tested independently of the UI.
- **Code Reusability**: Components can be reused in other parts of the application.

## Conclusion

The MVC pattern is a powerful approach for developing web applications in Java. By clearly separating the logic, data, and presentation, it promotes maintainability, scalability, and modularity.
