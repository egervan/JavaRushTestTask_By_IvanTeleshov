<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Добро пожаловать</title>
</head>
<body>
<div align="center">
<h2> Добро пожаловать! </h2>
    <table border="1">
    <th>id</th>
    <th>Username</th>
    <th>age</th>
    <th>admin</th>
    <th>createDate</th>
    <th>Редактировать</th>
    <th>Удалить</th>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.admin}</td>
            <td>${user.createDate}</td>

        </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>