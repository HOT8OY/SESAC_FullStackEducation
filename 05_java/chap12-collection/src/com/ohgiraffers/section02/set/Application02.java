package com.ohgiraffers.section02.set;

import java.util.*;

public class Application02 {
    public static void main(String[] args) {


        /*
         * [ LinkedHashSet ]
         * - '중복 불가'의 특징은 그대로 유지한다.
         * - 추가적으로 요소가 입력된 순서를 기억하여 순서를 유지하는 특징을 가진다.
         * */
        // Hashset : 순서 X, 중복 X
        // LikedHashset : 순서 O, 중복 X

        // HashSet
        Set<String> hset = new HashSet<>();
        hset.add("java");
        hset.add("html");
        hset.add("css");
        hset.add("java"); // 중복 허용하지 않음
        
        // LinkedHashSet
        Set<String> lhset = new LinkedHashSet<>();
        lhset.add("java");
        lhset.add("mysql");
        lhset.add("jbdc");
        lhset.add("java");

        System.out.println("HashSet 결과 : " + hset); // HashSet 결과 : [css, java, html]
        System.out.println("LinkedHashSet 결과 : " + lhset); // 입력 순서를 유지함 | LinkedHashSet 결과 : [java, mysql, jbdc]
    }
}
