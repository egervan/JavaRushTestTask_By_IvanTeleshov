<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nz
  Date: 20.05.16
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>
<%@ page import="java.lang.Long" %>
<%--<jsp:useBean id="createDate" class="java.lang.Long"/>
<jsp:setProperty name="createDate" property="time" value="${user.createDate.time}"/>--%>
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
                     <%--<input name="createDate" value="${user.createDate}" type="" hidden/>--%>
                       <%-- <c:if test="${user.createDate != null}">
                            <form:hidden path="createDate" value="${user.createDate}" id="createDate"/>
                        </c:if>--%>
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
