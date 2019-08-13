package servlet;

import bean.CollectBean;
import bean.CollectDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CollectAdd")
public class CollectAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = (String) request.getSession().getAttribute("userId");
        String bookId = request.getParameter("bookId");

//        System.out.println("userId=" + userId);
//        System.out.println("bookId=" + bookId);

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        CollectBean CTbean = new CollectBean();
        CollectDao dao = new CollectDao();

        CTbean.setUserId(Integer.parseInt(userId));
        CTbean.setBookId(Integer.parseInt(bookId));
        CTbean.setIfCol(1);

        try{
            dao.addCollect(CTbean);
        }catch (Exception e) {
            e.printStackTrace();
        }

        out.print("<script type=\"text/javascript\">");
        out.print("window.alert(\"收藏成功\");");
        out.print("window.location.href=\"FollowList\";");

        out.print("</script>");
    }
}
