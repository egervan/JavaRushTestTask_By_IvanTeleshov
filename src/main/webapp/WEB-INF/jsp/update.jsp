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
    <jsp:useBean id="user" class="objects.User" scope="application"  />
  <%--  <jsp:setProperty name="user" property="id" value="${user.id}" />
    <jsp:setProperty name="user" property="createDate" value="${user.createDate}" />--%>

    <form action="/update" method="get">
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
<%--
                    <jsp:setProperty name="userForm" property="name">
--%>
                    <input name="name" value="${user.name}" />
<%--
                    </jsp:setProperty>
--%>
                </td>
            </tr>
            <tr>
                <td>Возраст:</td>
                <td>
<%--
                    <jsp:setProperty name="userForm" property="age">
--%>
                    <input name="age" value="${user.age}" />
<%--
                    </jsp:setProperty>
--%>
                </td>
            </tr>
            <tr>
                <td>Администратор:</td>
                <td>
<%--
                    <jsp:setProperty name="userForm" property="admin">
--%>
                    <input name="admin" value="${user.admin}" />
<%--
                    </jsp:setProperty>
--%>
                </td>
            </tr>
            <tr>
                <td>Дата создания:</td>
                <td>
                    ${user.createDate}
                     <input name="createdDate" value="${user.createDate}" hidden/>
                </td>
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
