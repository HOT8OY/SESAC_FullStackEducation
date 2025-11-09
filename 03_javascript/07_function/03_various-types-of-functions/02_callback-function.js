/**
 * # [07_Function (함수) / 03_Various-Types-of-Functions]
 * # 02_callback-function (콜백 함수)
 * ## 함수의 핵심 활용: 콜백 함수(Callback Function)
 * 함수가 '일급 객체'이기 때문에 가능한 가장 실용적인 활용법이다.
 * 다른 함수의 '재료'로 전달되어, 그 함수의 실행 시점을 제어하는 함수이다.
 */

// #### 고차 함수 : 함수를 인자로 받는 함수(그 자체만으론 기능하진 않음)
function calculator(calculateCallback, a, b){
    console.log('계산을 시작합니다.');
    const result = calculateCallback(a, b);
    return result
}

// #### 콜백 함수들
function add(a, b){ // 자바스크립트 내부에선 var add function add(a, b){}로 저장되어있기 때문에 'add'만으로 호출 가능
    return a + b
}
function multiply(a, b){
    return a * b
}

// 고차 함수에 콜백 함수를 '재료'처럼 전달
var addResult = calculator(add, 10, 5);
console.log('덧셈 결과:', addResult);       // -> 계산을 시작합니다. / 덧셈 결과: 15
var multiplyResult = calculator(multiply, 10, 5);
console.log('곱셈 결과:', multiplyResult);  // -> 계산을 시작합니다. / 곱셈 결과: 50

// #### 프로그램에 기본 저장되어있는 고차함수
const numbers = [3, 10, 1, 4, 2];

// .sort() 라는 고차함수에 '정렬 기준'을 담은 콜백 함수를 전달합니다.
numbers.sort(function(a,b){
    // a - b가 음수면 a가 앞으로, 양수면 b가 앞으로 정렬. 0 이면 그대로 둔다.
    // 즉 음수면 a가 더 크다는 것, 양수면 b가 더 크다는 것.
    return a - b;   // 오름차순 정렬 기준
//    return b - a;   // 내림차순 정렬 기준
});
console.log(numbers);   // -> [ 1, 2, 3, 4, 10 ]
// console.log(numbers);   //  -> [ 10, 4, 3, 2, 1 ]