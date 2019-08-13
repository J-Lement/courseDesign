package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.SchBean;
import bean.SubDao;
import util.Pager;

public class SchManageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String schName = request.getParameter("schName");
		String curPage = request.getParameter("cur_page");
		if(curPage == null || "".equals(curPage))
			curPage = "1";
		
		Pager pager = new Pager();
		pager.setCurPage(Integer.parseInt(curPage));
		SubDao dao = new SubDao();
		List<SchBean> schList =null;
		
		try {
			schList = dao.listSch(schName, pager);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("schName", schName);
		request.setAttribute("schList", schList);
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("schManage.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
