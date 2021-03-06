<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/all.css">
    <title>Home | NewsBlog</title>
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
    <div class="row">
        <c:forEach var="post" items="${posts}">
            <div class="col">
                <div class="card">
                    <h3 class="post-title"><a href="news?id=${post.id}">${post.title}</a></h3>
                    <a href="news?id=${post.id}"><img src="uploads/${post.imagePath}" class="post-thumb"></a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
