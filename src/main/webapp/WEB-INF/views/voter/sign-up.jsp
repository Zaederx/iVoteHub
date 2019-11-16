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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

  <!-- Popper JS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="jumbotron text-center">
<h1>Voter Registration</h1>
<ul class="nav nav-tabs justify-content-center">
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="${pageContext.request.contextPath}/voter-registration">Register</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
      </li>
</ul>
</div>
<div class="container col-sm-2">

<div class="form-group text-center">
<h3>Please enter the following details:</h3>
<form:form action="${pageContext.request.contextPath}/register-voter-form" modelAttribute="voterForm" method="POST"> 
<!-- Make sure to have a tool tup explaining what is meant by fullname -->
	<form:label path="name">Name</form:label><br>
 	<form:input path="name" class="form-control"/><br>
 	
 	<form:label path="username">Username</form:label><br>
 	<form:input path="username" class="form-control"/><br>
 	
 	<form:label path="email">Email</form:label><br>
 	<form:input path="email" class="form-control"/><br>
 	
 	<form:label path="password">Password</form:label><br>
 	<form:password  path="password" class="form-control"/><br>
 	<form:label  path="password2">Re-enter Password</form:label><br>
 	<form:password path="password2" class="form-control"/><br>
 	
 	<form:label path="sniNum">SNI number</form:label><br> <!-- Add tool tip later -->
 	<form:input path="sniNum" class="form-control" placeholder="098234098234908" /><br><br>
 	
 	<button type="submit" class="btn btn-primary" value="Register">Register</button>

 </form:form>
</div>
</div>
</body>
</html>