// # ES6
// [# 01_class]
// # 01_class-basic (클래스 기본 문법)

/**
 * ## [클래스]
 * ES6에서 도입된, 객체를 생성하기 위한 새로운 '설계도' 양식이다.
 * 기존의 생성자 함수보다 훨씬 더 명확하고 체계적으로 객체를 설계할 수 있다.
 */

// ## 클래스 선언
// class로 시작. 이름은 대문자로 시작.
class Student {
    // new 키워드로 객체를 만들 때, 가장 먼저 딱 한번 실행되는 초기화 메서드
    // 생성자 함수는 1. this={} 빈 값을 할당 2.this에 값을 할당 3.return
    constructor(name, group) {
        this.name = name;   // this는 '새롭게 생성될 인스턴스(객체)'를 가리킨다.
        this.group = group;
    }
    // 메서드: 이 클래스(Student)로 만들어진 모든 객체가 공유하는 기능
    // 자동으로 Student.prototype에 저장된다.
    introduce() {
        console.log(`안녕하세요! ${this.group}반 ${this.name}입니다.`)
    }
}

// new 키워드로 실제 객체(인스턴스) 생성
// 클래스 생성자를 new와 함께 호출하지 않으면 에러가 발생한
const studentA = new Student("판다", 1);
const studentB = new Student("코알라", 2);

studentA.introduce();
studentB.introduce();

console.log(typeof Student); // function
// 일급객체 -> 클래스도 함수처럼 변수에 담거나, 함수의 결과로 반환할 수도 있다.


// ## getter, setter

class Product {
    constructor(name, price) {
        this.name = name;  // 내부 실제 데이터 저장
        this.price = price;
    }

    // ###### getter: 프로퍼티를 '읽으려고' 할 때 실행되는 함수
    get name() {
        console.log('getter: name을 읽고 있습니다.')
        return this._name;  // 실제 값은 _(언더스코어)가 붙은 프로퍼티에 저장
    }                       // 외부에서 obj.name을 읽을 때 실행됨

    get price() {
        return `${this._price.toLocaleString()}원`; // 값을 가공해서 반환
    }

    // ###### setter: 프로퍼티에 값을 '할당하려고' 할 때 실행되는 함수
    set name(value) {
        console.log('setter: name을 설정합니다.')
        this._name = value; // 실제 값은 _(언더스코어)가 붙은 프로퍼티에 저장
    }                       // 여기서 언더바(_)를 붙이지 않으면 값을 다시 할당하려는 것으로 인식되어,
                            // set name(value)가 다시 실행된다. 결과는 setter의 무한루프.
    set price(value) {
        // 유효성 검사: 가격이 0보다 작으면 0으로 강제 설정
        if(value < 0) {
            console.log('가격은 음수일 수 없습니다.');
            this._price = 0;
        } else {
            this._price = value;
        }
    }
};

const phone = new Product("스마트폰", 1400000);
console.log(`상품명: ${phone.name}`); // get name() 호출
console.log(`상품가격: ${phone.price}`); // 상품가격: 1,400,000원 | get price에서 가공된 후 출력

const computer = new Product("컴퓨터", -1500000);
console.log(computer.price);