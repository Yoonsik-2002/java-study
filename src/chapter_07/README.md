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
<br>

### 다중 상속의 문제점
- **1) 여러개의 클래스로부터 상속을 받다 보니, 클래스간의 관계가 복잡해진다.** <br>
- **2) 서로 다른(여러개의) 클래스로부터 상속받은 멤버들간의 이름이 같은 경우, 이를 구별해 낼 수 있는 방법이 없다.** <br>
<br>

예를 들어, 다중상속을 허용하여 `TV`클래스와 `VCR`클래스를 모두 조상으로 하여 해당 클래스들의 멤버들을 상속받는 `TVCR`클래스를 <br>
작성한다고 가정해 보자.<br>

이때, 만일 `TV`클래스에도 `power()`메서드가 있고, `VCR`클래스에도 `power()`메서드가 있다면, 이 두 클래스의 자손인 `TVCR`클래스는<br>
어느 조상 클래스의 `power()`메서드를 상속받게 되는 것일까?<br>

둘 다 상속받게 된다면, `TVCR`클래스 내에서 선언부(이름과 매개변수)만 같고 서로 다른 내용의 두 메서드를 어떻게 구별할 것인가?<br>

물론, 클래스 메서드(static 메서드)의 경우, 객체의 생성과는 상관없이 `클래스 명.메서드 명()`의 형태로, 클래스의 이름을 붙여 호출<br>
하는 것이 가능하다. 이러한 방식으로 클래스 메서드는 메서드 이름앞에 클래스 이름을 붙이는 식으로 구별 할 수 있다지만,<br>

인스턴스 메서드의 경우, 선언부가 같은 두 메서드를 구별할 수 있는 방법이 없다.<br>

결국, 이 두 메서드를 구별하기 위해서는 직접 해당되는 조상클래스에서의 메서드 이름이나, 매개변수를 변경해주는 방법밖에 없다.<br>

**하지만, 또 이렇게 해버리면, 해당 조상 클래스의 `power()`메서드를 사용하는 다른 클래스들까지 모두 변경을 해주어야 하므로, 그리<br>
간단한 문제가 아니라고 할 수 있다.**<br>

단일 상속이 다중 상속에 비해, 불편한 점도 물론 존재하지만, 클래스간의 관계가 보다, 명확해지고 코드를 더욱 신뢰할 수 있게 만들어<br>
준다는 점에서, 다중 상속보다 유리하다.<br>
<br>

### `TVCR`클래스를 단일상속만을 허용하는 Java에서 구현하기 

그렇다면, 이 `TVCR`클래스의 경우처럼, 두 개의 클래스로부터 해당 클래스의 멤버들을 가져와 사용하고 싶은경우, 이 단일상속만을 허옹<br>
하는 Java에서 어떻게 해야 할까?<br>

바로, 상속과 클래스간의 포함관계를 이용해 주면 된다.<br>

TV와 비디오 테이프의 재생 겸 녹화장치인 VCR의 기능을 모두 가지는 TVCR클래스를 구현하는데 있어, `TV`클래스와 `VCR`클래스와의<br>
관계를 한번 설정해 보도록 하겠다.<br>

`TVCR`은 어쨋든 `TV`이기 때문에, 두 클래스 간의 관계는 '상속'관계로 지정하였고, 
`TVCR`은 `VCR`을 포함(가지고 있기 때문에)하기 때문에, 이 두 클래스 간의 관계는 '포함'관계로 지정해 주었다.<br>

다음 예시코드를 한번 보도록 하자.<br>

```java
package chapter_07;

class TV {
  boolean power; // boolean의 기본값은 False로, 해당 타입의 변수를 직접 초기화 해주지 않았을 시, 기본값인 False로 초기화 된다.
  int channel;

  void power() {power = !power;}
  void channelUp() {channel ++;}
  void channelDown() {channel --;}
}

class VCR {
  boolean power;
  int counter = 0;

  void power() {power =! power}
  void play() {/* 내용 생략 */}
  void stop() {/* 내용 생략 */}
  void rew() {/* 내용 생략 */}
  void ff() {/* 내용 생략 */}
}

class TVCR extends TV {
  VCR vcr = new VCR(); // VCR 타입의 인스턴스 참조변수(vcr)을 생성하여 TVCR클래스와 VCR클래스 간의 포함관계를 맺음

  void power() {
    vcr.power();
  }

  void play() {
    vcr.play();
  }

  void stop() {
    vcr.stop();
  }

  void rew() {
    vcr.rew();
  }

  void ff() {
    vcr.ff();
  }

  /* TVCR클래스에 포함관계를 맺은 VCR클래스에 선언되어 있는 메서드와 똑같은 선언부(이름, 매개변수)를 가진 메서드를 선언하고,
    해당 메서드의 내용은, VCR클래스의 메서드를 호출하여 사용하도록 하였다.*/
}
```
<br>

이처럼 단일 상속만을 허용하는 Java에서 `TV`클래스의 메서드와 `VCR`클래스의 메서드를 사용하는 `TVCR`클래스를 구현하기 위해,<br>
`TV`클래스는 조상으로 하고, `VCR`클래스는 `TVCR`클래스에 포함시켜, 포함관계를 맺어 주었다.<br>

그리고 TVCR클래스에, 포함관계를 맺은 VCR클래스에 선언되어 있는 메서드와 똑같은 선언부(이름, 매개변수)를 가진 메서드를 선언하고,
해당 메서드의 내용은, VCR클래스의 메서드를 호출하여 사용하도록 하였다.<br>

이 방법을 통해, 외부적으로는 `TVCR`의 인스턴스를 사용하는 것 처럼 보이지만, 내부적으로는 `VCR`의 인스턴스를 생성하고, 해당 클래스<br>
의 메서드들을 호출하여 사용하는 꼴이 된다.<br>

**이렇게 함으로써, 결국에 내부적으로는 `VCR`클래스의 메서드를 호출하는 것 이기 때문에, `VCR`클래스의 메서드가 변경되더라도, 해당<br>변경사항이 `TVCR`클래스의 메서드에도 똑같이 적용되는 효과를 가질 수 있게 된다. 마치 직접 상속을 받은 것 처럼 말이다.<br>**

---
<br>

## `java.lang.Object`클래스 - 모든 클래스의 조상 클래스
`Object`클래스는 모든 클래스 간의 상속 계층도 최상위에 위치하여있는 조상 클래스이다.<br>
즉, `Object`클래스는 Java에서 만드는 모든 클래스들의 root라고 할 수 있다. 따라서, 모든 클래스들은 이 `Objcet`클래스를 super<br>
클래스로 가지고 태어난다.<br>

이는 Java에서 만들어지는 모든 클래스들은 `Object`클래스의 멤버들을 상속받기 때문에, `Object`클래스에 정의되어 있는 멤버들을<br>
사용할 수 있음을 의미한다.<br>
<br>

### `Object`클래스의 상속이 이루어지는 방식
어떻게 하면 Java에서 생성되는 모든 클래스들이`Object`클래스를 조상클래스로 가지게 될까? 이러한 상속이 이루어지는 방식은 <br>
내부적으로 어떻게 되는 것일까?<br>

해당 질문에 대한 답은 다음과 같다.<br>

> **다른 클래스로부터 상속받지 않은 모든 클래스들은 자동적으로 모두 `Object`클래스로부터 상속받게 한다.<br>**

<br>

예를들어, 아래와 같이 다른 클래스로부터 상속을 받지 않는 `Card`클래스가 있다고 해 보자.<br>
```java
class Card {
  // ...
}
```
<br>

위의 코드를 컴파일 하면, 컴파일러는 자동적으로 해당 코드를 **`extends Object`** 를 추가하여 `Card`클래스가 `Object`클래스로<br>
부터 상속받도록 한다.<br>
```java
class Card extends Object {
   // ...
}
```
<br>

이러한 방식을 통해, 다른 클래스로부터 상속을 받지 않는 클래스들은 자동적으로 `Object`클래스로 부터 상속을 받게 되고, 다른 클래스<br>
로부터 상속을 받는 클래스도 마찬가지로, 해당 클래스의 상속계층도를 따라, 거슬러 올라가다 보면, 결국 마지막 최상의 조상은 `Object`<br>
클래스가 되게 되는 것이다.<br>

이처럼, 모든 상속계층도의 최상위에는 `Object`클래스가 위치한다.<br>
이러한 이유로, Java의 모든 클래스들은 `Object`클래스의 멤버들을 상속받아, `Object`클래스에 정의되어 있는 멤버들을 사용하는 것이<br>
가능하다.<br>

우리가 지금까지 `toString()`메서드와 `equals()`메서드를 따로 정의해주지 않아도 사용이 가능하였던 이유는 해당 메서드들이 `Object`<br>
클래스의 멤버로서 정의되어 있기 때문이다.<br>

`Object`클래스에는 아래 사진과 같이, 인스턴스가 기본적으로 가져야 할 11개의 메서드들이 정의되어 있으며, 우리가 흔히 아는 `toString()`<br>
메서드와 `equals()`메서드 또한 이 11개의 메서드들에 포함되어 있다.<br>
<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/bb37d9cb-cc51-4ac1-89da-5f18072d1684)<br>

---
<br>

## 오버라이딩(overriding)
오버라이딩이란, 조상 클래스로부터 상속받은 메서드의 내용을 자손클래스 자신에게 맞도록 변경하는 작업을 의미한다.<br>

조상 클래스로부터 상속받은 메서드를 그대로 사용하는 것도 가능하지만, 자손 클래스 자신에게 맞도록 변경해야 하는 경우 또한,<br>
많이 존재한다.<br>

이러한 경우, 해당 메서드를 자손 클래스 자신에게 맞도록 오버라이딩 해준다.<br>
<br>

오버라이딩에 간단한 예시로, 다음 코드를 한번 보도록 하자.<br>

```java
class Point {
  int x;
  int y;

  String getLocation() {
    return "x : " + x + ", y : " + y;
  }
}

class Point3D extends Point {
  int z;

  Strin getLocation() { // 오버라이딩
    return "x : " + x + ", y : " + y + ", z : " + z;  
  }
}
```
<br>

해당 예시코드의 `Point`클래스는 2차원 좌표계의 한 점을 표현하기 위한 클래스이고, `Ponit3D`클래스는 3차원 좌표계의 한 점을<br>
표현하기 위한 클래스이다.<br>

`Point`클래스로부터 상속을 받는 `Point3D`클래스의 경우, `Point`클래스의 멤버로서 정의되어 있는 메서드 `getLocation()`을<br>
상속받게 된다.<br>

하지만, 2차원 좌표계의 한 점을 표현해주는 `Point`클래스의 `getLocation()`메서드는, x축, y축에 해당하는 좌표값만 반영하는<br>
것이 가능하다.<br>

즉, 3차원 좌표계의 한 점(x축, y축, z축 좌표값 반영)을 표현해야 하는 `Point3D`클래스에게는 맞지 않다고 할 수 있다.<br>
때문에, 우리는 `Point`클래스로 부터 상속받은 메서드  `getLocation()`을 `Point3D`클래스에 맞도록 변경(오버라이딩)해 주어야<br>
한다. 

**이렇게, 조상 클래스로부터 상속받은 메서드를 자손 클래스가 자신에게 맞게 변경하는 작업을 가리켜 메서드 오버라이딩(method overriding)<br>
이라고 한다!** <br>
<br>

### 오버라이딩(overriding)의 조건
오버라이딩이란, 조상 클래스로부터 상속받은 메서드의 '내용'만을 새로 작성하는 것이므로, **오버라이딩이 성립되기 위해서는,<br>
자손 클래스에서 오버라이딩 하는 메서드의 선언부(반환타입, 메서드 이름, 매개변수)가 조상의 것과 일치해야 한다.<br>**

따라서, 오버라이딩의 조건은 다음과 같다고 할 수 있다. 

- 리턴 타입이 같아야 한다.
- 메서드 이름이 같아야 한다.
- 매개변수가 같아야 한다.

> 자손 클래스에서 오버라이딩 하는 메서드는 조상클래스의 메서드와 '선언부가 일치해야 한다!'
<br>

이때, 자식 클래스에서 오버라이딩하는 메서드의 접근 제어자(access modifier)와 예외(exception)는 제한된 조건 하에서만 다르게<br>
변경할 수 있다. 해당 조건은 아래와 같다.<br>
<br>

#### 1. 접근제어자는 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.(같거나 넓어야 함)
> 접근제어자의 범위(좁은 순): `private`, `(default)`, `protected`, `public`<br>

만약, 조상클래스에 정의되어 있는 메서드의 접근제어자가 `protected`인 경우, 해당 메서드를 오버라이딩 하는 자손클래스의<br>
메서드는 접근제어자가 `protected`나, `public`이어야 한다.<br>
대부분의 경우, 같은 범위의 접근 제어자를 사용한다. <br>
<br>

#### 2. 조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.(적거나 같아야 함)
```java
class Parent {
  void parentMethod() throws IOException, SQLException {
    // ...
  }
}

class Child {
  void parentMethod() throws IOException {
     // ...
  }
}
```
<br>

위 예시코드의 경우, `Child`클래스의 `parentMethod()`메서드에 선언되어있는 예외의 개수가 조상 클래스인 `Parent`클래스의 <br>
`parentMethod()`에 선언되어 있는 예외의 개수보다 적기 때문에, 바르게 오버라이딩이 되었다 할 수 있다.<br>

하지만, 해당 개념을 이해하는데 있어, **단순히 선언된 예외의 개수가 문제가 아님을 명심해야 한다.<br>**
아래 코드를 보도록 하자.<br>

```java
class Child {
  void parentMethod() throws Exception {
    // ...
  }
}
```
<br>

만약 위 코드와 같이 오버라이딩을 하였을 경우, 바르게 오버라이딩이 되었을까?<br>

일단 `parentMethod()`메서드에 선언되어 있는 예외의 개수로만 보았을 때에는, 조상 클래스의 `parentMethod()`보다 적은 개수의<br>
예외가 선언되어 있으므로, 바르게 오버라이딩이 되었을 것이라 생각 할 수 있다.<br>

하지만, 여기엔 우리가 간과한 주의사항이 하나 있다. 바로, 단순히 선언된 예외의 개수가 문제가 아니라는 것이다.<br>

그럼 위의 코드에는 무슨 문제가 존재하는 것일까?<br>

해당 질문에 대한 답은 바로, 위의 코드의 `parentMethod()`에서 선언되어 있는 예외,`Exception`에 있다.<br>
`Exception`예외란 무엇이길래? 선언된 예외의 개수가 적은데도 불구하고, 바르게 오버라이딩이 되지 않는 것일까?<br>

`Exception`예외란, 모든 예외의 최고 조상이므로, 위 코드의 경우, 가장 많은 개수의 예외를 던질 수 있도록 선언한 꼴이 된다.<br>
결국, 예외의 개수는 조상클래스의 메서드보다 적거나 같아야 한다는 조건을 만족시키지 못하게 되어, 잘못된 오버라이딩이<br>
되는 것이다.<br>
<br>

#### 자식 클래스에서 조상 클래스의 메서드를 오버라이딩 할 때 주의할 점
> 1) 접근 제어자는 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.
> 2) 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.
> 3) 인스턴스 메서드를 static메서드로, static메서드를 인스턴스 메서드로 변경할 수 없다.
<br>

### 오버로딩 VS 오버라이딩
이름이 비슷한 두 개념, 메서드 오버로딩과 오버라이딩의 차이점을 한번 정리해 보도록 하겠다.<br>

**오버로딩**은 메서드의 이름은 같지만, 매개변수(매개변수의 개수 or 매개변수의 타입)가 다른, 기존에 없는 새로운 메서드를 추가하는 개념 <br>
이라 할 수 있다. (`new`)<br>

반면, **오버라이딩**의 경우, 조상 클래스로부터 상속받은 메서드의 내용을 변경하는 것이라 할 수 있다. (`change`, `modify`)<br>

즉, **새롭게 만들어 내느냐**, 아니면 기존에 조상 클래스에 존재하는 메서드를 상속받아, 해당 메서드의 내용을 **변경하느냐**의 차이가 있다.<br>

```java
class Parent {
  void parentMethod()  {}
}

class Child extends Parent {
  void parentMethod()  {}
  // 오버라이딩 : 조상 클래스 Parent의 메서드 parentMethod를 상속받고, 해당 메서드의 선언부는 그대로 두고, 내용을 변경.

  void parentMethod(int n) {}
  /* 오버로딩 : 조상 클래스 Parent의 멤버인 parentMethod메서드는 자손 클래스 Child에 상속되어, 해당 클래스의 멤버로 추가된다.
     이렇게 추가된 parentMethod메서드와 메서드 이름은 같지만, 매개변수 int n이 추가된 새로운 메서드 parentMethod(int n)이
     메서드 오버로딩을 통해 추가되었다. 
  */

  void childMethod()  {}

  void childMethod(int n) {}
  /* 오버로딩 : 기존 childMethod와 이름은 같지만, 매개변수 int n이 추가된 새로운 메서드 childMethod(int n)이 메서드 오버로딩을
     통해 추가되었다. 
  */

  void childMehtod()  {}
  // 메서드의 중복 정의 : 에러발생(already defined in Child)
}
```
---
<br>

## 조상 클래스의 멤버를 가리키는 참조변수 - `super`
`super`는 자손 클래스에서, 조상 클래스로부터 상속받은 멤버를 참조하는데 사용하는 참조변수이다.<br>
(조상 클래스로부터 상속받은 멤버변수를 가리킴)<br>
<br>

### 조상 클래스로부터 상속받은 멤버를 가리키는 참조변수 `super`
자손 클래스 내에서, 지역변수(`ex| 생성자의 매개변수`)와 멤버변수의 이름이 같을 때, 이를 구별해주기 위해, 멤버변수 앞에 `this`를<br>
붙여 구별해 주었듯이,<br>

**조상 클래스로부터 상속받은 멤버와, 자손 클래스 자신의 멤버의 이름이 같을 경우, 상속받은 멤버 앞에 `super`를 붙여, 이를 구별해<br>
주는 것이 가능하다!** <br>

즉, 조상 클래스로부터 상속 받은 멤버와, 기존 자손 클래스 자신의 멤버와 이름이 같아, 중복 정의되어 이를 구별해야 하는 경우, 조상<br>
클래스로부터 상속받은 멤버 앞에 `super`를 붙여, 구별해 주는 것이다.<br>

이때, 조상 클래스로부터 상속받은 멤버도 결국 어떻게 보면, 자손 클래스의 멤버라고도 할 수 있지 않은가?<br>
그렇다. 때문에, 상속받은 멤버도 자손클래스의 멤버이므로, `this`를 사용하는 것이 가능하다.<br>

때문에, 상속받은 멤버와 기존 자손클래스의 멤버의 이름이 서로 같아, 이를 구별해야 하는 경우에만 `super`를 사용해주는 것이 좋다.<br>
<br>

### `this`와 `super`의 차이점
`this`와 `super` 이 둘은, 무엇을 참조하느냐? 즉, 지역변수 자기 자신에게서 선언된 멤버를 참조하느냐, 아니면 조상 클래스로부터 <br>
상속받은, 조상 클래스의 멤버를 참조하느냐의 차이지, 근본적으로 이 둘은 같다.<br>

> 모든 인스턴스 메서드에는 자기 자신이 속한 인스턴스의 주소가 지역변수로 저장되는데, 이것이 `super`와 `this`의 값이 된다.<br>

<br>

### static 메서드에 super를 사용할 수 있는가?
사용할 수 없다.<br>

static메서드는 인스턴스와 관련이 없다. (클래스의 인스턴스를 생성하지 않아도 호출 할 수 있는 메서드가 바로 static메서드이다.)<br>
그래서 `this`와 마찬가지로, `super`또한 static메서드에는 사용할 수 없고, 인스턴스메서드에만 사용이 가능하다.<br>

**인스턴스 메서드에는 자신이 속한 인스턴스의 주소값이 지역변수로 저장되고, 이것이 `super`와 `this`의 값이 되는 것이다!** <br>
<br>
    
#### 💻 참조변수 `super`와 `this` 예시코드

##### example code 01
```java
class Parent {
  int x = 10;
}

class Child {
  void method() {
    System.out.println("x : " + x);
    System.out.println("this.x : " + this.x);
    System.out.println("super.x : " + super.x);
  }
}

class TestSuper {
  public static void main(String[] args) {
    Child c = new Child();
    c.method();
  }
}
```
```java
[실행결과]
x : 10
this.x : 10
super.x : 10
```
<br>

위 코드를 보면, 조상 클래스 `Parent`의 멤버변수 `x`를 자손 클래스 `Child`가 상속받은 상황임을 알 수 있다.<br>
이때, `Parent`의 멤버변수 `x`는 `Parent`의 멤버변수이기도 하며, `Child`가 상속을 받았기 때문에, `x`는 `Child`의 멤버변수<br>
라고도 할 수 있다.<br>

그리고, `Child`에 조상 클래스로부터 상속받은 멤버변수 `x`와 이름이 같은 멤버변수가 존재하지 않기 때문에 `x`, `this.x`, `super.x`<br>
모두 같은 변수를 의미한다.<br><br>

##### example code 02
```java
class Parent {
  int x = 10;
}

class Child {
  int x = 20;

  void method() {
    System.out.println("x : " + x);
    System.out.println("this.x : " + this.x);
    System.out.println("super.x : " + super.x);
  }
}

class SuperTest02 {
  public static void main(String[] args) {
    Child c = new Child();
    c.method();
  }
}
```
```java
[실행결과]
x : 20
this.x : 20
super.x : 10
```
<br>

해당 코드를 보면, `example code 01`과는 다른 조건이 존재한다. 바로, `Child`클래스에 조상 클래스`Parent`의 멤버변수 `x`와 이름이<br>
같은 멤버변수 `x`가 중복되어 정의되어 있다는 것이다.<br>

자손 클래스인 `Child`는 조상 클래스`Parent`의 멤버인 `x`를 상속받아, 해당 멤버도 자신의 멤버로 추가하게 될 텐데, 이미 `Child`엔<br>
똑같은 이름의 멤버변수 `x`가 중복되어 선언되어 있는 상황이다.

이렇게 **조상 클래스의 멤버와 자손 클래스 자신의 멤버의 이름이 같은 경우, `super`와 `this`는 각각 참조하는 변수가 달라지게 된다.**

결과값을 보면, `this.x`의 경우, `Child`클래스 자신의 멤버변수, 20을 저장하고 있는 `x`를 의미하게 되고,<br>
`super.x`의 경우, 조상 클래스인 `Parent`클래스의 멤버변수, 10을 저장하고 있는 `x`를 의미하게 됨을 알 수 있다.<br>

이렇게 java에서는 조상 클래스의 멤버를 가리키는 참조변수 `super`와 객체 자신을 가리키는 참조변수 `this`가 존재하기 때문에,<br>
**조상클래스에 선언되어 있는 멤버와 같은 이름의 멤버를 자손 클래스에서 중복 정의 하는 것이 가능하다.** <br>
`super`와 `this`를 통해 이들을 구별하는 것이 가능하기 때문이다!<br>
<br>

### `super`의 활용 - 메서드 오버라이딩에 `super` 사용하기 
메서드 오버라이딩이란 무엇인가? 조상 클래스로부터 상속받은 메서드를 자손 클래스 자신에게 맞게 변형하는 것을 의미한다.<br>
이러한 메서드 오버라이딩을 하는데 있어, `super`를 활용하기도 하는데, 다음 예시코드를 보도록 하자.<br>
<br>

#### 💻 `super`를 활용한 메서드 오버라이딩 예시 코드

##### `PointTest.java`
```java
class Point {
  int x;
  int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;

  String getLocaion() {
    return "x : " + x + ", y : " + y;
  }
}

class Point3D extends Point {
  int z;

  String getLocation() {  // 메서드 오버라이딩 - Point클래스의 메서드 getLocation을 자손 클래스인 Point3D 자신에게 맞게 변경
    // return "x : " + x + ", y : " + y + ", z : " + z;
    return super.getLocation() + ", z : + z;
  }
}
```
<br>

2차원 좌표의 점을 나타내는 클래스 `Point`와 해당 클래스로부터 멤버들을 상속받아, 3차원 좌표의 점을 나타내는 클래스 `Point3D`<br>
클래스로 이루어진 프로그램이다.<br>

해당 프로그램에는 `super`를 이용한 메서드 오버라이딩이 담겨있는데, `Point3D`클래스를 한번 보도록 하자.<br>

`Point`클래스로부터 상속을 받는 `Point3D`클래스는, `Point`클래스의 메서드인 `getLocation`을 상속받고, 해당 메서드를 자신에게<br>
맞도록 변경하여 사용하는데, 이러한 작업을 가리켜 메서드 오버라이딩 이라고 한다.<br>

이렇게, 자손 클래스가 조상 클래스의 메서드를 오버라이딩 하는 경우, `super`를 이용하여, 조상 클래스의 메서드를 호출하고, 해당 <br>
메서드의 내용에 추가적으로 작업을 덧붙이는 것도 가능하다.<br>

2차원 좌표의 점을 나타내는 클래스 `Point`의 경우, 멤버로 가지고 있는 `getLocation`메서드는  `x`, `y`의 좌표값을 출력해주지만,<br> 
3차원 좌표의 점을 나타내는 클래스 `Point3D`의 경우, 멤버로 상속받은 `getLocation`메서드의 기능을 수정해 줄 필요가 있다.<br>
바로, 3차원 좌표의 점을 추가하여 출력해 주어야 한다는 것이다.<br>

이렇게, **조상 클래스로 부터 상속받은 메서드의 내용에 추가적인 작업을 덧붙여야 하는 경우, `super`를 이용하여, 조상 클래스의<br>
메서드를 호출하고, 그 상태에서 추가적인 작업을 덧붙이는 것이 가능하다.<br>**

`return "x :" + x + ", y : " + y + ", z : " + z; // "x : " + x + ", y : " + y; 까지는 Point클래스 메서드의 내용임`

`reutrn super.getLocation() + ", z : " + z; // point클래스 메서드 getLocation()의 내용에 ", Z : " + z; 작업 추가`

이렇게 메서드 오버라이딩 시, 조상클래스의 메서드에 추가적인 작업을 덧붙이는 경우, 코드를 하나하나 작성하기 보다는 `super`를 이용<br>
하여 조상 클래스를 호출하고, 추가할 내용만 덧붙이면, **코드의 재사용성과, 유지보수에 유리하다는 장점을 가지게 된다.<br>**

조상 클래스의 내용을 변경하였을 경우, 해당 변경사항이 해당 메서드를 오버라이딩한 자손 클래스의 메서드에도 자동으로 적용이 되기<br>
때문이다.<br>

---
<br>

## 조상 클래스의 생성자 - `super()`
`this()`와 마찬가지로, `super()`또한 생성자이다. `this()`의 경우, 같은 클래스 내의 다른 생성자를 호출하는데 사용되지만,<br>
`super()`는 조상 클래스의 생성자를 호출하는데 사용된다.<br>

- **`this()`** - 같은 클래스 내의 다른 생성자를 호출하는데 사용
- **`super()`** - 조상 클래스의 생성자를 호출하는데 사용

이러한 `super()`를 사용하여 조상 클래스 내의 생성자를 호출해내야 하는 이유는 무엇이 있을까?<br>

어떠한 조상 클래스로부터 상속을 받고 있는 자손 클래스의 인스턴스를 생성하면, 해당 인스턴스는 자손 클래스의 멤버와 조상 클래스의<br>
멤버가 모두 합쳐진 하나의 인스턴스가 된다.<br>

