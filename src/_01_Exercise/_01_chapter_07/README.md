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
<br>

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

###

