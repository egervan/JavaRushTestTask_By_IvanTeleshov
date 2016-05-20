<%--
  Created by IntelliJ IDEA.
  User: nz
  Date: 20.05.16
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление пользователя</title>
</head>
<body>
<div align="center">
    <jsp:useBean id="user" class="objects.User" scope="session" />
    <form action="/addAction" method="post">
        <table>
            <%--<tr>
                <td>ID:</td>
                <td><input name="id" value="${userForm.id}" /></td>
            </tr>--%>
            <tr>
                <td>Имя:</td>
                <td><input name="name" value="${userForm.name}" /></td>
            </tr>
            <tr>
                <td>Возраст:</td>
                <td><input name="age" value="${userForm.age}" /></td>
            </tr>
            <tr>
                <td>Администратор:</td>
                <td><input name="admin" value="${userForm.admin}" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Отправить" /></td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
