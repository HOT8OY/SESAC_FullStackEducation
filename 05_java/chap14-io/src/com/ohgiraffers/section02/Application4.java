package com.ohgiraffers.section02;

import java.io.FileWriter;
import java.io.IOException;

public class Application4 {
    public static void main(String[] args) {
        /* FileWriter : 프로그램의 데이터를 1글자 단위로 파일로 내보내기 위한 스트림
        * 주요 대상 : 텍스트 파일(한글 등 다국어 처리 용이) */
        // 에러를 핸들링한다 = 에러를 처리한다
        try(FileWriter fw = new FileWriter("src/com/ohgiraffers/section02/testWriter.txt")) {
            // 아스키코드 to 문자
            fw.write(97); // a
            // 문자
            fw.write('A'); // A
            // 문자 배열로 문자 전송
            fw.write(new char[]{'a', 'p', 'p', 'l', 'e'}); // apple
            // 문자열도 가능
            fw.write("안녕하세요 반가워요");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
