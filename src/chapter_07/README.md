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
이것은 바로, 클래스 간에 **'포함(composite)관계'** 를 맺어주는 것이다.<br>

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
<br>

## 💻 예제 | Chapter_07 `Ex07_04_DeckTest`
다음은 `Card`클래스와 이 `Card`클래스의 객체(카드)의 묶음인 `Deck`클래스의 포함관계를 활용한 예제이다.<br> 
[Ex07_04_DeckTest](https://github.com/Yoonsik-2002/java-study/blob/main/src/chapter_07/Ex07_04_DeckTest.java)<br>
<br>

해당 예제 프로그램을 작성하며, 되짚어보면 좋을 것 같은 부분들을 정리해 보도록 하겠다.<br>
<br>

### 📑 `pick()`메서드의 동작과 객체배열 `cardArr`
> `pick()`메서드는 `Card`객체배열 `cardArr`에서 `Card`객체 하나를 뽑아, 리턴한다.

### `Card` 객체배열(`cardArr`)
객체배열이란, 각 인스턴스를 가리키는 참조변수를 묶어놓은 배열이다. 때문에, 해당 배열에 실제로 저장되는 것은 객체가 아니라, 해당<br>
객체의 주소이다.<br>

다음 예시코드를 한번 보도록 하자.<br>

```java
package chapter_07;

class M_Card {
  int number;

  M_Card(int number) {
    this.number = number;
  }
}

class M_Deck {
  final static int CARD_MAX = 5;
  M_Card[] cardArr = new M_Card[CARD_MAX];

  M_Deck() {
    for (int i = 0; i < CARD_MAX; i++) {
      cardArr[i] = new M_Card(i + 1);
    }
  }

  void show() {
    for (int i = 0; i < cardArr.length; i++) {
      System.out.println(cardArr[i].number);
    }
  }
}

class Ex07_05_MiniDeckTest {
    public static void main(String[] args) {
        M_Deck d = new M_Deck();
        
        d.show();
    }
}
```
<br>

main()의 `M_Deck d = new M_Deck();`가 실행되어, `M_Deck`클래스의 인스턴스 `d`가 생성되면

먼저, `M_Card[] carArr = new M_Card[CARD_MAX];`를 통해 5개의 `M_Card`타입의 첨조변수가 들어갈 수 있는 객체배열 공간이 만들<br>
어지고, `M_Deck()`생성자를 통해 해당 인스턴스의 멤버인 객체배열 `cardArr`의 초기화가 이루어진다.<br>

이때, 객체배열 `cardArr`을 이루는 참조변수 `cardArr[0]`, `cardArr[1]`, ... `cardArr[4]`는 for문이 돌 때마다, new 연산자를<br>
통해, `M_Card`객체를 생성하고, 해당 객체의 주소값을 저장한다.<br>

```java
// ...
cardArr[i] = new M_Card(i + 1); // number의 값이 1 ~ 5인 M_Card객체가 순차적으로 생성되어, 해당 주소값이 저장됨
```

그리고, 인스턴스 `d`의 메서드인 `show()`는 이렇게 초기화 된, 객체배열 `cardArr`에 저장되어 있는 `M_Card`객체들의 멤버인<br>
`number`의 값을 차례대로 출력 해준다.<br>
<br>

이러한 `cardArr`과 같은 객체배열은 **각 인스턴스를 가리키는 참조변수 배열이다.** 해당 배열에 실제로 저장된 것은 인스턴스(객체)<br>
가 아니라, 인스턴스의 주소이다.<br>

위 예시코드에서 만든 객체배열 `cardArr`을 그림으로 표현해 보도록 하겠다.<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/285029de-09dc-4060-9f36-39e01062f142)<br>
<br>

위 그림을 보면, 알 수 있듯이, `carArr`은 5개의 참조변수(`carArr[0] ~ carArr[4]`)을 저장할 수 있는 배열공간을 가리키는(해당 배열<br>
공간의 주소값을 저장하는) 참조변수이고, 해당 배열 공간에 저장되어 있는 참조변수 `carArr[0] ~ carArr[4]`는 `M_Card`클래스의 객체<br>
자체를 저장하는 것이 아니라, **`M_Card`클래스의 객체의 주소값을 저장하는 것을 알 수 있다.**<br>
<br>

