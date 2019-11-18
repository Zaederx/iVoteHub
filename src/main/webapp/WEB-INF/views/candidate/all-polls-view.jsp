<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>All Polls</title>
</head>
<body>
  <div class="jumbotron text-center">
      <h1>All Polls</h1>
      <ul class="nav nav-tabs justify-content-center">
        <li class="nav-item">
          <a class="nav-link" href="${pageContent.request.contextPath}/candidate/home">Candidate Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContent.request.contextPath}/candidate/view-polls">View Polls</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContent.request.contextPath}/logout">Logout</a>
        </li>
      </ul>
    </div>

    <div class="container text-center">

      <div id="poll-accordian">

       <div class="card">
         <div class="card-header">
           <a class="card-link" data-toggle="collapse" href="#c1">
             Candidates
           </a>
         </div>
         <div id="c1" class="collapse show" data-parent="#poll-accordian">
           <div class="card-body">
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
         </div>
       </div>

       <div class="card">
         <div class="card-header">
           <a class="collapsed card-link" data-toggle="collapse" href="#c2">
             Constituency
           </a>
         </div>
         <div id="c2" class="collapse" data-parent="#poll-accordian">
           <div class="card-body">
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
         </div>
       </div>

       <div class="card">
         <div class="card-header">
           <a class="collapsed card-link" data-toggle="collapse" href="#c3">
             Statistics
           </a>
         </div>
         <div id="c3" class="collapse" data-parent="#poll-accordian">
           <div class="card-body">
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
         </div>
       </div>

     </div>

    </div>
</body>
</html>
