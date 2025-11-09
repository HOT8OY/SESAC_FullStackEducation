package ex2_string_array;

import java.util.ArrayList;

public class ListExample {
    public static void main(String[] args) {
        // 1. 생성
        ArrayList<String> fruits = new ArrayList<>();

        // 2. 추가
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("오렌지");

        // 3. 특정 위치 삽입
        fruits.add(1, "포도");  // 1번 인덱스에 삽입


        // 4. 출력
        System.out.println(fruits);  // [사과, 포도, 바나나, 오렌지]

        // 5. 하나씩 꺼내기
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(i + ": " + fruits.get(i));
        }

        // 6. 향상된 for문 (추천!)
        for (String fruit : fruits) {
            System.out.println("과일: " + fruit);
        }

        // 7. 삭제
        fruits.remove("바나나");
        fruits.remove(0);  // 인덱스 0 삭제

        // 8. 크기 확인
        System.out.println("남은 개수: " + fruits.size());
    }
}
