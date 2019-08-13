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

@WebServlet("/CollectList")
public class CollectListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String curPage = request.getParameter("cur_page");

        if (curPage == null || "".equals(curPage))
            curPage = "1";
        Pager pager = new Pager();
        pager.setCurPage(Integer.parseInt(curPage));

        CollectDao dao = new CollectDao();
        BookDao Bdao = new BookDao();
        List<CollectBean> list = null;
        List<BookBean> BKlist = null;

//        System.out.println("userId="+userId);
        try {
            list = dao.loadCollect(Integer.parseInt(userId));

            BKlist = Bdao.loadBook(list,pager);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("userId", userId);
        request.setAttribute("list", BKlist);
        request.setAttribute("pager", pager);
        request.getRequestDispatcher("CollectList.jsp").forward(request, response);
    }
}
