package com.hw1.run;

import com.hw1.model.dto.Employee;
import com.hw1.model.dto.Student;

import java.util.Scanner;

// Run = Person(부모) -> Student(자식)
//                  └─> Employee(자식)
public class Run {
    public static void main(String[] args) {
        // 3명의 학생 정보를 기록할 수 있게 객체 배열 할당
        // 위의 사용데이터 참고하여 3명의 학생 정보 초기화
        // 위의 학생 정보 모두 출력 --> 향상된 for문 이용해서
        System.out.println("학생 3명의 정보를 차례대로 입력하세요");
        Student[] student = new Student[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < student.length; i++){
            student[i] = new Student();
            System.out.print(i+1 + "번째 학생의 이름을 입력하세요 : ");
            student[i].setName(sc.next());
            System.out.print(i+1 + "번째 학생의 나이를 입력하세요 : ");
            student[i].setAge(sc.nextInt());
            System.out.print(i+1 + "번째 학생의 키를 입력하세요 : ");
            student[i].setHeight(sc.nextDouble());
            System.out.print(i+1 + "번째 학생의 몸무게를 입력하세요 : ");
            student[i].setWeight(sc.nextDouble());
            System.out.print(i+1 + "번째 학생의 학년을 입력하세요 : ");
            student[i].setGrade(sc.nextInt());
            System.out.print(i+1 + "번째 학생의 전공을 입력하세요 : ");
            student[i].setMajor(sc.next());
            System.out.println(i+1 + "번째 학생 정보 입력 완료!");
        }
        System.out.println("======= 입력된 학생의 정보 =======");
        for (Student s : student) {
            try{
                System.out.println(s.information());
            } catch (NullPointerException err) {
                break;
            }
        }
        // 최대 10명의 사원 정보를 기록할 수 있게 배열을 할당
        // 사원들의 정보를 키보드로 계속 입력 받고 --> while(true) 무한 반복문을 통해
        // 계속 추가할 것인지 물어보고, 대소문자 상관없이 ‘y’이면 계속 객체 추가
        // 한 명씩 추가 될 때마다 카운트함
        System.out.println("사원의 정보를 입력합니다.");
        Employee[] employees = new Employee[10];
        int count = 0;
        while(count < 10){
            employees[count] = new Employee();
            System.out.print(count+1 + "번째 사원의 이름을 입력하세요 : ");
            employees[count].setName(sc.next());
            System.out.print(count+1 + "번째 사원의 나이을 입력하세요 : ");
            employees[count].setAge(sc.nextInt());
            System.out.print(count+1 + "번째 사원의 키를 입력하세요 : ");
            employees[count].setHeight(sc.nextDouble());
            System.out.print(count+1 + "번째 사원의 몸무게를 입력하세요 : ");
            employees[count].setWeight(sc.nextDouble());
            System.out.print(count+1 + "번째 사원의 월급을 입력하세요 : ");
            employees[count].setSalary(sc.nextInt());
            System.out.print(count+1 + "번째 사원의 부서를 입력하세요 : ");
            employees[count].setDept(sc.next());
            System.out.println("계속 하시겠습니까? (y/n)");
            String answer;
            answer = sc.next();
            if (answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') {
                count++;
            } else {break;}
        }
        sc.close();
        // 2명 정도의 사원 정보를 입력 받아 객체 배열에 저장
        // 현재 기록된 사원들의 정보를 모두 출력
        System.out.println("======= 입력된 사원의 정보 =======");
        for (Employee e : employees) {
            try{
                System.out.println(e.information());
            } catch (NullPointerException err) {
                break;
            }
        }
    }
}
