## 객체지향과 java에 대한 개념

### 객체
**객체**란 실세계 우리 주변의 모든 것(명사형)을 뜻합니다. 예를 들어 TV, 의자, 자동차 등...<br>
객체는 각자 자신만의 고유한 특성(state)과 행동(behavior)을 지니고, 다른 객체들과 서로 상호작용하며 존재합니다.<br>
실세계는 이러한 객체들의 집합이라고도 할 수 있습니다.

### 객체지향 언어
**객체지향 언어**는 위에서 설명한 실세계의 객체들을 프로그램 내에 표현하기 위해 **클래스와 객체** 개념을 도입하였습니다.

### 객체지향 언어의 특성
- #### 캡슐화
  캡슐화란 객체를 캡슐로 싸서 내부를 보호하고 볼 수 없게 하는 것으로, 외부 접근으로부터 내부를 보호하고, 노출되어선 안되는 정보를 은닉합니다.</br>

  > 실세계 객체의 캡슐화 사례 -<br>
    [캡슐과 알약], [TV케이스와 TV], [사람의 피부,근육과 장기,뇌]</br>

  객체는 캡슐화가 기본 원칙이지만, 외부와의 접속을 위해 몇 부분만 공개 노출합니다.<br>
  실세계와 달리 자바에서의 객체는 **클래스(class)라는 캡슐**을 사용하며, 해당 클래스의 속성은 필드(멤버변수)와 메소드(멤버함수)로 구성됩니다.<br>
  이때 멤버변수는 객체의 특성(state)을 나타내고, 멤버함수는 객체의 행동(behavior)을 나타냅니다.<br>
</br>

