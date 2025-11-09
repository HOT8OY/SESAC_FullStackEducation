/**
 * # [07_Function (함수)]
 * # 01_function-declaration (함수 선언문)
 */
// - 함수 선언문에서는 함수의 이름을 생략할 수 없다.
// 1. 함수 선언문
function hello(name) {
    return `${name}님 안녕하세요!`
}

// 함수 호출 - 이름(쟤료)
console.log(hello('홍길동'));   // -> 홍길동님 안녕하세요!

// 2. 함수 표현식
// - 함수 표현식에서는 함수의 이름을 생략할 수 있다.
var hi = function(name) {
    return `${name} 안녕~`
}
console.log(hi('판다'));    // -> 판다 안녕~

// - 함수 이름 생략 안해도 문제는 없음.
var calc = function add(a, b) {
    return a + b;
}
// // 단, 함수 호출은 식별자로 이루어진다.
console.log(calc(10, 20));  // -> 30
// // 식별자가 아닌것으로 하는 경우
console.log(add(10,20));    // -> add is not defined