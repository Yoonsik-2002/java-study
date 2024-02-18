package chapter_07;

class Ex07_23_InnerEx01 {
    class InstanceInner {  // 인스턴스 내부 클래스
        int iv = 100;
        // static int cv = 100; 에러 발생 - static 멤버는 static 내부 클래스에서만 가질 수 있다.
        final static int CONST = 100;
    }
    
    static class StaticInner {  // static 내부 클래스
        int iv = 200;
        static int cv = 200;  // static 내부 클래스만 static 멤버를 정의할 수 있다.
        
        /* static 멤버는 인스턴스를 생성하지 않고도 사용이 가능하다. 이러한 static 멤버를
        인스턴스를 생성해야지만 사용할 수 있는 인스턴스 클래스가 가지게 되면, 생성시기에 따른
        모순이 발생한다. 그러므로, static멤버는 static 내부 클래스에서만 정의할 수 있다.
        
        또, 이러한 static 내부 클래스는 외부 클래스의 인스턴스 멤버를 사용할 수 없다. 
        인스턴스 변수는 static 변수를 사용할 수 있지만, static 변수는 인스턴스 변수를 사용
        할 수 없다. 이는 내부클래스에도 적용된다. */
        
        final static int CONST = 200;
    }
    
    void myMethod() {
        class LocalInner {
            int iv = 300;
            // static int cv = 300; 에러 발생 - static 멤버는 static 내부 클래스에서만 가질 수 있다.
            final static int CONST = 300;
        }
    }
    
    public static void main(String[] args) {
        Ex07_23_InnerEx01 outer = new Ex07_23_InnerEx01();
        Ex07_23_InnerEx01.InstanceInner inst = outer.new InstanceInner();
        
        System.out.println(inst.iv);  // 인스턴스 클래스의 인스턴스 멤버의 경우, 외부 클래스의 인스턴스를 생성한 뒤, 내부클래스의 인스턴스를 생성하여 사용 가능.
        System.out.println(InstanceInner.CONST);  // 상수의 경우, 인스턴스 클래스의 멤버라도, `인스턴스 클래스명.상수 이름`을 통해 바로 사용 가능.
        
        System.out.println(StaticInner.cv);
        System.out.println(StaticInner.CONST);
        
        
    }
}