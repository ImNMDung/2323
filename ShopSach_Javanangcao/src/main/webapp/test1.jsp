<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>



				<form action="test1.jsp" method="get">
					<input class="form-control" name="txttk" type="text" value=""
						placeholder="Nhap so nguyen n"> <br> 
						<input	class="btn-primary" name="butdn" type="submit" value="Tong">
				</form>
				
		<%
		  String nn= request.getParameter("txttk");
		//Tao ra 1 biet session
		if(session.getAttribute("s")==null)//Chua tao bien sesion
		   session.setAttribute("s",(int)0);//tao
		   
	   if(nn!=null){
		   int n=Integer.parseInt(nn);
		  //b1: gan session vao 1 bien
		  int ss=(int)session.getAttribute("s");
		  //b2: Thao tac tren bien
		    ss=ss+n;
		  //b3: Luu ss vao lai session
		  session.setAttribute("s", ss);
		  
		   out.print("Tong="+ss);
	   }
	 
	  	
		// tạo biến toàn cục , chuyển hướng trang 
		//tạo biến 1 biến seesion session.setAttribute(“tenbiensession ", gtri);
	// biến ss có thể qua lại các trang bình thường 
	%>
			 <a href="htsach.jsp"> Mo trang chu</a>	
</body>
</html>