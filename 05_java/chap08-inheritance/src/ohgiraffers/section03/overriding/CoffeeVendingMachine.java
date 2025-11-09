package ohgiraffers.section03.overriding;
// VendingMachine의 자식
public class CoffeeVendingMachine extends VendingMachine{

    /* [ 오버라이딩 규칙 ] */

    /* [ 오버라이딩 성공 조건 ]
    * 메소드 이름, 반환타입, 매개변수 목록이 모두 부모와 동일해야 한다.
    * 접근제한자는 부모와 같거나 더 넓어야 한다.
    * ( private < default < protected < public )
    *
    * [ 오버라이딩 불가 대상 ]
    * 1. private 메소드(자식에게 보이지 않음)
    * 2. final 메소드(변경이 금지됨)
    * 3. 생성자 (상속되지 않음) (section01,02에서 한건 상속이 아닌 super로 불러냈다는것을 명심)
    * */

    // 모든 규칙(이름, 반환타입, 파라미터)을 지켜서 오버라이딩
    // @Override : 컴파일 단계에서 정확히 오버라이딩 되었는지 체크해줌
    @Override
    public String vend() {
        return "따뜻한 아메리카노";
    }

    // 규칙 위반1 : 메소드 이름이 다른 경우(단순히 새로운 메소드 추가)
//    @Override                     // 규칙을 위반하여 여기에 빨간색 밑줄 생성됨
//    public String vendMachine() {
//        return "음료수";
//    }

    // 규칙 위반2 : 반환타입이 다르면 오버라이딩 할 수 없다.
//    @Override
//    public int vend() {     // 부모의 반환타입인 String이 아닌 int를 반환하기에 int에 빨간색 밑줄이 생성됨.
//        return 100;
//    }

    // 규칙 위반3 : 메게변수(파라미터)가 다르면 오버라이딩이 아니다. (오버로딩에 해당)
//    @Override                     // 규칙을 위반하여 여기에 빨간색 밑줄 생성됨
//    public String vend(String type){
//        return type;
//    }

    // 규칙 위반4 : private 메소드는 오버라이딩 할 수 없다.
//    @Override                     // 규칙을 위반하여 여기에 빨간색 밑줄 생성됨
//    private void checkStock() {}

    // 규칙 위반5 : final 메소드는 '절대 변경 불가'를 의미하므로 오버라이딩 불가
//    @Override
//    public final void powerOn() {}

    // 규칙위반6 : 접근제한자는 부모보다 좁은 범위로 변경할 수 없다
    // 부모랑 동일하진 않아도 되지만 좁은 범위는 불가
//    @Override
//    protected void clean(){}    // 같은 범위라서 가능
//    void clean(){}  // default 접근 제한자가 protected보다 좁은 범위이므로 에러 발생

    // 접근제한자가 더 넓은 범위로 변경은 가능
    @Override
    public void clean() {
        System.out.println("내부를 스팀으로 청소합니다.");
    }
}
