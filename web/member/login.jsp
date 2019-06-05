<%--
  Created by IntelliJ IDEA.
  User: Le Thanh Tung
  Date: 28/05/2019
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form action="/user/login" method="post" class="w-25 m-auto">
    <h4 class="text-center">Login</h4>
    <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" name="name">
    </div>
    <div class="form-group">
        <label for="name">Password</label>
        <input type="password" class="form-control" name="password">
    </div>
    <input type="submit" class="btn btn-primary btn-block" value="Login">
    <a href="/user/register">Register</a>
</form>
</body>
</html>
