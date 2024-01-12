# JAVA의 정석 연습문제 - Chapter7
JAVA의 정석 Chapter7의 연습문제 풀이를 정리 해보도록 하겠다.<br>
<br>

## 💻 7-1
```java
package _01_Exercise._01_chapter_07;

class SutdaCard {
    int num; 
    boolean isKwang;
    
    SutdaCard(int num, boolean isKwang){
        this.num = num;
        this.isKwang = isKwang;
    }
    
    SutdaCard() {
        this(1, true);
    }
    
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

class SutdaDeck {
    final int CARDNUM = 20;
    
    SutdaCard[] cards = new SutdaCard[CARDNUM];
    
    SutdaDeck () {
        int i;
        
        for(i = 0; i < 20; i++) {
            /* cards 객체 배열의 0 ~ 9 index */
            if(i < 10) {
                /* 카드의 번호가 1, 3, 8인 경우 */
                if(i == 0 || i == 2 || i == 7) {
                    cards[i] = new SutdaCard((i+1), true);
                } 
                
                else {
                    cards[i] = new SutdaCard((i+1), false);
                }
            }
            
            /* cards 객체 배열의 10 ~ 19 index */
            else {
                cards[i] = new SutdaCard((i-9), false);
            }
        }
    }
}

class Exercise7_1 {
    public static void main(String[] args) {
        SutdaDeck deck = new SutdaDeck();
        
        for(int i = 0; i < deck.cards.length; i++) {
            System.out.print(deck.cards[i] + ", ");
        }
        
        System.out.println();
    }
}
```

###### [실행결과]
![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/172565a7-375a-414b-a911-4ab5039a232f)<br>

---

<br><br>

### 💻 7-2
```java
package _01_Exercise._01_chapter_07;

/* 섯다 카드를 표현하는 SutdaCard1 클래스 */
class SutdaCard1 {
    int num;
    boolean isKwang;
    
    SutdaCard1(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }
    
    SutdaCard1() {
        this(1, true);
    }
    
    public String toString() {
        return num + (isKwang ? "K" : ""); 
    }
}

/* SutdaCard1클래스의 카드 객체를 cards객체 배열로 모아서 관리하는 SutdaDeck1 클래스 */
class SutdaDeck1 {
    final int CARD_NUM = 20;
    
    SutdaCard1[] cards = new SutdaCard1[CARD_NUM];
    
    SutdaDeck1() {
        for (int i = 0; i < cards.length; i++) {
            if(i < 10) {
                if(i == 0 || i == 2 || i == 7) {
                    cards[i] = new SutdaCard1((i+1), true);
                }
                
                else {
                    cards[i] = new SutdaCard1((i+1), false);
                }
            }
            
            else {
                cards[i] = new SutdaCard1((i-9), false);
            }
        }
    }
    
    void showCards() {
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i] + ", ");
        }
    }
    
    void shuffle() {
        for(int i = 0; i < 30; i++) {
            int rand_index = (int)(Math.random() * 20);
            
            SutdaCard1 temp = cards[0];
            cards[0] = cards[rand_index];
            cards[rand_index] = temp;
        }
    }
    
    SutdaCard1 pick() {
        int rand_index = (int)(Math.random() * 20);
        
        return cards[rand_index];
    }
    
    SutdaCard1 pick(int index) {  // pick() 메서드를 오버로딩
        return cards[index];
    }
}

class Exercise7_2 {
    public static void main(String[] args) {
        SutdaDeck1 deck = new SutdaDeck1();

        deck.showCards();  // 전체 Card 출력
        System.out.println();
        
        System.out.println(deck.pick(0));  // 첫 번째 Card 출력
        
        System.out.println(deck.pick());  // 랜덤 pick한 Card 출력
        
        deck.shuffle();  // Card 섞기
        deck.showCards();  // 섞인 Card 출력
        System.out.println();
        
        System.out.println(deck.pick(0));  // 첫 번째 Card 출력
    }
}
```

