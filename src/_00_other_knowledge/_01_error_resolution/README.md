## `java.lang.ArrayIndexOutOfBoundsException` 에러
`C`와 `C++`과는 달리, Java는 배열의 인덱스로, 배열의 마지막 인덱스(배열의 크기가 `n`이면 배열의 마지막 인덱스는 `n-1`) 보다 큰 값이나,<br>
음수 값이 요청되는 경우, `java.lang.ArrayIndexOutOfBoundsException`에러를 발생시킨다.<br>
또한, 이 예외는 컴파일러가 검사하지 않고, 런타임(실행도중)에 발생된다.<br>

위에서 설명한 `java.lang.ArrayIndexOutOfBoundsException` 예외가 발생하는 경우에 대한 아주 간단한 예시를 들면 다음과 같다.<br>
```java
int[] ex_arr = {1, 3, 5, 7, 9}; // index = 0 ~ 4
int i = 5;
int j = -1;

System.out.println(ex_arr[i]); // java.lang.ArrayIndexOutOfBoundsException 에러 발생! - 배열 ex_arr의 인덱스에 ex_arr의 마지막 인덱스(4) 보다 큰 값인 5가 요청됨
System.out.println(ex_arr[j]); // java.lang.ArrayIndexOutOfBoundsException 에러 발생! - 배열 ex_arr의 인덱스에 음수 값이 요청됨
```
<br>

나는 해당 에러를 배열의 출력과 관련된 코드를 짜는 도중 만나게 되었다.<br>
다음은 문제의 그 코드이다.<br>
```java
package chapter_05;

import java.util.Arrays;

public class Ex05_2 {
    public static void main(String[] args) {
        int[] ex_arr1 = new int[10];
        int[] ex_arr2 = new int[10];
        // int[] ex_arr3 = new int[] {100, 90, 80, 70, 60};
        int[] ex_arr3 = {100, 90, 80, 70, 60};
        char[] ex_char_arr = {'a', 'b', 'c', 'd', 'e'};
        
        for (int i = 0; i <= ex_arr1.length ; i++) {
            ex_arr1[i] = i + 1;
        }
        
        for (int i = 0; i < ex_arr2.length ; i++) {
            ex_arr2[i] = (int)(Math.random()*10) + 1;
        }
        
        for (int i = 0; i < ex_arr1.length ; i++) {
            System.out.println(ex_arr1[i] + ",");
        }
        
        System.out.println(Arrays.toString(ex_arr2));
        System.out.println(Arrays.toString(ex_char_arr));
        System.out.println(ex_arr3);
        System.out.println(ex_char_arr);
    }
}
```
<br>

그리고, 아래는 해당 코드를 실행시켰을 때 나타나는 에러메세지이다.<br>
```java
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 10
        at chapter_05.Ex05_2.main(Ex05_2.java:14)
```
<br>

이 에러메세지의 `Ex05_2.java:14`를 통해 `Ex05_2.java`파일의 14번째 라인에 해당 에러가 발생했다는 것을 알 수 있다.<br>
`Ex05_2.java`파일에서 문제의 14번째 라인에 해당하는 코드와 해당 코드를 감사고 있는 for문은 다음과 같다.<br>
```java
13  for(int i = 0; i <= ex_arr1.length; i++) {
14      ex_arr1[i] = i + 1;
15  }
```
<br>

위 코드를 보고 바로 문제를 알 수 있었다.<br>
내가 해당 코드를 짠 의도는 10이라는 크기(요소의 개수)로 선언된 배열`ex_arr1`에 int형 정수 1부터 10까지를 for문을 이용하여<br>
저장하는 것이였다.<br>

그래서, 배열 `ex_arr1`의 index는 0~9 까지기 때문에 루프제어변수 `i`의 시작값을 0으로 초기화 해주고, `ex_arr1[i]`에 대입되는 값은<br> 
`i + 1`을 통해 1부터 시작하여, for문을 한번 돌고 나서(`i++, 후위연산자`) i가 1씩 증가하고, 해당 값에 또 `i + 1`을 통해 1이 추가로 더해지는<br>
패턴이 반복되며, `1, 2, 3, 4, ....` 이런식으로 값이 배열에 저장되게 하였다.<br>

여기까지는 좋았으나, 문제는 해당 for문의 조건식`i <= ex_arr1.length`에 있었다.<br>
`ex_arr1.length`는 배열의 길이(크기)를 반환하는데, `ex_arr1`은 크기가 10인 배열로 선언되었기 때문에, `ex_arr1.length`가<br>
반환하는 값은 10이 된다.<br>

