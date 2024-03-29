
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>Home</title>
</head>
<body>
  <div class="jumbotron text-center">
    <h1>Home Page</h1>
    <ul class="nav nav-tabs justify-content-center">
      <li class="nav-item">
        <a class="nav-link active" href="">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContent.request.contextPath}/voter-registration">Register</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContent.request.contextPath}/login">Login</a>
      </li>
    </ul>
  </div>

  <div class="container">
    <div class="row">
      <div class="col-sm-4">
        <h1>Welcome to iVoteHub</h1>
        <p>
          Here you can Register to Vote online.
        </p>
      </div>
    </div>
  </div>
</body>
</html>
