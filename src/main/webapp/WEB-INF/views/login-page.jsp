<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate Login</title>
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
<h1>Voter Login</h1>
<ul class="nav nav-tabs justify-content-center">
      <li class="nav-item">
        <a class="nav-link" href="${pageContent.request.contextPath}/home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContent.request.contextPath}/voter-registration">Register</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="${pageContent.request.contextPath}/login">Login</a>
      </li>
</ul>
</div>
<div class="container col-sm-2">
<div class="form-group text-center">
<form:form action = "${pageContext.request.contextPath}/authenticate"  method ="POST">

	<h3>Username</h3>
		<input   type="text" class="form-control" name="username"/>
	<h3> Password</h3>
		<input type="password" class="form-control"name="password"/><br><br>
	<button type="submit" class="btn btn-primary" value="Login">Login</button>
</form:form>
</div>
</div>
</body>
</html>