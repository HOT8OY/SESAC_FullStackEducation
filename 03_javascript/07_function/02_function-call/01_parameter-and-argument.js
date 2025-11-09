/**
 * # [07_Function (함수) / 02_Function-Call]
 * # 01_parameter-and-argument (매개변수와 인수)
 */

// 함수 선언문
function hello(name) {  // 'name'은 매개변수(parameter)

    console.log(name);

    // 모든 인수는 암묵적으로 arguments 객체의 프로퍼티(키:값 형식)로 보관된다.
    console.log(arguments);

    return `${name}님 안녕하세요!`;

}
// - 매개변수는 함수 몸체 내부에서만 참조할 수 있다.
// console.log(name);  // -> ReferenceError: name is not defined

// - 함수 선언문은 함수의 이름으로 호출한다
// - 전달하는 값을 '인수(argument)'라고 한다.
var result = hello(`판다`); // 가변인자 함수 구현 시 유용하게 사용된다.
console.log(result);    // -> 판다님 안녕하세요!

// - 인수가 부족해서 할당되지 않은 매개변수의 값은 undefined이다.
result = hello();       // -> undefined
console.log(result);    // -> undefined님 안녕하세요.

// - 매개변수보다 인수가 더 많은 경우 초과된 인수('판다')는 무시된다.
result = hello('코알라', '판다');  // -> 코알라
console.log(result)               // -> 코알라님 안녕하세요! [Arguments] { '0': '코알라', '1': '판다' }

// - 인수를 전달하지 않았을 경우, ES6에서 도입된 매개변수 기본값('호랑이')을 사용할 수 있다.
function hi(name = '호랑이') {
    return `${name} 안녕~`;
}
result = hi();
console.log(result);    // -> 호랑이 안녕~