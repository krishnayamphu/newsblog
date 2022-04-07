<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${path}/css/style.css">
    <title>Update Post</title>
</head>
<body>
<jsp:include page="../admin/header.jsp"/>
<div class="container">
    <h4>Post Details</h4>
    <form action="post-edit" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${post.id}">
        <label>Title</label>
        <input type="text" name="title" value="${post.title}" required>
        <br><br>
        <label>Content</label>
        <textarea name="content" cols="30" rows="10">${post.content}</textarea>
        <br><br>
        <label>Image</label>
        <c:choose>
            <c:when test="${not empty post.imagePath}">
                <img src="uploads/${post.imagePath}" width="100">
                <input type="text" name="image" value="${post.imagePath}" readonly>
            </c:when>
        </c:choose>
        <input type="file" name="upfile">
        <br><br>
        <label>Category</label>
        <select name="category" required>
            <option value="">select category</option>
            <c:forEach var="category" items="${categories}">
                <option value="${category.getId()}"
                    ${category.getId()==post.categoryId?'selected':''}
                >
                        ${category.getName()}
                </option>
            </c:forEach>
        </select>
        <br><br>
        <button type="submit">Update</button>
    </form>
</div>
</body>
</html>
