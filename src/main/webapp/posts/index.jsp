<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Posts</title>
</head>
<body>
<a href="post-create">Add Post</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Category</th>
        <th>Created Date</th>
        <th>Updated Date</th>
        <th>Action</th>
    </tr>
    <c:forEach var="post" items="${posts}">
    <tr>
        <td> ${post.id}</td>
        <td> ${post.title}</td>
        <td> ${post.title}</td>
        <td> ${post.createdAt}</td>
        <td> ${post.updatedAt}</td>
        <td>
            <a href="post-edit?id=${post.id}">edit</a>
            <form action="posts" method="post">
                <input type="hidden" name="id" value="${post.id}">
                <button type="submit">delete</button>
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
