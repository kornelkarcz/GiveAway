<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Oddaj rzeczy</title>
    <link rel="stylesheet" href="/css/styles.css"/>
</head>
<body>

<c:choose>
    <c:when test="${check == true}">
        <%@include file="adminHeader.jsp" %>
    </c:when>
    <c:when test="${sessionScope.logged != null}">
        <%@include file="loggedHeader.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="header.jsp" %>
    </c:otherwise>
</c:choose>


<c:choose>
    <c:when test="${check == true}">
        <%@include file="adminBody.jsp" %>
    </c:when>
    <c:when test="${sessionScope.logged != null}">
        <%@include file="loggedBody.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="unloggedBody.jsp" %>
    </c:otherwise>
</c:choose>


<%@include file="footer.jsp"%>
<script src="js/app.js"></script>
</body>
</html>
