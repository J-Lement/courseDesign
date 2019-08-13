package servlet;

import bean.FocusBean;
import bean.SubjectDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FollowAdd")
public class FollowAddServlet extends HttpServlet {
    public FollowAddServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        String userId = request.getParameter("userId");
        String subId = request.getParameter("subId");

//        System.out.print(userId);
//        System.out.print(subId);

        FocusBean bean = new FocusBean(Integer.parseInt(userId),Integer.parseInt(subId),1);
        SubjectDao dao = new SubjectDao();

//        System.out.print(bean.getUserId());

        try {
            dao.addSubject(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.print("<script type=\"text/javascript\">");
        out.print("window.alert(\"保存成功\");");
        out.print("window.location.href=\"FollowList\";");

        out.print("</script>");


    }
}
