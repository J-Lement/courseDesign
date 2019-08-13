package servlet;

import bean.FocusDao;
import bean.SubjectBean;
import bean.SubjectDao;
import bean.FocusBean;
import util.Pager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FocusList")
public class FocusListServlet extends HttpServlet {
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

        SubjectDao dao = new SubjectDao();
        FocusDao Fdao = new FocusDao();
        List<SubjectBean> SJlist = null;
        List<FocusBean> list = null;

//        System.out.print(userId);
        try {
            list = dao.loadSubject(userId);

            SJlist = Fdao.loadFocus(list,pager);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("userId", userId);
        request.setAttribute("list", SJlist);
        request.setAttribute("pager", pager);
        request.getRequestDispatcher("FocusRecommend").forward(request, response);
    }
}
