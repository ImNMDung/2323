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

import bean.UserBean;
import bean.lichsubean;
import bo.hoadonbo;
import bo.lichsuboadminbo;
import dao.hoadondao;
import dao.lichsudao;

@WebServlet("/xacnhanadm")
public class xacnhanadm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public xacnhanadm() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String makh = request.getParameter("makh");
		lichsudao ls = new lichsudao();

		lichsuboadminbo lbo = new lichsuboadminbo();
		ArrayList<lichsubean> dsls = lbo.getlichsu();
		if (dsls != null) {
			request.setAttribute("dsls", dsls);
		}

		lichsubean kh = (lichsubean) session.getAttribute("dsls");
		hoadondao hdbo = new hoadondao();
		if (request.getParameter("butxacnhan") != null) {
			hdbo.xacnhandamuaadm(makh);
			System.out.println("makh la: " + makh);

		}
		RequestDispatcher rd = request.getRequestDispatcher("admin_Xacnhanhoadon.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
