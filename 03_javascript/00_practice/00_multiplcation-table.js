// 배운것을 활용하여 구구단을 출력하시오.

for (let i = 1; i <= 9; i++) {
    for (let j = 1; j <= 9; j++) {
        // console.log(i + " * " + j + " = " + (i * j)); // 일반 문자열 사용
        // console.log(`${i} * ${j} = ${i * j}`);          // 템플릿 리터럴 사용
        console.log(`${i} 곱하기 ${j}는 ${i * j}입니다.`)
    }
}