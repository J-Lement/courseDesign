package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import bean.UserDao;
import util.Pager;

@WebServlet("/UserList")

public class UserListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userType = request.getParameter("userType");
		String curPage = request.getParameter("cur_page");
		
		if(curPage == null || "".equals(curPage))
			curPage = "1";
		Pager pager = new Pager();
		pager.setCurPage(Integer.parseInt(curPage));
		
		UserDao dao = new UserDao();
		List<UserBean> list = null;
		try {
			list = dao.listUser(userId, userName, userType, pager);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("userId", userId);
		request.setAttribute("userName", userName);
		request.setAttribute("userType", userType);
		request.setAttribute("userList", list);
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("userList.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
