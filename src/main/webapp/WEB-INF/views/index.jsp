<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Student Manager Home</title>
</head>
<body class="p-3 mb-2 bg-dark text-white"></div>
    <div align="center">
        <h1 class="display-1">Student List</h1>
        <h3> <a href="new" class="btn btn-success btn-lg" role="button">Create New Student</a> </h3>
        <table class="table table-dark table-striped" border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${listStudent}" var="student" varStatus="status">
                <tr>
                    <td>
                            ${student.student_id}
                    </td>
                    <td>
                        ${student.student_name}
                    </td>
                    <td>
                            ${student.student_email}
                    </td>
                    <td>
                        <div class="d-grid gap-2 d-md-block">
                        <a class="btn btn-warning btn-sm" href="edit?student_id=${student.student_id}" role="button">Edit</a>
                        &nbsp;&nbsp;
                        <a class="btn btn-danger btn-sm" href="delete?student_id=${student.student_id}" role="button">Delete</a>
                            </div>
                       </td>
                </tr>
            </c:forEach>
        </table>

    </div>
<br/>
</body>
</html>