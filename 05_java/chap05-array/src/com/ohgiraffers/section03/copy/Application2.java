package com.ohgiraffers.section03.copy;

import java.util.Arrays;

public class Application2 {
    public static void main(String[] args) {

        /*
        [ 깊은 복사 ]
        heap에 새로운 배열을 생성하고, 기존 배열의 값을 그대로 복사한다.
        따라서 두 배열은 서로 독립적이므로, 한쪽을 수정해도 다른 쪽에 영향이 없다.
        */

        // 원본 배열
        int[] originArr = {1, 2, 3, 4, 5};
        System.out.println(originArr.hashCode());   // 원본 배열의 해쉬코드
        System.out.println("-----------------------'");

        /* [ 깊은 복사를 하는 4가지 방법 ] */

        // # 1. for문을 이용한 수동 복사 (가장 정확)
        int[] copyFor = new int[originArr.length];  // originArr의 길이를 복사한 배열의 길이로 사용
        for (int i = 0; i < originArr.length; i++) {
            copyFor[i] = originArr[i];
        }
        print("copyFor", copyFor);

        // # 2. Arrays.copyOf() 이용 (가장 추천!)
        // Arrays를 import 할 것.
        // 사용 방법
        // Arrays.copyOf(원본배열, 복사할 길이);
        int[] copyOf = Arrays.copyOf(originArr, originArr.length);
        print("copyOf", copyOf);

        // # 3. System.arraycopy() (고성능, 복잡함)
        // 사용방법
        // System.arraycopy(원본, 원복시작위치, 사본, 사본시작위치, 복사할길이);
        int[] arrayCopy = new int[originArr.length];
        System.arraycopy(originArr, 0, arrayCopy, 0, originArr.length);
        print("arrayCopy", arrayCopy);

        // # 4. clone() (간단하지만, 크기 조절 불가)
        int[] copyClone = originArr.clone();
        print("copyClone", copyClone);

        //값 변경해보기
        copyClone[0] = 99;
        print("originArray", originArr);
        print("copyClone", copyClone);
    }
    // 해쉬코드와 array 내용을 출력하는 메소드
    public static void print(String name, int[] arr) {
        System.out.println(name + " hashCode: " + arr.hashCode() + ". array: " + Arrays.toString(arr));
    }
}
