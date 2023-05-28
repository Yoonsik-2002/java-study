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
for문의 루프제어변수 `i`를 0으로 초기화 하고, 1부터 10까지의 정수를 `ex_arr1`에 저장하기 위한 `ex_arr[i] = i + 1`도 그대로 유지한 상태에서<br>
`i`가 9일 때까지만 for문을 반복하도록 해당 for문의 조건식을 `i < ex_arr1.length`로 변경해 주었다.<br>
<br>

---






