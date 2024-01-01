/* 매개변수를 통해서 인터페이스I를 구현한 클래스의 인스턴스를 동적으로 제공받는 경우 
클래스 Thread의 생성자인 Thread(Runnable target)이 이러한 방식으로 되어있다.*/

package chapter_07;

class A1 {
    void autoPlay(I1 i) {  // I1인터페이스를 구현한 클래스의 인스턴스를 매개변수를 통해 동적으로 제공받음.
        i.play();
    }
}

interface I1 {
    public abstract void play();
}

class B1 implements I1 {
    public void play() {
        System.out.println("play in class B1");
    }
}

class C1 implements I1 {
    public void play() {
        System.out.println("play in class C1");
    }
}

class Ex07_20_InterfaceTest1 {
    public static void main(String[] args) {
        A1 a = new A1(); 
        
        a.autoPlay(new B1());  // 인터페이스 I를 구현한 클래스의 인스턴스를 인터페이스 I타입의 매개변수에 넘겨줌
        a.autoPlay(new C1());
    }
}
