/*
1. 클래스와 메서드 정의
- Animal 클래스를 정의하고 name과 sound를 속성으로 갖습니다.
- Animal 클래스는 sound를 출력하는 speak 메서드를 가집니다.
- Animal 클래스를 상속받은 Dog 클래스를 정의하고,
- Dog 클래스에 새로운 속성을 추가해 보세요.
- Dog 클래스에 Animal 클래스의 speak 메서드를 재정의(오버라이딩) 합니다.
- Dog 클래스를 통해 객체를 생성하고 speak 메서드를 호출하세요.
*/

class Animal {
    constructor(name, sound) {
        this.name = name;
        this.sound = sound;
    }
    speak () {
        console.log(`${this.name}이 ${this.sound}라고 포효합니다.`)
    }
}
const animalDog = new Animal('백구', '왈왈');
animalDog.speak(animalDog); // 백구이 왈왈라고 포효합니다.

class Dog extends Animal {
    constructor(name, sound, breed) {
        super(name, sound); // 부모 클래스(Animal)의 constructor를 호출하여 상속된 속성을 초기화
        this.breed = breed;
    }
    speak() {   // 부모의 speak 메서드를 재정의(오버라이딩)
        console.log(`${this.breed}인 ${this.name}가 ${this.sound} 짖습니다!`);
    }
}
const myDog = new Dog('바둑이', '멍멍', '진돗개');
myDog.speak();  // 진돗개인 바둑이가 멍멍 짖습니다!



/*
2. Getter와 Setter 활용
- Rectangle 클래스를 정의하고 width와 height 속성을 갖습니다.
- 면적을 계산하는 getter인 `area`를 추가하세요.
- width 또는 height를 변경할 수 있도록 setter를 추가하세요.
- Rectangle 클래스를 통해 객체를 생성하고 면적을 출력한 뒤 width를 변경하고 다시 면적을 출력하세요.

예시 출력:
면적: 50
변경 후 면적: 75
*/

// 1) 클래스 정의 및 속성 정의
class Rectangle {
    constructor (width, height) {
        this._width = width;
        this._height = height;
    }
    // 2) 면적 계산 'area' getter
    get area() {
        return this._width * this._height
    }
    // 3) setter를 통한 유효성검사 및 값 변경
    set width(newWidth) {  
        if (newWidth > 0) {
            this._width = newWidth;
        } else {
            console.log("너비는 0보다 커야 합니다.")
        }
    }
    set height(newHeight) {
        if (newHeight > 0) {
            this._height = newHeight;
        } else {
            console.log("높이는 0보다 커야 합니다.")
        }
    }
}
// 4) 객체 생성 & 출력
const rect = new Rectangle(5, 10);
console.log(`면적: ${rect.area}`); // 면적: 50
rect.width = 15;
console.log(`변경 후 면적: ${rect.area}`); // 변경 후 면적: 150

/*
3. Rest 파라미터와 Spread 문법 활용
- 두 개의 함수 sumAll과 mergeArrays를 작성하세요.
  1. sumAll 함수는 가변 인수를 받아 모든 숫자의 합을 반환합니다.
  2. mergeArrays 함수는 두 개의 배열을 인수로 받아 두 배열을 합친 새 배열을 반환합니다.
- 두 함수를 각각 호출하여 결과를 출력하세요.

예시 출력:
합계: 15
병합된 배열: [1, 2, 3, 4, 5, 6]
*/
function sumAll(...numbers) {
    let sum1 = 0;
    for (let number of numbers) {
        sum1 += number;
    }
    return sum1;
};
console.log(sumAll('합계: ', ...[1, 2, 3, 4, 5, 6]));


function mergedArrays(arr1, arr2) {
    return [...arr1, ...arr2];
};
const arrA = [1, 2, 3];
const arrB = [4, 5, 6];
const arrAB = mergedArrays(arrA, arrB);
console.log('병합된 배열: ', arrAB); // 병합된 배열:  [ 1, 2, 3, 4, 5, 6 ]


/*
4. 구조분해 할당 활용
- user 객체를 생성하고 name, age, location 속성을 초기화합니다.
- 구조분해 할당을 사용하여 name과 age를 추출하고 이를 이용해 "name은 age살입니다." 형태의 문장을 출력하세요.

임의의 배열을 리터럴로 생성하고,
- 구조분해 할당을 사용하여 배열에서 첫 번째 요소와 나머지 요소를 분리하여 출력하세요.

예시 출력:
홍길동은 30살입니다.
첫 번째 요소: 1
나머지 요소: [2, 3, 4, 5]
*/
const user = {
    name: '고라니',
    age: 7,
    location: 'forest'    
};
const {name, age} = user;
console.log(`${name}은 ${age}살입니다.`) // 고라니은 7살입니다.

const animal = [ '사자', '고양이', '돼지'];
const [animalFirst, ...animalExtra] = animal;
console.log(animalFirst); // 사자
console.log(animalExtra); // [ '고양이', '돼지' ]

/*
5. 클래스와 구조분해 할당을 활용한 학생 관리 시스템
- Student 클래스를 정의하고 name, age, score 속성을 추가하세요.
- 3명의 학생 데이터를 가진 배열 students를 생성하세요.
- 구조분해 할당을 사용하여 학생들의 이름과 점수만 배열로 추출하여 출력하세요.

예시 출력:
학생 이름: [유관순, 홍길동, 장보고]
학생 점수: [90, 80, 70]
*/
class Student {
    constructor (name, age, score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
};
const students = [  // {객체}를 담은 [배열]을 생성
    new Student ('유관순', 16, 90),
    new Student ('홍길동', 22, 80),
    new Student ('장보고', 44, 70)
];
// map은 배열을 반복
const studentNames = students.map(function({name}) {return name;});
const studentScores = students.map(function({score}) {return score;});
// 구조분해 할당을 하지 않았다면
// const studentNames1 = students.map((student) => student.name);

console.log('학생 이름: ', studentNames);
console.log('학생 점수: ', studentScores);