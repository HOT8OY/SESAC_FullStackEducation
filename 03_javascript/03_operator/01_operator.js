/**
 * # [03 - 연산자(Operator)]
 * 연산자(Operator)는 두 개 이상의 값을 조작하거나 비교하여 결과를 생성하는 기호이다.
 * 자주 사용되는 연산자에는 산술 연산자, 할당 연산자, 증감 연산자 등이 있다.
 */

// ## 1. 산술 연산자
var a = 10;
var b = 3;
console.log(a + b); // 13
console.log(a - b); // 7
console.log(a * b); // 30
console.log(a / b); // 3.3333335
console.log(a % b); // 1 (나머지)
console.log(a ** b); // 1000 (거듭제곱)

// ## 2. 할당 연산자
var c = 5;
c += 3; // c = c + 3 (C에다 3을 더한것을 C에 할당)
c -= 3; // c = c - 3

// ## 3. 증감 연산자
var d = 5;
// - ++ 는 1을 더하겠다는 의미
console.log(d++);   // 5 (후위 증가(출력은 5,d에 저장된 값은 6))
console.log(++d);   // 7 (전위 증가(d에 저장된 값은 7, 출력도 7))
console.log(--d);   // 6 (전위감소(d에 저장된 값은 6, 출력도 6))
console.log(d--);   // 6 (후위감소(출력은 6, d에 저장된 값은 5))
