/**
 * 원시 데이터 타입
 * 자바 스크립트에는 원시타입 이라는 기본적인 데이터 타입들이 있다.
 * 숫자(number), 문자열(string), 불린(boolean), null, undefined 등이 있다.
 */

// 숫자(number)
// 하나의 숫자 타입만 존재하고 모든 수를 실수로 처리한다.
var age = 30;
console.log(age);

// 문자열
// 문자열 타입은 텍스트 데이터를 나타내는데 사용한다.
// 문자열은 작은 따옴표(''), 큰 따옴표(""), 또는 백틱(``)으로 텍스트를 감싼다.
// var string : 변수 선언
// = "문자열"; : 값을 입력
var string = "문자열";
console.log(string)

// 불린(Boolean): 논리적 참, 거짓을 나타내는 true와 false 뿐이다.
var isStudent = true;
console.log(isStudent);

// null: 명시적으로 값이 없음을 의도적으로 명시할 때 사용한다.
var address = null;
console.log(address);

// undefined: 변수에 값이 할당되지 않았을 때 자동으로 할당되는 값
var salary;
console.log(salary);

// typeof: 데이터 타입을 확인할 때 사용
console.log(typeof age);
console.log(typeof string);
console.log(typeof isStudent);
// 자바스크립트의 첫 번째 버전의 버그
// type이 null로 나와야 하나 object로 나옴
console.log(typeof address);
console.log(typeof salary);

/**
 * 템플릿 리터럴
 * ES6부터 도입 된 멀티라인 문자열, 표현식 삽입 등의 편리한 문자열 처리 기능을 제공하는 문자열 표기법
 * 작은 따옴표, 큰 따옴표 대신 백틱(``)을 사용해 표현한다.
 */
// 일반 문자열 내에선 줄바꿈이 허용되지 않는다.
// var str = '안녕하세요.
// 반갑습니다.';

// 백틱을 사용하면 줄바꿈이 허용되고 모든 공백이 있는 그대로 적용된다.
var multiline = `안녕하세요.
반갑습니다.`;
console.log(multiline);

// 문자열은 문자열 연산자 +를 사용해 연결할 수 있다.
var lastName = '홍';
var firstName = '길동';
console.log('제 이름은 ' + lastName + firstName + '입니다.')

// 표현식 삽입(반드시 백틱 내에서 사용해야 한다.)
console.log(`제 이름은 ${lastName}${firstName}입니다.`); 


