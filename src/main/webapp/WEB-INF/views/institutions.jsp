<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Institutions</title>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <sec:authorize access="!isAuthenticated()" >
                <li><a href="${pageContext.request.contextPath}/user/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                <li><a href="${pageContext.request.contextPath}/user/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="logged-user">
                    Witaj <sec:authentication property="name"/>
                    <ul class="dropdown">
                        <li><a href="#">Profil</a></li>
                        <li><a href="#">Wyloguj</a></li>
                    </ul>
                </li>
            </sec:authorize>
        </ul>

        <ul>
            <li><a href="${pageContext.request.contextPath}/" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border">Fundacje</a></li>
            <li><a href="#" class="btn btn--without-border">Użytkownicy</a></li>
            <li><a href="#" class="btn btn--without-border">Administracja</a></li>
        </ul>
    </nav>
    <section type="table">
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">id</th>
                <th scope="col">Name</th>
                <th scope="col">Description</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <c:forEach items="${institutions}" var="institution">
                <tr>
                    <th scope="row">${institution.id}</th>
                    <td>${institution.name}</td>
                    <td>${institution.description}</td>
                    <td>@mdo</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>

    <footer>
    </footer>

    <script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