결국, for문의 조건식 `i <= ex_arr1.length`는 `i < = 10`과 같은 의미를 가지게 되는데, 그럼 해당 for문은 `ex_arr1[10] = 10 + 1;`까지 <br>
실행하고 나서 종료되게 된다.<br>

결론적으로, 인덱스의 범위가 0 ~ 9 까지인 배열 `ex_arr1`에 마지막 인덱스인 9보다 큰 값인 10이 해당 배열의 인덱스로 요청되었는데,<br>
이를 허용하지 않는 Java는 `java.lang.ArrayIndexOutOfBoundsException` 예외를 발생시키게 된 것이다.<br>

이제, 해당 예외가 발생하지 않도록 코드를 수정해 보도록 하겠다.<br>
```java
13  for(int i = 0; i < ex_arr1.length; i++) {
14      ex_arr1[i] = i + 1;
15  }
```
<br>

for문의 루프제어변수 `i`를 0으로 초기화 하고, 1부터 10까지의 정수를 `ex_arr1`에 저장하기 위한 `ex_arr[i] = i + 1`도 그대로 유지한 상태에서<br>
`i`가 9일 때까지만 for문을 반복하도록 해당 for문의 조건식을 `i < ex_arr1.length`로 변경해 주었다.<br>
<br>

---
<br><br>

## `no suitable method found for println(String,int,int,int)` 에러
해당 에러를 다루기 전에 `Formatting`이라는 개념에대해 한번 짚고 넘어가도록 하겠다.<br>
`Formatting`이란, 우리가 C, C++, C#에서 문자열을 출력 시, 해당 문자열 중간중간에 숫자(int, float, double)나 또 다른 문자열을 <br>
대입하여 출력하기 위해 흔히 사용하던 방법이다.<br>

예시코드를 작성해보면 다음과 같다.<br>

```C
int military_discharge = 390;

printf("전역까지 %d일 남았다.", military_discharge);
```
<br>

원래 Java에서 문자열을 출력하기 위해서는 `println()`메서드를 사용하였다. 해당 메서드를 사용할 때는 위의 예시코드의 경우,<br>
다음과 같이 `+`를 사용하여 문자열 사이에 숫자(int)를 대입해주어야 한다.<br>

```java
int military_discharge = 390;

System.out.println("전역까지 " + military_discharge + "일 남았다.");
```
<br>

그렇다면, Java에서 C, C++, C#에서와 같이 `Formatted Printing`을 하기 위해서는 어떻게 해야 할까? 다음 두 가지 방법을 통해 <br>
`Formatted Printing`이 가능하다.<br>

- #### `printf`메서드 사용하기
  `printf`메서드는 C, C++, C#과 같이 Java에서도 `Formatted Printing`을 할 수 있게 해준다.<br>
  해당 메서드를 적용한 예시코드는 다음과 같다.<br>
  ```java
  int military_discharge = 390;
  
  System.out.printf("전역까지 %d일 남았다.", military_discharge);
  ```
 
- #### `String.format()`메서드 사용하기
  `java.lang`의 `String`클래스의 `format()`메서드를 통해서도 Java에서의 `Formatted Printing`이 가능하다.<br> 
  해당 메서드를 적용한 예시코드는 다음과 같다.<br>
  ```java
  int military_dischage = 390;
  
  System.out.println(String.format("전역까지 %d일 남았다.", military_discharge));
  ```
  <br>

마지막으로, 에러가 난 코드를 한번 살펴보도록 하겠다.<br>

```java
package chapter_05;

class Ex05_8 {
    public static void main(String[] args) {
        int[][] score = {
                         {100, 90, 70},
                         {80, 60, 100}, 
                         {100, 90, 80},
                         {98, 77, 100},
        };
        int sum = 0;
        
        for(int i = 0; i < score.length; i++) {
            for(int j = 0; j < score[0].length; j++) {
                System.out.println("score[%d][%d] = %d\n", i, j, score[i][j]);
                
                sum += score[i][j];
            }
        }
        
        System.out.println("총합 : " + sum);
    }
}
```
<br>

아래는 해당 코드를 실행시켰을 때 발생하였던 에러메세지이다.<br>

```java
chapter_05/Ex05_8.java:15: error: no suitable method found for println(String,int,int,int)
```
<br>

