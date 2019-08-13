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

@WebServlet("/ScoreAdd")
public class ScoreAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String bookId = request.getParameter("bookId");
        String ifScore = request.getParameter("ifScore");
        String score = request.getParameter("score");

        ScoreBean bean = new ScoreBean();
        ScoreDao dao = new ScoreDao();

        bean.setUserId(Integer.parseInt(userId));
        bean.setBookId(Integer.parseInt(bookId));
        bean.setIfScore(Integer.parseInt(ifScore));
        bean.setScore(Float.parseFloat(score));

        int result = 0;

        try {
            result = dao.addScore(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("bean",bean);
        request.getRequestDispatcher("ScoreAvg").forward(request, response);
    }
}
