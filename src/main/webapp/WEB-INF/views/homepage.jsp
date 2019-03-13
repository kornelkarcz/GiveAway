<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
    <%@ include file="dependencies.jsp" %>
</head>
<body>

<c:choose>
    <c:when test="${sessionScope.logged != null}">
        <%@include file="loggedHeader.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="header.jsp" %>
    </c:otherwise>
</c:choose>

<section class="main-container">
    <article class="index-intro">
        <h1>Welcome to GiveAway</h1>

        <a href="http://localhost:8080/register">Register</a><br>
        <a href="http://localhost:8080/login">Login</a><br>
    </article>
</section>

</body>
</html>