해당 에러 메세지에 나타나있는대로, 15번째 라인의 코드를 보면 왜 해당 에러가 발생하였는지 알 수 있다.<br>
다음은 문제의 15번째 라인의 코드이다.<br>
```java
System.out.println("score[%d][%d] = %d\n", i, j, score[i][j]);
```
에러가 발생한 이유는 `println`메서드를 이용해서 다음과 같이 `Formatted Printing`을 하려면, `printf`메서드를 사용하거나<br>
`String.format()`메서드를 통해 숫자나 문자,문자열을 출력하고자 하는 문자열 사이에 끼워넣어주어야 하는데 그러지 않았다.<br>

해당 에러를 해결하려면 15번째 라인의 코드를 다음과 같이 변경해 주어야 한다.<br>

```java
System.out.printf("score[%d][%d] = %d\n", i, j, score[i][j]);
```
or
```java
System.out.println(String.format("score[%d][%d] = %d\n", i, j, score[i][j]));
```
<br>

---
<br><br>

## `Integer number too large`, `Type mismatch: cannot convert from double to float` 에러 - long, float 타입 변수 초기화 시, 값 뒤에 L, F를 붙여야 하는 이유
해당 에러를 다뤄보기 전에, 기본적인 Java의 데이터 타입을 다음 표로 정리해 보았다.<br><br>

### Java의 데이터 타입
![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/a6ca708d-b8b8-4fc4-ad12-0d7f87eeca2e)

#### `long` 타입이란 무엇인가?
`long` 타입은 8byte(64bit)의 크기를 가지고 있는, 정수형 타입 중에서 가장 큰 타입이다.<br>
우리가 흔히 알고 있는 정수형 타입인 `int`의 범위에 해당하는 수 는 -2,147,483,648 ~ 2,147,283,647로,<br>
`int`형의 경우, 대략 ±21억 정도의 범위의 정수값을 저장하는 것이 가능하다.<br>
(해당 `int`형 자료형의 크기는 4byte)<br>

이러한 이유로, -2,147,483,648 ~ 2,147,283,647 의 범위를 벗어나는 값을 저장해야 하는 경우에는, `int` 형보다 큰<br>
`long` 타입에 해당 값을 저장하여야 한다.<br><br>

### 에러 발생 코드
자, 이렇게 Java의 기본적인 데이터 타입과 개인적으로 명확하게 이해하고 있지 않았던 `long` 타입에 정리해 보았다.<br>
다음은 해당 에러가 발생했던 문제의 코드이다.<br>

```java
public class Ex_literal {
    public static void main(String[] args) {
        long ex_long = 12345678912;
        float ex_float = 1199.80;
    }
}
```
<br>

### 리터럴(literal)이란?
위 코드의 `long ex_long = 12345678912;` 에서 **`12345678912`** 와 `float ex_float = 1199.80;` 에서 **`1199.80`** 과 같이<br>
변수에 넣는 변하지 않는 데이터, 즉, 데이터(값) 그 자체를 두고, **리터럴(literal)** 이라고 한다.<br>
(해당 코드에서의 리터럴 = `12345678912`, `1199.80`)<br>

이러한 리터럴의 경우, 문자열 리터럴을 제외한, `byte`, `short`, `int`, `long`, `float`, `double`, `boolean`, `char` 리터럴은<br>
스택(자세히는, 스택 안의 operand 스택)이라는 메모리 공간에 일시적으로 적재(임시저장) 되었다가, 변수 라는 메모리 공간에 저장된다.<br>

이렇게 Java 에서 변수에 실질적으로 리터럴을 저장하기 전에, 스택이라는 메모리 공간에 일시적으로 적재하는 과정에 있어, 해당 리터럴이<br>
정수인 경우에는 기본적으로 자료형을 `int`로, 실수인 경우에는 `double`로 하여 일시적으로 해당 스택 메모리에 적재하게 된다.<br>

#### 변수에 저장하고자 하는 리터럴이 8byte 크기의 메모리 공간을 필요로 하는 정수인 경우
변수에 저장하고자 하는 리터럴이 정수이면서, 해당 값이 `int`형의 값의 범위인 -2,147,483,648 ~ 2,147,283,647을 넘어가는 정수인 경우,<br>
`int`형의 크기인 4byte보다 큰 8byte의 메모리 공간이 필요하므로, 자바언어를 실행하는 가상머신에게, 해당 값은 `int`타입의 4byte가 아닌<br>
`long`타입의 8byte 메모리 공간에 저장해야 하는 리터럴 이라고 명시해 주어야 한다.<br>
그것을 명시해 주기 위해서 사용하는 것이 해당 리터럴 뒤에 붙이는 접미사 **`L`** 이다.<br>

