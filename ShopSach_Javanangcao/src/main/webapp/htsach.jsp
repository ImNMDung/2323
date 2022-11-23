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
<title>Trang Chủ</title>
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
			<li class=""> <a> Bán Sách Online </a></li>
				<li class="active"><a href="ctl"> <i class="bi bi-window-stack"></i> Trang chủ</a></li>
				<li><a href="giohangctl"> <i class="bi bi-bag-fill"></i>Giỏ hàng</a></li>
				<li><a href="thanhtoanctl">Thanh toán</a></li>
				<li><a href="lichsumuahang">Lịch sử mua hàng </a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				

		
				<%UserBean kh = (UserBean) session.getAttribute("kh");
				if (kh != null) {
				%>
				<li><a href="" data-toggle="dropdown"> <span
						class="glyphicon glyphicon-log-in"></span> Chào : <%=kh.getHoten()%>
				</a>
					<ul class="dropdown-menu">
						<li><a href="htgioctl">Giỏ Hàng</a></li>
						<li><a href="logoutcsl">Đăng Xuất</a></li>

					</ul></li>
				<%
				}

				else {
				%>
				<li><a href="dangkyctl"><span class="glyphicon glyphicon-user"></span> Đăng Ký</a></li>
				<li><a href="ktdn"> <span
						class="glyphicon glyphicon-log-in"> </span> Đăng Nhập
				</a></li>
				<%
				}
				%>
			</ul>
		</div>
	</nav>

	<table width="1000" align="center">
		<tr>
			<td width="200" valign="top" class="">
				<table class="table table-bordered ">
					<%
					ArrayList<loaibean> dsloai = (ArrayList<loaibean>) request.getAttribute("dsloai");
					if (dsloai != null) {
						for (loaibean l : dsloai) {
					%>
					<tr>
						<td ><a href="ctl?ml=<%=l.getMaloai()%>"> <%=l.getTenloai()%>
						</a></td>
					</tr>
					<%
					}
					}
					%>
				</table>
			</td>
			<td width="600" valign="top">
				<table class="table cell">

					<%
					ArrayList<sachbean> dssach = (ArrayList<sachbean>) request.getAttribute("dssach");
					if (dssach != null) {
					int n = dssach.size();
						for (int i = 0; i < n; i++) {
							sachbean s = dssach.get(i);
					%>
					<tr >

						<td class="text-center">
								<img src="<%=s.getAnh()%>" width="200" height="180"> 
								<br>  <b> <%=s.getTensach()%> </b><br> 
										 <%=s.getGia()%> VNĐ <br>
							<br> <a	href="giohangctl?ms=<%=s.getMasach()%>&ts=<%=s.getTensach()%>&gia=<%=s.getGia()%>">

								<img src="mua.png" width="130" height="50">
						</a>
							<hr></td>
						<%
						i++;
						if (i < n) {
							s = dssach.get(i);
						%>
						<td class="text-center"><img src="<%=s.getAnh()%>" width="200" height="180">
							<br>  <b> <%=s.getTensach()%> </b><br> 
								<b> </b> <%=s.getGia()%> VNĐ <br>
							<a
							href="giohangctl?ms=<%=s.getMasach()%>&ts=<%=s.getTensach()%>&gia=<%=s.getGia()%>">
								<img src="mua.png" width="130" height="50">
						</a>
							<hr></td>
						<%
						}
						%>

					</tr>
					<%
					}
					}
					%>
				</table>
			</td>
			<td width="200" valign="top">
				<form action="ctl" method="get">
					<input class="form-control" name="txttk" type="text" value=""
						placeholder="Nhap tt"> <br> <input
						class="btn-primary" name="butdn" type="submit" value="Search">
				</form>







				</div>
			</td>
		</tr>
	</table>
</body>
</html>
