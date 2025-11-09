package o08_IdentityAndEquality;

import java.util.HashSet;
import java.util.Objects;

public class HashCodeExample {
    public static void main(String[] args) {
        // HashSet: 중복을 허용하지 않는 집합 자료구조
        // 중복 판단은 equals()와 hashCode()를 함께 사용

        HashSet<Student3> students = new HashSet<>();

        Student3 s1 = new Student3("김철수", 20);
        Student3 s2 = new Student3("김철수", 20);  // s1과 내용은 같음
        Student3 s3 = new Student3("이영희", 22);

        students.add(s1);
        students.add(s2);  // equals()와 hashCode()가 제대로 구현되었다면 추가 안됨
        students.add(s3);

        // s1과 s2는 내용이 같으므로 하나만 저장됨
        System.out.println("학생 수: " + students.size());  // 2

        // hashCode 확인
        System.out.println("s1 hashCode: " + s1.hashCode());
        System.out.println("s2 hashCode: " + s2.hashCode());
        // equals()가 true이면 hashCode()도 같아야 함
    }
}

class Student3 {
    String name;
    int age;

    Student3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // equals() 오버라이딩
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Student3 other = (Student3) obj;
        return age == other.age && Objects.equals(name, other.name);
    }

    // hashCode() 오버라이딩
    // equals()가 true인 객체는 같은 hashCode를 반환해야 함
    @Override
    public int hashCode() {
        // Objects.hash()는 여러 값을 조합해서 해시코드 생성
        return Objects.hash(name, age);
    }

    // toString() 오버라이딩 (객체 정보를 문자열로 표현)
    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

