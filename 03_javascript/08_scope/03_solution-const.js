/**
 * # [08_Scope]
 * # 03_solution-const
 * const=constant
 * const함수는 let의 장점을 모두 가지면서, '재할당 금지'라는 강력한 규칙이 추가된 키워드이다.
 */

// ## const 사용 규칙
// ## 1. 선언과 동시에 반드시 초기화를 해야한다.
// const GREETING; //'const' declarations must be initialized.
const GREETING = '안녕하세요';

// ## 2. 재할당이 금지된다.
// GREETING = '안녕히 가세요'; // -> TypeError: Assignment to constant variable

// #### const와 객체
const student = {
    name: '판다',
    age: 5
};

// student 변수를 다른 객체로 '바꿔치기'하는 것은 불가능하다.
// student = { name: '홍길동', age: 20 };  // -> TypeError: Assignment to constant variable.

// 겍체 내부의 내용물(프로퍼티)을 변경하는 것은 가능하다.
student.name = '코알라';
console.log(student);   // { name: '코알라', age: 5 } 내용물이 판다에서 코알라로 변경되었다.