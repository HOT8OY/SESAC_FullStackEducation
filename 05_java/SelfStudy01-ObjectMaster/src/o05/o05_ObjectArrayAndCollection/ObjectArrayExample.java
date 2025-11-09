package o05.o05_ObjectArrayAndCollection;
//### 5.1 객체 배열
//여러 개의 객체를 배열로 관리할 수 있습니다.
public class ObjectArrayExample {
    public static void main(String[] args) {
        // 방법 1: 배열 선언과 동시에 객체 생성
        Student[] students = new Student[3];  // 크기가 3인 배열 생성

        // 주의! 이 시점에서는 배열만 생성되고 Student 객체는 아직 생성 안됨
        // students[0], students[1], students[2]는 모두 null

        // 각 배열 요소에 객체를 생성해서 할당해야 함
        students[0] = new Student("김철수", 20);
        students[1] = new Student("이영희", 22);
        students[2] = new Student("박민수", 21);

        // 배열의 모든 학생 정보 출력
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].name + ", " + students[i].age);
        }

        // 방법 2: 배열 초기화와 동시에 객체 생성
        Student[] moreStudents = {
                new Student("최지현", 23),
                new Student("정수민", 24),
                new Student("강태양", 22)
        };

        // 향상된 for문 사용
        for (Student s : moreStudents) {
            System.out.println(s.name + ", " + s.age);
        }
    }
}

/*
메모리 구조:

[힙 영역]
students 배열 객체 (0x1000)
+-------------------+
| [0] -> 0x2000     |  -> Student 객체 (김철수, 20)
| [1] -> 0x2100     |  -> Student 객체 (이영희, 22)
| [2] -> 0x2200     |  -> Student 객체 (박민수, 21)
+-------------------+

배열도 객체이므로 힙에 저장되고,
배열의 각 요소는 다른 객체의 참조(주소)를 저장
*/
