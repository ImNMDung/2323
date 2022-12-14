package console;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.dangnhapadminbean;

import bo.dangnhapadminbo;


/**
 * Servlet implementation class dangnhapadmincsl
 */
@WebServlet("/dangnhapadmincsl")
public class dangnhapadmincsl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapadmincsl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String un=request.getParameter("txtun");
		 String pass=request.getParameter("txtpass");

		
		if(un!=null&&pass!=null) {
			 dangnhapadminbo khbo= new dangnhapadminbo();
		     dangnhapadminbean kh= khbo.ktdnadm(un, pass);
		     if(kh!=null) {
				 HttpSession session=request.getSession();
				 session.setAttribute("kh", kh);
				 response.sendRedirect("admincsl");
		     }else {
		    	 RequestDispatcher rd=request.getRequestDispatcher("admindangnhap.jsp?kt=1");
				 rd.forward(request, response);
		     }
		     
		 }else {
			 RequestDispatcher rd=request.getRequestDispatcher("admindangnhap.jsp");
			 rd.forward(request, response);
		 }
		 
		 
	}}