package _01_Exercise._00_chapter_06;

public class Exercise6_3 {
    static double getDistance(int x, int y, int x1, int y1) {
        double distance = Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2);
        return Math.sqrt(distance);
    }
    
    public static void main(String[] args) {
        System.out.println(getDistance(1, 1, 2, 2));
    }
}
