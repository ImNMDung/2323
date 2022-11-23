<%@page import="bean.*"%>
<%@page import="bo.giohangbo"%>
<%@page import="bean.sachbean"%>
<%@page import="bo.sachbo"%>
<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bo.loaibo"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>

  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
  

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
	          
       <%	giohangbo gh = (giohangbo)session.getAttribute("gio"); 
       String key=request.getParameter("soluong");
       long tongtien = 0;
     
       if(gh!=null){
    	   for(giohangbean h: gh.ds){
    		  

    	   tongtien += h.getThanhtien();
    	   
    	   %>
    	 
    	   
<table width="1000" align="center">
  <tr>
  <td width="100" valign="top"> 
     

  </tr>
  <td width="800" valign="top">
     <table class="table table-hover">
      <th scope="col" width="200px"> Mã Sách</th>
	 <th scope="col">Tên Sách</th>
	  <th scope="col"> Giá</th>
	 <th scope="col">Số lượng</th>
	
	 <th scope="col">Thành tiền</th>
	 	 <th scope="col">Trạng thái</th>
        
   
    	   <form action="suaxoacls?ms=<%=h.getMasach()%>" method="post">
       		<tr>
       				
       		<td>  <%=h.getMasach() %>	</td>
       
       		
       		<td>   <%=h.getTensach() %></td>
       		
       		<td>	   <%=h.getGia() %></td>
       		<td> <input class="form-control"  name ="txtsl" type="number" min="0" width="25" value="0"> </td>
       		<td><%=h.getThanhtien() %></td>
       		
       		<td> 
       		 <input class="btn-primary" name ="butsua" type="submit" value="Update">
     			  <input class="btn-primary" name ="butxoa" type="submit" value="Delete">       			 
     	 </form>
       		
      
       		
       		
       		
       			 
       	
       		</td>
       		</tr>
  
   
    	
      
     
     
       <% }} else {%>
       	Giỏ Hàng Trống
       	<form action="ctl">
       	 <input class="btn-primary" name ="" type="submit" value="Quay Lại Mua Hàng"> 
       	 </form>
       	
       	
       <%} %>
      	
      
    
     
    </table>
<table>
	<h3><span class="label label-info">Tổng tiền: <%=tongtien %> VND</span></h3>
	
	
</table>

<form action="damuactl" method="post">

<button name="abc" type="submit" value=""> Đặt Mua</button>

</form>

    </td>
  </tr>
  
</table>
  
</body>
</html>

