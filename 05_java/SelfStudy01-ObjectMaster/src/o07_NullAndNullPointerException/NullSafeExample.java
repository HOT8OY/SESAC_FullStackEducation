package o07_NullAndNullPointerException;

public class NullSafeExample {
    public static void main(String[] args) {
        Student student = getStudent();  // null을 반환할 수도 있는 메서드

        // 방법 1: if 문으로 null 체크
        if (student != null) {
            System.out.println(student.name);
        } else {
            System.out.println("학생 정보가 없습니다.");
        }

        // 방법 2: 삼항 연산자 사용
        String name = (student != null) ? student.name : "이름 없음";
        System.out.println(name);

        // 방법 3: 메서드에서 null 체크
        printStudentName(student);
    }

    // null을 반환할 수 있는 메서드
    static Student getStudent() {
        // 어떤 조건에 따라 null을 반환할 수 있음
        boolean found = false;  // 예시
        if (found) {
            return new Student("홍길동", 20);
        } else {
            return null;  // 찾지 못했을 때 null 반환
        }
    }

    // null-safe 메서드
    static void printStudentName(Student student) {
        // 메서드 시작 시 null 체크
        if (student == null) {
            System.out.println("학생 정보가 null입니다.");
            return;  // 메서드 종료
        }

        // null이 아닐 때만 실행되는 코드
        System.out.println("학생 이름: " + student.name);
    }
}
