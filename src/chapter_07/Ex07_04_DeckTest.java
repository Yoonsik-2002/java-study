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
        return pick(index);
    }
    
    // cardArr(덱)에 저장되어 있는 52개의 Card객체(카드)를 무작위로 섞음
    void shuffle() {
        for (int i = 0; i < cardArr.length; i++) {
            int rand = (int)(Math.random() * CARD_NUM); // 0 ~ 51 까지의 정수 중 임의의 수를 뽑아 rand에 저장
            
            /* cardArr[0] 에 존재하는 데이터와 0 ~ 51 중 임의로 뽑힌 수에 해당하는 인덱스에 존재하는 
            데이터(cardArr[rand])를 cardArr배열의 길이반큼 반복하여 교환하여 해당 객체배열에 저장되어
            있는 Card 객체의 순서를 섞음*/
            
            Card temp = cardArr[0]; // 임시저장
            cardArr[0] = cardArr[rand];
            cardArr[rand] = temp;
        }
    }
} // Deck 클래스의 끝

class Card {
    final static int KIND_MAX = 4;
    final static int NUM_MAX = 13;
    
    final static int SPADE = 4;
    final static int DIAMOND = 3;
    final static int HEART = 2;
    final static int CLOVER = 1;
    
    int kind;
    int number;
    
    Card(int kind, int number) {
        this.kind = kind;
        this.number = number;
    }
    
    Card() {
        this(SPADE, 1);
    }
}