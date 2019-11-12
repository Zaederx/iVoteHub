<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register For Voting</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-center">
<h1>Voter Registration</h1>
</div>
<div class="form-group">
<p>Please enter the following details:</p>
<form:form action="${pageContext.request.contextPath}/registerUser" modelAttribue="voter"> 
<!-- Make sure to have a tool tup explaining what is meant by fullname -->
	<p> Full name:</p>
 	<form:input path="fullname"/>
 	<p> Email Address: </p>
 	<form:input path="email"/>
 	<p>SNI</p>
 	<form:input path="sni"/>
 	<p>Password</p>
 	<form:input path password="password"/>
 	<form:input path password="password2"/>
 	
 	
 	<input type="submit" class="btn btn-default" value="Register"/>
 </form:form>
</div>
</body>
</html>