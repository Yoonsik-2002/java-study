package _01_Exercise._01_chapter_07;

class Point {
    int x;
    int y;
    
    Point() {
        this(0, 0);
    }
    
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public String toString() {
        return "x : " + x + "y : " + y;
    }
}

abstract class Shape {
    Point p;  // Point 클래스를 멤버변수로 포함하며, 클래스 간의 포함 관계를 형성. 
    
    Shape() {
        this(new Point(0, 0));
    }
    
    Shape(Point p) {
        this.p = p;
    }
    
    abstract double calcArea();
    /* 추상 메서드 calcArea() - 
    메서드의 선언문만 정의한 미완성 메서드. 
    
    해당 추상 클래스를 상속받아, clacArea() 메서드를 구현하는 도형 클래스의 넓이를 구하는 공식이
    도형별로 다르기 때문에, 각 클래스에서 자신에게 맞게 해당 추상 메서드의 구현부를 구현해 주어야 한다. */
    
    Point getPosition() {
        return p;
    }
    
    void setPosition(Point p) {
        this.p = p;
    }
}

class Circle extends Shape {
    double r;
    
    Circle () {
        this(10);
    }
    
    Circle (double r) {
        super(new Point(4, 8));
        
        this.r = r;
    }
    
    double calcArea() {
        return r * r * 3.14;
    }
}

class Rectangle extends Shape {
    double width;
    double height;
    
    Rectangle() {
        this(10, 10);
    }
    
    Rectangle(double width, double height) {
        super(new Point(12, 16));
        
        this.width = width;
        this.height = height;
    }
    
    double calcArea() {
        return width * height;
    }
    
    boolean isSquare() {
        if(width == height)
            return true;
        else
            return false;
    }
}

class Exercise7_22 {
    static double sumArea(Shape[] arr) {
        double sum = 0;
        
        for(int i = 0; i < arr.length; i++) {
            sum = sum + arr[i].calcArea();
            System.out.println("arr[" + i + "] 의 x좌표 : " + arr[i].p.x + "  |  y 좌표 : " + arr[i].p.y);
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        Shape[] arr = {new Circle(5.0), new Rectangle(3, 4), new Circle(), new Rectangle()};
        
        System.out.println("the sum of areas : " + sumArea(arr));
        
        
    }
}