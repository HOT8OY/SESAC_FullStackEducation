/**
 * # 02_property-accessor
 */
var dog = {
    name : '뽀삐',
    eat : function(food) {
        console.log(`${this.name}는 ${food}을 맛있게 먹어요.`)
    }
}

// ## 마침표 표기법
console.log(dog.name);  // dog의 name에 접근. -> 뽀삐
dog.eat('개껌'); // -> '뽀삐는 개껌을 맛있게 먹어요.'

// ## 대괄호 표기법
// 프로퍼티 키는 반드시 따옴표로 감싼 문자열을 사용한다.
console.log(dog['name'])    // -> 뽀삐
dog['eat']('간식')  // -> 뽀삐는 간식을 맛있게 먹어요.

// ### 대괄호 표기법을 써야할 때
// - key가 변수에 담겨 있을 때
var propName = 'name';
// dog.propName 이라고 쓰면 'propName'이라는 키를 찾으려 한다.(undefined)
// 변수에 담긴 키 값을 이용해 동적으로 프로퍼티에 접근할 때 유용하게 쓰인다.
console.log(dog[propName])  // dog['name']과 같음 -> 뽀삐

// ## in 연산자
// 프로퍼티 '존재' 여부 확인하기
console.log("name" in dog); // -> true
console.log("age" in dog);  // -> false | dog객체 안에 age라는 키가 없기 때문.

// ## for in 반복문
// 객체의 모든 프로퍼티 키 순회
for (var key in dog) {
    console.log(`key : ${key}`); // key : name, key : eat
    console.log(`dog[${key}] : ${dog[key]}`);   // 키에 해당하는 값
    // dog.key 라고 쓰면 'key'라는 이름의 프로퍼티 키를 찾으려 해서 안된다. 
}