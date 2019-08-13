package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookDao;
import bean.upBookBean;

@WebServlet("/SaveUpBook")

public class SaveUpBookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempId = request.getParameter("tempId");
		if(tempId == null || "".equals(tempId)) {
			response.sendRedirect("CheckBook");
			return;
		}
		int tId = Integer.parseInt(tempId);
		upBookBean bean = null;
		BookDao dao = new BookDao();
		try {
			bean = dao.loadUpBook(tId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i =0;
		if(bean != null)
			try {
				i=dao.updateUpBook(tId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		System.out.println("数据库中是否审核"+i);
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("saveUpBook.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
