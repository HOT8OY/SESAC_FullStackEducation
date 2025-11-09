package ohgiraffers.section01.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Application {
    public static void main(String[] args) {

        /* java.time 패키지는 날짜와 시간을 표현하는 여러 클래스를 제공한다.
        * - LocalDate : 날짜 정보만 표현 (예: 2025-12-25)
        * - LocalTime : 시간 정보만 표현 (예: 14:30:00)
        * - LocalDateTime : 날짜와 시간을 모두 표현 (예: 2025-12-25T14:30:00) */

        // .of : 해당 날짜나 시간을 저장.
        LocalDate departureDate = LocalDate.of(2025, 12, 25);
        LocalTime departureTime = LocalTime.of(14, 30);

        LocalDateTime trainDeparture = LocalDateTime.of(departureDate, departureTime);
        System.out.println("부산행 KTX 출발 시각 : " + trainDeparture); // 부산행 KTX 출발 시각 : 2025-12-25T14:30

        // .now : 현재 날짜와 시간
        LocalDateTime now = LocalDateTime.now();
        System.out.println("현재 시각 : " + now); // 현재 시각 : 2025-11-04T15:57:32.854462100

        /* get..() 메소드를 사용하여 날짜와 시간의 특정 필드(년, 월, 시, 분 등) 값을 가져올 수 있다. */
        System.out.println(trainDeparture.getYear());   // 2025
        System.out.println(trainDeparture.getMonth());  // DECEMBER
        System.out.println(trainDeparture.getMonthValue()); // 12
        System.out.println(trainDeparture.getDayOfWeek());  // THURSDAY

        /* plus...() 와 minus...() 메소드를 사용해서 시간계산을 할 수 있다.
        * java.time 객체는 불변이다. 원본 객체를 변경하지 않고, 계산된 새로운 객체를 반환한다. */
        LocalDateTime arrivalDeadline = trainDeparture.minusMinutes(20);  // 20분을 뺀 시간을 알려줌.
        System.out.println("늦어도 도착해야 하는 시간: " + arrivalDeadline);   // 늦어도 도착해야 하는 시간: 2025-12-25T14:10
        System.out.println("원본 출발 시간은 그대로인가? : " + trainDeparture); // 원본 출발 시간은 그대로인가? : 2025-12-25T14:30

        /* 날짜 비교하기 : isAfter(), isBefore(), isEqual() */
        // 비교후 값을 true, false 형태로 반환해줌.
        boolean isPast = trainDeparture.isBefore(now);
        System.out.println("기차 이미 떠났나요? : " + isPast);

        /* 포매팅
        * DateTimeFormatter를 사용하면 날짜/시간 객체를 원하는 형식의 문자열로 변환(format)하거나,
        * 특정 형식의 문자열을 날짜/시간 객체로 변환(parse)할 수 있다. */

        /*  Format: LocalDateTime -> String  */
        // 1. 원하는 출력 형식의 패턴을 만든다.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 출발");
        // 2. 날짜 객체에 format() 메소드를 호출하며 패턴 전달
        String ticket = trainDeparture.format(formatter);
        System.out.println("승차권 : " + ticket); // 승차권 : 2025년 12월 25일 14시 30분 출발

        /* Parse: String -> LocalDateTime */
        String christmasInput = "251225";   // yyMMdd 형식의 문자열
        // 1. 분석할 문자열의 패턴을 만든다
        DateTimeFormatter christmasParser = DateTimeFormatter.ofPattern("yyMMdd");
        // 2. LocalDate.parse() 메소드를 호출하여 문자열과 패턴 전달
        // .parse(넣을 문자열, 넣을 패턴)
        LocalDate parsedChristmas = LocalDate.parse(christmasInput,christmasParser);
        System.out.println("크리스마스 날짜 : " + parsedChristmas);    // 크리스마스 날짜 : 2025-12-25
    }
}
