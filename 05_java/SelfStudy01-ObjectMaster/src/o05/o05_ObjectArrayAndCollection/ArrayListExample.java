package o05.o05_ObjectArrayAndCollection;
// ## 5.2 ArrayList를 사용한 동적 객체 관리
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // ArrayList: 크기가 동적으로 변하는 배열 같은 자료구조
        // <Student>는 이 리스트가 Student 타입만 저장한다는 의미 (제네릭)
        ArrayList<Student> studentList = new ArrayList<>();

        // add() 메서드로 객체 추가
        studentList.add(new Student("김철수", 20));
        studentList.add(new Student("이영희", 22));
        studentList.add(new Student("박민수", 21));

        // size() 메서드로 리스트의 크기 확인
        System.out.println("학생 수: " + studentList.size());

        // get(index) 메서드로 특정 위치의 객체 가져오기
        Student firstStudent = studentList.get(0);
        System.out.println("첫 번째 학생: " + firstStudent.name);

        // 리스트의 모든 객체 순회
        for (Student s : studentList) {
            System.out.println(s.name + ", " + s.age + "세");
        }

        // 객체 제거
        studentList.remove(1);  // 인덱스 1의 객체 제거 (이영희)

        // 제거 후 크기 확인
        System.out.println("제거 후 학생 수: " + studentList.size());

        // 특정 객체 찾기
        for (Student s : studentList) {
            if (s.name.equals("박민수")) {
                System.out.println("박민수를 찾았습니다!");
                System.out.println("나이: " + s.age);
            }
        }

        // 리스트 비우기
        studentList.clear();
        System.out.println("모두 제거 후 학생 수: " + studentList.size());
    }
}



