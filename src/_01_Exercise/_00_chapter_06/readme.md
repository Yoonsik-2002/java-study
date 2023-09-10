# JAVA의 정석 연습문제 - Chapter6
### 💻 6-2
```java
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
```
<br>

### 📑 Review
- #### `average()` 메서드 구현하기
  해당 문제를 풀면서, 가장 고민을 많이 하였던 부분은 점수의 평균을 출력하는 메서드 `average()`를 구현하는 부분이었다.<br>
  
  해당 메서드는 `total()`메서드를 통해 리턴된 국어, 영어, 수학 점수의 총 합을 3으로 나눈 뒤, 해당 값을 반올림 하여<br>
  소수점 첫 번째 자리수까지 구한 뒤, 해당 값을 `return`하는 기능을 담당한다.<br>
  (국어, 영어, 수학 점수의 평균을 소수점 첫번째 자리까지 반올림 한 값을 리턴해야 함)<br>

  해당 기능을 구현하면서 새롭게 알게 된 메서드는 `java.lang`패키지의 `Math`클래스의 `round()`메서드이다.<br>

  #### `Math.round()` 메서드
  
  
  

