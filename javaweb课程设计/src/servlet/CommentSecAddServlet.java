package servlet;

import bean.CommentFirstBean;
import bean.CommentFirstDao;
import bean.CommentSecBean;
import bean.CommentSecDao;
import util.StringUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CommentSecAdd")
public class CommentSecAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cId = request.getParameter("cId");
        String userId = (String) request.getSession().getAttribute("userId");
        String contentNext = StringUtil.toCN(request.getParameter("contentNext"));

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        CommentSecBean bean = new CommentSecBean();
        CommentSecDao dao = new CommentSecDao();

        System.out.println("cid=" + cId);
        System.out.println("userIdd=" + userId);

        bean.setcId(Integer.parseInt(cId));
        bean.setUserId(Integer.parseInt(userId));
        bean.setContentNext(contentNext);

        try {
            dao.addCommentSecBean(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.print("<script type=\"text/javascript\">");
        out.print("window.alert(\"发送成功\");");
        out.print("window.location.href=\"CommentNextList?cId="+cId);
        out.print("\";");

        out.print("</script>");
    }
}
