<%--
  Created by IntelliJ IDEA.
  User: kornelkarcz
  Date: 2019-03-13
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    session.invalidate();
%>

<script>
    var timer = setTimeout(function() {
        window.location='http://localhost:8080'
    }, 2000);
</script>

</body>
</html>
