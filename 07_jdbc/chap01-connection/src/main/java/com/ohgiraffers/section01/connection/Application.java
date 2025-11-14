package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
        // [ 하드코딩 방식 ]
        /* finally 블럭에서 사용하기 위해 try 블럭 밖에 선언 */
        Connection con = null;
        /* 라이브러리에 있는 클래스를 활용하여 드라이버를 로드하고
        * 어떤 드라이버를 사용할지 인식시킨다*/
        // Class.forName("com.mysql.cj.jdbc.Driver");에 try catch사용
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            /* getConnection 스태틱 메소드를 이용해서 Connection(통로) 생성 */
            con = DriverManager.getConnection("jdbc:mysql://localhost/employeedb","ohgiraffers", "ohgiraffers");
            System.out.println("con : " + con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
