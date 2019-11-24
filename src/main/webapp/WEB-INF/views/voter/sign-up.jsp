<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<div class="container col-sm-8">
  <h3 class="d-flex justify-content-center">Please enter the following details:</h3>
<div class="container col-sm-10 d-flex justify-content-center">
  <div class="form-group text-center">

<!-- Spring form tags automatically make use of csrf tags for security -->
  <form:form action="${pageContext.request.contextPath}/register-voter-form" modelAttribute="voterForm" class="justify-content-center" method="POST">
  <!-- Make sure to have a tool tup explaining what is meant by fullname -->
  	<form:label path="name">Name</form:label><br>
   	<form:input path="name" class="form-control text-center" placeholder="Jack Sparrow"/><br>
   	<form:errors path="name" class="alert alert-danger" style="display:block"/>

	<c:if test="${param.error != null}">
   		</c:if>

   	<form:label path="username">Username</form:label><br>
   	<form:input path="username" class="form-control text-center" placeholder="ThePirate"/><br>
   	<form:errors path="username" class="alert alert-danger" style="display:block"/>

   	<form:label path="email">Email</form:label><br>
   	<form:input path="email" class="form-control text-center" placeholder="theBlackPearl@sevenseas.com"/><br>
   	<form:errors path="email" class="alert alert-danger" style="display:block"/>
   	
   	<form:label path="password">Password</form:label><br>
   	<form:password  path="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" <%--To catch password error on client end before sending the entire form for backend validation --%>
   	title="Ensure password is at least 8 characters long, has at least one uppercase and one lowercase letter, and contains at least one number. Special characters are not necessary, but recommended" class="form-control text-center" placeholder="DavieJonesLocker!25"/><br>
   	<form:errors path="password" class="alert alert-danger" style="display:block"/>
   		
   	<form:label  path="password2">Re-enter Password</form:label><br>
   	<form:password path="password2" class="form-control text-center" placeholder="DavieJonesLocker!25"/><br>
   	<form:errors path="password2" style="display:block"/><br>
 
   	<form:label path="sniCode">SNI number</form:label><br> 
   	<form:input path="sniCode" class="form-control text-center" placeholder="R8HFERGO8UHE5GU"/><br>
   	<form:errors path="sniCode" class="alert alert-danger" style="display:block"/><br><br><br>

   	<button type="submit" class="btn btn-primary" value="Register">Register</button><br><br><br><br>

   </form:form>
 </div>
  </div>
</div>
</body>
</html>
