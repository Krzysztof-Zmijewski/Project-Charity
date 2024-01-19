<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit-user</title>
    <%@include file="header.jsp"%>
<body>
<form:form modelAttribute="user" method="post" action="/user/edit">
<div class="form-group">
    <form:label path="username">Email</form:label>
    <form:input path="username" class="form-control" aria-describedby="name" autocomplete="true"/>
</div>
<div class="form-group">
    <form:label path="firstname">Firstname</form:label>
    <form:input path="firstname" class="form-control" autocomplete="true"/>
</div>
<div class="form-group">
    <form:label path="lastname">Lastname</form:label>
    <form:input path="lastname" class="form-control" autocomplete="true"/>
</div>
<div class="form-group">
    <form:label path="password">Password</form:label>
    <form:input path="password" class="form-control" type="password" autocomplete="false"/>
</div>
    <form:input path="id" type="hidden" autocomplete="true"/>
<form:button type="submit" class="btn btn-primary">Submit</form:button>
</form:form>
<%@include file="footer.jsp" %>
</html>
