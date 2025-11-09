package com.greedy.level02.normal.book.run;

import com.greedy.level02.normal.book.model.dto.BookDTO;

public class Application {
    public static void main(String[] args) {
        System.out.println("======= 기본 생성자 호출 =======");
        BookDTO dto = new BookDTO();
        dto.printInformation();
        System.out.println("======= 3개 초기화 호출 =======");
        BookDTO dto1 = new BookDTO("자바의 정석", "도우출판", "남궁성");
        dto1.printInformation();
        System.out.println("======= 모든 필드 초기화 호출 =======");
        BookDTO dto2 = new BookDTO("홍길동전", "활빈당", "허균", 5000000, 0.5);
        dto2.printInformation();
    }

}
