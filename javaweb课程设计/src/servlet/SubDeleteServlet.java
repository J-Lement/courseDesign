package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SubDao;

public class SubDeleteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int subId = Integer.parseInt(request.getParameter("subId"));
		
		SubDao dao = new SubDao();
		int result = 0;
		try {
			result = dao.deleteSub(subId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = -1;
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (result > 0) {			
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据删除成功！\");");
			out.println("window.location.href='SubManage';");
			out.println("</script>");
		} else {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据删除出错！\");");
			out.println("window.location.href='SubManage';");
			out.println("</script>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
