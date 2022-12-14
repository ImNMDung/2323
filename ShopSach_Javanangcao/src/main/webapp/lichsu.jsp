<%@page import="bean.UserBean"%>
<%@page import="bean.giohangbean"%>

<%@page import="bo.giohangbo"%>
<%@page import="bean.sachbean"%>
<%@page import="bo.sachbo"%>
<%@page import="bean.sachbean"%>
<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@page import="bean.lichsubean"%>
<%@page import="bo.lichsubo"%>
<%@page import="dao.lichsudao"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Giỏ hàng</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style >
  		.slform {
  		width: 60px;
  		}
  </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="ctl">Trang chủ</a></li>
      <li><a href="giohangctl">Giỏ hàng</a></li>
      <li><a href="thanhtoan.jsp">Thanh toán</a></li>
      <li><a href="lichsumuahang">Lịch sử mua hàng </a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <%
				if (session.getAttribute("kh") == null) {
				%>
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Đăng ký</a></li>
				<%}%>
				<%
				UserBean kh = (UserBean) session.getAttribute("kh");
				if (kh != null) {
					%>
					<li><a href=""> <span
							class="glyphicon glyphicon-user"></span> Xin chào: <%=kh.getHoten()	%>
					</a></li>
					<li><a href="logoutcsl"> <span
							class="glyphicon glyphicon-log-in"></span> Đăng xuất
					</a></li>
					<%
					} else {
				%>
				<li><a href="ktdn"> <span
						class="glyphicon glyphicon-log-in"></span> Đăng nhập
				</a></li>
				<%
				}
				%>
    </ul>
  </div>
</nav>
<table width="1000" align="center">
  <tr>
  <td width="800" valign="top">
     <table class="table table-hover">
	 <th scope="col" width="200px">Tên sách</th>
	 <th scope="col">Ngày mua</th>
	 <th scope="col">Số lượng</th>
	 <th scope="col">Giá tiền</th>
	 <th scope="col">Thành tiền</th>
	 	 <th scope="col">Trạng thái</th>
	 
      <%
      ArrayList<lichsubean> dsls = (ArrayList<lichsubean>) request.getAttribute("dsls");
		if (dsls != null) {
			int n = dsls.size();
			for (int i = 0; i < n; i++) {
				lichsubean s = dsls.get(i);

		%>
		<tr>
			
			<td><%=s.getTensach()%></td>
			<td><%=s.getNgaymua()%></td>
			<td><%=s.getSoluongmua()%></td>
			<td><%=s.getGia()%></td>
			<td><%=s.getThanhtien()%></td>
			<%if(s.isDamua() == 0) {%>
				<td class="text-info">Đã Đặt Mua</td>
			<%}%>
				
				<%if(s.isDamua() == 1) {%>
				<td class="text-success">Đã Thanh Toán</td>
			<%}%>
			<%if(s.isDamua() == 2) {%>
				<td class="text-danger">Đã Xác Nhận Đơn </td>
			<%}%>
		 
		</tr>
	<%}} %>
	
	
    </table>
   </td>
  </tr>
</table>
</body>
</html>