자, 그럼 [Ex07_04_DeckTest](https://github.com/Yoonsik-2002/java-study/blob/main/src/chapter_07/Ex07_04_DeckTest.java) 프로그램의 `Deck`클래스의 `pick()`메서드의 동작을 한번 보도록 하자.<br>

```java
Card c = d.pick(0);

// ...

Card pick(int index) {
  return cardArr[index];
}
```
<br>

`d.pick(0);`을 통해 `pick`메서드가 호출되면, 해당 메서드의 매개변수 `index`에는 인자로 전달한 `0`이라는 값이 전달되게 된다.<br>
그럼, `pick`메서드는 해당 인덱스(`index = 0`)에 해당하는 객체배열의 데이터(cardArr[0])의 주소를 리턴해주고, 해당 주소값은<br>
`Card`타입의 참조변수 `c`에 저장되게 된다.<br>

##### Ex) 매개변수로 전달된 `index`값이 `0`이고, `cardArr[0]`의 값이 `0x200`인 경우, `pick(0)`메서드 호출 시 변화 - 
```java
return cardArr[index];
/*->*/ return cardArr[0];
/*->*/ reutrn 0x200;
```
<br>

어떻게 이러한 변화가 일어나는 것일까?<br>
위의 객체배열 그림을 잘 보면 이해가 가능하다. 먼저, `pick`메서드가 호출되고, 매개변수인 `index`에 전달된 값은 `0`이기 때문에,<br>
`cardArr[index]` -> `cardArr[0]`이 된다.<br>

이때, 참조변수 `cardArr`이 가리키고 있는 배열공간에 저장되어 있는 참조변수 중, 첫 번째 참조변수인 `carArr[0]`은 결국 객체 배열의<br>
첫 번째 객체의 주소값을 저장하고 있기 때문에, `carArr[0]`은 결국, 해당 객체의 주소값인 `0x200`이라고 할 수 있다.<br>

때문에, **최종적으로, `pick`메서드는 `index = 0`에 해당하는 객체배열의 참조변수 `carArr[0]`에 저장되어 있는 객체의 주소값인<br>
`0x200`을 `Card`타입의 참조변수 `c`에게 리턴하게 된다.**<br>

해당 과정을 그림으로 나타내면 다음과 같다.<br>
<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/8bf0792d-e574-4fe0-933e-f0e01023b1a6)
<br><br>

### 📑 `java.lang`패키지의 `Object`클래스. 그리고 `Object`클래스의 멤버, `toString()`메서드에 대한 이해.

### `toString()`메서드
먼저, `toString()`메서드는 무엇인가? 해당 메서드에 대한 설명은 다음과 같다.<br>

> `toString()`메서드는 객체의 '문자로 된 표현'을 문자열 형태로 리턴한다. 이러한 `toString()`메서드를 통해 리턴된 결과는<br>
> **간결하면서도, 사람들이 읽기 쉬우며, 유익한 정보를 제공한다.** <br>

<br>

즉, 객체에 대한 간결하면서, 사람들이 읽기 쉬우며, 유익한 정보를 문자열로 표현하여 리턴해주는 것이 바로,<br>
이 `toString()`메서드인 것이다.<br>
<br>

### `toString()`메서드가 멤버로서 정의되어 있는, 클래스 계층의 최상위 클래스 - `Object`클래스
> **`java.lang.Object`클래스는 Java에서 만드는 모든 클래스들의 root이다. 따라서, 모든 클래스들은 `java.lang.Object`를<br>
> superclass로 가지고 태어난다.** <br>

<br>

이러한 `toString()`메서드에는 하나의 특징이 있는데, **바로, 클래스 간의 상속계층도에 최상위에 위치한(root) 클래스인<br>
`Object`클래스의 멤버라는 것이다.**<br>

이러한 `toString()`메서드는 Java의 모든 클래스들의 상속을 받는 `Object`클래스에 정의되어있는 멤버이기 때문에, Java의 모든<br>
클래스들은 이 `toString()`메서드를 따로 정의해주지 않아도 사용하는 것이 가능하다.<br>

