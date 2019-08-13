package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MajBean;
import bean.SubBean;
import bean.SubDao;
import util.CheckIt;
import util.StringUtil;

public class SubAddDoServlet extends HttpServlet {

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
		String schName = StringUtil.toCN(request.getParameter("schName"));
		String majName = StringUtil.toCN(request.getParameter("majName"));
		String Id = request.getParameter("subId");
		String subName = StringUtil.toCN(request.getParameter("subName"));
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(!CheckIt.IsNum(Id) || !CheckIt.IsString(majName) || !CheckIt.IsString(subName)  || !CheckIt.IsString(subName)) {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据格式不正确！\");");
			out.println("window.location.href='subAdd.jsp';");
			out.println("</script>");
			return;
		}
		
		SubBean bean = new SubBean();
		bean.setSubId(Integer.parseInt(Id));
		bean.setSubName(subName);
		bean.setSchName(schName);
		bean.setMajName(majName);
		
		SubDao dao = new SubDao();
//		try {
//			if (dao.subAdd(bean) > 0) {  // 插入数据成功
//				response.sendRedirect("SubManage");
//			} else {			// 插入数据失败！
//				response.sendRedirect("subAdd.jsp");
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		try {
			if (dao.subAdd(bean) > 0) {			
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加成功！\");");
				out.println("window.location.href='SubManage';");
				out.println("</script>");
			} else {
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加出错！\");");
				out.println("window.location.href='subAdd.jsp';");
				out.println("</script>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