그렇기 때문에, 자손 클래스의 인스턴스가 조상 클래스의 멤버를 사용하는 것이 가능하게 되는 것인데, 이러한 조상 클래스의 멤버들을 <br>
사용하기 위해서는, 해당 멤버들을 초기화 해주어야 한다.<br>

따라서, 자손 클래스의 생성자에서 `super()`를 통해 조상클래스의 생성자가 호출되어야 한다.<br>
<br>

### `super()`을 통한 조상 클래스의 멤버 초기화 시, 주의점 
**`super()`는 자손 클래스의 생성자의 맨 첫 줄에서 호출되어야 한다.** <br>

조상 클래스의 생성자를 호출하여, 조상 클래스의 멤버를 초기화 해주는 `super()`가 생성자의 맨 첫 줄에서 호출되어야 하는 이유는<br>
위에서도 언급하였듯이, **자손 클래스의 멤버가 조상 클래스의 멤버를 사용할 수도 있기 때문이다.** <br>

조상 클래스의 멤버가 먼저 초기화 가 되어 있어야, 자손 클래스가 사용하는 것이 가능하기 때문에, `super()`는 생성자의 맨 첫 줄에서 호출되어야 한다.<br>
<br>

### `Object`클래스와 `super()`
이와 같은 조상 클래스 생성자의 호출은 클래스의 상속관계를 거슬러 올라가면서 계속 반복되고, 이러한 반복의 끝은 Java 상속계층도의<br>
최상위에 위치하는 `Object`클래스에서 끝이나게 된다.<br>

그렇기 때문에, `Object`클래스를 제외한 모든 클래스의 생성자는 첫 줄에 반드시 **자신의 다른 생성자(`this()`) 또는 조상 클래스의<br> 생성자(`super()`)를 호출해 주어야 한다.<br>

그렇지 않으면, Java컴파일러는 생성자의 첫 줄에 `super();`를 자동적으로 추가해준다. 즉, 생성자의 첫 줄에 `this()`나 `super()`<br>
를 호출해주지 않을 시, 자동으로 조상 클래스의 기본 생성자를 호출하게 되는 것이다.<br>

자, 이제 `super()`의 개념을 이해해 보았으니, 다음 예시코드를 완성해 보도록 하겠다.<br>
[`super`를 활용한 메서드 오버라이딩 예시 코드(1)](https://github.com/Yoonsik-2002/java-study/blob/main/src/chapter_07/README.md#-super%EB%A5%BC-%ED%99%9C%EC%9A%A9%ED%95%9C-%EB%A9%94%EC%84%9C%EB%93%9C-%EC%98%A4%EB%B2%84%EB%9D%BC%EC%9D%B4%EB%94%A9-%EC%98%88%EC%8B%9C-%EC%BD%94%EB%93%9C1)<br>
<br>

#### 💻 `super`를 활용한 조상 클래스의 멤버변수 초기화 예시코드(에러 버전)

##### `PointTest.java`
```java
class Point {
  int x, y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  String getLocation() {
    return "x : " + x + ", y : " + y;
  }
}

class Point3D extends Point {
  int z;

  Point3D(int x, int y, int z) { // 에러 발생
    this.x = x;
    this.y = y;
    this.z = z;
  }

  String getLOcation() {
    return "x : " + x + ", y : " + y + ", z : " + z;
  }
}

class PointTest {
  Point3D p3 = new {oint3D(1, 2, 3);
}
```
<br>

해당 코드를 한번 보자. 제대로 동작할까?<br>

아니다. 해당 코드의 실행 시, 컴파일 에러가 발생하게 되는데, 그 이유를 한번 알아보도록 하겠다.<br>

`Point3D`의 생성자 부분을 한번 보도록 하자. `Point3D`클래스는 `Point`클래스를 조상으로 두는, `Point`클래스의 자손 클래스이다.<br>
그렇기 때문에, `Point3D`클래스의 인스턴스는 `Point`클래스의 멤버와 자기 자신의 멤버가 모두 합쳐진 하나의 인스턴스가 된다.<br>

이러한 경우, 자손 클래스의 멤버가 조상 클래스로부터 상속받은 멤버를 사용할 수도 있기 때문에, `Point3D`의 생성자의 첫 줄에는 조상<br>
클래스`Point`의 생성자가 호출되어야 한다.<br>

하지만, `Point3D`생성자의 첫 줄에는 조상 클래스의 생성자나, 자신의 다른 생성자가 호출되어 있지 않다.<br>

이러한 경우, Java컴파일러가 자동으로 `Ponit3D`생성자의 첫 줄에 `super();`를 추가하게 된다.<br>
`super();`의 뜻이 무엇인가? 바로, `Point3D`클래스의 조상 클래스인 `Point`클래스의 기본 생성자`Point()`의 호출을 의미한다.<br>

여기서 에러가 발생하게 되는데, `Point`클래스에는 이미 `Point(int x, int y)`생성자가 정의되어 있다. 이미 생성자가 정의되어 있는<br>
`Point`클래스의 경우, 컴파일러가 자동으로 기본생성자를 추가해주지 않는다.<br>

때문에, `Point()`생성자가 `Point`클래스에 정의되어 있지 않아, 컴파일 에러가 발생하는 것이다.<br>

해당 컴파일 에러를 해결하기 위해서는, 생성자 `Point3D(int x, int y, int z)`의 첫 줄에 `Point`클래스의 생성자<br>
`Point(int x, int y)`를 호출해 주어야 하는데, 해당 작업은 아래와 같이 `super()`를 이용하면 된다.<br>

```java
Point3D(int z) {
  super(x, y); // super()를 통해 조상 클래스의 생성자(Point(int x, int y)를 호출.
  this.z = z;
}
```
<br>

이처럼 조상 클래스의 멤버변수는 조상의 생성자에 의해 초기화 되어야 한다.<br>
<br>

#### 💻 `super`를 활용한 조상 클래스의 멤버변수 초기화 예시코드(완성버전)

##### `PointTest2.java`
```java
class Point {
  int x = 10;
  int y = 20;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Point3D extends Point {
  int z = 30;

  Point3D(int x, int y, int z) {
    super(x, y);
    this.z = z;
  }

  Point3D() {
   this(100, 200, 300);
  }
}

class PointTest {
  public static void main(String[] args) {
    Point3D 3p = new Point3D();

    System.out.println("x : " + 3p.x);
    System.out.println("y : " + 3p.y);
    System.out.println("z : " + 3p.z);
  }
}
```
<br>

위 코드의 동작 흐름을 나타내면 다음과 같다.<br>

- 1) `Point3D()` - `this(100, 200, 300);`<br>
- 2) `Point3D(int x, int y, int z)` - `super(x, y);`<br>
- 3) `Point(int x, int y)`- `super();`<br>
- 4) `Object()`<br>
<br>

![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/732d0aae-6c7f-4c33-98fa-a24575edf99e)<br>
<br>

어떠한 클래스의 인스턴스를 생성하면, Java클래스 상속관계도의 최상위에 위치하는 `Object`클래스까지 거슬러 올라가면서,<br>
모든 조상 클래스의 생성자가 순서대로 호출된다는 것을 알 수 있다.<br>

**`Point3D 3p = new Point3D()`** -> `Point3D()` -> `point3D(int x, int y, int z)` -> `Point(int x, int y)` -> `Object()`<br>

---
<br>

## package와 import

### 📦 패키지(package)
패키지란, 클래스의 묶음이다. 이러한 패키지에는 클래스 또는 인터페이스를 포함시킬 수 있다.<br>
**패키지를 통해 우리는, 서로 관련있는 클래스들을 그룹 단위로 묶어놓음으로써 클래스를 효율적으로 관리하는 것이 가능하다.<br>**

이러한 '패키지'라는 개념이 존재하기 때문에, 같은 이름을 가진 다른 내용의 클래스의 경우, '어느 패키지에 저장되어 있는가?'를 기준<br>
으로 구분하는 것이 가능하여, 서로 충돌하는 것을 피할 수 있다.<br>

해당 경우를 예를 들면, `String`클래스의 실제 이름 즉, full name은 패키지명을 포함한 `java.lang.String`이다.<br>
이는 `java.lang`패키지에 속해있는 `String`클래스 라는 의미이다.<br>
**그래서 같은 이름을 가진 클래스라도, 서로 다른 패키지에 존재한다면, 패키지명으로 구별하는 것이 가능하다!<br>**
<br>

### 물리적인 관점으로 본 패키지
> **클래스가 물리적으로 하나의 클래스파일(`.class`)인 것과 같이 패키지는 물리적으로 하나의 디렉토리이다.<br>**
> - 패키지 - 디렉토리
> - 클래스 - 클래스 파일(`.class`)

<br>

때문에, 어떠한 패키지에 속한 클래스는 해당 패키지(디렉토리)에 속하는 클래스 파일(`.class`)이어야 한다.<br>
예를 들어, `java.lang.String`클래스는 물리적으로 `java`라는 디렉터리의 서브 디렉터리인`lang` 디렉터리에 속해있는<br>
`String.class`파일이다.<br>

디렉토리가 하위 디렉토리를 가질 수 있는 것처럼, 물리적으로 하나의 디렉토리인 패키지도 마찬가지로, 다른 패키지를 포함할 수 있다.<br>
이러한 패키지의 포함관계는 `.`을 통해 표현이 가능하다.<br>

위 설명을 토대로, `java.lang.String`의 경우, `java`라는 패키지(디렉토리)에 포함되어 있는 `lang`이라는 패키지 (서브 디렉토리)에<br>
속해 있는 `String.class`파일이라는 의미를 가는 것이다.<br>
<br>

마지막으로, 패키지의 특성을 정리해 보면, 다음과 같다.<br>
> - 하나의 소스파일에는 첫 번째 문장으로 단 한번의 패키지 선언만을 허용한다.
> - 모든 클래스는 만드시 하나의 패키지에 속해야 한다.
> - 패키지는 점(`.`)을 구분자로 하여 계층구조로 구성할 수 있다.
> - 패키지는 물리적으로 클래스 파일(`.class`)을 포함하는 하나의 디렉토리이다.
<br>

### 패키지의 선언
패키지 선언문의 작성 규칙에 대해 정리해 보도록 하겠다.<br>
먼저, 패키지 선언문은 소스파일(`.java`)의 맨 위에 아래와 같은 한 줄을 작성해 주어야 한다.<br>
```java
package패키지명; 
```
<br>

이러한 패키지 선언문의 작성 시, 참고해야할 점들은 다음과 같다.<br>
- 소스파일 내에서 주석과 공백을 제외한 첫 번째 문장이어야 하며, 하나의 소스파일에 단 한번만 선언될 수 있다.
- 해당 소스파일에 포함된 모든 클래스나 인터페이스는 선언된 패키지에 속하게 된다.
- 패키지명은 대소문자를 모두 허용하지만, 클래스명과 쉽게 구별하기 위해, 소문자로 하는 것을 원칙으로 하고 있다.
<br>

### 이름없는 패키지(unnamed package)
**'모든 클래스는 반드시 하나의 패키지에 포함되어 있어야 한다.'** 이러한 패키지의 특성에도 불구하고, 따로 소스파일에 패키지를<br>
선언해주지 않아도 문제없이 소스파일 작성 및 실행이 가능하였다.<br>
(소스파일에 패키지 선언이 없어도 아무런 문제가 발생하기 않았음)<br>

소스파일에 패키지의 선언문이 존재하지 않는데도 아무런 문제가 일어나지 않았던 이유는 바로, 자바에서 기본적으로 제공해주는<br>
**이름없는 패키지(unnamed pakcage)** 때문이다.<br>

소스파일에 자신이 속할 패키지를 지정하지 않은 클래스는 즉, 상단에 패키지 선언문이 작성되어있지 않은 소스파일에 작성된 클래스의<br>
경우, 자동적으로 이름없는 패키지에 속하게 된다.<br>

결국, 이렇게 자신이 속할 패키지를 지정하지 않는 모든 클래스들은 이름없는 패키지라는 하나의 같은 패키지에 속하게 되는 셈이다.<br>

간단한 프로그램의 경우, 이렇게 패키지를 따로 지정해 주지 않아도 별 문제 없지만, 큰 프로젝트나 Java API와 같은 클래스 라이브러리<br>
를 작성하는 경우에는 미리 패키지를 구성하여 적용해야한다.<br>
<br>

### 🔌 import문

### 다른 패키지의 클래스를 사용하는 방법 1 - 패키지명이 포함된 클래스 이름(full name) 사용하기
**"모든 클래스는 반드시 하나의 디렉토리에 포함되어 있어야 한다."**<br>

소스코드를 작성하는데 있어, 해당 소스코드 맨 상단에 선언되어 있는 패키지가 아닌, 다른 패키지의 클래스를 사용하려면 패키지명이<br>
포함된 클래스 이름(full name)을 사용해야 한다.<br>

패키지란, 위에서도 설명하였듯이, 물리적으로 클래스나 인터페이스를 저장하는 디렉토리의 개념으로, 물리적으로 보았을 때 하나의<br>
클래스 파일(`.class`)인 클래스들을 저장한다.<br>

때문에, 클래스의 full name인 `패키지명.클래스이름`의 경우, 사용하고자 하는 클래스와 해당 클래스가 저장되어 있는 위치(디렉토리)<br>
를 의미하게 된다.<br>

따라서 우리는 패키지명이 포함된 클래스 이름을 사용하여 다른 패키지에 포함되어 있는 클래스를 사용하는 것이 가능하다.<br>

하지만, 이렇게 매번 패키지명이 포함된 클래스 이름을 사용하여 다른 패키지의 클래스를 사용하는 것은 비효율적이다.<br>
매번 사용하고자 하는 클래스의 패키지명을 붙여서 사용하는 것은 불편하기 때문이다.<br>
<br>

### 다른 패키지의 클래스를 사용하는 방법 2 - `import`문 사용하기
클래스의 코드를 작성하기 전에, import문으로 사용하고자 하는 클래스의 패키지를 미리 명시해주면, 소스코드에 사용되는 다른 패키지의<br>클래스의 이름(full name)에서 패키지명을 생략하여 사용하는 것이 가능하다.<br>

이것이 가능한 이유는 import문의 역할이 무엇인지를 생각해보면 알 수 있다.<br>
<br>

### import문의 역할
import문의 역할은 컴파일러에게 소스파일에 사용된 클래스의 패키지에 대한 정보를 제공하는 것이다.<br>
컴파일 시, 컴파일러는 이러한 import문을 통해 소스파일에 사용된 클래스들이 속해있는 패키지들을 알아낸 다음, 모든 클래스 이름앞에<br>
해당되는 패키지명을 붙여준다.<br>

즉, import문을 사용하지 않는 경우에는 우리가 직접 소스코드 상에서 사용하는 다른 패키지의 클래스들의 패키지명을 하나하나 클래스명<br>
에 붙여주어야 했지만,<br>
import문을 사용하면, 사용하는 클래스들의 패키지를 미리 명시해두고, 클래스 명만 사용하여 소스코드를 작성하고, 컴파일 시, 컴파일러<br>
가 import문을 보고 사용한 클래스의 패키지들을 알아내어, 해당되는 클래스들의 이름 앞에 패키지명을 우리 대신 붙여주게 된다.<br>

즉, 컴파일러에게 나 이런이런 패키지에 존재하는 클래스를 사용할 테니까, 너가 찾아서 클래스 이름 앞에 패키지명을 붙여줘~ 라고 명령<br>
하는 것이다.<br>

컴파일러가 사용한 클래스들의 패키지명을 import문을 통해알아내어, 우리 대신 사용하는 클래스명 앞에 해당되는 패키지명을 붙여주는 <br>
것이다.<br>
<br>

### import문의 선언
모든 소스파일(`.java`)에서 import문은 package문 다음에, 그리고 클래스 선언문 이전에 위치해야 한다.<br>
import문은 package문과는 달리, 한 소스파일 내에 여러번 선언하는 것이 가능하다.<br>

```java
// 일반적인 소스파일(*.java)의 구성은 다음의 순서로 되어 있다.

// 1) package문
// 2) import문
// 3) 클래스 선언
```
<br>

### java.lang 패키지
지금까지 `String`과 `System`같은 `java.lang`패키지의 크래스들은 패키지명 없이(full name을 사용하지 않고) 사용할 수 있었던<br>
이유는 모든 소스파일에는 묵시적으로 다음과 같은 import문이 선언되어 있기 때문이다.<br>

```java
import java.lang.*; // java.lang패키지의 모든 클래스들을 패키지명 없이 사용하겠다!
```
<br>

`java.lang`패키지는 매우 빈번히 사용되는 중요한 클래스들이 속한 패키지이기 때문에, 따로 import문으로 지정하지 않아도 되도록 한<br>
것이다.<br>
<br>

### static import문
import문을 사용하면 클래스의 패키지명을 생략하여 사용할 수 있었던 것과 같이, static import문을 사용하는 경우에는 static멤버를<br>
호출할 때 클래스명을 생략하는 것이 가능하다.<br>

이러한 static import문은 특정 클래스의 자주 사용하는 static멤버를 호출할 때 적용시 편리하며, 코드가 간결해진다는 장점이 있다.<br>

예를 들어보면, `Math.random()`메서드는 아래와 같이,  `java.lang`패키지의 `Math`클래스에 static으로 선언되어 있는 static<br>
멤버이다.<br>

```java
public static double random()
```
<br>

소스코드에 아래와 같이 static import문을 이용하여 미리 선언을 해주면, `random()`메서드앞에 클래스명인 `Math`를 붙이는 것을<br>
생략하여 `random()`메서드를 호출하는 것이 가능해진다.<br>

```java
static import java.lang.Math.random;
/*
메서드 이름 뒤에 괄호를 붙이지 않은 형태로 선언해 준다.

java.lang 패키지의 Math클래스에 static으로 선언되어 있는 random()메서드를
클래스이름(Math)를 붙이지 않고 사용이 가능해진다.
*/

// ...

System.out.println(random()); // System.out.println(Math.random());
```

---
<br><br>

## 제어자(modifier)
제어자(modifier)는 클래스나 변수, 메서드의 선언부에 함께 사용되어, 각 제어자가 의미하는 부가적인 의미를 부여해 준다. 이러한, 제어자의 종<br>
류는 아래와 같이 크게 2가지 종류로 나뉜다.<br>
1. 접근 제어자 `public`, `protected`, `dufault`, `private`
2. 접근 제어자 외의 제어자 **`static`**, **`final`**, **`abstract`**, `native`, `transient`, `synchronized`, `volatile`, `strictfp`
<br><br>

제어자는 주로 **클래스**, **멤버변수**, **메서드**에 주로 사용되며, 하나의 대상에 대해서 여러개의 제어자를 조합하여 사용하는 것이 가능하다. 이때, 접<br>
근 제어자의 경우, 하나의 대상에 대해서 한 번에 4개의 접근 제어자 중, 하나만 선택하여 사용하는 것이 가능하다.<br>

즉, 예를 들어, 접근 제어자의 경우, 하나의 대상에 대해서 `public`과 `private`를 함께 조합하여 사용하는 것이 불가능 하다는 것이다. 또, 제어자<br>
들 간의 순서는 관계가 없지만, 주로 접근 제어자를 제일 왼쪽에 놓는 경향이 있다.<br>
<br>

### 접근 제어자 외의 제어자
### 1) `static` - 클래스의, 공통적인
`static`은 '클래스의', '공통적인' 이라는 의미를 가진다. 인스턴스 변수의 경우, 하나의 클래스로부터 생성된 인스턴스일 지라도, 각 인스턴스의 인스턴스 멤버 변수에 저장되어 있는 값들은 각기 다르다.<br>

하지만, static 멤버 변수(클래스 변수)의 경우, 인스턴스에 관계없이, 모두 같은 값을 가지게 된다. 이는 해당 클래스로부터 생성되는 모든 인스턴스들이 하나의 같은 메모리 공간(static 멤버 변수)을 공유하기 때문이다.<br>
<br>

이러한 제어자 `static`이 사용될 수 있는 곳은 다음과 같다.<br>
> **메서드**, **멤버변수**, **초기화 블록(static 변수의 복잡한 초기화 수행)**
<br>

- ##### static 제어자가 붙은 메서드의 특징
  - 해당 메서드가 멤버로 속해 있는 클래스의 인스턴스를 생성하지 않고도 호출하여 사용하는 것이 가능하다.<br>
  - static 메서드 내에서는, 인스턴스 멤버를 직접 사용하지 않는다.<br>
  - 인스턴스 멤버를 사용하지 않는 메서드인 경우, 애초에 static을 붙여, static 메서드로 선언해 주는 것이 좋다.<br>
     인스턴스 생성 없이 호출이 가능하기 때문에, 편리하며, 속도 또한 빠르다.<br>

- ##### static 제어자가 붙은 멤버변수의 특징
  - 해당 멤버변수가 속한 클래스로부터 생성되는 모든 인스턴스들이 공통적으로 사용하는 static 멤버 변수가 된다.<br>
  - 클래스 변수는 클래스 메서드와 마찬가지로, 인스턴스를 생성하지 않아도 사용이 가능하다.<br>
  - 클래스 변수는 클래스가 메모리에 로드될 떄 생성된다.<br>
<br>

### 2) `final` - 마지막의, 변경될 수 없는
`final`은 '마지막의', '변경될 수 없는' 이라는 의미를 가진다. 이러한 final 제어자는 거의 모든 대상에 사용이 가능하다.<br>

먼저, 변수(지역 변수, 멤버 변수)에 사용되는 경우, 변경할 수 없는 상수가 되고, 메서드에 사용되는 경우, 해당 메서드는 오버라이딩이 할 수 없게 된다. 그리고 클래스에 사용되는 경우, 자신을 확장하는 자손 클래스를 정의할 수 없게 된다.<br>
<br>

제어자 `final`이 사용될 수 있는 곳은 다음과 같다.<br>
> **클래스**, **메서드**, **멤버변수**, **지역변수**
<br>

- ##### final 제어자가 붙은 클래스의 특징
  - 변경될 수 없는 클래스, 상속을 통해 확장될 수 없는 클래스가 된다. 때문에, final이 붙은 클래스의 경우, 자신을<br>
    확장하는 자손 클래스를 정의할 수 없다. 즉, 다른 클래스의 조상 클래스가 될 수 없다.<br>

- ##### final 제어자가 붙은 메서드의 특징
  - 변경될 수 없는 메서드, final 제어자가 붙은 메서드의 경우, 해당 메서드를 오버라이딩 하여 제정의 할 수 없다.<br>

- ##### final 제어자가 붙은 변수(멤버변수, 지역변수)의 특징
  - 값을 변경할 수 없는 상수가 된다. 
<br>

### 생성자를 이용한 final 멤버변수의 초기화
final 제어자가 변수 앞에 붙은 경우, 해당 변수는 값을 변경할 수 없는 상수가 된다. 이러한 상수는 일반적으로, 선언과 초기화를 동시에 한다. 하지만, final이 붙은 인스턴스 변수의 경우, 값을 변경할 수 없는 상수임에도, 생성자에서 초기화 되도록 하는 것이 가능하다.<br>

클래스 내에서 매개변수를 가지는 생성자를 선언하여, 해당 클래스의 인스턴스가 생성될 때, final 인스턴스 변수를 초기화는데 필요한 값을 생성자의 매개변수로부터 제공받아, final 인스턴스 변수를 초기화 하는 것이다.<br>

이러한 생성자를 이용한 final 인스턴스 변수의 초기화를 통해, 하나의 클래스로부터 생성된 인스턴스들의 final 인스턴스 변수가 각기 다른 값을 저장하게 하는 것이 가능하다.<br>

클래스를 작성하면서 final 인스턴스 변수를 선언 및 초기화 할 때, 일반적인 상수의 초기화 방식(선언과 동시에 초기화)으로 초기화를 해버리면, 해당 클래스의 인스턴스들의 final 인스턴스 변수는 클래스를 작성하면서 선언과 동시에 초기화 해준 모두 같은 값을 가지게 될 수 밖에 없다.<br>

다음은 클래스 내에서 상수의 일반적인 초기화 방식을 통해 final 인스턴스 변수를 초기화 하는 경우, 해당 클래스로 부터 생성되는 모든 인스턴스들이 가지고 있는 final 인스턴스 변수가 같은 값을 가지게 됨을 나타내본 예시 코드이다.<br>

```java
class Number{
    final int NUMBER = 10; // 상수의 일반적인 초기화 방식 - 선언과 동시에 초기화
    
    void getNumber() {
        System.out.println(NUMBER);
    }
}

class Ex07_08_FinalTest {
    public static void main(String[] args) {
        Number n1 = new Number();
        System.out.println("n1 : " + n1.NUMBER);
        
        Number n2 = new Number();
        System.out.println("n2 : " + n2.NUMBER);
        
        Number n3 = new Number();
        System.out.println("n3 : " + n3.NUMBER);
    }
}

/* 실행결과
n1 : 10
n2 : 10
n3 : 10 */
```
<br>

이번엔, 생성자를 통한 final 인스턴스 변수 초기화 방법을 통해 클래스에 매개변수가 존재하는 생성자를 추가하여, 해당 클래스의 인스턴스가 생성될 때, 생성자의 매개변수를 통해 final 인스턴스 변수를 초기화 하는데 필요한 값을 제공받아, final 인스턴스 변수를 초기화 해 보도록 하겠다.<br>

해당 방법을 사용하면, 하나의 클래스로부터 생성된 인스턴스들의 final 인스턴스 변수가 각각 다른 값을 저장하는 것이 가능해지게 된다. 즉, **인스턴스 별로 다른 값을 저장하는 것이 가능하고, 값의 변경이 불가능한 final 인스턴스 변수**가 되는 것이다. (초기화 방법에 따라 이렇게 특성이 변한다.)<br> 

이렇게, 인스턴스 별로 다른 값을 저장하는 것이 가능하고, 값의 변경이 불가능한 final 인스턴스 변수를 사용하는데 적합한 예시가 하나 있다. 바로 '트럼프 카드'이다.

트럼프 카드의 경우, 52장의 **각 카드마다 다른 종류와 숫자를 가지며,** 해당 카드 인스턴스가 생성되고 나면, 각 **카드의 종류와 숫자는 변경되어선 안된다.** 52장의 카드 중에서 하나의 값만 잘못 바꾸어도, 같은 카드가 2장 생기게 되기 때문이다.<br>

그렇기 때문에, 카드 인스턴스의 값을 변경하기 보다는 카드의 순서를 바꾸는 것이 더 안전한 방법이라 할 수 있다. 이때, 카드 인스턴스의 값(종류와 숫자)을 나타내는 멤버변수를 final 인스턴스 멤버변수로 선언해 주면, 인스턴스 별로 다른 값을 저장하면서, 변경할 수 없게 만들어 줄 수 있다.<br>

다음은 매개변수가 있는 생성자를 통해 초기화한 final 인스턴스 변수를 사용하여 작성한 트럼프 카드 프로그램으로, 52장의 카드 객체를 객체배열에 저장하고, 저장된 카드 객체의 final 인스턴스 변수인`KIND`와 `NUMBER`, static 멤버 변수인 `width`와 `height`의 값을 출력해준다.<br>

