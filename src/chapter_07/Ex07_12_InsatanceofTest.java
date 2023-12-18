package chapter_07;

class Ex07_12_InstanceofTest {
    public static void main(String[] args) {
        FireEngine fe = new FireEngine();
        
        if(fe instanceof FireEngine) { // 참조변수 fe가 가리키는 인스턴스가 FireEngine클래스의 인스턴스인가?
            System.out.println("This is a FireEngine insatance.");
        }
        
        if(fe instanceof Car) { // 참조변수 fe가 가리키는 인스턴스가 Car클래스의 인스턴스인가?(fe가 가리키는 인스턴스가 Car 클래스의 자손 클래스의 인스턴스 인가?)
            System.out.println("This is a Car instance.");
        }
        
        if(fe instanceof Object) { // 참조변수 fe가 가리키는 인스턴스가 Object클래스의 인스턴스인가?(fe가 가리키는 인스턴스가 Object 클래스의 자손 클래스의 인스턴스 인가?)
            System.out.println("This is an Object instance");
        }
        
        System.out.println(fe.getClass().getName()); // 참조변수 fe가 가리키고 있는 인스턴스의 클래스 이름을 문자열로 반환.
    }
}

class Car {}
class FireEngine extends Car {}