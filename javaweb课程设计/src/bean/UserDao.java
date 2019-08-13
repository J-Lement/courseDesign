package bean;

import java.beans.Statement;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.DBUtil;
import util.Pager;

public class UserDao {
	/*
	 * 从数据库中取出userId的信息
	 */
	public UserBean checkUser(String id,String password,String userType) throws SQLException {
		Connection conn = DBUtil.getConnection();
		UserBean uBean = new UserBean();
		if(conn != null) {
			String sql = "select * from allUser where userId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(id));
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				uBean.setUserId(rs.getInt("userId"));
				uBean.setUserName(rs.getString("userName"));
				uBean.setPassword(rs.getString("password"));
				uBean.setUserType(rs.getString("userType"));
			}
			rs.close();
			pstmt.close();
			
		}
		DBUtil.freeConnection(conn);
		if(uBean.getUserId() == 0)
			uBean = null;
		return uBean;
	}
	/*
	 * 加载用户数据
	 */
	public List<UserBean> listUser(String id, String userName, String userType, Pager pager) throws SQLException{
		List<UserBean> list = new ArrayList<UserBean>();
		Connection conn = DBUtil.getConnection();
		int userId=0;
		if(id != null && !"".equals(id))
			userId = Integer.parseInt(id);	
		
		if(conn != null) {
			java.sql.Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "select * from allUser";
			String whereSql = " where 1=1 ";
			if(userId != 0)
				whereSql += " and userId =" + userId;
			if(userName != null && !"".equals(userName))
				whereSql += " and username like '%" +userName +"%'";
			if(userType != null && !"".equals(userType))
				whereSql += " and userType like '%" + userType +"%'";
			System.out.println("userSQL111:"+sql+whereSql);
			ResultSet rs = stmt.executeQuery(sql + whereSql);//设置分页所需的数据总条数
			int totalCount = 0;

			rs.last();
			totalCount = rs.getRow();
			
			rs.close();
			System.out.println("totalcount:"+totalCount);
			pager.setTotalRecord(totalCount);
			
			sql = "select * from allUser where userId in(select top " + pager.getCurPage()*pager.getPageSize() + " userId from allUser "+ whereSql +")"
					+ " and userId not in(select top " + (pager.getCurPage()-1)*pager.getPageSize() + " userId from allUser " +whereSql+")";
			System.out.println("userSQL:"+sql);
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				UserBean bean = new UserBean();
				bean.setUserId(rs.getInt("userId"));
				bean.setUserName(rs.getString("userName"));
				bean.setPassword(rs.getString("password"));
				bean.setUserType(rs.getString("userType"));
				list.add(bean);
			}
			rs.close();
			stmt.close();
		}
		DBUtil.freeConnection(conn);
		return list;
	}
	
	/*
	 * 添加用户
	 */
	public int userAdd(UserBean bean) throws SQLException {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		
		if(conn != null) {
			String sql = "insert into allUser(userId , userName , password , userType)values(?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getUserId());
			pstmt.setString(2, bean.getUserName());
			pstmt.setString(3, bean.getPassword());
			pstmt.setString(4, bean.getUserType());
			result = pstmt.executeUpdate();
		}else
			result = -1;
		DBUtil.freeConnection(conn);
		return result;
	}
	/*
	 * 根据用户id从数据库中获取用户信息，用于显示用户修改界面数据
	 */
	public UserBean loadUserEdit(int userId) throws SQLException {
		UserBean bean = new UserBean();
		Connection conn = DBUtil.getConnection();
		
		if(conn != null) {
			String sql = "select * from allUser where userId = ?";
			PreparedStatement pstmt  = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setUserId(rs.getInt("userId"));
				bean.setUserName(rs.getString("userName"));
				bean.setPassword(rs.getString("password"));
				bean.setUserType(rs.getString("userType"));
			}
			rs.close();
			pstmt.close();
		}
		DBUtil.freeConnection(conn);
		return bean;
	}
	/*
	 * 更新数据库中的用户信息
	 */
	public int updateUser(UserBean bean) throws SQLException {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		if(conn != null) {
			String sql = "update allUser set userName = ?, password = ?, userType = ? where userId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getUserName());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getUserType());
			pstmt.setInt(4, bean.getUserId());
			result = pstmt.executeUpdate();
			pstmt.close();
		}else
			result = -1;
		DBUtil.freeConnection(conn);
		return result;
	}
	/*
	 * 删除用户
	 */
	public int deleteUser(int userId) throws SQLException {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		if(conn != null) {
			String sql = "delete from allUser where userId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userId);
			result = pstmt.executeUpdate();
			pstmt.close();
		}else {
			result = -1;
		}
		DBUtil.freeConnection(conn);
		return result;
	}

	/*
	* 修改密码
	* */
	public int newPassword(String userId,String old_Password,String new_password,String check_password) throws SQLException {
		int result = 0;
		Connection conn = DBUtil.getConnection();
		UserBean bean = new UserBean();

		if(conn != null) {
			String sql = "select * from allUser where userId = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(userId));
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()){
				bean.setPassword(rs.getString("password"));
			}
			rs.close();
			pstmt.close();


//			System.out.println("password=" + new_password);

			if(old_Password.equals(bean.getPassword()) && new_password.equals(check_password) && bean.getPassword()!= null){
				bean.setPassword(new_password);
				sql = "update allUser set password = ? where userId = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1,bean.getPassword());
				stmt.setInt(2,Integer.parseInt(userId));
				result = stmt.executeUpdate();
			    stmt.close();
			}else{
				result = -1;
				DBUtil.freeConnection(conn);
				return result;
			}
		}else
			result = -1;
		DBUtil.freeConnection(conn);
		return result;
	}
}
