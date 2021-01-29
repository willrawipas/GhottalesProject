<%-- 
    Document   : profile
    Created on : 9 Nov 2020, 18:28:08
    Author     : kankkm
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link href="css/style_1_1.css" rel="stylesheet" type="text/css"/>
        
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
    

<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="Homepage.html">Ghosttales</a>
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
          
          <!-- Page Header -->
  <header class="masthead" style="background-image: url('img/photo')">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="site-heading">
            <h1>MY PROFILE</h1>
            <span class="subheading"> 
            Username : ${userpro.username}<br><br>
            Name :  ${userpro.firstName} ${userpro.lastName}
            <br><br>
            <a href="${user.username==userpro.username ?'editprofile.jsp':''}" style="color: #ffffff"> 
             ${user.username==userpro.username ?'Edit Profile ':''}</a>
            </span>
          </div>
        </div>
      </div>
    </div>
  </header>

            
            <!-- Main Content -->
   <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">       
          <h1><u>My Story</u></h1>
                  <br>
              <c:forEach items="${mypost}" var="post" varStatus="vs">
        <div class="post-preview">
            
          <a href="post.html">
            <h2 class="post-title" >
                
                 
 
    
        <a href="getpost?id=${post.postId}" > ${post.title}  </a>
        <br>
        <a href="getpost?id=${post.postId}" > <img src="img/${post.postId}.jpg" width="650" height="300"/>  </a>
        
        </h2>
        
    <h3 class="post-subtitle">
              <!--Problems look mighty small from 150 miles up-->
            </h3>
          </a>
          <p class="post-meta">Posted by
            <a href="profile?name=${post.userinfousername.username}">${post.userinfousername.username}  </a>
            on ${post.createTime}  </p>
          
          <p class="post-meta" style="color: #000">  Like(${post.totallike})        Comment(${post.totalcomment})  </p>
          
        </div>
        <hr>
        <div class="post-preview">
          <a href="post.html">
   </tr> 
   
   
</c:forEach>

   
        <div class="clearfix">
          <!--a class="btn btn-primary float-right" href="otherpost">Show more  &#9661;</a-->
        </div>
      </div>
    </div>
  </div>

  <hr>

  <!-- Footer -->
  <footer>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <ul class="list-inline text-center">
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
          </ul>
          <p class="copyright text-muted">Copyright &copy; Your Website 2020</p>
        </div>
      </div>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/clean-blog.min.js"></script>

    </body>
    
</html>

