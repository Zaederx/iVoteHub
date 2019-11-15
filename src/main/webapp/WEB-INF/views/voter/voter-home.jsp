<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Welcome to the iVoteHub</title>
	<!-- CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	
	<!-- JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>

<body>
	<div class= "jumbotron text-center" >
		<h1>Voter Home Page</h1>
		<h2>Welcome <c:out value="${name}"></c:out></h2>
	</div>
	<div class="tron text-center">
		<a href="${pageContext.request.contextPath}/voter/vote"><button type="button" class="btn default-btn">Vote</button></a>
		<a href="/logout"><button type="button" class="btn default-btn">Logout</button></a>
	</div>
</body>
</html>