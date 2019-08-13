package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import bean.UserDao;
import util.CheckIt;
import util.StringUtil;

@WebServlet("/UserAdd")

public class UserAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userName = StringUtil.toCN(request.getParameter("userName"));
		String password = request.getParameter("password");
		String userType = StringUtil.toCN(request.getParameter("userType"));
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(!CheckIt.IsNum(userId) || !CheckIt.IsNum(password) || !CheckIt.IsString(userName) || !CheckIt.IsString(userType)) {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据格式不正确！\");");
			out.println("window.location.href='userAdd.jsp';");
			out.println("</script>");
			return;
		}
		
		UserBean bean = new UserBean();
		bean.setUserId(Integer.parseInt(userId));
		bean.setUserName(userName);
		bean.setPassword(password);
		bean.setUserType(userType);
		
		UserDao dao = new UserDao();
//		int result = 0;
//		try {
//			result = dao.userAdd(bean);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			result = -1;
//		}
//		if(result > 0) {
//			response.sendRedirect("UserList");
//		}else {
//			response.sendRedirect("userAdd.jsp");
//		}
		
		
		try {
			if (dao.userAdd(bean) > 0) {			
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加成功！\");");
				out.println("window.location.href='UserList';");
				out.println("</script>");
			} else {
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加出错！\");");
				out.println("window.location.href='userAdd.jsp';");
				out.println("</script>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
