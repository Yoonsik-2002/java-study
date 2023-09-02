package chapter_06.Ex06_13;

class Ex06_13 {
    public static void main(String[] args) {
        
        // 클래스 변수의 경우, 생성시기가 클래스가 메모리에 올라갈 때 이므로, 인스턴스를 생성하지 않아도 사용이 가능하다. 
        System.out.println("Card.width : " + Card.width);
        System.out.println("Card.height : " + Card.height);
        
        Card c1 = new Card(); // Card 클래스의 인스턴스 c1 생성. 인스턴스 변수 사용 가능!
        c1.kind = "Heart";
        c1.number = 7;
        
        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;
        
        System.out.println("c1의 종류는 " + c1.kind + "이며, 숫자는 " + c1.number + "이다. 크기는 (" + Card.width + "," + Card.height + ")");
        System.out.println("c2의 종류는 " + c2.kind + "이며, 숫자는 " + c2.number + "이다. 크기는 (" + Card.width + "," + Card.height + ")");
        System.out.println();
        System.out.println("c1의 width와 height를 각각 50과 80으로 변경합니다.");
        System.out.println();
        
        c1.width = 50;
        c1.height = 80;
        
        // static 변수인 width와 height를 변경하였기 때문에, 이는 c1과 같은 클래스의 인스턴스인 c2에도 적용된다. 
        System.out.println("c1의 종류는 " + c1.kind + "이며, 숫자는 " + c1.number + "이다. 크기는 (" + c1.width + "," + c1.height + ")");
        System.out.println("c2의 종류는 " + c1.kind + "이며, 숫자는 " + c2.number + "이다. 크기는 (" + c2.width + "," + c2.height + ")");
        
    }
}