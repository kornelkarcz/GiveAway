<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Login</title>
    <link rel="stylesheet" href="css/styles.css"/>
</head>
<body>
<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="http://localhost:8080/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="http://localhost:8080/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="http://localhost:8080/" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#" class="btn btn--without-border">O nas</a></li>
            <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">

            <section class="login-page">
                <h2>Zaloguj się</h2>
                <form name="loginForm" method="POST" action="/perform_login">
                    <div class="form-group">
                        <input type="text" name="email" placeholder="Email"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" placeholder="Hasło"/>
                    </div>
                    <div class="form-group">
                        <a href="#" class="btn btn--small btn--without-border">Przypomnij hasło</a>
                    </div>

                    <div class="form-group form-group--buttons">
                        <a href="#" class="btn btn--without-border">Załóż konto</a>
                        <button class="btn" type="submit">Zaloguj się</button>
                    </div>
                </form>
            </section>
        </div>
    </div>
</header>

</body>
</html>
