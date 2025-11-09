package o08_IdentityAndEquality;

public class EqualityExample {
    public static void main(String[] args) {
        // 두 개의 Student 객체 생성 (내용은 같지만 서로 다른 객체)
        Student student1 = new Student("김철수", 20);
        Student student2 = new Student("김철수", 20);

        // == 연산자: 참조(주소)를 비교
        // student1과 student2는 서로 다른 객체이므로 주소가 다름
        System.out.println(student1 == student2);  // false

        // 같은 객체를 참조하는 경우
        Student student3 = student1;  // student3는 student1과 같은 객체를 가리킴
        System.out.println(student1 == student3);  // true (같은 주소)

        // equals() 메서드: 내용을 비교
        // 기본 Object 클래스의 equals()는 ==와 동일하게 작동
        System.out.println(student1.equals(student2));  // false

        // equals()를 오버라이딩하면 내용 비교 가능 (아래 Student2 클래스 참조)
        Student2 s1 = new Student2("이영희", 22);
        Student2 s2 = new Student2("이영희", 22);

        System.out.println(s1 == s2);  // false (다른 객체)
        System.out.println(s1.equals(s2));  // true (내용이 같음)

        // String의 경우 equals()가 이미 오버라이딩되어 있음
        String str1 = new String("Hello");
        String str2 = new String("Hello");

        System.out.println(str1 == str2);  // false (다른 객체)
        System.out.println(str1.equals(str2));  // true (내용이 같음)
    }
}

// 기본 Student 클래스
class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// equals()를 오버라이딩한 Student2 클래스
class Student2 {
    String name;
    int age;

    Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // equals() 메서드 오버라이딩
    // 이름과 나이가 같으면 같은 객체로 간주
    @Override
    public boolean equals(Object obj) {
        // 1. 같은 객체를 참조하면 당연히 true
        if (this == obj) {
            return true;
        }

        // 2. null이거나 다른 클래스면 false
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // 3. Student2로 형변환
        Student2 other = (Student2) obj;

        // 4. 이름과 나이가 같은지 비교
        // this.age == other.age: 기본 타입은 ==로 비교
        // this.name.equals(other.name): 객체는 equals()로 비교
        return this.age == other.age && this.name.equals(other.name);
    }
}

/*
메모리 구조:

student1 -> 0x1000 [Student: "김철수", 20]
student2 -> 0x2000 [Student: "김철수", 20]
student3 -> 0x1000 (student1과 같은 객체)

student1 == student2: false (주소가 다름)
student1 == student3: true (주소가 같음)
*/

