<%-- 
    Document   : dopost
    Created on : Nov 1, 2020, 12:27:21 AM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Post</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="css/clean-blog.min.css" rel="stylesheet">
  <style>
      .content{
  word-wrap:break-word;
      }
  </style>
</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="homepage">Ghosttales</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="homepage">Home</a>
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
  
  <header class="masthead" style="background-image: url('img/${post.postId}.jpg')">
      
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="post-heading">
            <h1 name="title">${post.title}</h1>
            <!--h2 class="subheading">Problems look mighty small from 150 miles up</h2-->
            <span class="meta">Posted by
            <a href="profile?name=${post.userinfousername.username}"> ${post.userinfousername.username}  </a>
            on ${post.createTime} <br/><br/>
            <a href="${user.username==post.userinfousername.username ?'editpost.jsp':''}" style="color: #b21f2d" />
            ${user.username==post.userinfousername.username ?'Edit <img src ="img/Edit-01-512.png" width="20"/>':''}</a>
            </span>
          </div>
        </div>
      </div>
    </div>
  </header>
          
  <!-- Post Content -->
  <article>
    <div class="container">
      <div class="row">

        <div class="col-lg-8 col-md-10 mx-auto">
            <div class="content">
            <img src="img/${post.postId}.jpg" width="800" height="400"/>
               <br>
               <a  href="${user == null  ?'login.jsp':'favoritelist'}?id=${post.postId}&&username=${user.username}"> <img src ="img/${follow? 'heart3.png':'heart1.png'}" width="20"/>  ${count}</a> 
               <br>
               <br>
            ${post.content}
         
            
            <br>
            
            <br>
<h6 class="post-title" >
                
                 <u>comment (${num})</u>
                 </h6>
                 <hr>
                 
                 
        <c:forEach items="${cm}" var="cm" varStatus="vs">
      
      <div class="post-preview">
        

         
        
       
       
            <h6 class="post-title" >
                
                 
 
               username : <a href="getprofile?name=${cm.commentPK.userinfousername}">${cm.commentPK.userinfousername}</a>
         
        
        </h6>
        
    <h6 class="post-subtitle">
              ${cm.commentPK.comment} 
            </h6>
          </a>
          <p class="post-meta">
                 on ${cm.commentPK.createTime}
             </p>
          <hr>
          <!--p class="post-meta" style="color: #000"> ${post.totallike} Like  </p-->
          
        </div>
         </c:forEach>
                 
                      <form action="comment" method="POST">
            <input type="text"  name="comment" placeholder="comment" required>
            <!--input type="submit" value="comment"--> 
        </form>
            
        </div>     
            
            
      </div>
           
            
            
           </div>
  </article>                  

       
          
          
     
        </div>
        
            <div></div>
         

          
         
         
      </div>
         
    </div>
  </article>
            
</form>
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