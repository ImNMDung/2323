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
<title>Admin</title>
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

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary text-center" data-toggle="modal" data-target="#exampleModal">
 Thêm Loại
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title text-center" id="exampleModalLabel">Thêm</h5>
        
      </div>
      <div class="modal-body">
       		




<form action="adminhtsach" method="post">
			
							
						 <label for="masach" ><b>Mã Sách</b> <input class="form-control" name = "txtmasach1"  type="text" min="0" width="30" ></label>
	 						<br>
						 <label for=""><b>Tên Sách</b><input class="form-control"  name ="txttensach1" type="text" min="0" width="30"> </label>
						<br>
						<label for=""><b>Số Lượng </b><input class="form-control"  name ="txtsoluong1" type="text" min="0" width="10" > </label>
						<br>
						<label for=""><b>Giá Tiền</b><input class="form-control"  name ="txtgia1" type="text" min="0" width="10" > </label>
						<br>
	 
						
						<label for=""><b>Link Ảnh </b><input class="form-control"  name ="txtanh1" type="text" min="0" width="10" > </label>
						<br>
						<label for=""><b>Tác Giả</b><input class="form-control"  name ="txttacgia1" type="text" min="0" width="10" ></label>
		
					














      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" >Close</button>
        <button type="submit" class="btn btn-primary"name="butthem" >Thêm Loại</button>
      </div>
    </div>
  </div>
  </form>
  
</div>



	<table width="auto" align="center">
		<td  valign="top">
		
					
					
     <table class="table table-hover">
		 <th scope="col" width="50px" ></th>
		 <th scope="col" width="400px">Tên Sách</th>
		 <th scope="col" width="100px" >Số lượng</th>
		 <th scope="col" width="100px">Giá tiền</th>
		 <th scope="col" width="300"> IMG Ảnh</th>
		 <th scope="col" width="200"> Tác Giả</th>
		 <th scope="col">Trạng thái</th>
		
	 <% ArrayList<sachbean> dssach = (ArrayList<sachbean>) request.getAttribute("dssach"); 
					if (dssach != null) {
					int n = dssach.size();
						for (int i = 0; i < n; i++) {
							sachbean s = dssach.get(i);
					%>
	<form action="adminhtsach?ms=<%=s.getMasach()%>" method="post">
			
					<tr>			
					
	 					<td  ><input type="hidden" name = "txtmasach" value="<%=s.getMasach()%>"  /></td>
						<td ><input class="form-control"  name ="txttensach" type="text" min="0" width="30" value="<%=s.getTensach() %>"> </td>
						
						<td ><input class="form-control"  name ="txtsoluong" type="text" min="0" width="10" value="<%=s.getSoluong() %>"> </td>
						<td ><input class="form-control"  name ="txtgia" type="text" min="0" width="10" value="<%=s.getGia() %>"> </td>
					
	 
						
						<td ><input class="form-control"  name ="txtanh" type="text" min="0" width="10" value="<%=s.getAnh() %>"> </td>
						<td ><input class="form-control"  name ="txttacgia" type="text" min="0" width="10" value="<%=s.getTacgia() %>"> </td>
		
						<td >	<input class="btn-primary" name ="butsuaadmin" type="submit" value=Sửa>
								<input class="btn-primary" name ="butxoaadmin" type="submit" value="Xóa">
						 		
						</td>
					<tr >	
					
					</form>
					<%
					}
						
					}
					%>
	</table>
</body>
</html>
