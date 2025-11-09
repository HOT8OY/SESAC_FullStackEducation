package com.ohgiraffers.section02;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        List<OnlineCourse> course = Arrays.asList(
                new OnlineCourse("Java의 정석", "Programming", 120, false),
                new OnlineCourse("Spring 완전 정복", "Programming", 300, false),
                new OnlineCourse("JPA 끝장내기", "Programming", 240, false),
                new OnlineCourse("포토샵 마스터", "Design", 90, true),
                new OnlineCourse("일러스트레이터", "Design", 110, true),
                new OnlineCourse("SQL 첫걸음", "Database", 80, true),
                new OnlineCourse("데이터베이스 모델링", "Database", 150, false)
        );

        /**
         * Programming 카테고리 중 수강 시간 200분 초과인 강의 제목 출력하기
         */
        // [ Stream을 안 쓰는 기존 방식 ]
        // for, if 사용
        for(OnlineCourse c : course) {
            if("Programming".equals(c.getCategory()) && c.getDuration() > 200) {    // 한줄에 많은 코드를 쓰기 때문에 가독성이 안 좋음
                System.out.println(c.getTitle());
            }
        }
        // [ Stream을 사용 ]
        course.stream()
                .filter(c -> "Programming".equals(c.getCategory()))
                .filter(c -> c.getDuration() > 200)
                .map(OnlineCourse::getTitle)
                .forEach(System.out::println);


        /* ###[ 중간연산 ]### */
        // sorted()
        course.stream()
                .filter(OnlineCourse::isFree)   // true(무료인 강의)만 걸러옴
                .sorted((c1, c2) -> c1.getDuration() - c2.getDuration()) // Comparator를 람다식으로 구현!! 오름차순 정렬
                .forEach(System.out::println);

        // distinct() : 중복 제거하기
        course.stream()
                .map(OnlineCourse::getCategory)
                .distinct() // 중복된 카테고리를 제거
                .forEach(System.out::println);


        /* ###[ 최종연산 ]### */

        // collect
        List<OnlineCourse> designCourses = course.stream()
                .filter(c -> "Design".equals(c.getCategory()))
                .collect(Collectors.toList());
        System.out.println(designCourses);

        // 간단한 통계 구현
        // .count() : 스트림에 남아있는 요소 개수 확인
        // .sum() : 남은 요소의 합계
        // average() : 남은 요소의 평균
        int totalDurationOfFreeCourses = course.stream()
                .filter(OnlineCourse::isFree)
                .mapToInt(OnlineCourse::getDuration)    // mapToInt : Int Stream으로 변환( sum() 수행 가능)
                .sum();
        System.out.println(totalDurationOfFreeCourses + "분");


        /* groupingBy */
        // 모든 강의를 카테고리별로 분류해서 정리하기
        // collect에게 groupingBy를 할던데 기준은 '카테고리야' 라고 알려주면
        // 스트림이 알아서 Map<카테고리, 해당 강의 리스트> 형태로 분류해줌
        Map<String, List<OnlineCourse>> courseBycategory = course.stream()
                .collect(Collectors.groupingBy(OnlineCourse::getCategory));
        // Map 출력
        courseBycategory.forEach((category, courseList) -> {
            System.out.println("[" + category + "]");
            courseList.forEach(c -> System.out.println(" - " + c.getTitle()));
        });
    }
}
