package servlet;

import java.io.IOException;

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
import bean.upBookBean;

@WebServlet("/UploadBook")

public class UploadBookServlet extends HttpServlet {

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
		//处理上传
		System.out.println("reUserID:"+request.getParameter("userId"));
		SmartUpload su = new SmartUpload();//通过smartupload上传书籍文件
		su.initialize(this.getServletConfig(), request, response);
		su.setAllowedFilesList("txt");
		su.setCharset("utf-8");
		
		try {
			su.upload();
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}

		// 构建新增的BookBean
		upBookBean bean = new upBookBean();
		bean.setUserId(Integer.parseInt(su.getRequest().getParameter("userId")));
		
		bean.setbName(su.getRequest().getParameter("bName"));
		bean.setbAuthor(su.getRequest().getParameter("bAuthor"));
		bean.setbInfo(su.getRequest().getParameter("bInfo"));
		bean.setbSub(su.getRequest().getParameter("bSub"));
		bean.setIfCheck("否");
		
		File file = su.getFiles().getFile(0);
		try {
			file.saveAs("/temp/" + file.getFileName());//上传文件的存储路径 
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
		bean.setbAttach(file.getFileName());
		
		// 插入到数据库
		BookDao dao = new BookDao();
		try {
			if (dao.uploadBook(bean) > 0) {  // 插入数据成功
				response.sendRedirect("UserIndex");
			} else {			// 插入数据失败！
				response.sendRedirect("uploadBook.jsp");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
