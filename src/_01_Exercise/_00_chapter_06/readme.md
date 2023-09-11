# JAVA의 정석 연습문제 - Chapter6
JAVA의 정석 Chapter6의 연습문제 풀이를 정리해 보도록 하겠다.<br><br>

![sdfsdfsd](https://github.com/Yoonsik-2002/java-study/assets/83572199/2c725a85-086a-4270-8cd2-2c8d5d9e9bd0)<br><br>


## 💻 6-2
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
        return Math.round((total() / 3f) * 10) / 10f;
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

  ### `Math.round()`메서드를 통해 `average()` 메서드의 기능 구현
  위에서 정리한 `Math.round()`메서드를 활용하여, 국어, 영어, 수학 점수의 평균을 소수점 첫 번째 자리까지 구하여 나타내는<br>
  `average()`메서드를 구현해 보도록 하겠다.<br>

  먼저, `average()` 메서들의 반환형은 `float`이다.<br>

  ```java
  float average() {
   //...
  }
  ```
  <br>

  먼저, 과목의 평균은 해당 과목들의 점수의 총 합을 통해서 구해내야 하기 때문에, 과목들의 총 합을 구해, 리턴해주는<br>
  `total()` 메서드를 호출해야 한다.<br>
  그리고, 평균을 구하기 위해서는 과목의 개수인 3으로 나누어 주어야 한다.<br>

  하지만, 이때 주의해야 할 점이 있다. 과목의 평균은 소수점 1의자리까지 나타내야 한다는 것이다.<br>

  만약, 아래 코드와 같이 그냥 무작정 3으로 나누어 버리면, 반환형이 `int`형인 `total()`의 리턴값을 3으로 나누고,<br>
  나온 (나머지가 잘린) 몫에 `.0`이 붙은 값이 리턴되게 된다.<br>
  ```java
  float average() {
    return total() / 3;  // 결과 : 78.0
  }
  ```
  <br>

  이는 첫 번째 소수점까지 표현하라는 조건에 부합하지 않는다.<br>
  그렇다면, 나머지가 잘리지 않도록, 3f로 나누어주면 어떻게 될까?<br>
  결과값의 소수점 6번째 자리까지의 값이 리턴되게 된다. 이 또한, 조건에 부합하지 않는다.<br>
  ```java
  float average() {
    return total() / 3f; // 결과 : 78.666664
  }
  ```
  <br>

  이 상태에서, `Math.round()`메서드를 이용하여, 소수점 첫 번째까지의 값을 리턴시켜 보도록 하겠다.<br>
  `total() / 3f`를 통해 나온 값 78.666664에 10을 곱하면, 786.66664가 된다.<br>
  `Math.round()`메서드는 해당 값의 소수점 첫번째 자리수를 반올림하여, 정수 787을 리턴한다.<br>
  이렇게 나온 787을 다시 10f로 나누면 78.7이 된다.
  ```java
  float average() {
    return Math.round((total() / 3f) * 10) / 10f; // 결과 : 78.7
  }
  ```
<br>

- ### `info()` 메서드 구현하기
  해당 메서드는 `Sring`과 `int`, `float` 타입이 혼합되어 있는 학생정보(학생이름, 반, 번호, 국어점수, 영어점수, 수학점수, 총점,<br>
  평균)을 하나의 문장으로 리턴해주는 동작을 하는 메서드이다.<br>

  **`int + ""`** <-  문자열에 `int` 타입의 값을 이어붙이면 문자열이 리턴되는 속성을 이용하였다.<br>
  ```java
  String info() {
    return  name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + total() + "," + average();
  }
  ```
---

<br><br>

## 💻 6-3
```java
package _01_Exercise._00_chapter_06;

public class Exercise6_3 {
    static double getDistance(int x, int y, int x1, int y1) {
        double distance = Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2); // 특정 값의 제곱을 구해주는 java.lang 패키지의 Math.pow()메서드
        return Math.sqrt(distance); // 특정 값의 제곱근을 구해주는 java.lang 패키지의 Math.sqrt()메서드
    }
    
    public static void main(String[] args) {
        System.out.println(getDistance(1, 1, 2, 2));
    }
}
```
<br>

### 📑 Review
- ### `getDistance()` 메서드 구현하기
  `getDistance()` 메서드는 두 점의 거리를 계산하여 반환해주는 메서드이다.<br>
  
  해당 메서드의 매개변수로는 두 점의 x, y 좌표의 값이 전달되는데, 해당 두 점 사이의 거리는 피타고라스 정리를 적용하면<br>
  구할 수 있다.<br>

  피타고라스 정리를 활용한 두 점 사이의 거리는, `(좌표의 차)의 제곱` + `(y좌표의 차)의 제곱`의 제곱근을 구하면 되는데,<br>
  Java에서는 이러한 특정 값의 제곱을 구해주는 메서드와 특정 값의 제곱근을 구해주는 메서드를 `java.lang`패키지 내의 `Math`<br>
  클래스에서 제공해준다.<br>
  
  > 개발자들이 자바를 설치하면 자바에서 제공하는 기본 클래스들이 패키지, 모듈에 걸쳐 분류된 형태로 되는 것을 두고,<br>
  > 자바 개발자 도구, **JDK(Java Development Kit)** 라고 한다.<br>
  > 또, 이런식으로 자바에서 제공하는 기본 클래스 들을 **자바 API** 라고 한다.<br>
  > 자세한 설명은 다음 링크로.. `->`  [자바 JDK란?](https://github.com/Yoonsik-2002/java-study/tree/main/src/_00_other_knowledge/_01_package)<br>

  <br>

  ### `Math.pow()` 메서드
  특정 값의 제곱을 구하기 위해서는 `java.lang`패키지 내의 `Math.pow()`메서드를 사용하면 된다.<br>

  해당 메서드는 입력값과 출력값이 모두 `double`형이며, 다음 코드와 같이, 대상이 되는 값과, 몇 번 제곱할지에 대한<br>
  지수값을 전달해주는 식으로 사용이 가능하다.<br>
  ```java
  Math.pow(대상숫자, 지수);
  ```
  <br>

  ### `Math.sqrt()` 메서드
  특정 값의 제곱을 구해주는 메서드가 `Math.pow()`였다면, 특정 값의 제곱근을 구해주는 메서드 또한 존재한다.<br>

  바로, `Math.sqrt()` 메서드이다.<br>

  해당 메서드 또한, 입력값과 출력값이 모두 `double`형이며, 아래 코드와 같이, 대상이 되는 값을 전달해주기만 하면<br>
  해당 값의 제곱근을 리턴 받을 수 있다.<br>
  ```java
  Math.sqrt(대상숫자);
  ```
  <br>

  ### `getDistance()` 메서드 구현하기
  자, 이렇게 두 점 사이의 거리를 구하는데 필요한 자바 API, `Math`클래스의 `Math.pow()`메서드와 `Math.sqrt()`메서드에 대해<br>
  알아보았다.<br>

  이를 활용하여 인자로, 각 `x 좌표값`, `y 좌표값`을 전달받은 두 점 사이의 거리를 구하여 리턴해주는 메서드 `getDistance()`를 <br>
  완성해 보도록 하겠다.<br>

  ```java
  public class Exercise6_3 {
    static double getDistance(int x, int y, int x1, int y1) {
      // ...
    }
  }
  ```
  <br>

  먼저, `getDistance()`메서드의 반환형은 `double`로 해 주었다. 일단은, 해당 문제에서 요구하는 결과값이 최대 소수점 16자리의<br>  
  `double`형 이었고, 해당 메서드에서 활용할 `Math.pow()`메서드와 `Math.sqrt()`메서드의 기본 반환형 또한, `double`이여서 해당<br>
  자료형을 `getDistance()`메서드의 반환형으로 지정해 주었다.<br>

  그리고, 해당 메서드를 인스턴스를 생성하지 않아도 사용할 수 있도록, 앞에 `static`을 붙여, 클래스 메서드로 선언하여 주었다.<br>

  ```java
  public calss Exervise6_3 {
    static double getDistance(int x, int y, int x1, int y1) {
      double distance = Math.pow(x1 - x, 2) + Math.pow(y2 - y, 2);
      return Math.sqrt(distance);
    }

    public static void main(String[] args) {
      System.out.println(getDistance(1, 1, 2, 2));
    }
  }
  ```
  <br>

  마지막으로, 특정 값의 제곱을 반환해주는 `Math.pow()`메서드를 이용하여, 피타고라스 정리에 필요한 x, y 각 좌표의 차의 제곱을<br>
  구해 주었고, 두 값의 합의 제곱근을 `Math.sqrt()`메서드를 이용하여 구해 주었다.<br>

  이렇게 구해진 값을 리턴해주는 것이 바로, `getDistance()`메서드의 기능이다.<br>
  
  ---
  
  
  
  
  
  
  
  
  
  
  
   

  
  
  
  

