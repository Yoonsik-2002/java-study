package chapter_06;

class Data {
    int x; // 인스턴스 변수. 해당 클래스의 인스턴스가 생성된 후에 사용이 가능하다. 
}

public class Ex06_08 {
    public static void main(String[] args) {
        Data d = new Data(); // Data 클래스의 인스턴스 d 생성
        
        d.x = 10;
    
        System.out.println("main() : x = " + d.x);
        
        change(d.x);
        
        System.out.println("After change(d.x)");
        
        System.out.println("main() : x = " + d.x);
        
    }
    
    static void change(int x) {
        x = 1000;
        System.out.println("change() : x = " + x);
    }
}