###### [실행 결과]
![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/345af631-126c-4ef0-93b8-c6ab43f1d097)<br>
<br>

### 📑 Review
- ### toString()메서드를 오버라이딩한 클래스의 객체를 `PrintStream`클래스의 출력 관련 메서드로 출력하는 경우
  Object클래스의 toString()메서드는 객체의 문자로 된 표현을 문자열 형태로 리턴해준다.<br>
    
  PrintStream 클래스의 출력 관련 메서드(print, printf, println ...)를 통해 어떠한 클래스의 객체를 출력해주는 경우, 내부적으로 컴파일러에 의해 자동으로 호출된다.<br>
  
  아래 코드와 같이 PrintStream 클래스의 출력 관련 메서드로 SutdaCard1 클래스의 객체를 출력하는 경우를 한번 보도록 하자.<br>

  ```java
  class SutdaCard1 {
    // ...
    public String toString() {
        return num + (isKwang ? "K" : ""); 
    }
  }

  class SutdaDeck1 {
  // ...
      void showCards() {
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i] + ", ");  // cards[i] - 객체 배열 cards의 i 번째 인덱스에 저장되어 있는 SutdaCard1 클래스의 객체.
        }
    }
  ```
  <br>
  
  SutdaCard1 클래스에는 toString()메서드가 오버라이딩을 통해 해당 클래스에 맞게 재정의되어 있다.<br>

  SutdaCard1 클래스에서 toString()메서드를 오버라이딩 하였기 때문에, SutdaCard1클래스의 객체(`cards[i]`)를 출력할 때는, SutdaCar1클래스에서 오버라이딩하여 정의된 toString() 메서드가 호출되게 된다.<br>
    
  이처럼, 어떠한 클래스에서 toString()메서드를 오버라이딩하여 재정의 한 경우, 해당 클래스의 객체를 PrintStream 클래스의 출력 관련 메서드로 출력하면 **해당 클래스에서 오버라이딩한 toString() 메서드가** 컴파일러에 의해 내부적으로 호출되게 된다.<br>

---

<br><br>

### 💻 7-5
```java
class Product
{
  int price;
  int bonusPoint;

  product(int price) {
    this.price = price;
    bonusPoint = (int)(bonusPoint/10.0);
  }
}

class Tv extends Product {
  Tv() {}

  public String toString() {
    return "Tv";
  }
}

class Exercise7_5 {
  public static void main(String[] args) {
    Tv t = new Tv();
  ]
}
```
<br>

