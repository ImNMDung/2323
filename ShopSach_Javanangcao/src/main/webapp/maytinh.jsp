<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<%  
   /* String aa=  request.getParameter("txta");
	String bb=request.getParameter("txtb");
	long kq=0;
	long a=0;
	long b=0;
	if(aa!=null && bb!=null){
		 a= Long.parseLong(aa);
		 b= Long.parseLong(bb);
		if(request.getParameter("butc")!=null)
			kq=a+b;
		else
			if(request.getParameter("butt")!=null)
				kq=a-b;
			else
				if(request.getParameter("butn")!=null)
					kq=a*b;
				else
					if(b==0)
						out.print("<scipt>alert('Bo tay');</script");
					else
						kq=a/b;
	} */
	
// 	String a= request.getParameter("a");
// 	String b= request.getParameter("b");
// 	String kq= request.getParameter("kq");

		long a=0,b=0,kq=0;
		
		if(request.getAttribute("a")!=null){
			
			a=(long)request.getAttribute("a");
			b=(long)request.getAttribute("b");
			kq=(long)request.getAttribute("kq");
		}


	
	
%>

	 <form action="test" method="post">
       a= <input name="txta" type="number" value="0"> <br>
       b= <input name="txtb" type="number" value="0"> <br>
       kq= <input name="txtkq" type="number" value="0"> <br>
       <input name="butc" type="submit" value="+"> 
       <input name="butt" type="submit" value="-">
       <input name="butn" type="submit" value="*">
       <input name="butchia" type="submit" value="/">
    </form>
    
    <%
    out.print(kq);
    
    %>
</body>
</html>
