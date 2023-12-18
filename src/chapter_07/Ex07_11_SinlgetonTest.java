// package chapter_07;

// final class Singleton {
//     private static Singleton s = new Singleton();
    
//     private Singleton() {
//         // ...
//     }
    
//     public static getInstance() {
//         if(s == null) 
//             s = new Singleton();
        
//         return s;
//     }
// }

// class Ex07_11_SingletonTest {
//     public static void main(String[] args) {
//         // Singleton s = new Singletion(); 
        
//         Singleton s = Singleton.getInstance(); // public static 메서드이므로, 외부에서 클래스 이름을 통해 인스턴스를 생성하지 않아도 호출 가능
//     }
// }