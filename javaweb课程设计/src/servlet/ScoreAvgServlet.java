package servlet;

import bean.ReferenceDao;
import bean.ScoreBean;
import bean.ScoreDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ScoreAvg")
public class ScoreAvgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ScoreBean bean = (ScoreBean) request.getAttribute("bean");

        ReferenceDao dao = new ReferenceDao();

        int result = 0;
        try {
            result = dao.avgScore(bean);
        }catch (Exception ex) {
            ex.printStackTrace();
            result = -1;
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        if (result > 0) {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"数据删除成功！\");");
            out.println("window.location.href='Score.jsp';");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"数据删除出错！\");");
            out.println("window.location.href='Score.jsp';");
            out.println("</script>");
        }
    }
}
