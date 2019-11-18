<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

  <!-- Popper JS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="jumbotron text-center">
    <h1>This is the Home JSP</h1>
    <ul class="nav nav-tabs justify-content-center">
      <li class="nav-item">
        <a class="nav-link" href="${pageContent.request.contextPath}/candidate/home">Candidate Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="${pageContent.request.contextPath}/candidate/view-polls">View Polls</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContent.request.contextPath}/logout">Logout</a>
      </li>
    </ul>
  </div>
  <div class="container text-center">
    <table class="table">
      <thead>
        <tr>
          <th>Candidate Name</th>
          <th>Candidate Constituency</th>
          <th>Votes</th>
        </tr>
      </thead>
      <c:forEach var = "candidate" items="${candidates}">
        <tbody>
          <tr>
            <td>${candidate.name}</td>
            <td>${candidate.constituency}</td>
            <td>${candidate.votes}</td>
          </tr>
        </tbody>
      </c:forEach>
    </table>
  </div>

</body>
</html>
