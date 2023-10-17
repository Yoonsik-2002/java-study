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
    Point[] p = new Point[3];
    
    Triangle(Point[] p) {
        this.p = p;
    }
    
    void DrawTriangle() {
        System.out.printf("[]")
    }
}