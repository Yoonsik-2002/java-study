package chapter_07;

class Product {
    int price;
    int bonusPoint;
    
    Product(int price) {
        this.price = price;
        bonusPoint = (int)(price / 10.0);
    }
}

class Audio extends Product {
    Audio() {
        super(100);  // 조상 클래스(Product)의 생성자 호출
    }
    
    public String toString() {  // Object 클래스의 toString메서드를 Overring
        return "Audio";
    }
}

class Computer extends Product {
    Computer() {
        super(200);  // 조상 클래스(Product)의 생성자 호출
    }
    
    public String toString() {
        return "Computer";
    }
}

class Buyer {
    int money = 1000;
    int bonusPoint = 0;
    
    void buy (Product p) {
        if(money < p.price) {
            System.out.println("잔액이 부족합니다.");
            return;
        }
        
        money -= p.price;
        bonusPoint += p.bonusPoint;
        
        System.out.println(p + "을 / 를 구입하셨습니다.");
    }
}

class Ex07_14_PolyArgumentTest {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        
        b.buy(new Audio());
        b.buy(new Computer());
        
        System.out.println("현재 남은 돈 : " + b.money);
        System.out.println("현재 남은 포인트 : " + b.bonusPoint);
    }
}