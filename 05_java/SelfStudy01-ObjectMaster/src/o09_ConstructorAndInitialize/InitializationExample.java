package o09_ConstructorAndInitialize;

public class InitializationExample {
    public static void main(String[] args) {
        System.out.println("=== 첫 번째 Company 객체 생성 ===");
        Company company1 = new Company("삼성");

        System.out.println("\n=== 두 번째 Company 객체 생성 ===");
        Company company2 = new Company("LG");

        System.out.println("\n생성된 회사 수: " + Company.companyCount);
    }
}

class Company {
    // 1. 필드 선언 시 초기화
    String name;
    String location = "서울";  // 필드 선언과 동시에 초기화

    // 2. static 변수
    static int companyCount = 0;  // 모든 객체가 공유하는 변수

    // 3. static 초기화 블록
    // 클래스가 처음 로딩될 때 단 한 번만 실행됨
    static {
        System.out.println("static 초기화 블록 실행");
        companyCount = 0;
        // static 블록에서는 인스턴스 변수에 접근 불가!
        // name = "test";  // 에러!
    }

    // 4. 인스턴스 초기화 블록
    // 생성자보다 먼저 실행됨
    // 객체가 생성될 때마다 실행됨
    {
        System.out.println("인스턴스 초기화 블록 실행");
        location = "서울";  // 기본 위치 설정
        companyCount++;     // 회사 수 증가
    }

    // 5. 생성자
    Company(String name) {
        System.out.println("생성자 실행");
        this.name = name;
    }
}

/*
실행 순서:
1. 클래스 로딩 시 (프로그램 실행 후 첫 사용 시 한 번만):
   - static 변수 초기화
   - static 초기화 블록 실행

2. 객체 생성 시 (new Company(...) 호출 시마다):
   - 인스턴스 변수 초기화
   - 인스턴스 초기화 블록 실행
   - 생성자 실행

출력 결과:
static 초기화 블록 실행
=== 첫 번째 Company 객체 생성 ===
인스턴스 초기화 블록 실행
생성자 실행

=== 두 번째 Company 객체 생성 ===
인스턴스 초기화 블록 실행
생성자 실행

생성된 회사 수: 2
*/

