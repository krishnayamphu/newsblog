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
    <%
        List<Category> categories= (List<Category>) request.getAttribute("categories");
        for(Category category:categories){
    %>
    <tr>
        <td> <%= category.getId() %></td>
        <td> <%= category.getName() %></td>
        <td> <%= category.getCratedAt() %></td>
        <td>
            <a href="">edit</a>
            <form action="category" method="post">
                <input type="hidden" name="id" value="<%= category.getId() %>">
                <button type="submit">delete</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>

</body>
</html>
