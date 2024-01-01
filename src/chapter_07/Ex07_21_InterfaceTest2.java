/* 인터페이스I를 구현한 클래스의 인스턴스를 제 3의 클래스를 통해 전달받는 경우 
JDBC의 DriverManager클래스가 이런 방식으로 되어있다. */

package chapter_07;

class A2 {
    void methodA() {
        I2 i = InstanceManager.getInstance(); // 제 3의 클래스인 InstanceManager를 통해 I인터페이스를 구현한 클래스의 인스턴스를 전달받음
        i.methodB();
        System.out.println(i.toString());
    }
}

interface I2 {
    public abstract void methodB();
}

class B2 implements I2 {
    public void methodB() {
        System.out.println("methodB in B2 class");
    }
    
    public String toString() {
        return "class B2";
    }
}

class InstanceManager {
    static I2 getInstance() {  // 메서드의 리턴타입이 인터페이스 I - 해당 인터페이스를 구현한 클래스의 인스턴스를 리턴해줌
        return new B2();
    }
}

class Ex07_21_InterfaceTest2 {
    public static void main(String[] args) {
        A2 a = new A2();
        a.methodA();
    }
}