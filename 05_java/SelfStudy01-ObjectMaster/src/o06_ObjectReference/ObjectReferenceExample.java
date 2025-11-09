package o06_ObjectReference;

public class ObjectReferenceExample {
    public static void main(String[] args) {
        // Address 객체 생성
        Address address = new Address("서울", "강남구", "123-45");

        // Person 객체 생성하면서 Address 객체의 참조를 전달
        Person person = new Person("홍길동", address);

        // Person 객체를 통해 Address 정보에 접근
        System.out.println(person.name + "의 주소:");
        System.out.println(person.address.city);  // 서울
        System.out.println(person.address.district);  // 강남구

        // 주소 변경
        person.address.city = "부산";

        // address 변수로 확인해도 변경된 값이 나옴
        // 왜? person.address와 address는 같은 객체를 가리키기 때문
        System.out.println(address.city);  // 부산
    }
}

// 주소 클래스
class Address {
    String city;      // 도시
    String district;  // 구/군
    String zipCode;   // 우편번호

    Address(String city, String district, String zipCode) {
        this.city = city;
        this.district = district;
        this.zipCode = zipCode;
    }
}

// 사람 클래스
class Person {
    String name;
    Address address;  // Address 객체를 참조하는 변수

    Person(String name, Address address) {
        this.name = name;
        this.address = address;  // 주소 객체의 참조를 저장
    }
}

/*
메모리 구조:

[힙 영역]
Address 객체 (0x1000)
+----------------------+
| city: "부산"         |
| district: "강남구"   |
| zipCode: "123-45"    |
+----------------------+
          ↑
          | (참조)
          |
Person 객체 (0x2000)
+----------------------+
| name: "홍길동"       |
| address: 0x1000      | (Address 객체를 가리킴)
+----------------------+

person.address와 address 변수 모두 같은 객체(0x1000)를 가리킴
*/

