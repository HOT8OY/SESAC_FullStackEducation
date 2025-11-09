// # [04_spread-syntax]
// # 01_rest-and-spread
// [Rest 파라미터와 스프레드 문법]
// 똑같이 점 세 개(...)를 사용하지만, 쓰이는 위치에 따라 정반대의 역할을 한다.
// - Rest(나머지) Parameter: 여러 개의 값을 하나의 배열로 '모으기'
// - Spread(펼치기) Parameter: 하나의 배열을 여러 개의 값으로 '펼치기'

/**
 * [Rest Parameter]
 * 함수의 '매개변수' 자리에 사용하여, 정해지지 않은 개수의 인수들을
 * 하나의 '베열'로 모아서 받습니다.
 */

// Rest 파라미터는 반드시 매개변수 목록의 가장 마지막에 위치해야 한다.
function merge(first, ...args) {    // first 이외의 것들이 배열로 담겨서 출력된다.
    console.log(`첫 번째 : ${first}`);
    console.log(`나머지 : `, args);
// for..of를 사용하여 배열을 하나씩 출력하게 함.
    let message = first;
    for (let arg of args) {
        message += arg;
    }
    return message;
}

merge('안녕하세요', '반갑습니다.');
merge('안녕하세요', '반갑습니다', '저는 판다입니다.');  // 기존에는 정해진 것 보다 추가하면 나머지는 무시가 되었다.
console.log(merge('안녕하세요 ', '반갑습니다 ', '저는 판다입니다.')); // 안녕하세요 반갑습니다 저는 판다입니다.

/**
 * [Spread Syntax]
 * 함수의 '인구' 자리나, 배열/객체 리터럴 안에서 사용하여
 * 배열의 요소들을 개별 값의 목록으로 펼쳐준다.
 */

// ## 1. 함수 인수로 사용하기
const numbers = [10, 20, 30];
// Math.max는 배열이 아닌 낱개의 숫자들을 인수로 받는다. Math.max(10, 20, 30)
console.log(Math.max(numbers)); // NaN | 배열을 통째로 넣었기 때문
// ...numbers는 [10, 20, 30]을 10, 20, 30으로 펼쳐준다.
console.log(Math.max(...numbers)); // 30

// ## 2. 배열 리터럴에서 사용하기 (배열 합치기/복사)
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];

// #### 배열 합치기
const mergedArray = [...arr1, ...arr2, 7, 8];
console.log('병합된 배열', mergedArray); // 병합된 배열 [ 1, 2, 3, 4, 5, 6, 7, 8 ]

// #### 배열 '얕은 복사(값만 복사)'
// 값은 복사되어 같지만 각자 가지는 주소값은 엄밀히 다르다.
const arr1Copy = [...arr1]
console.log('원본 배열', arr1); // 원본 배열 [ 1, 2, 3 ]
console.log('복사된 배열', arr1Copy); // 복사된 배열 [ 1, 2, 3 ]
console.log('두 배열은 같은가', arr1 === arr1Copy); // 두 배열은 같은가 false
// 따라서 복사된 배열에 값을 넣어도 원본 배열에 영향을 주진 않는다.
arr1Copy.push(4);
console.log('원본 배열', arr1); // 원본 배열 [ 1, 2, 3 ]
console.log('복사된 배열', arr1Copy); // 복사된 배열 [ 1, 2, 3, 4 ]

// ## 3. 객체 리터럴에서 사용하기 (객체 합치기/복사)
const obj1 = {name:'홍길동', age: 20};
const obj2 = {job: '개발자'};

// #### 객체 합치기
const mergedObject = {...obj1, ...obj2, location: '서울'};
console.log('병합된 객체', mergedObject); // 병합된 객체 { name: '홍길동', age: 20, job: '개발자', location: '서울' }

// #### 객체 '얕은 복사'
const obj1Copy = {...obj1};
obj1Copy.age = 30; // 복사본을 변경해도 원본은 바뀌지 않는다 
console.log(obj1Copy); // { name: '홍길동', age: 30 }
console.log(obj1); // { name: '홍길동', age: 20 }