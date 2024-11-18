<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP</title>
</head>
<style>
  * {
    padding: 1px;
    margin: 1px;
  }
</style>
<body>
  <h1>Servlet Topics</h1>
  <br>
  <div><a href="A_SumOfNum.jsp">A) Servlet Basics: Sum of Number</a></div>
    <br>
  <div><a href="B_SquareOfNum.jsp">B) Servlet Communication: Square of Number</a></div>
    <br>
  <div><a href="C_TableOfNum.jsp">C) Session Management: Table of Number</a></div>
    <br>
  <div><a href="D_CheckPrime.jsp">D) Cookie Management: Check Prime </a></div>
    <br>
  <div><a href="${pageContext.request.contextPath}/details">E) ServletContext and ServletConfig: Details </a></div>
    <br>
  <div><a href="${pageContext.request.contextPath}/details">F) Filter  </a></div>
    <br>
  <h1>JSP Topics</h1>
    <br>
  <div><a href="a_Basics.jsp">a) JSP Basics</a></div>
    <br>
  <div><a href="b_ImplicitObjects.jsp">b) Implicit Objects:</a></div>
  <br>
  <div><a href="c_ExceptionHandling.jsp">c) Exception Handling</a></div>
  <br>
  <div><a href="d_JDBC.jsp">c) JDBC</a></div>
  <br>
  <h1>MVC Architecture</h1>
  <br>
  <div><a href="${pageContext.request.contextPath}/mvc">MVC: Student db </a></div>
</body>
</html>