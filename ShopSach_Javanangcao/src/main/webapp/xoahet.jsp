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
  
	   gh.xoachon(ms);
	   session.setAttribute("gio", gh);
	   response.sendRedirect("htgio.jsp");
   
 
	
%>
</body>
</html>