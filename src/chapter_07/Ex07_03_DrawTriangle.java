package chapter_07;

class Point {
    int x;
    int y;
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    Point() {
        this(0, 0);
    }
    
    String getXY() {
        return "("+ x + "," + y + ")";
    }
}

class Triangle {
    Point[] p = new Point[3];  // Triangle 클래스를 구성하는 단위클래스 Point타입의 객체배열 p선언. 해당 객체배열에는 Triangle을 이루는 3개의 점 객체가 저장됨
    
    Triangle(Point[] p) {
        this.p = p;
    }
    
    void DrawTriangle() {
        System.out.printf("[p[0] = %s, p[1] = %s, p[2] = %s]%n", p[0].getXY(), p[1].getXY(), p[2].getXY());
    }
}