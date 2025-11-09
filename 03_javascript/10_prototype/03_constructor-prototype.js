// # [10_Prototype]
// # 03_constructor-prototype

const studentHQ = {
    activate: true,
    login: function() {
        console.log(`${this.name}님 로그인 되었습니다.`);
    }
};

function Student(name) {
    this.name = name;
}

// 생성자 함수로 새로 만들어질 객체를 바라볼 프로토타입 객체를 지정
Student.prototype = studentHQ;

// new 연산자를 사용해 만든 객체는 생성자 함수의 프로토타입 정보를 사용해 [[Prototype]]을 설정한다.
// - student1.__proto__ == studentHQ;
const student1 = new Student('판다');
const student2 = new Student('코알라');

student1.login();   // -> 판다님 로그인 되었습니다.
student2.login();   // -> 코알라님 로그인 되었습니다.