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