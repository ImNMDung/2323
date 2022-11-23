<%@page import="bo.giohangbo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   String ms=request.getParameter("ms");
   
   giohangbo gh=(giohangbo)session.getAttribute("gio");
   if(request.getParameter("butsua")!=null){
	   long sl=Long.parseLong(request.getParameter("txtsl"));
	   gh.capnhatsoluong(ms, sl);
   }
  
	   if(request.getParameter("butxoa")!=null){
	 		 ms = request.getParameter("butxoa");  
		   
		   gh.xoa(ms);
		   }
   if(request.getParameter("butcheck")!=null){
	   String[] check= request.getParameterValues("check");
	   	for(String c:check)
	   	gh.xoa(c);
   }
   
   
   session.setAttribute("gio", gh);
   
   if(gh.ds.size()==0)
	   response.sendRedirect("htsach.jsp");
   else
   response.sendRedirect("htgio.jsp");
%>
</body>
</html>
