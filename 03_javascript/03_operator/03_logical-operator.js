/**
 * # 03_Logical-Operator
 * 논리 연산자는 여러 조건을 결합하여 하나의 논리적 결과를 도출한다.
 * 논리 연산자는 AND, OR, NOT 연산자가 있다.
 */

var a = true;
var b = false;

// ## 1. 논리 AND (&&)
// - a와 b가 모두 true일 때만 true
console.log(a && b); // false

// ## 2. 논리 OR (||)
// - a 또는 b 중 하나만 true이면 true
console.log(a || b); // true

// ## 3. 논리 NOT (!)
// - true이면 false로, false이면 true로 반전
console.log(!a);    // false
console.log(!b);    // true

/**
 * ## 단축 평가
 * 표현식을 평가하는 도중 평가 결과가 확정 된 경우 나머지 평가 과정을 생략하는 것
 */

console.log('apple' || 'banana'); //apple
// 'apple'이 이미 Truthy 값이므로 true로 평가되고, 논리 연산의 결과를 결정한 첫 번쨰 피연산자 apple을 그대로 반환한다.

console.log(false || 'banana'); // banana
// 즉, 논리 연산의 결과를 결정한 것을 반환한다.

console.log('apple' && 'banana'); // banana
// AND의 경우 좌항, 우항 모두 확인해야 하므로 논리 연산의 결과를 결정하는 두번째 피연산자 banana를 그대로 반환한다.

console.log(false && 'banana'); //false
// 여기서도 평가 과정이 생략되어 false를 반환한다.

// ### 단축 평가 사용 예시
var obj = null;
// var val = obj.value; //TypeError: Cannot read properties of null (reading 'value')
// // 에러 방지(Null Check)
var val = obj && obj.value; // null은 falsy한 값. obj가 false이기 때문에 뒤의 값을 사용하지 않기에 아무것도 실행되지 않음.
// // if(obj !== null) 과 같은 긴 코드를 대체하고, 프로그램이 멈추는 것을 막을 수 있다.
// // 치명적 단점이라면 의미가 있는 0이나 의도가 있는 null 등 까지 문제로 인식할 수 있음.