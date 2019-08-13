package bean;

import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CommentFirstDao {
	
	public int addIll(String str) throws SQLException {
		int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            String sql = "insert into Illegal(illText) values (?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, str);

            result = pstmt.executeUpdate();
//            System.out.println("result:" + result);
//            System.out.print(111);
        } else {
            result = -1;
        }
        DBUtil.freeConnection(conn);
        return result;
	}
//    public CommentFirstBean loadComment(String bookId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//        CommentFirstBean bean = new CommentFirstBean();
//        Connection conn = DBUtil.getConnection();
//
//        if (conn != null) {
//            String sql = "select * from Comment where bookId = ?";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, Integer.parseInt(bookId));
//            ResultSet rs = pstmt.executeQuery();
//
////            System.out.print(sql);
//
//            if (rs.next()) {
//                bean.setuserId(rs.getInt("userId"));
//                bean.setContent(rs.getString("content"));
//                bean.setBookId(rs.getInt("bookId"));
//            }
//        }
//
//        return bean;
//    }



    public int delete(String cId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            String sql = "delete from Comment where cId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(cId));
            result = pstmt.executeUpdate();
        } else {
            result = -1;
        }
        DBUtil.freeConnection(conn);
        return result;
    }

    public List<CommentFirstBean> listFile(String bookId) throws SQLException {
        List<CommentFirstBean> list = new ArrayList<CommentFirstBean>();
        Connection conn = DBUtil.getConnection();
        if (conn != null) {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql="select * from Comment where 1=1 ";

            if (bookId != null && !"".equals(bookId))
                sql += " and bookId ='" + bookId + "'";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CommentFirstBean bean = new CommentFirstBean();
                bean.setCld(rs.getInt("cId"));
                bean.setuserId(rs.getInt("userId"));
                bean.setContent(rs.getString("content"));
                bean.setBookId(rs.getInt("bookId"));
                list.add(bean);
            }
            rs.close();
            stmt.close();
        }

        DBUtil.freeConnection(conn);
        return list;
    }

    public int addComment(CommentFirstBean bean) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            String sql = "insert into Comment(userId, bookId, content) values (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getuserId());
            pstmt.setInt(2, bean.getBookId());
            pstmt.setString(3, bean.getContent());

            result = pstmt.executeUpdate();
//            System.out.println("result:" + result);
//            System.out.print(111);
        } else {
            result = -1;
        }
        DBUtil.freeConnection(conn);
        return result;
    }
}
