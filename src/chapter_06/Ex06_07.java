package chapter_06;

class Ex06_07 {
    public static void main(String[] args) {
        MyMath mm = new MyMath();
        
        long result_add = mm.add(5L, 3L);
        long result_subtract = mm.subtract(5L, 3L);
        long result_multiply = mm.multiply(5L, 3L);
        double result_divide = mm.divide(5, 3);
        
        System.out.println("add(5L, 3L) = " + result_add);
        System.out.println("subtract(5L, 3L) = " + result_subtract);
        System.out.println("multiply(5L, 3L) = " + result_multiply);
        System.out.println("divide(5, 3) = " + result_divide);
    }
}

class MyMath {
    /* long add(long a, long b) {
        long result = a + b;
        return result;
    }*/
    
    // 위 코드는 아래와 같이 간단히 작성 가능하다. 
    
    long add(long a, long b) {return a + b;}
    long subtract(long a, long b) {return a - b;}
    long multiply(long a, long b) {return a * b;}
    double divide(double a, double b) {return a / b;}
}
