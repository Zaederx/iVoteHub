<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register For Voting</title>
</head>
<body>
<p>Please enter the following details:</p>
<form:form action="${pageContext.request.contextPath}/registerUser" modelAttribue="voter"> 
<!-- Make sure to have a tool tup explaining what is meant by fullname -->
	<p> Full name:</p>
 	<form:input path="fullname"/>
 	<p> Email Address: </p>
 	<form:input path="email"/>
 	<p>SNI</p>
 	<form:input path="sni"/>
 	
 	<input type="submit" value="Register"/>
 </form:form>

</body>
</html>