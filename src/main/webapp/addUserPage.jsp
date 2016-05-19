<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nz
  Date: 19.05.16
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add team page</h1>
<p>Here you can add a new team.</p>
<form:form method="POST" commandname="addUser" action="${pageContext.request.contextPath}/team/add/process.html">
    <table>
        <tbody>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"></form:input></td>
        </tr>
        <tr>
            <td>Rating:</td>
            <td><form:input path="rating"></form:input></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add"></td>
            <td></td>
        </tr>
        </tbody>
    </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/start.jsp">Home page</a></p>
</body>
</html>
