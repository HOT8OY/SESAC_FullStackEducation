/**
 * # 05_Continue-Break
 * ### continue: 현재 반복문의 나머지 코드를 건너뛰고, 다음 반복으로 넘어간다.
 * ### break: 현재 반복문을 완전히 종료한다.
 * 
 * 이 두 가지 문은 반복문의 흐름을 제어하는 데 매우 유용하며,
 * 특정 조건에서 반복을 건너뛰거나 중단해야 할 때 사용된다.
 */
// ### continue 예시
for(let i = 1; i <= 10; i++){
    if(i % 2 === 0) {
        continue;   // i가 짝수라면 밑의 console.log(i)를 건너뛰고 위의 i++로 이동
    }
    console.log(i); // 홀수만 출력
}

// ### break 예시
for (let i = 1; i <= 10; i++) {
    if(i > 5) {     // 5를 초과하면 아예 반복문에서 탈출한다
        break;
    }
    console.log(i) // 1~5까지 출력 후 for문 종료
}

// ### 중첩반복문 continue 예제
for (let i = 0; i <= 3; i++) {
    for (let j = 1; j <= 3; j++) {
        console.log(`i: ${i}, j: ${j}`);    // i: 0 j:1~3까지 증가 후 i: 1 j:1~3 까지 증가. ~ i:3 j:3까지 되어서 끝남.
    }
}

for(let i = 0; i <= 3; i++) {
    for (let j = 1; j <= 3; j++) {
        if (j === 2) {
            continue;   // j가 2일 때 현재 반복만 건너뜀->j++로 감.
        }
        console.log(`i: ${i}, j: ${j}`);    // 결과 0,1/0,3/1,1/1,3/2,1/2,3/3,1/3,3
    }
}

// ### break를 사용한 중첩 반복문 예제

for(let i = 0; i <= 3; i++) {
    for (let j = 1; j <= 3; j++) {
        if (j === 2) {
            break;  // 현재 반복문을 빠져나가 바깥쪽 반복문의 증감식으로 간다
        }
        console.log(`i: ${i}, j: ${j}`);    // 결과 0,1/1,1/2,1/3,1
    }
}
// ### break를 사용하여 종료될 반복문 지정
outerLoop: for(let i = 0; i <= 3; i++) {
    for (let j = 1; j <= 3; j++) {
        if (j === 2) {
            break outerLoop;  // 종료될 반복문을 outerLoop로 지정함
        }
        console.log(`i: ${i}, j: ${j}`);    // 결과 0,1
    }
}

// ### for...of 반복문(ES6)
// 이는 배열이나 이터러블(iterable) 객체의 각 요소를 순회하는 데 사용
const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9];

for (const number of numbers) {
    console.log(number);
}