그동안, `toString()`이나 `equals(Object obj)`와 같은 메서드를 따로 정의하지 않고도 사용할 수 있었던 이유 또한, 해당 메서드들이<br>
`Object`클래스에 정의되어 있는 멤버들이기 때문이라고 할 수 있다.<br>

(자바의 모든 클래스들이 `Object`클래스를 상속받기 때문에, 지금까지 우리는 해당 클래스의 멤버인 `toString()`메서드를 따로<br>
정의해주지 않고도, 그대로 사용하는 것이 가능하였던 것!)<br>
<br>

### `toString()`메서드의 사용
그러면 한번, 이 `toString()`메서드를 사용하면 어떠한 출력 결과가 나타나는지 알아보도록 하겠다.<br>
과연, 우리가 아는대로, `toString()`메서드를 사용하면 간결하면서, 사람이 읽기 쉬운 유용한 정보가 출력될까?<br>

이를 알아보기 위해, 기존 `Ex07_04_DeckTest.java`프로그램을 간단하게 변형하여 `Ex07_05_MiniDectTest.java`프로그램을<br>
작성해 보았다.<br>

해당 프로그램은 카드를 표현하는 `M_Card`클래스와 `M_Card`클래스의 객체들을 5개 모아 놓을 수 있는 객체배열 `cardArr`을<br>
멤버로 가지고, 해당 객체배열(`cardArr`)에 담겨있는 카드의 정보를 출력하는 `show()`메서드를 가진 `M_Deck`클래스로 구성되어 있다.<br>

이 `M_Card`클래스와 `M_Deck`클래스는 `M_Deck`클래스가 `M_Card`클래스 타입의 객체배열 `cardArr`을 멤버로 가지고 있음으로서 서로<br> 포함관계를 이루고 있다.<br>

일단, 우리는 `M_Card`타입의 객체배열 `cardArr`에 저장되어 있는 `M_Card`객체들의 정보를 출력해주는 `M_Deck`클래스의 `show()`<br>
메서드에서 `toString()`메서드를 사용하여 그 결과를 확인해 보려고 한다.<br>

이때, `show()`메서드를 통해 확인해 볼 내용은 다음과 같다.<br>

> **`show()`메서드를 이용하여 `cardArr`에 담긴 `M_Card`객체를 출력 할 때, `System.out.println()`메서드만을 사용하여<br>
> 출력했을 때와, 해당 객체에 `toString()`메서드까지 적용했을 때 출력되는 결과에 어떤 차이가 존재하는지 확인해보도록 하겠다.**

<br>

자, 그럼 이제 `Ex07_05_MiniDeckTest.java`프로그램의 코드를 한번 보도록 하자.<br>

```java
package chapter_07;

class M_Card {
  int number;

  M_Card(int number) {
    this.number = number;
  }
}

class M_Deck {
  final static int CARD_MAX = 5;
  M_Card[] cardArr = new M_Card[CARD_MAX];

  M_Deck() {
    for (int i = 0; i < CARD_MAX; i++) {
      cardArr[i] = new M_Card(i + 1);
    }
  }

  void show() {
    for (int i = 0; i < cardArr.length; i++) {
      System.out.println("System.out.println() : " + cardArr[i]);
      System.out.println("Apply the toString() method : " + cardArr[i].toString());
      System.out.println("");
    }
  }
}

class Ex07_05_MiniDeckTest {
    public static void main(String[] args) {
        M_Deck d = new M_Deck();
        
        d.show();
    }
}
```
<br>

`M_Deck`클래스의 `void show()`메서드를 보면 알 수 있듯이, `void show()`메서드를 통해 객체 배열 `cardArr`에 저장되어 있는 객체들의<br>
정보를 다음 두 가지 방법으로 출력해 보았다.<br>

```java
// ...
System.out.println("System.out.println() : " + cardArr[i]); // 1) 그냥 System.out.println()메서드를 이용하여 cardArr[i]객체만 출력
System.out.println("Apply the toString() method : " + cardArr[i].toString()); // 2) cardArr[i]객체에 toString()메서드를 적용하여 출력
// ...
```
<br>

