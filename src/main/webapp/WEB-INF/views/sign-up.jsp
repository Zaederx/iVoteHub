<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register For Voting</title>
<!-- CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-center">
<h1>Voter Registration</h1>
</div>
<div class="form-group text-center">
<h2>Please enter the following details:</h2>
<form:form action="${pageContext.request.contextPath}/register/post" modelAttribute="voterForm"> 
<!-- Make sure to have a tool tup explaining what is meant by fullname -->
	<form:label path="name">Name</form:label><br>
 	<form:input path="name"/><br>
 	
 	<form:label path="username">Username</form:label><br>
 	<form:input path="username"/><br>
 	
 	<form:label path="email">Email</form:label><br>
 	<form:input path="email"/><br>
 	
 	<form:label path="password">Password</form:label><br>
 	<form:password  path="password"/><br>
 	<form:label  path="password2">Re-enter Password</form:label><br>
 	<form:password path="password2"/><br>
 	
 	<form:label path="sniNum">SNI number</form:label><br> <!-- Add tool tip later -->
 	<form:input path="sniNum"/><br><br>
 	

 	<input type="submit" class="btn btn-default" value="Register"/>
 </form:form>
</div>
</body>
</html>