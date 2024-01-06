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
    /* 
    Object클래스의 toString()메서드는 객체의 문자로 된 표현을 문자열 형태로 리턴해준다. 
    
    PrintStream 클래스의 출력 관련 메서드(print, printf, println ...)를 통해 어떠한 클래스의
    객체를 출력해주는 경우, 내부적으로 컴파일러에 의해 자동으로 호출된다.
    
    위 코드와 같이 PrintStream 클래스의 출력 관련 메서드로 SutdaCard1 클래스의 객체를 출력하는 경우를
    보자. 

    SutdaCard1 클래스에는 toString()메서드가 오버라이딩을 통해 해당 클래스에 맞게 재정의되어 있다.
    
    SutdaCard1 클래스에서 toString()메서드를 오버라이딩 하였기 때문에, SutdaCard1클래스의
    객체를 출력할 때는, SutdaCar1클래스에서 오버라이딩하여 정의된 toString() 메서드가 호출되게 된다. 
    
    이처럼, 어떠한 클래스에서 toString()메서드를 오버라이딩하여 재정의 한 경우, 해당 클래스의 객체를
    PrintStream 클래스의 출력 관련 메서드로 출력하면
    
    해당 클래스에서 오버라이딩한 toString() 메서드가 컴파일러에 의해 내부적으로 호출되게 된다.*/
}

/* SutdaCard1클래스의 카드 인스턴스를 모아서 관리하는 SutdaDeck1 클래스 */
class SutdaDeck1 {
    final int CARD_NUM = 20;
    
    SutdaCard1[] cards = new SutdaCard1[CARD_NUM];
    
    SutdaDeck1() {
        int i;
        
        for (i = 0; i < cards.length; i++) {
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
    
    void suffle() {
        for(int i = 0; i < 30; i++) {
            int rand_index = (int)(Math.random() * 20);
            
            int temp = cards[0];
            cards[0] = cards[rand_index];
            cards[rand_index] = temp;
        }
    }
    
    SutdaCard1 pick() {
        int rand_index = (int)(math.random() * 20);
        
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
        
        deck.pick(0);  // 첫 번째 Card 출력
        deck.pick();  // 랜덤 pick한 Card 출력
        System.out.println();
        
        deck.shuffle();  // Card 섞기
        deck.showCards();  // 섞인 Card 출력
        System.out.println();
        
        deck.pick(0);  // 첫 번째 Card 출력
    }
}