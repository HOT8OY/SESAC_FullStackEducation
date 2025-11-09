/**
 * # 암묵적 타입 변환 (Implicit Coercion)
 * 자바스크립트 엔진에 의해 암묵적으로 타입이 자동 변환 되는것을 암묵적 타입 변환 이라고 한다. 
 */

// 문자열 타입으로 변환

// 문자열 연결 연산자로 동작
// 문자열 타입이 아닌 피연산자를 문자열 타입으로 암묵적으로 변환한다.
console.log(10 + '20'); // 1020으로 출력됨.

console.log(true + '');
console.log(null + '');
console.log(undefined + ''); // true, null, undefined 등 전부 문자열로 반환됨.

// 숫자 타입으로 변환

// 산술 연산자의 피연산자는 모두 숫자여야함으로
// 숫자가 아닌 피연산자를 숫자 타입으로 암묵적 타입 변환한다.
console.log(10 - '5'); // 5
console.log(10 * '5'); // 50
console.log(10 / '5'); // 2
console.log(10 % '5'); // 0 (%는 나머지를 반환하는 기호. 10/5의 나머지를 반환)

// + 단항 연산자는 피연산자가 숫자 타입이 값이 아니면 숫자 타입의 값으로 암묵적 타입 변환
console.log(+'javascript') // NaN : Not a Number
console.log(+true)  // 1
// 빈 문자열(''), 빈 배열([]), null, false는 0으로 true는 1로 변환
// 객체와 undefined는 변환되지 않아 NaN

// 불리언 타입으로 변환

// 자바스크립트 엔진은 불리언 타입이 아닌 값을 Truthy 값(참으로 평가되는 값)
// 또는 Falsy 값(거짓으로 평가되는 값)으로 구분한다.

/**
 * Falsy한 값 (false로 평가되는 값.이것 외에는 Trusy한 값이니 전부 외울 것.)
 * false
 * 0 (숫자 0)
 * '' (빈 문자열)
 * null
 * undefined
 * NaN (Not a Number)
 * 이 값들은 조건문이나 논리 연산자에서 **false**로 평가된다.
 */

if(true) console.log("if(true)");
if('') console.log("if('')");
