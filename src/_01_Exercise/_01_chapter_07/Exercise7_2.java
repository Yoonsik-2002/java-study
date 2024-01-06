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