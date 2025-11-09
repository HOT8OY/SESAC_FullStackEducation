/**
 * # [07_Function (함수) / 02_Function-Call]
 * # 02_return(반환문)
 */

// ### return(반환문)
// - 반환문은 return 키워드 뒤에 오는것을 반환한다.
function hello(name) {
    return `${name}님 안녕하세요~`
    // console.log(name); // -> // 반환문 이후의 문은 실행되지 않고 무시된다.
}
// 리턴 키워드 뒤에 오는 값을 반환한다.
console.log(hello('다람쥐'));   // -> 다람쥐님 안녕하세요~


// 반환 값을 명시적으로 지정하지 않으면 undefined가 반환된다.
// 또는 반환문(return)을 생략할수도 있다. 이때도 암묵적으로 undefined를 반환한다.
function func() {
    console.log('함수가 호출되었습니다.')
    return;
}
console.log(func()) // -> 함수가 호출되었습니다. / undefined

