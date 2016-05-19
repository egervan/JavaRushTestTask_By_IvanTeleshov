<%--
  Created by IntelliJ IDEA.
  User: nz
  Date: 19.05.16
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List of teams</h1>
<p>Here you can see the list of the teams, edit them, remove or update.</p>
<c:foreach var="user" items="${}">
</c:foreach><table border="1px" cellpadding="0" cellspacing="0">
    <thead>
    <tr>
        <th width="10%">id</th><th width="15%">name</th><th width="10%">rating</th><th width="10%">actions</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.admin}</td>
        <td>
            <a href="${pageContext.request.contextPath}/update/${team.id}.html">Edit</a><br>
            <a href="${pageContext.request.contextPath}/delete/${team.id}.html">Delete</a><br>
        </td>
    </tr>

    </tbody>
</table>

<p><a href="${pageContext.request.contextPath}/start.jsp">Home page</a></p>
</body>
</html>
