package o05.o05_ObjectArrayAndCollection;

// 실습

import java.util.ArrayList;

public class ArrayListExercise {
    public static void main(String[] args) {
        // ArrayList: 크기가 동적으로 변하는 배열 같은 자료구조
        // <Student>는 이 리스트가 Student 타입만 저장한다는 의미 (제네릭)
        ArrayList<Student> arrayExercise = new ArrayList<>();

        // add() 메서드로 객체 추가
        arrayExercise.add(new Student("금태양", 18));
        arrayExercise.add(new Student("킹태양", 22));
        arrayExercise.add(new Student("태양Bro",33));

        // size() 메서드로 리스트의 크기 확인
        int arrSize = arrayExercise.size();
        System.out.println(arrSize);

        // get(index) 메서드로 특정 위치의 객체 가져오기
        Student arr1Student = arrayExercise.get(0);
        System.out.println(arr1Student.name);


        // 리스트의 모든 객체 순회(향상된 for문)
        for(Student s : arrayExercise) {
            System.out.println(s.name+", "+s.age+"세");
        }

        // 객체 제거
        arrayExercise.remove(2);


        // 제거 후 크기 확인
        System.out.println(arrayExercise.size());

        // 특정 객체 찾기
        for (Student s : arrayExercise) {
            if(s.name == "금태양") {
                System.out.println("찾았다! "+s.name+"!!!");
            }
        }

        // 리스트 비우기
        arrayExercise.clear();
        System.out.println(arrayExercise);

    }

}
