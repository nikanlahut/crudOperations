<%--
  Created by IntelliJ IDEA.
  User: monster
  Date: 23.12.2021
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<div align="center">
<h1>Edit Student</h1>
<form:form action="save" method="post" modelAttribute="student">
    <table cellpadding="5">
        <form:hidden path="student_id" />
    <tr>
        <td>Name:</td>
        <td><form:input path="student_name" /></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><form:input path="student_email" /></td>
    </tr>
        <tr>
            <td colspan="2" align="center"> <input type="submit" value="Save"/></td>
        </tr>
    </table>
</form:form>
</div>
</body>
</html>
