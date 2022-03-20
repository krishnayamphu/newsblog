<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Category</title>
</head>
<body>

<h4>Category Details</h4>
<form action="category-edit" method="post">
    <input type="hidden" name="id" value="${category.id}">
    <label>Name</label>
    <input type="text" name="name" value="${category.name}">
    <br><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
