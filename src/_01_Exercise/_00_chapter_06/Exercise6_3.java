package _01_Exercise._00_chapter_06;

public class Exercise6_3 {
    static double getDistance(int x, int y, int x1, int y1) {
        double distance = Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2); // 특정 값의 제곱을 구해주는 java.lang 패키지의 Math.pow()메서드
        return Math.sqrt(distance); // 특정 값의 제곱근을 구해주는 java.lang 패키지의 Math.sqrt()메서드
    }
    
    public static void main(String[] args) {
        System.out.println(getDistance(1, 1, 2, 2));
    }
}
