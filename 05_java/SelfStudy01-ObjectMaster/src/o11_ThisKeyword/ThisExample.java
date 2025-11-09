package o11_ThisKeyword;

public class ThisExample {
    public static void main(String[] args) {
        Person person = new Person("홍길동", 30);
        person.introduce();

        Person older = person.getOlderPerson(5);
        older.introduce();

        older.example();
        older.introduce();
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        // this.name: 이 객체의 name 필드
        // name: 매개변수 name
        this.name = name;  // 필드와 매개변수 이름이 같을 때 구분
        this.age = age;
    }

    // this: 현재 메서드를 호출한 객체 자신을 의미
    void introduce() {
        System.out.println("제 이름은 " + this.name + "이고, " +
                this.age + "살입니다.");
        // this는 생략 가능 (필드와 지역변수가 겹치지 않을 때)
        // System.out.println("제 이름은 " + name + "이고, " + age + "살입니다.");
    }

    // 메서드가 자기 자신(this)을 반환
    Person getOlderPerson(int years) {
        // 새로운 Person 객체 생성
        Person newPerson = new Person(this.name, this.age + years);
        return newPerson;
    }

    // this를 반환하는 메서드 (메서드 체이닝에 사용)
    Person setName(String name) {
        this.name = name;
        return this;  // 자기 자신을 반환
    }

    Person setAge(int age) {
        this.age = age;
        return this;  // 자기 자신을 반환
    }

    // 메서드 체이닝 사용 예시
    void example() {
        // 메서드를 연속으로 호출 가능
        this.setName("김철수").setAge(25);
        // setName()이 this를 반환하므로
        // 반환된 객체(자기 자신)로 다시 setAge() 호출 가능
    }
}
