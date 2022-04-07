<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${path}/css/style.css">
    <title>All Posts</title>
</head>
<body>
<jsp:include page="../admin/header.jsp"/>
<div class="container">
    <a href="post-create">Add Post</a>
    <table class="mytable">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Category</th>
            <th>Image</th>
            <th>Created Date</th>
            <th>Updated Date</th>
            <th>Action</th>
        </tr>
        <c:forEach var="post" items="${posts}">
            <tr>
                <td> ${post.id}</td>
                <td> ${post.title}</td>
                <td> ${post.getCategory()}</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty post.imagePath}">
                            <img src="uploads/${post.imagePath}" width="100">
                        </c:when>
                    </c:choose>
                </td>
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
</div>
</body>
</html>
