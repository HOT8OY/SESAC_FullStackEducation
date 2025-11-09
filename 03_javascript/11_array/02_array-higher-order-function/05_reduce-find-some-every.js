// # [11_array \ 02_array-higher-order-function]
// # 05_reduce-find-some-every

/**
 * #### reduce: 배열의 모든 값을 순회하며 하나의 최종 결과로 만듭니다. (ex: 총합 구하기)
 * #### find: 조건을 만족하는 첫 번째 요소 하나만 찾아옵니다.
 * #### some: 조건을 만족하는 요소가 하나라도 있는지 확인합니다. (true/false)
 * #### every: 모든 요소가 조건을 만족하는지 확인합니다. (true/false)
 */

const numbers = [1, 2, 3, 4, 5];

// ###### reduce - 모든 요소의 합 구하기
// - accumulator(누적값)
// - current(현재값)
// - 0: 맨 처음 accumulator에 들어있을 초기값
const sum = numbers.reduce((accumulator, current) => accumulator + current, 0);
console.log(sum);   // 15

// ###### find - 보다 큰 첫 번째 숫자 찾기
const foundNumber = numbers.find(num => num > 3);
console.log(foundNumber);   // 4

// ###### some - 짝수가 하나라도 있는지?
const hasEven = numbers.some(num => num % 2 === 0);
console.log(hasEven);   // true

// ###### every - 모든 숫자가 0보다 큰지?
const allPositive = numbers.every(num => num > 0);
console.log(allPositive);   // true
