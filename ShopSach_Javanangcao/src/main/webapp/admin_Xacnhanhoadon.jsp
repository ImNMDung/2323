<%@page import="bean.*"%>
<%@page import="bo.sachbo"%>
<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@page import="console.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ADMXNHD</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="popper.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li class="active"><a href="admincsl"> <i class="bi bi-window-stack"></i> Admin</a></li>
				<li><a href="admhtloai"> <i class="bi bi-bag-fill"></i>Quản Lý Loại</a></li>
				<li><a href="adminhtsach">Quản Lý Sách</a></li>
				<li><a href="adminxacnhanhoadon">Xác Nhận Hóa Đơn </a></li>
				<li><a href="admdskhctl"> danh sach khách hàng đã chuyển tiền </a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%dangnhapadminbean adm = (dangnhapadminbean) session.getAttribute("kh");
				if (adm != null) {
				%>
				<li><a href="" data-toggle="dropdown"> <span class="glyphicon glyphicon-log-in"></span> Chào : <%=adm.getTendangnhap()%> </a>
					<ul class="dropdown-menu">
						<li><a href="logoutadm" name="logoutadm">Đăng Xuất</a></li>
					</ul>
				</li>
				<% } else {%>
				
				<li><a href="dangnhapadmincsl"> <span class="glyphicon glyphicon-log-in"> </span> Đăng Nhập</a></li>
				<%	}	%>
			</ul>
		</div>
	</nav>
	<table width="1000" align="center">
		<td width="800" valign="top">

			<table class="table table-hover">
				<th scope="col">Mã Khách Hàng</th>
				<th scope="col" width="200px">Tên sách</th>
				<th scope="col">Ngày mua</th>
				<th scope="col">Số lượng</th>
				<th scope="col">Giá tiền</th>
				<th scope="col">Thành tiền</th>
				<th scope="col">Trạng thái</th>
				<th scope="col">Chức Năng</th>

				<%
				ArrayList<lichsubean> dsls = (ArrayList<lichsubean>) request.getAttribute("dsls");

				if (dsls != null) {
					int n = dsls.size();
					for (int i = 0; i < n; i++) {
						lichsubean s = dsls.get(i);
				%>

				<form action="xacnhanadm?ms=" <%=s.getMakh()%> method="post">
					<tr>
						<td><input type="text" class="text-center" style="outline: none; border: none;"
							name="makh" readonly="readonly" value="<%=s.getMakh()%>"></td>

						<td><%=s.getTensach()%></td>
						<td><%=s.getNgaymua()%></td>
						<td><%=s.getSoluongmua()%></td>
						<td><%=s.getGia()%></td>
						<td><%=s.getThanhtien()%></td>
						<%
						if (s.isDamua() == 1) {
						%>
						<td class="text-success">Đã Thanh Toán</td>
						<%
						}
						%>
						<td><input class="btn-primary" name="butxacnhan"
							type="submit" value="Xác Nhận"></td>

					</tr>
					<%
					}
					}
					%>
				</form>
			</table>
</body>
</html>
