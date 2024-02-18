package chapter_07;

class Ex07_24_InnerEx02 {  // 외부 클래스
    class InstanceInner {}  // 인스턴스 내부 클래스
    static class StaticInner {}  // static 내부 클래스
    
    InstanceInner iv = new InstanceInner(); // 인스턴스 멤버가 인스턴스 멤버를 참조.
    static Staticinner cv = new StaticInner(); // 스태틱 멤버가 스태틱 멤버를 참조.
    
    static void staticMethod() {
        // InstanceInner obj1 = new InstanceInner();  static 멤버가 인스턴스 멤버에 직접 접근하는 것은 불가능하다.
        StaticInner obj2 = new StaticInner();
        
        // 인스턴스 멤버에 굳이 접근하고자 하는 경우, 외부 클래스의 인스턴스를 먼저 만들어 주어야 한다.
        Ex07_24_InnerEx02 outer = new Ex07_24_InnerEx02();
        InstanceInner obj1 = outer.new InstanceInner();
    }
    
    void instanceMethod() {
        InstanceInner obj1 = new InstanceInner();
        StaticInner obj2 = new StaticInner();
        
        // LocalInner lv = new LocalInner();  메서드 내에 선언된 지역 내부 클래스는 해당 지역 내에서만 사용이 가능하다. 외부에서 접근할 수 없다.
    }
    
    void myMethod() {
        class LocalInner() {}
        LocalInner lv = new LocalInner();
    }
}