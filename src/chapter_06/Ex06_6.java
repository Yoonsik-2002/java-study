package chapter_06;

import java.util.Scanner;

public class Ex06_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 3 명의 학생정보 - 학번, 이름, 학점
        
        // -- 기본 자료형으로 나타내기 -- 
        // int student_num1, student_num2, student_num3;
        // String name1, name2, name3;
        // int score1, score2, score3;
        
        // -- 배열을 이용하여 나타내기 --
        // int[] student_num = new int[3];
        // String[] name = new String[3];
        // int[] score = new int[3];
        
        // for(int i = 0; i < name.length; i++) {
        //     System.out.println("input name : ");
        //     name[i] = scanner.nextLine();
        // }
        
        // for(int i = 0; i < name.length; i++) {
        //     System.out.println(name[i]);
        // }
        // ...
        
        // -- 클래스를 이용하여 나타내기 --
        class Student_info {
            int student_num;
            String name;
            double score;
            
            Student_info(int student_num, String name, double score) {
                this.student_num = student_num;
                this.name = name;
                this.score = score;
            }
        }
        
        Student_info[] std_arr = new Student_info[3];
        
        std_arr[0] = new Student_info(20211059, "kim minsu", 4.2);
        std_arr[1] = new Student_info(20223434, "Lee jimin", 3.8);
        std_arr[2] = new Student_info(20233432, "han sumin", 3.5);
        
        for (int i = 0; i < std_arr.length; i++) {
            System.out.println("[" + std_arr[i].student_num + " -- " + std_arr[i].name + " -- " + std_arr[i].score + "]");
        }
    }
}