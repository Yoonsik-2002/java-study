package chapter_07;

class Ex07_27_InnerEx05 {
    /* 외부 클래스의 변수와 내부 클래스의 변수의 이름이 같은 경우 */
    
    int value = 10; // Ex07_27_InnerEx05.this.value
    
    class InstanceInner {
        int value = 20; // this.value
    }
    
    void method() {
        int value = 30;
        
        System.out.println("value : " + value);
        System.out.println("this.value : " + this.value);
        System.out.println("Ex07_27_InnerEx05.this.value : " + Ex07_27_InnerEx05.this.value);
    }
    
    public static void main(String[] args) {
        Ex07_27_InnerEx05 outer = new Ex07_27_InnerEx05();
        Ex07_27_InnerEx05.InstanceInner inner = outer.new InstanceInner();
        outer.method();
    }
}
