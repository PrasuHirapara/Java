<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Implicit Objects</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    if (username != null) {
        out.println("<h3>Hello, " + username + "!</h3>");
    } else {
        out.println("<h3>No username provided.</h3>");
    }
%>
<br>
<%
    session.setAttribute("user", "Prasu");
    String user = (String) session.getAttribute("user");
    out.println("<h3>User: " + user + "</h3>");
%>
<br>
<%
    String contextParam = application.getInitParameter("name");
    out.println("<h3>Context Parameter: " + contextParam + "</h3>");
%>
<br>
<%
    String initParam = config.getServletName();
    out.println("<h3>Initialization Parameter (Servlet Name): " + initParam + "</h3>");
%>
<br>
<%
    pageContext.setAttribute("pageVar", "PageScopedValue");
    String pageVar = (String) pageContext.getAttribute("pageVar");
    out.println("<h3>Page Variable: " + pageVar + "</h3>");
%>
<br>
<%
    out.println("<h3>This is the current page: " + page.getClass().getName() + "</h3>");
%>
</body>
</html>
