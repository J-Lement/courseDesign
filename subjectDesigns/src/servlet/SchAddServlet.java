package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SchBean;
import bean.SubDao;
import util.CheckIt;
import util.StringUtil;

public class SchAddServlet extends HttpServlet {

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
		String schId = request.getParameter("schId");
		String schName = StringUtil.toCN(request.getParameter("schName"));
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(!CheckIt.IsNum(schId) || !CheckIt.IsString(schName)) {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据格式不正确！\");");
			out.println("window.location.href='schAdd.jsp';");
			out.println("</script>");
			return;
		}
		
		SchBean bean = new SchBean();
		bean.setSchId(Integer.parseInt(schId));
		bean.setSchName(schName);
		
		SubDao dao = new SubDao();
//		try {
//			if (dao.schAdd(bean) > 0) {  // 插入数据成功
//				response.sendRedirect("SchManage");
//			} else {			// 插入数据失败！
//				response.sendRedirect("schAdd.jsp");
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		try {
			if (dao.schAdd(bean) > 0) {			
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加成功！\");");
				out.println("window.location.href='SchManage';");
				out.println("</script>");
			} else {
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加出错！\");");
				out.println("window.location.href='schAdd.jsp';");
				out.println("</script>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
