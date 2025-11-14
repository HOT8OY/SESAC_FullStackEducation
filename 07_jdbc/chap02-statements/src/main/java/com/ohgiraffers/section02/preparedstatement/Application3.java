package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application3 {
    public static void main(String[] args) {
        /* EMPLOYEE 테이블에서 조회할 사원의 성씨를 입력 받아 해당 성씨를 가진 사원 정보들을 모두 출력 */

        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        /* 한 행의 정보를 담을 DTO */
        EmployeeDTO row = null;

        /* 여러 DTO 타입의 객체를 담을 List */
        List<EmployeeDTO> empList = null;

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 사원의 성을 입력하세요 : ");
        String empName = sc.nextLine();

        // 쿼리의 틀 만들기
        String query = "SELECT * FROM EMPLOYEE WHERE EMP_NAME LIKE CONCAT(?, '%')"; // CONCAT 안의 내용들은 합치기 가능. 그냥 ?% 이런식으로 쓰는건 불가.

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empName);

            System.out.println(pstmt);  // 의도한대로 쿼리문이 잘 만들어졌는지 확인.

            rset = pstmt.executeQuery();

            empList = new ArrayList<>();

            while (rset.next()) {
                // 각 행의 데이터를 담을 빈 EmployeeDTO
                row = new EmployeeDTO();
                // ResultSet에서 컬럼 값의 꺼내 DTO 각 필드에 채워넣는다
                row.setEmpId(rset.getString("EMP_ID"));
                row.setEmpName(rset.getString("EMP_NAME"));
                row.setEmpNo(rset.getString("EMP_NO"));
                row.setPhone(rset.getString("PHONE"));
                row.setDeptCode(rset.getString("DEPT_CODE"));
                row.setJobCode(rset.getString("JOB_CODE"));
                row.setSalLevel(rset.getString("SAL_LEVEL"));
                row.setSalary(rset.getInt("SALARY"));
                row.setBonus(rset.getDouble("BONUS"));
                row.setManagerId(rset.getString("MANAGER_ID"));
                row.setHireDate(rset.getDate("HIRE_DATE"));
                row.setEntDate(rset.getDate("ENT_DATE"));
                row.setEntYn(rset.getString("ENT_YN"));

                // 정보가 채워진 DTO를 List에 추가
                empList.add(row);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }

        for(EmployeeDTO emp : empList) {    // empList에 내용이 잘 담겼는지 확인
            System.out.println(emp);
        }
    }
}
