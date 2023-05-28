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
        
        for (int i = 1; i <= ex_arr1.length ; i++) {
            ex_arr1[i] = i;
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

