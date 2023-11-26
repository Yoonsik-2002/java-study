package chapter_07;

class Number{
    final int NUMBER = 10; // 상수의 일반적인 초기화 방식 - 선언과 동시에 초기화
    
    void getNumber() {
        System.out.println(NUMBER);
    }
}

class Ex07_08_FinalTest {
    public static void main(String[] args) {
        Number n1 = new Number();
        System.out.println("n1 : " + n1.NUMBER);
        
        Number n2 = new Number();
        System.out.println("n2 : " + n2.NUMBER);
        
        Number n3 = new Number();
        System.out.println("n3 : " + n3.NUMBER);
    }
}