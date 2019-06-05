<%@ page import="com.simpleWeb.entity.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Le Thanh Tung
  Date: 01/06/2019
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("students");
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<table class="table table-striped w-75 m-auto">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Status</th>
    </tr>

    </thead>
    <tbody>
    <% for (Student student : list) {%>
    <tr>
        </th>
        <td>
            <%= student.getName()%>
        </td>
        <td>
            <%= student.getEmail()%>
        </td>
        <td>
            <%= student.getStatus()%>
        </td>
        <td>
            <form action="/user/memberList" method="post">
                <input type="text" hidden name="name" value="<%= student.getName()%>">
                <input class="btn btn-danger" type="submit" value="Delete">
            </form>
        </td>
    </tr>
    <%}%>

    </tbody>
</table>
</body>
</html>
