package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookDao;
import bean.MajBean;
import bean.SchBean;
import bean.SubDao;
import util.Pager;

public class MajManageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String schName = request.getParameter("schName");
		String majName = request.getParameter("majName");
		String curPage = request.getParameter("cur_page");
		if(curPage == null || "".equals(curPage))
			curPage = "1";
		
		Pager pager = new Pager();
		pager.setCurPage(Integer.parseInt(curPage));
		SubDao dao = new SubDao();
		List<MajBean> majList =null;
		
		try {
			majList = dao.listMaj(schName, majName, pager);//获取专业信息
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookDao bDao = new BookDao();
		List<String> listSch = null;
		try {
			listSch = bDao.listSch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listSch", listSch);
		request.setAttribute("schName", schName);
		request.setAttribute("majName", majName);
		request.setAttribute("majList", majList);
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("majManage.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
