package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import bean.UserDao;

@WebServlet("/UserEdit")
public class UserEditServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		if(userId == null || "".equals(userId)) {
			response.sendRedirect("UserList");
			return;
		}
		
		UserDao dao = new UserDao();
		UserBean bean = null;
		try {
			bean = dao.loadUserEdit(Integer.parseInt(userId));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("userBean", bean);
		request.getRequestDispatcher("userEdit.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