```java
import java.util.Scanner;

class FinalCard {
    /* 상수지만 선언과 함꼐 초기화 하지 않고, 매개변수를 가지는 생성자를 통해, 인스턴스가 생성될 때 딱 한 번 초기화가 이루어짐.
    이후에 초기화는 불가능함 */
    final int NUMBER; 
    final String KIND;
    
    /* 카드의 크기(가로, 세로)는 모든 카드(인스턴스)가 같아야 하므로, 해당 클래스로부터
    생성되는 모든 인스턴스들이 공유하여, 모든 인스턴스가 같은 값을 가지게 되는 static 멤버변수로
    선언해 주었다. */
    
    static int width = 100;
    static int height = 250;
    
    FinalCard(int num, String kind) {
        NUMBER = num;
        KIND = kind;
    }
    
    FinalCard() { // 기본 생성자를 통하여 인스턴스를 생성하는 경우, 해당 인스턴스의 final 인스턴스 변수는 각각 1, king으로 초기화 됨
        this(1, "king");
    }
}

class Ex07_09_FinalCardTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        FinalCard[] cardArr = new FinalCard[52];
        
        int i; 
        int j;
        int temp = 0;
        
        for (i = 0; i < 4; i++) {
            String kind;
            
            System.out.println("Enter the kind of card");
            kind = scanner.nextLine();
            
            for (j = temp; j < (temp + 13); j++) {
                cardArr[j] = new FinalCard((j - i * 13) + 1, kind);
            }
            temp += 13;
        }
        
        for (int index = 0; index < 52; index++) {
            System.out.println("Kind : " + cardArr[index].KIND + ", Number : " + cardArr[index].NUMBER + ", width : " + cardArr[index].width + ", height : " + cardArr[index].height);
        }
    }
}

/* 실행결과
Kind : spade, Number : 3, width : 100, height : 250
Kind : spade, Number : 4, width : 100, height : 250
Kind : spade, Number : 5, width : 100, height : 250
Kind : spade, Number : 6, width : 100, height : 250
Kind : spade, Number : 7, width : 100, height : 250
Kind : spade, Number : 8, width : 100, height : 250
Kind : spade, Number : 9, width : 100, height : 250
Kind : spade, Number : 10, width : 100, height : 250
Kind : spade, Number : 11, width : 100, height : 250
Kind : spade, Number : 12, width : 100, height : 250
Kind : spade, Number : 13, width : 100, height : 250
Kind : diamond, Number : 1, width : 100, height : 250
Kind : diamond, Number : 2, width : 100, height : 250

...

Kind : heart, Number : 10, width : 100, height : 250
Kind : heart, Number : 11, width : 100, height : 250
Kind : heart, Number : 12, width : 100, height : 250
Kind : heart, Number : 13, width : 100, height : 250 */
```
<br>

### `abstract` - 추상의, 미완성의 
abstract는 '추상의', '미완성의'라는 의미를 가진다. 메서드의 선언부만 작성하고, 실제 수행내용은 구현하지 않은 '미완성'의 메서드를 가리켜, 추상 메서드라고 하는데, abstract는 이러한 추상 메서드의 선언에 사용된다.<br>

그리고, 이러한 추상 메서드가 클래스 내에 선언되어 있는 경우, 해당 클래스를 가리켜, 추상 클래스라고 한다. abstract는 이러한 추상 클래스에도 사용되어, 해당 클래스가 추상 메서드를 포함하는 추상 클래스임을 표시할 수 있게 해준다.<br>

추상 클래스는 아직 완성되지 않은 메서드를 포함하고 있는, 인스턴스의 '미완성 설계도'이기 때문에, 인스턴스를 생성할 수 없다.<br>
<br>

abstract가 사용될 수 있는 곳은 다음과 같다.<br>
> **클래스, 메서드**

<br><br>

## 접근 제어자(access modifier)
이전까지 설명하였던 제어자는 접근 제어자 외의 제어자에 대한 설명이였다. 이번엔 접근 제어자에 대해 다뤄보도록 하겠다. 접근 제어자는 **멤버**나 **클래스**에 사용되는데, 외부로부터 해당되는(접근 제어자가 붙은) 멤버나 클래스에 접근을 하지 못하도록 제한하는 역할을 한다.<br>

접근 제어자는 `public`, `pretected`, `(default)`, `private` 이렇게 총 4가지의 종류가 있으며, 이러한 종류에 따라 외부의 접근을 제한하는 범위가 달라지게 된다. 이러한 접근 제어자는 하나의 대상에 하나만 사용하는 것이 가능하다.<br>
<br>

접근 제어자 `public`, `pretected`, `(default)`, `private`이 사용될 수 있는 곳은 다음과 같다.<br>
> **클래스**, **멤버(멤버변수, 메서드, 생성자)**

<br>

### 접근 제어자의 종류별 범위
접근 제어자의 종류별 범위를 정리해 보면 다음과 같다.<br>

**`public`** - 접근 제한이 전혀 없다.<br>
**`protected`** - 같은 클래스, 같은 패키지 그리고 패키지에 상관없이 상속관계를 가지는 자손클래스에서 접근하는 것이 가능하다.<br>
**`(default)`** - 같은 클래스, 같은 패키지 내에서만 접근이 가능하다.<br>
**`private`** - 같은 클래스 내에서만 접근이 가능하다.<br>
<br>

### 대상에 따라 사용할 수 있는 접근 제어자
접근제어자를 적용하는 대상에 따라, 사용할 수 있는 접근 제어자가 달라지게 된다. 이때, 접근 제어자를 사용할 수 있는 대상으로는 **클래스**,**멤버(멤버변수, 메서드, 생성자)** 가 있다. 즉, 접근 제어자를 **클래스**에 적용하느냐, **멤버**에 적용하느냐에 따라, 사용할 수 있는 접근 제어자가 달라지는 것이다.<br>
<br>

대상에 따라 사용할 수 있는 접근 제어자를 정리해보면, 다음과 같다.<br>

> **클래스에 사용가능한 접근 제어자** - `public`, `(default)`<br>
>**멤버(멤버변수, 메서드, 생성자)에 사용 가능한 접근 제어자** - `public`, `protected`, `(default)`, `private`<br>
>

<br>

위 정리를 보면 알 수 있듯이, 클래스에는 접근 제어자 `pulbic`, `(default)` 이 2개만 사용이 가능하고, 멤버에는 `public`, `protected`, `(default)`, `private` 4개 모두 사용이 가능하다.<br>
<br>

### 접근 제어자를 이용한 캡슐화
클래스나 멤버, 특히 주로 멤버에 접근 제어자를 사용하는 이유는 **클래스 내부에 선언된 데이터를 보호하기 위해서이다.** 만약에 클래스 내부에 선언되어 있는 데이터가 비밀번호와 같은 민감한 내용의 데이터일 경우, 해당 데이터를 함부로 변경하지 못하도록 외부의 접근을 제한해 주어야 한다.<br>

이렇게, 외부로부터의 데이터 접근을 제한하는 것을 두고, 데이터 숨기기(data hiding)이라고 하며, 이는 객체지향개념의 캡슐화(encapsulation)에 해당하는 내용이다.<br>

접근 제어자는, 위와 같이 민감한 데이터를 외부로부터 보호하기 위해 접근을 제한하는 용도로도 사용하기도 하지만, **클래스 내부에서만 사용되는 멤버들을 `private`로 지정하여, 외부에 노출시키지 않음으로써 복잡성을 줄이기 위해서도 사용된다.** 이 내용 또한 객체지향개념의 캡슐화에 해당된다.<br>
<br>

이를 바탕으로 접근 제어자를 사용하는 이유를 간단히 정리해 보면 다음과 같다.<br>
> 1. 외부로부터의 접근을 제한하여 데이터를 보호하기 위해서<br>
> 2. 외부에는 불필요한(접근할 필요가 없는), 내부적으로만 사용되는 부분을 궅이 외부에 노출시키지 않음으로써, 복잡성을 줄이기 위해서<br>

<br>

### 접근 제어자의 사용예시 
아래 시간(시, 분, 초)을 나타내는 `Time`클래스를 한번 보도록 하자.<br>
```java
class Time {
  int hour;
  int minute;
  int second;
}
```
<br>

현재 이 `Time`클래스의 경우, 아래와 같이 해당 클래스의 인스턴스를 생성하고, 이 인스턴스의 멤버변수에 직접 접근하여 아무 값으로나 초기화 해주는 것이 가능하다.<br>
```java
Time t = new Time();
t.hour = 25;
t.minute = 62;
t.second = 87;
```
<br>

`Time`클래스의 인스턴스가 올바른 시간을 나타내기 위해서는 시간을 나타내는 멤버변수 `hour`의 경우, 0 <= `hour` < 24의 범위에 해당하는 값을 가져야 하고, 분과 초를 나타내는 멤버변수 `minute`과 `second`의 경우, 0 <= `minute`, `second` < 60에 해당하는 값을 가져야 한다.<br>

위의 코드처럼 외부에서 아무나 멤버변수에 접근하여 아무 값으로나 초기화 하는 경우, 올바른 시간을 나타낼 수 없다. 즉, 제 기능을 할 수 없게되는 것이다. 이러한 문제점을 해결해 주기 위해서 먼저 어떻게 하면 좋을까?<br>

그렇다. 올바른 값의 범위가 정해져 있는 멤버변수 `hour`, `minute`, `second`에 함부로 접근하여, 아무 값으로 초기화 하지 못하도록 **제한을 걸어 주어야 한다.** 이때, 이 제한을 걸어줄 수 있는 방법이 바로, 접근 제어자를 사용해주는 것이다.<br>

그렇다면, 해당 경우에는 4개의 접근 제어자들 중, 무엇을 사용하는 것이 좋을까? 먼저 첫 번째로 떠오르는 것은 `private`일 것이다. 그리고, `Time`클래스의 자손 클래스를 생성하여 해당 클래스를 확장해야하는 상황이라면, 자손 클래스의 접근까지 허용하는 `protected`를 사용해야 할 것이다.<br>
<br>

일단은, `Time`클래스의 자손 클래스를 생성하지는 않을 것이므로, 아래와 같이 접근 제어자 `private`를 통해 캡슐화를 해 주었다.<br>
```java
class Time {
  private int hour;
  private int minute;
  private int second;
}
```
<br>

이렇게, 접근 제어자`private`을 이용한 캡슐화를 통하여, 외부에서 `Time`클래스의 멤버에 직접 접근하지 못하게 하였다. **이제 `Time`클래스 내에서만 해당 멤버변수들에 접근하는 것이 가능하다.** <br>

`Time`클래스 내에서 `private`멤버변수들에 접근하여 값을 초기화 하고, 읽어오기 위해, 다음과 같은 함수를 만들어 보았다. 앞에 `get`이 붙어있는 함수는 멤버변수의 값을 불러오는 함수이고, `set`이 붙어있는 함수는 값을 초기화 해주는 함수이다.<br>
<br>

해당 메서드들을 통해,  클래스 내에서 `private`멤버변수들에 간접적으로 접근하는 것이다.<br>

```java
class Time {
  /* private - 같은 클래스 내에서만 접근 가능(클래스 외부에서 접근 불가)
     private 접근 제어자가 붙은 아래 변수들에는 해당 클래스 내에서만 접근이 가능하다. */
  private int hour;
  private int minute;
  private int second;

  /* public - 전체 범위에서 제한없이 접근 가능
     Time 클래스 내의 private 멤버변수들에 접근하여 값을 읽어오고, 초기화 해주는 get~, set~ 함수에는
     public 접근 제어자가 붙어, 어디서든 제한 없이 접근이 가능하다.*/
  public int getHour() { return hour; }
  public void setHour(int hour) {
    if(hour < 0 || hour > 23)
      return;
    this.hour = hour;
  }

  public int getMinute() { return minute; }
  public void setMinute(int minute) {
    if(minute < 0 || miniute > 59)
      return;
    this.minute = minute;
  }

  public int getSecond() { return second; }
  public void setSecond(int second) {
    if(second < 0 || second > 59)
      return;
    this.second = second;
  }
}
```
<br>

### 생성자의 접근 제어자
생성자에 접근 제어자를 사용함으로써, 인스턴스의 생성을 제한할 수 있다. 만약, 생성자에 접근 제어자 `private`가 붙는 경우, `private`생성자가 존재하는 클래스 외부에서 해당 생성자에 접근하는 것이 불가능하게 되므로, 외부에서는 인스턴스를 생성할 수 없게 된다.<br>

하지만, `private`생성자가 존재하는 클래스 내부에서는 해당 생성자를 사용하여 인스턴스를 생성하는 것이 가능하다. `private`생성자는 같은 클래스 내에서는 접근을 허용하기 때문이다.<br>

```java
class Singleton {

  /* private 접근 제어자가 붙은 생성자 */
  private Singleton() { // 
    // ...
  }

}
```
<br>

위와 같은 `private`생성자를 사용하는 경우, 해당 생성자가 존재하는 같은 클래스 내에서만 인스턴스를 생성할 수 있게 된다. 이러한 상태에서, 클래스 내에서 생성해낸 인스턴스를 외부로 반환해주는 `public`메서드를 제공해줌으로써,<br>

외부에서는 생성자를 통해 직접 `Singleton`클래스의 인스턴스를 생성할 수 없고, `public`메서드를 통해 반환받은 인스턴스에만 접근하는 것이 가능하게 된다.<br>

결국, 클래스 내부에서 생성해낸 인스턴스를 `public`메서드를 통해 반환받는 것 밖에 할 수 없는 외부 입장에서는 사용할 수 있는 인스턴스의 개수를 제한받게된다.<br>

직접 생성자를 사용하여 인스턴스를 원하는 만큼 생성할 수 있는 것이 아닌, 클래스 내부에서 생성해준 인스턴스를 `public`메서드를 통해서 반환받는 것 밖에 못함. 즉, 내부에서 만들어준 만큼만 반환받아 사용하는 것이 가능한 것이다.<br>
<br>

다음은 클래스 내부에서 인스턴스를 생성하고 해당 인스턴스를 외부에서 접근하게하는 생성자에 `private`접근제어자를 적용한 예시 코드이다.<br>
```java
class Singleton {
  // ...
     
  private static Singleton s = new Singleton();

  private Singleton() {
    // ...
  }

   public static getInstance() {
     return s;
   }

  // ...
}
```
<br>

위 코드를 나눠서 이해해 보도록 하겠다.<br>
<br>

먼저, 아래 코드를 한번 보자. 생성자에 `private`접근 제어자가 붙어 있는 것을 알 수 있다. `private`생성자는 `Singleton`클래스 내에서만 사용이 가능하다. 때문에, 외부에서 직접 해당 생성자를 통해 인스턴스를 생성하는 것은 불가능하다.<br>

즉, `private Singleton()` 생성자의 호출이 필요한 `Singleton`클래스의 인스턴스 생성은 반드시 `Singleton`클래스 내에서 이루어져야 한다. 해당 생성자를 호출하여 인스턴스를 생성하고, 만들어진 인스턴스를 외부로 반환해주는 메서드를 만들면<br>

`Singleton`클래스 내부에서 `private`생성자를 호출하여 클래스 내부에 인스턴스를 생성하고, 만들어진 인스턴스를 외부에서 반환받아 접근하게 하는 것이 가능하게 될것이다.<br>

```java
private Singleton() {
  // ...
}
```
<br>

자, 그럼 `Singleton`클래스 내부에서 `private`생성자를 호출하여 인스턴스를 생성하고, 해당 인스턴스를 외부로 반환해주는 `getInstance`메서드를 만들어 보도록 하겠다.<br>

아래 코드와 같이, 외부에서 직접 `private`생성자를 호출하여 `Singleton`클래스의 인스턴스를 생성하는 것은 불가능하다.<br>
`Singleton s = new Singletion();`
<br>

이러한 상황에서 외부에서 해당 클래스의 인스턴스를 생성하고 접근할 수 있는 방법은 오직 `getInstance`메서드를 통해 `Singleton`클래스 내부에서 인스턴스를 생성하고 이를 반환받는 방법 뿐인데,<br>

이 `getInstance`메서드가 인스턴스를 생성해야지만 사용이 가능한 인스턴스 멤버라면, 외부에서 해당 메서드에 접근할 수 있는 방법은 사라지게 된다. 애초에 외부에서는 `Singleton`클래스의 인스턴스를 생성할 수 없기 때문이다.<br>

그렇기 때문에, 내부에서 생성한 인스턴스를 리턴해주는 메서드 `getInstance`는 `Singleton`클래스의 인스턴스를 생성해야지만 사용이 가능한 인스턴스 멤버가 아닌, `Singleton`클래스의 인스턴스를 생성하지 않아도 사용이 가능한 클래스 멤버여야 한다.<br>

그리고, 외부에서 `getInstance`메서드에 제한없이 접근하여, `Singleton`클래스 내부에서 생성된 인스턴스를 반환받기 위해서는 해당 메서드의 접근 제어자를 `public`으로 지정해 주어야 한다.<br>
```java
public static getInstance() {
  return s;
}
```
<br>

마지막으로, `Singleton`클래스 내부에서 `Singleton`클래스의 인스턴스를 생성하는 내용의 코드이다. 해당 인스턴스를 외부로 반환해주는 메서드인 `getInstance`메서드가 `static`메서드이기 때문에, 해당 메서드에서 사용될 수 있도록 인스턴스가 미리 생성되어야 하므로 해당 인스턴스 또한 생성시기가 같은 `static`이어야 한다.<br>
```java
private static Singleton s = new Singleton();
```
<br>

### 생성자가 `private`인 클래스
위 코드의 경우와 같이, 생성자가 `private`인 클래스는 다른 클래스의 조상클래스가 될 수 없다.<br>

이유는, 자손클래스가 인스턴스를 생성할 때 조상 클래스의 생성자를 호출해야만 하는데, 생성자의 접근제어자가 `private`이므로, 자손 클래스에서 조상 클래스의 생성자를 호출하는 것이 불가능하기 때문이다.<br>

그래서, 클래스 앞에 제어자 `final`을 추가하여, 상속이 불가능한 클래스임을 표시해 두는 것이 좋다. '마지막의, 변경할 수 없는' 이라는 의미를 가지는 `final`제어자가 클래스 앞에 붙으면, 해당 클래스는 상속을 통해 확장될 수 없는 클래스가 된다.<br>

아래는 생성자가 `private`인 클래스를 활용한 예시코드이다. 생성자가 `private`인 클래스의 경우, 다른 클래스의 조상 클래스가 될 수 없기에(상속을 통해 확장될 수 없기 때문에), 이를 명시하기 위해 `final`제어자가 붙은 것을 알 수 있다.<br>
```java
package chapter_07;

final class Singleton {
    private static Singleton s = new Singleton();
    
    private Singleton() {
        // ...
    }
    
    public static getInstance() {
        if(s == null) 
            s = new Singleton();
        
        return s;
    }
}

class Ex07_11_SingletonTest {
    public static void main(String[] args) {
        // Singleton s = new Singletion(); 
        
        Singleton s = Singleton.getInstance(); // public static 메서드이므로, 외부에서 클래스 이름을 통해 인스턴스를 생성하지 않아도 호출 가능
    }
}
```
<br>

## 다형성(polymorphism)
> **다형성은 객체지향 프로그래밍에 있어, 매우 중요한 개념이므로, 반드시 확실히 이해하고 넘어가야 한다!! (나 스스로에게 강조)**

<br>

### 다형성이란 무엇인가?
객체지향 개념에서 다형성이란, 쉽게 말해 *'여러가지 형태를 가질 수 있는 능력'* 을 의미한다. java에서는 이 다형성을 한 타입의 참조변수가 여러 타입의 객체를 참조할 수 있도록 함으로, 프로그램적으로 구현하였다.<br>

이를 자세히 말하자면, **조상 클래스 타입의 참조변수가 자손 클래스의 인스턴스를 참조할 수 있도록 하였다는 것**이다.<br>
<br>

다형성을 이해하기 위해 다음 간단한 코드를 보도록 하겠다.<br>
```java
class Tv {
  boolean power;
  int channel;

  void power() {power = !power;}
  void channelUp() {++channel;}
  void channelDown() {--channel;}
}

class CaptionTv {
  String text;
  void caption() { /* 내용 생략 */}
}
```
<br>

해당 코드를 보면, `Tv`클래스와 `CaptionTv`클래스는 서로 상속관계에 있음을 알 수 있다. 이를 그림으로 표현해 보면 다음과 같이 표현이 가능하다.<br>
```java


/* ppt 그림 첨부 */


```
<br>

이 두 클래스의 인스턴스를 생성하고 사용하기 위해서는 아래와 같이 할 수 있다.<br>

```java
Tv t = new Tv();
CaptionTv c = new CaptionTv();
```
<br>

이처럼, 지금까지 인스턴스를 다루기 위해서는 해당 인스턴스와 일치하는 타입(클래스)의 참조변수를 사용해야 했다.<br>

위 코드를 토대로 설명하면, `Tv`클래스의 인스턴스를 다루기 위해서는 `Tv`클래스 타입의 참조변수 `t`를 사용해야 하고, `CaptionTv`클래스의 인스턴스를 다루기 위해서는 `CaptionTv`타입의 참조변수 `c`를 사용해야 하는 것이 일반적이라는 것이다.<br>

이처럼, 보통의 경우, 인스턴스의 타입과 이를 다루는 참조변수의 타입이 일치하는 것이 일반적이다. 하지만, **상속관계에 있는 두 클래스의 경우, 조상 클래스 타입의 참조변수로 자손 클래스의 인스턴스를 참조하도록 하는 것이 가능하다!** <br>

서로 상속관계에 있는 두 클래스 `Tv`클래스와 `CaptionTv`클래스를 가지고 예를 들어보면, 아래와 같이 인스턴스를 생성하고 다루는 것이 가능한 것이다.<br>

```java
Tv t = new CaptionTv();

/* 조상 클래스 타입의 참조변수로 자손 클래스의 인스턴스를 참조함 -
두 클래스가 상속관계에 있는 경우 인스턴스와 이를 참조하는 참조변수의 타입 불일치가 허용됨*/
```
<br>

위 코드를 보면 알 수 있듯이, 조상 클래스 `Tv`타입의 참조변수 `t`가 자손 클래스`CaptionTv`의 인스턴스를 참조하고 있는 것을 알 수 있다. 이처럼, **상속관계에 있는 두 클래스의 경우, 조상 클래스 타입의 인스턴스 변수로 자손 클래스의 인스턴스를 참조하게 하는 것이 가능하다.** <br>

즉, 상속 관계에 있는 두 클래스의 경우, 일반적인 인스턴스를 사용하는 형태인 참조변수와 인스턴스의 타입이 일치하는 형태가 아닌, 인스턴스와 이를 가리키는 참조변수의 타입이 불일치한 형태가 허용된다는 것이다!<br>

java에서의 다형성은 이런식으로, **조상 클래스 타입의 참조변수로 자손 클래스의 인스턴스를 참조하는 것(다루는 것)을 의미한다.** <br>
<br>

### 일반적인 경우와 다형성을 사용하는 경우의 차이점의 이해
일반적인 경우, java에서 인스턴스를 다루기 위해서는 해당 인스턴스와 이를 참조하는 참조변수의 타입이 서로 일치해야 했다. 하지만, 다형성을 사용하는 경우, 조상 클래스 타입의 참조변수가 자손 클래스의 인스턴스를 참조하여 다루는 것이 가능하게 된다.<br>

즉, 인스턴스와 이를 참조하는 참조변수의 타입 불일치가 허용된다는 것인데, 이러한 경우, 인스턴스와 이를 참조하는 참조변수의 타입이 일치하는 일반적인 경우와 어떠한 차이와 장점이 존재하는지 알아보도록 하겠다. 아래 코드를 한번 봐 보자.<br>

```java
CaptionTv c = new CaptionTv();  // 인스턴스와 참조변수의 타입 일치
Tv t = new CaptionTv(); // 인스턴스와 참조변수의 타입 불일치(다형성 사용)
```
<br>

위 코드에서, 2개의 `CaptionTv`클래스의 인스턴스 2개를 생성하고, 해당 인스턴스를 각각 다른 타입의 참조변수 `c`(CaptionTv클래스 타입), `t`(Tv클래스 타입)가 가리키도록 하였다.<br>

이러한 경우, 같은 인스턴스를 가리키고 있는 상황이라 할 지라도, 해당 인스턴스를 가리키는 참조변수의 타입이 무엇이냐(인스턴스와 일치하냐/아니냐)에 따라서 사용할 수 있는 인스턴스의 멤버의 개수가 달라지게 된다. 이를 좀 더 자세히 다뤄 보도록 하겠다.<br>
<br>

- ### 인스턴스와 참조변수의 타입이 일치하는 경우
  먼저, 인스턴스와 이를 참조하는 참조변수의 타입이 일치하는 경우를 한번 보도록 하겠다. 위 예시 코드의 첫 번째 코드가 이에 해당하는 코드일 것이다. 해당 코드를 그림으로 나타내보면 아래와 같이 표현이 가능하다.<br>
  <br>
   
  ![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/b121978b-0dcd-49ef-9c42-8d33b5cefde5)
  <br>

  먼저, `CaptionTv`클래스의 인스턴스를 참조하는 참조변수 `c`의 타입이 `CaptionTv`클래스 타입으로, 인스턴스와 타입이 일치한다. 이 경우, 참조변수 `c`를 통해서는 `CaptionTv`인스턴스의 모든 멤버를 사용하는 것이 가능하다.<br>

  이해하기 쉽게 참조변수 `c`를 `CaptionTv`용 리모컨이라 예를 들면, `CaptionTv`가 가지고 있는 7개의 멤버 에 해당하는 버튼들이 참조변수 `c`라는 리모컨에 모두 존재한다 라고 할 수 있겠다.<br>
<br>

