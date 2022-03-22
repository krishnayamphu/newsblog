<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Post</title>
</head>
<body>

<h4>Post Details</h4>
<form action="post-edit" method="post">
    <input type="hidden" name="id" value="${post.id}">
    <label>Title</label>
    <input type="text" name="title" value="${post.title}">
    <br><br>
    <label>Content</label>
    <textarea name="content" cols="30" rows="10">${post.content}</textarea>
    <br><br>
    <label>Image</label>
    <input type="text" name="image" value="${post.imagePath}">
    <br><br>
    <label>Category</label>
    <select name="category">
        <option>select category</option>
        <c:forEach var="category" items="${categories}">
            <option value="${category.getId()}"> ${category.getName()}</option>
        </c:forEach>
    </select>
    <br><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
