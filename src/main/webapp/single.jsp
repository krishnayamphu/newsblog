<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/all.css">
    <title>${post.title}</title>
</head>
<body>
<header>
    <h3>News Blog</h3>
    <p>Digital online news blog</p>
</header>
<nav>
    <a href="home">Home</a>
    <a href="about">About</a>
    <a href="contact">Contact</a>
</nav>
<div class="container">
    <div class="card">
        <h1>${post.title}</h1>
        <img class="full-img" src="uploads/${post.imagePath}">
        <p>${post.content}</p>
    </div>

</div>
</body>
</html>
