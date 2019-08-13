package servlet;

import bean.BookBean;
import bean.ReferenceBean;
import bean.ReferenceDao;
import bean.SubjectBean;
import util.Pager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/FocusRecommend")
public class FocusRecommendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = (String) request.getAttribute("userId");
        List<SubjectBean> SJlist = (List<SubjectBean>) request.getAttribute("list");
        Pager pager = (Pager) request.getAttribute("pager");

        ReferenceBean bean = new ReferenceBean();
        ReferenceDao dao = new ReferenceDao();
        List<ReferenceBean> list = new ArrayList<>();
        List<BookBean> BKlist = new ArrayList<>();

        int i = 0;

        try {
            list = dao.countRecommend();

            i = dao.updateRecommend(list);

            BKlist = dao.SortRecommend(SJlist);

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("userId", userId);
        request.setAttribute("list", SJlist);
        request.setAttribute("BKlist",BKlist);
        request.setAttribute("pager", pager);
        request.getRequestDispatcher("FollowList.jsp").forward(request, response);

    }
}
