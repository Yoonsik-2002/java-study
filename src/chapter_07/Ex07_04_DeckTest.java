package chapter_07;

/* 해당 프로그램은 Card를 표현하는 Card클래스와 이 Card클래스의 객체(카드)의 묶음인, Card클래스를 단위 클래스로
포함하는 Deck클래스로 이루어진다 (Deck has a Card).

- 기능 
    1) Card Deck을 만든다. 
    2) Deck을 섞기 전에, 제일 위의 카드를 뽑는다. 
    3) 뽑은 카드를 출력한다. 
    4) 카드를 섞는다. 
    5) 섞은 후에, 제일 위의 카드를 뽑는다.
*/

class Deck {
    final int CARD_NUM = 52; // 총 카드의 개수
    Card[] cardArr = new Card[CARD_NUM]; 
    /* 카드의 총 개수(CARD_NUM)만큼 Card클래스의 객체(카드)를 저장하는 객체배열 cardArr 생성.
    이때, Deck클래스와 Card클래스의 포함관계가 성립된다(Deck has a Card).*/
    
    Deck() { // Deck에 들어가는 52장의 카드객체(4종류, 각 종류당 13장의 카드 총 52장)를 초기화 한다. 이 52장의 카드의 묶음인 덱(Deck)은 cardArr 객체 배열
        int i = 0;
        
        for (int k = Card.KIND_MAX; k > 0; k--) {
            for (int n = 0; n < Card.NUM_MAX; n++) {
                cardArr[i++] = new Card(k, n+1); // i++ 후위 연산자 - 대입 후 증가.
            }
        }
    }
    
    // cardArr(덱)에서 카드를 뽑아 출력, - 1) 지정된 위치의 카드, 2) 랜덤 위치의 카드
    
    // 1) 지정된 위치의 카드
    Card pick(int index) {
        return cardArr[index];
    }
    
    // 2) 랜덤 위치의 카드
    Card pick() {
        int index = (int)(Math.random() * CARD_NUM);
        reutrn pick(index);
    }
}