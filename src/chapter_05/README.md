## 배열(Array)
배열이란 같은 타입의 여러 변수들을 하나의 묶음으로 다루는 것을 말한다.<br><br>
### 배열의 선언과 생성
- #### 배열의 선언
  Java 에서 **배열을 선언하는 방법**은 다음과 같다. 먼저, 원하는 자료형의 변수를 생성하고, 해당 변수 또는 자료형에 배열임을 의미하는 <br>
  대괄호`[]` 를 붙여주면 된다.<br>
  
  이렇게 배열을 선언하면 생성된 배열을 다루기 위한 참조변수를위한 공간이 만들어지게 된다.<br>
  (배열의 선언과 배열을 다루기 위한 참조변수 선언은 같은 의미)<br>
  
  또, 이러한 배열의 참조변수는 해당 배열의 첫 번째 요소의 주소값을 저장한다.<br>
  
  - #### 배열의 선언 예시
    |선언방법|선언 예|
    |---|---|
    |`타입[] 변수이름;`|`int[] student_score;`|
    |`타입 변수이름[];`|`int student_score[];`|
  
    위 예시에서 알 수 있듯이, 배열임을 의미하는 대괄호`[]` 는 변수의 자료형 뒤에 붙여도 되고, 변수이름 뒤에 붙여도 된다.<br>
    선언 예를 보면, 두 방법에 따라, 선언된 배열의 참조변수가 `student_score`, `student_score[]` 두 가지 형태로 만들어지는 것을 알 수 있다.<br>
  
    참고로 내가 공부하고 있는 책의 저자는 대괄호는 변수이름보다는 자료형의 일부라 생각하기 때문에 자료형 뒤에 붙이는 것을 선호한다고 한다.<br><br>
- #### 배열의 생성  
  배열을 선언하는 방법에 대해 알아 보았으니, **배열을 생성하는 방법**에 대해 알아보도록 하겠다. <br>
  배열의 선언이 배열을 다루기 위한 참조변수를 선언하는 것이였다면, 배열의 생성은 실질적으로 같은 타입의 여러 변수들을 저장할 공간을 생성하는 것 이라고 할 수 있다.<br>
  Java 에서는 배열을 생성하기 위해,  먼저 `new` 연산자를 사용하며 배열의 타입과 길이를 지정해 주어야 한다. 
  
  - #### 배열의 생성 예시
    |생성방법|생성 예|
    |---|---|
    |`타입[] 변수이름;`<br> `변수이름 = new 자료형[배열의 길이];`|`int[] student_score; // 배열을 선언(배열을 다루는 참조변수 선언)` <br> `student_score = new int[27]; // 배열을 생성(실제 저장공간을 생성)`|
    
    위 예시를 통해 배열을 선언하고 생성하는 과정에 대해 알아보았다.<br> 
    해당 예시에서는 배열의 선언과 생성이 배열을 선언한 뒤, 배열을 생성하는 방식으로 이루어져 있는데, 이를 한줄로 간략히 표현이 가능하다. 아래 코드를 보도록 하자. 
    
    ```java
    int[] student_score;
    student_score = new int[27];
    ```
    
    ⏬
    
    ```java
    int[] student_score = new int[27];
    ```
    이런식으로 배열의 선언과 생성을 동시에 하면 코드를 간략히 한 줄로 나타낼 수 있다.<br><br>

### 배열의 길이(배열이름.length)
Java 에서는 배열의 길이를 자바 가상머신 JVM(**J**ava **V**irtual **M**achine)이 별도로 관리해준다.<br>
배열의 길이는 `배열이름.length`를 통해서 얻을 수 있다.<br>

```java
int[] student_score = new int[27];
int arr_length = student_score.length;
```

다음 코드를 보면, 길이가 27인 배열 `student_score`가 생성되고, `student_score.length;`를 통해 해당 배열의 길이를 얻어와 변수 `arr_length`에 저장한 것을 알 수 있다.<br>

이때, 배열은 한번 생성하면 해당 배열의 길이를 변경할 수 없기 때문에, 이미 생성된 배열의 길이(`배열이름.length`)는 바뀌지 않는다. <br>
**즉, 배열의 길이는 상수 이다.** 결론적으로 배열의 길이는 `배열이름.length`를 통해서 읽어올 수만 있으며, 변경할 수는 없다.<br><br>

### 배열의 초기화
배열을 초기화하는 다양한 방법들을 정리해 보도록 하겠다.<br>
- #### 1. 배열의 요소를 직접 초기화 하기
  ```java
  int[] ex_arr = new int[5];
  ex_arr[0] = 50;
  ex_arr[1] = 60;
  ex_arr[2] = 70;
  ex_arr[3] = 80;
  ex_arr[4] = 90;
  ```

  위 코드와 같이 배열의 요소들을 직접 초기화 해 줄 경우, 하나하나 직접 초기화 해주기 때문에 값을 잘못 기입하는 실수를 줄일 수 있으며<br>
  각 요소마다 자유롭게 원하는 값을 초기화 할 수 있다는 장점이 있다.<br>
  하지만, 해당 배열의 길이가 길어지면 하나하나 값을 기입하기 번거로워 진다는 단점이 존재한다.<br><br>
  
