<%-- 
    Document   : forgotpassword
    Created on : 13 Nov 2020, 14:28:20
    Author     : kankkm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ForgotPassword</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
       
          <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="css/clean-blog.min.css" rel="stylesheet">
    </head>
    <body>
  <style>
body {
  background-image: url(img/s.jpg);
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
</style>

<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="index.jsp">Ghosttales</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="index.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="mostpop"">mostpopular</a>
          </li>
          <li class="nav-item">

            <a class="nav-link" href="About.jsp">About</a>
</li>
<li class="nav-item">
            <a href="${user==null ?'login.jsp':'getfavoritelist'}?name=${user.username}" > favoritelist </a>

          </li>
          <li class="nav-item">
            <a href="${user==null ?'login.jsp':'post.jsp'}">
                 ${user==null ?'Post':'Post'}</a>
          </li>
          <li class="nav-item">
            <a href="${user==null ?'login':'logout'}">
                 ${user==null ?'Login' : 'Logout'}
        </a>
          </li>
                    <a  style="color: white">  ${user==null ?'Guest':''}</a>
          <li class="nav-item">
          
          <a href="profile?name=${user.username}"  style="color: white"> ${user==null ?'':user.username}</a>
          </li>
        </ul>
      </div>
    </div>
   </nav>
    <body>
        <div class="container">
            <div class="box">
         <h1>
Forgot Password</h1>
<form action="forgotServlet" method="post">
                   <p>ใส่ Username ของคุณ</p>
                   <input type="text"  name="username"   required>
              <p>ใส่ Firstname ของคุณ</p>
<input type="text"  name="firstname"  required>
<p>ใส่ Lastname ของคุณ</p>
<input type="text"  name="lastname"   required>
<div style="color: red" >${Message}</div>
                   <input type="submit" value="Show Password">
                   
                </form>
                   </div>


        </div>
    </body>
</html>
