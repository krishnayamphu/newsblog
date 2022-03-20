<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.aptech.models.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Category</title>
</head>
<body>
<a href="category-create">Add Category</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Created Date</th>
        <th>Action</th>
    </tr>
    <c:forEach var="category" items="${categories}" varStatus="i">
    <tr>
        <td> ${category.id}</td>
        <td> ${category.name}</td>
        <td> ${category.createdAt}</td>
        <td>
            <a href="category-edit?id=${category.id}">edit</a>
            <form action="category" method="post">
                <input type="hidden" name="id" value="${category.id}">
                <button type="submit">delete</button>
            </form>
        </td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
