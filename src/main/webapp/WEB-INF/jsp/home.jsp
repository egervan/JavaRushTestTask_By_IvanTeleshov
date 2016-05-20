<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

        <c:set var="totalCount" scope="session" value="${users.size()}"/>
        <c:set var="perPage" scope="session"  value="10"/>
        <c:set var="pageStart" value="${param.start}"/>
        <c:if test="${empty pageStart or pageStart < 0}">
            <c:set var="pageStart" value="0"/>
        </c:if>
        <c:if test="${totalCount < pageStart}">
            <c:set var="pageStart" value="${pageStart - 10}"/>
        </c:if>

    <c:forEach items="${users}" var="user" begin="${pageStart}" end="${pageStart + perPage - 1}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.admin}</td>
            <td>${user.createDate}</td>
            <td><div align="center">
                <input type="button"  onclick="location.href='/update/${user.id}'" value="Редактировать" >
            </div></td>
            <td><div align="center">
                <input type="button"  onclick="location.href='/delete/${user.id}'" value="Удалить" >
            </div></td>
        </tr>
    </c:forEach>
    </table>
    <a href="?start=${pageStart - perPage}"><<</a>${pageStart + 1} - ${pageStart + perPage}
    <a href="?start=${pageStart + perPage}">>></a>
    <input type="button" onclick="location.href='/add'" value="Добавить пользователя" >
    <h3>Всего записей ${users.size()}</h3>
</div>
</body>
</html>