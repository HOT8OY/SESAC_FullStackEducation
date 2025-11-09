// # [11_array \ 02_array-higher-order-function]
// # 04_filter
// #### filter: 배열의 모든 요소에 대해 콜백 함수를 호출하고, 그 결과 true인 요소만으로 '새로운 배열'을 만든다.

const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

// 짝수만 걸러내기
const evenNumbers = numbers.filter(num => num % 2 === 0);
console.log(evenNumbers);   // [ 2, 4, 6, 8, 10 ]


// 점수가 95점 이상인것만 걸러내기
const students = [
    { name: '홍길동', score: 90 },
    { name: '유관순', score: 95}
];
const highScorers = students.filter(student => student.score >= 95);
console.log(highScorers);