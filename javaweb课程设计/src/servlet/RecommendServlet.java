package servlet;

import bean.BookBean;
import bean.UserBean;
import bean.ReferenceBean;
import bean.ReferenceDao;
import bean.SubjectBean;
import util.Pager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Recommend")
public class RecommendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = (String) request.getAttribute("userId");
        List<BookBean> Blist = (List<BookBean>) request.getAttribute("list");
        List<String> listSch = (List<String>) request.getAttribute("listSch");
        List<String> listMaj = (List<String>) request.getAttribute("listMaj");
        List<String> listSub = (List<String>) request.getAttribute("listSub");
        String schName = (String) request.getAttribute("schName");
        String majName = (String) request.getAttribute("majName");
        String subName = (String) request.getAttribute("subName");
        Pager pager = (Pager) request.getAttribute("pager");
//
//        for (SubjectBean bean:SJlist
//             ) {
//            System.out.println("1="+bean.getSubName());
//            System.out.println("2="+bean.getSubId());
//        }


//
//        for (BookBean BKbean:Blist
//        ) {
//            System.out.println("1="+ BKbean.getBookName());
//            System.out.println("2="+BKbean.getBookAuthor());
//            System.out.println("3="+BKbean.getBookAttach());
//            System.out.println("4="+BKbean.getBookId());
//        }

        ReferenceBean bean = new ReferenceBean();
        ReferenceDao dao = new ReferenceDao();
        List<ReferenceBean> list = new ArrayList<>();
        List<BookBean> BKlist = new ArrayList<>();

        int i = 0;

        try {
             list = dao.countRecommend();

             i = dao.updateRecommend(list);

             BKlist = dao.SortRecommend(null);



//            for (ReferenceBean Rbean:list
//                 ) {
//                System.out.println("1="+Rbean.getSubId());
//                System.out.println("2="+Rbean.getBookId());
//                System.out.println("3="+Rbean.getNumOfCol());
//                System.out.println("4="+Rbean.getNumOfBro());
//                System.out.println("5="+Rbean.getAvgScore());
//                System.out.println("6="+Rbean.getRecommend());
//            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("listSch", listSch);
        request.setAttribute("listMaj", listMaj);
        request.setAttribute("listSub", listSub);
        request.setAttribute("schName", schName);
        request.setAttribute("majName", majName);
        request.setAttribute("subName", subName);
        request.setAttribute("userId", userId);
        request.setAttribute("list", Blist);
        request.setAttribute("BKlist",BKlist);
        request.setAttribute("pager", pager);
        request.getRequestDispatcher("userIndex.jsp").forward(request, response);

    }
}