- ### 다형성을 사용하여 인스턴스와 참조변수의 타입이 일치하지 않는 경우
  그렇다면, 이제 다형성을 사용하여, 인스턴스와 탐조변수의 타입이 일치하지 않는 경우, 더 정확히, 조상 클래스 타입의 참조변수가 자손 클래스의 인스턴스를 참조하는 경우에는 어떠한 현상이 발생하는지 알아보도록 하겠다.<br>

  위 예시 코드의 두 번째 코드가 이에 해당하는 코드일 것이다. 해당 코드를 그림으로 나타내보면 아래와 같이 표현이 가능하다.<br>
  <br>

  ![스크린샷(4)](https://github.com/Yoonsik-2002/java-study/assets/83572199/c005d7eb-dfad-4b40-bd1f-97fd718c5407)
  <br>

  해당 경우에는 `CaptionTv`클래스의 인스턴스를 참조하는 참조변수 `t`의 타입이 `CaptionTv`클래스의 조상 클래스인 `Tv`클래스 타입으로, 인스턴스와 타입이 일치하지 않는다.<br>

  이러한 `Tv`클래스 타입의 참조변수로는 `CaptionTv`클래스의 인스턴스가 가지고 있는 모든 멤버를 사용하는 것이 불가능하다. 참조변수 `t`를 통해서는 오직, `CaptionTv` 인스턴스가 가지고 있는 멤버 중, `Tv`클래스의 멤버(상속받은 멤버 포함)만 사용하는 것이 가능할 뿐이다.<br>

  때문에, 생성된 `CaptionTv`인스턴스의 멤버 중에서, `Tv`클래스 에서는 정의되지 않은 멤버인 `text`와 `caption()`은 참조변수 `t`로 사용하는 것이 불가능하다 라고 할 수 있다.<br>

  이해하기 쉽게 예를 들어 설명하면, 우리가 사용하고자 하는 제품은 `CaptionTv`인데, `Tv`용 리모컨인 참조변수 `t`를 사용하여 `CaptionTv`를 사용하려 하는 것이다.<br>

  `Tv`용 리모컨인 참조변수 `t`에는 `Tv`를 동작하기 위한 버튼들만 존재할 뿐이지,`CaptionTv`의 추가적인 기능을 위한 버튼은 존재하지 않는 것이 당연하다. 즉, `Tv`용 리모컨인 참조변수 `t`에는 `Tv`클래스에 존재하는 5개의 멤버에 해당하는 버튼만이 존재할 뿐이다.<br>

  따라서, `Tv`클래스 타입의 참조변수 `t`로는 `Tv`클래스를 상속받아 확장한 형태인 자손 클래스 `CaptionTv`클래스 타입의 인스턴스의 모든 기능을 사용하는 것이 불가능하다.<br>

  제품에 아무리 기능이 많아도, 이를 다루는 리모컨에 해당되는 버튼이 없다면, 사용할 수 없는 기능이 되어버리는 것이다.<br>
<br>

### 자손 클래스 타입의 참조변수로 조상 클래스 타입의 인스턴스를 참조할 수는 없는 걸까?
다형성에 대한 내용을 정리하면서, 인스턴스의 타입과 이를 참조하는 참조변수의 타입이 일치하는 경우와 조상 클래스 타입의 참조변수가 자손 클래스 타입의 인스턴스를 참조하는 경우를 다뤄 보았었다.<br>

그렇다면, 반대로 자손 클래스 타입의 참조변수로 조상 클래스 타입의 인스턴스를 참조하게 할 수는 없는 걸까? 이번엔, 해당 질문에 대한 답을 내려 보도록 하겠다.<br>
<br>

아래 코드는 자손 클래스 타입의 참조변수로 조상 클래스 타입의 인스턴스를 참조하는 내용의 코드이다.<br>
```java
CaptionTv c = new Tv();
```
<br>

위 코드처럼 자손 클래스 타입의 참조변수로 조상 클래스 타입의 인스턴스를 참조하는 것은 불가능하다. 이유는, 인스턴스가 가지는 멤버의 개수 보다 참조변수가 사용할 수 있는 멤버의 개수가 더 많기 때문이다. 아래 그림을 한번 보자.<br>
<br>

![스크린샷(7)](https://github.com/Yoonsik-2002/java-study/assets/83572199/b7cefb17-092e-4194-9cb2-b3925c9b4693)<br>
<br>

`Tv`클래스의 자손 클래스인 `CaptionTv`클래스 타입의 참조변수 `c`는 `Tv`클래스의 멤버들에 추가적으로, 자기 자신이 가지고 있는 멤버, `text`와 `caption()`까지 총 7개의 멤버를 사용할 수 있다.<br>
<br>

하지만, 정작 참조변수 `c`가 참조하고 있는 인스턴스인, `Tv`클래스의 인스턴스는 5개의 멤버를 가지고 있을 뿐이다.<br>

즉, 참조변수 `c`가 사용할 수 있는 멤버는 7개인데, 정작, `c`가 가리키고 있는 인스턴스의 멤버는 5개로, 인스턴스가 가지는 멤버의 개수보다 참조변수가 사용할 수 있는 멤버의 개수가 더 많은 상황인 것이다.<br>

이러한 경우, 참조변수 `c`를 통해, `c.text`, `c.caption()`과 같은 멤버를 사용하고자 한다면, 이는 존재하지 않는 멤버를 사용하려 하는 꼴이 되어버린다.<br>

자손 클래스는 조상 클래스의 멤버를 상속받아, 이를 확장한 개념이라 할 수 있다. 이러한 자손 클래스 타입의 참조변수로 조상 클래스 타입의 인스턴스를 참조하는 경우, 참조변수가 사용할 수 있는 멤버의 개수가 실제 참조하고 있는 인스턴스가 가지는 멤버의 개수보다 많아지게 된다.<br>
<br>

이렇게 인스턴스가 가지고 있는 멤버의 개수보다, 해당 인스턴스를 참조하고 있는 참조변수가 사용할 수 있는 멤버의 개수가 더 많은 경우,<br>

**인스턴스엔 존재하지 않는 멤버를 사용하고자 할 가능성이 있으므로, 자손 클래스 타입의 참조변수가 조상 클래스의 인스턴스를 참조하는 것은 허용되지 않는다.** <br>

명심하자. 참조변수가 사용할 수 있는 멤버의 개수는 참조하고 있는 인스턴스의 멤버의 개수보다 작거나 같아야 한다. 클래스는 상속을 통해서 확장될 수는 있어도, 축소되지는 않는다. 때문에, 조상 인스턴스의 멤버 개수는 자손 인스턴스의 멤버 개수보다 항상 작거나 같을 수 밖에 없다.<br>
<br>

> **어떠한 타입의 참조변수를 사용하느냐에 따라서, 인스턴스에서 사용할 수 있는 멤버의 개수가 달라진다.<br>
(이때, 참조변수가 사용할 수 있는 멤버의 개수가 인스턴스의 멤버 개수보다 크면 안됨!)**

<br>

### 참조변수의 형 변환
> *어떠한 타입의 참조변수를 사용하느냐에 따라서, 인스턴스에서 사용할 수 있는 멤버의 개수가 달라진다.*<br>
<br>

참조변수의 형 변환은 무엇인가? 이는 어떠한 타입의 참조변수를 사용할 것인지를 정해주는 작업이라 할 수 있다.<br>

이때, 어떠한 타입의 참조변수를 사용하느냐에 따라, 인스턴스에서 사용할 수 있는 멤버의 개수가 달라지기 때문에 **결론적으로, 참조변수의 형 변환은 참조하고 있는 인스턴스에서 사용할 수 있는 멤버의 개수를 조절해주는 작업 이라고 할 수 있게 된다.**<br>
<br>

기본형의 형 변환의 경우, 예를 들어 3.6을 `int`형으로 형 변환할 시, 3으로 **값이 바뀌게 된다.** 그렇다면, 참조변수의 형 변환은 어떻게 될까? 기본형의 형 변환과 같이 값이 변화할까?<br>

아니다. 참조변수의 형 변환의 경우, 주소값(참조변수 값), 참조하고 있는 인스턴스(객체)가 변하는 것이 아니라, **참조하고 있는 인스턴스에서 사용할 수 있는 멤버의 개수만이 변하게 된다.** <br>

이러한 참조변수의 형 변환에 있어, 한 가지 주의할 점이 존재하는데, 바로 서로 상속 관계에 있는 클래스 사이에서만 형 변환이 가능하다는 점이다. 아래와 같이 말이다.<br>
<br>

![스크린샷(4)](https://github.com/Yoonsik-2002/java-study/assets/83572199/b67d6a37-c18f-42f4-946b-cc431258050a)
##### 이때, 무조건 바로 윗 조상이나, 자손이 아닌, 조상의 조상 클래스 혹은 자손의 자손 클래스 타입으로도 형 변환이 가능하다. 즉, 상속 관계에 있는 클래스라면 해당 클래스 타입으로의 형 변환이 가능한 것이다. 또, 모든 참조변수는 모든 클래스의 조상인 `Object`클래스 타입으로 형변환이 가능하다.

<br>

### 참조변수의 형 변환 : Up-casting과 Down-casting

자, 이제 참조변수의 형 변환을 본격적으로 이해해 보기 위해, 아래 간단한 코드를 작성해 보았다.<br>

```java
class Car {
  String color;
  int door;
  void drive() {
    System.out.println("start drive");
  }
  void stop() {
    System.out.pritnln("stop");
  }
}

class FireEngine extends Car {
  void waterTank() {
    System.out.println("extinguish the fire");
  }
}

class Ambulance extends Car {
  void siren() {
    System.out.println("operate the siren");
  }
}
```
<br>

위 코드에 정의되어 있는 클래스들은 `Car`, `FireEngine`, `Ambulance` 이렇게 3개로, `FireEngine`, `Ambulance`클래스는 모두 `Car`클래스를 조상 클래스 두는 상속관계를 가지고 있다. 이러한 관계를 그림으로 나타내면 아래와 같이 표현이 가능하다.<br>

```java


// ppt 그림 첨부


```
<br>

이러한 상속관계를 가지는 위 클래스들을 가지고, 참조변수의 형변환을 해보도록 하겠다. 아래 코드를 한번 보도록 하자.<br>

```java
FireEngine f = new FireEngine();

Car c = (Car)f; // 자손 클래스 -> 조상 클래스로 형 변환 - 형 변환 생략 가능 (Car c = f)
FireEngine f2 = (FireEngine)c; // 조상 클래스 -> 자손 클래스로 형 변환 - 형 변환 생략 불가
```
<br>

먼저, 첫 번째줄 코드를 보면, `FireEngine`클래스의 인스턴스를 생성하고, 이를 참조변수 `f`로 가리키게 한 것을 알 수 있다. 해당 상황을 그림으로 나타내면 아래와 같다.<br>
<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/a6ac4615-a1a1-4aaf-a234-72f8c07ac0f1)<br>
<br>

위 그림은 `Car`클래스의 자손 클래스인 `FireEngine`클래스의 인스턴스를 `FireEngine`클래스 타입의 참조변수 `t`가 참조하고 있는, 인스턴스와 이를 참조하고 있는 참조변수의 타입이 일치하는 일반적인 상황이라 할 수 있다.<br>

이렇게, 인스턴스와 참조변수의 타입이 일치하는 경우, 해당 인스턴스가 가지고 있는 멤버를 모두 사용하는 것이 가능하다.<br>
<br>

### 참조변수의 형 변환 : Up-casting 

그렇다면, 이번엔 참조변수의 형 변환을 이용하여, 조상 클래스인 `Car`클래스 타입의 참조변수가 자손 클래스인 `FireEngine`클래스의 인스턴스를 참조하도록 해보겠다. 해당 작업을 담당하는 코드는 두 번째줄 코드로, 해당 코드에 대해 간단히 설명해 보도록 하겠다.<br>

이 코드는 조상 클래스 타입의 참조변수 `c`가 자손 클래스 `FireEngine`의 인스턴스를 참조하도록 만들기 위해, `c`에 참조변수 자손 클래스 타입의 참조변수 `f`가 저장하고 있는 `FireEngine`클래스의 인스턴스의 주소값을 저장(대입) 해주는 코드이다.<br>

해당 대입연산을 진행하는데 있어, 대입 연산자를 기준으로 양 변의 타입이 같지 않은 것을 알 수 있다. `f`가 저장하고 있는 값을 대입 연산자를 통해 저장하게 될 참조변수 `c`와 `f`의 타입이 다르기 때문에, 형 변환을 수행하여, 두 변수간의 타입을 맞춰주어야 한다.<br>

```java
Car c = (Car)f; 
/* Car 클래스 타입의 참조변수에 FireEngine 클래스 타입의 참조변수 값을 대입해주기 위해, f를 Car클래스 타입으로 형 변환 해주었다.
자손 클래스 타입 -> 조상 클래스 타입(Up-casting) : 형 변환 생략 가능*/
```
<br>

위 상황은 자손 클래스 타입의 참조변수의 값(참조하고 있는 인스턴스의 주소값)을 조상 클래스 타입의 참조변수에 대입해주기 위해, 자손 클래스 타입의 참조변수를 조상 클래스 타입으로 형변환 해준 상황이다.<br>

이렇게 자손 클래스 타입에서 조상 클래스 타입으로 형변환 되는 업 캐스팅(Up-casting)의 경우에는, `Car c = f;`와 같이, 형 변환을 생략해주는 것이 가능하다. 해당 상황을 그림으로 나타내면 아래와 같다.<br>
<br>

![스크린샷(8)](https://github.com/Yoonsik-2002/java-study/assets/83572199/1ce730b1-91a7-43cf-a14f-5e627fd1e107)<br>
<br>

위 그림에서, `FireEngine`클래스의 인스턴스를 참조하고 있는 조상 클래스 타입의 참조변수 `c`를 통해 `FireEngine`클래스의 인스턴스를 다루는 경우, 해당 인스턴스의 5개의 모든 멤버를 사용하는 것이 불가능해진다. 오직 `Car`클래스의 멤버에 해당하는 4개의 멤버만 사용이 가능하다.<br>

어떠한 타입의 참조변수를 사용하는냐에 따라서, 같은 인스턴스를 참조하고 있는 상황이라도, 해당 인스턴스에서 사용할 수 있는 멤버의 개수가 달라지게 되는 것이다.<br>
<br>

### 참조변수의 형 변환 : Down-casting
현 상태는, 참조변수의 형 변환을 통해 조상 클래스 `Car`타입의 참조변수가 자손 클래스 `FireEngine`의 인스턴스를 참조하게 해 놓은 상태이다.<br>

이번엔, 조상 클래스 타입의 참조변수가 자손 클래스의 인스턴스를 참조하고 있는 현 상태에서, 형 변환을 통해 다시 자손 클래스 타입의 참조변수가 `FireEngine`클래스의 인스턴스를 참조하도록 만들어 보도록 하겠다.<br>
<br>

해당 작업을 수행하는 코드는 위 코드의 세 번째 줄 코드로, 해당 코드에 대해 간단히 설명해 보도록 하겠다.<br>

이 코드는 조상 클래스 `Car`타입의 참조변수 `c`가 자손 클래스 `FireEngine`의 인스턴스를 참조하고 있는 상황에서, 다시 자손 클래스 타입의 참조변수, `f2`가 해당 인스턴스를 참조하도록 형 변환 해주는 코드이다.<br>
<br>

이러한 인스턴스를 가리키는 참조변수의 형 변환은 변환시키고 싶은 타입의 참조변수에 현재 참조변수가 저장하고 있는 값을 대입해줌으로써 이루어지는데, 이때, 대입 연산자를 기준으로, 두 변의 타입이 다르기 때문에, 이를 같은 타입으로 맞춰주는 작업이 필요하다.<br>

```java
FireEngine f2 = (FireEngine)c;
/* FireEngine 클래스 타입의 참조변수에 Car 클래스 타입의 참조변수 값을 대입해주기 위해, c를 FireEngine클래스 타입으로 형 변환 해주었다. 
조상 클래스 타입 -> 자손 클래스 타입(Down-casting) : 형 변환 생략 불가*/
```
<br>

위 상황은 조상 클래스 타입의 참조변수 `c`의 값을 자손 클래스 타입의 참조변수 `f2`에 대입해주기 위해, 조상 클래스 타입의 참조변수를 자손 클래스 타입으로 형 변환 해준 상황이다.<br>

이렇게, 조상 클래스 타입에서 자손 클래스 타입으로 형 변환되는 다운 캐스팅(Down-casting)의 경우에는 형 변환을 생략해주는 것이 불가능하다. 해당 상황을 그림으로 나타내면, 아래와 같다<br>
<br>

![스크린샷(3)](https://github.com/Yoonsik-2002/java-study/assets/83572199/f03bebb2-4261-493d-94c4-f955f76bec09)<br>
<br>

위 그림에서, 조상 클래스 `Car`타입의 참조변수 `c`로 `FireEngine`클래스의 인스턴스를 참조하는 경우에는, `FireEngine`인스턴스가 가지고 있는 5개의 모든 멤버를 사용하는 것이 불가능 하였다.<br>

`FireEngine`클래스 타입의 인스턴스는 가지고 있지만, 조상 클래스인 `Car`는 가지고 있지 않는 `waterTank()`멤버의 경우, 참조변수 `c`를 가지고는 해당 멤버를 사용하는 것이 불가능하기 때문이다.<br>

하지만, 지금은 다시 참조변수의 형 변환을 통해 `FireEngine`클래스 타입의 참조변수 `f2`가 해당 인스턴스를 참조하게 만들어준 상태이다. 이는 참조변수와 인스턴스의 타입이 일치하는 상황이므로, `f2`를 통해서는 `FireEngine`클래스의 인스턴스가 가지는 모든 멤버를 사용 가능하다.<br>
<br>

이렇게, 조상 클래스 타입과 자손 클래스 타입으로 참조변수를 형 변환 해 보았다.<br>

참조변수의 타입이 무엇인가에 따라, 해당 참조변수가 참조하는 인스턴스에서 사용할 수 있는 멤버의 개수가 달라지게 된다. 우리는 이러한 참조변수의 형 변환을 통해 현재 참조하고 있는 인스턴스에서 사용할 수 있는 멤버의 개수를 변경해 주는 것이 가능하다.<br>
<br>

### 형 변환을 생략할 수 있는 경우와 없는 경우에 대한 이유
위 예시들을 통해, 자손 클래스 타입에서 조상 클래스 타입으로, 조상 클래스 타입에서 자손 클래스 타입으로의 참조변수의 형 변환을 해 보았다. 이러한 형 변환의 과정에 있어, 차이점 하나가 존재하였었는데, 바로 형 변환을 생략할 수 있느냐, 없느냐에 대한 차이였다.<br>

먼저, 자손 클래스 타입에서 조상 클래스 타입으로 참조변수의 형 변환이 이루어지는 경우에는 형 변환 생략이 가능하였지만, 반대 경우인 자손 클래스 타입에서 조상 클래스 타입으로 형 변환이 이루어지는 경우에는 형 변환 생략이 불가능하였다.<br>

이러한 차이점이 생기는 이유에 대해 정리해 보도록 하겠다.<br>
<br>

### Up-casting 시, 형 변환을 생략할 수 있는 이유
먼저, 참조변수의 형 변환 시, 형 변환을 생략할 수 있는 Up-casting의 경우를 한번 보도록 하자. 위에서 들었던 예시코드를 토대로 설명해 보도록 하겠다.<br>

`Car`클래스 타입의 참조변수 `c`가 있다고 해 보자. 이때, 참조변수 `c`가 참조할 수 있는 인스턴스는 무엇이 있을까? 그렇다. `Car`클래스의 인스턴스나, `Car`클래스의 자손 클래스인 `FireEngine`클래스의 인스턴스가 있을 것이다.<br>

클래스의 상속은 조상 클래스가 자손 클래스로 확장되는 개념으로, 조상 클래스 타입의 참조변수가 사용할 수 있는 멤버의 개수는 조상 클래스가 확장된 개념인 자손 클래스의 인스턴스가 가지는 멤버보다 항상 적을 수 밖에 없다.<br>

이렇게, 인스턴스의 멤버 개수보다 참조변수가 사용할 수 있는 멤버의 개수가 적은 것은 문제가 되지 않는다. 그저 인스턴스에서 사용할 수 있는 멤버의 개수가 줄어들 뿐이다.<br>
<br>

그러면 이번엔 `Car`타입의 참조변수 `c`를 `Car`클래스의 조상 클래스인 `Object`클래스 타입으로 형변환 해 보도록 하겠다. 어떻게 될까? 이 경우도 마찬가지로, 결국 조상 클래스 타입의 참조변수로 자손 클래스의 인스턴스를 참조하게 되는 상황으로, 문제가 되지 않는다.<br>

즉, 이렇게 자손 클래스 타입의 참조변수를 조상 클래스 타입의 참조변수로 형 변환 해주는 Up-casting의 경우, 참조하고 있는 인스턴스의 멤버 개수 보다 사용할 수 있는 멤버의 개수가 적어질 것이 분명하므로 문제가 되지 않는다는 것을 알 수 있다.<br>

Up-casting의 경우, 참조하는 인스턴스에서 사용할 수 있는 멤버의 수가 적어지는 것일 뿐이지, 문제가 되지 않으므로, 형 변환을 생략해 주는 것이 가능하다.<br>
<br>

### Down-casting 시, 형 변환을 생략할 수 없는 이유
이번엔 참조변수의 형 변환 시, 형 변환을 생략할 수 없는 Down-casting의 경우이다. 참조변수가 조상 클래스 타입에서 자손 클래스 타입으로 형 변환 되는 Down-casting의 경우, 참조변수에서 사용할 수 있는 멤버의 개수가 참조하고 있는 인스턴스의 멤버의 개수보다 많아질 가능성이 생긴다.<br>

상속이란 조상 클래스에서 자손 클래스로 확장되는 개념이기 때문이다. `Car`클래스 타입의 참조변수 `c`의 경우, `Car`인스턴스와 자손 클래스인 `FireEngine`인스턴스를 참조할 수 있었다.<br>

만약 `c`가 `FireEngine`인스턴스를 참조하고 있는 경우, `c`를 자손 클래스인 `FireEngine`타입으로 형 변환 되어도, `FireEngine`인스턴스에서 사용할 수 있는 멤버의 개수가 늘어날 뿐이지 문제가 되지는 않는다.<br>

하지만, `c`가 `Car`인스턴스를 참조하고 있는 경우, `c`를 자손 클래스인 `FireEngine`타입으로 형 변환하게되면, 참조변수가 사용할 수 있는 멤버의 수가 참조하고 있는 인스턴스가 가지는 멤버의 개수보다 많아지게 되는 문제가 생기게 된다.<br>
<br>

참조변수가 사용할 수 있는 멤버의 개수가 인스턴스의 멤버의 개수보다 많아질 경우, 인스턴스에선 존재하지 않는 멤버를 사용하게 될 가능성이 생기므로, 이는 문제가 된다.<br>

문제가 발생할 수 있는 가능성이 존재하기 때문에, 조상 클래스 타입에서 자손 클래스 타입으로 형변환 하는 Down-casting의 경우, 형 변환을 생략할 수 없다.<br>

이러한 Down-casting시, 형 변환을 하기 전에 `instanceof`연산자를 통해 참조변수가 참조하고 있는 실제 인스턴스의 타입을 확인해 보는것이 안전하다.<br>
<br>

### 참조변수의 형 변환에 대한 최종 정리
**참조 변수의 형 변환은 참조변수의 타입을 변환하는 것이지, 인스턴스를 변환하는 것은 아니기에, 인스턴스에는 아무런 영향을 미치지 않는다. 단지, 참조하고 있는 인스턴스에서 사용할 수 있는 멤버의 개수를 조절하는 것 뿐이다.<br>**

맨 처음 다형성의 개념에 대해 설명할 때 사용하였던 코드인 `Tv t = new CaptionTv();`도 결국엔 `Tv t = (Tv)new CaptionTv();`가 생략된 형태이다. 또, 해당 코드를 풀어서 나타내면 아래와 같이 표현하는 것도 가능하다.<br>

```java
CaptionTv c = new CaptionTv();
Tv t = (Tv)c;
```
<br>

또, 서로 상속관계에 있는 클래스(타입) 간에는 양방향으로 자유롭게 형변환이 이루어질 수 있으나, 참조변수가 가리키는 인스턴스의 자손 클래스 타입으로의 형변환은 허용되지 않는다. 때문에, 참조변수의 형 변환에 있어, 참조변수가 가리키는 인스턴스의 타입이 무엇인지 확인하는것이 중요하다!<br>

```java
FireEngine f = null;
Car c = new Car();
Car c2 = null;

f = (FireEngine)c; // 참조변수가 가리키는 인스턴스의 자손 클래스 타입으로의 형변환. 컴파일은 되지만, 실행 시 에러가 발생한다.
f.drive();

c2 = f;
c2.drive();
```
<br>

위 경우, 참조변수가 가리키는 인스턴스의 자손 클래스 타입으로 형 변환이 이루어져, 인스턴스가 가지고 있는 멤버의 개수보다 참조변수가 사용할 수 있는 멤버의 개수가 더 많아지게 되어, 실행 시 에러가 발행하게 된다.<br>

컴파일 시에는 참조변수 간의 타입만 체크하기 때문에, 실행 시 생성될 인스턴스의 타입까지는 컴파일러가 알지 못한다. 이러한 이유로 컴파일 시에는 문제가 없었지만, 실행 시에는 에러가 발생하여 실행이 비정상적으로 종료되게 된다.<br> 

위 코드를 컴파일 시에도, 실행 시에도 에러가 발생하지 않도록 만들어 주기 위해서는, `c`가 참조하게될 인스턴스의 타입을 `FireEngine`타입으로 변경해 주면 `FireEngine`타입으로 다운 캐스팅을 하든 다시 `Car`타입으로 업 캐스팅을 하든 문제가 발생하지 않을 것이다.<br>

이렇게 수정하고 난 다음에는 참조변수에 따라 사용할 수 있는 인스턴스의 멤버가 달라진다는 점만 주의해주면 된다.<br>

```java
FireEngine f = null;
Car c = new FineEngine();
Car c2 = null;

f = (FireEngine)c;  // Up-casting
f.waterTank();

c2 = f;  // Down-casting
c2.waterTank(); // 컴파일 에러 발생! Car클래스 타입의 참조변수로는 자손클래스 FireEngine인스턴스의 멤버인 WaterTank()를 호출할 수 없음.
```
<br>

참조변수의 형 변환시, 참조하고 있는 인스턴스의 타입에 주의하자! 그리고, 참조변수의 형 변환은 인스턴스에는 영향을 미치지 않으며, 인스턴스에서 사용 가능한 멤버의 개수를 조절해주는 것일 뿐이라는 것을 명심하자!<br>
<br>

### `instanceof`연산자
참조변수의 형 변환을 하는데 있어, 참조변수가 현재 참조하고 있는 인스턴스의 자손 클래스 타입으로는 형 변환이 허용되지 않는다. 만약 허용될 경우, 참조변수가 사용할 수 있는 멤버의 수가 현재 가리키고 있는 인스턴스의 멤버의 개수보다 많아져,<br>

존재하지 않는 멤버를 사용하게될 가능성이 생기기 때문이다. 참조하고 있는 인스턴스에는 존재하지 않는 멤버를 참조변수가 사용하려 하는 것은 분명히 문제가 되는 상황이다.<br>

이러한 이유로, 해당 상황이 발생하는 것을 방지하기 위해, 참조변수의 형 변환 시, 현재 참조변수가 참조하고 있는 인스턴스의 실제 타입을 미리 알아보는 것이 중요한데, 해당 작업을 수행하는데 사용되는 연산자가 바로, 이 `instanceof`연산자 이다.<br>

참조변수의 형 변환 전에는 반드시, `instanceof`연산자로 형 변환이 가능한지 먼저 확인해 보아야 한다!<br>
<br>

### `instanceof`연산자의 형식
`instanceof`연산자는 주로, 조건문에 사용되며, `instanceof`연산자를 중심으로 왼쪽에는 참조변수, 오른쪽에는 타입(클래스 명)이 피연산자로 위치한다. 해당 연산의 결과로는, boolean값인 `true`나 `false` 중 하나의 값의 반환된다.<br>

이러한 `instanceof`연산자를 이용한 연산 결과로 `true`를 반환 받았다는 것은 해당 참조변수를 검사한 타입(피연산자에 위치한 클래스)으로 형 변환이 가능하다는 것을 의미한다.<br>

이때, 만약, 연산 대상이 되는 참조변수가 아무것도 가리키지 않는, null값을 저장하고 있는 경우라면 `instanceof`연산의 수행 결과로 `false`를 반환받게 된다.<br>
<br>

아래는 `instanceof`연산자의 사용형식을 그림으로 나타내 본 것이다.<br>

![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/2fbf9d47-fb3e-4447-a682-74cbb85b758c)<br>
<br>

### `instanceof`연산자를 사용해야 하는 이유 - 참조변수의 형 변환이 가능한지 미리 검사해주기 위해
자, 그럼 다음 코드를 봐 보자. 이전에 사용하였던 `Car`클래스와 `FireEngine`클래스, `Ambulance`클래스를 활용한 `instanceof`연산자를 이용한 참조변수의 형 변환 예시코드이다. `FireEngine`클래스와 `Ambulance`클래스는 모두 `Car`클래스의 자손클래스들이다.<br>
<br>

![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/b1513a3b-1f35-4710-827a-e37b526a4abf)<br>
<br>

```java
void doWork(Car c) {
  if(c instanceof FireEngine) {  // FireEngine클래스 타입으로 형 변환이 가능한가?
    FireEngine f = (FireEngine)c;
    f.waterTank();
  } else if (c instanceof Ambulance) {  // Ambulance클래스 타입으로 형 변환이 가능한가?
      Ambulance a = (Ambulance)c;
      a.siren();
      // ...
  }
  // ...
}
```
<br>

`Car`타입의 참조변수 `c`를 매개변수로 하는 위 `doWork` 메서드가 호출될 때, 매개변수로는 어떠한 값이 전달될까? 참조변수 `c`를 통해서는 어떠한 값들이 `doWork`메서드의 매개변수로 전달될 수 있을지 그림으로 나타내 보았다.<br>
<br>

![스크린샷(4)](https://github.com/Yoonsik-2002/java-study/assets/83572199/99e6ac52-7730-4897-a4fc-8d3023106216)<br>
<br>

위 그림과 같이 먼저, `Car`클래스의 인스턴스가 전달될 수 있겠고, 조상 클래스 타입의 참조변수가 자손 클래스의 인스턴스를 참조하는 것도 가능하므로, `Car`클래스의 자손 클래스인 `FireEngine`클래스의 인스턴스나 `Ambulance`클래스의 인스턴스가 매개변수로 전달될 수 있을 것이다.<br>

즉, 다형성에 의해, 참조변수 `c`를 통하여 `Car` 클래스의 인스턴스와 `Car`클래스의 모든 자손 클래스의 인스턴스가 `doWork`메서드의 매개변수로 들어오는 것이 가능한 것이다.<br>

또, 추가적으로 `c`가 아무런 인스턴스를 가리키지 않고 `null`값을 저장하고 있는 경우엔 `null`값이 매개변수로 전달될 수도 있겠다.<br>

클래스 타입이 일치하는 인스턴스와 자손 클래스 타입의 모든 인스턴스들을 참조하는 것이 가능한 참조변수이기에, 메서드 입장에서는 참조변수를 통해 매개변수로 넘겨받은 인스턴스가 정확히 어떤 인스턴스인지(`Car`인스턴스인지, `Car`의 자손 클래스 인스턴스인지) 알 수가 없다.<br>

이렇게 현재 참조변수가 어떠한 인스턴스를 참조하고 있는지 알 수 없는 상태에서 참조변수의 형 변환을 하는 것은 에러를 발생시킬 수 있는 매우 위험한 일이다. 때문에, `instanceof`연산자를 통해 변환하고자 하는 클래스 타입으로 형 변환이 가능한지 미리 검사를 먼저 해주어야 한다.<br>
<br>

### `instanceof`연산자의 사용
자, 이제 이 `instancof`연산자가 어떻게 작동되는지 자세히 정리해 보도록 하겠다.<br>

```java
  if(c instanceof FireEngine) {  // FireEngine클래스 타입으로 형 변환이 가능한가?
    FireEngine f = (FireEngine)c;
    f.waterTank();
```
<br>

먼저, 위 경우를 한번 보자. 참조변수 `c`를 `FireEngine`클래스 타입으로 형 변환이 가능한지 검사한 뒤, 해당 타입으로 형 변환해주는 코드이다. 이때, `instanceof`연산자는 무엇을 기준으로 참조변수의 형 변환이 가능한지 불가능한지 판별해 내는 것일까?<br>

바로, `instatnceof`연산자의 오른쪽에 위치하는 참조변수가 가리키는 인스턴스의 타입을 기준으로 판별해낸다. 아래와 같은 방식으로 말이다.<br>
> **`c`가 참조하고 있는 인스턴스가 `FireEngine`클래스의 인스턴스이냐?** <br>
> **`c`가 참조하고 있는 인스턴스가 `FireEngine`클래스의 자손 클래스의 인스턴스이냐?**

<br>

`Car`타입의 참조변수 `c`를 `FireEngine`클래스 타입으로 형 변환 하고자 하는 경우, 참조변수 `c`가 참조하고 있는 인스턴스가 `FireEngine`클래스의 인스턴스이거나, `FireEngine`의 자손 클래스의 인스턴스여야 형 변환이 가능해진다.<br>

즉, `instanceof`연산자를 통해 이러한 형 변환이 가능한 조건에 해당하는지 따져 보는 것이다.<br>
<br>

위 예시코드의 경우는 `Car`타입의 참조변수 `c`가 자손 클래스인 `FireEngine`클래스의 인스턴스를 참조하고 있는 상태에선, `FireEngine`인스턴스의 멤버, `waterTank()`를 사용할 수 없으므로, 해당 인스턴스를 참조하는 `c`를 `FireEngine`클래스 타입으로 형 변환하여 `waterTanc()`를 사용할 수 있게 한 내용이다.<br>

다형성에 의해, 조상 클래스 타입의 참조변수로 자손 클래스의 인스턴스를 참조하는 것이 가능하기 때문에, 참조변수와 해당 참조변수가 가리키는 인스턴스의 타입이 항상 일치하지는 않는다는 것을 배웠다.<br>

이렇게 조상 클래스 타입의 참조변수가 자손 클래스의 인스턴스를 참조하는 경우, 해당 참조변수로는 자손 클래스의 인스턴스가 가지는 모든 멤버를 사용할 수 없기 때문에, 실제 참조하고 있는 인스턴스와 같은 타입의 클래스로 형 변환 해주어야 인스턴스의 모든 멤버들을 사용하는 것이 가능하다.<br>
<br>

### `instanceof`연산자에 대한 최종 정리
인스턴스를 참조하는 참조변수는 자신의 타입과 일치하는 클래스의 인스턴스는 물론이고, 자손 클래스의 인스턴스를 참조하는 것 또한 가능하다. 때문에, 참조변수가 어떠한 인스턴스를 참조하고 있는지 모르는 상태에서 참조변수의 형변환을 바로 하는 것이 아니라,<br>

`instanceof`연산자를 통해 해당 클래스 타입으로 참조변수를 형 변환 하는것이 가능한지 먼저 검사해 본 뒤에 참조변수의 형변환을 수행하는 것이 바람직하다.<br>

이러한 `instanceof`연산자는 주로 조건문에서 사용되며, 연산자 기준, 오른쪽에 위치하는 참조변수가 가리키고 있는 인스턴스의 타입을 기준으로, 왼쪽에 피연산자로 위치하는 클래스 타입으로 참조변수의 형 변환이 가능한지 판별하여 `true`나 `false`값을 반환해준다.<br>

**오른쪽 참조변수가 가리키는 인스턴스의 타입이 왼쪽 피연산자로 위치하는 클래스와 일치하는 경우, 오른쪽 참조변수가 가리키는 인스턴스의 타입이 왼쪽 피연산자로 위치하는 클래스의 자손 클래스인 경우** 참조변수의 형 변환이 가능하다.<br>

`intstnaceof`연산자는 이러한 참조변수의 형 변환이 가능한 조건에 해당하는지를 따져, `true`나 `false`를 반환해 주는 것이다.<br>

그럼, 마지막으로 아래 코드를 한번 봐 보자.<br>

```java
package chapter_07;

class Ex07_12_InstanceofTest {
    public static void main(String[] args) {
        FireEngine fe = new FireEngine();
        
        if(fe instanceof FireEngine) { // 참조변수 fe가 가리키는 인스턴스가 FireEngine클래스의 인스턴스인가?
            System.out.println("This is a FireEngine insatance.");
        }
        
        if(fe instanceof Car) { // 참조변수 fe가 가리키는 인스턴스가 Car클래스의 인스턴스인가?(fe가 가리키는 인스턴스가 Car 클래스의 자손 클래스의 인스턴스 인가?)
            System.out.pritnln("This is a Car instance.");
        }
        
        if(fe instanceof Object) { // 참조변수 fe가 가리키는 인스턴스가 Object클래스의 인스턴스인가?(fe가 가리키는 인스턴스가 Object 클래스의 자손 클래스의 인스턴스 인가?)
            System.out.println("This is an Object instance");
        }
        
        fe.getClass().getName(); // 참조변수 fe가 가리키고 있는 인스턴스의 클래스 이름을 문자열로 반환.
    }
}

class Car {}
class FireEngine extends Car {}
```
<br>

##### [실행결과]
![스크린샷(5)](https://github.com/Yoonsik-2002/java-study/assets/83572199/0303d9fa-8c90-4036-8462-8a666004d06b)<br>
<br>

해당 코드의 실행결과를 보면, 생성된 인스턴스는 `FireEngine`타입인데도 `Car`클래스와 `Object`클래스를 대상으로 한 `instanceof`연산에서 모두 `true`가 반환된 것을 알 수 있다.<br>

그 이유는, `FireEngine`클래스가 `Car`클래스와 `Object`클래스의 자손클래스 이므로, 해당 조상 클래스의 멤버들을 상속받았기 때문에, **`FireEngine`클래스의 인스턴스는 `Car`클래스의 인스턴스와 `Object`클래스의 인스턴스를 포함하고 있는 셈이라 할 수 있기 때문이다.<br>**

java의 상속 개념에 기반하여, 자손 클래스의 인스턴스는 조상 클래스의 인스턴스를 포함 및 확장한 개념이라 할 수 있다. 그렇기 때문에 조상 클래스 타입의 참조변수로 자손 클래스의 인스턴스를 참조하는 것이 가능한 것이다.<br>

하지만 이렇게 조상 클래스 타입의 참조변수로 자손 클래스의 인스턴스를 사용하는 경우, 조상 클래스가 포함 및 확장된 자손 클래스의 인스턴스의 멤버들 중에서, 딱 조상 클래스에 정의되어 있는 멤버들에만 접근하는 것이 가능하다는 것을 명심하자.<br>
<br>

![스크린샷(7)](https://github.com/Yoonsik-2002/java-study/assets/83572199/7e97a53c-9b09-4260-92e1-6c09a491c30d)<br>
<br>

아무튼, 이러한 이유로, 참조변수가 가리키는 인스턴스의 실제 타입과 같은 타입의 `instanceof`연산 외에, 조상 타입의 `instanceof`연산에도 `true`를 결과로 얻을 수 있으며, 이렇게 **`intanceof`연산의 결과가 `ture`인 것은 모두 해당 클래스 타입으로 참조변수로 형 변환이 가능하다는 것을 뜻한다.<br>**
<br>

### 참조변수와 인스턴스의 연결

#### 조상 클래스와 자손 클래스에 중복 정의된 경우, 참조변수의 타입에 영향을 받는 멤버변수
조상 클래스 타입의 참조변수와 자손 클래스 타입의 참조변수의 차이점이, 같은 인스턴스를 참조하고 있더라도, 해당 인스턴스에서 사용할 수 있는 멤버의 개수가 달라진다는 점이라 앞서 정리하였었다.<br>

여기서 한 가지 더 알아두어야 하는 내용이 있다. 만약, 조상 클래스에 정의되어 있는 멤버변수와 이름이 같은 인스턴스 변수가 자손 클래스에 중복되어 정의되어 있는 상황이라 해보자.<br>

이러한 경우, 해당 자손 클래스의 인스턴스를 조상 클래스 타입의 참조변수로 참조하느냐? 아니면, 자손 클래스 타입의 참조변수로 참조하느냐? 에 따라 얻을 수 있는 결과가 달라진다.<br>

조상 클래스 타입의 참조변수를 사용하였을 때에는 조상 클래스에 선언된 멤버변수가 사용되고, 자손 클래스 타입의 참조변수를 사용하였을 때에는 자손 클래스에 선언된 멤버변수가 사용된다.<br>
<br>

#### 조상 클래스와 자손 클래스에 중복 정의된 경우, 참조변수의 타입에 영향을 받지 않는 메서드
하지만, 메서드의 경우는 다르다. 메서드의 경우, 조상 클래스로부터 상속받은 메서드를 자손 클래스 자신에게 맞게 재정의하는 메서드 오버라이딩(method overriding)이라는 개념이 존재하는데, 이렇게 조상 클래스에서 정의된 메서드를 자손 클래스에서 오버라이딩 한 경우엔,<br>

해당 자손 클래스의 인스턴스를 참조하는 참조변수의 타입(클래스)에 관계없이, 항상 실제 자손 클래스의 인스턴스의 오버라이딩된 메서드가 호줄된다.<br>
<br>

즉, 조상 클래스와 자손 클래스에 같은 이름으로 중복 정의된 경우, 멤버 변수의 경우, 어떤 타입의 참조변수로 참조하느냐에 따라 얻게되는 값이 달라지지만, 메서드는 어느 타입의 참조변수로 참조되느냐에 관계없이, 항상 실제 자손 클래스의 오버라이딩된 메서드가 호출된다.<br>

아래 코드를 보면 이해가 더 쉽게 될 것이다.<br>

```java
class BindingTest {
  public static void main(String[] args) {
    Parnet p = new Child();
    System.out.println("p.x = " + p.x);
    p.method();

    Child c = new Child();
    System.out.println("c.x = " + c.x);
    c.method();
  }
}

class Parent {
  int x = 100;

  void method() {
    System.out.println("Parent method");
  }
}

class Child {
  int x = 200;

  void method() {
    System.out.println("Child method");
  }
}
```
<br>

##### [실행결과]
![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/eeb6ac80-0abe-499d-a390-ea81751a3bde)<br>
<br>

`Parent`클래스 타입의 참조변수 `p`와 `Child`클래스 타입의 참조변수 `c`가 `Parent`클래스의 자손 클래스인 `Child`클래스의 인스턴스를 참조하고 있는 상황이다.<br>

이때, `Child`인스턴스에는 `Parent`클래스와 `Child`클래스에서 중복 정의된 멤버변수 `x`와 메서드 `method()`가 존재한다. 이러한 상황에서 해당 코드의 실행결과를 보면 알 수 있듯이,<br>
<br>

중복 정의된 멤버변수 `x`의 경우, `Parent`와 `Child` 중 어떤 클래스 타입의 참조변수로 사용하느냐에 따라서 그 값이 달라졌었다.<br>

하지만, 중복 정의된 메서드 `method()`의 경우, 어떤 타입의 참조변수를 통해 사용하느냐에 관계없이, 실제 참조하고 있는 인스턴스의 타입인 `Child`클래스에 정의된 메서드가 호출 되었었다.<br>
<br>

아래 그림을 보면 더욱 이해가 수월할 것이다.<br>
<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/8f5db32a-f25f-4d69-9439-27b56c66593c)<br>
<br>

이렇게 참조변수의 타입에 따라 결과가 달라지는 경우는 조상 클래스에 정의된 멤버변수와 같은 이름의 멤버변수를 자손 클래스에 중복 정의한 경우 뿐이다.<br>
<br>

### 다형성의 장점 I - 매개변수의 다형성
매개변수의 다형성에 들어가기 앞서, 이전에 공부하였던 다형성에 대해 아래 자료를 통해 간략히 정리해 보았다.<br> 
<br>

![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/2d91cb31-13b9-4d9f-9d99-36915c99407d)<br>
<br>

이번에 정리해 볼 내용은, 매개변수의 다형성으로, 이 '다형적 매개변수'는 다형성의 장점 중 하나라 할 수 있다.<br>
<br>

### 다형적 매개변수란 무엇인가?
참조변수의 다형적인 특징은 메서드의 매개변수에도 적용된다. 매개변수가 참조형일 경우, 메서드의 호출 시, 매개변수 자신과 **같은 타입의 인스턴스나**, **자손 타입의 인스턴스**를 넘겨줄 수 있다.<br>

이러한 다형성의 장점 중 하나인, 다형적 매개변수를 아래 코드와 같이 이해하며 정리해 보도록 하겠다.<br>

```java
class Product {
  int price;  // 제품 가격
  int bonusPoint;  // 해당 제품을 구매하였을 시, 제공 받는 보너스 포인트
}

class Tv extends Product {}
class Computer extends Product {}
class Audio extends Product {}

class Buyer {
  int money = 1000;  // 구매자의 보유금액(물건 구매 시, 차감)
  int bonusPoint = 0;  // 구매자의 보유 보너스 포인트(물건 구매 시, 제품에 해당하는 보너스 포인트 만큼 증가)

  /* 물건을 구매하는데 필요한 buy 메서드 */

}
```
<br>

위 코드를 보면 알 수 있듯이, `Product`클래스는 `Tv`, `Computer`, `Audio`클래스의 조상이며, `Buyer`클래스는 제품을 구입하는 사람을 클래스로 표현한 것이다.<br>

자, 그럼 이제, `Buyer`클래스에서 물건을 구매하는 기능을 담당하는 `buy`메서드를 한번 추가해 보도록 하겠다. 해당 메서드는 메서드에 전달된 제품 인스턴스의 가격과 보너스 포인트 만큼 `Buyer`의 인스터스가 가지는 `money`와 `bonusPoint`값을 변경해주는 기능을 가진다.<br>
<br>

#### 다형적 매개변수의 이해 1) `Buyer`클래스의 `buy`메서드 구현 - 메서드 오버로딩을 활용하기 
먼저, `buy`메서드를 기존에 공부하였던 개념인 메서드의 오버로딩을 통해 구현해 보도록 하겠다.<br>

같은 이름의 메서드라도, 해당 메서드의 매개변수의 개수나, 타입이 다르다면, 이러한 메서드 여러개를 하나의 클래스에서 정의하는 것이 가능하다. 이러한 메서드 오버로딩을 활용하면, 다음과 같은 메서드들을 `Buyer`클래스에 정의해주면 될 것 이다.<br>

###### Tv제품을 구매하는 경우 호출되는 `buy`메서드
```java
void buy(Tv t) {
  money = money - t.price;
  bonusPoint = bonusPoint + t.bonusPoint;
}
```
<br>

###### Comoputer제품을 구매하는 경우 호출되는 `buy`메서드
```java
void buy(Computer c) {
  money = money - c.price;
  bonusPoint = bonusPoint + c.bonusPoint;
}
```
<br>

###### Audio제품을 구매하는 경우 호출되는 `buy`메서드
```java
void buy(Audio a) {
  money = money - a.price;
  bonusPoint = bonusPoint + a.bonusPoint;
}
```
<br>

이렇게 메서드 오버로딩을 활용하여, `buy`메서드를 정의하는 경우, 해당 메서드로는 매개변수의 타입에 해당하는 인스턴스(제품)의 구매만 가능하다. 그렇기 때문에, 다른 제품이 늘어날 때마다, `Buyer`클래스는 늘어난 제품에 해당하는 새로운 `buy`메서드를 매번 추가해 주어야 할 것이다.<br>

극단적인 예를 들면, 만약 100가지 종류의 새 제품이 추가된 경우, 그 제품들에 해당하는 `buy`메서드를 `Buyer`클래스에 하나 하나씩 추가해 주어야 한다는 것이다. 이는 매우 비효율적인 방식이다.<br>

이러한 문제를 해결하기 위해선 어떻게 해야할까? 그렇다. 바로, 참조변수의 다형성을 활용하면된다. 여기서 다형성의 장점이 나타난다.<br>
<br>

#### 다형적 매개변수의 이해 2) `Buyer`클래스의 `buy`메서드 구현 - 참조변수의 다형성을 활용하기
참조변수의 다형성 개념은 메서드의 매개변수에도 적용된다. 즉, 메서드의 매개변수가 참조형인 참조형 매개변수인 경우, 해당 메서드 호출 시, 매개변수 자신과 같은 타입의 인스턴스 혹은 자손 타입의 인스턴스를 넘겨주는 것이 가능하다.<br>

이러한 매개변수의 다형성을 이용하면, 이전 예시의 문제를 아래와 같은 하나의 메서드로 간단히 처리할 수 있다.<br>
<br>

```java
void buy(Product p) {
  money = money - p.price;
  bonusPoint = bonusPoint + p.bonusPoint;
}
```
<br>

매개변수가 `Product`클래스 타입의 참조변수라는 것은, 매개변수(참조형 타입)의 다형성에 의해, `Product`클래스의 자손 클래스 타입의 참조변수라면 어느 것이나 매개변수로 받아들일 수 있다는 뜻이다.<br>

`Tv`클래스와 `Computer`클래스는 `Product`클래스의 자손 클래스 이므로, `Product`타입의 참조변수를 매개변수로 가지는 `buy`메서드에 `Tv`클래스의 인스턴스와 `Computer`클래스의 인스턴스를 제공하는 것이 가능하다.<br>

```java
Buyer b = new Buyer();
Tv t = new Tv();
Computer c = new Computer();

b.buy(t);
b.buy(c);

/* Buyer b = new Buyer();

b.buy(new Tv());
b.buy(new Computer());

위와 같이 줄일수도 있음*/
```
<br>

### 다형성의 장점 II - 하나의 배열에 여러 종류의 객체를 저장 가능
이전에 다루었던 다형성의 장점은 조상 클래스 타입의 매개변수에 여러 타입의 자손 클래스 인스턴스들을 넘겨줄 수 있는 다형적 매개변수로, 메서드의 매개변수를 조상 클래스 타입의 참조변수로 두어, 하나의 메서드로 여러타입의 자손 클래스의 객체를 받을 수 있게 하였었다.<br>
<br>

이번에 정리해 볼 다형성의 두 번째 장점은 바로, **하나의 배열에 여러 종류의 객체를 저장하는 것이 가능하다** 라는 점이다.<br>  

기존에 우리가 알고 있던 배열은 하나의 같은 타입의 데이터를 저장하는 것 만이 가능하였었는데, **다형성을 이용하면, 하나의 배열에 여러 종류의 객체를 저장하는 것이 가능하게 되는 것이다.** <br>
<br>

다형성을 통해, 조상 클래스 타입의 참조변수로 자손 클래스의 인스턴스를 참조하는 것이 가능하므로, `Product`클래스가 `Tv`, `Audio`, `Computer`클래스의 조상 클래스인 경우, 아래와 같이 조상 클래스 타입의 참조변수로 자손 클래스의 인스턴스를 참조하는 것이 가능하였었다.<br>
```java
Product p1 = new Tv();
Product p2 = new Audio();
Product p3 = new Computer();
```
<br>

![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/ed6d1abd-0469-4bba-9ee8-18c2fac6ec68)


![스크린샷(8)](https://github.com/Yoonsik-2002/java-study/assets/83572199/c26f92f7-b3e4-4a26-9e25-13ae819c14f2)<br>
<br>

위의 코드를 `Product`클래스 타입의 참조변수 배열로 나타내면 다음과 같이 나타낼 수 있을 것이다.<br>
```java
Product[] pArr = new Product[3];

pArr[0] = new Tv();
pArr[1] = new Audio();
pARr[2] = new Computer();
```
<br>

![스크린샷(9)](https://github.com/Yoonsik-2002/java-study/assets/83572199/9e9d3a88-42b3-4519-976f-d22bebeaeb9d)<br>
<br>

위 그림들을 보면 알 수 있듯이, 조상 클래스 타입의 참조변수 배열(객체배열)을 이용하니, 다형성에 의해, 따로 따로 생성된 각기 다른 자손 클래스의 인스턴스들을 하나로 묶어 다루는 것이 가능해졌다.<br>

이처럼 조상 클래스 타입의 참조변수 배열을 이용하면, 공통 조상을 가진 자손 클래스 타입의 객체들을 하나의 배열로 묶어서(저장하여) 다루는 것이 가능하다.<br>

객체 배열은 결국, 객체를 참조하는 참조변수들을 하나로 묶은 참조변수 배열로, 해당 참조변수 배열의 타입이 어떠한 클래스들의 조상 클래스 타입이라면, 이 참조변수 배열을 이루는 참조변수들은 각기 다른, 여러개의 자손 클래스들의 인스턴스를 참조하는 것이 가능하다.<br>

이것이 바로, 다형성의 두 번째 장점인 **하나의 배열에 여러 종류의 객체를 저장 가능하다는 점** 이다.<br>
<br>

### 추상 클래스(abstract class) 
클래스를 설계도로 비유하면, 추상 클래스는 미완성 클래스로 비유하는 것이 가능하다. 미완성 설계도란, 말 그대로 완성되지 못한 채로 남겨진 설계도를 의미한다.<br>

이렇게 '클래스가 미완성이다' 라는 말은 어떠한 상태를 일컫는 말일까? 클래스가 미완성이라는 것은 멤버의 개수에 관계된 것이 아닌, **미완성 메서드(추상 메서드)를 포함하고 있다는 의미이다.** <br>
<br>

즉, 추상 메서드를 포함하고 있는 클래스를 가리켜, 추상 클래스라 하는 것이다.<br>

완성되지 않은 설계도를 가지고서는 제품을 만들어낼 수 없듯이, 추상 클래스를 통해서 인스턴스를 생성하는 것은 불가능하다. 완성되지 않은 클래스인 추상 클래스는 상속을 통해서 자손 클래스에 의해서만 완성될 수 있다.<br>
<br>

그렇다면, 이러한 완성되지 못해, 인스턴스를 생성해 낼 수 없는 미완성된 클래스인 추상 클래스를 굳이 사용하는 이유는 무엇일까?<br>
<br>

### 추상 클래스를 사용하는 이유
완성되지 못한 설계도인 추상 클래스는 그 자체로 클래스의 역할은 다 못하지만, 새로운 클래스를 작성하는데 있어서 바탕이되는 조상 클래스로서 중요한 의미를 가진다.<br>

새로운 클래스를 작성할 때, 아무것도 없는 상태에서 시작하는 것 보단, 완전하진 못하더라도, 어느정도 틀을 갖춘 상태에서 시작하는 것이 나을 것이다.<br>
<br>

해당 상황을 이해하기 쉽게 예를 들어 보도록 하겠다. 같은 크기의 TV라도, 가지고 있는 기능의 차이에 따라 여러가지 모델로 나뉘는 경우가 있다. 단순 기능에 따른 차이이기 때문에, 해당 TV들의 설계도는 아마 90%정도는 동일할 것이다.<br>

이러한 상황에서, 각 TV들의 설계도를 각각 따로 처음부터 그리는 것 보다는, 이들의 공통 부분만을 그린 미완성 설계도를 만들어 놓고, 이 미완성 설계도를 이용해서 각각 제품의 설계도를 완성하는 것이 더욱 효율적일 것이다.<br>
<br>

![스크린샷(3)](https://github.com/Yoonsik-2002/java-study/assets/83572199/2aac4fb4-f691-4116-8198-a7afe0df85b7)<br>
<br>

### 추상 클래스와 제어자 `abstract`
추상 클래스에는 제어자 `abstract`가 붙는다. 이는, 해당 클래스가 추상 클래스임을 알리기 위함이다.<br>

이렇게 함으로써, 해당 클래스를 사용할 때, 선언문에 붙어있는 `abstract` 키워드를 보고, 이 클래스에는 추상 메서드가 있으니, 상속을 통해서 구현해 주어야 한다는 것을 쉽게 알 수 있을 것이다.<br>
<br>

이러한 추상 클래스의 기본적인 형태는 아래와 같다. <br>
```java
abstract class 클래스 이름 {
  ...
}
```
<br>

추상 클래스 자체로는 인스턴스를 생성할 수 없으며, 완성되지 않은 추상 메서드를 포함하고 있다는 점을 제외하고는, 추상 메서드는 일반 메서드와 전혀 다르지 않다. 그러므로, 추상 클래스 또한, 생성자를 가질 수 있으며, 멤버변수와 메서드 또한 가질 수 있다.<br>

##### |참고| 클래스 내에 추상 메서드가 존재하지 않는데도, 클래스의 선언문에 `abstract` 키워드를 붙여, 추상 클래스로 지정할 수도 있다. 이렇게 추상 메서드가 존재하지 않는 완성된 클래스라 할지라도, 추상 클래스로 지정되면, 인스턴스를 생성하는것이 불가능하다! 

<br>

### 추상 메서드(abstract method)
이제, 추상 메서드의 개념을 정리해 보도록 하겠다. 보통 우리가 아는 일반적인 메서드는 선언부와 구현부로 이루어져 있다. 그렇다면, 미완성 메서드인 추상 메서드는 어떠한 형태를 가질까?<br>

추상 메서드는 아래와 같이 메서드의 선언부만 작성하고, 구현부는 작성하지 않은 채로 남겨둔 형태를 가진다. 추상 메서드 역시 추상 클래스와 마찬가지로, 제어자 `abstract`가 앞에 붙으며, 메서드의 구현부가 존재하지 않으니 `{}`대신 문장의 끝을 알리는 `;`가 붙게된다.<br>
```java
/* 주석을 통해 어떤 기능을 수행할 목적으로 작성하였는지 설명한다. */
abstract 리턴타입 메서드이름();
```
<br>

추상 메서드가 '미완성 메서드'로 불리는 이유는 이처럼, 메서드를 설계만 해놓고 실제 수행될 내용(구현부)은 작성하지 않았기 때문이라 할 수 있다. 그렇다면, 메서드를 이와 같이 미완성 상태로 남겨놓는 이유는 무엇일까?<br>
<br>

### 메서드를 미완성인 상태로 남겨놓는 이유
추상 클래스에서 추상 메서드를 이와 같이, 미완성인 상태로 남겨놓는 이유는, 해당 추상 메서드의 내용이 상속받는 클래스에 따라 달라질 수 있기 때문이다.<br>

미완성 메서드인 추상 메서드를 멤버로 가지는 미완성 설계도인 추상 클래스의 경우, 상속을 통해, 자손클래스에 의해서만 완성될 수 있다.<br>
<br>

즉, 추상 클래스는 어떠한 새로운 클래스를 작성하는데 바탕이 되는 조상 클래스로써의 역할을 하며, 이러한 추상 클래스를 조상 클래스로 두고 만들어지는 자손 클래스는 추상 클래스로부터 상속받은 추상 메서드의 실제 내용(구현부)을 오버라이딩을 통해 구현하게 된다.<br>

이처럼 설계는 추상 클래스가 하고, 실질적인 메서드의 내용 구현은 추상 메서드를 상속받는 자손 클래스가 하기 때문에, 설계를 담당하는 추상 클래스에서는 메서드의 선언부만을 작성하고, 어떠한 기능을 수행할 목적으로 작성된 것인지 주석을 덧붙여 설명해주기만 하면 되는 것이다.<br>

그리고, 이러한 추상 클래스의 추상 메서드는 이를 상속받은 자손 클래스가 자신에게 맞게 오버라이딩하여 실질적인 내용을 구현해 완성하게 된다. 추상 클래스를 어떤 클래스가 상속을 받느냐에 따라 추상 메서드의 내용이 달라지는 이유는 여기에 있다.<br>
<br>

### 추상 클래스로부터 상속받는 자손 클래스에서 추상 메서드를 오버라이딩 할 때 주의할 점
추상 클래스로부터 상속받는 자손클래스는 상속받은 모든 추상 메서드를 오버라이딩을 통해 모두 구현해 주어야 한다. **만일, 조상(추상 클래스)으로부터 상속받은 추상 메서드를 하나라도 구현하지 않는다면, 해당 자손 클래스 또한 추상 클래스로 지정해 주어야 한다.** <br>

아래 코드의 경우를 한번 보자.<br>
```java
abstract class Player {  // 추상 클래스
  abstract void play(int pos);  // 추상 메서드
  abstract void stop();  // 추상 메서드
}

class AudioPlayer extends Player {
  void play(int pos) {  // 상속받은 추상 메서드를 구현
    // 내용 생략
  }

  void stop() {  // 상속받은 추상 메서드를 구현
    // 내용 생략
  }
}

abstract class AbstractPlayer {
  void stop() {  // 상속받은 추상 메서드를 구현
    // 내용 생략
  }
}
```
<br>

#### 추상 클래스로부터 상속받은 추상 메서드들을 모두 구현한 경우
`AudioPlayer`클래스는 조상인 추상 클래스,`Player`로 부터 상속받은 모든 추상 메서드를 구현하였다. 이처럼 미완성 설계도인 `Player`클래스는 상속을 통해, 자손 클래스인 `AudioPlayer`에 의해 완성되게 된다.<br>
<br>

#### 추상 클래스로부터 상속받은 추상 메서드들을 모두 구현하지 않은 경우
하지만 `AbstractPlayer`클래스의 경우는 다르다. 조상인 추상 클래스,`Player`로 부터 상속받은 추상 메서드를 모두 구현하지 않았다. 때문에, 해당 클래스에는 완성되지 않은, 상속만 받아놓고, 오버라이딩을 통해 구현하지 않은 추상 메서드가 남아있는 상태라 할 수 있다.<br>

결국 추상 메서드를 멤버로 포함하고 있기 때문에, `Abstract`클래스도 `abstract`키워드를 붙여, 추상 클래스로 지정해 주어야 한다.<br>
<br>

### 추상 클래스의 작성 - 클래스들 간의 공통 부분을 뽑아내어, 추상 클래스를 만들어, 이를 상속하도록 하는 경우
추상 클래스의 작성에 있어, 여러 클래스에서 사용될 수 있는 추상 클래스를 바로 작성하거나, 기존 클래스의 공통 부분을 뽑아서 추상 클래스를 만들어, 상속하도록 하는 경우도 존재한다.<br>
<br>

먼저, 두 번째 경우인, 기존 클래스들의 공통 부분을 뽑아서 추상 클래스를 만들어, 상속하도록 하는 경우를 정리해 보도록 하겠다.<br>

다음은 해당 추상 클래스의 작성 방식의 예시로 들기 위해 작성된 코드로, 게임에 나오는 유닛들을 클래스로 정의한 것이다. 해당 코드를 가지고, 클래스들의 공통 부분을 뽑아, 추상 클래스를 만들고, 이를 상속하도록 만들어 보겠다. <br>
```java
class Marine {
  int x, y;
  void move(int x, int y) {/* 지정된 위치로 이동 */}
  void stop() {/* 현재 위치에 정지 */}
  void stimPack() {/* 스팀팩을 사용한다. */}
}

class Tank {
  int x, y;
  void move(int x, int y) {/* 지정된 위치로 이동 */}
  void stop() {/* 현재 위치에 정지 */}
  void changeMode) {/* 공격모드를 변경 */}
}

class DropShip {
  int x, y;
  void move(int x, int y) {/* 지정된 위치로 이동 */}
  void stop() {/* 현재 위치에 정지 */}
  void load() {/* 선택된 대상을 태운다. */}
  void unload() {/* 선택된 대상을 내린다. */}
}
```
<br>

### 클래스들 간의 공통 부분을 뽑아내는데 있어, 메서드의 선언부는 서로 같지만 구현부의 내용이 다른 경우
위 코드를 토대로, `Marine`클래스, `Tank`클래스, `DropShip`클래스에서 공통적인 부분을 찾아, 해당 부분을 표시하여 나타내면 아래 그림과 같이 나타낼 수 있을 것이다.<br>
<br>

![스크린샷(3)](https://github.com/Yoonsik-2002/java-study/assets/83572199/083ecbc1-f09d-46e6-b490-bb0dd3182cd5)<br>
<br>

이때, `Marine`클래스와 `Tank`클래스, `DropShip`클래스의 `move`메서드의 선언부는 공통적인 부분으로 표시되었지만, 구현부는 공통적인 부분으로 표시되지 않았다. 그 이유는 각 클래스의 특성에 따라, 해당 `move`메서드의 구현부의 내용이 달라지기 때문이라 할 수 있다.<br>

먼저, `Marine`클래스와 `Tank`클래스는 지상 유닛이지만, `DropShip`클래스는 공중 유닛으로, 서로 이동하는 방법이 다르다는 차이점이 존재한다. 이러한 이유로, 이 '이동' 기능을 구현하는 `move`메서드의 경우,<br>

'해당 메서드가 멤버로 속해 있는 클래스가 지상 유닛을 생성하기 위한 클래스냐, 공중 유닛을 생성하기 위한 클래스냐' 에 따라서 실제 구현부의 내용이 서로 달라질 수 있다.<br>

이때, 해당 클래스들 간, `move`메서드의 선언부는 같기 때문에 `move`메서드를 추상 클래스 `Unit`의 추상 메서드로 정의하는 것이 가능하다. 이렇게 할 경우, 다음과 같은 장점이 존재한다.<br>
<br>

1) 클래스 간 공통적인 부분을 최대한 뽑아냄으로써, 코드의 중복을 최대한 줄인 간결한 코드를 작성하는 것이 가능하다.<br>

2) 어차피 모든 유닛들에겐 움직이는 기능 즉, `move`메서드의 기능이 필요하다.<br>

   이때, 해당 메서드를 추상 클래스 `Unit`의 추상 메서드로 정의함으로써, 이를 상속받은 자손 클래스 유닛 별로, 특성에 맞게 각기 다른 이동 방법(지상 유닛 : 걸어서 , 공중 유닛 : 날아서)을 적용하여 `move`메서드의 구현부의 내용을 구현해 내는것이 가능하다.<br>

3) `move`메서드가 추상 메서드로 선언된 것에는, 앞으로 추상 클래스인 `Unit`클래스를 상속받아 작성되는 클래스는 모두, 상속받은 추상 메서드 `move`의 구현부의 내용을 클래스 자신에게 알맞게 작성하여 반드시 완성해 주어야 한다는 의미가 담겨있다.<br>

   즉, 이렇게 메서드 앞에 `abstract`가 붙게되면, 이 추상 메서드를 해당 추상 메서드를 상속받는 자손 클래스에서 반드시 구현해 주여야 한다는 것을 자손 클래스 작성자에게 강조해주는 역할을 한다.<br> 
<br>

자, 그럼 이러한 `Marine`, `Tank`, `DropShip`클래스들의 공통된 부분을 뽑아내어, 추상 클래스`Unit`을 만들어 보도록 하겠다. 먼저, 각 클래스들간의 공통적인 부분은 멤버변수 `x`, `y`가 있으며, 메서드 `stop`과, 메서드 `move`의 선언부가 있다.<br>
<br>

![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/4c1c3078-c7e7-4135-aebb-20338fab1796)<br>
<br>

`stop`메서드의 경우, 현재 위치에서 정지하는 기능을 담당하며, 해당 메서드의 경우, 세 클래스에서 모두 선언부와 구현부가 공통적이다. 하지만, `move`메서드의 경우는 다르다.<br>

`move`메서드는 이를 멤버로 포함하는 클래스가 '지상 유닛 객체를 생성하기 위한 클래스인가? 아니면, 공중 유닛 객체를 생성하기 위한 클래스인가?' 에 따라, 메서드의 구현부가 달라지게 된다. 하지만 클래스간, `move`메서드의 선언부는 서로 같다.<br>

때문에, 추상 클래스 `Unit`에는 멤버변수 `x`, `y`와 `stop`메서드, 그리고 `move`메서드의 선언부 즉, 추상 메서드 `move`가 들어가게 된다. 이렇게 `Unit`클래스는 추상 메서드를 포함하고 있기 때문에, 추상 클래스가 된다. 완성된 추상 클래스 `Unit`은 아래와 같다.<br>
```java
abstract class Unit {
  int x, y;

  abstract move(int x, int y);
  /* 추상 메서드 move -
     추상 클래스 Unit으로부터 상속받는 자손 클래스들은 각자 특성에 맞게,
     상속받은 추상 메서드 `move`의 내용(구현부)을 구현해 내는것이 가능하다. */

  void stop() {
    /* 현재 위치에서 정지 */
  }
}
```
<br>

이제, `Marine`, `Tank`, `DropShip`클래스는 추상 클래스 `Unit`을 상속받아, 작성되게 된다. 아래와 같이 말이다.<br>
```java
abstract class Unit {  // 해당 클래스는 추상 클래스로, 추상 메서드를 포함하고 있으니, 자손 클래스로의 상속을 통해 구현되어야 함을 알림
  int x, y;
  abstract void move(int x, int y);  // 해당 메서드는 추상 메서드로, 앞으로 Unit 클래스를 상속받아 작성되는 클래스는 move메서드를 자신에게 맞게 반드시 구현해야 함을 알림
  void stop() {/* 현재 위치에 정지 */}
}

class Marine extends Unit{
  void move(int x, int y) {/* 지정된 위치로 이동 */}
  void stimPack() {/* 스팀팩을 사용한다. */}
}

class Tank extends Unit{
  void move(int x, int y) {/* 지정된 위치로 이동 */}
  void changeMode) {/* 공격모드를 변경 */}
}

class DropShip extends Unit{
  void move(int x, int y) {/* 지정된 위치로 이동 */}
  void load() {/* 선택된 대상을 태운다. */}
  void unload() {/* 선택된 대상을 내린다. */}
}
```
<br>

### `abstract`를 붙여야 하는 이유
위 코드를 보면, 아래와 같은 의문점이 들 수 있다.<br>

'어차피 `Unit`클래스를 부모클래스로 하여, `Marine`, `Tank`, `DropShip`클래스가 이를 상속받는 것이라면, 아래 코드와 같이 `move`메서드를 추상 메서드가 아닌, 구현부가 비어있는 메서드로 정의해 두고, 해당 메서드를 자손 클래스들에서 오버라이딩하여 사용해도 별 차이 없는거 아닌가?'<br>

```java
class Unit {
  int x, y;
  void move(int x, int y) {}  // 구현부가 비어있는 메서드
  void stop() {
    /* 현재 위치에 정지 */
  }
}

class Marine extends Unit{
  void move(int x, int y) {/* 지정된 위치로 이동 */}
  void stimPack() {/* 스팀팩을 사용한다. */}
}

class Tank extends Unit{
  void move(int x, int y) {/* 지정된 위치로 이동 */}
  void changeMode) {/* 공격모드를 변경 */}
}

class DropShip extends Unit{
  void move(int x, int y) {/* 지정된 위치로 이동 */}
  void load() {/* 선택된 대상을 태운다. */}
  void unload() {/* 선택된 대상을 내린다. */}
}
```
<br>

그렇다. `Unit`을 상속받는 자손 클래스들에서 `move`메서드를 잊지않고 오버라이딩 해 준다면, 위와 같이 코드를 작성한다고 해서 문제가 발생하지는 않는다. 하지만, 역으로 문제가 발생하지 않을 것이란 보장은 할 수 없다. <br>
<br>

##### `abstract`를 붙여, 추상 메서드로 선언하지 않고, 구현부가 빈 메서드를 정의하였을 시, 발생할 수 있는 문제점
만약, 위와 같이, `move`메서드에 `abstract`를 붙여, 추상 메서드로 선언하지 않고, 구현부가 빈 메서드를 정의하는 경우, 이를 상속받는 자손 클래스에서는 이미 해당 메서드가 구현이 완료된 메서드인 것으로 인식하고, 오버라이딩을 통해 자신에게 맞게 구현하지 않고 넘어가버릴 가능성이 존재한다.<br>
<br> 

##### `abstract`를 붙여, 추상 메서드로 선언하였을 시, 얻을 수 있는 긍정적인 효과
위 경우와는 반대로, `move`에 `abstract`를 붙여, 추상 메서드로 선언하였을 시에는, 해당 메서드를 상속받는 자손 클래스를 작성하는 이로 하여금, 이것이 추상 메서드이므로, 반드시 자손 클래스에 맞게 내용을 구현해 주어야 한다는 사실을 강조해 주는 효과를 얻을 수 있게된다.<br>
<br>

`abstract`가 붙는 추상 클래스와 추상 메서드의 개념을 알고 있는 개발자라면, `abstract`가 붙는 추상 클래스인 `Unit`클래스는 미완성 클래스로, 그 자체로 인스턴스를 생성하는 것이 불가능하며, 상속을 통해 자손클래스에 의해서만 완성시키는 것이 가능하다는 것을 알 것이다.<br>

그리고, 추상 클래스를 토대로 자손 클래스를 작성하는데 있어, 추상 클래스에 존재하는 모든 추상 메서드를 자손 클래스에서 자신에게 맞게 오버라이딩 하여 구현해 주어야지만, 완성된 클래스를 생성할 수 있음을 알 것이다.<br>

만약, 추상 클래스에 존재하는 모든 추상 메서드를 자손 클래스에서 오버라이딩 하여 구현해주지 않을 경우, 미완성 메서드인 추상 메서드를 상속받아 그대로 가지고 있는 꼴이 되므로, 해당 자손 클래스 또한 미완성 클래스인 추상 클래스가 되기 때문이다.<br>
<br>

즉, 쉽게 말해, `abstract`는 추상 클래스의 자손 클래스를 작성하는 개발자로 하여금 아래와 같은 생각을 하게 해주는 역할을 하는 것이다.<br>
<br>

*'어? 클래스 앞에 `abstract`가 붙어있는 추상 클래스잖아?* <br>

*추상 클래스로부터 상속받는 자손클래스를 작성할 때에는 추상 클래스에 존재하는 모든 추상 메서드를 오버라이딩 하여 구현해 주어야해.<br>
이 추상 클래스에 자손 클래스에서 오버라이딩 하여 구현해주어야할 추상 메서드가 무엇이 있는지 봐볼까?'* <br>
<br>

### 추상 클래스인 `Unit`클래스 타입의 참조변수 배열 사용하기
위에서 만든 추상 클래스 `Unit`은 해당 클래스로부터 상속받는 `Marin`, `Tank`, `DropShip` 클래스를 작성하는데 바탕이되는 조상 클래스의 역할을 한다.<br>

단지, 추상 메서드 `move`를 포함하고 있기에, 이를 상속받는 자손 클래스들이 자신에게 맞게 `move`메서드의 구현부를 반드시 오버라이딩 하여 구현해 주어야 한다는 특징이 존재할 뿐이다.<br>
<br>

아래는 추상 클래스 `Unit` 타입의 참조변수 배열로, 다형성의 원리에 의하여 해당 배열을 통해, `Unit`을 조상으로 하여 작성된 `Marin`, `Tank`, `DropShip`클래스의 인스턴들을 다루는 것이 가능하다.<br>

즉, `Unit`이 자손 클래스인 `Marin`, `Tank`, `DropShip`의 공통조상이기에, `Unit` 타입의 참조변수 배열로 해당 클래스들의 인스턴스들을 하나의 묶음으로 다룰수가 있는 것이다!<br>
```java
Unit[] group = new Unit[3];

group[0] = new Marin();
group[1] = new Tank();
group[2] = new DropShip();

for (int i = 0; i < group.length; i++) {
  group[i].move(100, 200);
```
<br>

위 코드의 `group[i].move(100, 200);`는 각 인덱스에 저장되어 있는 자손 클래스의 인스턴스를 (100, 200) 좌표로 움직이는 역할을 한다. 이때, `Unit`타입의 참조변수 `group[i]`을 사용하여 `move`메서드를 호출한다고 해서,<br>

`Unit`클래스의 완성되지 않은 추상 메서드 `move`가 호출되는 것이라 생각해선 안된다. 메서드는 참조변수의 타입과는 관계없이 실제 참조변수가 가리키고 있는 인스턴스에서 구현된 메서드가 호출되기 때문이다.<br>

즉, `group[i].move(100, 200);`과 같이 호출하는 것이 `Unit`클래스의 추상 메서드인 `move`를 호출하는 것 처럼 보일 수 있지만 실제적으로는, 해당 참조변수에 의해 참조되고 있는 `Marin`, `Tank`, `DropShip`인스턴스에서 구현된 메서드가 호출되는 것이다.<br>
<br>

### 추상화에 대한 최종 정리
이렇게 추상 클래스, 추상 메서드에 대해 공부해 보았다. 상속이 조상 클래스를 사용하여, 확장된 개념인 자손 클래스를 만들어 내는 구체화 작업이라면, 추상화는 반대로, 기존의 클래스의 공통부분을 뽑아내어, 조상 클래스를 만들어내는 추상화 작업이라 할 수 있다.<br>

추상화를 구체화의 반대되는 의미로 이해하면, 이해하기 쉽다. 즉, 구체화가 기존의 것에 기능을 더하고, 확장시켜, 더욱 구체적으로 만드는 것이라 하면, 추상화는 그 반대의 의미로, 공통적인 요소들을 뽑아내어 기존의 것 보다 불명확하게 만드는 작업이라 할 수 있다.<br>
<br>

![스크린샷(7)](https://github.com/Yoonsik-2002/java-study/assets/83572199/23c8d6f3-d3d1-46db-b0a4-78780f80f2e0)<br>
<br>

이를 상속 계층도에 빗대어 설명하면, 상속 계층도를 따라 내려갈수록, 클래스는 점점 기능이 추가되고, 확장되어 구체화의 정도가 더욱 심해지며, 상속 계층도를 따라 올라갈수록, 클래스는 공통요소만 남게 되어, 추상화의 정도가 심해진다고 할 수 있다.<br>
<br>

올라가면 올라갈수록 공통요소만 남아, 기존의 것보다 불명확해지는 추상화. 불명확하다는 것이 뭔가 좋지 않게 느껴지지만, 불명확 하다는 것에서의 나름 장점 또한 존재한다.<br>

추상화된 코드는 구체화된 코드보다 유연하다. 유연하다는 것은 변경에 유리하다는 것으로, 이러한 특성이 장점이 되는 경우가 존재한다.<br>
<br>

### 인터페이스(interface)
인터페이스는 추상 클래스의 일종으로, 프로그래밍 관점에서 보았을 때, 추상 메서드의 집합이라 할 수 있다. 단순하게, 추상 메서드를 쭉 적어, 나열해 놓은 것이라 생각하는 것이 편할 것이다.<br>
(JDK 1.8 부터 인터페이스에 상수와 static 메서드, default 메서드가 추가되었지만, 이것은 핵심이 아님. 중요한 것은 인터페이스는 추상 메서드의 집합이라는 것! 이것이 핵심이다.)<br>
<br>

우리가 이전에 공부하였던 추상 메서드는 무엇이었나? 그렇다. 일반 클래스에 왼성되지 않은 메서드인 추상 메서드가 포함되면, 이는 완성되지 않은 메서드를 포함하는 완성되지 않은 클래스인, 추상 클래스가 되었었다.<br>

즉, 추상 메서드는 일반 메서드에 추상 메서드가 포함되어 있는 형태로,  일반 메서드의 요소인 생성자, 지역변수가 포함되는 것이 당연하였다.<br>
<br>

하지만, 인터페이스는 추상 메서드보다 추상화 정도가 높아서, 몸통을 갖춘 일반 메서드나 멤버변수를 구성원으로 가질 수 없다. **오직 추상 메서드와 상수만을 멤버로 가질 수 있으며, 그 외의 다른 어떠한 요소도 허용하지 않는다.** <br>

**인터페이스 또한, 추상 클래스와 같이 완성되지 않은 불완전한 것이기 때문에, 그 자체만으로 사용되기 보다는, 다른 클래스를 작성하는데 도움을 줄 목적으로 사용된다.** <br>
<br>

### 인터페이스의 선언
인터페이스의 선언은 클래스를 선언하는 것과 크게 다를 것이 없다. 키워드로 `class`대신 `interface`가 사용된다는 차이가 존재할 뿐이다. 또, 인터페이즈의 접근 제어자로는 `public`과 `(default)`를 사용하는 것이 가능하다.<br>
(클래스의 경우, 접근 제어자로 `public`, `protected`, `(default)`, `private`를 사용하는 것이 가능하지만, 인터페이스는 `public`과 `(default)`만 접근제어자로 사용 가능하다.)<br>

다음은 인터페이스의 선언문의 형태를 나타낸 것이다.<br>
```java
interface 인터페이스이름 {
  public static final 상수이름 = 값;  // 상수
  public abstract 반환형 메서드이름(매개변수 목록);  // 추상 메서드
}
```
<br>

이때, 위 선언문의 형태를 보면 알 수 있듯이, 상수이든, 추상 메서드이든 예외없이 **인터페이스의 멤버라면 모두 `public`이 붙는다.** 또, 이러한 인터페이스의 멤버인 상수와 추상 메서드에는 다음과 같은 제약사항이 존재한다.<br>
<br>

> ##### 추상 메서드-
> 모든 메서드(추상 메서드)는 `public abstract`이어야 하며, 이를 생략하는것이 가능하다.<br>
> ##### 상수 -
> 모든 멤버변수(상수)는 `public static final`이어야 하며, 이를 생략하는것이 가능하다.<br>

<br>

추상 메서드의 경우, 기본적으로 `abstract`가 붙는데, 인터페이스의 멤버는 모두 `public`이 붙어야 하므로, 인터페이스의 멤버로서의 추상 클래스는 항상 예외없이 `public abstract`인 것이다.<br>

또, 상수의 경우를 설명하면, Java에서 상수의 접근 제어자는 일반적으로 `static final`로 선언되는데, 인터페이스의 멤버는 모두 `public`이 붙어야 하므로, 인터페이스의 멤버로서의 상수는 항상 예외없이 `public static final`인 것이다.<br>
<br>

이처럼 인터페이스에 정의된 모든 멤버에 예외없이 적용되는 사항이기 때문에, 제어자를 생략하는 것이 가능하며, 생략된 제어자는 컴파일 시, 컴파일러가 자동으로 추가해준다.<br>

자, 이제 인터페이스를 한번 직접 작성해 보도록 하겠다. 인터페이스는 간단히 말해, 추상 메서드의 집합, 추상 메서드를 쭉 나열해 놓은 것이라 할 수 있으며, 멤버로는 추상 메서드와 상수를 가진다. 해당 멤버들의 접근 제어자는 모두 `public`이다.<br>
(인터페이스의 모든 멤버들에는 접근 제어자 `public`이 붙음)

```java
interface PlayingCard {
  public static final int HEART = 1;  
  static int CLOVER = 2;  // public static final int CLOVER = 2;
  final int SPADE = 3;  // public static final int SPADE = 3;
  int DIAMOND = 4;  // public static final int DIAMOND = 4;

  public abstract String getCardNumber();
  String getCardKind();  // public abstract String getCardKind();
}
```

##### |참고| 원래는 인터페이스의 모든 메서드는 추상 메서드여야 하는데, JDK1.8 부터 인터페이스에 static메서드와 (default)메서드의 추가를 허용하는 방향으로 변경되었다. 실무에서는 아직 JDK1.8을 사용하지 않는 곳이 많기 때문에, JDK1.8이전 규칙과 이후의 규칙을 모두 알고 있어야 한다! 

<br>

### 인터페이스의 상속
인터페이스는 인터페이스로부터만 상속 받을 수 있다. 즉, 인터페이스의 조상은 인터페이스만 가능하다. 또, 인터페이스는 클래스와는 달리, 다중상속을 허용하여, 여러 개의 인터페이스로부터 상속받는 것이 가능하다. 그리고, `Object`와 같은 최고 조상이 없다.<br>

인터페이스가 다중 상속이 가능한 이유는 인터페이스를 구성하는 추상 메서드에는 구현부가 존재하지 않기 때문에, 메서드간의 충돌 문제가 발생하지 않기 때문이라 할 수 있다.<br> 

인터페이스의 상속은 다중 상속이 가능하다는 점 말고는, 클래스의 상속과 크게 다를 것이 없다. 다음 인터페이스의 상속 예시코드를 한번 보자.<br>
```java
interface Movable {
  /* 지정된 위치로 이동하는 기능 */
  void move(int x, int y);  // public abstract 생략
}

interface Attackable {
  /* 지정된 대상을 공격하는 기능 */
  void attack(Unit u);  // public abstract 생략
}

interface Fightable extends Movable, Attackable {}
```
<br>

위 코드의 결과, 인터페이스 `Fightable`은 조상 인터페이스(`Movable`, `Attackable`)로 부터 추상 메서드 `move`와 `attack`을 상속받아, 멤버로 가지게 된다.<br>
<br>

### 인터페이스의 구현
#### 자손 클래스로의 상속을 통해 멤버로 가지고 있던 추상 메서드를 완성하는 추상 클래스
미완성 메서드인 추상 메서드를 멤버로 가지는, 객체의 미완성 설계도인 추상 클래스. 이 추상 클래스의 경우, 추상 클래스 자체로는 인스턴스를 생성하는 것이 불가능 하였다.<br>

즉, 추상 클래스는 결국, 그 자체적으로 바로 사용될 수 있는 개념이 아닌, 자손 클래스를 작성하는데 바탕이 되어주는 조상 클래스의 역할을 하는 것으로 공부 하였었다.<br>

그렇기 때문에, 추상 클래스는 자손 클래스로의 상속을 통해, 멤버로 포함하고 있던 추상 메서드를 자손 클래스로 상속해주고, 자손 클래스가 이를 오버라이딩하여 자신에게 맞게 구현부의 내용을 완성해줌으로써 비로소 가지고 있던 추상 메서드를 완성하는 것이 가능하였었다.<br>
<br>

#### 인터페이스의 구현 - 인터페이스에 정의된 추상 메서드를 완성하는 것
추상 클래스가 자손 클래스로의 상속을 통해, 추상 메서드를 완성하는 것과 같이, 인터페이스도, 자신에게 정의되어 있는 추상메서드의 구현부를 완성해줄 클래스를 작성해 주어야 한다.<br>

이렇게, 인터페이스에 정의된 추상 메서드를 완성해주는 작업을 가리켜, 인터페이스의 구현이라 한다.<br>
<br>

이러한 인터페이스의 구현은 추상 클래스가 자신의 추상 메서드를 오버라이딩 하여 구현해줄 자손 클래스를 작성하는 것과 크게 다를 것이 없다. `extends`대신 구현한다라는 의미의 키워드, `implements`를 사용한다는 차이점이 존재할 뿐이다.<br>

다음은 인터페이스의 구현방식을 나타낸 예시 코드이다.<br>
```java
class 클래스이름 implement 인터페이스이름 {
  // 인터페이스에 정의되어 있는 추상 메서드를 구현해야 한다.
}
```
<br>

위 코드의 형태와 같이, `implement`키워드를 통해 지정한 인터페이스에 정의되어 있는 추상 메서드를 해당 클래스에서 구현해 줌으로써, 인터페이스의 구현이 이루어지는 것이다.<br>

그럼 이제, 다음 인터페이스 구현 예시코드를 한번 보도록 하자.<br>
<br>

### 인터페이스의 모든 추상 메서드를 구현한 경우
```java
interface Fightable {
  void move (int x, int y);
  void attack (Unit u);
}

class Fighter implements Fightable {
  void move (int x, int y) {
    /* 메서드 구현 */
  }
  void attack (Unit u) {
    /* 메서드 구현 */
  }
}
```
<br>

`Fighter`클래스는 `implements`키워드를 통해 지정한 인터페이스 `Fightable`에 존재하는 모든 추상 메서드(`move`, `attack`)를 구현해주었기 때문에, 인터페이스의 구현에 성공하였다고 할 수 있다.<br>
<br>

### 인터페이스의 추상 메서드를 모두 구현하지 않고, 일부만 구현한 경우
그럼, 아래 케이스를 한번 보자.<br>
```java
interface Fightable {
  void int move (int x, int y);
  void int attack (Unit u);
}

abstract class Fighter implemtnes Fightable {
  void move (int x, int y) {
    /* 메서드 구현 */
  }
}
```
<br>

위 코드를 보면 알 수 있듯이, `Fighter`클래스는 `implements`키워드를 통해 지정한 인터페이스,`Fightable`이 가지고 있는 모든 추상메서드를 구현하지 않았다.<br>

`Fightable`인터페이스의 추상 메서드인 `move`와 `attack`중, `move`만 구현해 놓은 상태인 것이다. 이 경우, 구현되지 않은 추상 메서드 `attack`은 그대로 `Fighter`클래스에 남아있게 된다.<br>

완성되지 않은 메서드인 추상 메서드를 멤버로 가지는 추상 클래스 앞에는 `abstract`키워드를 붙여주어야 한다.<br>
<br>

이처럼, 클래스가 구현하고자 하는 인터페이스의 추상 메서드 중, 일부만 구현하게 되는 경우, 해당 클래스는 추상 메서드를 포함하는 추상 클래스가 되므로, `abstract`를 붙여, 추상 클래스로 선언해 주어야 한다.<br>
<br>

### 상속과 구현을 동시에 (ft.다중 구현)
마지막으로, 아래 코드와 같이, 상속과 구현을 동시에 하는 것도 가능하다.<br>
```java
abstract class Unit {
  int x, y;
  abstract void move (int x, int y);
  void stop() {
    /* 현재 위치에 정지 */
  }
}

interface Fightable {
  void move (int x, int y);
  void attack (Unit u);
}

class Fighter extends Unit implements Fightable {
  void move (int x, int y) {
    /* 메서드 구현 */
  }
  void attack (Unit u) {
    /* 메서드 구현 */
  }
}
```
<br>

위 코드를 보면, `Fighter`클래스는 `Unit`클래스를 상속받고, `Fightable`클래스를 구현한다. 이때, 추상 클래스 `Unit`과 인터페이스 `Fightable`에는 똑같은 추상 메서드 `move`가 존재한다.<br>

이러한 경우, `Fighter`클래스는 `Unit`클래스의 추상 메서드 `move`와 `Fightable`인터페이스의 추상 메서드 `move`를 따로따로 구현해 주어야 할까?<br>

아니다. `Fighter`클래스에서는 `Unit`클래스의 추상 메서드, `move`를 오버라이딩 하여 구현하고, 이렇게 구현된 `move`메서드는 동시에, `Fightable`인터페이스의 추상 메서드 `move`를 구현한 것으로 간주된다.<br>

**이렇게 두개의 추상 메서드의 구현을 동시에 만족시키는 것을 가리켜, "다중 구현" 이라고 한다.<br>**
<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/35e541c8-af61-4fe5-b226-a73bd5a5f667)<br>
<br>

이러한 다중 구현이 가능한 이유는, `move`와 같은 추상 메서드에는 메서드의 구현부가 존재하지 않아, **메서드간 충돌이 발생하지 않기 때문이라 할 수 있다.<br>**

마지막으로, 다음 예시코드를 한번 보도록 하자.<br>
```java
package chapter_07;

interface Movable {
    void move(int x, int y); // public abstract void move (int x, int y);
}

interface Attackable {
    void attack(Unit u); // public abstract void attack (int x, int y);
}

interface Fightable extends Movable, Attackable {} 
/* Mobeable 인터페이스와 Attackable 인터페이스를 다중 상속받아,
해당 인터페이스들이 가지고 있는 주상 메서드, move와 attack을 포함하고 있음.*/

class Unit {
    int currentHP;
    int x, y;
}

class Fighter extends Unit implements Fightable {
    public void move(int x, int y) {/* 내용 생략 */}
    public void attack(Unit u) {/* 내용 생략 */}
}

class Ex07_17_FighterTest {
    public static void main(String[] args) {
        Fighter f = new Fighter();
        
        if(f instanceof Unit) {
            System.out.println("f는 Unit의 자손이다.");
        }
        
        if(f instanceof Movable) {
            System.out.println("f는 Movable 인터페이스를 구현하였다.");
        }
        
        if(f instanceof Attackable) {
            System.out.println("f는 Attackable 인터페이스를 구현하였다.");
        }
        
        if(f instanceof Fightable) {
            System.out.println("f는 Fightable 인터페이스를 구현하였다.");
        }
        
        if(f instanceof Object) {
            System.out.println("f는 Object 클래스의 자손이다.");
        }
    }
}
```
<br>

해당 코드에 사용된 클래스와 인스턴스의 관계를 그림으로 나타내보면, 다음과 같이 표현이 가능하다.<br>
<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/de94a632-f420-4747-aa27-7018b8afad6f)<br>
<br>

실제로, `Fighter`클래스는 `Unit`클래스로부터 상속받고, `Fightable`인터페이스만을 구현 하였지만, `Unit`클래스는 `Objact`클래스의 자손이고, 다중상속이 가능한 인터페이스인 `Fightable`은 `Movable`과 `Attackable`의 자손이다.<br>

그러므로, `Fighter`클래스는 이 모든 클래스와 인터페이스의 자손이 되는 셈이다.<br>
<br>

인터페이스의 경우, 상속이 아닌, 구현이라는 용어를 사용하지만, 이러한 구현도 인터페이스로부터 상속받은 추상 메서드를 구현하는 것이기 때문에, 인터페이스도 조금 다른 의미의 조상이라 할 수 있다.<br>

마지막으로, 위 코드에서 인터페이스의 추상 메서드를 구현하는 부분을 한번 봐 보자.<br>
```java
...
interface Fightable {
  void move(int x, int y);
  void attack(Unit u);
}

class Fighter extends Unit implements Fightable {
  public void move(int x, int y) {/* 내용 생략 */}
  public void attack(Unit u) {/* 내용 생략 */}
}
```
<br>

메서드를 오버라이딩 하는 경우에는, 자식 클래스에서 오버라이딩 한 메서드의 접근 제어자의 범위가 기존 조상 클래스의 메서드의 접근 제어자의 범위보다 크거나 같아야 한다.<br>

이때, 인터페이스 `Fightabel`을 보면, 해당 인터페이스에 정의되어 있는 추상 클래스 `move`와 `attack`에는 아무런 접근제어자가 붙어있지 않다. 이는, 보이는 그대로 해당 추상 클래스들의 접근제어자가 `(default)`라는 의미가 아니라, `public abstract`가 생략된 것이다.<br>

인터페이스의 모든 추상 메서드 앞에는 예외없이 `public abstract`가 붙기 때문에, 이를 생략해 주는 것이 가능하다. (생략된 `public abstract`는 컴파일 시, 컴파일러가 자동으로 추가해줌)<br>

결국, `Fightable`인터페이스가 `Fighter`클래스에게 상속 시켜준 추상 메서드,`move`와 `attack`의 접근제어자는 `public`이므로, 이들을 오버라이딩 하여 구현해준 `Fighter`클래스의 `move`, `attack`메서드의 접근제어자는 모두 `public`이어야 한다.<br>
<br>

**오버라이딩을 통해 자손 클래스에서 구현된 메서드의 접근 제어자의 범위는 반드시 기존 조상 클래스의 메서드의 접근제어자의 범위보다 넓거나 같아야 한다! 그리고, 이러한 개념은 인터페이스의 구현에도 적용된다!(인터페이스 : 조금 다른 의미의 조상)** <br>
<br>

### 인터페이스를 이용한 다형성
이전 정리에서 인터페이스도 자기 자신을 구현해준 클래스의 (조금 다른 의미의)조상이 될 수 있다고 하였었다. 결국, 자신이 가지고 있는 추상 메서드를, 이를 구현해줄 클래스에게 상속해주기 때문이다.<br>
<br>

![스크린샷(3)](https://github.com/Yoonsik-2002/java-study/assets/83572199/846f6789-26db-4667-a39d-cdd8b5a7e193)<br>
<br>

위 그림과 같이, 인터페이스는 결국 자신을 구현한 클래스의 조상이라 할 수 있다. 그렇기에, 해당 인터페이스 타입의 참조변수로, 이를 구현한 클래스의 인스턴스를 참조하는 것이 가능하고, 인터페이스 타입으로 형 변환도 가능하다.<br>

예를들어, `Fighter`클래스가 `Fightable`인터페이스를 구현하였다고 해 보자. 이러한 경우, 아래 코드와 같이, `Fightable`타입의 참조변수가 `Fight`클래스의 인스턴스를 참조하게 하는 것이 가능하다.<br>
```java
Fightable f = (Fightable)new Fighter();
Fightable f = new Fighter();  // Up-casting이므로, 형 변환 생략 가능.
```
<br>

하지만, 여기서 주의할 점이 존재한다. 인터페이스를 이용한 다형성도 마찬가지로, 인터페이스 타입의 참조변수가 이를 구현한 클래스의 인스턴스를 참조하는 경우, 해당 참조변수로는 **인터페이스에 정의된 멤버들만 사용하는 것이 가능하다.** <br>

즉, 인터페이스, `Fightable`타입의 참조변수를 사용하는 경우, 해당 인터페이스에 정의되어 있는 멤버들만 호출이 가능한 것이다.<br>
<br>

### 인터페이스를 이용한 다형성 I - 메서드의 매개변수의 타입으로 사용되는 인터페이스
인터페이스를 이용한 다형성에 의해, 인터페이스가 메서드의 매개변수의 타입으로 사용되는 것도 가능하다. 이러한 인터페이스 타입의 매개변수가 가지는 의미는 무엇일까?<br>

바로, **해당 매개변수에는 그 매개변수 타입의 인터페이스를 구현한 클래스의 인스턴스를 넘겨주어야 한다는 것을 의미한다.<br>**
```java
class Fighter extends Unit implements Fightable {
  public void move(int x, int y) {/* 내용 생략 */}
  public viod attack(Fightable f) {/* 내용 생략 */}
```
<br>

위 코드의 경우, `attack`메서드를 보면 인터페이스인 `Fightable`타입의 매개변수 `f`가 존재하는 것을 볼 수 있다. <br>

이러한 `attack`메서드의 호출 시, 매개변수 `f`에는 `Fightable` 인터페이스를 구현해준 `Fighter`클래스의 인스턴스만을 넘겨주는 것이 가능하다.<br>
<br>

### 인터페이스를 이용한 다형성 II - 메서드의 리턴타입으로 지정되는 인터페이스
```java
Fightable method() {
  ...
  Fighter f = new Fighter();
  return f;
}
```
<br>

인터페이스의 다형성에 의해, 인터페이스를 메서드의 리턴타입으로 지정해주는것도 가능하다.<br>
<br>

**메서드의 리턴타입이 인터페이스라는 것은, 메서드가 해당 인터페이스를 구현한 클래스의 인스턴스를 반환한다는 것을 의미한다.<br>**

위 코드의 경우, `method`의 리턴타입이 인터페이스인 `Fightable`이기 때문에, 메서드의 리턴문에서 `Fightable`인터페이스를 구현한 클래스인 `Fighter`의 인스턴스를 반환해준다.<br>
<br>

### 인터페이스의 장점
인터페이스의 장점을 정리하기 전에, 먼저 핵심적인 인터페이스의 의미가 무엇인지에 대해 한번 짚고 넘어가 보도록 하겠다.<br>
<br>

### 핵심적인 인터페이스의 의미는 무엇인가? 
**인터페이스는 두 대상(객체)간의 '연결', '대화', '소통'을 돕는 '중간 역할'을 한다.<br>**

이러한 인터페이스의 예시를 들면, 우리가 흔히 사용하는 GUI(Graphical User Interface), Windows를 예로 들 수 있다. 컴퓨터에게 사람이 직접 명령하여 컴퓨터를 사용하는 것은 쉽지 않은 일이다.<br>

하지만, Windows를 통하여, 우리는 보다 직관적이고 편리하게 컴퓨터를 사용하는 것이 가능하다. Windows화면 클릭 시, 해당되는 명령어가 컴퓨터로 전달되는 방식으로 말이다.<br>

이렇게, Windows는 사람과 컴퓨터라는 두 대상 사이의 중간 역할을 하며, 이러한 두 대상간의 '연결', '대화', '소통'을 돕는다.<br>
<br>

이처럼 Windows라는 인터페이스를 사용하게되는 경우, 우리는 컴퓨터(하드웨어)와 직접 소통하지 않고, 컴퓨터와 사람의 연결과 소통을 돕는, 중간 역할인 Windows와 직접적인 관계를 가지며 소통한다. 그리고, 컴퓨터와는 Windows를 통하여 간접적으로 소통하게된다.<br> 

이러한 경우, 컴퓨터(하드웨어)를 다른 것으로 바꾸어도, 직접 관계를 가지며 소통하던 인터페이스인, Windows를 통해 그대로 사용하는 것이 가능하다! Java에서의 인터페이스도 마찬가지로 이러한 특성을 가진다.<br>

자, 이제, 인터페이스의 4가지 장점에 대해 정리해 보도록 하겠다.<br>
<br>

### 인터페이스의 장점 1. - 독립적인 프로그래밍이 가능하여, 변경에 유리한, 유연한 코드를 작성하는 것이 가능하다. 
인터페이스의 장점을 확실히 이해하기 위해, 인터페이스를 사용하였을 때와 사용하지 않았을 때를 비교하여 정리해 보도록 하겠다.<br>
<br>

### 인터페이스를 사용하지 않은 경우 
```java
class A {
  public void methodA(B b) {
    b.methodB();
  }
}

class B {
  public void methodB() {
    System.out.println("methodB()");
  }
}

class InterfaceTest {
  public static void main(String[] args) {
    A a = new A();
    a.methodA(new B());
  }
}
```
<br>

위 상황을 그림으로 나타내면 다음과 같이 표현하는 것이 가능하다.<br> 
<br>

```java
// ppt 그림 삽입
```
<br>

위 그림을 보면 알 수 있듯이, 클래스 `A`가 클래스 `B`를 사용하고 있다. 이와 같은 관계를 가리켜, **'클래스 `A`가 클래스 `B`에 의존하고 있다.'** 라고 표현하는 것이 가능하다.<br>

이때, 위 상황의 경우, 인터페이스를 사용하고 있지 않고, 클래스 `A`와 클래스 `B`가 서로 직접적인 관계를 가지고 있는 상황이라 할 수 있다. 이러한 상황에서, 클래스 `A`가 기존에 사용하던 클래스 `B`대신, 새로운 클래스 `C`를 사용하려면 클래스 `A`의 코드 또한 변경해 주어야 한다.<br>

이처럼, 두 클래스가 서로 직접적인 관계를 가져, 강한 결합을 이루고 있는 경우, 의존하고 있는 클래스의 코드까지 변경해 주어야 하는, 변경에 불리한 코드가 만들어지게 된다.<br>
<br>

### 인터페이스를 사용하는 경우 
인터페이스를 사용하는 경우, 아래 그림과 같이, 클래스의 선언(설계)와 구현을 분리시키는 것이 가능하다.<br>
<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/73e91fd8-28ae-41ab-aee9-6b34809352b1)<br>
<br>

이러한 경우, 클래스와 클래스간의 직접적인 관계를 인터페이스를 사이로 둔, 간접적인 관계로 만드는 것이 가능하다. 인터페이스를 통해 구현된 클래스의 경우, 다른 클래스와 직접적인 관계를 가지기 보단, 인터페이스를 통한 간접적인 관계를 가지게 된다.<br>

쉽게 말해, 위 그림의 `B`클래스 처럼, 인터페이스라는 껍데기에 둘러싸인다고 표현하는 것이 가능하다. 이 `B`클래스는 인터페이스(껍데기)를 통해, 다른 클래스와 간접적인 관계를 가지는 것이다.<br>

이렇게 인터페이스를 사용하여, 클래스간의 직접적인 관계를 인터페이스를 중간 역할로 둔, 간접적인 관계로 변경하면, 한 클래스의 변경이 관련된 다른 클래스에게 영향을 미치지 않는 독립적인 프로그래밍이 가능해진다.<br>
<br>

이러한 인터페이스를 사용하는 경우의 예시로 작성한 아래 코드를 한번 보도록 하자.<br>
```java
class A {
  public void methodA(I i) {
    i.methodB();
  }
}

interface I {
  public abstract void methodB();
}

class B implements {
  public void methodB() {
    System.out.println("methodB()");
  }
}

/*class C implements {
  public void methodB() {
    System.out.println("methodC()");
  }
}*/

class InterfaceTest {
  public static void main(String[] args) {
    A a = new A();
    a.methodA(new B());
    /*a.methodA(new C());*/
  }
}
```
<br>

위 상황을 그림으로 나타내면 다음과 같이 표현하는 것이 가능하다.<br>
<br>

```java
// ppt그림 삽입
```
<br>

위 경우, 인터페이스를 사용하지 않는 경우와는 다르게, `A`클래스가 `B`클래스의 인터페이스인 `I`와 직접적인 관계를 가지는 것을 알 수 있다. 즉, `B`클래스와는 직접적인 관계를 맺지 않고, 인터페이스 `I`를 통한 간접적인 관계를 맺고 있는 것이다.<br>

이러한 상태에서, `B`클래스를 다른 클래스인 `C`클래스로 변경하는 경우, 어떤일이 발생할까? 이때, `C`클래스는 `B`클래스와 마찬가지로, 인터페이스 `I`를 구현해준 클래스이다.<br>

`A`클래스가 `B`클래스의 껍데기인 인터페이스 `I`와만 직접적인 소통을 하기 때문에, 껍데기가 둘러싸고있는 알맹이인 `B`클래스가 다른 클래스인 `C`클래스로 바뀌어도, `A`클래스에서는 이를 알 수 없을 뿐만 아니라,<br>

이러한 변경은 인터페이스 하고만 직접적인 관계를 가지는 `A`클래스에게는 상관이 없는 일이라 할 수 있다. 때문에, `A`클래스의 코드를 수정하지 않아도 된다.<br>

즉, 아래 그림과 같이 `A`클래스와 직접적인 관계를 갖는 껍데기(인터페이스`I`)는 그대로인 상태로, 알맹이(인터페이스 `I`를 구현한 클래스 `B`, `C`)를 바꾸는 것이다.<br>
<br>

![스크린샷(5)](https://github.com/Yoonsik-2002/java-study/assets/83572199/3d574b0a-69d1-46a9-b414-3c4544be33de)<br>
<br>

또, 인터페이스의 다형성에 의해, 매개변수가 인터페이스 `I`타입인 `A`클래스의 메서드, `methodA()`에는 `I`인터페이스를 구현한 모든 클래스의 인스턴스를 매개변수로 전달해 주는 것이 가능하다.<br>

때문에, `A`클래스는 직접적인 관계를 가지는 인터페이스 `I`를 통해, `I`를 구현한 다른 클래스들을 굳이 코드를 수정하지 않아도 사용하는 것이 가능하게 된다.<br>

이처럼, 인터페이스 `I`를 통해, 서로 간접적인 관계를 가지는 `A`클래스와 `B`클래스의 관계를 두고, 느슨한 결합이라 표현한다. 이 경우, 변경에 유리하며, 유연한 코드를 작성하는 것이 가능하다.<br>
<br>

### 인터페이스의 장점 2. - 개발시간을 단축시키는 것이 가능하다.
```java
// ppt 자료 추가
```
<br>

다음과 같이, `A`클래스가 `B`클래스와 직접적인 관계를 맺고 있는 경우, `A`클래스를 작성하기 위해서는, `B`클래스가 완성될 때 까지 기다려야 한다. 때문에 자치하면, 개발시간이 오래걸릴 수도 있는 경우라 할 수 있다.<br>

반면, 인터페이스를 사용하는 경우는 다르다.<br>
<br>

```java
// ppt 자료 추가
```
<br>

일단, 인터페이스가 작성되면, 이를 사용해서 프로그램을 작성하는 것이 가능하다. 메서드를 호출하는 쪽에서는 메서드의 내용과는 관계없이, 메서드의 선언부만 알면 되기 때문이다.(해당 이름의 메서드에 어떤값을 대입해주어야 하고, 결과로 어떤 값을 반환받을 수 있는가?)<br>

인터페이스는 무엇인가? 메서드의 선언부, 즉, 추상 메서드들을 정렬해 놓은 것이라 할 수 있다. 때문에, 아직 구현되지 않은 인터페이스의 추상 메서드라도, 이를 이용하여 해당 메서드를 호출하는 클래스를 바로 작성하는 것이 가능하다.<br>

이렇게, 메서드의 선언부를 통해, 해당 메서드를 호출하는 클래스를 작성하고 있는 동안, 해당 메서드의 선언부(추상 메서드)를 선언하고 있는 인터페이스를 구현해주는 클래스를 동시에 작성하는 것이 가능하다.<br>
<br>

위 그림의 경우도 똑같다. 클래스 `A`가 인터페이스 `I`를 통해, 클래스 `B`와 간접적인 관계를 맺고 있는 해당 상황에서, 클래스 `A`를 작성하기 위해, 클래스 `B`가 모두 작성될 때까지 기다릴 필요가 없다.<br>

그저, 클래스 `A`는 인터페이스 `I`에 선언되어 있는 추상 메서드(메서드의 선언부)를 이용하여 작성해 나가면 되고, 동시에, 인터페이스 `I`를 구현하는 클래스 `B`를 작성해주면 되는 것이다.<br>

이처럼, 해당 두 작업을 동시에 진행하는 것이 가능하기 때문에, 인터페이스 사용 시, 개발시간을 단축시킬 수 있다는 장점이 있다.<br>
<br>

### 인터페이스의 장점 3. - 표준화가 가능하다. 
프로젝트에 사용되는 기본 틀을 인터페이스로 작성하고, 개발자들에게 해당 인터페이스를 구현하여 프로그램을 작성하도록 함으로써, **보다 일관적이고, 정형화된 프로그램을 개발하는 것이 가능하다.<br>**
<br>

### 인터페이스의 장점 4. - 서로 관계없는 클래스들에게 관계를 맺어줄 수 있다. 
해당 인터페이스의 장점은 게임에 나오는 유닛들을 클래스로 나타내고, 이들의 관계를 상속계층도로 나타낸, 아래 예시를 통해 한번 정리해 보도록 하겠다.<br>
<br>

![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/da218a46-aab4-40c2-bbe9-99f6e369c344)<br>
<br>

위 상속 계층도를 보면, 모든 유닛들의 최고 조상은 `Unit`클래스이고, 유닛의 종류는 지상 유닛(`GroundUnit`), 공중 유닛(`AirUnit`)으로 나뉘는 것을 알 수 있다.<br>

지상 유닛으로는 - `Marine`, `SCV`, `Tank`가 있으며, 공중 유닛으로는 - `DropShip`이 있다.<br>
<br>

이러한 상황에서, `SCV`(건설인부)에게 `Tank`와 `DropShip`과 같은 기계화 유닛을 수리할 수 있는 기능을 제공하기 위해, `repair`메서드를 정의해 보도록 하겠다. 먼저, 다음과 같은 방법을 사용할 수 있을 것이다.<br>
<br>

#### 1) `repair`메서드의 매개변수의 타입을 수리할 기계화 유닛의 타입으로 지정해주는 방법
`repair`메서드의 매개변수의 타입을 수리하고자 하는 기계화 유닛의 타입으로 지정해주는 경우, 아래와 같이 수리할 수 있는 (기계화)유닛의 개수만큼 다른 버전의 오버로딩 된 메서드를 정의해야 한다.<br>
```java
void repair(Tank t) {
  /* Tank를 수리 */
}

void repair(DropShip ds) {
  /* DropShip을 수리 */
}

// 지상 유닛, 장갑차(ArmoredCar)가 추가된 경우
void repair(ArmoredCar ac) {
  /* ArmoredCar를 수리 */
}

...

```
<br>

이처럼, 하나의 `repair`메서드로 하나의 기계화 유닛을 수리하게 되는 경우, 새로운 수리가 가능한 유닛이 추가될 때마다, 매번 메서드를 오버로딩하여 추가해 주어야 한다.<br>

이러한 방식은 비효율적이므로, 해당 상황을 피하기 위해서는, 수리가 가능한 (기계화)유닛들의 공통조상을 찾아, 해당 조상 클래스 타입을 `repair`메서드의 매개변수 타입으로 지정하여, 기계화 유닛들을 `repair`하나의 메서드로 수리할 수 있도록 해야 할 것이다.<br>
<br>

#### 2) `repair` 메서드의 매개변수의 타입을 수리가 가능한 기계화 유닛들의 공통조상으로 하여, `repair`메서드 하나로 여러개의 기계화 유닛들을 수리할 수 있게 해주는 방법
수리가 가능한, 기계화 유닛의 경우, 지상 유닛과 공중 유닛으로 나뉘게 된다. 때문에, 이들의 공통조상의 타입으로 아무리 `repair`메서드의 매개변수 타입을 지정해 주려 해도, 최소한 2개의 다음과 같은 메서드가 필요할 것이다.<br>
```java
void repair(GroundUnit gu) {
  /* 매개변수로 넘겨진 지상 유닛(GroundUnit)을 수리한다. */
}

void repair(AirUnit au) {
  /* 매개변수로 넘겨진 공중 유닛(AirUnit)을 수리한다. */
}
```
<br>

하지만, 해당 방법을 사용하는 경우에도 문제점은 존재한다. `GroundUnit`에는 하위 클래스로, 기계화 유닛이 아닌 `Marine`클래스 또한 포함하고 있다.<br>

`repair`메서드의 매개변수의 타입을 `GroundUnit`로 지정해 주는 경우, 해당 메서드로 `Marine`클래스의 인스턴스가 전달될 수도 있는 위험이 존재한다. 때문에, `repair`메서드의 매개변수의 타입으로 `GroundUnit`은 부적합하다고 할 수 있다.<br>

결국, 현재 상속관계에서는 기계화 유닛만을 공통 자손으로 가지는 이들의 공통조상은 존재하지 않는다고 할 수 있다. 즉, 기계화 유닛들만의 공통점이 존재하지 않아, 모든 기계화 유닛들이 서로 관계가 있는 상황이라고 할 수 없는 것이다.<br>

##### 이때, 인터페이스를 사용하면, 기존의 상속체계를 유지하면서, 관계를 맺어주고 싶은 기계화 유닛 클래스들만의 공통점을 만들어, 서로 관계가 없던 해당 클래스들에게 새로운 관계를 맺어주는 것이 가능하다!
<br>

#### 3) 인터페이스를 사용하여, 기계화 유닛들만의 새로운 관계를 맺어주고, `repair`메서드의 매개변수 타입을 해당 인터페이스로 하여, `repair`메서드 하나로 여러개의 기계화 유닛들을 수리할 수 있게 해주는 방법
자, 이제 인터페이스를 사용하여, 서로 관계가 없던 기계화 유닛들의 새로운 관계를 맺어주도록 하겠다.<br>

인터페이스를 사용하여, 서로 관계가 없던 기계화 유닛들의 새로운 관계를 맺어주기 위해, 다음과 같이 `Repairable`이라는 인터페이스를 생성하고, 해당 인터페이스를 수리가 가능한 기계화 유닛 클래스들이 구현하도록 하였다.<br>
```java
interface Repairable {}

class Tank extneds GroundUnit implements Repairable() {
  // ...
}

class SCV extends GourndUnit implements Repairable() {
  // ...
}

class DropShip extends AirUnit implements Repairable() {
  // ...
}
```
<br>

이렇게, 3개의 기계화 유닛이 모두 `Repairalbe`인터페이스를 구현함으로써, 해당 기계화 유닛 클래스들은 `Repairable`인터페이스를 구현한 클래스라는 공통점이 생겼다. 즉, 아래와 같은 하나의 새로운 관계가 맺어진 것이다.<br>
<br>

![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/c3c6fe56-69c9-4e88-977c-ebcc60ad80c4)<br>
<br>

`Repairable` 인터페이스에 정의된 것은 아무것도 없으며, 단지, 해당 인터페이스를 구현한 클래스의 인스턴스의 타입체크에 사용될 뿐이다.<br>
<br>

또, 아래와 같이`repair`메서드의 매개변수 타입을 `Repairable`인터페이스 타입으로 지정해 주는 경우, 인터페이스를 이용한 다형성에 의해, 해당 매개변수로 `Repairable`인터페이스를 구현한 모든 기계화 유닛 클래스의 인스턴스를 넘겨주는 것이 가능해진다.<br>
```java
repair(Repairable r) {
 // 매개변수로 넘겨받은 기계화 유닛을 수리한다.
}
```
<br>

이로 인해, `repair`메서드 하나로, (`Repairable`인스턴스를 구현한)모든 기계화 유닛을 수리하는 것이 가능하게 된다.<br>

앞으로 새로운 기계화 유닛 클래스가 추가될 때, 해당 클래스가 `Repairable`인터페이스를 구현하도록 하면, 이 클래스 또한 `repair`메서드를 통해 수리가 가능하게 될 것이다.<br>

다음은 해당 내용을 구현한 기계화 유닛 수리 프로그램이다.<br>
**[Ex07_19_RepairableTest.java](https://github.com/Yoonsik-2002/java-study/blob/main/src/chapter_07/Ex07_19_RepairableTest.java)**<br>
<br>

### 인터페이스의 장점 최종 정리
인터페이스의 장점에 대해 마지막으로 최종적으로 정리해보기 위해, 아래 예시를 들어보도록 하겠다.<br>
<br>

![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/46b94d51-2520-4b15-adaa-a87ea79f89d3)<br>
<br>

건물을 표현하는 클래스 `Academy`, `Bunker`, `Barrack`, `Factory`가 있고, 이들의 공통조상인 `Building`이 있다. 이때, `Barrack`클래스와 `Factory`클래스에 아래와 같은 건물을 이동시킬 수 있는 새로운 메서드들을 추가하고자 하는 상황이다.<br>

```java
void liftOff() { /* 내용 생략 */}
void move(int x, int y) { /* 내용 생략 */ }
void stop() { /* 내용 생략 */ }
void land() { /* 내용 생략 */ }
```
<br>

해당 상황에서 주어진 메서드들을 `Barrack`클래스와 `Factory`클래스에 추가할 수 있는 방법으로는 어떤 것들이 있을까?<br>
<br>

### worst case
먼저, 가장 단순하게 생각해 볼 수 있는 방법으로는 해당 메서드들을 `Barrack`클래스와 `Factory`클래스에 따로따로 추가해 주는 방법이 있을 것이다.<br>

하지만, 해당 방법을 사용하는 경우, 똑같은 코드의 중복이 일어난다는 문제가 발생하게 된다. 그렇다고 해서, 코드의 중복을 없애기 위해, 건물을 표현하는 클래스들의 공통 조상인 `Building`클래스에 해당 메서드를 멤버로 추가하여, 자손 클래스들이 이를 상속받게 하는 경우,<br>

코드의 중복은 없앨 수 있지만, 원하지 않는 클래스인 `Academy`와 `Bunker`클래스에도 해당 메서드들이 상속되어버리게 된다. 따라서, 해당 두 가지 방법으로는 요구사항을 100% 충족시키지는 못한다는 것을 알 수 있다.<br>
<br>

### best case
현재 상황에서는 위 메서드들을 추가하고자 하는 `Barrack`클래스와 `Factory`클래스, 이 두 클래스만의 새로운 관계를 맺어주는 것이 필요한 상황이다.<br>

물론, 이 두 클래스에는 `Building`클래스의 공통자손이라는 관계가 존재하지만, 해당 관계에는 우리가 필요로 하지 않는 `Academy`와 `Bunker`클래스가 포함되어 있다.<br>

이러한 상황에서, 서로 관계없는 클래스들의 새로운 관계를 맺어줄 수 있는 인터페이스를 사용할 수 있다.<br>

`Liftable`이라는 새로운 인터페이스를 생성하여, 주어진 메서드를 해당 인터페이스에 추상 메서드로 추가해주고, `Burrack`클래스와 `Factory`클래스가 이를 구현하게 하면 아래와 같은 새로운 관계가 형성되게 된다.<br>
<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/c99d4cd7-a0db-4aca-9920-1ea59ee96ce6)<br>
<br>

이때, `Liftable`인터페이스에 존재하는 추상 메서드들을 `Barrack`클래스와 `Factory`클래스에 각각 다른 내용으로 구현해야 하는 경우에는 그렇게 두 클래스에 각기 다른 내용으로 `Liftable`인터페이스의 추상 메서드들을 구현해주면 된다.<br>

하지만, `Barrack`클래스와 `Factory`클래스에 서로 같은 내용으로 `Lifable`인터페이스의 추상 메서드들을 구현해 주어도 되는 경우, 실제 `Barrack`클래스와 `Factory`클래스에 각각 같은 내용으로 `Liftable`인터페이스의 추상메서드를 구현하는 것은 오히려,<br>

같은 내용의 코드를 중복시키는 꼴이 되어버린다. 선언부와 구현부가 동일한 메서드들이 두 개의 서로 다른 클래스에 정의되어 있는 형태이기 때문이다.<br>

이러한 문제를 해결하기 위해서는 `Liftable` 인터페이스를 작성하고, 해당 인터페이스를 구현하는 클래스인 `LiftableImpl`을 따로 작성해 둔 뒤, 해당 클래스를 `Liftable`인터페이스를 구현하는 `Barrack`클래스와 `Factory`클래스에 포함시켜,<br>

내부적으로 호출하여 사용하도록 하게 하는 방법이 있다. 아래 과정을 잘 보도록 하자.<br>
<br>

###### `Liftable` 인터페이스 작성
```java
interface Liftable {
  void liftOff();
  void move(int x, int y);
  void stop();
  void land();
```
<br>

###### `Liftable`인터페이스를 구현하는 클래스, `LiftableImpl` 작성
```java
class LiftableImpl implements Liftable {
  public void liftOff() { /* 내용 생략 */ }
  public void move(int x, int y) { /* 내용 생략 */ }
  public void stop() { /* 내용 생략 */ }
  public void land() { /* 내용 생략 */ }
}
```
<br>

###### `LiftableImpl`을 `Liftable`인터페이스를 구현하는 `Barrack`클래스와 `Factory`클래스에 포함시켜, 내부적으로 호출하여 사용
```java
/* Barrack 클래스 */
class Barrack extends Building implements Liftable {
  LiftableImpl l = new LiftableImpl();  // LiftableImpl 클래스를 Barrack클래스에 포함시킴

  /* Liftable 인터페이스를 구현한 LiftableImpl 클래스의 메서드들을 내부적으로 호출 */
  public void liftOff() {l.liftOff();}
  public void move(int x, int y) {l.move(x, y);}
  public void stop() {l.stop();}
  public void land() {l.land();}
}

/* Factory 클래스 */
class Factory extends Building implements Liftable {
  LiftableImpl l = new LiftableImpl();  // LiftableImpl 클래스를 Factory클래스에 포함시킴

  /* Liftable 인터페이스를 구현한 LiftableImpl 클래스의 메서드들을 내부적으로 호출 */
  public void liftOff() {l.liftOff();}
  public void move(int x, int y) {l.move(x, y);}
  public void stop() {l.stop();}
  puvlic void land() {l.land();}
}
```
<br>

![스크린샷(3)](https://github.com/Yoonsik-2002/java-study/assets/83572199/a4eb26b0-ec9f-4900-bce4-8195c3f0a406)<br>
<br>

위와 같은 인터페이스를 활용한 방식을 통해, `Liftable`인터페이스의 추상메서드들을 구현하는 같은 내용의 코드를 `Barrack`클래스와 `Factory`클래스에 각각 작성하지 않고, 
`LiftableImpl`클래스 한 곳에서 관리하는 것이 가능해졌다.(중복 제거)<br>

그리고, 이렇게 작성된 `Liftable`인터페이스와 `LiftableImpl`클래스는 후에 다시 재사용될 수 있다.<br>
<br>

### 인터페이스의 (본질적인) 이해
이번에는 인터페이스의 본질적인 측면을 살펴봄으로써, 인터페이스에 대한 더욱 이해를 해보도록 하겠다. 먼저, 인터페이스를 이해하기 위해서는 다음 두 가지 사항을 염두에 두고 있어야 한다.<br>
<br>

> - 클래스를 사용하는 쪽(User)과 클래스를 제공하는 쪽(Provider)이 있다.<br>
> - 메서드를 사용하려는 쪽(User)에서는 사용하려는 메서드의 선언부만 알고 있으면 된다. (메서드의 구현부, 내용은 몰라도 된다.)

<br>

### 두 클래스간의 관계가 직접적인 관계인 경우 `A`-`B`
```java
class A {
  public void methodA(B b) {
    b.methodB();
  }
}

class B {
  public void methodB() {
    System.out.println("methodB()");
  }
}

class InterfaceTest {
  public static void main(String[] args) {
    A a = new A();

    a.methodA(new B());
  }
}
```
<br>

위 코드의 경우, 클래스 `A`가 클래스 `B`의 인스턴스를 생성하고, 해당 인스턴스를 통해, 클래스 `B`에 정의되어있는 `methodB()`를 사용한다.<br>

이러한 경우, *'두 클래스는 서로 직접적인 관계에 있다'* 라고 할 수 있으며, 아래 그림과 같이 표현하는 것이 가능하다.<br>
<br>

![스크린샷(4)](https://github.com/Yoonsik-2002/java-study/assets/83572199/cff93052-5cf3-4196-ae75-1e3bdc8fe1e6)<br>
<br>

이렇게 클래스`A`와 클래스`B`가 서로 직접적인 관계에 있는 경우, 클래스`A`를 작성하기 위해서는 먼저, 클래스`B`가 완성되어 있어야 한다. 즉, 클래스`B`가 완성되어 있지 않은 상황이라면, 클래스`A`를 작성하기 위해서는 클래스`B`가 완성될 때까지 기다려야한다는 것이다.<br>

이러한 이유로, 두 클래스가 서로 직접적인 관계를 가지는 경우, **개발시간이 느려진다는 단점이 생기게 된다.** <br>
<br>

이뿐만이 아니다. 클래스`B`의 `methodB()`의 선언부가 변경되면, 해당 메서드를 사용하는 클래스`A`도 변경해 주어야 한다<br>

이처럼, 두 클래스가 서로 직접적인 관계에 있는 경우, 한 쪽(Provider)이 변경되면, 다른 한 쪽(User)도 변경해 주어야 한다는 단점이 존재한다. 즉,**변경에 유연하지 않다는 뜻이다.** <br>

이렇게, 클래스`A`가 클래스 `B`를 직접 호출하여 사용하는 것과 같이, 두 클래스가 서로 직접적인 관계를 가지는 경우, 개발 시간이 느려지고, 변경에 유연하지 않다는 단점이 생기게 된다.<br>
<br>

### 인터페이스를 사용하여, 두 클래스의 관계를 간접적인 관계로 만들어 주는 경우 `A`-`I`-`인터페이스I를 구현한 클래스(B)`
인터페이스를 사용하면, 클래스`A`가 클래스`B`를 직접 호출하는 것이 아닌, 인터페이스를 매개체로 하여, 클래스`A`가 인터페이스를 통해 클래스`B`의 메서드에 간접적으로 접근하는 것이 가능하다.<br>

이러한 경우, 클래스`B`에 변경사항이 생기거나, 크래스`B`가 같은 내용의 다른 클래스로 대체되어도 클래스`A`는 아무런 영향도 받지 않게 된다. 즉, 변경에 유연한 코드가 되는 것이다.<br>

이렇게 두 클래스의 관계를 간접적인 관계로 만들어주기 위해서는 먼저, 아래와 같이 인터페이스를 사용하여 클래스`B`(Provider)의 선언과 구현을 분리해 주어야 한다.<br>
```java
interface I {
  public abstract void methodB();
}

class B implements I {
  public void methodB() {
    System.out.println("methodB in B class");
  }
}
```
<br>

![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/7a17961c-c281-40d2-8ad2-3d575cdac9bd)<br>
<br>

이제, 클래스`A`는 아래와 같이, 클래스`B`를 직접 사용하여 작성하는 대신, 인터페이스`I`를 사용하여 작성하는 것이 가능하다.<br>
<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/24284602-07d3-4ef6-9795-fb124b09b6f9)<br>
<br>

이렇게 메서드의 매개변수의 타입이 인터페이스 타입인 경우, 그 매개변수에는 해당 인터페이스를 구현한 클래스의 인스턴스를 넘겨주는 것이 가능하다. 이번 예시에서는, 인터페이스`I`를 구현한 클래스`B`의 인스턴스가 해당 매개변수로 전달되는 것이 가능할 것이다.<br>

또, 위와 같은 경우, **클래스`A`를 작성하는데 있어, 클래스`B`가 사용되지 않았다. 이 점에 주목해야 한다.** <br>
<br>

이제, 클래스`A`와 클래스`B`의 관계는 클래스`A`가 클래스`B`를 직접 사용하여 작성되는 `A`-`B`의 직접적인 관계에서, 클래스`A`가 클래스`B`대신 인터페이스`I`를 사용하여 작성됨으로써, `A`-`I`-`인터페이스I를 구현한 클래스(B)`의 간접적인 관계로 바뀌게 되었다.<br>
<br>

![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/47d52dd2-8054-4a52-b157-44821538656f)<br>
<br>

이러한 상태에서는 클래스`A`가 인터페이스`I`를 통해, 클래스`B`에 있는 메서드를 호출하게 된다. 즉, 클래스`A`는 인터페이스`I`하고만 직접적인 관계를 가진다고 할 수 있다.<br>

때문에, 클래스`B`의 변경은 클래스`A`에게 영향을 미치지 않는다. 클래스`A`는 오직 직접적인 관계를 맺고 있는 인터페이스`I`의 영향만을 받는다.<br>
<br>

![스크린샷(2)](https://github.com/Yoonsik-2002/java-study/assets/83572199/195918eb-9442-4d31-9cb0-2132facd70a3)<br>
<br>

**인터페이스 `I`는 실제 구현 내용(클래스`B`와 같이, 인터페이스`I`를 구현한 클래스)을 감싸고 있는 껍데기이며, 클래스`A`는 이 껍데기 안에 어떤 알맹이(인터페이스`I`를 구현한 클래스)들어있는지 몰라도 된다.** <br>

또, 이렇게 인터페이스를 사용하는 경우, 클래스`B`가 완성되지 않았어도, 완성될 때까지 기다리지 않고, 클래스`A`를 작성하는 것이 가능하다. 메서드를 호출하는 쪽에서는 호출하고자 하는 메서드의 선언부만 알면되기 때문이다.<br>

이때, 메서드의 선언부인 추상 메서드를 멤버로 가지는 인터페이스를 사용하면, 이를 토대로, 클래스`A`를 작성하는 것이 가능하게 된다. 그렇기에, 굳이, 클래스`B`가 완성될 때까지 기다릴 필요가 없는 것이다.<br>
(추상 메서드이지만, 해당 메서드가 완성되었다고 가정하고, 클래스 `A`를 작성하는 것이다.)<br>

마지막으로, 다음은 인스턴스를 매개체로 둔, 두 클래스의 간접적인 관계에서, 인터페이스를 구현한 클래스(Provider)의 인스턴스를 인터페이스를 통해 이를 사용하는 클래스(Uer)에게 전달해주는 방식에 따라 두가지 케이스로 나눠 본 예제 프로그램이다.<br>
- ##### [case 1 - 인터페이스를 구현한 클래스의 인스턴스를 매개변수를 통해 동적으로 제공받는 경우](https://github.com/Yoonsik-2002/java-study/blob/main/src/chapter_07/Ex07_20_InterfaceTest1.java)
- ##### [case 2 - 인터페이스를 구현한 클래스의 인스턴스를 제 3의 클래스를 통해 제공받는 경우](https://github.com/Yoonsik-2002/java-study/commit/6e82a56b7cb1921082ec5313ba88336f92a9a1d2)

<br>

### 인터페이스의 디폴트(`default`)메서드와 `static`메서드
원래 기존 인터페이스에서는 추상 메서드만 선언하는 것이 가능하였었다. 하지만, JDK1.8부터 상수, 디폴트 메서드와 `static`메서드도 추가할 수 있게 되었다.<br>
<br>

### `static`메서드
`static`메서드는 클래스 레벨에서 동작하며, 인스턴스와는 독립적으로 실행된다.(해당되는 클래스의 인스턴스를 생성하지 않아도, 클래스 이름을 통해 바로 호출하는 것이 가능)<br>

따라서, `static`메서드는 인스턴스의 상태에 영향을 주지 않고, 실행된다. 이러한 이유로 `static`메서드와 인스턴스 메서드는 서로 충돌이 발생하지 않는다. 이러한 `static`메서드는 같은 클래스에 중복 정의되지 않는 이상, 충돌이 발생하지 않는다.<br>
<br>

이처럼, `static`메서드는 인스턴스와는 관계가 없는 독립적인 메서드이기 때문에, 예전부터 인터페이스에 추가하지 않을 이유가 없었다. 충돌이 발생하지 않기 때문이다.<br>

하지만, JDK1.8 이전엔, Java를 더욱 쉽게 배울 수 있게 하기위해서는 규칙을 단순화할 필요가 있어, 굳이 '인터페이스에 존재하는 메서드는 모두 추상 메서드여야 한다' 라는 규칙을 깨지 않았다. (JDK1.8 이전 인터페이스 : 추상메서드를 정렬해 놓은 것)<br>

때문에, 인터페이스와 관련된 모든 `static`메서드들은 별도의 클래스에 모아 두어야 했었다.<br>
<br>

이에 대한 가장 대표적인 것으로는, `java.util.Collection`인터페이스가 있다. 해당 인터페이스와 관련된 `static`메서드들은 모두 `Collections`라는 클래스에 따로 정의되어 있다. 만약에, 인터페이스에 `static`메서드를 추가할 수 있었다면, `Collections`클래스는 존재하지 않았을 것이다.<br>
<br>

JDK1.8 부터는, 이러한 `staic`메서드를 인터페이스에 포함하는 것이 가능해졌다. 이때, 인터페이스 내의 모든 `static`메서드 역시 마찬가지로, 접근 제어자 `public`이 붙으며, 이는 생략 가능하다.<br>
<br>

### 디폴트 메서드
*'그래, `static`메서드는 클래스(혹은 인터페이스) 내에 중복 정의되지 않는 이상, 충돌을 일으키지 않으니, 인터페이스에 추가되는것이 가능하다고 생각해. 하지만, 일반 메서드 같은 디폴트 메서드를 추가할 수 있게 허용하는 이유는 뭐지?'* 라는 생각이 들 수 있다.<br>

먼저, 인터페이스에서 디폴트 메서드를 추가할 수 있게 해준 이유에 대해 설명해 보도록 하겠다.<br>
<br>

### 인터페이스에 디폴트 메서드를 추가할 수 있도록 허용한 이유
인터페이스가 변경되지 않으면 좋겠지만, 아무리 인터페이스의 설계를 잘 해도, 언젠가 변경은 발생하기 마련이다.<br>

만약에, JDK1.8 이전에 기존에 설계하여 작성해 둔 인터페이스에 새로운 메서드를 추가해야 하는 상황이 발생하였다고 해 보자. 이때, 새롭게 추가하는 메서드는 추상 메서드일 것이다. 이것이 문제가 된다.<br>

해당 인터페이스를 구현한 클래스의 경우, 인터페이스에 새롭게 추가된 추상 메서드를 또 구현해 주어야 한다. 그렇지 않으면, 새롭게 추가된 추상 메서드를 그대로 포함하고 있는 추상 클래스가 되어버리기 때문이다.<br>

인터페이스를 구현하는 클래스는 해당 인터페이스가 정의한 규약을 준수해야 한다. 따라서, 인터페이스의 모든 추상 클래스를 구현해 주어야 한다.<br>
<br>

이러한 상황에서 만약, 새로운 추상메서드를 추가해준 인터페이스를 구현하고 있는 클래스가 여러개라면? 이러한 클래스를 하나하나 찾아, 새롭게 추가한 추상 클래스들을 모두 구현해 주어야 할 것이다.<br>

이처럼, 조상 클래스에 새로운 메서드를 추가하는 것은 별 일이 아니지만, 인터페이스의 경우는 보통 큰 일이 아니라 할 수 있다.<br>

이러한 문제를 해결해 주기 위해, JDK1.8 부터는 디폴트 메서드(default method)라는 것을 고안하여, 사용할 수 있도록 하였다. 디폴트 메서드는, 추상 메서드의 기본적인 구현을 허용하는 메서드로, 메서드의 구현부가 작성되어 구현된 완성된 메서드이기 때문에,<br>

이러한 디폴트 메서드를 인터페이스에 추가해준다고 해도, 기존에 해당 인터페이스를 구현하고 있던 클래스들에서 따로 구현해주지 않아도 된다. 즉, 조상 클래스에 새로운 메서드를 추가한 것과 동일해 지는 것이다.<br>
<br>

이러한 디폴트 메서드 앞에는 `default`키워드가 붙으며, 디폴트 메서드도 마찬가지로, 접근제어자 `public`이 붙는다. 그리고, 이러한 특성은 인터페이스의 모든 디폴트 메서드에 예외없이 적용되는 사항이므로, 생략이 가능하다.<br>

또, 디폴트 메서드는 메서드의 선언부만 존재하는 추상 메서드와는 달리, 구현부(몸통 `{}`)이 존재한다.<br>
<br>

### 디폴트 메서드의 충돌
메서드의 이름은 같지만, 서로 구현부가 다른 경우, 메서드의 충돌이 일어난다.<br>

인터페이스의 다중 상속이 가능하였던 이유도, 인터페이스를 구성하는 추상 메서드에는 메서드의 구현부가 존재하지 않아, 메서드간 충돌이 일어나지 않기 때문이라 할 수 있다.<br>

하지만, JDK1.8 부터, 메서드의 구현부가 존재하는 디폴트 메서드의 사용을 허가 함으로써, 인터페이스 사용 시, 새롭게 추가된 디폴트 메서드가 기존 메서드와 이름이 중복되어, 충돌문제가 발생할 수도 있는 가능성이 생기게 되었다.<br>

이렇게 발생할 수 있는 충돌을 해결하는 규칙은 다음과 같다.<br>
<br>

> ##### 여러 인터페이스의 디폴트 메서드 간의 충돌
> - 해당 인터페이스를 구현하는 클래스에서 디폴트 메서드를 오버라이딩 해준다.<br>
>
> ##### 디폴트 메서드와 조상 클래스의 메서드 간의 충돌
> - 디폴트 메서드는 무시되고, 조상 클래스의 메서드가 상속된다.<br>

<br>

![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/cfa0e26d-696c-4dbe-a0af-bfd43ebf24b0)<br>
<br>

관련 예시코드는 다음과 같다.<br>
##### [디폴트 메서드의 충돌 예시코드](https://github.com/Yoonsik-2002/java-study/commit/fd7666de89006af1e9c3f0d9e7db9e471b192953)

<br>
