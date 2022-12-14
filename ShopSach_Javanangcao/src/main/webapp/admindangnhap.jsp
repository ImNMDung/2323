<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
 <form action="dangnhapadmincsl" >
 <label for="email"><b>Tài Khoản</b></label>
    <input type="text" placeholder="Nhập Tài Khoản" name="txtun" required>

    <label for="psw"><b>Mật Khẩu</b></label>
    <input type="password" placeholder="Nhập Mật Khẩu" name="txtpass" required>
   
    <div class="clearfix">
      <button  name="bxtdn" type="submit" class="signupbtn">Đăng Nhập</button>
       
    </div>
    </form>
    
</body>
</html>