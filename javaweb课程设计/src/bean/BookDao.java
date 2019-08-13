package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;
import util.Pager;

public class BookDao {
	/*
	 * 在AdminIndex中调用，显示主界面的内容，若有查询条件，则显示查询结果
	 * 参数为学校名称，专业名称，课程名称，pager是用于分页的
	 */
	public List<BookBean> listBook(String schName, String majName, String subName, Pager pager) throws SQLException {
		List<BookBean> list = new ArrayList<BookBean>();
		Connection conn = DBUtil.getConnection();
		int schId = 0, majId = 0, subId = 0;
		String whereSql = "";

		System.out.println("sqlschname:" + schName + " " + majName);
		if (conn != null) {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "";
			if (schName != null && !"".equals(schName)) {//查询学校id
				sql = "select schId from School where schName = '" + schName + "'";
				System.out.println("sqlthisthis:" + sql);
				ResultSet rs1 = stmt.executeQuery(sql);
				if (rs1.next())
					schId = rs1.getInt("schId");
			}
			if (majName != null && !"".equals(majName)) {//查询专业id
				sql = "select majId from Major where majName = '" + majName + "'";
				ResultSet rs2 = stmt.executeQuery(sql);
				if (rs2.next())
					majId = rs2.getInt("majId");
			}
			sql = "select count(*) from Reference where subId in(";
			if (subName == null || "".equals(subName)) {//查询课程id,若无具体课程名称，则查询是否有具体的学校和专业
				whereSql = "select subId from Subject where 1=1";    //wheresql语句查询的是课程id的结果集
				if (schId != 0)
					whereSql += "and schId =" + schId + "";
				if (majId != 0)
					whereSql += "and majId = " + majId + "";
				whereSql += ")";
				System.out.println("sql111:" + sql);
			} else {//若有具体的课程名称，则根据名称查询课程id
				whereSql += "select subId from Subject where subName = '" + subName + "')";
			}

			// 先计算总记录数
			System.out.println("sql222:" + sql + whereSql);
			ResultSet rs = stmt.executeQuery(sql + whereSql);
			int totalCount = 0;//记载查询到的信息的总条数，用于分页
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
			System.out.println("totalcount:" + totalCount);
			rs.close();
			pager.setTotalRecord(totalCount);

			sql = "select * from Book where bookId in (select top " + pager.getCurPage() * pager.getPageSize()
					+ " bookId from Reference where subId in(" + whereSql + ") and bookId not in (";//显示当前页数的信息
			sql += "   select top " + (pager.getCurPage() - 1) * pager.getPageSize()
					+ "   bookId from Reference where subId in( " + whereSql + ")";
			System.out.println("sql333:" + sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BookBean bean = new BookBean();
				bean.setBookId(rs.getInt("bookId"));
				bean.setBookName(rs.getString("bookName"));
				bean.setBookAuthor(rs.getString("bookAuthor"));
				bean.setBookInfo(rs.getString("bookInfo"));
				bean.setBookSub(rs.getString("bookSub"));
				bean.setBookAttach(rs.getString("bookAttach"));
				list.add(bean);
			}
			rs.close();
			stmt.close();
		}
		DBUtil.freeConnection(conn);
		return list;
	}

	/*
	 * 获取用户上传的书籍信息
	 */
	public List<upBookBean> listUpBook(String bName, String bSub, String ifCheck, Pager pager) throws SQLException {
		List<upBookBean> list = new ArrayList<upBookBean>();
		Connection conn = DBUtil.getConnection();
		String whereSql = " where 1=1";

		if (conn != null) {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "select count(*) from TempBook";
			if (bName != null && !"".equals(bName))
				whereSql += " and bName like '%" + bName + "%'";    //wheresql语句查询的是课程id的结果集
			if (bSub != null && !"".equals(bSub))
				whereSql += " and bSub like '%" + bSub + "%'";
			if (ifCheck != null && !"".equals(ifCheck))
				whereSql += " and ifCheck = '" + ifCheck + "'";

			// 先计算总记录数
			System.out.println("sqlcount:" + sql + whereSql);
			ResultSet rs = stmt.executeQuery(sql + whereSql);
			int totalCount = 0;//记载查询到的信息的总条数，用于分页
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
			System.out.println("totalcount:" + totalCount);
			rs.close();
			pager.setTotalRecord(totalCount);

			sql = "select * from TempBook where tempId in (select top " + pager.getCurPage() * pager.getPageSize()
					+ " tempId from TempBook " + whereSql + ") and tempId not in (";//显示当前页数的信息
			sql += "   select top " + (pager.getCurPage() - 1) * pager.getPageSize()
					+ "   tempId from TempBook " + whereSql + ")";
			System.out.println("sql333:" + sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				upBookBean bean = new upBookBean();
				bean.setTempId(rs.getInt("tempId"));
				bean.setUserId(rs.getInt("userId"));
				bean.setbSub(rs.getString("bSub"));
				bean.setbName(rs.getString("bName"));
				bean.setbAuthor(rs.getString("bAuthor"));
				bean.setbInfo(rs.getString("bInfo"));
				bean.setbAttach(rs.getString("bAttach"));
				bean.setIfCheck(rs.getString("ifCheck"));
				list.add(bean);
			}
			rs.close();
			stmt.close();
		}
		DBUtil.freeConnection(conn);
		return list;
	}

