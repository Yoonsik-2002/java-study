package _01_Exercise._00_chapter_06;

public class Exercise6_9 {
    static int abs(int value) {
        if(value < 0) 
            value = value * -1;
        
        return value;
    }
    
    public static void main(String[] args) {
        int value = -5;
        System.out.println(value + "의 절대값 : " + abs(value));
        
        value = 10;
        System.out.println(value + "의 절대값 : " + abs(value));
    }
}

// package _01_Exercise._00_chapter_06;

// public class Exercise6_9 {
//     public static void main(String[] args) {
//         long value = -9223372036854775808L; // long 타입의 최소값: -9,223,372,036,854,775,808
//         System.out.println(value + "의 절대값 : " + Math.abs(value));
        
//         value = -10;
//         System.out.println(value + "의 절대값 : " + Math.abs(value));
//     }
// }