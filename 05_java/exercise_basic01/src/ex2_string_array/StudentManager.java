package ex2_string_array;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int age;
    String studentId;

    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
    }

    public void showInfo() {
        System.out.println(studentId + " | " + name + " | " + age + "살");
    }
}

public class StudentManager {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("이름: ");
        String name = sc.nextLine().trim();

        System.out.print("나이: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("학번: ");
        String id = sc.nextLine().trim();

        students.add(new Student(name, age, id));
        System.out.println("학생 추가 완료!\\n");
    }

    public static void showAll() {
        if (students.isEmpty()) {
            System.out.println("등록된 학생 없음\\n");
            return;
        }
        System.out.println("=== 학생 목록 ===");
        for (Student s : students) {
            s.showInfo();
        }
        System.out.println();
    }

    public static void searchStudent() {
        System.out.print("검색할 이름: ");
        String keyword = sc.nextLine().trim();

        boolean found = false;
        for (Student s : students) {
            if (s.name.contains(keyword)) {
                s.showInfo();
                found = true;
            }
        }
        if (!found) System.out.println("검색 결과 없음\\n");
        else System.out.println();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("1.추가 2.전체조회 3.검색 4.종료");
            System.out.print("선택: ");
            String menu = sc.nextLine();

            if (menu.equals("1")) addStudent();
            else if (menu.equals("2")) showAll();
            else if (menu.equals("3")) searchStudent();
            else if (menu.equals("4")) {
                System.out.println("프로그램 종료!");
                break;
            } else {
                System.out.println("잘못된 입력!\\n");
            }
        }
        sc.close();
    }
}
