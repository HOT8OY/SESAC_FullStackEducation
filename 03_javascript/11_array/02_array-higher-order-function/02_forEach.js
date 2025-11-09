// # [11_array \ 02_array-higher-order-function]
// # 02_forEach

// #### forEach: 배열의 각 요소에 대해 콜백 함수를 실행합니다. 반환 값은 없습니다.

const names = ['호랑이', '기린', '늑대'];

// for 반복문을 이용
for(let i = 0; i < names.length; i++) {
    console.log(names[i]);
}

// forEach 버전
names.forEach(animal => console.log(animal));   // names.forEach(function(animal){console.log(animal)});

// 콜백 함수는 요소의 값, 인덱스, 배열 자체를 인자로 받을 수 있다.
names.forEach((name, index, array) => {
    console.log(`${index + 1}번째 이름: ${name}`);  // n번째 이름: OO
})