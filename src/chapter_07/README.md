## 상속(inheritance)
상속이란, 기존의 클래스를 **재사용 하여** 새로운 클래스를 작성하는 것이다.<br>

상속을 이용하여 클래스를 생성하는 경우, 기존의 클래스를 재사용하여 새 클래스를 작성하기 때문에, 보다 적은양의 코드로 클래스를 작성하는<br>
것이 가능하다. 그리고, 코드를 공통적으로 관리(조상 클래스의 변경사항이 자식 클래스에도 반영됨)할 수 있기 때문에, 코드의 추가 및 변경이<br>
용이하다.<br>

이러한 상속의 특징 덕문에, 상속을 이용하면, 코드의 재사용성은 높이고 코드의 중복은 줄여, 프로그램의 생산성과 유지보수에 크게 기여할 수 <br>
있다.<br>
<br>

### 상속의 구현
Java에서 상속을 구현하는 방법은 다음과 같다.<br>
> 새로 작성하고자 하는 클래스의 이름 뒤에 `extends`키워드와, 상속받고자 하는 클래스의 이름을 붙여준다.<br>

예를 들어, 새로 작성하고자 하는 클래스의 이름이`Child`, 상속해주는 클래스의 이름이 `Parant`라면, 다음과 같이 작성하면 된다.<br>
```java
class Child extends Parent {
  // ...
}
```
<br>

위의 `Child`클래스와 `Parent`클래스, 이 두 클래스는 서로 상속 관계에 있다고 표현이 가능하며, 상속을 해주는 클래스를 '조상 클래스',<br>
상속을 받는 클래스를 '자손 클래스' 라고 한다.<br>

이렇게 상속관계에 있는 두 클래스를 가리켜 사용할 수 있는 용어는 '조상 클래스', '자손 클래스' 외에도 아래와 같이 다양한 것들이 있다.<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/3982d9a0-7150-47e3-af81-c59f2f3cd892)<br>
<br>

### 클래스 간의 상속관계
먼저, 클래스 간의 상속관계를 알아보기 쉽게 그림으로 표현하는 상속계층도(class hierarchy)에 대해 알아보도록 하겠다.<br>
```java
class Parent{}
class Child extends Parent{}
```
<br>

위 코드에서의 두 클래스, `Child`와 `Parent`의 경우,  `Child`라는 새로운 클래스가 기존의 `Parent`클래스의 멤버들을 상속받는<br>
상속관계에 있다.<br>

이러한 상속관계를 상속계층도를 이용하여 그림으로 표현할 수 있는데, 클래스는 타원으로, 클래스 간의 상속관계를 화살표를 이용하여<br>
표현하는 방식이다. `Child`와 `Parent`의 상속관계도를 그려보면 다음과 같다.<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/009a1606-e9da-4d75-bd75-456b5540db80)<br>
<br>

이러한 상속관계도를 이용하면, 클래스 간의 관계를 보다 쉽게 이해할 수 있다.<br>
<br>

