<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate Login</title>
</head>
<body>
<form:form action = "${pageContext.request.contextPath}/loginForm" modelAttribute="LoginForm"  method ="POST">
	<form:label path="usertype" modelAttribute= "usertype"> UserType</form:label>
		<form:select  path="usertype" size="1" items="${usertypeMap}"/>
	<form:label path="username"> Username</form:label>
		<form:input path="username"/>
	<form:label path="password"> Password</form:label>
		<form:input path="password"/>
<input type="submit" value="Login"/>
</form:form>

</body>
</html>