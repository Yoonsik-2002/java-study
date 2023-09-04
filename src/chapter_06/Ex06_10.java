package chapter_06;

class Ex06_10 {
    public static void main(String[] args) {
        // 인스턴스를 생성하지 않아도 사용이 가능한 클래스 메서드 호출하기
        
        System.out.println("클래스 메서드 사용");
        System.out.println("----------------------");
        System.out.println("s_add = " + MyMath2.s_add(50, 100));
        System.out.println("s_subtract = " + MyMath2.s_subtract(200, 100));
        System.out.println("s_multiply = " + MyMath2.s_multiply(10, 20));
        System.out.println("s_divide = " + MyMath2.s_divide(200, 10));
        
        
        // 인스턴스를 생성하고, 인스턴스 변수를 사용하는 인스턴스 메서드 호출하기
        MyMath2 mm = new MyMath2(); // 생성된 인스턴스의 주소값을 저장해, 해당 인스턴스를 가리키는 참조변수 mm!
        mm.a = 400;
        mm.b = 200;
        System.out.println("");
        System.out.println("인스턴스 메서드 사용");
        System.out.println("----------------------");
        System.out.println("add  = " + mm.add());
        System.out.println("subtract = " + mm.subtract());
        System.out.println("multiply = " + mm.multiply());
        System.out.println("divide = " + mm.divide());
    }
}

class MyMath2 {
    long a, b;  // 클래스 영역에 선언된 인스턴스 변수. 해당 클래스의 인스턴스가 생성되어야 만들어져, 사용이 가능하다. 
    
    // 인스턴스 변수 a, b를 사용하는 인스턴스 메서드 add, subtract, multiply, divide. 반드시 인스턴스가 생성된 뒤에 호출이 가능하다. 
    // 미리 선언되어 있는 인스턴스 변수 a, b를 사용하기 때문에, 매개변수가 필요 없다. 
    long add() { return a + b;}
    long subtract() {return a - b;}
    long multiply() {return a * b;}
    double divide() {return a / b;}
    
    // 인스턴스 변수 a, b를 사용하지 않고, 인스턴스를 생성하지 않아도 바로 호출 가능한 클래스 메서드 s_add, s_subtract, s_multiply, s_divide
    static long s_add(long a, long b) {return a + b;}
    static long s_subtract(long a, long b) {return a - b;}
    static long s_multiply(long a, long b) {return a * b;}
    static double s_divide(double a, double b) {return a / b;}
}
