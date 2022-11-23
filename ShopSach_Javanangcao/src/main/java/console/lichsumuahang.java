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

import bean.loaibean;
import bean.sachbean;
import bo.loaibo;
import bo.sachbo;
import bean.UserBean;
import bean.lichsubean;
import bo.lichsubo;
import dao.lichsudao;

/**
 * Servlet implementation class lichsumuahang
 */
@WebServlet("/lichsumuahang")
public class lichsumuahang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsumuahang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("kh");
		if ( user == null) {
			response.sendRedirect("ktdn");
		} else {		
			int makh = user.getMakh();
			lichsubo lbo = new lichsubo();
			ArrayList<lichsubean> dsls = lbo.getlichsu(makh);
			if ( dsls != null) {
				request.setAttribute("dsls", dsls);
			}
			RequestDispatcher rd= request.getRequestDispatcher("lichsu.jsp");
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
