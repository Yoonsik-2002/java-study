package chapter_06;

class Ex06_15 {
    static int[] arr = new int[10];  // 명시적 초기화를 통해 배열 arr을 생성한다.
    
    static {  // 클래스 초기화 블럭
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*10) + 1;
        }
    }
    
    public static void main(String[] args) {
       for (int i = 0; i < arr.length; i++) {
           System.out.println("arr["+i+"] :" + arr[i]);
       }
    }
}