추가로, 출력된 결과 중, 무엇이 첫 번째 방법의 결과이고, 무엇이 두 번째 방법의 결과인지 구분하기 위해, `System.out.println() : `<br>
과 `Apply the toString() method : `이라는 문자열을 각각 출력값 앞에 표시해 두었다.<br>

자, 이제 결과를 한번 봐 보자.<br>
해당 프로그램의 결과는 다음과 같다.<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/385971d1-11bd-45af-9975-1688e16855c0)<br>
<br>

### `PrintStream`클래스의 출력 관련 메서드를 통한 객체 출력 시, 자바 컴파일러가 자동으로 `toString()`메서드를 호출한다.

`Ex07_05_MiniDeckTest`프로그램의 결과를 보면 알 수 있듯이,<br>

`System.out.prtinln()`메서드를 이용하여 객체(`cardArr[i]`)만을 출력했을 때와, 객체(`cardArr[i]`)에 `toString()`메서드를 적용하여<br>
출력했을때의 결과는 같았었다.<br>

이렇게 결과값이 같다는 것은, **객체만 출력한 것과 객체에 `toString()`메서드를 적용하여 출력한 것이 결국 동일하다는 의미가 될 수 있을까?** <br>

그렇다. 동일하다.<br>

기본적으로 `PrintStream`클래스의 출력 관련 메서드(`printf()`, `println()` 등)를 통해 **객체**를 출력하도록 명령하면, **자바 컴파일러는<br>
내부적으로 (객체의 문자로된 표현을 리턴하는)`toString()`메서드를 호출한다.** <br>

즉, `printf()`, `println()` 메서드를 사용하여 객체를 출력하도록 명령하면, 그냥 기본적으로 자바 컴파일러가 `toString()`메서드를<br>
자동 호출 해주기 때문에, 결국, 같은 결과 값이 나오게 된 것이고, 굳이 **`객체.toString()`의 형태를 가질 필요가 없게 된다.**<br>

(기본적으로 자바 컴파일러가 `toString()`메서드를 호출해 주기 때문! `PrintStream`클래스의 출력관련 메서드에 참조변수(Object)를<br>
넣으면, 자바 컴파일러에 의해 `toString()`메서드가 자동으로 호출된다.)<br>
<br>

이러한 **`toString()`메서드가 정확히 어떠한 결과값을 리턴해주고**, **`Object`클래스에서는 어떻게 정의되어 있는지** [Java 공식문서](https://docs.oracle.com/javase/8/docs/api/)<br>
에서 찾아보면, 다음과 같다.<br>
<br>

- #### `toString()`메서드는 정확히 어떠한 결과값을 리턴해 주는가?
  > **`Object`클래스의 `toString()`메서드는, 전달받은 객체가 인스턴스로서 존재하는 클래스의 이름과 기호문자 `@`, 그리고 객체의<br>
  > 부호 없는 16진수 해쉬코드표기로 구성된 문자열을 반환한다.<br>
  > (이때, 해시코드란, 객체를 식별하는 하나의 정수값을 의미한다.)** <br>

<br>

- #### `Object`클래스에서 `toString()`메서드는 어떻게 정의되어 있는가?
  ```java
  public String toString() {
    return getClass().getName() + '@' + Integer.toHexString(hashcode());
    // 현재 참조하고 있는 클래스를 확인하여, 해당 클래스의 이름을 반환 + @ + 해당 객체의 부호없는 16진수 해시코드 값.
  }
  ```
<br>

아래 간단한 코드와 그 결과를 한번 보도록 하자.<br>

`ExCard`클래스의 `card`객체를 생성한 뒤, `PrintStream`클래스의 메서드 중 하나인 `println()`메서드로 해당 `card`객체를<br>
출력하는 간단한 코드이다.<br>

우리가 공부한 대로라면, `PrintStream`클래스의 출력 관련메서드(`println()`)에 객체(`ExCard`클래스의 `card` 객체)를 전달<br>
하였으니, 내부적으로 자바 컴파일러가 `toString()`메서드를 호출하여, `card`객체의 정보를 문자열로 출력해 줄 것이다.<br>
(나의 예상 결과 값 : `chapter_07.ExCard@부호없는 16진수 해시코드값`)<br>

```java
package chapter_07;

class ExCard {
  int cardNum;

  ExCard(int cardNum) {
    this.cardNum = cardNum;
  }
}

class Ex07_06_toStringExCode {
  public static void main(String[] args) {
    ExCard card = new ExCard(14);

    System.out.println(card);
  }
}
```
<br>

다음은 해당 코드의 결과 값이다.<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/c2018a34-3043-49e1-8790-f13eeb25407b)<br>
<br>

