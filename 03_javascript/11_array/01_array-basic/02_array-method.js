// # [11_array \ 01_array-basic]
// # 02_array-method

const foods = ['짜장면', '샌드위치', '우동'];
console.log(foods); // [ '짜장면', '샌드위치', '우동' ]

// #### push(): 맨 뒤 값 추가하기
foods.push('탕수육');
foods.push('곱창');
console.log(`push 후: ${foods}`)    // 짜장면,샌드위치,우동,탕수육,곱창


// #### pop(): 맨 뒤 값 때어내기
foods.pop();
console.log(`pop 한번: ${foods}`);  // pop 한번: 짜장면,샌드위치,우동,탕수육
const food = foods.pop();    // 제거한 값을 반환한다.    // 탕수육
console.log(`pop 두번: ${foods}`);  // pop 두번: 짜장면,샌드위치,우동
console.log(food)   // 탕수육

// #### unshift(): 맨 앞에 값을 추가한다.
foods.unshift('후라이드치킨');
foods.unshift('양꼬치');
console.log(`unshift 후: ${foods}`); // unshift 후: 양꼬치,후라이드치킨,짜장면,샌드위치,우동

// #### shift(): 맨 앞의 값을 제거한다.
foods.shift();
console.log(`shift 후: ${foods}`);  // shift 후: 후라이드치킨,짜장면,샌드위치,우동

// #### indexOf(값): 특정 값이 있는 '첫 번째 인덱스'를 알려준다. 없으면 -1을 반환한다.
// #### includes(값): 특정 값이 있는지 여부만 true/false로 알려준다.
// // 현재 [후라이드치킨, 짜장면, 샌드위치, 우동]
console.log(foods.indexOf('짜장면'));   // 1

// 같은것이 여러개 있어도 첫 번째 인덱스를 표시
foods.push('짜장면');
console.log(foods); //  1

console.log(foods.indexOf('짜장면'));   // 1
console.log(foods.indexOf('돈까스'));   // -1

console.log(foods.includes('샌드위치')); // true
console.log(foods.includes('삼겹살'));  // false

// MDN(Mozilla Developer Network)에서 'Array' 검색하면 모든 메서드 설명을 볼 수 있다.