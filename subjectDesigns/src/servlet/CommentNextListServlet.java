package servlet;

import bean.CommentSecBean;
import bean.CommentSecDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CommentNextList")
public class CommentNextListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = (String) request.getSession().getAttribute("userId");
        String cId = request.getParameter("cId");
        String CSbean = request.getParameter("bean");

        System.out.println("CID!=" + cId);

        CommentSecBean bean = new CommentSecBean();
        CommentSecDao dao = new CommentSecDao();
        List<CommentSecBean> list = new ArrayList<CommentSecBean>();

        try {
            list = dao.listCommentSec(cId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("userId", userId);
        request.setAttribute("cId",cId);
        request.setAttribute("CSbean",CSbean);
        request.setAttribute("list",list);
        request.getRequestDispatcher("commentNextList.jsp").forward(request, response);
    }
}
