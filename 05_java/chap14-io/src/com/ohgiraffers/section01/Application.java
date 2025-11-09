package com.ohgiraffers.section01;

import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        /* I/O -> input / output */

        /*
        * 파일 클래스를 이용해서 인스턴스를 생성한다.
        * 대상 파일이 존재하지 않아도 인스턴스를 생성할 수 있다.
        * */
        File file = new File("src/com/ohgiraffers/section01/test.txt"); // new File(경로) : 아직 존재하지 않는 파일에 대한 신청서

        // 실제 파일 생성
        // .createNewFile은 file이 성공적으로 생성됐는지에 따라 boolean 값을 반환한다.
        // .createNewFile은 IOException을 던지기 때문에 tryCatch로 예외 처리를 해야한다.
        try {
            boolean createSuccess = file.createNewFile();   // 첫 실행 시 true, 다시 실행시 이미 file이 존재하기에 false를 반환
            System.out.println(createSuccess); // 생성 결과를 확인
        } catch (IOException e) {
            e.printStackTrace();
        }

        // .length : 파일의 크기 확인
        // .getPath : 파일의 경로
        // .getAbsolutePath : 파일의 절대경로(최상위 부터 표시)
        System.out.println("파일의 크기 : " + file.length() + "byte");
        System.out.println("파일의 경로 : " + file.getPath());
        System.out.println("파일의 절대 경로 : " + file.getAbsolutePath());

        // .delete : 파일의 삭제 여부에 따라 t/f를 반환
        boolean deleteSuccess = file.delete();
        System.out.println(deleteSuccess);
    }

}