#### 변수에 저장하고자 하는 리터럴이 4byte 크기의 메모리 공간을 필요로 하는 실수인 경우
그렇다면, 변수에 저장하고자 하는 리터럴이 실수인 경우에는 어떻게 될까?<br>
위에서 설명하였듯이, 변수에 저장하고자 하는 값이 실수인 경우에는, 변수라는 메모리 공간에 저장하기전, 해당 리터럴을 스택메모리에<br>
임시저장 할 때, 기본적으로 자료형을 `double`로 하여 저장하게 되는데, 이때, `double`이라는 자료형의 크기는 8byte이기 때문에,<br>
8byte 크기로 스택 메모리 공간에 적재되게 된다.<br>
이때, 저장하고자 하는 실수 리터럴이 4byte(`float`) 로 표현해야하는 값이라면, 이 또한, 자바언어를 실행해주는 가상머신에게 해당<br>
리터럴 값은 8byte가 아닌 4byte크기의 메모리 공간에 할당해 주어야 하는 리터럴 값이라고 명시해 주어야 한다.<br>
이를 명시해 주기 위해 사용하는 것이 접미사 **`F`** 이다.<br>

#### 리터럴이 변수에 저장될 때 반환결과 정리
| 리터럴(스택 안의 operand 스택에 임시저장) | -> | 변수 |
|:--------------------------------------:|:------:|:----:|
| `int` (4byte 할당) | -> | `int` (4byte로 저장)|
| `long` (접미사 `L`을 붙였을 시, 8byte 할당) | -> | `long` (8byte로 저장)|
| `double` (8byte 할당) | -> | `double` (8byte로 저장)|
| `float` (접미사 `F`를 붙였을 시, 4byte 할당) | -> | `float` (4byte로 저장)|

<br>

### 에러 해결
이렇게, 리터럴이 `long`타입이나 `float`타입의 변수에 저장될 때 왜 접미사 `L`과 `F`를 붙여야 하는지에 대해서 알아 보았다.<br>
이제 위 코드에서 발생한 에러를 해결해 보도록 하겠다.<br>

#### 1) `long ex_long = 12345678912;`
해당 코드를 보았을때, 변수 `ex_long`에 저장되는 리터럴 `12345678912`는 `int`타입의 저장 가능한 값의 범위인<br>
-2,147,483,648 ~ 2,147,283,647을 훨씬 벗어나는 값임을 알 수 있다.<br>

때문에, `int`타입 보다 더 큰 8byte의 메모리 공간을 가지는 `long`타입에 저장하여야 한다.<br>

하지만, 이러한 리터럴은 변수에 저장되기 전에, 스택 안의 operand 스택에 임시저장 되는데, 정수 리터럴의 경우,<br>
기본적으로 4byte공간의 `int`타입으로 저장되게 된다.<br>

이때, Java언어를 실행하는 가상머신에게 *'해당 리터럴은 4byte보다 더 큰 메모리 공간이 필요! 8byte를 내놓아라!'* 라고<br>
명시해주는 것이 바로 접미사 `L`이다.<br>

이를 적용하여 해당 코드를 수정하면 다음과 같다.<br>

```java
public class Ex_literal {
    public static void main(String[] args) {
        long ex_long = 12345678912L;
        float ex_float = 1199.80;
    }
}
```
<br>

#### 2) `float ex_float = 1199.80;`
해당 코드를 보았을 때, 리터럴 `1199.80`을 4byte크기의 변수(메모리 공간) `ex_float`에 저장하는 코드임을 알 수 있다.<br>

마찬가지로, 이러한 리터럴은 변수에 저장되기 전에, 스택 안의 operand 스택에 임시저장 되는데, 실수 리터럴의 경우,<br>
기본적으로 8byte공간의 `double`타입으로 저장되게 된다.<br>

하지만, 우리가 변수 `ex_float`에 저장하고자 하는 리터럴은 4byte(float)로 표현하고자 하는 실수 리터럴이다.<br>
때문에, 이 또한, Java언어를 실행하는 가상머신에게 *'해당 리터럴은 4byte메모리 공간을 이용하여 표현할거야<br>
기본적으로 제공하는 8byte말고 4byte를 줘!'* 라고 명시해 주어야 한다.<br>
바로, 이를 명시해 주는 것이 바로 접미사 `F`이다.<br>

이를 적용하여 해당 코드를 최종적으로 수정하면 다음과 같다.<br>

```java
public class Ex_literal {
    public static void main(String[] args){
        long ex_long = 12345678912L;
        float ex_float = 1199.80F;
    }
}
```
<br>

---
<br><br> 






















