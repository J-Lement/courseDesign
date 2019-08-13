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

@WebServlet("/BookMarkList")
public class BookMarkListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = (String) request.getSession().getAttribute("userId");
        String curPage = request.getParameter("cur_page");
        int i = 0;

        if (curPage == null || "".equals(curPage))
            curPage = "1";
        Pager pager = new Pager();
        pager.setCurPage(Integer.parseInt(curPage));
//
//        if (curPage == null || "".equals(curPage))
//            curPage = "1";
        BookMarkDao dao = new BookMarkDao();
        BookDao Bdao = new BookDao();
//        BookMarkDao Fdao = new FocusDao();
//        List<SubjectBean> SJlist = null;
        List<BookMarkBean> list = null;
        List<BookBean> BKlist = null;

//        System.out.print(userId);
        try {
            list = dao.loadBookMark(userId);
            BKlist = Bdao.loadBookMark(list,pager);
        } catch (Exception e) {
            e.printStackTrace();
        }



        request.setAttribute("userId", userId);
        request.setAttribute("list",BKlist);
        request.setAttribute("rTime",BKlist.get(0).getrTime());
        request.setAttribute("pager", pager);
        request.getRequestDispatcher("BookmarkList.jsp").forward(request, response);
    }

}
