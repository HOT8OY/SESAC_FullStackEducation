package com.ohgiraffers.section01.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application2 {
    public static void main(String[] args) {

        Properties prop = new Properties();
        // finnaly 블록에서 사용하기 위한 Connection
        Connection con = null;

        try {
            // [ 외부 파일 이용 방식 ]
            // jdbc-config.properties 파일을 생성하여 안에 내용을 작성해 둘 것.
            // .properties 파일을 읽어서 prop 객체에 로드
            // xml 가져오기
            //설정-에디터-파일 및 코드 템플릿-XML Properties File - 코드 복사&붙여넣기
            //.loadFromXML
            prop.load(new FileReader("src/main/java/com/ohgiraffers/section01/connection/jdbc-config.properties"));

            System.out.println(prop);   // 값이 잘 들어가 있는지 확인

            // prop 객체의 key를 이용해 설정 값을 꺼낸다
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");

            // 변수에 담긴 설정 값으로 DB에 연결
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);

            System.out.println("con : " + con); // con : com.mysql.cj.jdbc.ConnectionImpl@3c9754d8

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(con != null) {
                try{
                    con.close();    // 끝나면 close할 것
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
