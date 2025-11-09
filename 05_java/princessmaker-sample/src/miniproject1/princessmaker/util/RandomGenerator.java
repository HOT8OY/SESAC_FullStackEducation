package miniproject1.princessmaker.util;

import java.util.Random;

/**
 * 게임에서 사용하는 랜덤 값을 생성하는 유틸리티 클래스
 * 활동의 성공/실패 판정에 사용됨
 */
public class RandomGenerator {
    // Random 객체 (랜덤 값 생성용)
    private static final Random random = new Random();

    /**
     * 활동의 성공 수준을 랜덤으로 결정
     * 피로도에 따라 실패 확률이 달라짐
     *
     * 일반 확률 (피로도 80 미만):
     * - 실패: 5%
     * - 보통: 35%
     * - 성공: 45%
     * - 대성공: 15%
     *
     * 높은 피로도 (80 이상):
     * - 실패: 50%
     * - 보통: 30%
     * - 성공: 15%
     * - 대성공: 5%
     *
     * @param isHighFatigue 피로도가 높은지 여부 (80 이상이면 true)
     * @return 성공 수준 (0: 실패, 1: 보통, 2: 성공, 3: 대성공)
     */
    public static int determineSuccessLevel(boolean isHighFatigue) {
        // 0~99 사이의 랜덤 값 생성 (100가지 경우의 수)
        int roll = random.nextInt(100);

        if (isHighFatigue) {
            // 피로도가 높을 때: 실패 확률 증가
            if (roll < 50) {
                return 0;  // 실패 (0~49: 50%)
            } else if (roll < 80) {
                return 1;  // 보통 (50~79: 30%)
            } else if (roll < 95) {
                return 2;  // 성공 (80~94: 15%)
            } else {
                return 3;  // 대성공 (95~99: 5%)
            }
        } else {
            // 일반 상태: 정상 확률
            if (roll < 5) {
                return 0;  // 실패 (0~4: 5%)
            } else if (roll < 40) {
                return 1;  // 보통 (5~39: 35%)
            } else if (roll < 85) {
                return 2;  // 성공 (40~84: 45%)
            } else {
                return 3;  // 대성공 (85~99: 15%)
            }
        }
    }

    /**
     * 성공 수준을 문자열로 변환
     * @param successLevel 성공 수준 (0~3)
     * @return 성공 수준 문자열
     */
    public static String getSuccessLevelName(int successLevel) {
        switch (successLevel) {
            case 0:
                return "실패";
            case 1:
                return "보통";
            case 2:
                return "성공";
            case 3:
                return "대성공";
            default:
                return "알 수 없음";
        }
    }

    /**
     * 지정된 범위 내의 랜덤 정수 생성
     * @param min 최소값 (포함)
     * @param max 최대값 (포함)
     * @return min과 max 사이의 랜덤 정수
     */
    public static int getRandomInt(int min, int max) {
        // max - min + 1 범위의 값을 생성하고 min을 더함
        return random.nextInt(max - min + 1) + min;
    }
}