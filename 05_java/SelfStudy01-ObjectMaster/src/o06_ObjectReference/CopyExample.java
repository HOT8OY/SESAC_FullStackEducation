package o06_ObjectReference;

public class CopyExample {
    public static void main(String[] args) {
        // 원본 객체 생성
        Student original = new Student("김철수", 20);

        // 얕은 복사 (Shallow Copy)
        // 참조만 복사됨 - 같은 객체를 가리킴
        Student shallowCopy = original;

        // shallowCopy를 통해 값을 변경하면
        shallowCopy.name = "이영희";

        // original도 같이 변경됨 (같은 객체를 가리키므로)
        System.out.println(original.name);  // 이영희

        // 깊은 복사 (Deep Copy)
        // 새로운 객체를 생성하고 값을 복사
        Student deepCopy = new Student(original.name, original.age);

        // deepCopy를 변경해도
        deepCopy.name = "박민수";

        // original은 변경되지 않음 (서로 다른 객체이므로)
        System.out.println(original.name);  // 이영희 (변경 안됨)
        System.out.println(deepCopy.name);   // 박민수
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

/*
얕은 복사:
original -> 0x1000 (Student 객체)
shallowCopy -> 0x1000 (같은 객체!)

깊은 복사:
original -> 0x1000 (Student 객체)
deepCopy -> 0x2000 (다른 객체!)
*/