- #### 상속
  실세계에서 상속은 상위 개체의 속성이 하위개체에 물려져서, 하위개체가 상위개체의 속성을 모두 가지는 관계를 뜻합니다.<br>
  ![](https://velog.velcdn.com/images/yoonsik123/post/fdaf144b-86ff-4659-83fa-2acd284c5bf2/image.png)<br>
  자바의 상속은 자식 클래스(sub class)가 부모 클래스(super class)의 속성을 물려받고 기능을 추가하여 확장(extends) 하는 개념입니다.</br>
  상속은 슈퍼클래스의 필드와 메소드를 물려받아 코드를 재사용함으로, 코드 작성에 드는 시간과 비용을 줄입니다.<br> 
</br>

- #### 다형성
  다형성은 같은 이름의 메소드가 클래스 혹은 객체에 따라 다르게 동작하도록 구현되는 것을 말합니다.<br>
  상속 관계의 다형성을 보여주는 사례로는 다음 2가지가 있습니다.</br>
  
     - **메소드 오버라이딩(overriding)**<br>
     슈퍼클래스에 구현된 메소드를 서브클래스에서 동일한 이름으로 자신의 특징에 맞게 다시 구현하는 것</br>
     - **메소드 오버로딩(overloading)**<br>
     클래스 내에서 이름이 같지만 서로 다르게 동작하는 메소드를 여러개 만드는 것
<br><br>


## 객체와 인스턴스 

- #### 인스턴스화(instantiate)
  인스턴스화(instantiate)는 클래스로부터 객체를 만드는 과정을 의미하며, 이렇게 **클래스로부터 만들어진 객체를 인스턴스(instant) 라고 한다.**<br>

  **`클래스`** ➡️ **`인스턴스화`** ➡️ **`인스턴스(객체)`**

- #### 인스턴스(instance)와 객체(object)
  객체와 인스턴스는 같은 의미이지만, 엄밀히 따지면 다음과 같은 차이점이 있다. 객체는 **모든 인스턴스를 대표하는 포괄적인 의미**를 가지고 있으며, 인스턴스는 **어떤 클래스로부터 만들어진 객체인지를 강조**하는 의미를 갖는다.<br>

  이 둘은 같은 의미이므로, 철저하게 구분할 필요는 없지만, 아래와 같이 문맥에 따라 구분하여 사용하는 것이 좋다.<br>
  > 👨🏻‍💻 OLED_TV는 **객체**이다.<br>

  > 👩🏻‍💻OLED_TV는 TV클래스의 **인스턴스**이다.<br>
    
<br><br>


## 소스파일 내에 클래스 작성 규칙

일반적으로는, 하나의 소스파일에는 하나의 클래스를 작성한다. 하지만 소스파일 내에 두개 이상의 클래스를 작성하는 것도 가능하다. 하지만 다음과 같은 규칙이 존재한다. <br>

- #### 규칙1 - 소스파일 내에 public class가 존재하는 경우
  소스파일 내에 `public class`가 존재한다면, 해당 소스파일의 이름과 `pulic class`의 이름은 같아야 한다.<br>
  
  ```java
  [Example01.java]
  
  class Tv{
    ...
  }

  public class Example01 {
    public static void main(String[] args) {
      ...
    }
  }
  ```



- #### 규칙2 - 소스파일 내에 public class가 존재하지 않는 경우 
  소스파일 내에 `public class`가 존재하지 않는다면, 해당 소스파일의 이름은 소스파일 내 어떤 클래스의 이름으로 해도 상관없다.<br>

  ```java
  [Example02.java]
  
  class Car {
    ...
  }

  class Tv {
    ...
  }

  class Example02 {
    public static void main(String[] args) {
      ...
  }
  ```

소스파일(.java)과는 달리, 클래스파일(.class)은 클래스 마다 하나씩 만들어지기 때문에, 소스파일 `Example02.java`를 컴파일 하면, 다음과 같이 클래스 파일 3개가 생성된다.<br>
> Car.class

> Tv.class

> Example02.class

<br><br>


## 객체의 생성과 사용
우리는 객체를 생성할 때 해당 객체의 설계도 역할을 하는 클래스를 선언한 뒤, 이 클래스로부터 인스턴스(객체)를 생성한다.<br>
객체를 생성하는 일반적인 방법은 다음과 같다. 

```java
클래스명 변수명; // 클래스로부터 생성된 인스턴스를 참조하는 클래스 타입의 참조변수를 선언한다. 
변수명 = new 클래스명(); // new 연산자에 의해 클래스의 인스턴스가 메모리의 빈 공간에 생성되고, 생성된 인스턴스의 주소값이 참조변수에 저장된다.
```
이렇게 생성된 객체의 주소값을 참조변수에 저장하는 이유는 Java에서는 이 참조변수를 통해 객체에 접근하여 해당 객체를 사용<br>
(멤버변수 초기화, 멤버함수 호출)하기 때문이다. 객체를 사용하는 일반적인 방법은 다음과 같다.<br>

```java
참조변수.객체의 멤버변수명 = 초기화 하고싶은 값; // 참조변수를 통해 (주소값이 저장된) 객체에 접근한뒤. 연산자를 통해 초기화 하고 싶은 객체의 멤버변수를 지정하고, 해당 멤버변수의 값을 초기화 해준다.
참조변수.객체의 멤버함수명(); // 참조변수가 가리키고 있는 객체의 호출하고 싶은 멤버함수를 . 연산자를 통해 지정하여 해당 멤버함수를 호출한다.  
```


### 클래스로부터 인스턴스를 생성하고 해당 인스턴스의 속성과 메서드 사용하기
```java
class Tv {
  // Tv 객체의 속성(멤버변수)
  String manufacturer;
  int price;
  int channel;
  boolean power;

  // Tv 객체의 기능(멤버변수)
  void power() { power = !power; }
  void channelUp() { channel++; }
  void channelDown(){ channel--; } 
}

public class Ex06_2 {
  public static void main(String[] args){
    Tv oled_tv;
    oled_tv = new TV();

    oled_tv.manufacturer = "LG";
    oled_tv.channel = 6;
    oled_tv.channelUp();
    oled_tv.channelDown();
    
    System.out.println("현재 채널은 + oled_tv.channel + "입니다.");
}
```

다음은 클래스의 선언과 해당 클래스로부터의 인스턴스 생성과 사용울 다루는 아주 간단한 코드이다.<br>
인스턴스의 생성부터 생성된 인스턴스를 사용하는 과정을 단계별로 살펴보도록 하겠다.<br>

- #### 객체의 생성
  **1) `Tv oled_tv;`**<br>
  `Tv`클래스 타입의 참조변수 `oled_tv`를 선언한다. 메모리에 참조변수 `oled_tv`를 위한 공간이 생성 된다.<br>
  이 참조변수 `oled_tv`는 Tv 클래스의 인스턴스의 주소값을 저장하고, 이 `oled_tv` 를 통해 Tv클래스의 인스턴스에 접근할 수 있게된다.<br>
  
  **2) `oled_tv = new Tv();`**<br>
  Java에서는`new`연산자를 이용해 클래스의 인스턴스를 생성할 수 있다. 위는 `new`연산자로 `Tv`클래스의 인스턴스를 메모리의 빈 공간에 생성하고
  이때, 해당 객체의 멤버변수들은 각 자료형에 해당하는 기본값으로 초기화 된다.<br>
  
  생성된 인스턴스의 주소값을 참조변수 `oled_tv`에 저장하는 코드이다.<br>
  
  이 시점부터 위에서 말한 참조변수(`oled_tv`)를 통한 클래스(`Tv`)의 인스턴스에 접근이 가능하게 된다. **인스턴스를 다루기 위해서는 반드시 참조변수가 필요하다!**<br>

