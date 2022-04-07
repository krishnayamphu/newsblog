<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${path}/css/style.css">
    <title>Create Category</title>
</head>
<body>
<jsp:include page="../admin/header.jsp"/>
<div class="container">
    <h4 class="text-center pt-30">Create new Category</h4>
    <form class="myform" action="category-create" method="post">
        <label>Name</label>
        <input type="text" name="name">
        <label>Description</label>
        <textarea name="description" cols="30" rows="10"></textarea>
        <button type="submit">Create</button>
    </form>
</div>
</body>
</html>
