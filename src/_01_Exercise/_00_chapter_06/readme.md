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

<br><br>

## 💻 6-4
```java
package _01_Exercise._00_chapter_06;

class MyPoint {
    int x;
    int y;

    // 생성자
    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 인스턴스 메서드 getDistance()
    double getDistance(int x, int y) {
        double distance = Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2);
        return Math.sqrt(distance);
    }
}

public class Exercise6_4 {
    public static void main(String[] args) {
        // 인스턴스 생성
        MyPoint p = new MyPoint(1, 1);

        // MyPoint클래스의 인스턴스 p와 (2, 2)좌표의 점의 거리를 구해 반환하는 인스턴스 메서드 getDistance()메서드 호출
        System.out.println(getDistance(2, 2);
    }
}
```
<br>

### 📑 Review
- ### 6-3문제의 `getDistance()`메서드를 `MyPoint`클래스의 인스턴스 메서드로 정의하기
  생성자를 통해 x좌표 1로, y좌표 1로 초기화 되어있는 `MyPoint`인스턴스 `p`와, (2, 2)좌표에 해당하는 점의 거리를 구해 반환<br>
  하는 인스턴스 메서드 `getDistance()`를 정의하고, 해당 코드를 완성해 보도록 하겠다.<br>

  인스턴스 멤버인 인스턴스 메서드는 인스턴스 변수가 생성되는 시기인 '자신이 속한 클래스의 인스턴스가 생성된 뒤'에 사용이 가능하다.<br>
  인스턴스 메서드 `getDistance()`는 x좌표 1, y좌표 1에 위치하는 점과, (2, 2) 좌표에 해당하는 점의 거리를 구해 반환해주는 메서드<br>
  이다.<br>
  <br>

  ### 인스턴스 메서드 `getDistance()` 구현하기
  ```java
  double getDistance(int x, int y) {
      double distacne = Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2);
      return Math.sqrt(distance);
  }
  ```
  <br>

  매개변수에, 인스턴스 `p`와의 거리를 계산할 점의 x, y좌표값(2, 2)가 전달되면, 그 값을 가지고, 피타고라스 정리를 통해 거리를 구하<br>
  는 메서드이다.<br>

  `Math.pow()`메서드를 통해, 각 점의 x좌표값의 차의 제곱, y좌표값의 차의 제곱을 구해준다.<br>
  이때, 각각 1로 초기화 되어있는 인스턴스 `p`의 멤버변수 `x`와 `y`를 사용하기 위해 `this`를 사용하였는데, 이 `this`는 객체 자신을<br>
  가리키는 참조변수로, 우리가 `인스턴스이름.멤버변수이름`을 통해 해당 인스턴스의 멤버변수에 접근하듯이, 객체(인스턴스)자신을 가리키는<br>
  `this`를 이용하여, 해당 인스턴스의 멤버변수에 접근하는 것이 가능하다.<br>

  이렇게 `Math.pow()`메서드를 통해 구한 작 점의 x좌표값의 차의 제곱, y좌표값의 차의 제곱을 더해준 뒤, 해당값을 특정값의 제곱근을<br>
  구해주는 `Math.sqrt()`메서드에 전달해주면, `getDistance()`메서드에 좌표값이 전달된 점과 `p`의 거리를 구할 수 있게된다.<br>
  <br>
  
  ### 동작 과정

  먼저, `getDistance()`메서드를 사용하기 위해서는, 우선적으로 해당 메서드가 속한 `MyClass`클래스의 인스턴스를 생성해 주어야 한다.<br>
  ```java
  MyPoint p = new MyPoint(1, 1);
  ```
  <br>

  해당 인스턴스`p`가 생성되면서, 생성자에 의해 `p`의 좌표를 나타내는 멤버변수 `x`와 `y`가 각각 1로 초기화 된다.<br>

  (1, 1) 위치에 있는 점 `p`와 (2, 2) 위치에 있는 점의 거리를 구하여 리턴해주는 `getDistance()` 인스턴스 메서드를 호출하여, 그 리턴값을<br>
  화면에 출력해 준다.<br>
  ```java
   System.out.println(getDistance(2, 2));
  ```
  <br>
  
