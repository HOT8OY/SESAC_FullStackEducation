package o04_scope;
//### 4.1 스코프의 개념
//**스코프**는 변수나 객체에 접근할 수 있는 "범위"를 의미합니다.

public class ScopeExample {
    // 클래스 레벨 변수 (필드, 인스턴스 변수)
    // 객체가 생성되면 이 변수도 함께 생성됨
    String instanceField = "인스턴스 변수";

    // static 변수 (클래스 변수)
    // 객체 생성 없이도 사용 가능, 모든 객체가 공유
    static String classField = "클래스 변수";

    public static void main(String[] args) {
        // 1. 지역 변수의 스코프
        {
            int localVar = 10;  // 이 중괄호 안에서만 사용 가능
            System.out.println(localVar);  // 정상 작동
        }
        // System.out.println(localVar);  // 에러! 스코프를 벗어남

        // 2. 인스턴스 변수에 접근하려면 객체를 생성해야 함
        ScopeExample obj = new ScopeExample();
        System.out.println(obj.instanceField);  // 정상 작동

        // 3. static 변수는 객체 없이도 접근 가능
        System.out.println(ScopeExample.classField);  // 정상 작동

        // 4. 메서드 내에서 생성한 객체
        Person person = new Person("홍길동");
        // person은 main 메서드가 끝날 때까지 접근 가능
        System.out.println(person.name);
    }

    // 메서드 레벨의 스코프
    void exampleMethod(int parameter) {  // parameter는 메서드 매개변수
        int methodLocal = 5;  // 메서드 내 지역 변수

        // 이 메서드 내에서는 다음 변수들에 접근 가능:
        // 1. parameter (매개변수)
        // 2. methodLocal (지역 변수)
        // 3. instanceField (인스턴스 변수)
        // 4. classField (클래스 변수)

        System.out.println(parameter);
        System.out.println(methodLocal);
        System.out.println(instanceField);
        System.out.println(classField);
    }
    // 메서드가 끝나면 parameter와 methodLocal은 사라짐
}

class Person {
    String name;
    Person(String name) { this.name = name; }
}

