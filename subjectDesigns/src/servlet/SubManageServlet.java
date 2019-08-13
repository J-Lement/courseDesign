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
import bean.SubBean;
import bean.SubDao;
import util.Pager;

public class SubManageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String schName = request.getParameter("schName");
		String majName = request.getParameter("majName");
		String subName = request.getParameter("subName");
		String curPage = request.getParameter("cur_page");
		if(curPage == null || "".equals(curPage))
			curPage = "1";
		
		Pager pager = new Pager();
		pager.setCurPage(Integer.parseInt(curPage));
		SubDao dao = new SubDao();
		List<SubBean> subList =null;
		
		try {
			subList = dao.listSub(schName, majName, subName, pager);//获取课程信息
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookDao bDao = new BookDao();
		List<String> listSch = null;
		List<String> listMaj = null;
		try {
			listSch = bDao.listSch();
			listMaj = bDao.listMaj();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listSch", listSch);
		request.setAttribute("listMaj", listMaj);
		request.setAttribute("schName", schName);
		request.setAttribute("majName", majName);
		request.setAttribute("subName", subName);
		request.setAttribute("subList", subList);
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("subManage.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
