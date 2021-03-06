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
          <a class="nav-link" href="${pageContent.request.contextPath}/commission/home">Candidate Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContent.request.contextPath}/commission/view-polls">View Polls</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContent.request.contextPath}/logout">Logout</a>
        </li>
      </ul>
    </div>

    <div class="container text-center">

      <div id="poll-accordian">

       <div class="card" onclick="location.reload();">
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
                 <tbody id="candidate-table">
                   <!-- <tr>
                     <td>${candidate.name}</td>
                     <td>${candidate.constituency.name}</td>
                     <td>${candidate.count}</td>
                   </tr> -->
                 </tbody>
               </c:forEach>
             </table>
           </div>
         </div>
       </div>

       <div class="card" onclick="location.reload();">
         <div class="card-header">
           <a class="collapsed card-link" data-toggle="collapse" href="#c2">
             Constituency
           </a>
         </div>
         <div id="c2" class="collapse show" data-parent="#poll-accordian">
           <div class="card-body">
             <table class="table">
               <thead>
                 <tr>
                   <th>Constituency Name</th>
                   <th>Constituency Votes</th>
                   <th></th>
                 </tr>
               </thead>
               <c:forEach var = "party" items="${parties}">
                 <tbody id="party-table">
                   <!-- <tr>
                     <td>${party.name}</td>
                     <td>${party.count}</td>
                     <td></td>
                   </tr> -->
                 </tbody>
               </c:forEach>
             </table>
           </div>
         </div>
       </div>

     </div>

    </div>
    <script>
      window.onload = () => {
        getCandidates()
        getParties()
      }
      function success(res) {
        console.log(res)
        console.log(res[0])
        var html =  ''
        var count = 0
        var tableBody = document.querySelector('#candidate-table')
        $('#candidate-table').empty()
        for (let index = 0; index < res.length; index++) {
          var candidate = res[index];
          html += '<tr>'
            + '<td>'+candidate.name+ '</td>'
          + '<td>'+candidate.constituency+'</td>'
          + '<td>'+candidate.votes+'</td>'
          + '</tr>\n'
        }
        tableBody[0]=''
        tableBody.innerHTML = html
       
        
      }

      function error() {
        console.error('There is an error retrieving response from server at: /candidates-all')
      }
    setInterval(function() {
      getCandidates()
    	// location.reload();
    }, 18050)

    function getCandidates() {
      $.ajax({
        method:'GET',
        url: '/candidates-all',
        success: (res) => success(res),
        error: () => error()
      })
    }

    function getParties() {
      $.ajax({
        method:'GET',
        url: '/parties-all',
        success: (res) => success2(res),
        error: () => error2()
      })
    }
    function success2(res) {
      console.log(res)
        var html =  ''
        var count = 0
        var table = document.querySelector('#party-table')
        $('#party-table').empty()
        for (let index = 0; index < res.length; index++) {
          
          var party = res[index];
          html += '<tr>'
            + '<td>'+party.name+ '</td>'
          + '<td>'+party.votes+'</td>'
          + '</tr>\n'
          
        }
        
        table.innerHTML = html
    }
    function error2() {
      console.error('There is an error retrieving response from server at: /parties-all')
    }
    setInterval(function() {
      getParties()
    	// location.reload();
    }, 18050)
    </script>
</body>
</html>
