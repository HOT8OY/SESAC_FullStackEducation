package com.ohgiraffers.section03.abstraction;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        /*
        [ 추상화 ]
        운전자 { 시동 ON, 엑셀, 브레이크, 핸들조작 } 만 알면 차를 운전할 수 있음. 차량 내부의 로직에 대해선 몰라도 됨.
        추상화란 사용자에게 내부의 것을 보이지 않게 하고, 필요한 부분만 노출 시키는 것.
        사용자 -> 운전자 -> 자동차 순으로 명령을 전달.
         */
        CarRacer racer = new CarRacer();
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("======= 카레이싱 프로그램 =======");
            System.out.println("1. 시동 걸기");
            System.out.println("2. 엑셀 밟기");
            System.out.println("3. 브레이크 밟기");
            System.out.println("4. 시동 끄기");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 선택 : ");
            int no = sc.nextInt();

            switch (no) {
                // 사용자는 카레이서에게 '요청' 한다.
                case 1:
                    racer.startUp();
                    break;
                case 2:
                    racer.stepAccelator();
                    break;
                case 3:
                    racer.stepBreak();
                    break;
                case 4:
                    racer.turnOff();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("잘못 된 번호를 선택하셨습니다.");
                    break;
            }
        }

    }
}
