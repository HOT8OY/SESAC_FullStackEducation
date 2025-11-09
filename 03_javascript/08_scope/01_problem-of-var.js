/**
 * # [08_Scope]
 * # 01_problem-of-var (var함수의 문제점)
 * ES5까지 사용되던 var 키워드는 세 가지 주요 문제점을 가지고 있다.
 */
// ## 1. 변수 중복 선언 허용 -> 코드의 신뢰성 하락
var msg = '안녕하세요';
console.log(msg);   // -> 안녕하세요
var msg = '안녕히 가세요~';
console.log(msg);   // -> 안녕히 가세요~ 두번째 내용으로 덮어씌워졌다

// ## 2. 함수 레벨 스코프 -> 의도치 않은 변수 오염
var i = 100;    // 중요한 전역 변수
for (var i = 0; i < 5; i++) {   // for문 안에서 var로 선언하면 위의 전역변수에 영향을 미친다
    console.log('for문 내부의 i:', i)   // -> for문 내부의 i: 0~4
}
console.log('for문 바깥의 i:', i);  // -> for문 내부의 i: 5

// ## 3. 변수 호이스팅 -> 코드의 가독성 및 예측 가능성 저하
console.log(test);  // -> undefined (원래는 선언문 위에 있기에 reference error가 나와야 함.)
test = '반갑습니다.'
var test;           // 선언이 가장 위로 끌어올려진 것처럼 동작함
console.log(test);  // -> '반갑습니다.'