package chapter_06;

class Data1 {
    int x; // 인스턴스 변수 - 해당 클래스(Data)의 인스턴스를 생성한 다음 사용이 가능하다. (클래스 변수의 경우, 인스턴스를 생성하지않아도 사용 가능. 클래스.변수이름)
}

public class Ex06_9 {
    public static void main(String[] args) {
        Data1 d = new Data1(); // Data 클래스의 인스턴스 생성
        
        d.x = 10; 
        
        System.out.println("main() : x = " + d.x);
        
        change(d);
        
        System.out.println("main() : x = " + d.x);
    }
    static void change(Data1 d) {
        /* 생성된 인스턴스의 참조변수가 저장하고 있는 인스턴스의 주소값이 복사되어 참조형 매개변수 Data d 에 들어감
        결국, 해당 매개변수 또한 그 인스턴스를 가리키고 있는 상태가 되어, 실질적으로 해당 인스턴스에 접근하여 속성값을
        변경하는 것이 가능하게 됨*/
        
        d.x = 100; 
        System.out.println("After change : x = " + d.x);
    }
}