package bean;

import org.omg.CORBA.TypeCodePackage.BadKind;
import util.DBUtil;
import util.Pager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {

    public List<FocusBean> loadSubject(String userId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {

//        SubjectBean SJbean = new SubjectBean();
        List<FocusBean> list = new ArrayList<FocusBean>();
//        BookBean BKbean = new BookBean();
        Connection conn = DBUtil.getConnection();

//        System.out.print(userId);

        if (conn != null) {

//            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "select * from Focus where 1=1 ";

            if (userId != null && !"".equals(userId))
                sql += " and userId ='" + userId + "'";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();



            while(rs.next()) {
                FocusBean bean = new FocusBean();
                bean.setUserId(rs.getInt("userId"));
                bean.setSubId(rs.getInt("subId"));
                bean.setIfFoc(rs.getInt("ifFoc"));
                list.add(bean);
            }

//            for (FocusBean Fbean:list
//                 ) {
//                System.out.print(Fbean.getSubId());
//                System.out.println(Fbean.getUserId());
//            }

            rs.close();
            pstmt.close();
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
////            pstmt.setString(3, bean.getTime());
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

    public int delete(String subId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            String sql = "delete from Focus  where subId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(subId));
            result = pstmt.executeUpdate();
        } else {
            result = -1;
        }
        DBUtil.freeConnection(conn);
        return result;
    }

    public List<SubjectBean> listSubject(int userId) throws SQLException {
        List<SubjectBean> list = new ArrayList<SubjectBean>();
        FocusBean bean = new FocusBean();
        Connection conn = DBUtil.getConnection();
        if (conn != null) {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql="select * from Subject where 1=1 ";

            if (userId != 0)
                sql += " and userId ='" + userId + "'";


            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                bean.setUserId(rs.getInt("userId"));
                bean.setSubId(rs.getInt("subId"));
                bean.setIfFoc(rs.getInt("ifFoc"));
            }
            rs.close();
            stmt.close();

            SubjectBean SJbean = new SubjectBean();
            sql = "select * from Subject where subId = ?";
            PreparedStatement rpstmt = conn.prepareStatement(sql);
            rpstmt.setInt(1, bean.getSubId());
            ResultSet rrs = rpstmt.executeQuery();

            System.out.print(sql);

            while(rrs.next()) {
                SJbean.setSchId(rrs.getInt("schId"));
                SJbean.setMajId(rrs.getInt("majId"));
                SJbean.setSubId(rrs.getInt("subId"));
                SJbean.setSubName(rrs.getString("subName"));
                list.add(SJbean);
            }
            System.out.print(SJbean.getSubName());
        }


        DBUtil.freeConnection(conn);
        return list;
    }


    public List<SubjectBean> listSubject(String userId, Pager pager) throws SQLException
    {
        List<SubjectBean> list = new ArrayList<SubjectBean>();
        Connection conn = DBUtil.getConnection();
        if (conn != null) {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql="select count(*) from Subject";
            String whereSql = " where 1=1 ";
            if (userId != null && !"".equals(userId))
                whereSql += " and userId ='" + userId + "'";

            // 先计算总记录数
            ResultSet rs = stmt.executeQuery(sql + whereSql);
            int totalCount = 0;
            if (rs.next())  {
                totalCount = rs.getInt(1);
            }
            rs.close();
            pager.setTotalRecord(totalCount);

            sql = "select * from Subject where subId in (select top " + pager.getCurPage() * pager.getPageSize()
                    + " subId from Subject " + whereSql
                    + ") and subId not in (";
            sql += "   select top " + (pager.getCurPage()-1) * pager.getPageSize()
                    + "   subId from Subject " + whereSql;
            sql += ")";
            //           System.out.println(sql);
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SubjectBean bean = new SubjectBean();
                bean.setSchId(rs.getInt("schId"));
                bean.setMajId(rs.getInt("majId"));
                bean.setSubId(rs.getInt("subId"));
                bean.setSubName(rs.getString("subName"));
                list.add(bean);
            }
            rs.close();
            stmt.close();
        }
        return list;
    }

    public int addSubject(FocusBean bean) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            String sql = "insert into Focus(userId, subId, ifFoc) values (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getUserId());
            pstmt.setInt(2, bean.getSubId());
            pstmt.setInt(3, bean.getIfFoc());

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