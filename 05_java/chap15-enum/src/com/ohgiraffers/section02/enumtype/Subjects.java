package com.ohgiraffers.section02.enumtype;

public enum Subjects {
    // 내부에 상수들을 ','로 구분하여 넣어두면 내부적인 순서가 자동으로 구현이 된다.
    // 작성한 순서대로 0부터 값이 자동 부여 된다.
    // 각 값들은 싱글톤으로 관리가 된다.
    // 각 값들은 객체로 관리되기에 상태나 행위를 가질 수 있음.
    JAVA,
    MYSQL,
    JDBC,
    HTML,
    CSS,
    JAVASCRIPT
}
