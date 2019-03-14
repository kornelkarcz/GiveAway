<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="fake">
    <div class="form-group">
        <label for="email">Email:</label>
        <form:input path="email" class="form-control" type="text" name="email"/>
    </div>
    <div class="form-group">
        <label for="password">Password:</label>
        <form:input path="password" class="form-control" type="password" name="password"/>
    </div>

    <button class="btn btn-primary btn-block active">Submit</button>
</form:form>

</body>
</html>
