package console;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserBean;
import bean.giohangbean;
import bo.chitietbo;
import bo.giohangbo;
import bo.hoadonbo;

/**
 * Servlet implementation class damuactl
 */
@WebServlet("/damuactl")
public class damuactl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public damuactl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// phải đăng nhập 
		
	// tạo httpss lấy ss đăng nhập   
		// lấy phần tử trong giỏ hàng lưu trong gio hàng bo ss. "gio"
		HttpSession session=request.getSession();
		UserBean kh= (UserBean)session.getAttribute("kh");
		if(kh==null)
			response.sendRedirect("ktdn");
		else {
			giohangbo gh=(giohangbo)session.getAttribute("gio");
			hoadonbo hdbo= new hoadonbo();
			chitietbo ctbo= new chitietbo();
			System.out.println("ma kh: " + kh.getMakh());
			hdbo.Them(kh.getMakh());
			long maxhd=hdbo.getmaxhd();
			System.out.println("ma hoa don: " + maxhd);
			for(giohangbean g: gh.ds) {
				//System.out.println(g.getMasach() +"  abc");
				ctbo.Them(g.getMasach().trim(), g.getSoluong(),maxhd);
			}
			hdbo.capnhat(maxhd);
			session.removeAttribute("gio");
			RequestDispatcher rd= request.getRequestDispatcher("lichsumuahang");
			rd.forward(request, response);
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
