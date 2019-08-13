package servlet;

import bean.CommentFirstBean;
import bean.CommentFirstDao;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CommentAdd")
public class CommentAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = (String) request.getSession().getAttribute("userId");
        String bookId = request.getParameter("bookId");
        String comment = StringUtil.toCN(request.getParameter("comment"));

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        CommentFirstBean bean = new CommentFirstBean();
        CommentFirstDao dao = new CommentFirstDao();

        bean.setuserId(Integer.parseInt(userId));
        bean.setBookId(Integer.parseInt(bookId));
        bean.setContent(comment);

        try {
            dao.addComment(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.print("<script type=\"text/javascript\">");
        out.print("window.alert(\"发送成功\");");
        out.print("window.location.href=\"BookInfo?bookId="+bookId);
        out.print("\";");

        out.print("</script>");
    }
}
