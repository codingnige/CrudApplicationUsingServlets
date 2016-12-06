<%-- 
    Document   : main
    Created on : Nov 1, 2016, 9:10:22 PM
    Author     : nigelantwi-boasiako
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <form action="ManagementServlet" method="POST">
            ID: <input type="text" name="id" value="${user.id}" placeholder="Enter if deleting or editing"/>
            <br>
            Title: <input type="text" name="title" value="${user.title}"/> 
            <br>
            Name: <input type="text" name="name" value="${user.firstname}"/> 
            <br>
            Surname: <input type="text" name="surname" value="${user.surname}"/> 
            <br>
            Date of Birth: <input type="text" name="dob" value="${user.dateofbirth}"/> 
            <br>
            Activate:<input type="checkbox" name="status" value="${user.status}"> 
            <br>
            <input type="submit" name="ac" value="Create"/>
            <input type="submit" name ="ac" value="Edit"/>
            <input type="submit" name="ac" value="Delete"/>
        </form>
        <br>
        <table border="2">
            <th>ID</th>
            <th>Title</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Date Of Birth</th>
            <th>Status</th>
            <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.title}</td>
                <td>${user.firstname}</td>
                <td>${user.surname}</td>
                <td>${user.dateofbirth}</td>
                <td>${user.status}</td>
            </tr>
            </c:forEach>
    </body>
</html>
