package bean;

import org.omg.CORBA.TypeCodePackage.BadKind;
import util.DBUtil;
import util.Pager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CollectDao {

    public List<CollectBean> loadCollect(int userId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

        BookBean BKbean = new BookBean();
        List<CollectBean> list = new ArrayList<CollectBean>();

        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            String sql = "select * from Collection where userId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            System.out.print(sql);

            while(rs.next()) {
                CollectBean bean = new CollectBean();
                bean.setUserId(rs.getInt("userId"));
                bean.setBookId(rs.getInt("bookId"));
                bean.setIfCol(rs.getInt("ifCol"));
                list.add(bean);
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

        return list;
    }



//    public int update(CollectBean bean) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//        int result = 0;
//        Connection conn = DBUtil.getConnection();
//
//        if (conn != null) {
//            String sql = "update Collection set title = ?, content = ?, create_time = ?, is_top = ?, read_count = ? ,source = ? where id = ?";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, bean.getTitle());
//            pstmt.setString(2, bean.getContent());
//            pstmt.setString(3, bean.getTime());
//            pstmt.setInt(4, bean.getIs_top());
//            pstmt.setInt(5, bean.getRead_count());
//            pstmt.setString(6, bean.getSource());
//            pstmt.setInt(7, bean.getId());
////            int result = pstmt.executeUpdate();
////            System.out.println("result:" + result);
//        } else {
//            result = -1;
//        }
//        DBUtil.freeConnection(conn);
//        return result;
//    }

    public int delete(String userId,String bookId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            String sql = "delete from Collection where userId = ? and bookId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,Integer.parseInt(userId));
            pstmt.setInt(2, Integer.parseInt(bookId));
            result = pstmt.executeUpdate();
        } else {
            result = -1;
        }
        DBUtil.freeConnection(conn);
        return result;
    }

    public List<BookBean> listCollect(int userId) throws SQLException {
        List<BookBean> list = new ArrayList<BookBean>();
        CollectBean bean = new CollectBean();
        Connection conn = DBUtil.getConnection();
        if (conn != null) {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql="select * from Collection where 1=1 ";

            if (userId != 0)
                sql += " and userId ='" + userId + "'";


            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                bean.setUserId(rs.getInt("userId"));
                bean.setBookId(rs.getInt("bookId"));
                bean.setIfCol(rs.getInt("ifCol"));
            }
            rs.close();
            stmt.close();

            BookBean BKbean = new BookBean();
            sql = "select * from Book where bookId = ?";
            PreparedStatement rpstmt = conn.prepareStatement(sql);
            rpstmt.setInt(1, bean.getBookId());
            ResultSet rrs = rpstmt.executeQuery();

            System.out.print(sql);

            while(rrs.next()) {
                BKbean.setBookId(rrs.getInt("bookId"));
                BKbean.setBookName(rrs.getString("bookName"));
                BKbean.setBookAuthor(rrs.getString("bookAuthor"));
                BKbean.setBookInfo(rrs.getString("bookInfo"));
                list.add(BKbean);
            }
            System.out.print(BKbean.getBookName());
        }


        DBUtil.freeConnection(conn);
        return list;
    }


//    public List<FileBean> listFile(String title, String source, Pager pager) throws SQLException
//    {
//        List<FileBean> list = new ArrayList<FileBean>();
//        Connection conn = DBUtil.getConnection();
//        if (conn != null) {
//            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//            String sql="select count(*) from TFile";
//            String whereSql = " where 1=1 ";
//            if (title != null && !"".equals(title))
//                whereSql += " and title ='" + title + "'";
//            if (source != null && !"".equals(source))
//                whereSql += " and source like '%" + source + "%'";
////
//            // 先计算总记录数
//            ResultSet rs = stmt.executeQuery(sql + whereSql);
//            int totalCount = 0;
//            if (rs.next())  {
//                totalCount = rs.getInt(1);
//            }
//            rs.close();
//            pager.setTotalRecord(totalCount);
//
//            sql = "select * from TFile where id in (select top " + pager.getCurPage() * pager.getPageSize()
//                    + " id from TFile " + whereSql
//                    + ") and id not in (";
//            sql += "   select top " + (pager.getCurPage()-1) * pager.getPageSize()
//                    + "   ID from TFile " + whereSql;
//            sql += ")";
//            //           System.out.println(sql);
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                FileBean bean = new FileBean();
//                bean.setId(rs.getInt("id"));
//                bean.setTitle(rs.getString("title"));
//                bean.setContent(rs.getString("content"));
//                bean.setCreate_time(rs.getDate("create_time"));
//                bean.setIs_top(rs.getInt("is_top"));
//                bean.setRead_count(rs.getInt("read_count"));
//                bean.setSource(rs.getString("source"));
//                bean.setAttach(rs.getString("attach"));
//                list.add(bean);
//            }
//            rs.close();
//            stmt.close();
//        }
//        return list;
//    }

    public int addCollect(CollectBean bean) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            String sql = "insert into Collection(userId, bookId, ifCol) values (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getUserId());
            pstmt.setInt(2, bean.getBookId());
            pstmt.setInt(3, bean.getIfCol());

            result = pstmt.executeUpdate();
            //System.out.println("result:" + result);
//            System.out.print(sql);
        } else {
            result = -1;
        }
        DBUtil.freeConnection(conn);
        return result;
    }

    public int conuntCollect(String userId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        int totalCount = 0;

        if (conn != null){
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql="select count(*) from Collection Where 1=1";
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