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

@WebServlet("/FollowList")
public class FollowListServlet extends HttpServlet {
    public FollowListServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String curPage = request.getParameter("cur_page");

        if (curPage == null || "".equals(curPage))
            curPage = "1";
        SubjectDao dao = new SubjectDao();
        List<SubjectBean> list = null;
        Pager pager = new Pager();
        pager.setCurPage(Integer.parseInt(curPage));
        try {
            list = dao.listSubject(userId, pager);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("userId", userId);
        request.setAttribute("list", list);
        request.setAttribute("pager", pager);
        request.getRequestDispatcher("Follow_add.jsp").forward(request, response);
    }
}
