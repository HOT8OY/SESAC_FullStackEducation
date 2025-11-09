/**
 * # 02_function-hoisting (함수 호이스팅)
 * 함수 선언문은 런타임 이전 자바스크립트 엔진에 의해 먼저 실행된다.
 * 따라서 선언문 이전에 함수를 참조, 호출할 수 있다.
 * 함수 선언문이 코드 선두로 끌어 올려진 것처럼 동작하는
 * 자바스크립트 고유의 특징을 함수 호이스팅이라고 한다.
 */
console.log(hello); // -> [Function: hello] | 함수 선언문은 코드의 맨 위에 있는것 처럼 작동한다(함수 호이스팅)
console.log(hi);    // -> undefined     | 변수에 할당되는 함수 표현식은 차례대로 작동 함
console.log(hello('홍길동'));   // -> 홍길동님 안녕하세요!
// console.log(hi('판다'));        // -> hi is not a function

// 함수 선언문
function hello(name) {
    return `${name}님 안녕하세요!`
}
// 함수 표현식
var hi = function(name) {
    return `${name} 안녕~`
}