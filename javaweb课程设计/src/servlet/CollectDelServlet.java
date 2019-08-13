package servlet;



import bean.CollectDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CollectDel")

public class CollectDelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollectDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String bookId = request.getParameter("bookId");
        CollectDao dao = new CollectDao();
//        System.out.println("bookId=" + bookId);
        int result = 0;
        try {
            result = dao.delete(userId,bookId);
        }catch (Exception ex) {
            ex.printStackTrace();
            result = -1;
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        if (result > 0) {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"数据删除成功！\");");
            out.println("window.location.href='InformList';");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"数据删除出错！\");");
            out.println("window.location.href='InformList';");
            out.println("</script>");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
