
<%--Directives--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Arrays, java.util.List" %>

<html>
<head>
    <title>JSP Basics</title>
</head>
<body>
<%--Declarations--%>
    <%!
        int num = 100;
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    %>

<%--Scriptlets--%>
    <%
        out.println("Hello World");
        out.println("<br>");
        out.println(num + " from class declaration section via scriptlet tag.");
    %>
    <h3>This is after scriptlet tag.</h3>
    <%
        int num = 123; // inside service method so first Priority.
        out.println(num + " from service methods via scriptlet tag.");
    %>
    <br>
<%--Expressions--%>
    <%= list%>
</body>
</html>
