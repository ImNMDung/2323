package console;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.billbean;
import bo.billbo;
import bo.loaibo;
import dao.ketnoi;

/**
 * Servlet implementation class thanhtoancsl
 */
@WebServlet("/hoadonctl")
public class hoadonctl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hoadonctl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
			
				
			HttpSession session = request.getSession();
		
			billbo lbo = new billbo();
			String tdnSession = (String) session.getAttribute("dn");
			String tdn = "";
			if (tdnSession != null) tdn = tdnSession;
			ArrayList<billbean> dsloai = lbo.getbill(tdn);
				if ( dsloai != null ) {
			  request.setAttribute("dsloai", dsloai  );
			  
			
			  
			  
				}
			  
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("lichsu.jsp");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
