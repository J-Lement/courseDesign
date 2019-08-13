package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import bean.BookBean;
import bean.BookDao;
import util.CheckIt;

@WebServlet("/BookAdd")
public class BookAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 处理上传
		System.out.println("fsdfsfsd");
		SmartUpload su = new SmartUpload();//通过smartupload上传书籍文件
		su.initialize(this.getServletConfig(), request, response);
		su.setAllowedFilesList("txt");
		su.setCharset("utf-8");
		
		try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if(!CheckIt.IsNum(su.getRequest().getParameter("bookId")) || !CheckIt.IsString(su.getRequest().getParameter("bookName"))) {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"请填写正确信息！\");");
			out.println("window.location.href='book_add.jsp';");
			out.println("</script>");
			return;
		}
		// 构建新增的BookBean
		BookBean bean = new BookBean();
		bean.setBookId(Integer.parseInt(su.getRequest().getParameter("bookId")));
		
		
		bean.setBookName(su.getRequest().getParameter("bookName"));
		bean.setBookAuthor(su.getRequest().getParameter("bookAuthor"));
		bean.setBookInfo(su.getRequest().getParameter("bookInfo"));
		bean.setBookSub(su.getRequest().getParameter("bookSub"));
		bean.setUpTime(0);
		
		File file = su.getFiles().getFile(0);
		
		try {
			file.saveAs("/upload/" + file.getFileName());//上传文件的存储路径 
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		bean.setBookAttach(file.getFileName());
		
		
		
		// 插入到数据库
		BookDao dao = new BookDao();
//		try {
//			if (dao.bookAdd(bean) > 0) {  // 插入数据成功
//				response.sendRedirect("AdminIndex");
//			} else {			// 插入数据失败！
//				response.sendRedirect("book_add.jsp");
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		try {
			if (dao.bookAdd(bean) > 0) {			
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加成功！\");");
				out.println("window.location.href='AdminIndex';");
				out.println("</script>");
			} else {
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"数据添加出错！\");");
				out.println("window.location.href='book_add.jsp';");
				out.println("</script>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
