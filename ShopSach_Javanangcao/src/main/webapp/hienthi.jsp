<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="bo.loaibo"%>
<%@ page import="bo.sachbo"%>
<%@ page import="bean.loaibean"%>
<%@ page import="bean.sachbean"%>
<%@page import="bo.sinhvienbo"%>
<%@page import="bo.*"%>
<%@page import="bean.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hien Thi</title>
</head>
<body>
<table class="table table-responsive text-cente" border="1"  width="1000" align="center">
    <tr>
        <th colspan="3">THÔNG TIN SINH VIÊN</th>
    </tr>
    <tr>
        <td align="center">Hiển thị tên môn</td>
        <td  align="center">Hiển thị sinh viên </td>
        <td align="center">Tìm kiếm</td>
    </tr>
    <tr>
			<td width="200" valign="top">
				<table>
					<%
					monhocbo lbo = new monhocbo();
					ArrayList<monhocbean> dsloai = lbo.getmonhoc();
					for (monhocbean l : dsloai) {
					%>
					<tr>
						<td><a href="hienthi.jsp?ml=<%=l.getMamon()%>">  <%=l.getTenmon()%>
						
						</a></td>
					</tr>
					<%
					}
					%>
				</table>
			</td>
			<td width="600" valign="top">
			
				<table class="table">

					<%
					request.setCharacterEncoding("utf-8");
					response.setCharacterEncoding("utf-8");

					String ml = request.getParameter("ml");
					String key = request.getParameter("txttk");

					sinhvienbo sbo = new sinhvienbo();
					
					ArrayList<sinhvienbean> dssach = sbo.getsinhvien();
					if (ml != null)
						dssach = sbo.TimMa(ml);
					else if (key != null)
						dssach = sbo.Tim(key);

					int n = dssach.size();
					for (int i = 0; i < n; i++) {
						sinhvienbean s = dssach.get(i);
					%>
					<tr>
						<td>
						<img src="<%=s.getAnh()%>" alt=""  height="300" width="200"> <br> <%=s.getHoten()%>
							<br> <%=s.getMasingvien()%> <br>
							<br> <%=s.getDiachi()%> <br>
							 <a href="giohang.jsp">
							 <img
								src="mua.jpg" alt="">
								</a>
							<hr></td>
						<%
						i++;
						if (i < n) {
							s = dssach.get(i);
						%>
						<td><img src="<%=s.getAnh()%>" alt="" height="300" width="200"> <br> <%=s.getHoten()%>
							<br> <%=s.getMasingvien()%> <br> 
								<br> <%=s.getDiachi()%> <br>
								<a href="giohang.jsp"><img
								src="mua.jpg" alt=""></a>
							<hr></td>
						<%
						}
						%>

					</tr>
					<%
					}
					%>
				</table>
					
			
			</td>
			
			<td width="200" valign="top">
				<form action="hienthi.jsp" method="get">
					<input class="form-control" name="txttk" type="text" value=""
						placeholder="Nhap tt"> <br> <input
						class="btn-primary" name="butdn" type="submit" value="Search">
				</form>

			</td>
		</tr>
	</table>
</body>
</html>