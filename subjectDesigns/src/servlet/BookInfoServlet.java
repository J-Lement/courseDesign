package servlet;

import bean.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/BookInfo")
public class BookInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = (String) request.getSession().getAttribute("userId");
        String bookId = request.getParameter("bookId");

        BookDao BKdao = new BookDao();
        BookBean BKbean = new BookBean();
        CommentFirstDao CFdao = new CommentFirstDao();
        List<CommentFirstBean> list = new ArrayList<CommentFirstBean>();
        ReferenceDao RCdao = new ReferenceDao();

        try {
            BKbean = BKdao.loadBook(Integer.parseInt(bookId));
            list = CFdao.listFile(bookId);
            RCdao.AddNumofBro(bookId);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println("book = "+ BKbean.getBookInfo());
        for (CommentFirstBean bean:list
             ) {
            System.out.println("cId=" + bean.getCld());
        }

        request.setAttribute("userId", userId);
        request.setAttribute("bookId",bookId);
        request.setAttribute("BKbean", BKbean);
        request.setAttribute("list",list);
        request.getRequestDispatcher("commentList.jsp").forward(request, response);
    }
}
