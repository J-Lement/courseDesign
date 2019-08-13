package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CommentFirstDao;

@WebServlet("/AddIll")
public class AddIllServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ill = request.getParameter("ill");
		CommentFirstDao dao = new CommentFirstDao();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try {
			if (dao.addIll(ill) > 0) {			
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加成功！\");");
				out.println("window.location.href='addIllegal.jsp';");
				out.println("</script>");
			} else {
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加出错！\");");
				out.println("window.location.href='addIllegal.jsp';");
				out.println("</script>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
