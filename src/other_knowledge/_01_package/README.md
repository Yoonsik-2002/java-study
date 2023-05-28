## 패키지 (Package)
패키지란 서로 관련있는 자바 클래스들을 하나로 모아둘 수 있는 자바의 디렉토리이다.<br>

이렇게 패키지를 이용하여 비슷한 성격의 자바 클래스들을 모아두는 이유는 다음과 같다.<br><br>

- 서로 관련있는 자바 클래스들을 패키지 단위로 모아두기 때문에 클래스 분류가 용이하다.

- 자바 코드 작성 시, 다른사람이 작성한 라이브러리나 클래스를 사용하게 되는 경우가 많이 있는데, 이때 가져오려는 클래스 명이<br>
  같은 경우, 클래스의 패키지 이름으로 각 클래스를 구분할 수 있다.<br>
  결론적으로 클래스 명이 동일하더라도 패키지 이름이 다르면 충돌없이 해당 클래스를 가져와 사용이 가능하다.<br>
  따라서, 배포용으로 작성하는 자바 클래스는 반드시 패키지 명을 포함해야 한다.<br>
<br><br>

### 자바의 모듈과 패키지, 클래스의 관계
먼저, 패키지란 위에서 설명하였듯이, 서로 관련있는 클래스나 인터페이스의 컴파일된(`.class`) 파일들을<br>
한 곳에 묶어놓은 것이다.<br>

때문에, 패키지는 디렉토리와 비슷한 성격을 띈다고 할 수 있다. 결국 하나의 패키지는 관련된 클래스 파일들이 들어있는<br>
디렉토리라 볼 수 있다.<br>

자바 JDK는 개발자들에게 많은 클래스들을 패키지 형태로 제공하는데, JDK 9부터는 이러한 패키지들을 모듈(module)이라는 단위로 묶어,<br>
100개 가까운 모듈을 제공한다.<br>
<br>

