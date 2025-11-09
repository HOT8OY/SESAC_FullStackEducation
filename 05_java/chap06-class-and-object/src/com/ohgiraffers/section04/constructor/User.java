package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class User {

    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;  // 날짜 관련

    /*
    * [ 생성자 ]
    * new 연산자를 통해 객체가 메모리(heap)에 생성될 때, 가장 먼저 단 한번 호출되는 초기화 메소드
    *
    * [ 사용목적 ]
    * 객체의 필드를 원하는 값으로 '초기화(처음 값을 주는 것)'
    *
    * [ 작성규칙 ]
    * - 이름이 클래스명과 반드시 동일해야 한다.
    * - 반환 타입(void, int 등)을 적지 않는다.
    *
    * 접근제한자 클래스명(매개변수) {
    *    인스턴스 생성 시점에 수행할 명령(주로 필드 초기화)
    *    this.필드명 = 매개변수;
    * [ 생성자 오버로딩 ]
    * 생성자의 이름은 같지만 매개변수가 다르기 때문에 들어온 값으로 구분하여 알아서 작동된다.
    * 매개변수를 4개 받은 생성자 함수에 4개가 아닌 3개만 넣어서 호출하는건 불가능 하다.
    * 즉 입력받아야 할 데이터를 강제화 할 수 있다는 것이다.

    * }
    * */

    // 1. 기본 생성자 (매개변수가 없는 생성자)
    // 클래스에 생성자가 하나도 없을 경우, 컴파일러가 눈에 보이지 않는 기본생성자 코드를 자동으로 추가해준다.
    // 때문에 우리가 지금까지 기본 생성자 작성 없이 new User()를 이용해 객체를 생성할 수 있었다.
    // ※ 유의할 점 : 코드 내에 매개변수 있는 생성자가 하나라도 있을경우 컴파일러가 기본생성자를 자동으로 추가해주지 않는다!
    public User() {
        System.out.println("User 클래스의 기본생성자 호출됨...");
    }

    // 2. 매개변수 있는 생성자
    public User(String id, String pwd, String name) {
        // this: '생성된 객체 자기 자신'을 가리키는 키워드
        this.id = id;   // 우측의 id : 입력받은 값
        this.pwd = pwd; // 입력받은 값을 객체 안에 넣음
        this.name = name;
        System.out.println("id, pwd, name을 초기화하는 생성자 호출...");
    }

    // 3. 모든 필드를 초기화 하는 생성자
    public User(String id, String pwd, String name, java.util.Date enrollDate) {
        /*
        * [ this() 생성자 ]
        * 같은 클래스 내의 다른 생성자를 호출할 때 사용한다.
        * 반드시 생성자 내부의 가장 첫 줄에 작성해야 한다. */
        this(id, pwd, name);    // id pwd name을 채우는걸 이걸로 초기화.
        this.enrollDate = enrollDate;
        System.out.println("모든 필드를 초기화하는 생성자 호출됨...");

    }



    // alt + insert 버튼으로 getter와 setter를 간단 생성 가능
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    // 위의 get을 한번에 조회할 수 있도록 만든 것
    public String getInformation() {
        return "User [id=" + this.id + ", pwd=" + this.pwd + ", name=" + this.name + ", enrollDate=" + this.enrollDate + "]";
    }
}
