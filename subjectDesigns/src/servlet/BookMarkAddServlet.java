package servlet;

import bean.BookMarkBean;
import bean.BookMarkDao;
import bean.FocusBean;
import bean.SubjectDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/BookMarkAdd")
public class BookMarkAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        String userId = request.getParameter("userId");
        String bookId = request.getParameter("bookId");

//        System.out.print(userId);
//        System.out.print(bookId);

        BookMarkBean bean = new BookMarkBean(Integer.parseInt(userId),Integer.parseInt(bookId),"50","0");
        BookMarkDao dao = new BookMarkDao();

//        System.out.print(bean.getUserId());

        try {
            dao.addBookMark(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.print("<script type=\"text/javascript\">");
        out.print("window.alert(\"保存成功\");");
        out.print("window.location.href=\"BookMarkList\";");

        out.print("</script>");
    }
}
