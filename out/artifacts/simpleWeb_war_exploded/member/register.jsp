<%@ page import="com.simpleWeb.entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: Le Thanh Tung
  Date: 11/05/2019
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Student student = (Student) request.getAttribute("stundet");
    if (student == null) {
        student = new Student();
    }
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form method="post" action="/user/register" class="w-25 m-auto">
    <h4 class="text-center">Register</h4>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" name="email" value="<%= student.getEmail()%>">
    </div>
    <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" name="name" value="<%= student.getName()%>">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" name="password" value="<%= student.getPassword()%>">
    </div>
    <div class="form-group">
        <label for="confirmpassword">Confirm password</label>
        <input type="password" class="form-control" name="confirmPassword">
    </div>
    <input type="submit" class="btn btn-primary btn-block" value="Register">
    <a href="/user/login">Login</a>
</form>
</body>
</html>
