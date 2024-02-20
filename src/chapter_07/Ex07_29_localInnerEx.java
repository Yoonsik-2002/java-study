package chapter_07;

class Ex07_29_localInnerEx {
    int instanceVar = 10;
    
    void outerMethod() {
        class LocalInner {
            void innerMethod1(int var) {
                // 인자를 통해 외부 클래스의 인스턴스 변수에 접근
                System.out.println(var);
            }
            
            void innerMethod2() {
                // 메서드 내부에서 외부 클래스의 인스턴스 변수를 참조하여 접근
                System.out.println(instanceVar);
            }
        }
        
        LocalInner inner = new LocalInner();
        
        // 인자를 통한 접근
        inner.innerMethod1(instanceVar);
        
        // 메서드 내부에서 참조하여 접근
        inner.innerMethod2();
    }
}
