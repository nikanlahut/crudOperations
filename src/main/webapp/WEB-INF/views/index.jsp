<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Manager Home</title>
</head>
<body>
    <div align="center">
        <h1>Student List</h1>
        <h3> <a href="new">New Student</a> </h3>
        <table border="1" cellpadding="5">
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
                        <a href="edit?student_id=${student.student_id}">Edit</a>
                        &nbsp;&nbsp;
                        <a href="delete?student_id=${student.student_id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
<br/>
</body>
</html>