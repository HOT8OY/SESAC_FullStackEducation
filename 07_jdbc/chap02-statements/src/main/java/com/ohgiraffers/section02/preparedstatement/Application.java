package com.ohgiraffers.section02.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {
        /* PreparedStatement는 SQL 쿼리의 형태(구조)를 먼저 DB에 전송하여 준비(Prepare)시키고, 나중에 데이터(값)만 따로 전송하여 실행(Execute)하는 객체다. */
        // 데이터와 분리: setXXX()로 전달되는 데이터는 절대로 SQL 코드로 인식되지 않는다.
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            /* PrepareStatement 객체 생성 시 수행할 sql 구문을 인자로 전달하며 생성 */
            pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");

            // 차이점은 위에서 이미 pstmt를 만들었기 때문에 Query를 따로 전달하지 않는다.
            rset = pstmt.executeQuery();

            while(rset.next()) {
                System.out.println(rset.getString("EMP_ID") + ", " +rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
