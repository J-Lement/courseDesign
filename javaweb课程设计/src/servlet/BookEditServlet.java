package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;
import bean.BookDao;

@WebServlet("/BookEdit")

public class BookEditServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		System.out.println("bookEdit   "+bookId);
		if(bookId == null || "".equals(bookId)) {//若id为空则返回主界面
			response.sendRedirect("AdminIndex");
			return;
		}
		
		BookDao dao = new BookDao();
		BookBean bean = null;
		try {
			bean = dao.loadEdit(Integer.parseInt(bookId));//根据id加载书籍内容，将返回值存入bookBean中
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("bean", bean);
		request.getRequestDispatcher("bookEdit.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	

}
