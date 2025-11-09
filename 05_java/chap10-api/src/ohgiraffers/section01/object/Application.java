package ohgiraffers.section01.object;

public class Application {
    public static void main(String[] args) {

        /* java의 모든 클래스들은 Object라는 클래스를 상속받고 있다
           우리는 Object에서 제공하는 기능들을 이미 사용하고 있음
           toString(), equals(), hashCode() 등 */

        // 객체 생성
        Book book1 = new Book(1, "홍길동전", "허균", 50000);
        Book book2 = new Book(2, "목민심서", "정약용", 30000);
        Book book3 = new Book(2, "목민심서", "정약용", 30000);
        // book2와 book3은 내용은 같지만 서로 다른 heap영역에 만들어지기 때문에 별개의 객체다

        /* Object.toString() 기본기능은 '클래스명@해시코드'를 반환한다.
        * 사람이 보기에는 의미없는 정보이다. 따라서 객체의 필드 값을 보여주도록 어버라이딩 하여 사용한다. */
        System.out.println("book1 = " + book1); // toString 의 기본값 : book1 = ohgiraffers.section01.object.Book@2f4d3709
                                                // toString 오버라이딩 후 : book1 = Book{number=1, title='홍길동전', author='허균', price=50000}
        /*
        * object.equals()의 기본 기능은 '==' 연산과 같이 두 객체의 주소 값을 비교한다. (동일성 비교)
        * 하지만 때로는 주소가 달라도 필드의 내용이 같으면 '같다(동등하다)'고 판단해야 할 때가 있다.
        * 이런 '동등성 비교'를 위해 equals()를 오버라이딩 한다.
        * */
        System.out.println("동일성(주소값) 비교(==) : " + (book2 == book3));    // false
        System.out.println("동등성(내용) 비교(equals) : " + (book2.equals(book3))); // 기본 : false | equals 오버라이딩 후 : true

        /* 자바의 중요한 '일반 규약' : equals() 비교로 true를 반환한다면,
         두 객체의 hashCode() 값은 반드시 같아야 한다.
         나중에 배울 '자료구조' 기술에서 객체를 빠르고 효율적으로 찾기 위해 hashCode() 값으로 객체를 비교하는데
         만약 equals는 같다고 나오고 hashCode는 다르다면,
         컴퓨터가 이 두 객체를 완전히 다른것으로 착각하는 문제가 생길 수 있다.*/
        System.out.println(book2.hashCode());   // 1225358173   // 오버라이딩 후 -1740523887
        System.out.println(book3.hashCode());   // 1848402763   // 오버라이딩 후 -1740523887
    }
}
