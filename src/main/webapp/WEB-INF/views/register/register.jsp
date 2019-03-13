<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<h1>Register nigga</h1>

<form:form method="post" modelAttribute="user">
    <div class="form-group">
        <label for="firstName">First name:</label>
        <form:input path="firstName" class="form-control" type="text" name="firstName"/>
        <form:errors path="firstName" cssClass="error"/>
    </div>
    <div class="form-group">
        <label for="lastName">Last name:</label>
        <form:input path="lastName" class="form-control" type="text" name="lastName"/>
        <form:errors path="lastName" cssClass="error"/>
    </div>
    <div class="form-group">
        <label for="email">Email:</label>
        <form:input path="email" class="form-control" type="text" name="email"/>
        <form:errors path="email" cssClass="error"/>
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <form:input path="password" class="form-control" type="password" name="password"/>
        <form:errors path="password" cssClass="error"/>
    </div>

    <button class="btn btn-primary btn-block active">Submit</button>
</form:form>


</body>
</html>