- ### Example_01) `Child`와 `Parent`의 상속관계
  클래스란, 멤버들의 집합이라 할 수 있다. Java에서 상속이란, 조상 클래스의 이러한 모든 멤버들을 자손 클래스가 상속받는 것을<br>
  의미한다.<br>

  때문에, 자손 클래스는 조상 클래스의 멤버들을 포함한다고 할 수 있다.<br>

  이를바탕으로, `Child`클래스와 `Parent`클래스의 관계를 다이어그램으로 나타내면 다음과 같다.<br>

  ![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/5dc4694d-0b54-434c-9b0b-8f034e536fb0)<br>
  <br>

  이때, 조상 클래스인 `Parent`의 멤버에 변경사항이 생긴 경우와, 자손 클래스인 `Child`의 멤버에 변경사항이 생긴 경우 각각<br>
  서로에게 어떠한 영향을 미치는지 정리해 보도록 하겠다.<br>
  <br>
     
  - #### 조상 클래스(`Parent`)의 멤버에 변경사항이 생긴 경우
    ```java
    class Parent {
      int age;
    }

    class Child extends Parent{ }
    ```
    <br>

    위와 같이, `Child`의 조상 클래스 `Parent`에 `age`라는 int형 변수를 멤버변수로 추가하였다.<br>
    이러한 변경사항은 자손 클래스 `Child`에게 어떠한 영향을 미칠까?<br>

    `Parent`의 멤버를 상속받는 관계에 있는 `Child`는 `Parent`로 부터 `age`를 상속받아, 자동적으로 해당 멤버변수가 추가된<br>
    것과 같은 효과를 얻게 된다.<br>

    ![스크린샷(4)](https://github.com/Yoonsik-2002/java-study/assets/83572199/575505f8-7bc4-489f-8992-330b8c0deac9)<br>
    <br>
    
  - #### 자손 클래스(`Child`)의 멤버에 변경사항이 생긴 경우
    ```java
    class Parent {
      int age;
    }

    class Child extends Parent {
      void play() {
        System.out.println("Let's play~");
      }
    }
    ```
    <br>

    위와 같이, `Child`클래스에 새로운 멤버로 `play()`메서드를 추가해 보았다. <br>
    해당 변경사항은 조상 클래스인 `Parent`에게 영향을 미칠까? <br>

    아니다. `Child`클래스에 새로운 코드가 추가되어도 조상 클래스인 `Parent`는 아무런 영향도 받지 않는다.<br>
     
    ![스크린샷(6)](https://github.com/Yoonsik-2002/java-study/assets/83572199/a1d32127-0880-44ad-b37f-62a5b8652947)<br>
    <br>

    조상 클래스의 변경사항은 자동적으로 해당 조상클래스를 상속받고 있는 자손 클래스는 영향을 받게 되지만, <br>
    자손 클래스가 변경되는 것은 조상 클래스에 아무런 영향을 주지 못한다.<br>
    <br>

  자손 클래스는 조상 클래스의 모든 멤버들을 상속받기 때문에, 멤버의 수가 항상 조상 클래스의 멤버의 수와 같거나 더 많다.<br>
  즉, 상속에 상속을 거듭할 수록 상속을 받는 클래스이 멤버개수는 점점 더 늘어나게 된다.<br>

  이러한 이유로, 상속을 받는다는 것은 조상 클래스를 확장(extend)한다는 의미로 해석될 수 있다. 상속을 할 때 사용하는 키워드가<br>
  `extends`인 이유도 여기에 있다.<br>

  ##### [Java 상속의 특징]
  > 생성자와 초기화 블록은 상속되지 않는다. 멤버만 상속된다.<br>
  > 자손 클래스의 멤버의 개수는 항상 조상 클래스의 멤버의 개수와 같거나 많다.<br>
<br>

- ### Example_02) `Child2`클래스 추가 : 하나의 조상 클래스로 부터 두개의 자손 클래스가 상속을 받는 경우
  `Parent`클래스로 부터 상속을 받는 `Child2`클래스를 새로 작성하여 추가해 보도록 하겠다.<br>

  ```java
  class Parent{}
  class Child extends Parent{}
  class Child2 extends Parent{}
  ```
  <br>

  자, 이제 `Child`클래스와 `Child2`클래스 둘 다 `Parent`클래스를 상속받고 있다.<br>
  이러한 상속관계를 상속 계층도를 이용하여 표현하면 다음과 같다.<br>

  ![스크린샷(4)](https://github.com/Yoonsik-2002/java-study/assets/83572199/cd92be69-79d5-4fb7-a6ce-06b66770af1b)<br>
  <br>

  `Child`와 `Child2`는 모두 `Parent`를 상속받고 있으므로, `Parent`와 `Child`, `Parent`와 `Child2`는 서로 상속관계에 있다고<br>
  할 수 있다.<br>

  그렇다면, `Child`와 `Child2`는 어떠한 관계에 있는 것일까?<br>

  같은 클래스를 상속받고 있다고 해도, `Child`와 `Child2`간에는 서로 아무런 관계도 성립되지 않는다.<br>
  
  *'같은 조상클래스로부터 상속을 받고 있는 형제관계 아니야?'* <- 아니다. **클래스 간의 관계에서 형제관계와 같은 것은 존재하지<br>
  않는다. 부모와 자식의 관계(상속관계)만이 존재할 뿐이다.**<br>
  <br>

  ### 공통 조상을 사용하는 경우 장점
  `Parent`와 같이 두 클래스(`Child`, `Child2`)에 대한 공통 조상을 사용하는 경우는 어떤 경우가 있을까?<br>

  만약, 클래스 `Child`와 `Child2`에 공통으로 추가되어야 하는 멤버(멤버변수, 메서드)가 있다면, 이것들을 `Child`와 `Child2`에<br>
  각각 따로 추가해주기 보다는, 이들의 공통 조상인 `Parent`에 추가해 주는 것이 좋다.<br>

  어차피 `Child`와 `Child2`는 이들의 공통 조상인 `Parent`의 멤버들을 상속받기 때문에, `Parent`에 새로운 멤버를 추가해 주면,<br>
  `Child`와 `Child2`에 새로운 멤버를 추가해 주는 것과 같은 효과를 얻을 수 있다.<br>

  이후로는, `Parent`의 내용만 변경해주면 손쉽게 `Child`와 `Child2`의 내용까지 변경되기 때문에, 작업이 간단해진다.<br>

  공통 조상과 같이, 같은 내용의 코드(자손 클래스들에 공통으로 들어갈 멤버에 관한 코드)를 한 곳에서 관리하면, 코드의 중복이<br>
  줄어든다.<br>
  (반대로 같은 내용의 코드를 다른 장소 예를 들어, 자손 클래스 `Child`, `Child2`에 따로따로 관리하게 되면, 같은 내용의 코드가<br>
  중복됨. 같은 내용의 코드는 하나의 장소에서 관리해야 중복이 일어나지 않음)<br>

  코드의 중복이 일어날 경우, 코드를 관리하는 각 장소 하나하나를 변경해주어야 하기 때문에 유지보수가 어려워지고 일관성을 유지하기<br>
  어려워진다.<br>

  **이처럼 같은 내용의 코드를 하나 이상의 클래스에 중복적으로 추가해야하는 경우, 상속관계를 이용해서 최소화 해주어야 한다!** <br>
  <br>

  ### 직접조상과 간접조상의 관계
  아래 코드와 같이, `Child`클래스를 상속받는 `GrandChild`클래스를 생성하여 보았다.<br>
  ```java
  class Parent{}
  class Child extends Parent{}
  class Child2 extends Parent{}
  class GrandChild extends Parent{}
  ```
  <br>

  이러한 상속관계를 상속 계층도를 이용하여 나타내면 다음과 같다.<br>

  ![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/fafeca4c-3fe8-476b-be11-11b9700fc0c9)<br>
  <br>

  자손 클래스는 조상 클래스의 모든 멤버를 물려받는다. 그렇기 때문에, `GrandChild`클래스는 `Child`클래스의 모든 멤버들과 `Child`<br>
  클래스의 조상인 `Parent`로부터 상속받은 멤버들까지 모두 상속받게 된다.<br>

  그렇기 때문에, `GrandChild`클래스는 `Child`클래스의 자손이기도 하며, `Parent`클래스의 자손이기도 하다.<br>
  이를 더 정확하게 표현하면 다음과 같이 표현이 가능하다.<br>

  - `Child`클래스는 `GrandChild`클래스의 **직접조상(직접적인 상속관계)** 이다.<br>
  - `Parent`클래스는 `GrandChild`클래스의 **간접조상(간접적인 상속관계)** 이다.<br>
  <br>

  그렇다면, 아래와 같이, `Parent`클래스에 int형 멤버변수 `age`를 추가하면, 어떻게 될까?<br>
  
  ```java
  class Parent{
    int age;
  }
  class Child extends Parent{}
  class Child2 extends Parent{}
  class GrandChild extends Parent{}
  ```
  <br>

  당연히 `Parent`를 상속받고 있는 자손 클래스 `Child`, `Child2`, `GrandChild(간접)` 모두에 해당 멤버변수가 추가될 것이다.<br>
  반대로, `Parent`클래스에서 해당 멤버변수 `age`를 삭제하면, 해당 변경사항은 자손 클래스 `Child`, `Child2`, `GrandChild` <br>
  모두에게 적용되어, 세 클래스 모두에서 삭제가 될 것 이다.<br>

  이렇게 조상 클래스만 변경해 주어도, 모든 자손 클래스 그리고 자손의 자손클래스에게 영향까지 영향을 주기 때문에, 클래스간의<br>
  상속관계를 맺어주면, 자손 클래스들의 공통정인 부분은 조상 클래스에 정의하여 한번에 관리하고, 자손 클래스 들은 각자에게<br>
  정의된 멤버만 관리하면 되므로, 각 클래스의 코드가 적어지기 때문에 관리가 용이해진다.<br>
<br>

> **전체 프로그램을 이루는 클래스들을 면밀히 설계 분석하여, 클래스들 간의 상속관계를 적절하게 맺어주는 것이 객체지향 프로그래밍의<br>
> 핵심이다!** <br>
<br>

### 💻 예제 **`7-1`**
예제 `7-1`에서 구현해볼 예제 `Ex07_01_CaptionTvTest.java`프로그램을 작성하기 전에, 해당 프로그램을 이루는 클래스들을 설계 분석하여<br>
클래스들간의 상속관계를 맺어보도록 하겠다. <br>

`Ex07_01_CaptionTvTest.java`프로그램을 구성하는 클래스는 `Tv`와 `CaptionTv`이렇게 2개가 있다. 캡션이란, 송출되는 음성이나 음악을 기호 <br>
혹을 자막으로 나타내주는 기능인데, 이 캡션 기능을 담당하는 `CaptionTv`클래스는 일반 Tv의 기능(Power on/off, Channel up/down)을<br>
담당하는 `Tv`클래스에 캡션 기능을 추가한 형태이다. <br>

그렇기 때문에, 두 클래스는 `CaptionTv`클래스가 `Tv`클래스를 상속받는 상속관계를 띄게 된다. <br>
이를, 상속 계층도로 나타내면 다음과 같다. <br>

![스크린샷(4)](https://github.com/Yoonsik-2002/java-study/assets/83572199/bd0f4c87-5b0c-4798-96ae-9c41952d4413) <br>
 <br>

 이를 토대로, `Tv`, `CaptionTv`클래스를 작성해 보도록 하겠다. <br>

 ```java
class Tv {
  boolean power; // 전원 상태(on/off) - boolean 타입의 멤버변수의 경우, 명시적 초기화를 해주지 않았을 시, 기본값인 (false)으로 자동 초기화 된다.
  int channel; // 채널(up/down) - int 타입의 멤버변수의 경우, 명시적 초기화를 해주지 않았을 시, 기본값인 (0)으로 자동 초기화 된다.

  void power() {power = !power;} // 현재 power의 값 -> 그 반대값 - 스위치 같은 기능(true or false)
  void channelUp() {++channel;}
  void channelDown() {--channel;}
}

class CaptionTv extends Tv {
  boolean caption; // 캡션 기능(on/off)

  void displayCaption(String text) {
    if(caption) { // 캡션 상태가 on(true)일 경우에만 text를 출력
      System.out.println(text);
    }
  }
}

public class Ex07_01_CaptionTvTest {
  public static void main(String[] args) {
    CaptionTv ctv = new CaptionTv();

    ctv.channel = 10;
    ctv.channelUp();
    System.out.println(ctv.channel);

    ctv.displayCaption("Hello, World"); // ctv의 caption이 기본값인 flase로 초기화 되어있기 때문에 작동X
    ctv.caption = true;
    ctv.displayCaption("Hello, World"); // caption을 true로 해주었기 때문에 작동O
  }
}
```
<br>

`Ex07_01_CaptionTvTest`프로그램을 구성하는 클래스인 `Tv`클래스와 `CaptionTv`클래스를 각자 멤버들과 함께 다이어그램으로<br>
표현하면 다음과 같다.<br>
<br>

![스크린샷(6)](https://github.com/Yoonsik-2002/java-study/assets/83572199/34a16782-58b4-4478-b477-72c32115039a)<br>
<br>

마지막으로, 위 코드를 보면 의아할 수 있는 부분이 있다.<br>
```java
CaptionTv ctv = new CaptionTv();
ctv.channel = 10;
```
<br>

*'어? 인스턴스 멤버는 본인이 속한 클래스의 인스턴스가 생성되고 난 뒤에 사용이 가능한거 아닌가? `channel`은 `Tv`클래스의 멤버변수<br>
인데 아직 `Tv`클래스의 인스턴스는 생성하지 않았잖아?`*<br>

자손 클래스의 인스턴스를 생성하면, 조상 클래스의 멤버도 함께 생성되기 때문에,<br>
따로 조상 클래스의 인스턴스를 생성하지 않고도 조상 클래스의 멤버를 사용하는 것이 가능하다!!<br>
<br>

> 자손 클래스의 인스턴스를 생성하면, 조상 클래스의 멤버와 자손 클래스의 멤버가 합쳐진 하나의 인스턴스로 생성된다.<br><br>
그렇기 때문에, 자손 클래스의 인스턴스를 생성하면, 조상 클래스의 인스턴스를 생성하지 않아도 조상 클래스의 멤버를<br>
사용하는 것이 가능하다. <br>

---
<br>

## 클래스간의 관계 - 포함관계
클래스를 재사용하는 방법으로는, 앞서 다뤄보았던 '상속'이라는 것이 있었다. 상속 이외에도 클래스를 재사용하는 방법이 존재하는데,<br>
이것은 바로, 클래스 간에 **'포함(composite)관계'**를 맺어주는 것이다.<br>

아래는 클래스 간의 포함관계에 대한 예시이다.<br>

```java
// 원(Circle)을 표현하기 위한 Circle클래스
class Circle {
  int x;
  int y;
  int r;
}

// 좌표상의 한 점을 다루기 위한 Point클래스
class Point {
  int x;
  int y;
}
```
<br>

이때, `Point`클래스를 재사용하여 `Circle`클래스를 작성한다면, 다음과 같이 할 수 있을 것이다.<br>
```java
class Circle {
  Point c = new Point();  // 다른 클래스 타입의 참조변수(c)를 멤버변수로 선언
  int r;
}
```
<br>

이와 같이, 클래스 간의 포함관계를 맺어주는 것은 한 클래스(`Circle`)의 멤버변수로, 다른 클래스(`Point`) 타입의 참조변수(`c`)를 <br>
선언하는 것을 뜻한다.<br>

이렇게, 하나의 거대한 클래스를 작성하는 것 보다, **단위별로 여러개의 클래스들을 작성한 다음, 이 단위 클래스들을 클래스의 표함관계를<br>
이용하여 재사용하면, 보다 간결하고 손쉽게 클래스를 작성하는 것이 가능하다!**<br>
그리고, 이렇게 작성된 단위 클래스들은 다른 클래스를 작성하는데에도 재사용 될 수 있을 것이다.<br>

마치, **`'하나의 완성된 거대한 클래스 블록'`** 전체를 한번에 사용하는 것이 아니라, **`'하나의 단위를 나타내는 클래스 블록'`** 을 여러개<br> 
만들어, 이를 레고 조립하듯이 조립하는 느낌으로 나는 이해하였다.<br>
이러한 **`'하나의 단위를 나타내는 클래스 블록'`** 들은 어떻게 조합하느냐에 따라서 다른 작품(클래스)을 만드는 데에도 쓰이는 것이다.<br>

```java
// 자동차를 표현하기 위한 클래스 - Car
class Car {
  Engine e = new Engine(); // 자동차를 이루는 하나의 단위인 엔진을 표현하기 위한 (단위)클래스 - Engine
  Door[] d = new Door[4]; // 자동차를 이루는 하나의 단위인 문을 표현하기 위한 (단위)클래스 - Door
  // ...
}
```
<br>

위와 같이, 자동차를 표현하는 `Car`클래스를 작성할 때 이 자동차(`Car`)를 이루는 단위요소(엔진, 문 등)들을 따로 각각<br>
단위 클래스(`Engine`, `Door`)로 작성해 놓은뒤, 이들을 `Car`클래스의 멤버변수로 선언하여 포함관계를 맺어주면, 클래스를<br>
작성하는 것도 쉽고, 코드도 간결하여, 이해하기도 용이하다.<br>

그리고, 단위 클래스 별로 코드가 작게 나뉘어 작성되어 있기 때문에, 코드를 관리하는데도 수월하다.<br>

___
<br>

## 클래스간의 관계 결정하기 - 어떠한 경우에 상속을 사용하고, 또 어떠한 경우에 포함관계를 맺어주는가?
클래스를 작성하는데 있어, 상속관계를 맺어주어야 할지, 혹은 포함관계를 맺어주어야 할지 결정하는 것은 때때로 혼란스러울 수 있다.<br>

아래 `Circle`클래스와 `Point`클래스 간의 관계를 맺어주는 경우를 한번 보도록 하자.<br>

```java
// Circle 클래스
class Circle {
  int x;
  int y;
  int r;
}

// Point 클래스
class Point {
  int x;
  int y;
}
```
<br>

위 두 클래스를 한번씩 상속관계와 포함관계를 이용하여 맺어주고, 그 결과를 보도록 하겠다.<br>

- #### `Circle`클래스와 `Point`클래스 간의 포함관계를 맺어주는 경우
  ```java
  class Circle {
    Point p = new Point();  // Point 클래스 타입의 참조변수를 멤버변수로 추가
    int r;
  }
  ```
<br>

- #### `Circle`클래스와 `Point`클래스 간의 상속관계를 맺어주는 경우
  ```java
  class Circle extends Point {
    int r;
  }
  ```
<br>

포함관계를 맺어주는 경우와 상속관계를 맺어주는 경우를 비교해 보았을 때, `Circle`클래스를 작성하는데 있어, `Point`클래스를 상속<br>
받거나 포함시키는 것은 별 차이가 없는 듯 하다.<br>

그럴 때에는, 아래 문장에 두 클래스의 이름을 대입해 보면, 두 클래스 간의 관계를 어떻게 맺어주면 좋을지가 명확해진다.<br>

> **⚪⚪은 ⚪⚪이다.(is-a)**<br>
> **⚪⚪은 ⚪⚪을 가지고 있다.(has-a)**<br> 

해당 문장에 `Circle`클래스와 `Point`클래스를 대입해보면, 다음과 같다.<br>

*'`Circle`은 `Point`이다. - (`Circle` is a `Point`)'* <br>
*'`Circle`은 `Point`를 가지고 있다. - (`Circle` has a `Point`)'*<br>

이를 보면, `Circle`클래스를 작성하는데 있어서, `Point`클래스와 어떠한 관계를 맺어주면 좋을지 알 수 있을 것이다.<br>
원(`Cirlce`)은 원점(`Point`)와 반지름으로 이루어지기 때문에, *'`Circle`은 `Point`를 가지로 있다.'* 라는 표현이 맞다고 할 수 있다.<br>
<br>

이처럼, 클래스를 가지고 문장을 만들었을 때, *'⚪⚪은 ⚪⚪이다.'* 라는 말이 성립하면, **상속관계**를 맺어주면 되고,<br>
*'⚪⚪은 ⚪⚪을 가지고 있다.'* 라는 말이 성립하면, **포함관계**를 맺어주면 된다.<br>

때문에, `Circle`클래스와 `Point`클래스 간의 관계는 **포함관계**를 맺어주는 것이 올바르다고 할 수 있다.<br>

추가로, 상속관계를 맺어주는 상황을 간단히 예를 들어 설명해 보도록 하겠다.<br>
<br>

`Car`클래스와 `SportsCar`라는 클래스가 있다고 해보자. 이 경우, 해당 문장에 대입해보면,

*'`SportsCar`는 `Car`를 포함한다.'* 보다는, *'`SportsCar`는 `Car`이다.'* 와 같이 문장을 만드는 것이 더 옳기 때문에,<br>
두 클래스는 `SportsCar`클래스가 `Car`클래스를 상속받는 상속관계를 맺어주는 것이 바람직하다.<br>

> **상속관계 -** ⚪⚪은 ⚪⚪이다.(is-a)<br>
> **포함관계 -** ⚪⚪은 ⚪⚪을 가지고 있다.(has-a)<br>
  




    

  

    
  


  

  
  

  
  


