<%--
  Created by IntelliJ IDEA.
  User: nz
  Date: 19.05.16
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start page</title>
</head>
<body>
<h1>Home page</h1>
<p>
    ${message}<br>
    <a href="${pageContext.request.contextPath}/addUserPage.jsp">Add new user</a><br>
    <a href="${pageContext.request.contextPath}/AllUsers.jsp">List users</a><br>
</p>
</body>
</html>