- #### 2. for문을 이용하여 배열 초기화 하기
  ```java
  int[] ex_arr = new int[5]; 
  int i;
  
  for(i = 0; i < ex_arr.length; i++) {
    ex_arr[i] = i * 10 + 50;
  }
  ```
  
  배열의 길이가 긴 경우에는 다음 코드와 같이 배열의 요소들을 for문을 이용하여 초기화 할 수도 있다. 해당 방법을 사용하면 <br>
  첫 번째 방법처럼 배열의 길이만큼 배열의 요소를 하나하나 초기화 해주어야 하는 번거로운 과정을 거치지 않아도 된다.<br>
  하지만, 반복문을 통해 값들이 초기화 되기 때문에, 첫 번째 방법처럼 각 요소마다 원하는 값을 자유롭게 초기화 해 줄 수 없고,<br>
  저장하려는 값에 일정한 규칙이 존재해야 한다.<br>
  (위 코드는 `i * 10 + 50;` 이라는 규칙에 따라 배열의 요소가 각자 다른 값으로 초기화 됨)<br><br>
  
- #### 3. 배열을 생성과 동시에 초기화 하기
  ```java
  // case 1
  int[] ex_arr = new int[]{50, 60, 70, 80, 90};
  ```
  
  위와 같이 배열을 생성과 동시에 초기화 하면 배열의 요소들을 일일이 초기화 해야 할 필요(첫 번째 방법)도 없으며, 저장하려는 값들에 <br>
  일정한 규칙이 존재(두 번째 방법)하지 않아도 된다.<br>
  그저 `{}` 안에 저장하고자 하는 값들을 `,`로 구분하여 나열하면 되며, 또 나열된 값들의 개수만큼 배열의 길이가 자동으로 정해지기 때문에<br>
  `new int[]`의 `[]`안에 배열의 길이를 적지 않아도 된다. 
  
  ```java
  // case 2
  int[] ex_arr = {50, 60, 70, 80, 90};
  ```
  심지어, 위와 같이 `new int[]` 를 생략해도 배열의 생성 + 초기화를 할 수 있다.<br>
  해당 방법이 소스가 더욱 간단해지기 때문에 많이 쓰이는 방식이지만 주의할 점이 존재한다.<br>
  
  ```java
  // wrong cases
  int[] ex_arr; // 배열의 선언
  ex_arr = {50, 60, 70, 80, 90}; // 배열의 생성 및 초기화 (에러발생)
  ```
  위 예시와 같이 배열의 선언과 생성을 동시에 하지 않고 따로따로 할 경우, 이전에 설명한 `new int[]`를 생략할 수 없다(에러발생).<br>
  배열 초기화 시, `new int[]` 생략은 배열의 선언과 생성을 동시에 수행할 경우에만 가능하다!<br>
  
  ```java
  // right cases
  int[] ex_arr = new int[]{50, 60, 70, 80, 90};
  int[] ex_arr = {50, 60, 70, 80, 90};
  
  int[] ex_arr;
  ex_arr = new int[] {50, 60, 70, 80, 90};
  ```
<br>

### 배열의 출력
배열의 출력에 대해 간단히 정리해 보겠다.<br>

- #### `for`문 이용하기 
  배열에 저장되어 있는 값들을 출력하여 확인할 때, `for`문을 사용하여 확인이 가능하다.<br>
  간단한 예시를 들어보겠다.<br>

  ```java
  int[] ex_arr = {100, 90, 80, 70, 60};

  for (int i = 0; i < ex_arr.length; i++)
  {
    System.out.println(ex_arr[i]);
  }
  ```
  먼저 위 예시와 같이, `println` 메서드를 통해 배열에 저장되어 있는 값들을 줄바꿈과 동시에 출력이 가능하다.<br><br>

  ```java
  int[] ex_arr = {100, 90, 80, 70, 60};

  for (int i = 0; i < ex_arr.length; i++)
  {
    System.out.print(ex_arr[i] + ",");
  }
  System.out.println(); // 줄 바꿈
  ```
  또, 위 예시와 같이 줄바꿈을 하지 않고, `print` 메서드로 배열 내에 저장되어 있는 값들을 출력할 수도 있다.<br>
<br>

