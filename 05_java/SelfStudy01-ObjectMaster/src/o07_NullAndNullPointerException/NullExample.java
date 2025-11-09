package o07_NullAndNullPointerException;

public class NullExample {
    public static void main(String[] args) {
        // null: "참조하는 객체가 없음"을 의미하는 특별한 값
        Student student = null;

        // student 변수는 존재하지만, 어떤 객체도 가리키지 않음
        System.out.println(student);  // null 출력

        // null인 변수로 객체의 멤버에 접근하려 하면 에러!
        try {
            System.out.println(student.name);  // NullPointerException 발생!
        } catch (NullPointerException e) {
            System.out.println("에러 발생: 객체가 null입니다!");
        }

        // 올바른 사용법: null 체크 후 사용
        if (student != null) {
            System.out.println(student.name);
        } else {
            System.out.println("student가 null이므로 접근할 수 없습니다.");
        }

        // 객체 생성 후에는 정상 사용 가능
        student = new Student("김철수", 20);
        System.out.println(student.name);  // 정상 작동
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
