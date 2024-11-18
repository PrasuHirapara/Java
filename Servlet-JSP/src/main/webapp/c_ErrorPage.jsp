
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body bgcolor="red" text="white">
<%= exception.getClass().getName() %>
<%= exception.getMessage() %>
</body>
</html>
