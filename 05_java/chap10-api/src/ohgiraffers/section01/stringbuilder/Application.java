package ohgiraffers.section01.stringbuilder;

public class Application {
    public static void main(String[] args) {

        // String의 비효율성 측정

        long startTime = System.nanoTime();     // 성능 측정 시작

        String str = "";
        for (int i = 0; i < 50000; i++) {   // 문자열이 합쳐지며 객체가 50000개가 생긴다
            str += i;
        }
        
        long endTime = System.nanoTime();       // 작업이 끝난 시간 기록

        System.out.println("String : " + (endTime - startTime));    // 788835300
        // String : 불변
        // StringBuilder : 가변을 이용한 효율적인 작업을 한다.
        // .append()는 기존 객체의 공간을 늘려 문자열을 추가하므로,
        // 반복문 안에서 문자열을 합칠 때 String 보다 월등히 빠른 성능을 보인다.
        // 따라서 잦은 문자열 변경이 예상될 때는 StringBuilder를 사용하는 것이 좋다.

        startTime = System.nanoTime();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 50000; i++){        // append를 이용해서 문자열을 추가.
            sb.append(i);
        }

        endTime = System.nanoTime();
        System.out.println("StringBuilder : " + (endTime - startTime)); // 2788700


        // string builder에서 제공하는 기능을 알아보자.
        StringBuilder sb2 = new StringBuilder("javamysql");

        /* delete(start, end) : 시작 인덱스부터 종료 인데스 '전까지'의 문자열을 제거한다. */
        System.out.println(sb2.delete(4,9));    // java

        /* insert(index, value) : 지정한 인덱스에 값을 삽입한다. */
        System.out.println("insert() " + sb2.insert(0, "my")); // myjava

        /* reverse() : 문자열의 순서를 뒤집는다. */
        System.out.println("reverse() " + sb2.reverse());   // avajym

        // 최종 결과물을 우리에게 익숙한 String 타입으로 변환
        String resert = sb2.toString();
    }

}
