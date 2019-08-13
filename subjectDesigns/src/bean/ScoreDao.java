package bean;

import util.DBUtil;

import java.sql.*;

public class ScoreDao {
    public int addScore(ScoreBean bean) throws SQLException,InstantiationException, IllegalAccessException, ClassNotFoundException{
        int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            String sql = "insert into Score(bookId, userId, ifScore, score) values (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getBookId());
            pstmt.setInt(2, bean.getUserId());
            pstmt.setInt(3, bean.getIfScore());
            pstmt.setFloat(4,bean.getIfScore());

            result = pstmt.executeUpdate();
            //System.out.println("result:" + result);
//            System.out.print(sql);

        } else {
            result = -1;
        }
        DBUtil.freeConnection(conn);
        return result;
    }

}
