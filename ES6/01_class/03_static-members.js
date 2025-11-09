// [# 01_class]
// # 03_static-members

/**
 * ## [정적(static)메서드와 프로퍼티]
 * 클래스의 '인스턴스'가 아닌, 클래스 '자체'에 소속된 멤버를 의미한다.
 * 개별 객체의 상태와 관계없이, 클래스 전체가 공유하는 기능이나 데이터를 정의할 때 사용한다.
 */

class Student {
    constructor(name, height) {
        // 인스턴스 프로퍼티 (객체가 가지는 개별의 값)
        this.name = name;
        this.height = height;
    }

    // 인스턴스 매서드 (개인이 사용하는 기능 (개인 사물함 같은 존재))
    introduce() {
        console.log(`저는 ${this.name}입니다.`)
    }

    // 정적(static) 메서드 (공용 기능 (교실 같은 존재))
    static compare(studentA, studentB) {
        // 두 학생 인스터스를 받아서 키를 비교하는 공용 기능
        return studentA.height - studentB.height;
    }
}

const studentA = new Student('호랑이', 100.5);
const studentB = new Student('기린', 300);
const studentC = new Student('강아지', 50);

// studentA.compare(studentA, studentB); // 클래스 명으로 접근하지 않으면 오류가 난다.

// 정적 메서드는 '인스턴스'가 아닌'클래스 이름'으로 직접 호출합니다.
console.log(Student.compare(studentA, studentB));

// 배열의 sort 메서드에 '비교 규칙'으로 유용하게 사용된다.
const students = [studentA, studentB, studentC];
students.sort(Student.compare);
console.log(`정렬된 후`, students);


/**
 * ## [정적(static) 프로퍼티]
 * 클래스 자체에 데이터를 저장하고 싶을 때 사용한다.
 */

class Animal {
    // 정적 프로퍼티(공용 데이터)
    static planet = '지구';

    constructor(name) {
        this.name = name; // 인스턴스 프로퍼티 (개별 동물의 이름)
    }
}
// 정적 프로퍼티도 '클래스 이름'으로 직접 접근합니다.
console.log(`모든 동물은 ${Animal.planet}에 삽니다.`);

// Static field도 상속이 가능하다.
class Human extends Animal {
    develop(language) {
        console.log(`${language} 개발 좋아요~`)
    }
}
console.log(`인간도 ${Human.planet}에 삽니다.`);