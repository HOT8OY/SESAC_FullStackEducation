// # [10_Prototype]
// # 01_prototype-basics
// 자바스크립트의 모든 객체는 [[Prototype]]이라는 '연결고리'를 가지고 있다.
// 이 연결고리는 다른 객체를 가리킬 수 있는데, 이 대상을 '프로토타입'이라고 부른다.

const user = {
    activate: true,
    login: function() {
        console.log('로그인 되었습니다.');
    }
};

const student = {
    passion: true
};

const greedyStudent = {
    activate: false
};

// student의 프로토타입을 user로 설정합니다.
// student는 user의 기능을 빌려 쓸 수 있게 된다.
student.__proto__ = user;

// greedyStudent에서 로그인 기능을 탐색(없음)->student에서 탐색(없음)->user에서 탐색(있음)
greedyStudent.__proto__ = student;

// student 객체에 activate 프로퍼티가 없으면, 연결된 user에서 찾아본다.
console.log(student.activate);  // -> true

student.login();    // -> 로그인 되었습니다.
greedyStudent.login();

console.log(student.passion);   // -> true
console.log(greedyStudent.activate);    // -> false