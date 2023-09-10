package _01_Exercise._00_chapter_06;

class Student {
    String name; // 학생이름
    int ban; // 반
    int no; // 번호
    int kor; // 국어점수
    int eng; // 영어점수
    int math; // 수학점수
    
    // Student 클래스의 생성자
    Student(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    
    // 점수의 합계를 출력하는 메서드 total()
    int total() {
        return kor + eng + math;
    }

    // 점수의 평균을 출력하는 메서드 average()
    float average() {
        return Math.round((total() / 3f) * 10) / 10.0f;
    }
    
    // 모든 정보를 출력해주는 메서드 info()
    String info() {
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + total() + "," + average();
    }
}

public class Exercise6_2 {
    public static void main(String[] args) {
        Student s = new Student("홍길동", 1, 1, 100, 60, 76);
        
        String str = s.info();
        System.out.println(str);
    }
}