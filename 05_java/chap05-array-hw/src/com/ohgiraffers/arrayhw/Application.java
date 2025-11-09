package com.ohgiraffers.arrayhw;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Application app = new Application();
        app.oddUpDown();
        app.baseball();
    }
    /* 홀수인 양의 정수를 입력 받아 입력 받은 크기 만큼의 정수형 배열을 할당하고
     * 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
     * 중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값 넣어 출력하세요
     *
     * 단, 홀수인 양의 정수를 입력하지 않은 경우에는 "양수 혹은 홀수만 입력해야 합니다."를 출력하세요
     *
     * -- 입력 예시 --
     * 홀수인 양의 정수를 입력하세요 : 7
     *
     * -- 출력 예시 --
     * 1 2 3 4 3 2 1
     *
     * -- 입력 예시 --
     * 홀수인 양의 정수를 입력하세요 : 8
     *
     * -- 출력 예시 --
     * 양수 혹은 홀수만 입력해야 합니다.
     */
    public void oddUpDown () {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=======Q. 1=======");
        int oddNum = 0;
        while(true) {
            System.out.print("홀수인 양의 정수를 입력하세요 : ");
            oddNum = sc.nextInt();
            if (oddNum % 2 == 1) {
                break;
            }
            else {
                System.out.println("양수이며 홀수인 수만 입력해야 합니다.");
            }
        }
        for(int up = 1; up <= (oddNum + 1) / 2; up++) {
            System.out.print(up + " ");
        }
        for(int down = (oddNum - 1) / 2; down >= 1; down--) {
            System.out.print(down + " ");
        }
    }
    /* 숫자 야구게임 만들기
     * 길이 4의 정수 배열을 만들고 각 인덱스에는 0 ~ 9까지의 중복되지 않는 난수를 저장한다.
     * 4자리 숫자를 입력받아 스트라이크, 볼 등의 힌트를 주며 4자리 난수 숫자를 맞추는 게임이다.
     * 숫자와 자리가 모두 맞는 경우 스트라이크, 숫자는 맞지만 자리는 맞지 않는 경우는 볼 이다.
     * 예) 9183 으로 난수가 발생하면 9356 입력 시 1S 1B이다.
     *
     * 단, 기회는 총 10번이며, 10번 이내에 맞추는 경우 "정답입니다." 출력 후 게임 종료
     * 10번의 기회가 모두 소진 되면 "10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다." 출력 후 종료
     *
     * 또한 4자리의 정수를 입력하지 않은 경우에는 "4자리의 정수를 입력해야 합니다." 출력 후 입력을 다시 받을 수 있되
     * 횟수는 차감하지 않는다.
     *
     * -- 프로그램 예시 (난수 7416 의 경우) --
     *
     * 10회 남으셨습니다.
     * 4자리 숫자를 입력하세요 : 1234
     * 아쉽네요 0S 2B 입니다.
     * 9회 남으셨습니다.
     * 4자리 숫자를 입력하세요 : 5678
     * 아쉽네요 0S 2B 입니다.
     * 8회 남으셨습니다.
     * 4자리 숫자를 입력하세요 : 7416
     * 정답입니다.
     * */
    public void baseball() {
        System.out.println("\n=======Q. 2=======");
        Scanner sc = new Scanner(System.in);
        // 0~9 중복되지 않는 난수를 생성
        int[] randomNum = new int[4];
        for(int i = 0; i < randomNum.length; i++) {
            randomNum[i] = (int)(Math.random() * 6);
            for (int j = 0; j < i; j++) {
                if(randomNum[i] == randomNum[j]) {
                    i -= 1;
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(randomNum)); // 정답 랜덤 난수 확인
        System.out.println("숫자 야구게임을 PLAY 합니다.");
        int[] inputArr = new int[4];
        int coin;
        for (coin = 10; coin >= 0 ; coin--) {
            // 코인 전부 소모 시 프로그램 종료
            if(coin == 0) {
                System.out.println("10번의 기회를 모두 소진하셨습니다. 프로그램을 종료합니다.");
                break;
            }
            System.out.println(coin + "회 남으셨습니다.");
            System.out.println("4자리 숫자를 입력하세요.");
            int input = sc.nextInt();
            // 4자리 정수가 맞는지 확인
            if (String.valueOf(input).length() != 4) {
                System.out.println("4자리의 정수를 입력해야 합니다.");
                coin++;
                continue;
            }
            // 받은 int를 배열로 변환하여 inputArr에 삽입
            for(int i = 0; i <= 3; i++) {
                char singleNum = Integer.toString(input).charAt(i);
                inputArr[i] = Character.getNumericValue(singleNum);
            }
            // [정답]입력받은 값이 난수와 같다면 break;로 탈출
            boolean isSame = false;
            for (int i = 0; i < randomNum.length; i++) {
                if(randomNum[i] == inputArr[i]) {
                    isSame = true;
                } else {isSame = false; break;}
            }
            if (isSame) {
                System.out.println("정답입니다!");
                break;
            }
            // 숫자와 자리가 모두 맞는 경우 스트라이크(strk)
            int strk = 0;
            for (int s = 0; s < randomNum.length; s++) {
                if(inputArr[s] == randomNum[s]) {
                    strk += 1;
                }
            }
            // 숫자는 맞지만 자리는 맞지 않는 경우 볼(ball)
            int ball = 0;
            for (int i = 0; i < randomNum.length; i++) {
                for(int j = 0; j < inputArr.length; j++) {
                    if (randomNum[i] == inputArr[j]) {
                        ball += 1;
                    }
                }
            }
            System.out.println("아쉽네요. " + strk + "S " + ball + "B 입니다.");
        }
    }
}