	/*
	 *显示主界面学校下拉框中的信息
	 */
	public List<String> listSch() throws SQLException {//加载所有学校名称
		List<String> list = new ArrayList<String>();
		Connection conn = DBUtil.getConnection();

		if (conn != null) {
			Statement stmt = conn.createStatement();
			String sql = "select schName from School";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next())
				list.add(rs.getString("schName"));
			rs.close();
			stmt.close();
		}
		DBUtil.freeConnection(conn);
		return list;
	}

	/*
	 * 显示主界面专业下拉框中的信息
	 */
	public List<String> listMaj() throws SQLException {//加载所有专业名称
		List<String> list = new ArrayList<String>();
		Connection conn = DBUtil.getConnection();

		if (conn != null) {
			Statement stmt = conn.createStatement();
			String sql = "select majName from Major";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next())
				list.add(rs.getString("majName"));
			rs.close();
			stmt.close();
		}
		DBUtil.freeConnection(conn);
		return list;
	}

	/*
	 *查询主界面课程下拉框中的信息
	 */
	public List<String> listSub() throws SQLException {//加载所有课程名称
		List<String> list = new ArrayList<String>();
		Connection conn = DBUtil.getConnection();

		if (conn != null) {
			Statement stmt = conn.createStatement();
			String sql = "select subName from Subject";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next())
				list.add(rs.getString("subName"));
			rs.close();
			stmt.close();
		}
		DBUtil.freeConnection(conn);
		return list;
	}

	/*
	 * 在数据库Book表中添加书籍
	 */
	public int bookAdd(BookBean bean) throws SQLException {
		int result = 0;
		System.out.println(""+bean.getBookId()+" "+bean.getBookName()+" " +bean.getBookAuthor()+" " +bean.getBookAttach());
		Connection conn = DBUtil.getConnection();
		if (conn != null) {
			String sql = "insert into Book(bookId, bookName, bookAuthor, bookInfo, bookAttach, bookSub ,upTime)values( ?, ?, ?, ?, ?, ?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getBookId());
			pstmt.setString(2, bean.getBookName());
			pstmt.setString(3, bean.getBookAuthor());
			pstmt.setString(4, bean.getBookInfo());
			pstmt.setString(5, bean.getBookAttach());
			pstmt.setString(6, bean.getBookSub());
			pstmt.setInt(7, 0);
			result = pstmt.executeUpdate();
		} else {
			result = -1;
		}
		DBUtil.freeConnection(conn);
		return result;
	}

	/*
	 * 在数据库TempBook表中添加书籍，即上传书的临时表
	 */
	public int uploadBook(upBookBean bean) throws SQLException {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		if (conn != null) {
			String sql = "insert into TempBook(userId, bName, bAuthor, bInfo, bAttach, ifCheck, bSub)values( ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getUserId());
			pstmt.setString(2, bean.getbName());
			pstmt.setString(3, bean.getbAuthor());
			pstmt.setString(4, bean.getbInfo());
			pstmt.setString(5, bean.getbAttach());
			pstmt.setString(6, bean.getIfCheck());
			pstmt.setString(7, bean.getbSub());
			result = pstmt.executeUpdate();
		} else {
			result = -1;
		}
		DBUtil.freeConnection(conn);

		return result;
	}

	/*
	 *根据书籍id加载‘修改书籍’界面
	 */
	public BookBean loadEdit(int bookId) throws SQLException {
		BookBean bean = new BookBean();
		Connection conn = DBUtil.getConnection();

		if (conn != null) {
			String sql = "select * from Book where bookId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setBookId(rs.getInt("bookId"));
				bean.setBookName(rs.getString("bookName"));
				bean.setBookAuthor(rs.getString("bookAuthor"));
				bean.setBookInfo(rs.getString("bookInfo"));
				bean.setBookSub(rs.getString("bookSub"));
				bean.setBookAttach(rs.getString("bookAttach"));
			}
			rs.close();
			pstmt.close();
		}
		DBUtil.freeConnection(conn);
		return bean;
	}

	/*
	 * 根据上传书的id加载此书的相关信息
	 */
	public upBookBean loadUpBook(int tempId) throws SQLException {
		upBookBean bean = new upBookBean();
		Connection conn = DBUtil.getConnection();

		if (conn != null) {
			String sql = "select * from TempBook where tempId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tempId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setbName(rs.getString("bName"));
				bean.setbAuthor(rs.getString("bAuthor"));
				bean.setbInfo(rs.getString("bInfo"));
				bean.setbSub(rs.getString("bSub"));
			}
			rs.close();
			pstmt.close();
		}
		DBUtil.freeConnection(conn);
		return bean;
	}

	/*
	 * 修改数据库中书籍的信息
	 */
	public int updateBook(BookBean bean) throws SQLException {
		int result = 0;
		Connection conn = DBUtil.getConnection();

		if (conn != null) {
			String sql = "update Book set bookName = ?, bookAuthor = ?, bookInfo = ?, bookSub = ? where bookId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getBookName());
			pstmt.setString(2, bean.getBookAuthor());
			pstmt.setString(3, bean.getBookInfo());
			pstmt.setString(4, bean.getBookSub());
			pstmt.setInt(5, bean.getBookId());
			result = pstmt.executeUpdate();
			pstmt.close();
		} else {
			result = -1;
		}
		DBUtil.freeConnection(conn);
		return result;
	}

	/*
	 * 上传书籍审核通过后更改tempBook表信息
	 */
	public int updateUpBook(int tempId) throws SQLException {
		int result = 0;
		Connection conn = DBUtil.getConnection();

		if (conn != null) {
			String sql = "update TempBook set ifCheck = ? where tempId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "是");
			pstmt.setInt(2, tempId);
			result = pstmt.executeUpdate();
		} else
			result = -1;

		return result;
	}

	/*
	 * 在数据库中删除书籍
	 */
	public int deleteBook(int bookId) throws SQLException {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		if (conn != null) {
			String sql = "delete from Book where bookId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			result = pstmt.executeUpdate();
			pstmt.close();
		} else {
			result = -1;
		}
		DBUtil.freeConnection(conn);
		return result;
	}

	public List<BookBean> loadBook(List<CollectBean> list,Pager pager) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		List<BookBean> BKlist = new ArrayList<BookBean>();

		Connection conn = DBUtil.getConnection();

		int totalCount = 0;
		for (CollectBean bean:list
		) {
			totalCount++;
		}
		pager.setTotalRecord(totalCount);

		for (CollectBean bean : list
		) {
			if (conn != null) {
				String sql = "select * from Book where bookId = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bean.getBookId());
				ResultSet rs = pstmt.executeQuery();

//				System.out.print(sql);

				while (rs.next()) {
					BookBean BKbean = new BookBean();
					BKbean.setBookId(rs.getInt("bookId"));
					BKbean.setBookName(rs.getString("bookName"));
					BKbean.setBookAuthor(rs.getString("bookAuthor"));
					BKbean.setBookInfo(rs.getString("bookInfo"));
					BKbean.setBookSub(rs.getString("bookSub"));
					BKbean.setBookAttach(rs.getString("bookAttach"));
					BKlist.add(BKbean);
				}
//            sql = "select * from Book where bookId = ?";
//            PreparedStatement rpstmt = conn.prepareStatement(sql);
//            rpstmt.setInt(1, bean.getBookId());
//            ResultSet rrs = rpstmt.executeQuery();
//
//            System.out.print(sql);

//            if(rrs.next()) {
//                BKbean.setBookId(rrs.getInt("bookId"));
//                BKbean.setBookName(rrs.getString("bookName"));
//                BKbean.setBookAuthor(rrs.getString("bookAuthor"));
//                BKbean.setBookInfo(rrs.getString("bookInfo"));
//            }
			}
		}


		return BKlist;
	}

	/*
	载入用户所有书签

	 */


	public List<BookBean> loadBookMark(List<BookMarkBean> list, Pager pager) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		List<BookBean> BKlist = new ArrayList<BookBean>();

		Connection conn = DBUtil.getConnection();

        int totalCount = 0;
            for (BookMarkBean bean:list
                 ) {
                totalCount++;
            }
            pager.setTotalRecord(totalCount);

            for (BookMarkBean bean:list
		) {
			if (conn != null) {
				String sql = "select * from Book where bookId = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bean.getBookId());
				ResultSet rs = pstmt.executeQuery();

//				System.out.print(sql);

				while(rs.next()) {
					BookBean BKbean = new BookBean();
					BKbean.setReading(bean.getReading());
					BKbean.setrTime(bean.getrTime());
					BKbean.setBookId(rs.getInt("bookId"));
					BKbean.setBookName(rs.getString("bookName"));
					BKbean.setBookAuthor(rs.getString("bookAuthor"));
					BKbean.setBookInfo(rs.getString("bookInfo"));
					BKbean.setBookSub(rs.getString("bookSub"));
					BKbean.setBookAttach(rs.getString("bookAttach"));
					BKlist.add(BKbean);
				}
			}
		}


		return BKlist;
	}

	/*
	载入本书详细信息
	 */
	public BookBean loadBook(int bookId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		BookBean BKbean = new BookBean();
		Connection conn = DBUtil.getConnection();
		if (conn != null) {
			String sql = "select * from Book where bookId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()){
				BKbean.setBookId(rs.getInt("bookId"));
				BKbean.setBookName(rs.getString("bookName"));
				BKbean.setBookAuthor(rs.getString("bookAuthor"));
				BKbean.setBookInfo(rs.getString("bookInfo"));
				BKbean.setBookSub(rs.getString("bookSub"));
				BKbean.setBookAttach(rs.getString("bookAttach"));
			}
		}


		return BKbean;
	}
}
