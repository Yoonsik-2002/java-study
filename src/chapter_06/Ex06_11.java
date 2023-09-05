package chapter_06;

class Ex06_11 {
    public static void main(String[] args) {
        MyMath3 mm = new MyMath3(); // MyMath3 클래스에 속해있는 인스턴스 메서드들을 사용하기 위해 인스턴스를 생성 
        
        System.out.println("mm.add(3, 3) = " + mm.add(3, 3));
        System.out.println("mm.add(3, 3L) = " + mm.add(3, 3L));
        System.out.println("mm.add(3L, 3L) = " + mm.add(3L, 3L));
        System.out.println("mm.add(3L, 3) = " + mm.add(3L, 3));
        
        int[] arr = {100, 200, 300};
        
        System.out.println("mm.add(arr) = " + mm.add(arr));
    }
}

class MyMath3 {
    int add(int a, int b) {
        System.out.print("int add(int a, int b) - ");
        return a + b;
    }
    
    long add(int a, long b) {
        System.out.print("long add(int a, long b) - ");
        return a + b;
    }
    
    long add(long a, long b) {
        System.out.print("long add(long a, long b) - ");
        return a + b;
    }
    
    long add(long a, int b) {
        System.out.print("long add(long a, int b) - ");
        return a + b;
    }
    
    int add(int[] arr) {
        int a = 0;
        
        for (int i = 0; i < arr.length; i++) {
            a = a + arr[i];
        }
        
        System.out.print("int add(int[] arr) - ");
        return a;
    }
}