### 📑 Review
- ### 조상 클래스로부터 상속을 받는 자손클래스의 생성자의 작성방법
  #### 조상 클래스와 자손 클래스의 포함관계
  자손 클래스는 조상 클래스의 멤버들을 상속받아, 포함하게 된다. 때문에, 자손 클래스는 조상 클래스를 포함 및 확장한 개념이라 할 수 있다.<br>
  
  이러한 이유로, 자손 클래스의 인스턴스는 조상 클래스의 인스턴스를 포함한 형태를 가진다.<br>
  
  다형성을 통해 조상 클래스 타입의 참조변수로 자손 클래스의 인스턴스를 참조하는 것이 가능한 이유도 여기에 있다. 조상 클래스 타입의 참조변수를 통해서는, 자손 클래스의 인스턴스가 포함하고 있는 조상 클래스의 멤버를 사용하는 것이 가능하다.<br>
  <br>

  #### `super`키워드를 통한 자손 클래스의 생성자 에서의 조상 클래스의 생성자의 명시적 호출
  이렇게 조상 클래스로부터 상속을 받는 자손 클래의 생성자에서는 반드시 조상 클래스의 생성자를 첫 줄에서 명시적으로 호출해 주어야 한다. 이때, 자손 클래스에서 조상 클래스의 생성자를 호출하기 위해 사용되는 키워드가 바로 `super`키워드 이다.<br>

  이렇게 해주어야지만, 자손 클래스의 인스턴스를 생성할 때 조상 클래스의 생성자가 먼저 호출되어, 초기화 작업이 먼저 수행되고, 그 후에 자손 클래스인 `Tv`클래스의 인스턴스의 초기화 작업이 이루어지게 된다. <br>
  <br>

  ![스크린샷(6)](https://github.com/Yoonsik-2002/java-study/assets/83572199/80161d75-da2c-44c8-86ba-4cffb46a1079)<br>
  <br>

  #### 조상 클래스의 인스턴스의 초기화가 자손 클래스의 인스턴스의 초기화보다 먼저 이루어져야 하는 이유
  이처럼 조상 클래스의 인스턴스의 초기화가 자손 클래스의 인스턴스의 초기화보다 먼저 수행되어야 하는 이유는, 조상 클래스로부터 상속을 받는 자손 클래스가 조상 클래스의 멤버를 활용하여 인스턴스를 초기화 할 수도 있기 때문이다.<br>

  인스턴스 멤버의 경우, 해당 클래스의 인스턴스의 생성이 이루어진 후에 사용하는 것이 가능하기 때문에, 자손 클래스의 인스턴스가 조상 클래스의 멤버를 사용하여 초기화 되는 경우, 반드시 먼저 조상 클래스의 인스턴스가 생성되어 있어야 한다.<br>
  <br>

- ### 위 코드를 어떻게 수정해주면 좋은가?
  조상 클래스인 `Product`클래스의 경우, 매개변수가 있는 생성자는 존재하지만, 기본 생성자는 존재하지 않는다.<br>

  기본적으로 자바에서는, 자손 클래스의 생성자를 호출하면, 조상 클래스의 기본 생성자가 자동으로 호출되게 된다.<br>

  하지만, `Product`클래스와 같이, 조상 클래스에 매개변수가 있는 생성자는 존재하지만, 기본 생성자는 존재하지 않는 경우, 이러한 기본 생성자의 자동 호출이 일어나지 않기 때문에, 자손 클래스의 생성자에서 조상 클래스의 생성자를 따로 명시적으로 호출해 주어야 한다.<br>
  <br>
  
  이처럼 자손 클래스에서 조상 클래스의 생성자를 명시적으로 호출해야 하는 경우, 사용하는 키워드가 바로 `super()`키워드이다.<br>

  `super()`에 호출하고자 하는 조상 클래스의 생성자의 매개변수에 들어갈 값을 전달해주면, 해당되는 조상 클래스의 생성자를 호출하는 것이 가능해진다.<br>

  또, 이 `super()`키워드는 자손 클래스의 생성자의 첫 번째 줄에 작성해 주는데, 이는 자손 클래스의 인스턴스를 초기화하는데 있어, 조상 클래스의 인스턴스 멤버를 사용하는 경우도 존재하기 때문이다.<br>

  인스턴스 멤버는 해당되는 클래스의 인스턴스가 생성된 뒤에 사용이 가능하기 때문에, 조상 클래스의 인스턴스의 생성 및 초기화가 먼저 이루어져야 한다고 할 수 있다. 이러한 이유로, `super()`키워드는 자손 클래스의 생성자의 맨 첫 번째 줄에 작성한다.<br>
  <br>
  
  자, 위의 코드가 정상적으로 작동하도록 만들어 주기 위히서는 아래와 같이 수정해 주면 좋을 것이다.<br>

  ```java
  // ...

  class Tv extends Product {
    Tv() {
      super(1200); // 조상 클래스의 생성자 Product(int price) 호출
    }

    public String toString() {
      return "Tv";
    }
  }
  ```
  <br>
  
---

<br><br>

### 💻 7-7
```java
class Parent {
  int x = 100;

  Parent(int x) {
    this.x = x;
  }

  Parent() {
    this(200);
  }

  int getX() {
    return x;
  }
}

class Child extends Parent {
  int x = 3000;

  Child(int x) {
    this.x = x;
  }

  Child() {
    this(1000);
  }
}

class Exercise7_7 {
  public static void main(String[] args) {
    Child c = new Child();

    System.out.println("x = " + c.getX());
  }
}
```
<br>

### 📑 Review
- ### 조상 클래스의 기본 생성자의 자동 호출에 대한 정리
  **Java에서 생성자가 호출될 때, 기본적으로 자동으로 super클래스의 기본생성자가 호출된다.** <br>

  즉, `Child`클래스의 인스턴스를 생성하는 과정에서 `Child`클래스의 생성자가 호출되면, 자동으로 super클래스인 `Parent`클래스의 기본 생성자가 호출되는 것이다.<br>

  이때, 마침 `Parent`클래스에 기본 생성자가 존재하기에, 이러한 기본 생성자의 자동 호출이 이루어지게 된다. 만약, 이전에 정리한 `7-5`번의 `Product`클래스와 같이, 클래스 내에 매개변수가 있는 생성자만 존재하고 기본 생성자는 존재하지 않는 경우에는 `super()`키워드를 이용하여 직접 명시적으로 호출해 주어야 한다.<br>
  <br>

- ### 해당 코드를 실행했을 때의 호출되는 생성자의 순서와 실행결과는 어떻게 되는가?
  먼저, 위 코드를 보면, `Child`클래스의 인스턴스를 생성하기 위해, `Child()`생성자를 호출한다. 이때, Java에서는 생성자가 호출될 시, 자동적으로 super클래스의 기본 생성자를 호출하기 때문에, `Parent`클래스의 기본 생성자인 `Parent()`가 호출되게 된다.<br>

  또, 이렇게 호출된 `Parent()`생성자 내에서는 오버로딩된 또 다른 생성자 `Parent(int x)`생성자를 호출하여, `Parent`클래스의 인스턴스 변수인 `x`의 값을 `200`으로 변경해주게 된다.<br>

  그리고, 다시 `Child()`생성자로 돌아와, `Child`클래스 내에서 오버로딩된 다른 생성자 `Child(int x)`를 호출하게 된다. 이를 통해, `Child`클래스의 인스턴스 변수인 `x`의 값을 `1000`으로 변경해주게 된다.<br><br>

  해당 코드의 실행결과가 나오는 과정을 정리해 보면, 먼저 `Child c = new Child();`를 통해, `Child` 클래스의 인스턴스를 생성하게 된다. 이때, `Child()`생성자가 호출되면서, 자동으로 super클래스인 `Parent`클래스의 기본 생성자인 `Parent()`가 호출되게 된다.<br>

  이때, `Parent`클래스의 기본 생성자는 오버로딩된 `Parent(int x)`생성자를 내부적으로 호출하기 때문에, 이를 통해 `Parent`클래스의 인스턴스 변수 `x`의 값이 `200`으로 변경되게 된다. 이렇게 `Parent`클래스의 인스턴스의 초기화는 끝나게 된다.<br>

  이제 다시 `Child`클래스의 기본생성자로 넘어가, `Child()`생성자가 내부적으로 호출하는 `Child(int x)` 생성자를 호출하여, `Child`클래스의 인스턴스 변수인 `x`의 값을 `1000`으로 변경해준다. 이렇게 `Child`클래스의 인스턴스의 생성 및 초기화까지 끝나게 된다.<br>

  이제, `System.out.println("x = " + c.getX());` 가 실행되게 되는데, `Child`클래스 타입의 참조변수`c`가 사용하는 메서드 `getX()`는, `Parent`클래스의 멤버로, 해당 메서드가 반환하는 값도 `Parent`클래스의 인스턴스 변수인 `x`이므로, `200`을 반환하게 된다.<br>

  따라서 해당 코드의 결과값은 `x = 200`이 되겠다.<br>

  ---

  

  

  
