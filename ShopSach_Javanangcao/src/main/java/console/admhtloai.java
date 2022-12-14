package console;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.loaibo;
import bean.UserBean;
import bean.dangnhapadminbean;
import bean.loaibean;

/**
 * Servlet implementation class admhtloai
 */
@WebServlet("/admhtloai")
public class admhtloai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admhtloai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		dangnhapadminbean user = (dangnhapadminbean) session.getAttribute("kh"); 
		if ( user == null) {
			response.sendRedirect("dangnhapadmincsl");
		} else {		
			
		
		 String maloai1=request.getParameter("txtmaloai1");
		 String tenloai1= request.getParameter("txttenloai1");
		 String maloai=request.getParameter("txtmaloai");
		 String tenloai= request.getParameter("txttenloai");
		 
		 loaibo sbo=new loaibo();
		 ArrayList<loaibean> dsloai=sbo.getloai();
		  
		  request.setAttribute("dsloai", dsloai);
		  
		  
		  if (request.getParameter("butthem1")!=null  && tenloai1 != null ) {
				 	
		  		sbo.ThemLoai(maloai1,tenloai1);
		  		
		  		
		  		System.out.println("dathem");
		  		response.sendRedirect("ctl");
				}
		  
				if (request.getParameter("butxoaadmin")!=null) {
					 sbo.XoaLoai(maloai);
					 System.out.println("daxoa");
				}
			
				
				if (request.getParameter("butsuaadmin")!=null) {
					 sbo.SuaLoai(maloai, tenloai);
					 
				}
				
		 
			  	
			  	RequestDispatcher rd= request.getRequestDispatcher("adminhtloai.jsp");
				rd.forward(request, response);
		
		}
		
	}

}
