/**
 * # [09_Constructor-Function]
 * # 01_constructor-function (생성자 함수)
 */

// - 일반 객체
const student1 = {
    name: '판다',
    age: 5,
    getInfo: function() {
        return `${this.name}는 ${this.age}세 입니다.`
    }
}
const student2 = {
    name: '코알라',
    age: 3,
    getInfo: function() {
        return `${this.name}는 ${this.age}세 입니다.`
    }
}

// ## 생성자 함수
// 규칙1. 생성자 함수 사용시 일반 함수와 구분하기 위해서 이름 첫 글자를 대문자로 만드는 것이 관례이다.
// 규칙2. this는 앞으로 '생성될 객체(instance)'를 가리키는 키워드이다.
// - 생성자 함수를 이용한 객체
function Student(name, age) {
    this.name = name;   // this.name = Student.name이다.
    this.age = age;
    this.getInfo = function() {
        return `${this.name}는 ${this,age}세 입니다.`
    }
}

// ## 'new' 키워드를 사용하여 설계도로부터 실제 객체(인스턴스)를 생성한다.
// '생성자 함수'를 호출 시에는 new를 꼭 써야 함.
// 형식: new 생성자 함수의 이름(함수에 전달할 값을 넣어준다)
const student3 = new Student('호랑이', 7);  // student3.name = '호랑이', student3.age = 7
const student4 = new Student('기린', 10);

console.log(student3);  // -> Student { name: '호랑이', age: 7, getInfo: [Function (anonymous)] }
console.log(student4.getInfo());    // -> 기린는 10세 입니다.