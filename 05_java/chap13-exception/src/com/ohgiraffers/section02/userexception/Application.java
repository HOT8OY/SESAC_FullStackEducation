package com.ohgiraffers.section02.userexception;

import com.ohgiraffers.section02.userexception.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userexception.exception.NegativeException;
import com.ohgiraffers.section02.userexception.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userexception.exception.PriceNegativeException;

public class Application {
    public static void main(String[] args) {

        /* catch 블록은 항상 '구체적인 지식 타입 -> 포괄적인 부모 타입' 순서로 작성해야 한다!!
        * '|'를 사용하여 한번에 비슷한 예외를 처리할 수 있음*/

        /* finally : try 블록에서 예외가 발생하든, 발생하지 않든 '반드시' 실행되는 코드 블록
          - 주로 자원 반납(예: DB 연결 종료, 파일 닫기)과 같이 항상 수행되어야 하는 코드를 작성 */

        ExceptionTest et = new ExceptionTest();

        try {
//            et.checkEnoughMoney(30000, 50000);  // 정상인 경우
            et.checkEnoughMoney(-30000, 50000);  // 상품 가격이 음수일 때
//            et.checkEnoughMoney(30000, -50000);  // 가진 돈이 음수일 때
//            et.checkEnoughMoney(50000, 30000);  // 가진 돈이 가격보다 적을 때
        } catch (PriceNegativeException | MoneyNegativeException e) {
            // "가격 음수" 또는 "가진 돈 음수"이면, 모두 여기서 처리
            // multicatch : 하나의 catch에서 다양한 에러를 처리하는 것!
            System.out.println("진단명 : " + e.getClass() + "발생!! " + e.getMessage());
//        } catch (PriceNegativeException e) {
//            System.out.println("진단명 : " + e.getClass() + "발생!! " + e.getMessage());
//        } catch (MoneyNegativeException e) {
//            System.out.println("진단명 : " + e.getClass() + "발생!! " + e.getMessage());
        } catch (NotEnoughMoneyException e) {
            System.out.println("진단명 : " + e.getClass() + "발생!! " + e.getMessage());
        }
        // catch 블록은 항상 '구체적인 지식 타입 -> 포괄적인 부모 타입' 순서로 작성해야 한다!!
        // (포괄적인 부모 타입을 먼저 하면, 자식 타입에서 catch할 일이 없어지기 때문)
        catch(NegativeException e) {
            System.out.println("음수 익셉션 발생!!");
        } catch (Exception e) {
            // 혹시 모를 남은 모든 예외를 잡는 최종 안전망
            e.printStackTrace();
        } finally {
            // try 블록에서 예외가 발생하든, 발생하지 않든 '반드시' 실행되는 코드 블록
            // 주로 자원 반납(예: DB 연결 종료, 파일 닫기)과 같이 항상 수행되어야 하는 코드를 작성
            System.out.println("계산이 끝나 영수증을 출력합니다.");
        }

        System.out.println("프로그램을 정상적으로 종료합니다.");

    }
}
