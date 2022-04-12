<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${path}/css/style.css">
    <title>User Registration</title>
</head>
<body>
<div class="container">
    <form action="register" method="post">
        <c:if test="${err!=null}">
            <p>${err}</p>
        </c:if>
        <input type="text" name="name" placeholder="Fullname" required>
        <input type="text" name="username" placeholder="Username" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <input type="password" name="cpassword" placeholder="Confirm Password" required>
        <button type="submit">Register</button>
    </form>

    <a href="register">Create new Account</a>
</div>
</body>
</html>
