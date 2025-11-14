package com.ohgiraffers.section01.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {
        /* Statement */
        /* Statement는 JDBC API의 핵심 인터페이스 중 하나로,
         데이터베이스에 SQL 명령(구문)을 전달하고 실행시키는 역할 */

        // Connection 열기
        Connection con = getConnection();

        // 쿼리를 운반하고 결과를 반환하는 객체
        Statement stmt = null;
        // select 결과집합을 받아 올 인터페이스
        ResultSet rset = null;
        try {
            // stmt에 객체를 받아 넣음
            stmt = con.createStatement();
            // executeQuery :
            rset = stmt.executeQuery("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE");

            while(rset.next()) {
                /* .next() : ResultSet 커서 위치를 내리면서 다음 행이 존재하면 true, 존재하지 않으면 false 반환
                * getXXX(컬럼명) : 커서가 가리키는 행의 컬럼을 XXX 데이터 타입으로 반환한다. */
                System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // close순서는 가장 마지막에 열었던 것 부터 닫는다.
            close(rset);
            close(stmt);
            close(con);
        }
    }
}
