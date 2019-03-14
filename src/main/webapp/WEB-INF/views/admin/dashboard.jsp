<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Admin</title>
    <%@ include file="../dependencies.jsp" %>
</head>
<body>

<c:choose>
    <c:when test="${check == true}">
        <%@include file="../adminHeader.jsp" %>
    </c:when>
    <c:when test="${sessionScope.logged != null}">
        <%@include file="../loggedHeader.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="../header.jsp" %>
    </c:otherwise>
</c:choose>

<section class="main-container">
    <article class="index-intro">

        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <div id="list-example" class="list-group">
                <a class="list-group-item list-group-item-action" href="#">Users</a>
                <a class="list-group-item list-group-item-action" href="#">Advertisements</a>
                <a class="list-group-item list-group-item-action" href="#">Institutions</a>
            </div>
            <div data-spy="scroll" data-target="#list-example" data-offset="0" class="scrollspy-example">
            </div>
        </div>
        <div class="col-sm-4"></div>

    </article>
</section>

<%@include file="../footer.jsp"%>>
</body>
</html>
