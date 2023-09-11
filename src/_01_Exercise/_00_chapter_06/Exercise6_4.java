package _01_Exercise._00_chapter_06;

class MyPoint {
    int x;
    int y;
    
    // 생성자
    MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // 인스턴스 메서드 getDistance()
    double getDistance(int x1, int y1) {
        double distance = Math.pow(x1 - this.x, 2) + Math.pow(y1 - this.y, 2);
        return Math.sqrt(distance);
    }
}

public class Exercise6_4 {
    public static void main(String[] args) {
        // 인스턴스 생성
        MyPoint p = new MyPoint(1, 1); // 생성자를 통해 인스턴스 m의 인스턴스 변수 값이 초기화 된다. 
        
        // p와 (2, 2)의 거리를 구해 반환하는 인스턴스 메서드 getDistance() 호출 
        double distance = p.getDistance(2, 2);
        
        System.out.println(distance);
    }
}

