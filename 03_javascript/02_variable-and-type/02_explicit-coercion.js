/**
 * # 명시적 타입 변환 (Explicit Coercion)
 * 개발자의 의도에 따라 값의 타입을 변환하는 것이다.
 * 자바스크립트에서 기본 제공하는 표준 빌트인 생성자 함수(String, Number, Boolean)
 * new 연산자 없이 호출하는 방법,
 * 빌트인 메서드를 사용하는 방법, 암묵적 타입 변환을 이용하는 방법이 있다.
 */

// [문자열 타입으로 변환]

// 1. String 생성자 함수를 new 연산자 없이 호출
// 어떤 값이 들어올지 모를 때 가장 안전하게 쓸 수 있는 방법
console.log(String(10));    // "10"
console.log(String(true));  // "true"
console.log(String(null));  // "null"

// 2. toString 메서드 사용
console.log((10).toString()); // "10"
// console.log((null).toString()); // TypeError: Cannot read properties of null

// 3. 문자열 연결 연산자 이용 - [01_암묵적 변환 챕터]에서 확인함

// ## 숫자 타입으로 변환

// ### 1. Number 생성자 함수를 new 연산자 없이 호출
// - 완벽히 숫자로 변환할 수 있을 때만 작동
console.log(Number('10'));  // 10
console.log(Number(false)); // 0
console.log(Number('10원')); //NaN

// ### 2. parseInt, parseFloat 함수 이용
// - int(정수),float(실수)
// - 문자열 -> 숫자만 가능
// - 숫자로 변환 가능한 것만 변환되고 그 외의 것은 버려짐
console.log(parseInt('10.01'));     // 10
console.log(parseFloat('10.01'));   // 10.01
console.log(parseInt('10원'));      // 10

// ### 3. + 단항 산술 연산자 이용 - [01_암묵적 변환 챕터]에서 확인함.

// ## [불리언 타입으로 변환]
/**
 * - Falsy (false, undefined, null, 0, NaN, '')는 false로,
 * 나머지는 모두 true로 바꿔주는 방법입니다.
 * - Falsy 규칙을 그대로 적용.
 */


// ### 1. Boolean 생성자 함수를 new 연산자 없이 호출하는 방법
console.log(Boolean('JavaScript')); // true
console.log(Boolean(NaN));          //false

// ### 2. ! 부정 논리 연산자를 두번 사용하는 방법
console.log(!'JavaScript')  // false
console.log(!!'JavaScript') // true
console.log(!undefined)    // true
console.log(!!undefined)    // false
