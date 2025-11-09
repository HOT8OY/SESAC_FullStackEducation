/**
 * # [04_Modern-Operator]
 * # 01_Optional Chaining Operator(옵셔널 체이닝 연산자)
 * ES11에서 도입된 연산자로 좌항의 피연산자가 null 또는 undefined인 경우 undefined를 반환하고, 그렇지 않으면 우항의 프로퍼티 참조를 이어간다.
 */

var obj = null;
// var val; = obj.value; // TypeError

// // ?를 붙여서 null인지 undefined인지 확인하여 뒤의 값을 반환
var val = obj?.value;
console.log(val); //undefined

// 옵셔널 체이닝 연산자 이전에는 논리연산자 &&를 사용한 단축 평가로 확인했었다.
// 그러나 빈 문자열과 같은 Falsy한 값을 false로 취급해서 생기는 문제가 있다.
var str = '';
console.log(str.length); // 0

// 빈 문자열과 같은 Falsy 값을 false로 취급해서 생기는 문제. 
var len = str && str.length;
console.log(len); // 의도한 길이인 0이 아닌 ''(빈 문자열)을 반환.

// // 빈 문자열은 null 또는 undefined가 아니므로 문자열의 길이 값이 담긴다.
var len = str?.length
console.log(len); // 0 