- #### `Arrays.toString()`메서드 사용하기 
  배열의 값 자체를 출력하기 위해서는 간단하게 `Arrays.toString(배열 이름)` 매서드를 사용하는 방법도 있다.<br>
  해당 매서드는 배열에 저장되어 있는 값들을 `[첫번째 요소, 두 번째 요소, ... ]`와 같은 **문자열 형태로 만들어서 반환해준다.**
  
  이 `Arrays.toString()`매서드를 사용하기 위해서는 먼저 `import java.util.Arrays`를 추가해 주어야 한다.<br>
  해당 함수를 사용하여 배열 내에 저장된 값들을 문자열 형태로 만들어 반환해주는 예시를 들어보겠다.<br>
  
  ```java
  int[] ex_arr = {100, 90, 80, 70, 60};
  
  System.out.println(Arrays.toString(ex_arr));
  ```
  위 예시코드를 실행하면 다음과 같은 출력이 이루어진다.<br>
  
  ```java
  [100, 90, 80, 70, 60]
  ```
  위에서 미리 언급한 대로, `Arrays.toString(배열 이름)` 메서드를 사용하면 `[첫 번째 요소, 두 번째 요소, ...]` 형식으로 배열에 저장된<br>
  값들이 출력된다.<br>
  
  그렇다면, 모든 타입의 배열들이 `Arrays.toString(배열 이름)` 매서드를 사용하면 위와 같은 형식의 결과가 반환될까?<br>
  아니다, `char`형 배열은 해당 메서드를 사용하면 예외적으로 각 요소마다 구분자(`,`와 추가로 `[]`도) 없이 배열에 저장된 값들이 출력되게 된다.<br>
  예시 코드를 보도록 하자.<br>
  
  ```java
  char[] ex_char_arr = {'a', 'b', 'c', 'd', 'e', 'f'};
  
  System.out.println(Arrays.toString(ex_char_arr));
  ```
  위 예시코드를 실행하면 다음과 같은 출력이 이루어진다.<br>
  
  ```java
  abcdef
  ```
  왜 `char`형 배열에만 이런일이 일어나는 걸까?<br>
  이유는 `println` 메서드가 `char`형 배열일때만 이렇게 동작하도록 작성되었기 때문이다.<br>
<br>

- #### 배열의 이름(배열의 참조 변수)값을 바로 출력하기
  배열의 이름 즉, 배열을 참조하고 있는 참조변수값을 바로 출력하면 어떻게 될까?<br>
  다음 예시코드를 보도록 하자.<br>
  
  ```java
  int[] ex_arr = {100, 90, 80, 70, 60};
  
  System.out.println(ex_arr);
  ```
  위 예시코드를 실행하면 다음과 같은 출력이 이루어진다.<br>
  
  ```java
  [I@28d93b30
  ```
  이게 무슨 뜻일까?...<br>
  
  위와 같이 배열의 참조변수 값을 바로 출력하는 경우에는 `[타입@주소]` 형식의 출력이 이루어진다.<br>
  `I`는 1차원 `int`형 배열이라는 의미이고, `@`뒤에 이어지는 16진수는 배열의 주소를 의미하는데, 실제 주소가 아닌, 내부 주소이다.<br>
<br>

### `Math.random()`메서드를 이용하여 배열의 요소 섞기
`java.lang`패키지의 `Math.random()`메서드를 이용하여 배열의 요소들을 섞는 방법을 정리해 보도록 하겠다.<br>
그 전에 먼저, 기본적으로 알아야 할 두 변수에 저장된 값을 교환하는 법(Swap)을 간단히 정리해 보았다.<br>

- #### 두 변수에 저장된 값 교환하기(Swap)

  ```java
  int a = 10;
  int b = 20;
  ```
  위의 두 int형 변수 `a`, `b`에 저장되어 있는 값을 서로 교환해주는 코드는 다음과 같다.<br>
  ```java
  int a = 10;
  int b = 20;
  int temp = 0;

  temp = a;
  a = b;
  b = temp;
  ```
  이 코드를 보고 *'엥, 두 변수에 저장된 값을 교환 하려면 단순히 `a = b, b = a` 이런식으로 바꿔주기만 하면 되는거 아닌가?<br>
  `temp`는 왜 추가한거지?'* 라는 생각이 들 수 있다.<br>

  하지만, 해당 방법을 사용하면, 값을 교환할 수 없게 된다.<br>
  ```java
  int a = 10;
  int b = 20;

  a = b;  // 기존 a에 저장되어 있던 값인 10이 소멸되고 b에 저장되어 있는 값인 20이 들어감.
  b = a;  // b에 a에 저장되어 있는 값, 20이 들어감. 결국, a에는 20, b에도 20이 들어가게 됨.
  ``` 
  위 방법을 사용하면 주석에도 정리해 놓았듯이, `a = b`의 경우, `a`에 `b`안에 저장되어 있는 값인 20이 들어가면서 기존에 `a`에 저장되어 있던<br>
  값인 10이 지워지게 된다.<br>

  그 상태에서 값을 교환한답시고 `b = a`를 해버리면, `a`에 새롭게 저장된 값인 20이 `b`에 저장되어, 결국엔 `a`에는 20이, `b`에도 20이 저장되게 된다.<br>
  교환이 이루어지지 않은 것이다.<br>

  이를 해결하기 위해서 필요한 것이 임시저장소 역할을 하는 변수 `temp`이다.<br>

  위의 방법이 교환에 성공하지 못한 이유는 10이라는 값을 저장하고 있는 `a`라는 변수에 바로 `b`가 저장하고 있는 값인 20을 저장해서 기존 `a`에 <br>
  저장되어 있던 값, 10이 지워져 버렸기 때문이다.<br>

  그래서, **`a`에 교환할 값을 저장하기 전에, 미리 임시저장소 `temp`에 기존 `a`에 저장되어 있던 10을 임시 보관해 주어야 한다!**<br>
  이러한 방식을 적용하여 코드를 완성해보면 다음과 같다.<br>

  ```java
  int a = 10;
  int b = 20;
  int temp = 0;

  temp = a;  // 임시 저장소 temp에 a에 저장된 값 10을 임시저장
  a = b;  // a에 b가 저장하고 있는 값 20을 저장 - 기존 a에 저장되어 있던 10이 지워지고, 20이 a에 저장됨
  b = temp  // a는 현재 20을 저장하고 있기 때문에, 기존에 a에 저장되어 있던 값인 10을 저장하고 있는 임시저장소 temp의 값을 b에 저장
  ```
  이렇게 두 변수의 값을 교환하는 법에 대해 정리해 보았으니, 이제 본론으로, `Math.random()`메서드를 이용해 배열의 요소들을 섞어주는 법을 <br>
  알아보도록 하겠다.<br><br>
  
