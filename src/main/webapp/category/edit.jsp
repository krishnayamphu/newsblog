<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${path}/css/style.css">
    <title>Update Category</title>
</head>
<body>
<jsp:include page="../admin/header.jsp"/>
<div class="container">
    <h4 class="text-center pt-30">Category Details</h4>
    <form class="myform" action="category-edit" method="post">
        <input type="hidden" name="id" value="${category.id}">
        <label>Name</label>
        <input type="text" name="name" value="${category.name}">
        <label>Description</label>
        <textarea name="description" cols="30" rows="10">${category.description}</textarea>
        <button type="submit">Update</button>
    </form>
</div>

</body>
</html>
