<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Voting Page</title>
</head>
<body>
<div class="jumbotron text-center">
<div>
<p>Please Select one candidate of a constituency for whom you will vote</p>
<form:form action="${pageContent.request.contextPath}/voter/vote-post" modelAttribute="voteForm">
<table>
	<tr> 
		<th>Candidate</th>
		<th>Constituency</th>
		<th>Select</th>
	</tr>
	<c:forEach var = "candidate" items ="${candidates}" >
		<tr>
			<td>${candidate.name}</td>
			<td>${candidate.constituency}</td>
			<td> <form:button  class="btn btn-default" type="submit" path="vote" value="${candidate.username}"></form:button> </td>
		</tr>
	</c:forEach>
</table>
</form:form>
</div>
</div>
</body>
</html>