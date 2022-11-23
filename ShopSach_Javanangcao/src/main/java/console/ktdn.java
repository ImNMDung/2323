package console;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import bo.UsersBo;
import dao.ketnoi;

/**
 * Servlet implementation class ktdn
 */
@WebServlet("/ktdn")
public class ktdn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ktdn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * try { String un = request.getParameter("txtun"); String pass =
		 * request.getParameter("txtpass"); ketnoi kn = new ketnoi(); kn.ketnoi();
		 * 
		 * String sql = "SELECT * FROM KhachHang WHERE tendn = ? AND pass = ?";
		 * PreparedStatement cmd = kn.cn.prepareStatement(sql); cmd.setString(1, un);
		 * cmd.setString(2, pass); ResultSet rs = cmd.executeQuery(); String tk="";
		 * String mk = ""; while (rs.next()) {
		 * 
		 * tk = rs.getString("tendn");
		 * 
		 * mk = rs.getString("pass"); }
		 * 
		 * if (un != null && pass != null) { // for (int i=0; i <= tk.length();i++)
		 * 
		 * { if (un.equals(tk) && pass.equals(mk)) { HttpSession session =
		 * request.getSession(); session.setAttribute("dn", un); RequestDispatcher rd =
		 * request.getRequestDispatcher("ctl"); rd.forward(request, response);
		 * 
		 * } else { RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
		 * rd.forward(request, response);
		 * 
		 * } } } else {
		 * 
		 * 
		 * RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
		 * rd.forward(request, response);
		 * 
		 * }
		 * 
		 * rs.close(); kn.cn.close();
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } }
		 */
	
	
	 String un=request.getParameter("txtun");
	 String pass=request.getParameter("txtpass");

	
	if(un!=null&&pass!=null) {
		 UsersBo khbo= new UsersBo();
	     UserBean kh= khbo.ktdn(un, pass);
	     if(kh!=null) {
			 HttpSession session=request.getSession();
			 session.setAttribute("kh", kh);
			 response.sendRedirect("ctl");
	     }else {
	    	 RequestDispatcher rd=request.getRequestDispatcher("dangnhap.jsp?kt=1");
			 rd.forward(request, response);
	     }
	     
	 }else {
		 RequestDispatcher rd=request.getRequestDispatcher("dangnhap.jsp");
		 rd.forward(request, response);
	 }
	 
	 
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
