package servlet;

import bean.UserBean;
import bean.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/UserPasswordEdit")
public class UserPasswordEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String old_Password = request.getParameter("old_password");
        String new_password = request.getParameter("new_password");
        String check_password = request.getParameter("check_password");

        int result = 0;

        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
//        System.out.println("check_password="+userId);


        if(userId == null || "".equals(userId)) {
            response.sendRedirect("password_edit.jsp");
            return;
        }

        UserDao dao = new UserDao();
        UserBean bean = null;
        try {
            result = dao.newPassword(userId,old_Password,new_password,check_password);
        } catch (NumberFormatException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        out.print("<script type=\"text/javascript\">");
        out.print("window.alert(\"保存成功\");");
        out.print("window.location.href=\"InformList\";");

        out.print("</script>");
    }
}
