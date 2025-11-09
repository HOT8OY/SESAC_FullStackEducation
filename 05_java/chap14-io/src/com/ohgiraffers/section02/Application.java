package com.ohgiraffers.section02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        /* [ FileInputStream ]
        * FileInputStream : File로부터 데이터를 1바이트씩 읽어오는 스트림. 한글은 3바이트이므로 한글을 읽어오면 깨짐.
        * 주요 대상 : 모든 종류의 파일(이미지, 영상, 텍스트) */
        // 프로젝트 패키지 내에 파일 생성 -> testInputStream.txt 생성
        // FileInputStream은 FileNotFoundException을 throw 하기 때문에 예외를 처리해야 한다.
        FileInputStream fin = null; // try블럭 안에 선언하면 지역변수로 취급되어 하단의 finally 에서 인지하지 못 하기에 여기에 선언

        try {
            fin = new FileInputStream("src/com/ohgiraffers/section02/testInputStream.txt");

            int value; // 파일로부터 값을 받아와 담아둘 변수

            // .read() : 파일에 기록된 값을 순차적으로 1바이트씩 읽어온다. 더 이상 읽을 데이터가 없으면 -1을 반환
            // .read()도 Exception을 throw 하기에 처리 필요 -> while에 catch를 추가할 것
            // while문 = 1바이트씩 읽어와서 하나씩 출력하는 문
            while((value = fin.read()) != -1) {
                System.out.println(value);  // 숫자값으로 읽어오기 때문에 97,98,99 이런식으로 출력됨
                System.out.println((char)value); // 강제형변환 하여 char형식으로 가져옴 | a b c d e
                                                    // 한글은 3바이트로 되어있기 때문에 .read를 사용하면 값이 깨져서 출력된다!
            }
            // .length() : 파일의 길이 확인
            System.out.println("파일의 길이 : " + new File("src/com/ohgiraffers/section02/testInputStream.txt").length());

            // 파일의 길이 만큼의 byte 배열을 만든다.
            int filesize = (int) new File("src/com/ohgiraffers/section02/testInputStream.txt").length();
            byte[] bar = new byte[filesize];

            // 파일의 내용을 읽어서 byte 배열에 기록해준다.
            fin.read(bar);

            // for문으로 byte 배열을 읽어와서 확인
            for(int i = 0; i < bar.length; i++) {
                System.out.println((char)bar[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 항상 사용이 끝난 stream은 반드시 닫아서 자원들 반환해야 한다!
            // .close 도 Exception 처리 필요
            if(fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
