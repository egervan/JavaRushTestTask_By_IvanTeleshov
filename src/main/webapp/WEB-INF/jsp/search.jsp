<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <title>Результат поиска</title>
</head>
<body>
<div align="center" class="container">
    <h2> Результат поиска: </h2>

    <form name="searchForm" action="/search" method="get" >
        <td align="center" colspan="2">
            Имя: <input type="text" id="requestName" name="requestName">
            <input type="submit" value="Поиск" /></td>
    </form>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>id</th>
            <th>Имя</th>
            <th>Возраст</th>
            <th>Администратор</th>
            <th>Дата создания</th>
            <th>Редактировать</th>
            <th>Удалить</th>
        </tr>
        </thead>

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
                <td> ${user.age}</td>
                <td>
                    <input name="admin" value="true" align="center" type="checkbox" onclick="return false" readonly ${user.admin == 'true' ? 'checked' : ''}/>
                </td>
                <td>${user.createDate}</td>
                <td>
                    <input type="button"  onclick="location.href='/update/${user.id}'" value="Редактировать" >
                </td>
                <td>
                    <input type="button"  onclick="location.href='/delete/${user.id}'" value="Удалить" >
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="?requestName=${param.requestName}&start=${pageStart - perPage}">${pageStart > 0 ? '<<' : ''}</a>${pageStart + 1} - ${pageStart + perPage}
    <a href="?requestName=${param.requestName}&start=${pageStart + perPage}">${pageStart + perPage < users.size() ? '>>' : ''}</a>
    <br>
    <input type="button" onclick="location.href='/add'" value="Добавить пользователя" >
    <h3>Всего записей ${users.size()}</h3>
    <input type="button" onclick="location.href='/home'" value="На главную" >
</div>
</body>
</html>