허허, 내 예상이 맞았다.<br>

객체(`card`)가 인스턴스로 있는 클래스의 이름(패키지경로 포함) `chapter_07.ExCard` + 기호문자 `@` + <br>
`card 객체의 부호없는 16진수 해시코드 값` ➡ `chapter_07.ExCard@28d93b30` 이 결과 값으로 출력되었다.<br>

이렇게, `toString()`메서드는 무엇이고, `Objcet`클래스에 어떻게 정의되어 있으며, 객체를 리턴하는 경우에, 어떠한 값을<br>
리턴해 주는지 공부해 보았다.<br>

*'이때, `toString()`메서드가 `클래스이름@부호없는 16진수 해시코드`형식의 리턴값 말고, 우리가 원하는 객체의 값을 출력하게<br>
할 수는 없는걸까?'*<br>

해당 질문에 대한 내용은 `java.lang.Object`클래스의 멤버인 `toString()`메서드를 `Ex07_04_DeckTest`프로그램의 `Card`클래스의<br>
멤버로 있는 메서드에 재정의(overriding)하며 다뤄보도록 하겠다.<br>
<br>

### `Object`클래스의 멤버인 `toString()`메서드를 `Ex07_04_DeckTest`예제의 `Card`클래스에서 오버라이딩(overriding) 하기

### 오버라이딩(overriding)이란?
오버라이딩(overriding)이란, **조상 클래스로부터 멤버로 상속받은 메서드의 내용을 변경하는 것을 의미한다.**<br>
물론, 조상 클래스로부터 상속받은 메서드를 그대로 사용하기도 하지만, 자손 클래스 자신에게 맞게 변경해야 하는 경우도 많이 존재한다.<br>
이러한 경우, 조상 클래스로부터 상속받은 메서드를 오버라이딩(자손 클래스 스스로에게 맞도록 재정의) 한다.<br>

> **참고 |** override의 사전적 의미는 `~위에 덮어쓰다(overwrite)`이다.<br>
> 즉, 조상 클래스의 정의되어 잇는 메서드의 내용을 자손 클래스에서 자신에게 맞게 덮어써서 재정의 하는 것이라 할 수 있다.

자, 그럼 이제 overriding이 무엇인지 알아 보았으니, 해당 개념을 이용하여 `Object`클래스에서 상속받은 `toString()`메서드를 `Card`<br>
클래스에서 해당 클래스에 맞게 재정의(덮어쓰기) 해 보도록 하겠다.<br>

```java
class Card {
  // ...
  public String toString() {
    String[] kinds = {"", "SPADE", "DIAMOND", "HEART", "CLOVER"};
    String numbers = "0123456789XJQK";

    return "Kind : " + kinds[this.kind] + ", number : " + numbers.charAt(this.number);
  }
}
```
<br>

자, 이렇게 모든 클래스의 조상클래스인 `Object`클래스로부터 상속받은 `toString()`메서드를 위와 같이, `Card`클래스에 맞게 재정의<br>
(overriding) 해 보았다.<br>

간단히 설명하자면, 원래 객체를 출력할 때, 해당 객체가 인스턴스로 존재하는 클래스의 이름과 `@`, 부호없는 16진수 해시코드를 문자열로<br>
리턴해 주었던 `toString()`클래스를 `Card`클래스에서 해당 클래스에 맞게 오버라이딩 한 것이다.<br>

`Card`클래스에서의 오버라이딩을 통해 재정의된 `toString()`메서드의 기능은 다음과 같다.<br>
<br>

