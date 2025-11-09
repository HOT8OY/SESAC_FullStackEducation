package ohgiraffers.section02.superkeyword;
// 자식 클래스
public class Computer extends Product {
    // 자식 자신만의 필드를 가질수도 있음
    private String cpu;
    private int ram;

    // 기본 생성자
    public Computer() {
        super();    // 부모 클래스의 기본 생성자 호출. 컴파일러가 자동으로 추가
        System.out.println("Computer 가본 생성자 호출");
    }

    // 매개변수 있는 생성자
    public Computer(String code, String name, int price, String cpu, int ram) {
        super(code, name, price); // super()에 인자를 전달하면 부모의 매개변수 있는 생성자를 호출. super호출은 맨 첫줄에 쓰여야 한다.
        this.cpu = cpu;           // 같은 클래스의 생성자를 호출하는 this()는 super()랑 같이 쓸 수 없다. super()를 두번 호출하는것과 같기 때문.
        this.ram = ram;
        System.out.println("Computer 클래스의 부모 필드도 초기화하는 생성자 호출함");
    }

    // getter, setter
    // 부모한테 있는 getter, setter는 다시 추가할 필요는 없다.
    // 자식의 것만 추가하면 됨.
    public String getCpu() {
        return cpu;
    }
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }
    public int getRam() {
        return ram;
    }
    public void setRam(int ram) {
        this.ram = ram;
    }

    // 부모의 getInformation을 Override
    @Override
    public String getInformation() {
        // 부모(Product)에게 있는 '모든걸 반환하는 메소드'를 호출
        // super.getInformation() 부모가 만들어주는 문자열을 먼저 가져온다.
        // 여기서 super();를 생략하게 되면 StackOverflowError가 발생함.
        // this.getInformation();로 변하면서 자신의 것을 무한히 불러오기 때문(재귀호출).
        String parentInfo = super.getInformation();
        // 자식 클래스 필드 정보를 덧붙여 완전한 정보를 만든다
        String computerInfo = ", Computer [cpu=" + cpu + ", ram=" + ram +"]";
        return parentInfo + computerInfo;

    }

}
