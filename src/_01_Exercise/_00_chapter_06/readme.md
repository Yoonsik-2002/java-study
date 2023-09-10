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
- ### `average()` 메서드 구현하기
  해당 문제를 풀면서, 가장 고민을 많이 하였던 부분은 점수의 평균을 출력하는 메서드 `average()`를 구현하는 부분이었다.<br>
  
  해당 메서드는 `total()`메서드를 통해 리턴된 국어, 영어, 수학 점수의 총 합을 3으로 나눈 뒤, 해당 값의 소수점 두 번째<br>
  자리수를 반올림 하여 소수점 첫 번째 자리수까지 구한 뒤, 해당 값을 `return`하는 기능을 담당한다.<br>
  (국어, 영어, 수학 점수의 평균을 소수점 첫번째 자리까지 반올림 한 값을 리턴해야 함)<br>

  해당 기능을 구현하면서 새롭게 알게 된 메서드는 `java.lang`패키지의 `Math`클래스의 `round()`메서드이다.<br><br>

  ### `Math.round()` 메서드
  `Math.round()` 메서드는 실수의 소수점 첫 번째 자리수를 반올림하여, 정수로 리턴시켜준다.<br>
  해당 메서드를 활용하면, 소수점 몇 번째까지 표현이 가능하다.<br>

  다음 예시코드를 한번 보도록 하자.<br>

  ```java
  double pie = 3.14159265358979;

  System.out.println(Math.round(pie));  // 결과 : 3 출력
  System.out.println(Math.round(pie * 10) / 10.0; // 결과 : 3.1 출력
  System.out.println(Math.round(pie * 100) / 100.0;  // 결과 : 3.14 출력
  System.out.println(Math.round(pie * 100) / 1000.0; // 결과 : 3.142 출력
  ```

  #### `Math.round(pie)` - 실수의 소수점 첫 번째 자리수를 반올림하여 정수 반환하기
  `Math.round(pie)`의 동작을 한번 풀어서 설명해 보면 다음과 같다.<br>
  
  `Math.round()` 메서드가 인자로 `pie`에 저장되어 있는 값을 전달받으면, 해당 값의 소수점 첫 번째 자리수를 반올림하여<br>
  정수로 리턴시켜 준다.<br>
  
  3.14159265358979로 전달된 `pie`의 값의 소수점 첫 번째 자리수가 반올림되면, 정수 3이 되고, 해당 값(3)이 리턴되는 것이다.<br><br>

  #### `Math.round(pie * 10) / 10.0;` - 소수점 첫 번째 자리수 까지 나타내기
  `Math.round(pie * 10) / 10.0;`은 인자로 전달된 `pie`의 값을 소수점 첫 번째 자리까지 반올림하여 반환하여 준다<br>
  해당 메서드의 동작과정을 풀어서 설명해 보도록 하겠다.<br>

  먼저, `pie * 10`으로 인해, `Math.round()`메서드에는 31.41592265358979라는 값이 인자로 전달되게 된다.<br>
  이 상태에서, 실수의 소수점 첫 번째 소수점의 값을 반올림하여 정수로 반환하는 `Math.round()`메서드는<br>
  해당 값의 첫 번째 자리수를 반올림하여 31이라는 정수를 리턴하게 된다.<br>

  이때, 이 31이라는 값을 10.0으로 나눠주면, 3.1이라는 값이 리턴되게 된다.<br><br>

  #### `Math.round(pie * 100) / 100.0;` - 소수점 두 번째 자리수 까지 나타내기
  `Math.round(pie * 100) / 100.0`은 인자로 전달된 `pie`의 값을 소수점 두 번째 자리까지 반올림하여 반환하여 준다.<br>
  해당 메서드의 동작과정을 풀어서 설명해 보도록 하겠다.<br>

  먼저, `pie * 100`으로 인해, `Math.round()`메서드에는 314.159265358979라는 값이 인자로 전달되게 된다.<br>
  그러면, `Math.round()`메서드는 늘 하던대로, 해당 값의 첫 번째 자리수를 반올림하여 314라는 정수를 리턴하게 된다.<br>

  이때, 해당 값(314)를 100.0으로 나눠주면, 3.14라는 값이 리턴되게 된다.<br><br>

  #### `Math.round(pie * 1000) / 1000.0;` - 소수점 세 번째 자리수 까지 나타내기 
  `Math.round(pie * 1000) / 1000.0`은 인자로 전달된 `pie`의 값을 소수점 세 번째 자리까지 반올림하여 반환하여 준다.<br>
  해당 메서드의 동작과정을 풀어서 설명해 보도록 하겠다.<br>

  먼저, `pie * 1000`으로 인해, `Math.round()`메서드에는 3141.59265358979라는 값이 인자로 전달되게 된다.<br>
  마찬가지로, `Math.round()`메서드는 해당 값의 첫 번째 자리수를 반올림하여 3142라는 정수를 리턴하게 된다.<br>

  이때, 해당 값(3142)를 1000.0으로 나눠주면, 3.142라는 값이 리턴되게 된다.<br><br>

  
  
  
  
  
   

  
  
  
  

