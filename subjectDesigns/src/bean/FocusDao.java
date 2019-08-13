package bean;

        import util.DBUtil;
        import util.Pager;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.List;

public class FocusDao {
    public List<SubjectBean> loadFocus(List<FocusBean> FBlist, Pager pager) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//        FocusBean bean = new FocusBean();

        List<SubjectBean> list = new ArrayList<SubjectBean>();
//        BookBean BKbean = new BookBean();
        Connection conn = DBUtil.getConnection();

        int totalCount = 0;
        for (FocusBean bean:FBlist
        ) {
            totalCount++;
        }
        pager.setTotalRecord(totalCount);

        for (FocusBean bean:FBlist
        ) {
            if (conn != null) {
                String sql = "select * from Subject where subId = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, bean.getSubId());
                ResultSet rs = pstmt.executeQuery();

//                System.out.println(bean.getSubId());

//                System.out.print(sql);

                if (rs.next()) {
                    SubjectBean SJbean = new SubjectBean();
                    SJbean.setSubId(rs.getInt("subId"));
                    SJbean.setSubName(rs.getString("subName"));
                    list.add(SJbean);
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
        }

        return list;
    }

    public int conuntFocus(String userId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        int totalCount = 0;

        if (conn != null){
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql="select count(*) from Focus Where 1=1";
            if (userId != null && !"".equals(userId))
                sql += " and userId ='" + userId + "'";

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next())  {
                totalCount = rs.getInt(1);
            }
            System.out.println(totalCount);
            rs.close();
        }

        return totalCount;
    }


}


