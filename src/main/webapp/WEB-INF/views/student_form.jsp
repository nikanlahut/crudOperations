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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Edit Student</title>
</head>
<body class="p-3 mb-2 bg-dark text-white">
<div align="center">
<h1 class="display-2">Edit Student</h1>
<form:form action="save" method="post" modelAttribute="student" >
    <table class="align-middle">
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
            <td colspan="2" align="center"> <div class="d-grid gap-2 col-6 mx-auto"> <input class="btn btn-secondary" type="submit" value="Save"/> </div></td>
        </tr>
    </table>
    </div>
</form:form>
</body>
</html>