- #### `Math.random()`메서드를 이용하여 배열의 요소 섞기(Shuffle)
  `Math.random()`메서드는 이전에 설명하였듯이, 어느 한 범위 내에서 임의의 정수, 즉 난수를 뽑는 용도로 많이 사용하는 메서드이다.<br>

  `Math`클래스는 `java.lang` 패키지에 속해있는 클래스로, 이 `java.lang` 패키지에 속해있는 클래스들은 자바에서 특별히`import`를 <br>
  하지 않더라도, 클래스 명으로 사용이 가능하게 해 주었기 때문에, 따로 `import`를 하지 않아도 된다!<br>

  이 `java.lang` 패키지와 `Math.random()`메서드에 대한 설명은 다음 링크에 자세히 설명해 놓았다.<br>
  [패키지 (Package)](https://github.com/Yoonsik-2002/java-study/tree/main/src/_00_other_knowledge/_01_package)<br><br>
  
  먼저, 여기 1 ~ 10까지의 숫자가 저장되어 있는 배열 `arr`이 있다고 해 보자.<br>
  ```java
  int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  ```
  
  이 배열에 저장되어 있는 요소들을 `Math.random()`메서드를 활용하여 서로 100회 섞어보도록 하겠다.<br>
  이를 구현하기 위해서는 다음과 같은 for문이 필요할 것이다.<br>
  ```java
  int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  
  // 100번 반복해서 배열 arr의 요소들을 섞어주기 위해 필요한 반복문
  for (int i = 0; i < 100; i++) {
    
  }
  ```
  그럼, 이제 이 for문에 들어갈 코드들을 구상해 보도록 하겠다.<br>
  내가 배열 `arr`의 요소들을 섞기 위해 사용하고 싶은 방식은 다음과 같다.<br>
  
  > 배열의 첫 번째 인덱스(index 0)에 저장되어 있는 값과 0 ~ 9 까지의 인덱스 중 무작위로 하나를 골라, 해당 인덱스에 저장되어 있는 값을 <br>
  > 교환한다. 이 동작을 100번 반복한다.<br><br>
  > 그러면, 결론적으로, 첫 번째 인덱스(index 0)는 고정된 상태로, 이 첫 번째 인덱스에 저장되어 있는 값과 for문을 통해 반복할 때 마다, <br>
  > 0 ~ 9 까지의 인덱스 중, 무작위로 뽑힌 인덱스에 저장된 값이 교환되며, 배열 `arr`의 요소들이 뒤섞이게 된다.<br>
  
  해당 방식을 그림으로 표현하면 다음과 같다.<br>
  <br>
  
  ![51DEF8E1-7F59-4B2A-A11B-A4EAA7964F21](https://github.com/Yoonsik-2002/java-study/assets/83572199/b928bfcc-d52d-411d-bf93-f2dc4da30b23)<br>
  ![5DC27379-B6A8-4982-8990-342A0A346263](https://github.com/Yoonsik-2002/java-study/assets/83572199/aef638fe-21d8-4f1d-8696-fbfd077cdc47)<br>
  ![E9E3A699-F0B7-430C-88E0-12EE330BED68](https://github.com/Yoonsik-2002/java-study/assets/83572199/6f06b914-a5f2-4ae5-9f6c-a8ef32b8cbc1)<br>
  ![7DBCAB6E-3912-4C46-8A16-0870746D170E](https://github.com/Yoonsik-2002/java-study/assets/83572199/2d6e837f-9150-4c23-b626-ac0230033a81)<br>
  <br>
  위 과정이 for문을 통해 100번 반복되며, 배열의 요소들이 골고루 뒤섞이게 되는 것이다!<br>
  
  개인적으로 생각해본 해당 부분을 코드로 구현할 시, 중요하게 생각해야 할 부분은 '고정된 대상 `arr[0]`과 `arr`의 0 ~ 9 까지의 인덱스중, 하나를<br>
  무작위로 뽑은 값(인덱스)에 해당하는 값인 `arr[rand] (이때, rnad 는 (int)(Math.random() * 10)의 결과값)`의 교환을 여러번 반복하면,<br>
  해당 배열의 요소들을 골고루 섞어줄 수 있다는 것' 이였다.<br>
  
  그럼, 위 for문에 들어갈 부분을 채워서 해당 코드를 완성해 보겠다.<br>
  ```java
  import java.util.Arrays;
  
  class Ex05_5 {
    public static void main(String[] args) {
      int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  
      for (int i = 0; i < 100; i++) {
        int rand = (int)(Math.rand() * 10);
    
        int temp = arr[0];
        arr[0] = arr[rand];
        arr[rand] = temp;
      }
  
      System.out.println(Arrays.toString(arr));
    }
  }
  ```
  <br><br>
  
### String 클래스
String 클래스는 `java.lang`패키지에 소속된 클래스로, 따로 `import`를 하지 않아도 사용이 가능한 클래스이다.<br>
(이는 `java.lang` 패키지 소속 클래스라면, 모두 해당되는 사항)<br>

Java에서는 여러 문자, 즉 문자열을 저장하기 위해, 이 String타입의 변수를 사용한다.<br>
문자열 이라는 것은 '여러개의 문자를 연이어 늘어놓은 것' 을 의미하므로, 문자 배열인 char배열과 같은 뜻이라 할 수 있다.<br>
  
객체지향이라는 개념이 나오기 이전의 언어들은 데이터와 기능을 따로 다루었지만, 객체지향 언어에서는 데이터와 그에 관련된 기능들을<br>
하나의 클래스로 묶어서 사용할 수 있게 해준다.<br>
즉, 데이터와 기능을 따로 구분하여 다루지 않고, 서로 관련된 것이라면, 하나의 클래스로 묶어서 사용하는 것이다.<br>
  
때문에, 객체지향이라는 개념이 나오기 이전 언어인, C언어 에서는 이러한 문자열을 char배열로 다루지만, **객체지향 언어인 Java에서는 <br>
char배열(문자열)과 그에 관련된 기능들을 함께 묶어서 하나의 클래스로 정의한다. 이것이 바로 String 클래스 이다.**<br>

이렇게 Java처럼 문자열을 다룰 때, String클래스를 사용하면 좋은 점은, String클래스 자체가 char배열(문자열)과 관련된 기능들을 추가하여 확장한<br>
것이기 때문에, C언어처럼 달랑 데이터의 개념인 char배열을 사용하는 것보다 데이터와 해당 데이터와 관련된 기능들을 하나로 묶은 개념인<br>
String 클래스를 사용하는 것이 문자열을 다루는데 더욱 편리하고 용이하다는 점이다.<br><br>

- #### String 클래스의 주요 메서드
  String 클래스는 수많은 문자열 관련 메서드들을 제공하지만, 지금은 이 중, 가장 기본적인 메서드 몇 가지만 다뤄보고자 한다.<br>
  
  |메서드|설명|
  |:---:|:-:|
  |char charAt(int index)|문자열에서 해당 위치(index)에 있는 문자를 반환한다.|
  |int length()|문자열의 길이를 반환한다.|
  |String substring(int from, int to)|문자열에서 해당 범위(from ~ to)의 문자열을 반환한다.(to는 포함 안됨)|
  |boolean equals(Object obj)|문자열의 내용이 같은지 확인한다. 같으면 결과는 true, 다르면 false|
  |char[] toCharArray()|문자열을 문자배열(char[])로 변환해서 반환한다.|
  
  #### `charAt`메서드
  `charAt`메서드는 문자열에서 지정한 index에 해당하는 한 문자를 가져와준다. 배열에서 `배열이름[index]`를 통해 index에 위치한 값을 가져오는 것과<br>
  같은 개념이라 생각하면 된다.<br>
  
  배열과 마찬가지로 `charAt`메서드의 index는 0부터 시작한다.<br>
  ```java
  String name = "ChoYoonsik";
  char ch = name.charAt(0);   // 문자열 name의 첫 번째 문자 'C'를 char형 변수 ch에 저장
  ```
  
  #### `substring`메서드
  `substring`메서드는 문자열의 원하는 일부분을 뽑아낼 수 있다. 이때, 주의할 점은 범위의 끝은 포함되지 않는다는 것이다.<br>
  예를 들어, index의 범위가 2 ~ 4 라고 하면, 4는 범위에서 포함되지 않는다.(2 <= x < 4)<br>
  ```java
  String name = "ChoYoonsik";
  String first_name = name.substring(3, 11);
  String last_name = name.substring(0, 3);
  
  System.out.println("성 : " + last_name);
  System.out.println("이름 : " + first_name);
  ```
  
  #### `equals` 메서드
  이 메서드에 관한 설명은 내가 이전에 velog에 자세히 정리해놓은게 있어서 해당 링크를 첨부하도록 하겠다.<br>
    [[Java] 문자열(String)의 생성과 문자열의 비교 equals(), ==의 차이점](https://velog.io/@yoonsik123/TIL-38-Java-%EB%AC%B8%EC%9E%90%EC%97%B4String%EC%9D%98-%EC%83%9D%EC%84%B1%EA%B3%BC-%EB%AC%B8%EC%9E%90%EC%97%B4%EC%9D%98-%EB%B9%84%EA%B5%90-equals-%EC%9D%98-%EC%B0%A8%EC%9D%B4%EC%A0%90)<br>
<br>

### String 배열
String클래스에 대해 알아보았으니, 이제 String배열에 대해 알아보도록 하겠다.<br>

배열의 타입이 String이라고 해도, 선언과 생성 방법은 int형 배열과 다르지 않다.<br>
다음은 3개의 문자열을 저장할 수 있는 String 타입의 배열을 생성하는 코드이다.<br>
```java
String[] str_arr = new String[3];
```
<br>

다음 코드의 결과는 아래 그림과 같이 나타낼 수 있다.<br>
![ACD40224-4D1F-4081-AFFB-86CC7F07944B](https://github.com/Yoonsik-2002/java-study/assets/83572199/ecb8269c-fe9c-47e9-bdda-cf54bf36d8bf)<br>
<br>

다음과 같이 3개의 String 타입의 참조변수 (`str_arr[0]`, `str_arr[1]`, `str_arr[2]`)를 저장하기 위한 공간이 마련되고,<br>
이 참조변수들은 해당 시점에서는 아무것도 가리키고 있지 않기 때문에, 참조형의 기본값인 `Null`로 초기화 되게 된다.<br>

추가로, 변수의 타입에 따른 기본값을 정리해보면, 다음과 같다.<br>
|자료형|기본값|
|:---:|:---:|
|boolean|false|
|char|'\u0000'|
|byte, short, int|0|
|long|0L|
|float|0.0f|
|double|0.0d 또는 0.0|
|참조형|Null|
<br>

다시 본론으로, 이 String 타입의 배열을 초기화 하기 위해선, 원래는 아래 코드와 같이 배열의 각 참조변수에 `new`연산자를 이용하여<br>
객체를 생성해야 한다.<br>
왜냐하면 String은 클래스이기 때문이다.<br>
```java
String[] str_arr = new String[3];
str_arr[0] = new String("Cho");
str_arr[1] = new String("Yoon");
str_arr[2] = new String("Sik");
```
하지만, 특별히 String 클래스의 경우 위 내용을 간략히 큰 따옴표(`""`)만을 사용하여 표현이 가능하다.<br>
```java
String[] str_arr = new String[3];
str_arr[0] = "Cho";
str_arr[1] = "Yoon";
str_arr[2] = "Sik";
```
또 아래와 같이 String 타입의 배열을 생성과 동시에 초기화 할 수도 있다.<br>
```java
String[] str_arr = new String[] {"Cho", "Yoon", "Sik"};
String[] str_arr = {"Cho", "Yoon", "Sik"};
```
<br>

다음은 String 배열과 String 클래스의 몇가지 메서드를 활용하여 만들어본 코드이다.<br>
```java
package chapter_05;

import java.util.Arrays;

class Ex05_7 {
    public static void main(String[] args) {
        String[] str_arr = {"Cho", "Yoon", "Sik"};
        
        /* 
        String[] str_arr = new String[3];
        str_arr[0] = new String("Cho");
        str_arr[1] = new String("Yoon");
        str_arr[2] = new String("Sik");
        
        String[] str_arr = new String[3];
        str_arr[0] = "Cho";
        str_arr[1] = "Yoon";
        str_arr[2] = "Sik";
        
        String[] str_arr = new String[] {"Cho", "Yoon", "Sik"};
        String[] str_arr = {"Cho", "Yoon", "Sik"};
        */
        
        for (int i = 0; i < str_arr.length; i++) {
            System.out.println("str_arr[" + i + "] : " + str_arr[i]);
        }
        System.out.println();
        
        for (int i = 0; i < 100; i++) {
            int rand = (int)(Math.random() * 3);
            String temp = str_arr[0];
            str_arr[0] = str_arr[rand];
            str_arr[rand] = temp;
        }
        System.out.println(Arrays.toString(str_arr));
        System.out.println();
        
        /*
        String 클래스의 메서드 charAt과 subString으로 문자열을 다루는 코드.
        객체지향 언어인 Java는 문자열을 달랑 char배열로 다루지 않고, 
        문자열(char배열)과 해당 문자열과 관련된 메서드들을 String이라는 하나의 클래스로 묶어서 다룬다.
        즉, String 클래스는 [데이터 : 문자열(char배열)] 과 [문자열을 다루는 기능 : 메서드]를 하나로 묶어 확장한 개념이기 때문에
        C언어처럼 달랑 char배열을 사용하여 문자열을 다루는 것 보다 더욱 용이하고, 편리하다. 
        */
        String name = "ChoYoonSik";
        char use_chat = name.charAt(0);
        String use_substr = name.substring(3, 10);
        
        System.out.println(use_chat);
        System.out.println(use_substr);
    }
}
```
<br>

[실행결과]
```java
str_arr[0] : Cho
str_arr[1] : Yoon
str_arr[2] : Sik

[Cho, Sik, Yoon]

C
YoonSik
```
<br>

### 2차원 배열
2차원 배열은 주로 테이블 형태의 데이터를 다룰 때 사용하며, 선언 방법은 다음과 같다. 
```java
타입[][] 변수이름;   // 타입 변수이름[][]; , 타입[] 변수이름[]; 형태의 선언도 가능하다. 배열의 차원 수 만큼 대괄호를 추가해주면 됨
```
<br>

4행3열의 int형 데이터를 저장하는 2차원 배열 `ex_arr`을 생성해 보도록 하겠다.<br>
```java
int[][] ex_arr = new int[4][3];
```
<br>

해당 코드가 수행되면, 아래 그림과 같은 4행3열의 총 12개의 int형 데이터를 저장할 수 있는 공간이 생성된다.<br>

![5D64F79B-5BE3-4E93-B8BD-26B19BD47D0F](https://github.com/Yoonsik-2002/java-study/assets/83572199/4736bb5b-0bef-4936-8b52-b3cc54f80b3f)<br>
<br>

다음과 같이 배열을 생성하면, 배열의 각 요소에는 배열요소의 타입의 기본값(배열`ex_arr`의 요소의 타입은 int형, int형 타입의 기본값은 0)이<br>
자동적으로 저장되게 된다.<br>

이렇듯, 2차원 배열은 행과 열로 이루어져 있는 테이블형태로 데이터를 저장하는 배열이다. 때문에, 2차원 배열의 인덱스는 행과 열에 각각 존재한다.<br>
또, 각 인덱스의 범위는 행`0 ~ 배열의 길이 - 1`, 열`0 ~ 배열의 길이 - 1`이다.<br>
그리고, 2차원 배열의 요소에 접근하기 위해서는 원하는 요소의 행 인덱스와 열 인덱스를 통해 접근해야 한다.<br>

만약, 위에서 생성한 2차원 배열`ex_arr`의 경우, 해당 배열을 생성하면, `ex_arr[0][0]` ~ `ex_arr[3][2]` 까지 총 12개의 int형 데이터를 <br>
저장할 수 있는 공간이 생성되게 된다.<br>
그리고, 만약 `ex_arr`의 두 번째 행의 세번째 열에 있는 데이터에 접근하고 싶으면 `ex_arr[1][2]`을 사용하면 된다.<br>

2차원 배열의 초기화에 들어가기 전, 4행 3열의 `ex_arr` 배열을 생성하고 네 번째 행의 두 번째 열에 100을 저장하고, 해당 데이터를 출력하는<br>
간단한 코드를 작성해 보겠다.<br>

```java
int[][] ex_arr = new int[4][3];

ex_arr[3][2] = 100;
System.out.println(ex_arr[3][2]);
```
<br>

2차원 배열 또한 `{}`를 이용하여 생성과 초기화를 동시에 할 수 있다. 2차원 배열 초기화 시, 1차원 배열과의 차이점은 초기화 하고싶은 행들을<br>
`{}`로 한번 더 감싸서, 행별로 구분하여 초기화 해준다는 것이다.<br>

다음은 2차원 배열을 초기화 하는 코드이다.<br>

```java
// 2차원 배열 또한 생성과 동시에 초기화 시, new 타입[][] 생략 가능
int[][] ex_arr = new int[][] {{10, 20, 30, 40}, {50, 60, 70, 80}, {90, 100, 110, 120}};
int[][] ex_arr = {{10, 20, 30, 40}, {50, 60, 70, 80}, {90, 100, 110, 120}};

// 위와 같이 2차원 배열은 한줄에 한번에 생성과 초기화를 동시에 할 수 있지만, 아래와 같이 행 별로 줄바꿈을 해 주는 것이 더욱 알아보기 쉽다.
int[][] ex_arr = {
                  {10, 20, 30, 40},
                  {50, 60, 70, 80},
                  {90, 100, 110, 120}
                 };
```
<br>

위의 코드를 실행하면, 행 별로 첫 번째 행에는 `{10, 20, 30, 40}`이, 두 번째 행에는 `{50, 60, 70, 80}`이, 세 번째 행에는 `{90, 100, 110, 120}`
이 작성한 그대로, 이차원 배열`ex_arr`이 생성과 동시에 해당 값들로 초기화 되게 된다.<br>
<br>

### `Arrays`클래스로 배열 다루기
`java.util`패키지의 `Arrays`클래스는 배열을 다루는데 유용한 메서드들을 제공해 준다.<br>
이 메서드들 중, 자주 사용되는 메서드 몇 가지를 정리해 보도록 하겠다. (더욱 자세한 내용은 chapter_11에서 ...)<br>

- #### 1차원 배열, 2차원 배열의 비교와 모든 요소 문자열로 출력 - `equals()` `deepEquals()`, `toString()` `deepToString()`
  `toString()`메서드는 배열의 모든 요소들을 문자열로 출력해주는 메서드이다. 하지만, 이 `toString()`메서드는 1차원 배열에만 사용이 가능하다.<br>
  
  2차원 배열의 모든 요소들을 문자열로 출력하기 위해서는 `deepToString()`메서드를 사용한다. 해당 메서드는 배열의 모든 요소를 재귀적으로 접근해서<br>
  문자열을 구성하기 때문에, 2차원 상의 다차원 배열에도 사용이 가능하다.<br>
  
  ```java
  int[][] ex_arr = {
      {1, 2, 3, 4, 5},
      {6, 7, 8, 9, 10}
     };
     
  System.out.println(Arrays.deepToString(ex_arr));   // 출력결과 : [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]]
  ```

  `equals()`메서드는 두 배열에 저장되어 있는 모든 요소들을 비교하여, 일치하면 `true`, 일치하지 않으면 `false`를 반환해주는 메서드이다.<br>
  이때, `equals()`메서드는 1차원 배열에만 사용이 가능하다.<br>
  때문에, 다차원 배열의 비교에는 `deepEquals()`메서드를 사용해야 한다.<br>
  
  ```java
  String[][] ex_arr_1 = {{"aaa", "bbb"}, {"AAA", "BBB"}};
  String[][] ex_arr_2 = {{"aaa", "bbb"}, {"AAA", "BBB"}};
  
  System.out.println(Arrays.deepEquals(ex_arr_1, ex_arr_2);   // true 반환
  System.out.println(Arrays.equals(ex_arr_1, ex_arr_2);   // false 반환(정상 작동 x)
  ```
<br>

- #### 배열의 복사 - `copyOf()`, `copyOfRange()`
  `copyOf()`메서드는 배열 전체를, `copyOfRange()`메서드는 배열의 일부를 복사하여 새로운 배열을 만들어 반환해준다.<br>
  이때, 두 메서드에 지정되는 범위의 끝은 포함되지 않는다.<br>
  두 메서드를 사용하는 방식은 다음과 같다.<br>
  ```java
  Arrays.copyOf(복사할 배열의 이름, 범위);
  Arrays.copyOfRange(복사할 배열의 이름, 시작과 끝 범위);
  ```
  
  ```java
  int[] ex_arr = {0, 1, 2, 3, 4};
  
  int[] ex_arr_cp1 = Arrays.copyOf(ex_arr, ex_arr.length);   // ex_arr_cp1 = [0, 1, 2, 3, 4] 
  int[] ex_arr_cp2 = Arrays.copyOf(ex_arr, 3);   // ex_arr_cp2 = [0, 1, 2]
  int[] ex_arr_cp3 = Arrays.copyOf(ex_arr, 7);   // ex_arr_cp3 = [0, 1, 2, 3, 4, 0, 0] 기존 배열의 범위를 넘어가면, 해당 배열의 타입의 기본값으로 초기화 되어 복사됨
  int[] ex_arr_cp4 = Arrays.copyOfRange(ex_arr, 1, 5);   // ex_arr_cp4 = [1, 2, 3]
  int[] ex_arr_cp5 = Arrays.copyOfRange(ex_arr, 0, 7);   // ex_arr_cp5 = [0, 1, 2, 3, 4, 0, 0] 
  ```
<br>

- #### 배열의 정렬 - `sort()`
  `sort()`메서드는 배열을 정렬할 때 사용하는 메서드로, 아래와 같이 사용이 가능하다.<br>
  ```java
  int[] ex_arr = {1, 3, 0, 4, 5, 2};
  Arrays.sort(ex_arr);   // 배열 ex_arr을 정렬함
  System.out.println(Arrays.toString(ex_arr));   // [0, 1, 2, 3, 4, 5] 출력
  ```
<br>

- #### String을 char배열로 - `toCharArray()`
  String 클래스는 char배열과 관련된 메서드들을 하나로 묶은 개념이라고 앞서 소개하였다. String클래스에서는 String을 char배열로 변환해주는<br>
  메서드를 제공하는데,<br>
  바로, `toCharArray()`메서드이다. 사용 방식은 아래 예시코드를 보도록 하자.<br>
  
  ```java
  String[] ex_arr = {"television", "computer", "mouse", "phone"};
  
  char[] cpt = ex_arr[1].toCharArray();   // String 배열의 두 번째 인자인 computer를  char배열로 변환하여 char배열의 레퍼런스 변수 cpt에 저장
  
  System.out.println(Arrays.toString(cpt)); // computer 출력
  ```
  참고로, 이름이 비슷해서 헷갈릴 수도 있는데, 배열에 저장된 요소들을 문자열형태로 출력해주는 메서드 `toString()`은 `java.util`패키지의<br>
  `Arrays`클래스에 속한 메서드이고, 방금 사용한 `toCharArray()`메서드는 `java.lang`패키지의 `String`클래스에 속한 메서드이다.<br>
<br>

### 메소드에서 배열 리턴
메소드에서 어떤 배열이든 리턴할 경우, 해당 배열 전체가 아닌, 배열의 레퍼런스를 리턴하게 된다.<br>

배열을 생성하고 해당 배열을 리턴하는 메소드 `makeArray()`메소드를 만들어 보겠다. `makeArray()`메소드를 만드는데 있어,<br>
주의할 점은 다음과 같다.<br>

- 메소드는 레퍼런스만 리턴하기 때문에, `makeArray()`메소드의 리턴타입을 선언할 때, [] 안에<br>
  배열의 크기를 지정하지 않는다.<br>
  
- `makeArray()`메소드에서 리턴하는 배열의 타입이 리턴받는 레퍼런스 변수의 타입과 일치해야 한다.<br>

다음은 배열을 생성하여 리턴하는 `makeArray()`메소드와 `makeArray()`로부터 생성된 배열을 리턴받는<br>
코드이다.<br>
```java
int[] makeArray() {
  int[] temp = new int[4];
  return temp;
}

... 

int[] newIntArray = makeArray();
```
`makeArray()` 메소드가 return하고 나면, 지역변수인 `temp`는 사라지게 된다. 하지만, `temp`가 가리키고 있는,<br>
(`temp`가 `new`키워드를 통해 할당받은) 배열 메모리는 사라지지 않는다.<br>

---



            










  
  
  
 
  
  
  
  
  
  



  


  






  
  
  
    
    
  
  

  
