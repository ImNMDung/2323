<%@page import="bean.*"%>
<%@page import="bo.*"%>
<%@page import="bean.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.*"%>
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
       		




<form action="admhtloai" method="post">
			
							
						 <label for="masach" ><b>Mã Loại</b> <input class="form-control" name = "txtmaloai1"  type="text" min="0" width="30" ></label>
	 						<br>
						 <label for=""><b>Tên Loại</b><input class="form-control"  name ="txttenloai1" type="text" min="0" width="30"> </label>
						<br>
						



      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal" >Close</button>
        <button type="submit" class="btn btn-primary"name="butthem1" >Thêm Loại</button>
        
        </form>
      </div>
    </div>
  </div>
  
  
</div>



	<table width="auto" align="center">
		<td  valign="top">
		
					
					
     <table class="table table-hover">
		
		 <th scope="col" width="200px"  >Mã Loại</th>
		 <th scope="col" width="400px" >Tên Loại</th>
	
		 <th scope="col">Trạng thái</th>
		
	 <% ArrayList<loaibean> dsloai = (ArrayList<loaibean>) request.getAttribute("dsloai"); 
					if (dsloai != null) {
					int n = dsloai.size();
						for (int i = 0; i < n; i++) {
							loaibean s = dsloai.get(i);
					%>
	<form action="admhtloai?ms=<%=s.getMaloai()%>" method="post">
			
					<tr>			
					
	 					<td  ><input type="text" name = "txtmaloai" style="outline: none; border: none;"  readonly="readonly" value="<%=s.getMaloai()%> "  /></td>
						<td ><input class="form-control"  name ="txttenloai" type="text" min="0" width="30" value="<%=s.getTenloai() %>"> </td>
						
						
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
