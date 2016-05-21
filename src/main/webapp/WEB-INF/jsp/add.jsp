<%--
  Created by IntelliJ IDEA.
  User: nz
  Date: 20.05.16
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" charset="UTF-8">
    <title>Добавление пользователя</title>
</head>
<body>
<div align="center">
    <jsp:useBean id="userForm" class="objects.User" scope="application" />
    <form action="/addAction" method="get" accept-charset="UTF-8">
        <table>
            <tr>
                <td>Имя:</td>
                <td><input name="name" value="" /></td>
            </tr>
            <tr>
                <td>Возраст:</td>
                <td><input name="age" value="" type="number"/></td>
            </tr>
            <tr>
                <td>Администратор:</td>
                <td>
                    <input name="admin" value="true" type="checkbox" ${user.admin == 'true' ? 'checked' : ''}/>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2"><input type="submit" value="Сохранить" /></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
