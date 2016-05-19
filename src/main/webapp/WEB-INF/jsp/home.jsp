<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Добро пожаловать</title>
</head>
<body>
<h4> Добро пожаловать! </h4>
<table>
    <c:forEach items="${users}" var="user">
    <tr>
        <td>${user}</td>
    </tr>
    </c:forEach>
</body>
</html>