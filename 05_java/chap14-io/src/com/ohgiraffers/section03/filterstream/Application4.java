package com.ohgiraffers.section03.filterstream;

import com.ohgiraffers.section03.filterstream.dto.MemberDTO;

import java.io.*;

public class Application4 {
    public static void main(String[] args) {

        /* 객체단위 입출력 보조스트림 (ObjectOutputStream / ObjectInputStream)
        * 객체를 통째로 파일에 저장하고, 객체를 통째로 파일로부터 읽어오는 스트림. */
        // MemberDTO

        // 객체배열 생성
        MemberDTO[] outputMembers = {
                new MemberDTO("user01", "pass01", "홍길동", 25, 1250.7),
                new MemberDTO("user02", "pass02", "이순신", 49, 1000.2),
                new MemberDTO("user03", "pass03", "유관순", 16, 1489.3)
        };

        /* [ ObjectOutputStream ] */

        try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("src/com/ohgiraffers/section03/filterstream/testObjectStream.txt"))) {
            for (MemberDTO mem : outputMembers) {
                objOut.writeObject(mem);    // writeObject로 객체를 통째로 쓴다!
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* [ ObjectInputStream ] */

        try(ObjectInputStream objIn = new ObjectInputStream(new FileInputStream("src/com/ohgiraffers/section03/filterstream/testObjectStream.txt"))) {

            while(true) {
                // readObject로 객체를 통째로 읽는다.
                System.out.println((MemberDTO)objIn.readObject());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {  // EOFException 핸들링은 따로 추가할 것!
            System.out.println("끝!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
