<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.aptech.models.Category" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${path}/css/style.css">
    <title>All Category</title>
</head>
<body>
<jsp:include page="../admin/header.jsp"/>

<div class="container">
    <a class="btn-primary" href="category-create">Add Category</a>
    <table class="mytable">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Created Date</th>
            <th>Updated Date</th>
            <th>Action</th>
        </tr>
        <c:forEach var="category" items="${categories}">
            <tr>
                <td> ${category.id}</td>
                <td> ${category.name}</td>
                <td> ${category.createdAt}</td>
                <td> ${category.updatedAt}</td>
                <td>
                    <div class="action-wrap">
                        <a class="btn-primary" href="category-edit?id=${category.id}">edit</a>
                        <form action="category" method="post">
                            <input type="hidden" name="id" value="${category.id}">
                            <button class="btn-primary" type="submit">delete</button>
                        </form>
                    </div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
