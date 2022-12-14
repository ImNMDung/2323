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

import bean.dangnhapadminbean;
import bean.sachbean;
import bo.sachbo;

/**
 * Servlet implementation class adminhtsach
 */
@WebServlet("/adminhtsach")
public class adminhtsach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminhtsach() {
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

		HttpSession session = request.getSession();
		dangnhapadminbean user = (dangnhapadminbean) session.getAttribute("kh"); 
		if ( user == null) {
			response.sendRedirect("dangnhapadmincsl");
		} else {	
		
request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		
		 String masach=request.getParameter("txtmasach");
		 String soluong= request.getParameter("txtsoluong");
		 String gia=request.getParameter("txtgia");
		 String tensach= request.getParameter("txttensach"); 
		 String anh=request.getParameter("txtanh");
		 String tacgia= request.getParameter("txttacgia"); 
		 
		 
		 String masach1=request.getParameter("txtmasach1");
		 String soluong1= request.getParameter("txtsoluong1");
		 String gia1=request.getParameter("txtgia1");
		 String tensach1= request.getParameter("txttensach1"); 
		 String anh1=request.getParameter("txtanh1");
		 String tacgia1= request.getParameter("txttacgia1"); 
		// HttpSession session=request.getSession();
		 
		 
		
		sachbo sbo=new sachbo();
		 ArrayList<sachbean> dssach=sbo.getsach();
		  
		  request.setAttribute("dssach", dssach);
		if (request.getParameter("butthem")!=null && masach1 != null && soluong1 != null && gia1 != null && tensach1  != null &&  tacgia1  != null && anh1 != null ) {
		 sbo.ThemSach(masach1, tensach1,soluong1, gia1,anh1,tacgia1);
		 	
		}
		if (request.getParameter("butxoaadmin")!=null) {
			 sbo.XoaSach(masach);
			
		}
	
		
		if (request.getParameter("butsuaadmin")!=null) {
			 sbo.SuaSach(masach, tensach, soluong, gia,anh,tacgia);
			 
			
		
		}
		 
		System.out.println(tensach1 +" tensach");
		System.out.println(masach1 +" masach");
		System.out.println(gia1 +"  gia");
		System.out.println(soluong1 +" soluong");
		System.out.println(anh1 +"  anh");
		System.out.println(tacgia1+" tacgia");
		  	
		  	
		  	RequestDispatcher rd= request.getRequestDispatcher("adminhtsach.jsp");
			rd.forward(request, response);
	}
	}

}
