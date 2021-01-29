<%-- 
    Document   : showpass
    Created on : 13 Nov 2020, 14:48:15
    Author     : kankkm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Showpass</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
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

        <div class="container">
            <div class="box">
               <h1>
Show Password</h1>
                **Remember Your Password**<br>
      <br>  <input type="password"  value="${user.password}"  id="myInput" >
<input type="checkbox" onclick="myFunction()">
<a href="logout"><br>คลิก กลับไปที่หน้าหลัก และ Login ใหม่</a>
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
 </div>

   </div>
    </body>
</html>
