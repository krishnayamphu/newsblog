<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${path}/css/style.css">
    <title>All Users</title>
</head>
<body>
<jsp:include page="../admin/header.jsp"/>
<div class="container">
    <a href="user-create">Add User</a>
    <table class="mytable">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Username</th>
            <th>Email</th>
            <th>Created Date</th>
            <th>Action</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td> ${user.id}</td>
                <td> ${user.name}</td>
                <td> ${user.username}</td>
                <td> ${user.email}</td>
                <td> ${user.createdDate}</td>
                <td>
                    <div class="action-wrap">
                        <a class="btn-primary" href="user-edit?id=${user.id}">edit</a>
                        <form action="users" method="post">
                            <input type="hidden" name="id" value="${user.id}">
                            <button class="btn-primary" type="submit">delete</button>
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
