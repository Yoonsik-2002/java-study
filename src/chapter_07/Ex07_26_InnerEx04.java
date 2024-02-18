package chapter_07;

class Ex07_26_InnerEx04 { // 외부 클래스
    class InstanceInner { // 인스턴스 내부 클래스
        int iv = 100;
    }
    
    static class StaticInner { // static 내부 클래스
        int siv = 200;
        static int scv = 200;
    }
    
    void myMethod() {
        class LocalInner {
            int iv = 400;
        }
    }
    
    public static void main(String[] args) {
        /* 인스턴스 클래스의 인스턴스 생성하기 */
        Ex07_26_InnerEx04 outer = new Ex07_26_InnerEx04(); // 외부 클래스의 인스턴스를 먼저 생성
        Ex07_26_innerEx04.InstanceInner ii = outer.new InstanceInner(); // 그 후에, 외부 클래스의 인스턴스 생성
        
        System.out.println("ii.iv : " + ii.iv);
        System.out.println("Ex07_26_InnerEx04.StaticInner.scv : " + Ex07_26_InnerEx04.StaticInner.scv);
        
        /* 스태틱 내부 클래스의 인스턴스 멤버 사용하기 - 외부 클래스의 객체를 먼저 생성하지 않아도 됨 */
        Ex07_26_InnerEx04.StaticInner si = new StaticInner();
        System.out.println("si.siv : " + si.siv);
    }
}