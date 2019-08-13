package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import bean.UserBean;
import bean.UserDao;
import util.DBUtil;
import util.StringUtil;

@WebServlet("/Check")

public class CheckServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String userType = StringUtil.toCN(request.getParameter("userType"));
		System.out.println(userId + "u\n" + password + "p\n" + userType);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(userId == null || "".equals(userId)) {//检验用户名，密码，类型是否为空
			System.out.println(userId + "\n" + password + "\n" + userType);
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"用户名不能为空\");");
			out.println("window.location.href='login.jsp';");
			out.println("</script>");
			return;
		}else if(password == null || "".equals(password)) {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"密码不能为空\");");
			out.println("window.location.href='login.jsp';");
			out.println("</script>");
			return;
		}else if(userType == null || "".equals(userType)) {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"请选择用户类型\");");
			out.println("window.location.href='login.jsp';");
			out.println("</script>");
			return;
		}
//		System.out.println(userId);
		Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(userId);
        if( !isNum.matches() ){//限制用户id只能是整型数字
        	out.println("<script type='text/javascript'>");
			out.println("window.alert(\"用户Id含非法字符\");");
			out.println("window.location.href='login.jsp';");
			out.println("</script>");
			return;
        }
        UserDao uDao = new UserDao();
        UserBean uBean =null;
        try {
        	uBean = uDao.checkUser(userId, password, userType);//将取出的数据存入UserBean中
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(uBean);
        if(uBean == null || !uBean.getPassword().equals(password) || !uBean.getUserType().equals(userType)){//检验用户密码和用户类型是否匹配
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"用户信息不匹配\");");
			out.println("window.location.href='login.jsp';");
			out.println("</script>");
			return;
		}
		else if(uBean.getPassword().equals(password) && uBean.getUserType().equals(userType)) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			if(userType.equals("管理员"))
				request.getRequestDispatcher("adminIndex.jsp").forward(request, response);
			else
				request.getRequestDispatcher("userIndex.jsp").forward(request, response);
		}
	}
	

}
