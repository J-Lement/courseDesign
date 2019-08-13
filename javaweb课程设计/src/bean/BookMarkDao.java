package bean;

import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookMarkDao {
        public List<BookMarkBean> loadBookMark(String userId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//        FocusBean bean = new FocusBean();

            List<BookMarkBean> list = new ArrayList<BookMarkBean>();
//        BookBean BKbean = new BookBean();
            Connection conn = DBUtil.getConnection();

//        System.out.print(userId);

//            for (FocusBean bean:FBlist
//            ) {
                if (conn != null) {
                    String sql = "select * from BookMark where userId = ?";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, Integer.parseInt(userId));
                    ResultSet rs = pstmt.executeQuery();

//                System.out.println(bean.getSubId());

//                System.out.print(sql);

                    while (rs.next()) {
                        BookMarkBean BMbean = new BookMarkBean();
                        BMbean.setBookId(rs.getInt("bookId"));
                        BMbean.setReading(rs.getString("reading"));
                        BMbean.setrTime(rs.getString("rTime"));
                        list.add(BMbean);
                    }
                }


//            sql = "select * from Subject where subId = ?";
//            PreparedStatement rpstmt = conn.prepareStatement(sql);
//            rpstmt.setInt(1, bean.getSubId());
//            ResultSet rrs = rpstmt.executeQuery();
//
//            System.out.print(sql);
//
//            while(rrs.next()) {
//                SJbean.setSubId(rrs.getInt("subId"));
//                SJbean.setSubName(rrs.getString("subName"));
//                list.add(SJbean);
//            }
//            }

            return list;
        }

    public int delete(String userId,String bookId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            String sql = "delete from BookMark  where bookId = ? and userId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(bookId));
            pstmt.setInt(2,Integer.parseInt(userId));
            result = pstmt.executeUpdate();
        } else {
            result = -1;
        }
        DBUtil.freeConnection(conn);
        return result;
    }

        public int updateBookMark(BookMarkBean bean) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            String sql = "update Collection set rTime = ? where userId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getrTime());
            pstmt.setInt(2, bean.getUserId());
//            int result = pstmt.executeUpdate();
//            System.out.println("result:" + result);
        } else {
            result = -1;
        }
        DBUtil.freeConnection(conn);
        return result;
    }

    public int addBookMark(BookMarkBean bean) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            String sql = "insert into BookMark(userId, bookId, reading, rTime) values (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getUserId());
            pstmt.setInt(2, bean.getBookId());
            pstmt.setString(3, bean.getReading());
            pstmt.setString(4,bean.getrTime());

            result = pstmt.executeUpdate();
            //System.out.println("result:" + result);
//            System.out.print(sql);
        } else {
            result = -1;
        }
        DBUtil.freeConnection(conn);
        return result;
    }

    public int conuntBookMark(String userId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        int totalCount = 0;

        if (conn != null){
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql="select count(*) from BookMark Where 1=1";
            if (userId != null && !"".equals(userId))
                sql += " and userId ='" + userId + "'";

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next())  {
                totalCount = rs.getInt(1);
            }
            rs.close();
        }

        return totalCount;
    }
}
