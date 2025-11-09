/**
 * # [09_Constructor-Function]
 * # 02_instance-creation-process
 */
// ## 'new' 버튼을 눌렀을 때 내부에서 벌어지는 일 (인스턴스 생성 과정)
// 1단계. this에 빈 객체()를 할당한다.
// 2단계. this라는 빈 객체에 속성(name,age 등)들을 추가하며 초기화합니다.
// 3단계. 완성된 객체(this)가 암묵적으로 반환된다. 마치 return this; 코드가 맨 마지막에 있는 것처럼 동작한다.
function Student(name, age) {
    console.log(this);  // 1단계 -> Student {}
    this.name = name;
    this.age = age;
    this.getInfo = function() {
        return `${this.name}는 ${this,age}세 입니다.`
    }
}

const student = new Student('홍길동', 20);
console.log(student);   // -> Student { name: '홍길동', age: 20, getInfo: [Function (anonymous)] }

// ## 설계도를 잘못 사용했을 때의 위험성 ('new' 없이 호출)
// new 없이 호출하면 생성자 함수가 아닌 '일반 함수'로 동작한다.
// const student2 = Student('다람쥐', 2);
// console.log(student2);  // -> undefined
// 이때 함수 안의 this는 '전역 개체(window)'를 가리키게 된다.(전역 오염)
// console.log(window.name);   // '다람쥐'

// ### new.target을 이용한 안전장치 설치
// 해당 함수가 new와 함꼐 '생성자'로 호출되었는지 확인한다.
// new와 함께 호출되면 new.target은 자기 자신(Dog 함수)을 가르킨다.
// new 없이 '일반 함수'로 호출되면 new.target은 undefined가 된다.
function Dog(name, age) {
    if(!new.target) {
        console.log('new 없이 호출했네요~ new를 붙여서 다시 실행합니다.')
        return new Dog(name, age);
    }
    this.name = name;
    this.age = age;
}

// new 없이 호출 하기(안전장치 있음)
const dog1 = Dog('두부',1 );
console.log(dog1);  // -> new 없이 호출했네요~ new를 붙여서 다시 실행합니다. / Dog { name: '두부', age: 1 }