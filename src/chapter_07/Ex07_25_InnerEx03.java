package chapter_07;

class Ex07_25_InnerEx03 {
    // 접근 제어자 private가 붙어 있는 멤버의 경우, 해당 클래스 내에서만 사용이 가능.
    private int outerIv = 0;  
    static int outerCv = 0;
    private static int outerPcv = 0;
    
    class InstanceInner {
        int iiv = outerIv; // 인스턴스 내부 클래스, InstanceInner또한, 외부 클래스의 private멤버와 같은 클래스 내에 존재하는 멤버이기에, 사용가능하다.
        int iiv2 = outerCv; // 인스턴스 멤버는 인스턴스 멤버와 static 멤버 모두 사용이 가능하기에, 인스턴스 내부 클래스 InstanceInner 또한 static 멤버인 outerCv를 사용할 수 있다.
        int iiv3 = outerPcv; // 같은 클래스 내에 있는 private멤버이면서, static 멤버인 outerPcv 또한 사용 가능하다.
    }
    
    class StaticInner {
        // int siv = outerIv; static 변수가 인스턴스 변수를 사용할 수 없듯이, static 내부 클래스도 외부클래스의 인스턴스 멤버를 사용할 수 없다.
        int scv = outerCv;
        int pscv = outerPcv;
    }
    
    void myMethod() {
        int lv = 0; // 지역변수 - 메서드의 종료와 함께 소멸된다. 지역 내부 클래스의 객체보다 빨리 사라져 버림.
        final int LV = 0;
        
        class LocalInner {
            int liv = outerIv;
            int liv2 = outerCv;
           // int liv3 = lv; 외부 클래스의 지역변수는 final이 붙은 상수만 접근 가능하다. JDK1.8이 아닌 경우, 에러. JDK1.8부터는 에러 아님.
            int liv4 = LV;
        }
    }
}