- **1) `Card`클래스의 객체 배열 `cardArr`에서 참조변수 `cardArr[i]`에 의해 현재 참조되고 있는 인스턴스(카드 한 장)의 종류(무늬)<br>
  를 나타내는 멤버, `this.kind`의 정보를 출력해준다.**

  먼저, `Card`클래스의 인스턴스, 카드의 종류(무늬)를 나타내는 멤버변수 `kind`는 int형으로 정의되어, 정수값이 저장된다.<br>
  해당 프로그램에서는 카드의 종류를 `1 ~ 4`까지의 숫자로 구분하는데, 해당 숫자가 의미하는 카드의 종류는 다음과 같다.<br>

  ```java
  final static int SPADE = 4; // SPADE 무늬는 4
  final static int DIAMOND = 3; // DIAMOND 무늬는 3
  final static int HEART = 2; // HEART 무늬는 2
  final static int CLOVER = 1; // CLOVER 무늬는 1
  ```
  <br>

  이를 이용하여, 현재 참조되고 있는 `Card`클래스의 인스턴스의 멤버, `kind`, `number`에 저장되어 있는 값을 출력해주는 기능으로<br>
  재정의할 `toString()`메서드를 작성하는데 있어, 다음과 같은 방법을 생각해 보았다.<br>

  `String`타입의 문자열 배열 `kinds`를 생성하고, 해당 배열에 카드의 종류를 의미하는 문자열 `SPADE`, `DIAMOND`, `HEART`,<br> 
  `CLOVER`를 저장한다.<br>

  그리고, `kinds[]`에 현재 참조되는 카드 인스턴스의 멤버`kind`의 값(`1 ~ 4`)을 전달하여, 해당 값에 해당하는 인덱스에 존재하는<br>
  문자열을 반환하도록 하였다.<br>
  
  ```java
  ex) return kinds[this.kind]
  /* this.kind, 현재 참조되고 있는 인스턴스의 kind 멤버 값(1 ~ 4)에 해당하는 인덱스에 위치한 kinds 배열의 요소를
  리턴하는 기능*/
  ```
  <br>

  이때, kinds[] 배열을 정의하는데 있어, 주의할 점이 존재한다. kind 멤버 값(1 ~ 4)에 해당하는 인덱스에 위치한 값을 리턴해 주는<br>
  것인데, 배열의 인덱스는 0부터 시작한다는 것이다.<br>

  그렇다면, `String[] kinds = {"SPADE", "DIAMOND", "HEART", "CLOVER"};` 이렇게 정의한 경우, `SPADE` 즉, `1`값을 저장하고<br>
  있는 인스턴스의 `kind`(this.kind)를 전달해주는 경우, "SPADE"가 아닌 "DIAMOND"가 출력되게 될 것이다.<br>

  그러므로, `kinds`는 다음과 같이 정의해 주어야 한다.<br>

  ```java
  String[] kinds = {"", "SPADE", "DIAMOND", "HEART", "CLOVER"};
  ```
  <br>

  사용하지 않는 배열요소 `""`를 인덱스 0 자리에 추가하여, `"SPADE"`는 인덱스 1, `"DIAMOND"`는 인덱스2, `"HEART"`는 인덱스 3,<br>
  `"CLOVER"`는 인덱스 4에 위치하게 하였다. 이를 통해, `kinds`배열에 1을 전달하면, `"SPADE"`, 2를 전달하면, `"DIAMOND"`, 3을<br>
  전달하면, `"HEART"`, 4를 전달하면 `"CLOVER"`를 출력하게 하였다.<br>
  <br>

- **2) `Card`클래스의 객체 배열 `cardArr`에서 참조변수 `cardArr[i]`에 의해 현재 참조되고 있는 인스턴스(카드 한 장)의<br>
  숫자 를 나타내는 멤버, `this.number`의 정보를 출력해준다.**

  이 또한 위 기능과 비슷한 원리로 구현하였다.<br>

  `toString()`메서드에 카드 인스턴스의 멤버, `number`에 저장되는 숫자들의 문자열을 저장한 String변수 number를 정의한다.<br>
  ```java
  String numbers = "0123456789XJQK"; // 숫자 10부터는 X, J, Q, K로 표현
  ```
  <br>

  해당 문자열을 이용하여 현재 참조되고 있는 카드 인스턴스의 숫자를 나타내는 멤버 `number`값을 출력해주는데, 여기서도 똑같이<br>
  주의할 점이 존재한다.<br>

  바로, `Card`클래스의 인스턴스의 멤버 `number`에는 `1 ~ 13`까지의 숫자가 저장된다는 것이다.<br>

  문자열 변수는 결국 '문자'로 이루어진 배열을 참조하고 있는 참조변수라고 할 수 있는데, 이러한 이유로, 문자열에 첫 번째로<br>
  저장된 문자의 인덱스는 0이라고 할 수 있다.<br>

  때문에, 0부터 시작하는 카드에 저장되는 숫자들을 모아둔 문자열 맨 앞에 0을 추가하여, `number.charAt(this.number)`을 <br>
  적용하였을 때, 원하는 값이 출력될 수 있도록 하였다.<br>
