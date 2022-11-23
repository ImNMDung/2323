package console;

import dao.*;
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
 * Servlet implementation class dangkyctl
 */
@WebServlet("/dangkyctl")
public class dangkyctl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dangkyctl() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// khai bao session

		HttpSession session = request.getSession();
		UsersBo s = new UsersBo();
		String userName = request.getParameter("tk");
		String pass = request.getParameter("mk");
		String bxtdk = request.getParameter("bxtdk");
		UserBean users = new UserBean();
		String mes = "";
		if (userName != null && pass != null && bxtdk != null) {

			try {
				users.setTendan(userName);
				users.setPass(pass);

				if (s.addAccount(users)) {

					mes = "Đăng ký tài khoản thành công.Vui lòng đăng nhập.";
					session.setAttribute("SingupSuccess", mes);
//					response.sendRedirect("dangnhap.jsp");
					request.getRequestDispatcher("dangnhap.jsp").forward(request, response);
				} else {
					mes = "Lỗi!";
					session.setAttribute("SingupError", mes);
//					response.sendRedirect("Dangky.jsp");
				request.getRequestDispatcher("Dangky.jsp").forward(request, response);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		} else {			
			request.getRequestDispatcher("Dangky.jsp").forward(request, response);
		}
	}
}
