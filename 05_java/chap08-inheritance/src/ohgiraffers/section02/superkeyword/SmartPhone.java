package ohgiraffers.section02.superkeyword;
// 자식
public class SmartPhone extends Product {

    // 고유필드를 하나 추가
    private boolean isFoldable;
    private String agency;
    // 부모 필드 포함 모든 필드를 초기화하는 생성자
    public SmartPhone (String code, String name, int price, boolean isFoldable, String agency) {
        super(code, name, price);
        this.isFoldable = isFoldable;
        this.agency = agency;
        System.out.println("SmartPhone 생성자 호출됨");
    }
    // 부모의 getInformation() 메소드 오버라이딩
    @Override
    public String getInformation(){
//        String parentInfo = super.getInformation();
//        String smartPhoneInfo = ", SmartPhone [isFoldable= " + isFoldable + ", agency= " + agency + "]";
//        return parentInfo + smartPhoneInfo;
        // 짧다면 이렇게도 가능
        return super.getInformation() + ", SmartPhone [isFoldable= " + isFoldable + ", agency= " + agency + "]";
    }

}
