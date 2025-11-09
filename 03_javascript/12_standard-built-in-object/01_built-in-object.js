// # [12_standard-built-in-object]
// # 01_built-in-object

// ## 표준 내장 객체
// 자바스크립트가 기본적으로 제공하는 유용한 객체들이다.

// #### String: 문자열 도구 상자
// 텍스트를 자르고, 붙이고, 검색하는 등 문자열을 다루는데 필수적인 기능 제공

// ###### 검색하기 - indexOf(), includes()
const myIntro = '안녕하세요! 제 이름은 판다입니다.';
console.log(myIntro.indexOf('이름'));   // 9 | '이름'이라는 단어가 몇 번째에 표함되어 있는가?
console.log(myIntro.includes('나이'));  // false | '나이'라는 단어가 포함되어 있는가?

// ###### 잘라내기 - slice(), substring()
// slice는 숫자에도 가능하지만 substring은 문자열에만 사용 가능하다.
const fileName = 'my-profile.jpg'
console.log(fileName.slice(11)); // jpg | slice 뒤의 숫자는 index 기준 n번째 부터 끝까지 잘라온다.
console.log(fileName.slice(-3)); // jpg | - 를 붙이면 뒤에서 부터 잘라온다.
console.log(fileName.slice(3, 10)); // profile | 첫 숫자(start), 두번째 숫자(end)

// ###### 쪼개서 배열 만들기 - .split()
// 특정 문자열을 기준으로 쪼개서 배열을 만듦
const tags = "#자바스크립트#개발자#꿀팁#프론트엔드"
const tagArray = tags.split('#');
console.log(tagArray);  // [ '', '자바스크립트', '개발자', '꿀팁', '프론트엔드' ]

// #### 기타 유용한 도구들
const userId = "   USER123   "
// ###### .trim(): 문자열 앞/뒤 불필요한 공백 제거
console.log(userId);    //    USER123   
console.log(userId.trim()); // USER123
// ###### .toUpperCase(): 대문자
console.log(userId.toUpperCase());  //    USER123   
// ###### .toLowerCase(): 소문자로 바꾸기
console.log(userId.toLowerCase());  //    user123  


// #### Math: 숫자 도구
// 랜던 숫자 생성, 반올림 등 간단하지만 활용도 높은 숫자 기능들을 제공.

// ###### Math.random(): 랜덤 숫자 만들기
// 0 이상 1 미만의 랜덤한 소수를 반환합니다.
console.log(Math.random()); // 0.20290634047625966

// 응용: 1 ~ 45 사이의 랜덤 정수 만들기
// Math.floor는 소수점을 버림
const randomNumber = Math.floor(Math.random() * 45) + 1;
console.log(randomNumber);

// ###### Math.round(): 숫자 반올림/버림/올림
console.log(Math.round(3.14))   // 반올림   | 3
console.log(Math.floor(3.99))   // 소수점 버림 | 4
console.log(Math.ceil(3.01))    // 소수점 올림 | 4

// ###### Date(): 날짜와 시간을 다루는 기본적인 기능 제공
// 현재 날짜/시간 생성 및 정보 추출
const now = new Date();
console.log(now);   // 2025-09-30T05:12:36.640Z
// 특정 시간만 추출하고 싶다면
const year = now.getFullYear();
const month = now.getMonth() + 1;   // 월(Month)은 0부터 시작한다.
const date = now.getDate();
console.log(`${year}년 ${month}월 ${date}일`); // 2025년 9월 30일

// ###### 실무에서는 더 편리한 '날짜 전문 라이브러리'를 사용하는 경우가 많다.
// 예: Day.js, data-fns, Luxon