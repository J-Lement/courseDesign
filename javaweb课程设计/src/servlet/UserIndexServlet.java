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
import util.Pager;

@WebServlet("/UserIndex")

public class UserIndexServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String schName = request.getParameter("schName");
		String majName = request.getParameter("majName");
		String curPage = request.getParameter("cur_page");
		String subName = request.getParameter("subName");
		String userId = (String) request.getAttribute("userId");

		if (curPage == null || "".equals(curPage))
			curPage = "1";
		BookDao dao = new BookDao();
		List<BookBean> list = null;
		List<String> listSub = null;
		List<String> listSch = null;
		List<String> listMaj = null;
		Pager pager = new Pager();
		pager.setCurPage(Integer.parseInt(curPage));
		try {
			list = dao.listBook(schName, majName, subName, pager);//显示书籍信息
			listSub = dao.listSub();//显示所有课程
			listSch = dao.listSch();//显示所有学校
			listMaj = dao.listMaj();//显示所有专业
		} catch (Exception e) {
			e.printStackTrace();
		}	
		request.setAttribute("listSch", listSch);
		request.setAttribute("listMaj", listMaj);
		request.setAttribute("listSub", listSub);
		request.setAttribute("schName", schName);
		request.setAttribute("majName", majName);
		request.setAttribute("subName", subName);
		request.setAttribute("userId",userId);
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("Recommend").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	

}
