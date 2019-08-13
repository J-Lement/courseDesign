package bean;

import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReferenceDao {
    public int avgScore(ScoreBean bean) throws SQLException,InstantiationException, IllegalAccessException, ClassNotFoundException{
        int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
//            String sql = "select count(*) from Reference";
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql="select * from Score where 1=1 ";

            if (bean.getBookId() != 0)
                sql += " and bookId ='" + bean.getBookId() + "'";

            float score = 0;
            int i = 0;
            float avgScore;
            ResultSet rrs = stmt.executeQuery(sql);
            while (rrs.next()) {
                score += rrs.getFloat("score");
                i++;
            }
            avgScore = score/i;

            String nextSql = "update Reference set avgScore = ? where userId = ?";
            PreparedStatement pstmt = conn.prepareStatement(nextSql);
            pstmt.setFloat(1,avgScore);
            pstmt.setInt(2,bean.getUserId());


            rrs.close();
            stmt.close();


            result = pstmt.executeUpdate();
            //System.out.println("result:" + result);
//            System.out.print(sql);
        } else {
            result = -1;
        }
        DBUtil.freeConnection(conn);
        return result;
    }

    public List<ReferenceBean> countRecommend() throws SQLException,InstantiationException, IllegalAccessException, ClassNotFoundException {
        int result = 0;
        Connection conn = DBUtil.getConnection();
        List<ReferenceBean> list = new ArrayList<>();
        ResultSet rs;

        if(conn != null){
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql="select * from Reference where 1=1 ";

            rs = stmt.executeQuery(sql);

            while(rs.next()){
                ReferenceBean bean = new ReferenceBean();
                bean.setSubId(rs.getInt("subId"));
                bean.setBookId(rs.getInt("bookId"));
                bean.setNumOfCol(rs.getInt("numOfCol"));
                bean.setNumOfBro(rs.getInt("numOfBro"));
                bean.setAvgScore(rs.getFloat("avgScore"));
//                bean.setRecommend(rs.getFloat("Recommend"));
                bean.setRecommend(bean.getNumOfCol()*35 + bean.getNumOfBro()*15 + bean.getAvgScore()*50) ;
                list.add(bean);
            }
        }

        return list;
    }

        public int updateRecommend(List<ReferenceBean> list) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        int result = 0;
        Connection conn = DBUtil.getConnection();

        if (conn != null) {
            for (ReferenceBean bean:list
                 ) {
                String sql = "update Reference set Recommend = ? where bookId = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setFloat(1, bean.getRecommend());
                pstmt.setInt(2, bean.getBookId());
                int i = pstmt.executeUpdate();

            }


//            pstmt.setInt(4, bean.getIs_top());
//            pstmt.setInt(5, bean.getRead_count());
//            pstmt.setString(6, bean.getSource());
//            pstmt.setInt(7, bean.getId());
//            int result = pstmt.executeUpdate();
//            System.out.println("result:" + result);
        } else {
            result = -1;
        }
        DBUtil.freeConnection(conn);
        return result;
    }

    public List<BookBean> SortRecommend(List<SubjectBean> SJlist) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        List<BookBean> list = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        ResultSet rs;

        if(conn != null){
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "(select top 5 bookId from Reference where 1 = 1 ";
            String sortsql = "";
            if(SJlist != null) {
                for (SubjectBean bean : SJlist
                ) {
                    if ("".equals(sortsql)) {
                        sortsql += "and subId = '" + bean.getSubId() + "'";
                    } else {
                        sortsql += " or subId = '" + bean.getSubId() + "'";
                    }
                }
                sortsql += " order by Recommend desc )";
                sql += sortsql;
                String wheresql = "select * from book where bookId in ";
                rs = stmt.executeQuery(wheresql + sql);
//                System.out.println("SQL = "+sql);
            }else{
                sql += " order by Recommend desc )";
                String wheresql = "select * from book where bookId in ";
                rs = stmt.executeQuery(wheresql + sql);
                System.out.println("SQL = "+ wheresql + sql);
            }



            while(rs.next()){
                BookBean bean = new BookBean();
                bean.setBookId(rs.getInt("bookId"));
                bean.setBookName(rs.getString("bookName"));
                bean.setBookAuthor(rs.getString("bookAuthor"));
                bean.setBookInfo(rs.getString("bookInfo"));
                bean.setBookSub(rs.getString("bookSub"));
                bean.setBookAttach(rs.getString("bookAttach"));
                list.add(bean);
            }

        }

        DBUtil.freeConnection(conn);
        return list;
    }

    /*
    更新推荐表中的点击量
     */
    public void AddNumofBro(String bookId) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Connection conn = DBUtil.getConnection();
        int numOfBro = 0;

        if(conn != null){
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql="select numOfBro from Reference where 1=1 ";

            if (bookId != null && !"".equals(bookId))
                sql += " and bookId ='" + bookId + "'";

            ResultSet rrs = stmt.executeQuery(sql);

            if(rrs.next()){
                numOfBro = rrs.getInt("numOfBro");
            }
            numOfBro++;

            String nextSql = "update Reference set numOfBro = ? where bookId = ?";
            PreparedStatement pstmt = conn.prepareStatement(nextSql);
            pstmt.setFloat(1,numOfBro);
            pstmt.setInt(2,Integer.parseInt(bookId));
            int result = pstmt.executeUpdate();

            rrs.close();
            stmt.close();
            DBUtil.freeConnection(conn);
        }
    }
}