<br>

아무튼, 이렇게 `Object`클래스의 `toString()`메서드를 오버라이딩 하는 작업을 해 보았다.<br>

오버라이딩이란 조상클래스로부터 멤버로 상속받은 메서드의 내용(기능)을 자식클래스가 자신에게 맞게 재정의하는 작업이라는 것을<br>
기억하고, 해당 오버라이딩이라는 개념은 다음 진도에서 더욱 자세히 다뤄보려 한다.<br>

---
<br>

## 단일상속(single inheritance)
다른 객체지향 언어인 C++에서는 여러개의 조상 클래스로부터 상속받는 것이 가능한 다중 상속(multiple inheritance)을 허용하지만,<br>
**Java에서는 오직 하나의 조상 클래스로부터 상속받는 것이 가능한 단일상속(single inheritance)만을 허용한다.** <br>

즉, 하나의 클래스가 둘 이상의 클래스로부터 상속을 받을 수 없는 것이다.<br>

예를 들어, `TV`클래스와 `VCR`클래스가 있을 때, 다음과 같이, 이 두 클래스로부터 상속을 받는 `TVCR`클래스를 작성할 수 없다.<br>
```java
class TVCR extends TV, VCR { // 에러 : Java에서는 하나의 클래스로부터 상속을 받는 '단일상속'만이 허용된다. 
  // ...
}
```
<br>

### Java언어가 단일상속만을 허용하는 이유
*'아니, 다중상속을 통해 하나의 클래스가 여러개의 클래스로부터 상속을 받을 수 있으면, 더 복합적인 기능을 가진 클래스를 쉽게 <br>
작성할 수 있으니 더 좋은거 아닌가?'* 라는 생각이 들 수 있다.<br>

물론, 이러한 다중상속에는 위와 같이 복합적인 기능을 가진 클래스를 더욱 쉽게 작성할 수 있다는 장점도 존재하지만, 아래와 같은 단점들<br>
또한 존재한다.<br>

- **1) 여러개의 클래스로부터 상속을 받다 보니, 클래스간의 관계가 복잡해진다.** <br>
- **2) 서로 다른(여러개의) 클래스로부터 상속받은 멤버들간의 이름이 같은 경우, 이를 구별해 낼 수 있는 방법이 없다.** <br>
<br>

예를 들어, 다중상속을 허용하여 `TV`클래스와 `VCR`클래스를 모두 조상으로 하여 해당 클래스들의 멤버들을 상속받는 `TVCR`클래스를 <br>
작성한다고 가정해 보자.<br>

이때, 만일 `TV`클래스에도 `power()`메서드가 있고, `VCR`클래스에도 `power()`메서드가 있다면, 이 두 클래스의 자손인 `TVCR`클래스는<br>
어느 조상 클래스의 `power()`메서드를 상속받게 되는 것일까?<br>

둘 다 상속받게 된다면, `TVCR`클래스 내에서 선언부(이름과 매개변수)만 같고 서로 다른 내용의 두 메서드를 어떻게 구별할 것인가?<br>

물론, 클래스 메서드(static 메서드)의 경우, 객체의 생성과는 상관없이 `클래스 명.메서드 명()`형태로, 클래스의 이름을 붙여 호출이<br>
가능하다. 이러한 방식으로 클래스 메서드는 메서드 이름앞에 클래스 이름을 붙이는 식으로 구별 할 수 있다지만,<br>

인스턴스 메서드의 경우, 선언부가 같은 두 메서드를 구별할 수 있는 방법이 없다.<br>





  

  
    













    

  

    
  


  

  
  

  
  


