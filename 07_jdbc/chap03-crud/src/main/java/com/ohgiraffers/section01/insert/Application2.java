package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        /* 1. 메뉴의 이름, 가격, 카테고리 코드, 판매 여부를 입력 받기(Scanner 이용) */
        Scanner sc = new Scanner(System.in);
        MenuDTO menu = new MenuDTO();
        System.out.print("추가할 메뉴 이름을 입력하세요 : ");
        String menuName = sc.nextLine();
        menu.setMenuName(menuName);
        System.out.print("추가할 메뉴 가격을 입력하세요 : ");
        int menuPrice = sc.nextInt();
        menu.setMenuPrice(menuPrice);
        System.out.print("추가할 메뉴 카테고리 코드를 입력하세요 : ");
        int categoryCode = sc.nextInt();
        menu.setCategoryCode(categoryCode);
        sc.nextLine(); // 버퍼제거
        System.out.print("추가할 메뉴 판매 여부(Y/N)를 입력하세요 : ");
        String orderable_status = sc.nextLine();
        menu.setOrderableStatus(orderable_status);
        /* 2. MenuDTO 객체를 생성하여 입력받은 값으로 setting */

        /* 3. InsertController의 insertMenu() 메소드 호출 */
        InsertController insertM = new InsertController();
        int result = insertM.insertMenu(menu);

        /* 4. insert 결과에 따라 성공이면 '메뉴 등록 성공!' 출력, 실패이면 '메뉴 등록 실패' 출력  */
        if (result > 0) {
            System.out.println("메뉴 등록 성공!");
        } else {
            System.out.println("메뉴 등록 실패!");
        }

    }
}
