package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;
import bean.BookDao;
import bean.upBookBean;
import util.Pager;

@WebServlet("/CheckBook")

public class CheckBookServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bName = request.getParameter("bName");
		String bSub = request.getParameter("bSub");
		String ifCheck = request.getParameter("ifCheck");
		String curPage = request.getParameter("cur_page");
		if (curPage == null || "".equals(curPage))
			curPage = "1";
		BookDao dao = new BookDao();
		List<upBookBean> list = null;
		Pager pager = new Pager();
		pager.setCurPage(Integer.parseInt(curPage));
		try {
			list = dao.listUpBook(bName, bSub, ifCheck, pager);//显示书籍信息
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("bName", bName);
		request.setAttribute("bSub", bSub);
		request.setAttribute("ifCheck", ifCheck);
		request.setAttribute("upList", list);
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("checkBook.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