- #### 객체의 사용
  **3) `oled_tv.channel = 6;`**<br>
  참조변수 `oled_tv`가 가리키고 있는 객체의 멤버변수들 중, `channel`이라는 멤버변수를 `.` 연산자를 통해 지정하고, 해당 멤버변수를<br>
  6으로 초기화 해준다.<br>
  (`oled_tv`가 가리키고 있는 객체의 멤버변수 `channel`에 6이 저장됨)<br>
  
  **4) `oled_tv.channelUp();`**<br>
  참조변수 `oled_tv`가 가리키고 있는 객체의 멤버함수 `channelUp()`을 `.` 연산자로 지정하여 해당 멤버함수를 호출한다.<br>
  (`oled_tv`가 가리키고 있는 객체의 멤버함수 `channelUp()`이 실행됨)<br>

  **5) `System.out.println("현재 채널은" + oled_tv.channel + "입니다.");`**<br>
  참조변수 `oled_tv`가 가리키고 있는 객체의 멤버변수 `channel`에 저장되어 있는 값을 출력하기 위해 `oled_tv.channel`을 사용하였다.<br><br>
  
객체의 생성부터 사용까지의 과정을 단계별로 정리해 보았다. 이를 통해 알 수 있는 점은 다음과 같다.<br>
> **객체는 해당 객체의 주소값을 저장하고 있는(해당 객체를 가리키고 있는) 참조변수를 통해서만 다룰 수 있으며, <br>
> 참조변수의 타입(클래스)는 객체의 타입과 같아야 한다!**

<br><br>


## 객체배열(Array of Objects)
이전에는 단순히 객체의 생성과 이용, 즉 하나의 객체를 생성하여 사용하는 객체에 대한 기본적인 내용을 다뤄 보았다.<br>

그렇다면, 하나가 아닌 많은 수의 객체를 다루기 위해서는 어떻게 해야 할까?<br>
바로 객체배열(Array of Objects)을 사용하면 된다. 객체 배열은 말 그대로 여러개의 객체들을 배열로 다루는 것이다.<br>
하지만 객체배열을 이해하는데 있어, 주의해야 할 점이 존재한다.<br>
바로, **객체배열의 각 요소들에는 객체 자체가 저장되는 것이 아니라, 해당 객체를 참조하고 있는 (해당 객체의 주소값을 저장하고 있는) 각 객체의 참조변수들이 저장되는 것이다.**<br>
즉, 각 객체의 참조변수(객체의 주소값)들이 저장되어 있는 배열이라고 할 수 있겠다. <br>
> **`객체배열` = `각 객체의 참조변수들을 하나로 묶은 참조변수 배열`**<br>

### 객체배열의 선언과 생성
객체배열의 선언과 생성 방법은 일반배열의 선언과 생성 방법과 비슷하다.<br>
예시를 통해 알아보도록 하자.<br>
먼저, 다음과 같이 `Car` 클래스가 미리 생성되어 있다고 가정해 보겠다. 

```java
package chapter_06;

public class Car {
    String name;
    String price;
    
    public Car(String name, String price) {
        this.name = name;
        this.price = price;
    }
}
```

