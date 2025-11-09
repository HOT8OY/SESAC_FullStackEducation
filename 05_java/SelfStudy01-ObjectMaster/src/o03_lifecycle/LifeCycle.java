package o03_lifecycle;

public class LifeCycle {

    public static void main(String[] args) {
        createAndPrintStudent();
        // createAndPrintStudent() 메서드가 종료되면
        // 메서드 내부에서 생성된 student 변수는 스택에서 제거됨
        // 하지만 힙의 Student 객체는 즉시 제거되지 않고
        // 가비지 컬렉터가 나중에 처리함

        Student s = createStudent();
        // 이 경우는 다름!
        // createStudent()에서 생성한 객체의 참조를 반환받아
        // main의 s 변수에 저장했으므로
        // 객체는 계속 살아있음
        System.out.println(s.name);  // 정상 작동
    }

    // 메서드 내에서 객체 생성
    static void createAndPrintStudent() {
        // 지역 변수 student는 이 메서드의 스택 프레임에 생성
        Student student = new Student("박민수", 23);
        System.out.println(student.name);
        // 메서드가 끝나면 student 변수는 사라지지만
        // Student 객체는 힙에 남아있다가 GC에 의해 나중에 제거됨
    }

    // 객체를 생성해서 반환하는 메서드
    static Student createStudent() {
        Student student = new Student("최지현", 21);
        return student;  // 객체의 참조(주소)를 반환
        // 참조가 반환되므로 호출한 쪽에서 계속 사용 가능
    }
}

class Student {
    String name;
    int age;
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
