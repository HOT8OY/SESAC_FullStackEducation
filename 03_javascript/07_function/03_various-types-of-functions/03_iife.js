/**
 * # [07_Function (함수) / 03_Various-Types-of-Functions]
 * # 03_iife (즉시 실행 함수)
 */

// 일반적인 함수는 정의하고, 호출해야 실행된다.
function sayHi() {
    console.log('일반 함수 Hi!!')
}
sayHi();

// #### 즉시 실행 함수
// 즉시 실행 함수: 함수를 정의하자마자 딱 한 번만 실행되는 '일회용 함수'입니다.
// 즉시 실행 함수는 소괄호()안에 작성 후 마지막에 소괄호() 추가. 이름이 필요 없음.
// 즉시 실행 함수 안에서 선언된 변수는 외부에서 절대 접근할 수 없다.
// '독립된 작업 공간'을 만드는 것과 같다.
// 즉시 실행 함수: (즉시실행함수)()
(function() {
    const secretMessage = "이 변수는 이 안에서만 존재합니다.";
    console.log('즉시 실행 함수가 실행되었습니다~!');
    console.log(secretMessage);
})();

// 즉시실행함수는 즉시실행함수 바깥에서 사용 불가
// console.log(secretMessage);     // -> ReferenceError: secretMessage is not defined

/**
 * ### 즉시 실행 함수를 왜 사용할까?
 * - 변수 이름 충돌 방지: 내가 만든 변수 이름이 다른 라이버러리나 코드와 겹치는 것을 막아줍니다.
 * - '전역 스코프'를 오염시키지 않기 위해 사용합니다. (중요!)
 */

const result = (function(){
    let a = 10;
    let b = 20;
    return a + b;
})();
console.log(result);    // -> 30