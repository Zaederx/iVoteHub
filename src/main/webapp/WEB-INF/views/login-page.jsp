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
<div class="container col-sm-8 d-flex justify-content-center">
<form:form action="${pageContext.request.contextPath}/preprocessing" modelAttribute="loginForm" method="POST">
  <c:if test="${param.error != null}">
    <i class="alert alert-danger">
      Please enter valid username and password.</i><br><br>
  </c:if>
  <c:if test="${param.logout != null}">
    <i class="alert alert-primary">Logout successful.</i>
    <br>
      <br></c:if>
  <!-- <div class="form-group text-center col-sm-12 d-flex-vertical justify-content-center"> -->

    <h3>Username</h3>
    <form:input path="username" type="text" class="form-control" name="username"/>
   <form:errors path="username"/>
    <h3>Password</h3>
    <form:input path="password" type="password" class="form-control" name="password"/>
    <form:errors path="password"/>
    <p style="display:inline">Remember Me</p>
    <input type="checkbox" name="remember-me"/><br><br>
    <button type="submit" class="btn btn-primary" >Login</button>
<!--   </div> -->
</form:form>

</div>

</body>
</html>

