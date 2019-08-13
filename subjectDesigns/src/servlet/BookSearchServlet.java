package servlet;


import bean.*;
import util.Pager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


/**
 * Servlet implementation class EmployeeListServlet
 */
@WebServlet("/BookSearch")

public class BookSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String curPage = request.getParameter("cur_page");

        System.out.print(userId);


        if (curPage == null || "".equals(curPage))
            curPage = "1";
        CollectDao dao = new CollectDao();
        List<BookBean> list = null;
        Pager pager = new Pager();
        pager.setCurPage(Integer.parseInt(curPage));
        try {
            list = dao.listCollect(Integer.parseInt(userId));
        } catch (Exception e) {
            e.printStackTrace();
        }


        request.setAttribute("userId", userId);
        request.setAttribute("list", list);
        request.setAttribute("pager", pager);
        request.getRequestDispatcher("CollectList.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
