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

public class SubDao {
	/*
	 *显示学校管理界面中的信息
	 */
	public List<SchBean> listSch(String schName, Pager pager) throws SQLException{//加载所有学校名称
		List<SchBean> list = new ArrayList<SchBean>();
		Connection conn = DBUtil.getConnection();
		
		if(conn != null) {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "select * from School";
			if(schName != null && !"".equals(schName)) {
				sql += " where schName like '%" + schName + "%'";
			}
			
			ResultSet rs = stmt.executeQuery(sql);
			int totalCount = 0;
			
			rs.last();
			totalCount = rs.getRow();
			rs.close();
			pager.setTotalRecord(totalCount);
			
			sql = "select * from School where schId in(select top "+ pager.getCurPage() * pager.getPageSize() 
					+" schId from School where schName like '%" + schName + "%') and schId not in(select top " +
					(pager.getCurPage()-1) * pager.getPageSize() + "schId from School where schName like '%" + schName + "%')";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				SchBean bean = new SchBean();
				bean.setSchId(rs.getInt("schId"));
				bean.setSchName(rs.getString("schName"));
				list.add(bean);
				
			}
			rs.close();
			stmt.close();
		}
		DBUtil.freeConnection(conn);
		return list;
	}
	/*
	 * 显示专业管理界面的信息
	 */
	public List<MajBean> listMaj(String schName, String majName, Pager pager) throws SQLException{
		List<MajBean> list = new ArrayList<MajBean>();
		Connection conn = DBUtil.getConnection();
		String whereSql = "";
		int schId = 0,majId = 0;
		
		if(conn != null) {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "";
			if(schName != null && !"".equals(schName)) {//查询学校id
				sql = "select schId from School where schName = '" + schName + "'";
				ResultSet rs1 = stmt.executeQuery(sql);
				if(rs1.next())
					schId = rs1.getInt("schId");
			}
			sql = "select count(*) from Major where 1=1 ";
			if(majName != null && !"".equals(majName)) //查询专业id
				whereSql += " and majId in( select majId from Major where majName like '%" + majName + "%')";
			if(schId != 0 ) {
				whereSql += " and majId in ( select majId from Subject where schId =" + schId + ")";
			}
			
			ResultSet rs = stmt.executeQuery(sql + whereSql);
			int totalCount = 0;
			if(rs.next())
				totalCount = rs.getInt(1);
			rs.close();
			System.out.println("total:"+totalCount);
			pager.setTotalRecord(totalCount);
			
			if("".equals(whereSql))
				sql = "select * from Major where majId in(select top "+ pager.getCurPage() * pager.getPageSize() 
				+" majId from Major) and majId not in(select top " + (pager.getCurPage()-1) * pager.getPageSize()
				+" majId from Major)";
			else {
			sql = "select * from Major where majId in(select top "+ pager.getCurPage() * pager.getPageSize() 
					+" majId from Subject where 1=1 " + whereSql + ") and majId not in(select top " +
					(pager.getCurPage()-1) * pager.getPageSize() + " majId from Subject where 1=1 " + whereSql + ")";
			}
			System.out.println("sql:"+sql);
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MajBean bean = new MajBean();
				bean.setMajId(rs.getInt("majId"));
				bean.setMajName(rs.getString("majName"));
				list.add(bean);
				
			}
			rs.close();
			stmt.close();
		}
		DBUtil.freeConnection(conn);
		
		return list;
	}
	/*
	 * 显示课程管理界面信息
	 */
	public List<SubBean> listSub(String schName,String majName,String subName,Pager pager) throws SQLException{
		List<SubBean> list = new ArrayList<SubBean>();
		Connection conn = DBUtil.getConnection();
		int schId = 0,majId = 0,subId = 0;
		String whereSql = "",sql1 = "", sql2 = "";
		
		System.out.println("sqlschname:"+schName+" "+ majName + " " +subName);
		if(conn != null) {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//由于subject表中只有学校
			//和专业的id，所以在获取id的时候，要通过id将学校和专业的名称获取到，所以要用到两个不同的Statement语句
			String sql = "";
			if(schName != null && !"".equals(schName)) {//查询学校id
				sql = "select schId from School where schName = '" + schName + "'";
				ResultSet rs1 = stmt.executeQuery(sql);
				if(rs1.next())
					schId = rs1.getInt("schId");
			}
			if(majName != null && !"".equals(majName)) {//查询专业id
				sql = "select majId from Major where majName = '" + majName + "'";
				ResultSet rs2 = stmt.executeQuery(sql);
				if(rs2.next())
					majId = rs2.getInt("majId");
			}
			sql = "select count(*) from Subject where subId in";
			whereSql = "(select subId from Subject where 1=1";	//wheresql语句查询的是课程id的结果集
			if(schId != 0)
				whereSql += " and schId =" + schId + "";
			if(majId != 0)
				whereSql += " and majId = " + majId + "";
			if(subName != null && !"".equals(subName))
				whereSql += " and subName like '%" + subName+"%'";
			whereSql += ")";
			
			// 先计算总记录数
			System.out.println("count* sql:" + sql + whereSql);
			ResultSet rs = stmt.executeQuery(sql + whereSql);
			int totalCount = 0;//记载查询到的信息的总条数，用于分页
			if (rs.next())  {
				totalCount = rs.getInt(1);
			}
			rs.close();
			pager.setTotalRecord(totalCount);
			
			sql = "select * from Subject where subId in (select top " + pager.getCurPage() * pager.getPageSize()  
					+ " subId from Subject where subId in "+ whereSql + ") and subId not in(";//显示当前页数的信息
			sql += "   select top " + (pager.getCurPage()-1) * pager.getPageSize()
					+ "   subId from Subject where subId in "+ whereSql + ")";
			System.out.println("sql333:"+sql);
			rs = stmt.executeQuery(sql);
			ResultSet rs1, rs2;
			while (rs.next()) {
				SubBean bean = new SubBean();
				bean.setSubId(rs.getInt("subId"));
				bean.setSubName(rs.getString("subName"));
				
				sql1 = "select schName from School where schId = " + rs.getInt("schId");
				rs1 = stmt1.executeQuery(sql1);
				if(rs1.next())
				bean.setSchName(rs1.getString("schName"));
				
				sql2 = "select majName from Major where majId = " + rs.getInt("majId");
				rs2 = stmt1.executeQuery(sql2);
				if(rs2.next())
				bean.setMajName(rs2.getString("majName"));
				list.add(bean);
			}
			rs.close();
			stmt.close();
		}
		DBUtil.freeConnection(conn);
		return list;
	}
	/*
	 * 添加学校
	 */
	public int schAdd(SchBean bean) throws SQLException {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		
		if(conn != null) {
			String sql = "insert into School(schId,schName)values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSchId());
			pstmt.setString(2, bean.getSchName());
			result = pstmt.executeUpdate();
			pstmt.close();
		}else
			result = -1;
		DBUtil.freeConnection(conn);
		return result;
	}
	/*
	 * 添加专业
	 */
	public int majAdd(MajBean bean) throws SQLException {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		
		if(conn != null) {
			String sql = "insert into Major(majId,majName)values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getMajId());
			pstmt.setString(2, bean.getMajName());
			result = pstmt.executeUpdate();
			pstmt.close();
		}else
			result = -1;
		DBUtil.freeConnection(conn);
		return result;
	}
	/*
	 * 添加课程
	 */
	public int subAdd(SubBean bean) throws SQLException {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		int schId = 0,majId = 0;
		
		String sql1 = "select schId from School where schName = '" + bean.getSchName() + "'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql1);
		if(rs.next())
			schId = rs.getInt("schId");
		
		sql1 = "select majId from Major where majName = '" + bean.getMajName() + "'";
		rs = stmt.executeQuery(sql1);
		if(rs.next())
			majId = rs.getInt("majId");
		rs.close();
		stmt.close();
		
		if(conn != null) {
			String sql = "insert into Subject(subId, subName, schId, majId)values(?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getSubId());
			pstmt.setString(2, bean.getSubName());
			pstmt.setInt(3, schId);
			pstmt.setInt(4, majId);
			result = pstmt.executeUpdate();
			pstmt.close();
		}else
			result = -1;
		DBUtil.freeConnection(conn);
		return result;
	}
	/*
	 * 根据学校id删除学校信息
	 */
	public int deleteSch(int schId) throws SQLException {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		if(conn != null) {
			String sql = "delete from School where schId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, schId);
			result = pstmt.executeUpdate();
			pstmt.close();
		}else {
			result = -1;
		}
		DBUtil.freeConnection(conn);
		return result;
	}
	/*
	 * 根据学校id删除学校信息
	 */
	public int deleteMaj(int majId) throws SQLException {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		if(conn != null) {
			String sql = "delete from Major where majId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, majId);
			result = pstmt.executeUpdate();
			pstmt.close();
		}else {
			result = -1;
		}
		DBUtil.freeConnection(conn);
		return result;
	}
	/*
	 * 根据课程id删除课程信息
	 */
	public int deleteSub(int subId) throws SQLException {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		if(conn != null) {
			String sql = "delete from Subject where subId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subId);
			result = pstmt.executeUpdate();
			pstmt.close();
		}else {
			result = -1;
		}
		DBUtil.freeConnection(conn);
		return result;
	}

}