- #### 일반배열과 객체배열의 선언과 생성 비교 
  |일반배열|객체배열|
  |:------:|:------:|
  |`타입[] 배열이름 = new 타입[배열의 길이]`|`클래스명[] 배열이름 = new 클래스명[배열의 길이]`|
  
  위 표를 보면 알 수 있듯이, 객체배열을 생성하기 위해서는 **`클래스명[] 배열이름 = new 클래스명[배열의 길이]`** 형식을 사용하면 된다.<br>
  그럼, `Car` 클래스 타입의 객체배열 `car_arr`을 만들어 보겠다.<br>
   ```java
   Car[] car_arr = new Car[3];
   ```
   
   해당 코드를 통해 길이가 3인 객체배열 `car_arr`이 생성되었다.<br>
   이렇게 처음 객체 배열을 생성하면 해당 객체배열의 각 요소들(`car_arr[0]`, `car_arr[1]`, `car_arr[2]`)은 모두 참조변수의 <br>
   기본값인 `null`로 자동 초기화 된다.<br>
   이제 객체배열 `car_arr`에 3개의 객체, 정확히는 3개의 객체의 주소를 저장할 준비가 된 것이다.<br>
   
 - #### 객체배열에 객체 저장하기 (객체를 생성하여 객체배열의 각 요소에 저장하기)
   위 설명을 보면 알 수 있듯이, 객체배열을 생성하면 여러개의 객체들을 다루기 위한 기본값 `null`로 자동 초기화 된 참조변수들<br>
   (`car_arr[0]`, `car_arr[1]`, `car_arr[2]`)이 만들어지는 것이지, 객체가 생성되어 각 요소들에 저장되지는 않는다.<br>
   때문에 우리는 **객체배열을 생성한 뒤, 객체를 생성하여 해당 객체배열의 각 요소(참조변수)에 저장해 주어야 한다!**<br>
   
   - #### 객체배열의 요소 하나하나에 객체를 생성하여 저장하기
     ```java
     Car[] car_arr = new Car[3]; // 객체배열 car_arr 생성(기본값 null 로 자동 초기화 된 객체를 다루는 참조변수 3개가 생성됨 car_arr[0], car_arr[1], car_arr[2])
   
     // 객체를 생성하여 객체배열의 각 요소(참조변수)에 저장 (참조변수 = new 클래스(생성자의 매개변수) 형식)
     car_arr[0] = new Car("porsche 911", "149,900,000");
     car_arr[1] = new Car("mclaren 720s", "359,000,000");
     car_arr[2] = new Car("lamborghini huracan evo", "299,000,000");
     ```
   
   - #### 배열의 초기화 블럭을 사용하여 객체 저장하기
     ```java
     Car[] car_arr = new Car[]{new Car("porsche 911", "149,900,000"), new car("mclaren 720s", "359,000,000"), new Car[]("lamborghini huracan evo", "299,000,000")};
     
     // 배열의 초기화 블럭 사용 시, new Car[] 생략 가능(단, 배열의 선언과 초기화를 동시에 하는 경우에만 가능)
     Car[] car_arr = {new Car("porsche 911", "149,900,000"), new car("mclaren 720s", "359,000,000"), new Car[]("lamborghini huracan evo", "299,000,000")};
     ```
     
   - #### for문을 이용하여 객체 저장하기 
     다뤄야할 객체의 수가 많은 경우, for문을 사용하여 저장이 가능하다.<br>
     ```java
     Car car_arr = new Car[30];
     
     for (int i = 0; i < car_arr.length; < i++) {
       System.out.println("Input the name of the car : ");
       String name = scanner.nextLine();
       System.out.println("Input the price of the car : ");
       String price = scanner.nextLine();
       
       car_arr[i] = new Car(name, price);
     }
     ```
<br><br>


## 클래스의 정의 - 데이터와 함수의 결합
이전에 클래스에 대한 설명을 *'클래스는 객체를 찍어내기 위한 틀 이며, 속성과 기능으로 정의된다'* 라고 했었다.<br> 
이는 객체지향이론의 관점에서 봤을때의 클래스의 정의이다.<br>

프로그래밍적인 관점에서 봤을때의 클래스의 정의에 대해 설명해 보도록 하겠다.<br>

프로그래밍 언어에 있어, 데이터 저장형태의 발전은 다음과 같이 이루어졌다.<br>
> **1. 변수 -** 하나의 데이터를 저장할 수 있는 공간<br>
> **2. 배열 -** 자료형이 같은 여러개의 데이터들을 하나로 묶어서 저장할 수 있는 공간<br>
> **3. 구조체 -** 서로 연관성을 띄지만 자료형이 다른 데이터들을 자료형에 상관없이 하나로 묶어서 저장할 수 있는 공간<br>
> **4. 클래스 -** 서로 관계가 깊은 데이터와 함수의 결합<br>

프로그래밍에 있어, 주로 함수는 데이터를 대상으로 작업을 수행하기 때문에 데이터와 함수는 서로 관계가 깊다.<br>
이를 위해 객체지향 언어에서는 데이터와 함수를 결합하여 하나의 클래스로 정의할 수 있게 하였다.<br>
**서로 연관성을 띄는 데이터들을 정의하고 이들을 처리하는 함수들까지 함께 정의한 것이 바로 프로그래밍적인 관점에서의 클래스 이다.**

<br><br>


## 클래스의 정의 - 사용자 정의 타입(user-defined type)
사용자 정의 타입은 프로그램 언어가 기본적으로 제공하는 기본 자료형 외에 프로그래머가 서로 관련 있는 변수들을 묶어서,<br>
하나의 새로운 자료형으로 추가한 것 이다.<br>

Java와 같은 객체지향 언어에서는 '클래스'가 바로 사용자 정의 타입이다.
