<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nz
  Date: 20.05.16
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="java.lang.Long" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" charset="UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <title>Редактирование пользователя</title>
</head>
<body>
<div align="center">
    <h2>Редактирование пользователя</h2>
    <jsp:useBean id="user" class="objects.User" scope="application"/>
    <form action="/update" method="get" accept-charset="UTF-8">
        <table>
            <tr>
                <td>ID:</td>
                <td>
                    ${user.id}
                    <input name="id" value="${user.id}" hidden />
                </td>
            </tr>
            <tr>
                <td>Имя:</td>
                <td>
                    <input name="name" value="${user.name}" />
                </td>
            </tr>
            <tr>
                <td>Возраст:</td>
                <td>
                    <input name="age" value="${user.age}" type="number" />
                </td>
            </tr>
            <tr>
                <td>Администратор:</td>
                <td>
                    <input name="admin" value="true" type="checkbox" ${user.admin == 'true' ? 'checked' : ''}/>
                </td>
            </tr>
            <tr>
                <td>Дата создания:</td>
                <td>
                    ${user.createDate}
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2"><input type="submit" value="Сохранить" /></td>
            </tr>
        </table>
    </form>
    <input type="button" onclick="location.href='/home'" value="На главную" >
</div>

</body>
</html>
