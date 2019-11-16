<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h2>Welcome ${name}</h2>
	</div>
	
	<div class="tron text-center">
	
	<%
	String link = "pointer-events: none; cursor: default";
	boolean voted = Boolean.parseBoolean(request.getParameter("voted"));
	if ( voted == true ) {
		out.println("<h4 style=\"color:tomato;\">You have already voted.</h4>");
		request.setAttribute("disabled", " disabled");
		request.setAttribute("link",link);
	} %>
		<a href="${pageContext.request.contextPath}/voter/vote" style="${link}"><button type="submit"  class="btn default-btn${disabled}">Vote</button></a>
		
		<form:form action="${pageContext.request.contextPath}/logout" style="display:inline;" method="POST">
		<a><button type="submit"name="logout" class="btn default-btn" id="logout">Logout</button></a>
		</form:form>
	</div>
	</div>
</body>
</html>