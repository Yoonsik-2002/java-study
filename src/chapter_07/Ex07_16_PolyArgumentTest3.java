package chapter_07;

import java.util.*;

class Product3 {
    int price;
    int bonusPoint;
    
    Product3(int price) {
        this.price = price;
        bonusPoint = (int)(price / 10.0);
    }
    
    Product3() {
        price = 0;
        bonusPoint = 0;
    }
}

class Tv3 extends Product3 {
    Tv3() {
        super(100);
    }
    
    public String toString() {
        return "Tv";
    }
}

class Audio3 extends Product3 {
    Audio3() {
        super(200);
    }
    
    public String toString() {
        return "Audio";
    }
}

class Computer3 extends Product3 {
    Computer3() {
        super(300);
    }
    public String toString() {
        return "Computer3";
    }
}

class Buyer3 {
    int money = 1000;
    int bonusPoint = 0;
    
    Vector cart = new Vector();  
    /* 구입한 제품을 저장하는데 사용될 Vector객체 - 동적으로 크기가 관리되는 Object 클래스 타입의 객체배열 생성
    모든 클래스의 조상 클래스인 Object 클래스 타입의 참조변수 배열이기 때문에, 모든 클래스의 인스턴스를 저장하는 것이 가능하다. */
    
    /* 제품 구매 기능 */
    void buy(Product3 p) {  // 매개변수의 다형성 - 조상 클래스 타입의 매개변수를 사용함으로써, 메서드 하나로 자손 클래스 타입의 인스턴스들을 넘겨받아, 처리 가능
        if(money < p.price) {
            System.out.println("잔액이 부족합니다.");
            return;
        }
        
        money -= p.price;
        bonusPoint += p.bonusPoint;
        
        cart.add(p);  // 동적으로 관리되는 객체배열인 Vector 클래스의 인스턴스 cart에 구입한 제품 인스턴스 추가. 
        
        System.out.println(p + "제품을 구입하셨습니다.");
    }
    
    /* 제품 환불 기능 */
    void refund(Product3 p) {  // 매개변수의 다형성 - 모든 제품 인스턴스의 환불이 가능하도록, 제품 클래스의 조상 클래스인 Product3타입의 매개변수 사용
        if(cart.remove(p)) {  // Vector 클래스의 인스턴스인 가변 객체 배열 cart에서 전달받은 제품 인스턴스를 제거. 성공시 true 반환
            money += p.price;
            bonusPoint -= p.bonusPoint;
            
            System.out.println(p + "을/를 환불 하였습니다.");
        } else {
            System.out.println("구매하신 제품 중에 " + p + "제품은 존재하지 않습니다.");
        }
    }
    
    /* 구매한 물품에 대한 정보를 요약해서 보여주는 기능 */
    void summary() {
        int sum = 0;
        String cartList = "";
        
        if(cart.isEmpty()) {
            System.out.println("구매하신 물품이 없습니다.");
            return;
        }
        
        for(int i = 0; i < cart.size(); i++) {
            Product3 p = (Product3)cart.get(i);  // i인덱스에 해당하는 제품 인스턴스가 cart 객체배열에서 가져와짐. 그리고, 조상 클래스 타입의 참조변수 p에 저장.
            
            /* cart는 Object 클래스 타입의 참조변수 배열이다. 때문에, 제품 인스턴스 cart.get(i)는 Object 클래스 타입의 참조변수로 
            참조되고 있는 상황이라 할 수 있다.
            
            이러한 상황에서 Object클래스의 자손 클래스인 Product3클래스 타입의 참조변수로 해당 제품 인스턴스를 참조하도록 해주기 위해선
            참조변수의 형 변환이 이루어져야 한다. 해당 상황은 자손 클래스 타입의 참조변수로의 형 변환인 다운 캐스팅을 하는 상황이기 때문에,
            
            위 코드와 같이 형 변환을 생략하지 않고, 명시해 주어야 한다.*/
            
            
            sum += p.price;  // 구입한 물품의 총 가격
            cartList += (i == 0) ? "" + p : ", " + p;  // 구입한 물품의 목록
            
            /* 구입한 물품의 목록을 구하는 위 코드에 대한 설명 -
            
               해당 코드는 문자열 연결 연산자(+=)를 사용하여 문자열 cartList에 p를 더해주는 상황이다. 
               이때, p는 Product3클래스 타입의 참조변수로, cart배열에 저장되어 있는 자손 클래스 타입의 구매한 제품 인스턴스를
               cart.get(i)를 통해 반환받아 참조하고 있는 상황이다.
               
               이처럼, Java에서 문자열과 다른 타입의 값이 연결되는 경우, 자동으로 toString()메서드가 호출되게 된다.
               
               이때, Product3타입의 참조변수 p는 실제로는, 자손 클래스의 제품 인스턴스를 참조하고 있으므로, 이때 자동으로 호출되는
               toString()메서드는 해당 인스턴스의 타입인 자손 클래스에서 오버라이딩된 toString()메서드가 호출되게 된다. 
               
               메서드가 조상 클래스와 자손 클래스에 오버라이딩으로 인해, 중복 정의되어 있는 경우, 참조변수의 타입과는 상관없이, 실제
               참조되고 있는 인스턴스의 타입에 해당하는 클래스에 정의된 메서드가 사용된다.
               
               ex) Product3 p = new Computer3();
                   cartList += p; 
    
                   위 코드의 경우, 문자열 cartList에 다른 타입의 값인 참조변수 p가 연결되는 상황이다. 
                   이떄, 자동으로 toString()메서드가 호출되게 되는데, 해당 toString()메서드는
                   
                   p가 실제 참조하고 있는 Computer3 인스턴스의 타입인 Computer3 클래스에 오버라이딩을
                   통해 중복 정의된 toString()메서드가 된다. 
                   
                   때문에, 문자열 cartList에는 "Computer"가 더해지게 됨
            */
        }
        System.out.println("구입한 물품의 총 가격 : " + sum);
        System.out.println("구입한 물품의 목록 : " + cartList);
    }
}

class Ex07_16_PolyArgumentTest3 {
    public static void main(String[] args) {
        Buyer3 buyer = new Buyer3();
        
        Tv3 tv = new Tv3();
        Audio3 audio = new Audio3();
        Computer3 computer = new Computer3();
        
        buyer.buy(tv);
        buyer.buy(audio);
        buyer.buy(computer);
        buyer.summary();
        
        System.out.println();
        
        buyer.refund(audio);
        buyer.summary();
    }
}