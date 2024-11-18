<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="${pageContext.request.contextPath}/login" >
    Enter Name: <input name="name" type="text" value="Prasu">
    <br>
    Enter Password: <input name="password" type="password" value="Prasu@123">
    <br>
    <input type="submit" value="Login">
</form>
</body>
</html>
