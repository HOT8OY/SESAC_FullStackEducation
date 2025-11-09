/**
 * # [08_Scope]
 * # 04_scope-summary
 */
// #### 전역 변수
// 가장 넓은 스코프
let globalVar = '전역 변수';    // 가장 넓은 스코프

// #### 블록 스코프 변수, 함수 스코프 변수
if (true) {
    let blockVar = '블록 스코프 변수'   // if문 안에서만 유효
    function sayHi() {
        let functionVar = '함수 스코프 변수' // sayHi 안에서만 유효
        // 가장 안쪽에선 바깥의 모든 함수를 사용 가능
        console.log(globalVar);
        console.log(blockVar);
        console.log(functionVar);
    }
    sayHi();
    console.log(globalVar);
    console.log(blockVar);
//    console.log(functionVar);   // 함수 밖에서는 접근 불가 -> ReferenceError: functionVar is not defined
}
console.log(globalVar);
// console.log(blockVar);  // 블록 밖에서는 접근 불가 -> ReferenceError: blockVar is not defined
// console.log(functionVar);

/**
 * ## 변수 사용 원칙
 * #### 원칙 1
 * 기본적으로 모든 변수는 const로 선언한다. (가장 안전)
 * #### 원칙 2
 * 값이 반드시 바뀌어야만 하는 변수에만 let을 사용한다.
 * #### 원칙 3
 * var는 이제 사용하지 않는다.
 */