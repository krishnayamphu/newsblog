<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Category</title>
</head>
<body>

<h4>Create new Category</h4>
<form action="category-create" method="post">
    <label>Name</label>
    <input type="text" name="name">
    <br><br>
    <label>Description</label>
    <textarea name="description" cols="30" rows="10"></textarea>
    <br><br>
    <button type="submit">Create</button>
</form>

</body>
</html>
