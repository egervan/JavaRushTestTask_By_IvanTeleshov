<%--
  Created by IntelliJ IDEA.
  User: nz
  Date: 20.05.16
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>
<html>
<head>
    <title>Добавление пользователя</title>
</head>
<body>
<div align="center">
    <jsp:useBean id="userForm" class="objects.User" scope="application"  />
    <form action="/addAction" method="get">
        <table>
            <tr>
                <td>ID:</td>
                <td><input name="id" value="${user.id}" readonly/></td>
            </tr>
            <tr>
                <td>Имя:</td>
                <td><input name="name" value="${user.name}" /></td>
            </tr>
            <tr>
                <td>Возраст:</td>
                <td><input name="age" value="${user.age}" /></td>
            </tr>
            <tr>
                <td>Администратор:</td>
                <td><input name="admin" value="${user.admin}" /></td>
            </tr>
            <tr>
                <td>Администратор:</td>
                <td><input name="admin" value="${user.createDate}" readonly/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Отправить" /></td>
            </tr>
        </table>
    </form>
    <input type="button" onclick="location.href='/home'" value="На главную" >
</div>

</body>
</html>