- #### 자바 JDK란?
  JDK란 Java Development Kit의 약자로, 자바 개발도구를 의미한다. 자바를 설치하게되면, 이 JDK가 설치되게 되는데, 이 JDK는 개발자들이 <br>
  사용할 수 있는 많은 클래스들이 서로 관련성을 띄는 것들끼리 모여, 하나의 패키지 단위로 각각 분류되고,<br>
  
  이렇게 관련성을 띄는 클래스들끼리 모여 만들어진 여러개의 패키지들은 또 4개의 모듈(`java.desktop`, `java.base`, `java.rmi`, `java.sql`) 에<br>
  분류되어 담겨있는 형태로 제공된다.<br>
  
  결국 개발자들이 자바를 설치하면, 자바에서 제공하는 기본 클래스들이 패키지 -> 모듈에 걸쳐 분류된 형태로 제공되는 것이 바로 이 자바 개발도구, JDK인 것이다.<br>
  
  또, 이런식으로 자바에서 제공하는 기본 클래스들을 자바 API라고 한다.<br>
  (JDK [ `모듈 -> 패키지 -> 기본 클래스들, 이 기본 클래스들이 바로 자바 API` ])<br>
  
  우리가 화면에 문자열을 출력하기 위해 흔히 사용하는 `System.out.println()`에서 `System`은 JDK의 `java.lang`패키지에 속해있는 클래스이다.<br>
  이렇듯, 만약 자바API가 없다면, 개발자가 화면 출력, 키 입력, 네트워킹 등 모든 기능을 직접 구현해야 한다.<br>
  
  다음은 JDK의 표준 패키지 계층 구조를 나타낸 그림이다.<br><br>
  
  ![6096190E-4A6A-4971-B168-60BD4E59F1B8](https://github.com/Yoonsik-2002/java-study/assets/83572199/537fbbab-3fbe-41c6-ab13-1904780dd535)<br>
<br><br>
  
### `import`문
위에서 설명했듯이, 패키지란 서로  클래스들을 모아둔 하나의 단위(디렉토리)이다.<br>
이렇게 패키지 안에 속한 클래스를 다른 파일에서 사용하기 위해서는 클래스 이름 앞에 패키지의 경로까지 포함한 full name까지<br>
명시해 주어야만 사용이 가능하다.<br>

이렇게 다른 파일에서 클래스를 가져와 사용할 때마다 해당 클래스의 패키지 경로까지 포함한 긴 이름을 사용하는 것은 비효율적이다.<br>
그래서 Java 에서는 `import`라는 키워드를 제공하고 있다.<br>

`import`문은 자바 컴파일러에게 코드에서 사용할 클래스의 패키지에 대한 정보를 미리 제공해주는 역할을 한다.<br>
따라서, `import`문을 사용하면 다른 패키지에 속해있는 클래스를 가져와 사용할 때, 패키지 경로를 제외한 클래스 이름만으로 가져와<br>
사용할 수 있게 된다.<br>
<br>

- #### `import`문에 대한 추가적인 설명 (`Scanner`예시)
  응용 프로그램에서 다른 패키지에 있는 클래스를 사용하기 위해서는 패키지 이름을 포함한 경로명을 사용하여야 한다고 위에서 설명하였다.<br>
  이러한, 사용하고자 하는 클래스와 해당 클래스의 패키지 이름까지 포함한 경로명을 **완전 경로명** 이라고 하겠다.<br>
  
  이런식으로 다른 패키지에 속해있는 클래스를 사용할 때 완전 경로명을 사용하는 이유는 컴파일러가 사용하고자 하는 클래스 파일의 위치를<br>
  정확히 찾을 수 있도록 하기 위해서이다.<br>
  <br>
  **다음은 `java.util`패키지(`JDK`의 `java.base`모듈의 `java.util`패키지)의 `Scanner`클래스 사용 예시이다.**<br>
  ```java
  public class ImportExample {
    public static void main(String[] args) {
      java.util.Scanner scanner = new java.util.Scanner(System.in);
      String name = scanner.nextLine();
      
      System.out.println(name);
    }
  }
  ```
  해당 예시처럼 `Scanner`를 사용할 때 마다 완전 경로명을 사용할 경우, 코드가 길어지고, 그만큼 오타가 날 가능성도 높아진다.<br>
  한마디로 비효율적이다.<br>
  
  이러한 문제를 해결하기 위해 `Java`에서는 `import`라는 키워드를 제공한다. 해당 키워드는 위에서 설명했듯이, 사용하고자 하는 클래스의 경로를<br>
  컴파일러에게 미리 제공해 주는 역할을 한다.<br>
  
  때문에, `import`문을 사용하면, 사용하고자 하는 다른 패키지의 클래스의 이름만 가지고 해당 클래스를 사용할 수 있다.<br>
  <br>
  **다음은 `import`문을 이용하여 `Scanner`클래스를 사용하는 예시 코드이다.**<br>
  ```java
  import java.util.Scanner;
  
  public class ImportExample {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String name = scanner.nextLine();
      
      System.out.println(name);
    }
  }
  ```
  `import`문을 사용할 때 주의할 점은 *`import`문은 반드시 소스 코드의 앞 부분에 작성되어야 한다는 것이다.*<br>
  또, 위 예시코드가 `import`문을 통해서 `java.util`패키지에 속해있는 `Scanner`클래스의 경로명을 딱 찍어서 컴파일러에게 알려준 것이라면,<br>
  
  한 패키지에 속해있는 여러 클래스를 사용하고 싶을 때에는 일일이 클래스마다 `import`문을 사용하는 것이 아니라, `*`를 사용하여, 한 패키지의<br>
  모든 클래스들을 대상으로 지정해 줄 수 있다.<br>
  > 일반적으로, 프로그래밍에서 `*`는 모든 것(everything)이라는 의미로 통용된다.<br>
  
  **`java.util`패키지를 예로 들면 다음과 같다.**<br>
  ```java
  import java.util.*;
  ```
  해당 코드를 통해, `java.util`패키지에 속해 있는 모든(`*`) 클래스들의 경로를 컴파일러에게 알려주게 되고,<br>
  결과적으로, `java.util`패키지에 속해 있는 클래스라면, 완전 경로명을 사용하지 않고, 해당 클래스의 이름만으로 사용이 가능하게 된다.<br>
  <br>
  **다음은 `*`을 이용한 `import`문을 통해 `java.util`패키지의 `Scanner`클래스와 `Arrays`클래스를 사용하는 예시 코드이다.**<br>
  ```java
  import java.util.*;
  
  public class ImportExample {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String name = scanner.nextLine();
      
      System.out.println(name);
      
      char[] char_arr = {'y', 'o', 'o', 'n', 's', 'i', 'k'};
      System.out.pritnln(Arrays.toString(char_arr);
    }
  }
  ```
  <br><br>

### `java.util`패키지
`java.util`패키지(package)는 말 그대로 Java 프로그래밍에 있어, 유용한 클래스들을 모아둔 것으로,<br>
대표적인 클래스들은 날짜와 관련된 `Date`, `Calender`등이 있으며, 자료구조와 알고리즘 관련 클래스들의 집합인<br>
컬렉션 프레임워크(Collection Framework)도 포함되어 있다.<br>

> 컬렉션 프레임워크(Collection Framework)란?
  다수의 데이터들을 쉽고 효과적으로 처리(데이터 저장, 데이터 처리) 할 수 있는 표준화된 방법을 <br>
  제공하는 클래스들의 집합이다.<br><br>
  즉, 데이터를 저장하는 자료구조와 저장된 데이터를 처리하는 알고리즘을 클래스로 구현해 놓은 것이다.<br>
  이러한 컬렉션 프레임워크는 Java의 인터페이스(Interface)를 사용하여 구현한다.<br>
<br>

#### `java.util`패키지에 속한 클래스들
  `java.util` 패키지에 속한 클래스들을 정리해보면 다음과 같다.
  <br>
  
  ```java
  AbstractCollection, 
  AbstractList, AbstractSequentialList, LinkedList, ArrayList, Vector, Stack, 
  AbstractSet, HashSet, LinkedHashSet, TreeSet, 
  AbstractMap, HashMap, LinkedHashMap, TreeMap, 
  Arrays, BitSet, Calendar, GregorianCalendar, 
  Collection, Date, Dictionary, Hashtable, Properties, 
  EventObject, Locale, Observable, Random, Scanner, StringTokenizer
  ```
<br>
  
### `java.lang` 패키지
`java.lang`패키지는 자바에서 가장 기본적인 동작을 수행하는 클래스들의 집합이다.<br>
따라서, Java에서는 이 `java.lang`패키지에 속해있는 클래스들은 따로 `import`문을 사용하지 않아도, 클래스 이름만으로도<br>
사용할 수 있게 하고있다.<br>
<br>

#### `Math`클래스
`java.lang` 패키지의 `Math`클래스는 이름 그대로 수학에서 자주 사용하는 상수들과 함수들을 미리 구현해 놓은 클래스이다.<br>
<br>

#### `random()`메소드
임의의 정수, 난수를 만들때, Java에서 우리는 `Math.random()`메소드를 사용할 수 있다.<br>

`Math`클래스의 `random()`메소드는 0.0과 1.0 사이의 범위에 속하는 (0.0 <= `Math.random()` < 1.0)<br>
임의의 double 값을 반환한다.<br>
즉, Math.random()`메소드가 기본적으로 반환하는 double 값은 0.0 ~ 0.999999999... 가 될 것이다.<br>

하지만, 우리가 원하는 것은 난수, 즉 임의의 정수이다. 때문에, 해당 값을 `Math.random()`메소드를 통해 반환받기 위해서는<br>
기본적으로 0.0 ~ 1.0미만의 double 값을 반환하는 해당 메서드를 어느정도 손봐줄 필요가 있다.<br>
<br>

#### `Math.random()`메소드로 1 ~ 7중, 임의의 정수 구하기
`Math.random()`메소드로 1 ~ 7 중 임의의 정수를 구하기 위한 과정을 정리해 보겠다.<br>

- #### 1) 각 변에 7을 곱해준다.
  ```java 
  0.0 * 7 <= Math.random() * 7 < 1.0 * 7
  0.0 <= Math.random() * 7 < 7.0   // 나올 수 있는 값의 범위 : 0.0 ~ 6.99999....
  ```
  
- #### 2) 각 변을 int형으로 형변환 한다. 
  ```java
  (int)0.0 <= (int)(Math.random() * 7) < 7.0
  0 <= (int)(Math.random() * 7) < 7   // 나올 수 있는 값의 범위 : 0 ~ 6
  ```
  
- #### 3) 각 변에 1을 더해준다. 
  ```java
  0 + 1 <= ((int)(Math.random() * 7) + 1) < 7 + 1
  1 <= ((int)(Math.random() * 7) + 1) < 8   // 나올 수 있는 값의 범위 : 1 ~ 7
  ```
  `1 <= ((int)(Math.random() * 7) + 1) < 8`에서 `* 7`은 내가 원하는 값의 개수, 개별값의 개수를 의미한다.<br>
<br>

#### 난수의 범위를 자유자재로 정해서 임의의 정수 구하기
`Math.random()`메소드로 여러 다양한 범위에서의 임의의 정수를 구하는 식을 만들어 보겠다.<br>

- #### Quiz 1) -5 ~ 5 까지의 난수를 `Math.random()`메소드로 표현해라
  ```java
  (int)(Math.random() * 11)  // 현재 범위 : 0 <= Math.random() < 11
  ((int)(Math.random() * 11) -5) // 현재 범위 : -5 <= Math.random() < 6
  ```
  먼저, 기본적으로 `Math.random()`함수의 범위를 보도록 하자.<br>
  
  `0.0 <= Math.random() < 1.0`<br>
  
  여기서, 우리가 원하는 값은 임의의 정수이기 때문에 int형으로 형변환 해준다.<br>
  
  `0 <= (int)(Math.random()) < 1`<br>
  
  이때, -5 ~ 5 까지 내가 원하는 값의 개수(-5 ~ 5 까지의 값들의 개수) 즉, 개별값은 `-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5` 이렇게 총 11개이다.<br>
  때문에, 위 식의 양 변에 11을 곱해준다.<br>
  
  `0 <= (int)(Math.random() * 11) < 11`<br>
  
  이 상태에서, 우리가 원하는 값의 범위는 -5 ~ 5 이기 때문에, 양 변에 -5를 해주면 다음과 같은 식이 완성된다.<br>
  
  `-5 <= ((int)(Math.random() * 11) -5) < 6`<br>
  
  결국 `((int)(Math.random() * 11) -5)`가 반환하는 값은 -5 이상, 6미만인 임의의 정수가 된다!!<br>
  <br>
  
- #### Quiz 2) 2 ~ 17 까지의 난수를 `Math.random()`메소드로 표현해라
  ```java
  (int)(Math.random() * 16) // 현재 범위 : 0 <= Math.random() < 16
  ((int)(Math.random() * 16) + 2) // 현재 범위 : 2 <= Math.random() < 18
  ```
  마찬가지로, 기본적으로 `Math.random()`함수의 범위를 보도록 하자.<br>
  
  0.0 <= Math.random() < 1.0`<br>

  여기서, 우리가 원하는 값은 임의의 정수이기 때문에 int형으로 형변환을 해준다.<br>
  
  `0 <= (int)(Math.random()) < 1`<br>
  
  이때, 2 ~ 17 까지 내가 원하는 값의 개수(2 ~ 17 까지의 값들의 개수) 즉, 개별값은 `17 - 2 + 1`로, 총 16개이다.<br>
  때문에, 위 식의 양 변에 16을 곱해준다.<br>
  
  `0 <= (int)(Math.random() * 16) < 16`<br>
  
  이 상태에서, 우리가 원하는 값의 범위는 2 ~ 17 이기 때문에, 양 변에 2를 더해주면 다음과 같은 식이 완성된다.<br>
  
  `2 <= ((int)(Math.random() * 16) + 2) < 18`<br>
  
  최종적으로, `((int)(Math.random() * 16) + 2)`가 반환하는 값은 2 이상, 18 미만인 임의의 정수가 된다!<br>
  
  
