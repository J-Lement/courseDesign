package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookDao;
import bean.MajBean;
import bean.SchBean;
import bean.SubDao;
import util.CheckIt;
import util.StringUtil;

public class MajAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String majId = request.getParameter("majId");
		String majName = StringUtil.toCN(request.getParameter("majName"));
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(!CheckIt.IsNum(majId) || !CheckIt.IsString(majName)) {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据格式不正确！\");");
			out.println("window.location.href='majAdd.jsp';");
			out.println("</script>");
			return;
		}
		
		MajBean bean = new MajBean();
		bean.setMajId(Integer.parseInt(majId));
		bean.setMajName(majName);
		
		SubDao dao = new SubDao();
//		try {
//			if (dao.majAdd(bean) > 0) {  // 插入数据成功
//				response.sendRedirect("MajManage");
//			} else {			// 插入数据失败！
//				response.sendRedirect("majAdd.jsp");
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		
		try {
			if (dao.majAdd(bean) > 0) {			
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加成功！\");");
				out.println("window.location.href='MajManage';");
				out.println("</script>");
			} else {
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加出错！\");");
				out.println("window.location.href='majAdd.jsp';");
				out.println("</script>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
