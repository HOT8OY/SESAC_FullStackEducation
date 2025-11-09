package miniproject1.princessmaker.util;

import java.util.Scanner;

/**
 * 사용자 입력을 검증하는 유틸리티 클래스
 * 잘못된 입력 시 재입력을 요청하는 기능 포함
 * 제네릭을 사용하여 다양한 타입의 입력 검증 가능 (현재는 Integer만 구현)
 */
public class InputValidator {

    /**
     * 정수 입력을 받고 유효성을 검증
     * 범위를 벗어나거나 숫자가 아닌 입력 시 재입력 요청
     *
     * @param scanner Scanner 객체
     * @param prompt 입력 요청 메시지
     * @param min 최소값 (포함)
     * @param max 최대값 (포함)
     * @return 유효한 정수 입력값
     */
    public static int getValidatedInt(Scanner scanner, String prompt, int min, int max) {
        // 유효한 입력을 받을 때까지 반복
        while (true) {
            try {
                // 입력 요청 메시지 출력
                System.out.print(prompt);

                // 사용자 입력 받기
                String input = scanner.nextLine().trim();

                // 빈 입력 체크
                if (input.isEmpty()) {
                    System.out.println("❌ 입력이 비어있습니다. 다시 입력해주세요.");
                    continue;
                }

                // 문자열을 정수로 변환
                int value = Integer.parseInt(input);

                // 범위 검증
                if (value < min || value > max) {
                    System.out.printf("❌ %d ~ %d 사이의 숫자를 입력해주세요.%n", min, max);
                    continue;
                }

                // 유효한 입력이면 반환
                return value;

            } catch (NumberFormatException e) {
                // 숫자가 아닌 입력인 경우
                System.out.println("❌ 숫자만 입력 가능합니다. 다시 입력해주세요.");
            }
        }
    }

    /**
     * 문자열 입력을 받고 유효성을 검증
     * 빈 문자열이 아닌지 확인
     *
     * @param scanner Scanner 객체
     * @param prompt 입력 요청 메시지
     * @return 유효한 문자열 입력값
     */
    public static String getValidatedString(Scanner scanner, String prompt) {
        // 유효한 입력을 받을 때까지 반복
        while (true) {
            // 입력 요청 메시지 출력
            System.out.print(prompt);

            // 사용자 입력 받기
            String input = scanner.nextLine().trim();

            // 빈 입력 체크
            if (input.isEmpty()) {
                System.out.println("❌ 입력이 비어있습니다. 다시 입력해주세요.");
                continue;
            }

            // 유효한 입력이면 반환
            return input;
        }
    }

    /**
     * Yes/No 선택 입력을 받음
     * y, yes, n, no를 입력받아 boolean으로 반환
     *
     * @param scanner Scanner 객체
     * @param prompt 입력 요청 메시지
     * @return Yes면 true, No면 false
     */
    public static boolean getYesOrNo(Scanner scanner, String prompt) {
        // 유효한 입력을 받을 때까지 반복
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            } else {
                System.out.println("❌ 'y' 또는 'n'을 입력해주세요.");
            }
        }
    }
}