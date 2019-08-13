package bean;

import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentSecDao {
    public List<CommentSecBean> listCommentSec(String cId) throws SQLException {
        List<CommentSecBean> list = new ArrayList<CommentSecBean>();
        Connection conn = DBUtil.getConnection();
        if (conn != null) {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql="select * from CommentNext where 1=1 ";

            if (cId != null && !"".equals(cId))
                sql += " and cId ='" + cId + "'";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CommentSecBean bean = new CommentSecBean();
                bean.setcId(rs.getInt("cId"));
                bean.setUserId(rs.getInt("userId"));
                bean.setContentNext(rs.getString("contentNext"));
                list.add(bean);
            }
            rs.close();
            stmt.close();
        }

        DBUtil.freeConnection(conn);
        return list;
    }

    public int addCommentSecBean(CommentSecBean bean) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            String sql = "insert into CommentNext(cId, userId, contentNext) values (?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getcId());
            pstmt.setInt(2, bean.getUserId());
            pstmt.setString(3, bean.getContentNext());

            result = pstmt.executeUpdate();
//            System.out.println("result:" + result);
//            System.out.print(111);
        } else {
            result = -1;
        }
        DBUtil.freeConnection(conn);
        return result;
    }

    public int delete(String ucId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            String sql = "delete from CommentNext where ucId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(ucId));
            result = pstmt.executeUpdate();
        } else {
            result = -1;
        }
        DBUtil.freeConnection(conn);
        return result;
    }
}
