// # [03_iterable]
// # 01_iterable (이터러블)

/** ## [이터러블]
 * ES6에서 도입된, '순회 가능한' 데이터 컬렉션을 위한 통일된 규약입니다.
 * 배열, 문자열, NodeList, Map, Set 등은 모두 이 규약에 따릅니다.
 * 
 * 이터러블의 가장 큰 특징은 'for...of' 반복문을 사용할 수 있다는 것입니다.
 */

// #### 배열 순회
const array = ['사과', '바나나', '딸기'];
// 기존에는 for(let i = 0; i < array.length; i++){console.log(item);}
for (const item of array) {
    console.log(item);
}

// #### 문자열 순회
const string = "안녕하세요"
for (const char of string) {
    console.log(char);
}

/**
 * 이터러블 : 순회 가능한 규약을 따르는 객체 (for...of 가능)
 * 유사 배열 : 인덱스와 length 프로퍼티가 있어서 배열처럼 '생긴' 객체.
 * 
 * 둘은 서로 다른 개념이며, for...of가 안되는 유사 배열 객체도 있다.
 */

// 유사 배열 객체
const arrayLike = {
    0: "배열인듯",
    1: "배열아닌",
    2: "배열같은너",
    length: 3
};
// for (const item of arrayLike) {
//     console.log(item); // TypeError: arrayLike is not iterable
// };


/**
 * ##[Array.from: 배열 변환기]
 * 이터러블이든, 유사 배열 객체든 모두 우리가 다루기 편한 '진짜 배열'로 변환할 수 있다.
 */
const realArray = Array.from(arrayLike);
// 배열 메서드를 사용할 수 있다.
console.log(realArray); // [ '배열인듯', '배열아닌', '배열같은너' ]
console.log(realArray.pop());