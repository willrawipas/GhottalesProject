<%-- 
    Document   : editprofile
    Created on : 13 Nov 2020, 02:24:16
    Author     : kankkm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style_1_1.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <style>
body {
  background-image: url(img/54e8d1444d50a814f6da8c7dda793678153bdee757596c48732f7ed69e4bc05dbb_12801.jpg);
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
</style>
        <div class="box">  
        <h1>
Edit Profile</h1>
<form action="editprofile" method="post">
                   <p>Username is ${user.username}</p>
                   
              <p>เปลี่ยนรหัส ใส่รหัสปัจจุบัน</p>
<input type="password"  name="password"  id="myInput" required>
<input type="checkbox" onclick="myFunction()">
<p>ใส่รหัสใหม่*ไม่เปลี่ยนรหัสให้เขียนรหัสเดิม*</p>
<input type="password"  name="newpassword"  id="myInput2" required>
<input type="checkbox" onclick="myFunction2()">
<script>
function myFunction() {
  var x = document.getElementById("myInput");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
<script>
function myFunction2() {
  var x = document.getElementById("myInput2");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
 <p>Firstname</p>
<input type="text"  name="firstname"  value="${user.firstName}"required>
 <p>Lastname</p>
<input type="text"  name="lastname" value="${user.lastName}" required>
<div style="color: red" >${Message}</div>
                   <input type="submit" value="EDIT">
                   
                   <p><a href="profile?name=${user.username}"> เปลี่ยนใจไม่ EDIT คลิก </a></p>
                   
                </form>
                   </div>
    </body>
</html>
