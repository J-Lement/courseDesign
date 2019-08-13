package servlet;

import bean.BookMarkDao;
import bean.CollectDao;
import bean.FocusBean;
import bean.FocusDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InformList")
public class InformListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        int CollectCount = 0;
        int FocusCount = 0;
        int MarkCount = 0;

//        System.out.println("罗杰：" + userId);

        CollectDao Cdao = new CollectDao();
        FocusDao Fdao = new FocusDao();
        BookMarkDao BMdao = new BookMarkDao();

        try {
            CollectCount = Cdao.conuntCollect(userId);
            FocusCount = Fdao.conuntFocus(userId);
            MarkCount = BMdao.conuntBookMark(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("userId",userId);
        request.setAttribute("CollectCount",CollectCount);
        request.setAttribute("FocusCount",FocusCount);
        request.setAttribute("MarkCount",MarkCount);
        request.getRequestDispatcher("InformList.jsp").forward(request, response);
    }
}
