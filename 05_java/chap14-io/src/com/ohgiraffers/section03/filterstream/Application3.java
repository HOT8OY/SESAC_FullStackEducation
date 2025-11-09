package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application3 {
    public static void main(String[] args) {
        /* 데이터입출력 보조스트림 (DataInputStream / DateOutputStream)
        * 자바의 기본 자료형 그대로 파일에 쓰고, 그대로 읽어오고 싶을 때 사용 */

        /* [ DataOutputStream ] */
        try(DataOutputStream dout = new DataOutputStream(new FileOutputStream("src/com/ohgiraffers/section03/filterstream/score.txt"))) {

            // write를 쓰는데 자료형에 맞는 메소드를 사용
            dout.writeUTF("홍길동");    // 문자열
            dout.writeInt(95);          // 정수
            dout.writeChar('A');        // 문자
            dout.writeUTF("이순신");
            dout.writeInt(87);
            dout.writeChar('B');
            dout.writeUTF("김철수");
            dout.writeInt(73);
            dout.writeChar('C');

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /* [ DataInputStream ] */
        try(DataInputStream din = new DataInputStream(new FileInputStream("src/com/ohgiraffers/section03/filterstream/score.txt"))) {


            while (true) {
                // 읽어올 땐 썻던 순서(UTF, int, char)대로 읽어와야 한다.
                System.out.println(din.readUTF() + ", " + din.readInt() + ", " + din.readChar());
                // 더 이상 읽어올 게 없으면 .EOFException 발생
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {  // 파일의 끝에 도달하면 발생하는 정상적인 예외
            System.out.println("파일 읽기 완료!!"); // .EOFException은 IOException 보다 좁은 범위이기에 IOException 보다 위에 설정.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
