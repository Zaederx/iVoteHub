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
<form:form action = "${pageContext.request.contextPath}/authenticate"  method ="POST">
	<h1>Username</h1>
		<input  type="text" name="username"/>
	<h1> Password</h1>
		<input type="password" name="password"/>
	<input type="submit" value="Login"/>
</form:form>

</body>
</html>