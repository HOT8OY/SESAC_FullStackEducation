// # [11_array \ 01_array-basic]
// # 01_array
// ## array(배열)
// 배열은 여러 개의 값을 순차적으로 나열한 자료구조이다.

// ## 배열 리터럴을 통해 배열 생성
// [배열]내부의 값들을 '요소'라고 부른다.
const fruits = ['바나나', '복숭아', '키위'];

// 배열의 요소는 자신의 위치를 나타내는 인덱스를 가지며 배열의 요소에 접근할 때 사용된다.
// 바나나:0 / 복숭아:1 / 키위:2
console.log(fruits[0]); // 바나나
console.log(fruits[2]); // 키위

// 배열은 요소의 개수, 즉 배열의 길이를 나타내는 length 프로퍼티를 갖는다.
console.log(fruits.length); // 3

// 배열은 인덱스와 length 프로퍼티를 갖기 때문에 for문을 통해 순차적으로 요소에 접근할 수 있다.
for(let i = 0; i < fruits.length; i++){
    console.log(fruits[i])  // 바나나 / 복숭아  / 키위
};

// typeof를 이용하여 객체인지 확인
console.log(typeof fruits); // object