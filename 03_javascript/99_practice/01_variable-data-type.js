// [문제 1] 변수 선언과 데이터 타입
/*
1. 이름(name), 나이(age), 주소(address)를 저장할 수 있는 변수를 선언하고 값을 할당하세요.
2. 각 변수를 콘솔에 출력하세요.
3. typeof를 이용해 데이터 타입을 확인 해보세요.
*/

const name1 = "홍길동";
const age1 = 45;
const address1 = "서울시 용산로2길 22";
console.log(name1, age1, address1);
console.log(typeof name1);   // string
console.log(typeof age1);    // number
console.log(typeof address1);   // string


// [문제 2] 객체 생성 및 속성 다루기
/*
1. 학생 정보를 저장하는 객체를 만드세요. 객체에는 다음 속성을 추가하세요:
   - 이름(name): 문자열
   - 학번(studentId): 숫자
   - 전공(major): 문자열
2. 객체의 각 속성 값을 콘솔에 출력하세요.
3. 새로운 속성 '학년(year)'을 추가하고 값을 할당하세요.
4. '전공(major)' 속성을 삭제하세요.
5. 최종 객체를 출력하세요.
*/

const student = {name : "홍길동", studentId : 251024, major : "Special Thief Expert"};
console.log(student);
student.year = 4;
delete student.major;
console.log(student);   // { name: '홍길동', studentId: 251024, year: 4 }


// [문제 3] 배열과 배열 메소드 활용
/*
1. 좋아하는 음식 목록을 배열로 만드세요. 배열에는 최소 5개의 음식 이름이 들어가야 합니다.
2. 다음 작업을 수행하세요:
   - 배열에 새로운 음식을 추가하세요.
   - 배열의 마지막 음식을 제거하세요.
   - 배열의 첫 번째 음식을 제거하세요.
   - 배열의 첫 번째에 새로운 음식을 추가하세요.
3. 최종 배열을 콘솔에 출력하세요.
*/

const favoriteFood = ['딸기', '당근', '수박', '참외', '메론'];
favoriteFood.push('바나나');
favoriteFood.pop();
favoriteFood.shift();
favoriteFood.unshift('파프리카');
console.log(favoriteFood); // [ '파프리카', '당근', '수박', '참외', '메론' ]


// [문제 4] forEach와 배열 탐색
/*
1. 숫자 배열을 만드세요. (예: [10, 20, 30, 40, 50])
2. forEach 메소드를 사용하여 각 숫자를 2배로 만들어 새로운 배열에 저장하세요.
3. 최종 배열을 콘솔에 출력하세요.

hint : 새로운 빈 배열 생성해두기
			 배열 메서드인 push()와 *(곱하기)연산자 활용
*/

let nums = [10, 23, 25, 32, 44]
const doubledNums = []; // 빈 배열 생성
nums.forEach ((num) => {
   doubledNums.push(num * 2);
});
console.log(doubledNums); // [ 20, 46, 50, 64, 88 ]

// [문제 5] 객체 배열 다루기
/*
1. 3명의 학생 정보를 저장하는 객체 배열을 만드세요. 각 객체는 다음 속성을 가져야 합니다:
   - 이름(name): 문자열
   - 학년(grade): 숫자
   - 점수(score): 숫자
   
2. 다음 작업을 수행하세요:
   - 모든 학생의 정보를 콘솔에 출력하세요.(foreach 활용)
   ex) 이름: 홍길동, 학년: 1학년, 점수: 75
*/

const students = [
   {name: '김도둑', grade: 4, score: 86},
   {name: '박괴도', grade: 3, score: 96},
   {name: '낙제생', grade: 1, score: 65}
];
students.forEach ((student) => {
   console.log(`이름: ${student.name}, 학년: ${student.grade}, 점수: ${student.score}`);
});
