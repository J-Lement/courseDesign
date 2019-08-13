package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BookBean;
import bean.BookDao;
import util.CheckIt;
import util.DBUtil;
import util.StringUtil;

@WebServlet("/BookEditDo")

public class BookEditDoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("---update Book in Servlet");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookName = StringUtil.toCN(request.getParameter("bookName"));
		String bookAuthor = StringUtil.toCN(request.getParameter("bookAuthor"));
		String bookInfo = StringUtil.toCN(request.getParameter("bookInfo"));
		String bookAttach = StringUtil.toCN(request.getParameter("bookAttach"));
		String bookSub = StringUtil.toCN(request.getParameter("bookSub"));
		
		if(!CheckIt.IsString(bookName) || !CheckIt.IsString(bookSub) || !CheckIt.IsString(bookAuthor)) {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据格式不正确\");");
			out.println("window.location.href=\"AdminIndex\";");
			out.println("</script>");
			return;
		}
		BookBean bean = new BookBean();
		bean.setBookId(bookId);
		bean.setBookName(bookName);
		bean.setBookAuthor(bookAuthor);
		bean.setBookInfo(bookInfo);
		bean.setBookSub(bookSub);
		bean.setBookAttach(bookAttach);
		
		BookDao dao = new BookDao();
		int result = 0;
		try {
			result = dao.updateBook(bean);//将书籍信息存入bean中，通过dao更新数据库中的信息，返回的是数据库中影响的行数
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = -1;
		}
		
		
		if(result > 0) {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据修改成功\");");
			out.println("window.location.href=\"AdminIndex\";");
			out.println("</script>");
		}else {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"数据修改失败\");");
			out.println("window.location.href=\"BookEdit?bookId=" + bookId + "\";");
			out.println("</script>");
		}
	}

}
