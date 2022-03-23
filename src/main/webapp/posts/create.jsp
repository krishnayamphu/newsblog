<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Post</title>
</head>
<body>

<h4>Create new Post</h4>
<form action="post-create" method="post" enctype="multipart/form-data">
    <label>Title</label>
    <input type="text" name="title" required>
    <br><br>
    <label>Content</label>
    <textarea name="content" cols="30" rows="10"></textarea>
    <br><br>
    <label>Category</label>
    <select name="category" required>
        <option value="">select category</option>
        <c:forEach var="category" items="${categories}">
            <option value="${category.getId()}">${category.getName()}</option>
        </c:forEach>
    </select>
    <br><br>
    <label>Image</label>
    <input type="file" name="upfile">
    <br><br>
    <button type="submit">Create</button>
</form>

</body>
</html>