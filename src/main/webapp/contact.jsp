<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/all.css">
    <title>Contact | NewsBlog</title>
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
    <h4>Contact Us</h4>
    <form class="contact-form" action="">
        <label>Fullname:</label>
        <input type="text" name="name">

        <label>Email:</label>
        <input type="email" name="email">

        <label>Mobile:</label>
        <input type="number" name="mobile">

        <label>Message:</label>
        <textarea name="message" cols="30" rows="10"></textarea>

        <button type="submit">Send</button>
    </form>

</div>

<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d56518.26546463849!2d85.2805307186172!3d27.70519324481474!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2snp!4v1648546403134!5m2!1sen!2snp" width="100%" height="400" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
</body>
</html>