---

<br><br>

## 💻 6-5 
```java
package _01_Exercise._00_chapter_06;

import java.util.Arrays;

public class Exercise6_5 {
   static int[] shuffle(int[] arr) {
        for(int i = 0; i < 100; i++){
            // 배열 arr의 인덱스인, 0에서 9까지의 수 중, 무작위로 하나 선택하여 rand에 저장
            int rand = (int)(Math.random() * 10);

            // arr의 0번째 인덱스에 저장된 값과 무작위로 선택되어 저장된 rand 인덱스에 저장된 값을 서로 교환
            int temp = arr[0];
            arr[0] = arr[rand];
            arr[rand] = temp;
        }
        return arr;
    }

public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(Arrays.toString(arr));

    int[] rand_arr = shuffle(arr);
    System.out.pritnln(Arrays.toString(arr));
}
```
<br>

### 📑 Review
- ### `shuffle()`메서드 구현하기
  이 `shuffle()`메서드는 인자로 전달받은 배열 `arr`의 0번째 인덱스에 저장되어있는 값(`arr[0]`)과, `arr`의 인덱스인 0 ~ 9 까지의 수 중, 무작<br>
  위로 하나를 선택하여 저장한 `rand`에 해당하는 인덱스에 저장되어있는 값(`arr[rand]`)를 교환하는 과정을 여러번 반복하여 배열 내부에 저장되어<br>
  있는 값의 순서를 뒤섞은 뒤, 리턴해주는 메서드이다.<br>

  먼저, 해당 메서드를 인스턴스 생성을 하지 않아도 사용이 가능할 수 있도록, 클래스 메서드로 정의한다.<br>
  ```java
  public class Exercise6_5 {
      static int[] shuffle(int[] arr) {
          // ...
      }
  }
  ```
  <br>

  그리고, `arr[0]`과 `arr[rand]`를 서로 교환하는 과정을 여러번 반복하여 배열에 저장되어 있는 데이터들을 뒤섞어주는 기능을 구현해<br>
  보도록 하겠다.<br>

  해당 기능을 구현해보기 위해서는, `java.lang`패키지 내의 `Math.random()`메서드를 사용해야 한다.<br>
  <br>
  
  ### `Math.random()` 메서드
  `Math`클래스가 속해있는 `java.lang`패키지는 Java프로그래밍에 필요한 가장 기본적인 클래스들이 모여있는 패키지이다.<br>
  때문에, Java 에서는,  `import`구문을 통해 호출해 주어야 하는 다른 패키지들과는 달리, `lang`패키지는 `import`구문을 사용하여 호출해주지<br>
  않아도 사용이 가능도록 하였다.<br>

  자, 이 `java.lang`패키지의 `Math.random()`메서드를 이용하여, 0 ~ 9 까지의 인덱스 중, 무작위로 하나를 선택하여 int형 변수 `rand`에<br>
  저장하는 코드를 `shuffle()`메서드에 추가해 보도록 하겠다.<br>
  ```java
  public class Exercise6_5{
      static int[] shuffle(int[] arr) {
          for(int i = 0; i < 100; i++) {
              int rand = (int)(Math.random() * 10);
              // ...
          }
      }
  }
  ```
  <br>

  이, `Math.random()`메서드에 대해 간단히 설명하자면, 해당 메서드는 기본적으로, 0 에서 1미만의 실수(double형)값을 무작위로 반환 해주는<br>
  메서드이다.<br>
  (0 에서 0.999999999999999 까지의 실수를 무작위로 반환. 반환형은 double 자세한 설명은 -> [java.lang 패키지](https://github.com/Yoonsik-2002/java-study/tree/main/src/_00_other_knowledge/_01_package#javalang-%ED%8C%A8%ED%82%A4%EC%A7%80))<br>

  이러한 `Math.random()`메서드를 통해 우리가 얻고자 하는 값은 int형의 0 ~ 9까지의 난수이다.<br>

  기본적인 `Math.random()`메서드의 값의 범위는 다음과 같다.<br>
  `0 ≤ Math.random() < 1  // 반환형은 double`

  하지만, 우리가 얻고자 하는 값의 범위는 0 ~ 9까지의 난수이다. 해당 값의 범위를 설정해 주기 위해서는, 각 변에 10을 곱해주면 해당 범위를 정해줄 수가 있다.<br>
  
  `0 * 10 ≤ (Math.random() * 10) < 1 * 10`
  `0 ≤ (Math.random() * 10) < 10`

  그 다음으로, 기본 반환형이 double인 해당 메서드를 통해 int형의 값을 리턴받기 위해서는, 아래와 같이 int형으로 형변환을 해주어야 한다.<br>
  ```java
  int rand = (int)(Math.random() * 10);
  ```
  <br>

  자, 해당 코드를 통해 0 ~ 9 까지의 인덱스 값 중 하나를 뽑아, int 형 변수 `rand`에 저장할 수 있게 되었다.<br>

  이를 활용하여, `shuffle()`메서드를 마저 완성해 보면 다음과 같다.<br>
  ```java
  public class Exercise6_5{
      static int[] shuffle(int[] arr) {
          for(int i = 0; i < 100; i++) {
              int rand = (int)(Math.random() * 10);

              int temp = arr[0];
              arr[0] = arr[rand];
              arr[rand] = temp;
          }
          return arr;
      }
  }
  ```
  <br>

  ### `Array.toString()` 메서드
  Java에서 배열 내용을 출력해 보기 위해, 바로 `Object`클래스의 `toString()`메서드를 사용해버리면, 우리가 기대하는 배열의 내용이 아닌,<br>
  배열의 주소값이 출력되게 된다.<br>

  배열의 내용을 출력하기 위해서는 `java.util`패키지의 `Arrays.toString()`메서드를 사용해야 한다.<br>
  `shuffle()`메서드를 통해 배열 `arr`의 내용을 뒤섞은 뒤, 이를 출력해주는 기능까지 모두 마저 구현해 보도록 하겠다.<br>

  ```java
  import java.util.Arrays;

  public class Exercise6_5 {
      static int[] shuffle(int[] arr) {
          for(int i = 0; i < 100; i++) {
              int rand = (int)(Math.random() * 10);

              int temp = arr[0];
              arr[0] = arr[rand];
              arr[rand] = temp;
          }
          return arr;
      }
  }

  public static void main(String[] args) {
      int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
      System.out.println(Arrays.toString(arr));

      int[] rand_arr = shuffle(arr);
      System.out.println(Arrays.toString(rand_arr));
  }
  ```
  <br>

---

<br><br>

## 💻 6-6
```java
package _01_Exercise._00_chapter_06;

public class Exercise6_6 {
    static boolean isNumber(String str) {
        // str이 null 이거나, 빈 문자열인 경우
        if(str == null || str.equals("")){
            return false;
        }
        
        // str이 숫자로만 이루어져 있는 경우 / 아닌 경우
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch < 48 || ch > 57) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String str = "1234";
        System.out.println(str + "은 숫자로만 이루어져 있는가? " + isNumber(str));
        
        str = "123o";
        System.out.println(str + "은 숫자로만 이루어져 있는가? " + isNumber(str));
    }
}
```
<br>

### 📑 Review
- ### `isNumber()` 메서드 구현하기
  `isNumber()`메서드는 인자로 전달받은 문자열이 모두 숫자로 이루어져 있으면, `true`를 리턴하고, 비어있거나, 문자가 섞여있는<br>
  경우, `false`를 리턴해주는 메서드이다.<br>

  먼저, 해당 메서드를 인스턴스를 생성하지 않아도 사용할 수 있게 해주기 위해, `static`을 붙여, 클래스 메서드로 정의해보도록<br>
  하겠다.<br>

  ```java
  static boolean isNumber(String str) {
      // ...
  }
  ```
  <br>

  ### 조건 1) `str`이 `null`이거나 빈 문자열(`""`)인 경우, `return false`
  먼저, 조건 중 하나인 `str`이 `null`이거나 빈 문자열(`""`)인 경우, `false`를 리턴하는 기능을 구현해 보도록 하겠다.<br>
  여기서, 조건을 `(str == null || str.equals(""))`로 지정해 주었는데, 값이 `null`(`str == null`) 이거나,<br>
  빈 문자열(`str.equals("")`)인 경우, `false`를 리턴한다.<br>
  <br>
  
  ### 빈 문자열(`""`)과, `null`의 차이
  빈 문자열(`""`)과 `null`의 차이는 다음과 같다.<br>
  - 빈 문자열은 값이 할당되었지만, 길이는 0인 경우이다.<br>
  - null은 값이 없는 상태이다. 즉, String 객체를 가리키는 String 변수가 아무런 값도 가리키고 있지 않은 상태를 의미한다.<br>
  <br>
  
  값이 할당되었지만, 길이는 0인 경우와, 값이 없는 상태.. 어쨋든 문자열이 비어있다는 의미 아닌가? 왜 구지 두 조건을 사용<br>
  하는 것일까?<br>

  해당 질문에 대한 답은 `NullPointerException`에러가 발생할 수 있기 때문이라 할 수 있다.<br>
  해당 에러는 실제 값이 아닌, `null`을 가지고 있는 객체 혹은 변수를 호출할 때 발생하는 에러이다.<br>

  만약, String 변수 `str`에 `null`이 저장된 상태로, 해당 변수가 `isNumber()`메서드의 매개변수로 전달되었다고 생각해 보자.<br>
  만약, 조건문이 `if(str.equals(""))`로만 이루어져 있다면, `equals()`메서드를 호출하면서, `null`값을 가지고 있는 변수,<br>
  `str`을 호출한 꼴이 된다.<br>
  때문에 다음과 같이 `NullPointerException`에러가 발생하게 된다.<br>
  <br>
  ![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/6a33ec3f-48fc-455f-a0a6-e4ffb4e09643)<br>
  <br>
  ![스크린샷(3)](https://github.com/Yoonsik-2002/java-study/assets/83572199/64e68ba5-8d21-40ed-8d8e-1738a86baa96)<br>
  <br>
  
  때문에, 해당 조건문의 or연산자(`||`)의 첫 번째 조건에서, 먼저, `null`을 체크해 주어야 한다.<br>
  (`if(str == null || str.equals(""))`에서 먼저 `null`을 체크한 뒤, `str == null`일 경우, `return false`)<br>

  이를 반영하여, 첫 번째 조건에 해당하는 코드를 완성해 보면, 다음과 같다.<br>

  ```java
  package _01_Exercise._00_chapter_06;

  public class Exercise6_6 {
    static boolean isNumber(String str) {
        // str이 null 이거나, 빈 문자열인 경우
        if(str == null || str.equals("")) {
        return false;
        }
        // ...
    }
    // ...
  ```
  <br>

  ### 조건 2) `str`이 숫자로만 이루어져 있으면, `return true` 아닌경우, `return false`
  `str`이 저장하고 있는 문자열이 숫자로만 이루어져있는 경우와, 아닌 경우를 구분하는 기능을 구현하는데 있어, 먼저 생각한 방법은<br>
  다음과 같다.<br>
  
  `str`이 저장하고 있는 문자열을 하나하나 숫자인지 문자인지 구분하여, 해당 문자열을 이루는 문자가 모두 숫자인 경우, `true`를<br>
  반환하고, 아닌 경우, `false`를 반환하는 방법.<br>

  해당 방법을 구현하기 위해서는, 먼저, `for`문을 이용하여, 문자열 `str`의 길이만큼 반복하여, `str`을 이루는 문자 중 하나를<br>
  순서대로 선택하여, 숫자인지 아닌지 구분하는 작업을 해 주어야 한다.<br>

  먼저, 해당 작업을 이루는 `for`문과 `str`을 이루는 문자 중 하나를 순서대로 선택하는 기능을 구현해 보도록 하겠다.<br>

  ```java
  package _01_Exercise._00_chapter_06;

  static boolean isNumber(String str) {
         /* str이 null 이거나, 빈 문자열인 경우
         if(str == null || str.equals("")) {
              return false;
          }
         */
  
          // str이 숫자로만 이루어져 있는 경우 / 아닌 경우
          for(int i = 0; i < str.length(); i++) {
              char ch = str.charAt(i);
          // ...
          }
      // ...
  ```
  <br>

  해당 코드를 보면, 문자열 `str`의 길이만큼 반복하여, 한번 반복 할 때마다, 해당 문자열을 이루는 문자들 중 첫 번째 문자열<br> 
  (`str.charAt(0)`) 부터 순서대로 뽑는 기능을 담당한다는 것을 알 수 있다.<br>
  (String 클래스의 `charAt(int index)` 메서드 - 문자열 내에서 지정된 index의 문자를 꺼내올 때 사용)<br>

  추가적으로, `String`타입의 문자열의 길이를 구할 때는, `String` 클래스의 `length()`메서드를 사용하고, 배열의 길이를 구할<br>
  때는, `length`를 사용한다.<br>
  (배열의 길이를 구할 때 사용하는 `length`는 최초 배열이 생성될 때 길이가 결정되는 상수이다.)<br>

  자, 이렇게 `str`문자열을 이루는 문자 중에서, index 0에 해당하는 첫번째 문자부터 순차적으로 뽑아내는 기능까지 구현해 보았다.<br>
  이제, 이렇게 뽑은 문자가 숫자인지, 문자인지 구분하는 기능을 구현해야 한다.<br>
  <br>

  ### 아스키 코드 ASCII (American Standard Code for Information Interchange, 미국 정보 교환 표준 부호)
  컴퓨터는 문자를 문자 그대로 기억하지 않는다. 그 대신, 숫자로 기억하고, 표현한다.<br>
  예를 들어, `A`는, 숫자 97로, `C`는 99로 표현한다. 만약 이러한 규칙을 사람마다 마음대로 정하게 되면, 자칫 소통하는데 오류가<br>
  생길 것이다.<br>

  이러한 일을 방지하기 위해선, 모든 사람들이 공통으로 사용할 수 있는 표준 규격이 필요한데, 이것이 바로 아스키 코드이다.<br>
  <br>
  ##### [아스키 코드표]
  ![스크린샷(5)](https://github.com/Yoonsik-2002/java-study/assets/83572199/5677b481-fee5-47cc-905d-354b21249557)<br>
  <br>

  우리가 `charAt()`메서드를 통해 문자열`str`에서 뽑아내는 것은 모두, `char`타입의 문자이다.<br>
  즉, 만약, 문자열 `str`이 모두 숫자로 이루어져 있다고 하면, 문자 `'0'` ~ `'9'`로 이루어져 있는 것이라고 할 수 있다.<br>
  위의 아스키 코드를 보면 알 수 있듯이, `'0'` ~ `'9'`까지의 문자 형태의 숫자는 아스키 코드상에서 48 ~ 57까지의 10진수<br>
  로 표현이 가능하다.<br>

  때문에, 10진수의 아스키 코드값 48 ~ 57까지의 범위를 벗어나는 문자는 모두 숫자가 아니라고 할 수 있다.<br>

  이를 이용하여, 조건을 만들면, 다음과 같은 조건을 만들 수가 있다.<br>

  ```java
  if(ch < 48 || ch > 57) {
      return false;
  }
  ```
  <br>

  `str`문자열에서 뽑아낸 문자(`ch`)의 10진수 아스키 코드값이 48보다 작거나 57보다 큰 경우에는, 이는 숫자 이외의 값이라<br>
  할 수 있으므로, `false`를 리턴한다!<br>

  그렇다면, `str`이 모두 숫자로 이루어져 있는 문자열인 경우는 어떻게 판별할까?<br>

  `str`의 길이만큼 반복하여, `str`을 이루는 문자를 순서대로 하나하나 뽑아 아스키 코드값 48 ~ 57 까지의 범위내에 있는지<br>
  검사하는 과정에 있어,  숫자가 아닌 경우에는 `false`를 리턴하고 해당 메서드를 종료하게 되고,<br>
  숫자인 경우에는 반복을 이어나가게 되는데, 이때 중간에 `false`를 리턴하지 않고, `str`의 길이만큼 반복이 이루어지면,<br>
  이는 해당 문자열 `str`이 모두 10진수 아스키 코드값 48 ~ 57에 해당되는 문자형 숫자로 이루어져 있다는 의미가 된다.<br>

  이를 마지막으로, `isNumber()`메서드와, 나머지 코드까지 완성해보면 다음과 같다.<br>

  ```java
  package _01_Exercise._00_chapter_06;

  public class Exercise6_6 {
      static boolean isNumber(String str) {
          // str이 null 이거나, 빈 문자열인 경우
          if(str == null || str.equals("")){
              return false;
          }
        
          // str이 숫자로만 이루어져 있는 경우 / 아닌 경우
          for(int i = 0; i < str.length(); i++) {
              char ch = str.charAt(i);
            
              if(ch < 48 || ch > 57) {
                  return false;
              }
          }
          return true;
      }
    
      public static void main(String[] args) {
          String str = "1234";
          System.out.println(str + "은 숫자로만 이루어져 있는가? " + isNumber(str));
        
          str = "123o";
          System.out.println(str + "은 숫자로만 이루어져 있는가? " + isNumber(str));
      }
  }    
  ```
  <br>

---

<br><br>

## 💻 6-7
```java
package _01_Exercise._00_chapter_06;

class MyTv {
    
    /* 멤버변수(클래스 변수, 인스턴스 변수) - 
    직접 초기화 해주지 않아도 해당 자료형의 기본값으로 자동 초기화 된다.
    */
    boolean isPowerOn;
    int channel;
    int volume;
    
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;
    
    void turnOnOff() {
        /*
        if(isPowerOn == false) 
            isPowerOn = true;
        else 
            isPowerOn = false;
        */
        
        isPowerOn = !isPowerOn;
    }
    
    void volumeUp() {
        if(volume < MAX_VOLUME)
            volume ++;
    }
    
    void volumeDown() {
        if(volume > MIN_VOLUME)
            volume --;
    }
    
    void channelUp() {
        if (channel == MAX_CHANNEL) 
            channel = MIN_CHANNEL;
        else
            channel ++;
    }
    
    void channelDown() {
        if (channel == MIN_CHANNEL)
            channel = MAX_CHANNEL;
        else
            channel --;
    }
    
} // class MyTv

public class Exercise6_7 {
    public static void main(String[] args) {
        MyTv tv = new MyTv();
        
        tv.channel = 100;
        tv.volume = 0;
        System.out.println("CH: " + tv.channel + "," + "VO: " + tv.volume);
        
        tv.channelDown();
        tv.volumeDown();
        System.out.println("CH: " + tv.channel + "," + "VO: " + tv.volume);
        
        tv.volume = 100;
        tv.channelUp();
        tv.volumeUp();
        System.out.println("CH: " + tv.channel + "," + "VO: " + tv.volume);
    }
}
```
<br>

### 📑 Review
- ### `final` 키워드에 대해 - `final` : 마지막의, 변경될 수 없는
  위 코드의 `MyTv`클래스를 보면, 인스턴스 변수 앞에 `final`키워드가 붙어있는 변수의 선언문을 볼 수 있다.<br>

  ```java
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;
  ```
  <br>

  `final`키워드의 의미와, 이러한 `final`키워드가 붙은 변수의 용도에 대해 정리해 보도록 하겠다.<br>

  `final`은 '마지막의', '변경될 수 없는'의 의미를 가지고 있으며, 거의 모든 대상(변수, 메서드, 클래스)에 사용될 수 있다.<br>

  > **`final`이 사용될 수 있는 곳 -** 클래스, 메서드, 멤버변수, 지역변수
  
  이러한 모든 대상에 사용되는 `final`키워드에 대해서는 chapter07에서 자세히 정리하고, 지금은 해당 코드에 쓰이는 변수에 사용되는<br>
  `final`키워드에 대해 정리해 보도록 하겠다.<br>
  <br>

  ### 변수에 `final`키워드를 사용한 경우
  변수에 `final`을 붙이면, '이 변수는 수정할 수 없다.'라는 의미를 가지게 된다. **즉, 값을 변경할 수 없는 상수가 되는 것이다.**<br>

  `final`키워드가 붙은 변수의 경우, 값을 변경할 수 없기 때문에, 이에 따른 초기화 값이 필수적이다.<br>
  보통 상수의 경우에는, 선언과 초기화를 동시에 하지만, 인스턴스 변수의 경우, 생성자에서 초기화 되도록 할 수 있다.<br>

  ```java
  package _01_Exercise._00_chapter_06;

  class MyTv {
    
    /* 멤버변수(클래스 변수, 인스턴스 변수) - 
    직접 초기화 해주지 않아도 해당 자료형의 기본값으로 자동 초기화 된다.
    */
    boolean isPowerOn;
    int channel;
    int volume;
    
    //final int MAX_VOLUME = 100;
    //final int MIN_VOLUME = 0;
    //final int MAX_CHANNEL = 100;
    //final int MIN_CHANNEL = 1;

    // 생성자를 이용한 final키워드가 붙은 인스턴스 변수(상수)의 초기화
    MyTv(int max_volume, int min_volume, int max_channel, int min_channel) {
        MAX_VOLUME = max_volume;
        MIN_VOLUME = min_volume;
        MAX_CHANNEL = max_channel;
        MIN_CHANNEL = min_channel;
    }
  ```
  <br>

  ```java
  public class Exercise6_7 {
      public static void main(String[] args) {
          MyTv tv1 = new MyTv(100, 0, 100, 1);
          MyTv tv2 = new MyTv(200, 0, 234, 1);
          MyTv tv3 = new MyTv(10, 1, 2342, 0);
          /* 생성자를 통해, final키워드가 붙은 인스턴스 변수를 초기화 해주면,
          각 인스턴스 별로, final 키워드가 붙은 인스턴스 변수를 서로 다른 값으로 초기화 해주는 것이 가능하다.*/
  ```
  <br>
  
  이렇게 `final`키워드가 붙은 인스턴스 변수의 초기화가 생성자를 통해 이루어지는 것이 허용되는 이유는 무엇일까?<br>

  해당 질문의 답은 생성자의 역할을 생각해보면 나온다. 생성자는 한 클래스에서 생성되는 인스턴스들의 인스턴스 변수들을 초기화<br>
  해주는 작업을 담당하는 메서드이다.<br>

  인스턴스 변수들은 각 인스턴스별로 별도의 저장공간을 가지기 때문에, 하나의 클래스에서 생성된 인스턴스라도, 서로 다른 속성값을<br>
  이 인스턴스 변수를 통해 저장하는 것이 가능하다.<br>
  (인스턴스별로, 서로 다른 각, 인스턴스의 고유한 속성은 인스턴스 변수로 정의해준다.)<br>

  `final`키워드가 붙은 인스턴스 변수를 생성자를 통해 초기화 해주는 것이 불가능 하다면, 해당 클래스에서 생성되는 인스턴스의<br>
  `final`이 붙은 인스턴스 변수들은 모두 같은 값을 가질 수 밖에 없게된다.<br>

  아래와 같이, 클래스 내의 선언문에서, 선언과 동시에 초기화 해주는 경우, 이미 해당 값으로 초기화 되었기 때문에, 그 뒤에,<br>
  인스턴스가 생성되고 나서, `인스턴스이름.인스턴스변수이름 = 변경할 값`을 통한 값의 변경이 불가능하다.<br>
  ```java
  final int MAX_VOLUME = 100;
  // ...
  MyTv.MAX_VOLUME = 200; // 에러발생
  ```
  <br>
---

<br><br>

## 💻 6-8
```java


  
  

  

  

  
  
  
  





  
