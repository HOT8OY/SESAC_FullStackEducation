/**
 * # [07_Function (함수) / 03_Various-Types-of-Functions]
 * # 01_first-class-function (일급 객체)
 * 자바 스크립트에서 함수는 '값(value)'으로 취급될 수 있다.
 */

// ## 1. 함수는 값이기 때문에 함수 자체(function(){})를 변수에 담을 수 있다. (함수 표현식)
var sayHello = function() {
    console.log('안녕!!');
}
sayHello(); // -> 안녕!!

// ## 2. 객체의 속성으로 담을 수 있다. 객체의 속성으로 들어있는 함수는 (메서드)라고 부른다.
var myObject1 = {
    sayHi: function() {
        console.log('반가워~');
    }
};
myObject1.sayHi();  // -> 반가워~

// 최신 문법으로 아래와 같이 단축해서 사용 가능하다.
// - function 키워드를 생략 가능
var myObject2 = {
    sayBye() {
        console.log('잘가~');
    }
};
myObject2.sayBye(); // -> 잘가~

// ## 3. 함수의 인자(arugument)로 전달할 수 있다.
// ## 4. 함수의 결과(return value)로 반환될 수 있다.
function manager(task, count){
    console.log('매니저가 업무를 지시합니다.');
    for(let i = 0; i < count; i++) {
        task();
    }
    return function(){  // 함수를 결과물로 반환
        console.log('모든 업무가 완료되었습니다.');
    }
}
manager(sayHello, 3);   // -> 안녕!! 3번 반복

// sayHello 함수를 인자로 전달
// manager 함수가 반환한 새로운 함수를 실행
var report = manager(sayHello, 3);
report();   // -> 안녕!!*3, 모든 업무가 완료되었습니다.
