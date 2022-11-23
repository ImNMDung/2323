
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<style>
  @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap');
  * {box-sizing: border-box}
  body{
    font-family: 'Noto Sans JP', sans-serif;
  }
  h1, label{
    color: DodgerBlue;
  }
  /* Full-width input fields */
    input[type=text], input[type=password] {
    width: 100%;
    padding: 15px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: none;
    width:100%;
    resize: vertical;
    padding:15px;
    border-radius:15px;
    border:0;
    box-shadow:4px 4px 10px rgba(0,0,0,0.2);
  }

  input[type=text]:focus, input[type=password]:focus {
    outline: none;
  }

  hr {
    border: 1px solid #f1f1f1;
    margin-bottom: 25px;
  }

  /* Set a style for all buttons */
  button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    opacity: 0.9;
  }

  button:hover {
    opacity:1;
  }

  /* Extra styles for the cancel button */
  .cancelbtn {
    padding: 14px 20px;
    background-color: #f44336;
  }

  /* Float cancel and signup buttons and add an equal width */
  .signupbtn {
    float: left;
    width: 100%;
    border-radius:15px;
    border:0;
    box-shadow:4px 4px 10px rgba(0,0,0,0.2);
  }

  /* Add padding to container elements */
  .container {
    padding: 16px;
  }

  /* Clear floats */
  .clearfix::after {
    content: "";
    clear: both;
    display: table;
  }



</style>
<html>
<form action="ktdn" >
  <div class="container">
    <h1>Đăng Nhập</h1>
    <%
    	String mess = ( String)session.getAttribute("SingupSuccess");
    	if (mess == null) out.print("");
    	else {
    %>
    <p class="text-center bg-danger p-2"><%=mess %></p>
    <%} %>
    <p>Xin hãy nhập biểu mẫu bên dưới để đăng nhập</p>
    <hr>

    <label for="email"><b>Tài Khoản</b></label>
    <input type="text" placeholder="Nhập Tài Khoản" name="txtun" required>

    <label for="psw"><b>Mật Khẩu</b></label>
    <input type="password" placeholder="Nhập Mật Khẩu" name="txtpass" required>

   
    <label>
      <input type="checkbox" checked="checked" name="remember" style="margin-bottom:15px"> Nhớ Đăng Nhập
    </label>

    <div class="clearfix">
      <button  name="bxtdn" type="submit" class="signupbtn">Đăng Nhập</button>
       
    </div>
  </div>
</form>
<form action="dangkyctl" >
  <div class="container">
  <div class="clearfix">
      <button  name="bxtdk" type="submit" class="signupbtn">Đăng Ký</button>
       
    </div>
  </div>


</form>

</body>
</html>