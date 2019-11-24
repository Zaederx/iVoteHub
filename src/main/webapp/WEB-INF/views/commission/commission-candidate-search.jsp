<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

  <!-- Popper JS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

  <!-- JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Candidate Search</title>
</head>
<body>
<div class="jumbotron text-center">
    <h1>Search</h1>
      <ul class="nav nav-tabs justify-content-center">
        <li class="nav-item">
          <a class="nav-link active" href="${pageContext.request.contextPath}/commission/home">Candidate Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/commission/view-polls">View Polls</a>
        </li>
        <li>
       		<a class="nav-link" href="${pageContext.request.contextPath}/commission/candidate-search">Candidate Search</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
        </li>
      </ul>
  </div>

<!--   <div class="container justify-content-center"> -->
<label>Enter Candidate Name</label>
  <input type="text" id="candidateName">
    <label id="cName"></label>
  <label id="constituency"></label>
  <label id="votes"></label>
<!--   </div> -->
  
  <script type="text/javascript">

  	$(document).ready(function(){
  		$("#candidateName").keyup(function(){
  			$.ajax({
  				type:"GET",
  				url: "${pageContext.request.contextPath}commission-rest/candidate/" + $('#candidateName').val(),
  				success: function(result){
  					if (result.trim() == '{}'){
  						$('#cName').html("No Candidate with the specified name.");
  						$('#constituency').html("");
  						$('#votes').html("");
  					} else {

  						var candidate = jQuery.parseJSON(result);
  						var name = candidate.name;
  						var constituency = candidate.constituency;
  						var votes = candidate.votes;

  						$('#cName').html(name);
  						$('#constituency').html(constituency);
  						$('#votes').html(votes);
  					}
  				}
  			});
  		});
  	});
  </script>
</body>
</html>
