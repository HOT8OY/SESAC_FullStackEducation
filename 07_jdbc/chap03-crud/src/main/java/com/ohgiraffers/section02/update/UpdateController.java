package com.ohgiraffers.section02.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class UpdateController {

    public int updateMenu(MenuDTO changedMenu) {
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        int result = 0;

        Properties prop = new Properties();

        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));

            String query = prop.getProperty("updateMenu");

            pstmt = con.prepareStatement(query);
            // 사용자가 입력하여 MenuDTO에 setting 되어 있던 값을 getter를 이용하여 꺼내서 위치홀더 값에 적용
            pstmt.setString(1, changedMenu.getMenuName());
            pstmt.setInt(2, changedMenu.getMenuPrice());
            pstmt.setInt(3, changedMenu.getMenuCode());

            result = pstmt.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
            close(con);
        }
        return result;
    }
}
