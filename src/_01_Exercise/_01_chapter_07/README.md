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
![스크린샷(1)](https://github.com/Yoonsik-2002/java-study/assets/83572199/172565a7-375a-414b-a911-4ab5039a232f)

