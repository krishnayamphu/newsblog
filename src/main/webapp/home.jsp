<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/all.css">
    <title>Home | NewsBlog</title>
</head>
<body>
<div class="container">
    <div class="row">
        <c:forEach var="post" items="${posts}">
            <div class="col">
                <div class="card">
                    <h3 class="post-title">${post.title}</h3>
                    <img src="uploads/${post.imagePath}" class="post-thumb">
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
