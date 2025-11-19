package com.ohgiraffers.section03.delete;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        /* 삭제할 메뉴 코드 입력받기 */
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 메뉴 번호를 입력하세요 : ");
        int menuCode = sc.nextInt();

        DeleteController controller = new DeleteController();
        int result = controller.deleteMenu(menuCode);

        if(result >0) {
            System.out.println("메뉴 삭제 성공!");
        } else {
            System.out.println("메뉴 삭제 실패!");
        }
    }
}
