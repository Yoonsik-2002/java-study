package chapter_07;

class Product2 {
    int price;
    int bonusPoint;
    
    Product2(int price) {
        this.price = price;
        bonusPoint = (int)(price / 10.0);
    }
    
    Product2() {}
}

/* 제품 클래스 */
class Tv2 extends Product2 {
    Tv2() {  // super를 통한 조상 클래스의 생성자 호출(자손 클래스의 생성자의 맨 첫 줄에 등장해야 함).
        super(100);
    }
    
    public String toString() {  // Object클래스의 멤버(메서드)인, toString()메서드를 자손클래스인 Tv2에 맞게 재정의(오버라이딩).
        return "Tv2";
    }
}

class Audio2 extends Product2 {
    Audio2() {
        super(200);
    }
    
    public String toString() {
        return "Audio2";
    }
}

class Computer2 extends Product2 {
    Computer2() {
        super(300);
    }
    
    public String toString() {
        return "Computer2";
    }
}

/* 구매자 클래스 */
class Buyer2 {
    int money = 1000;
    int bonusPoint = 0;
    
    /* 구매한 제품 인스턴스들을 저장하는 객체배열 */
    Product2[] cart = new Product2[10];
    int i = 0; 
    
    void buy(Product2 p) {  // 다형성의 첫 번째 장점 - 다형적 매개변수
        if(money < p.price) {
            System.out.println("잔액이 부족합니다.");
            return;
        }
        
        money -= p.price;
        bonusPoint += p.bonusPoint;
        
        /* 구매한 제품 인스턴스들을 조상 클래스 타입의 참조변수 배열 cart에 저장 */
        cart[i++] = p; // 다형성의 두 번째 장점 - 여러가지 (자손 클래스)타입의 객체를 하나의 배열에 묶어서 다루는 것이 가능
        
        System.out.println(p + "을/를 구매하셨습니다."); 
        /* PrintStream 클래스의 출력 관련 메서드(println(), print())를 사용하여 객체를 출력하는 경우, 자바 컴파일러가
        자동으로 toString()메서드를 호출한다.*/
    }

    void summary() {
        int sum = 0;
        String itemList = "";
        
        for(int i = (cart.length - 1); i >= 0; i--) {
            if(cart[i] == null) {
                continue;
            }
            
            sum += cart[i].price;
            itemList += (i == 0) ? cart[i] : cart[i] + ", ";
            
            System.out.println("구매 총 금액 : " + sum);
            System.out.println("상품 리스트 : " + itemList);
        }
    }
}

class Ex07_15_PolyArgumentTest2 {
    public static void main(String[] args) {
        Buyer2 b = new Buyer2();
        
        b.buy(new Tv2());
        b.buy(new Audio2());
        b.buy(new Computer2());
        
        b.summary();
    }
}