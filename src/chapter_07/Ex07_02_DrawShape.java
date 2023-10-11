package chapter_07;

class Shape {
    String color = "black";
    
    void draw() {
        System.out.printf("[color = %s]%n", color); // printf()는 출력 후 줄바꿈X. 줄바꿈을 하려면, %n을 넣어주어야 한다. 
    }
}

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
        return "("+x+","+y+")";
    }
}

class Circle extends Shape {
    Point center; // Point 클래스 타입의 멤버변수 추가(클래스의 포함관계)
    int r;
    
    Circle(Point center, int r) {
        this.center = center;
        this.r = r;
    }
    
    Circle() { // 생성자의 오버로딩
        this(new Point(0, 0), 100); // Circle(Point center, int r) 생성자를 재 호출
    }
    
    void draw() {
        System.out.printf("[center = (%d, %d), r = %d, color = %s]%n", center.x, center.y, r, color);
        /* Circle 클래스와 포함관계를 띄고 있는 Point 클래스 타입인 인스턴스의 참조변수 center의 멤버변수인 x와 y값, 
        Circle 클래스의 멤버변수인 r의 값, Circle 클래스가 상속받고 있는 Shape 클래스의 멤버변수이 color의 값 출력*/
    }
}

class Triangle extends Shape {
    Point[] p = new Point[3]; // Point 클래스 타입의 크기가 3인 객체배열 선언(클래스의 포함관계)
    
    Triangle(Point[] p) {
        this.p = p;
    }
    
    void draw() {
        System.out.printf("[p1 = %s, p2 = %s, p3 = %s, color = %s]%n", p[0].getXY(), p[1].getXY(), p[2].getXY(), color);
        /* Point 클래스 타입인 객체배열 p는 레퍼런스 변수 p[0], p[1], p[2] 를 통해 총 3개의 Point타입의 인스턴스를 가리킨다.
        때문에, p[0]이라는 레퍼런스 변수가 가리키고 있는 Point타입의 인스턴스가 가지고 있는 고유한 멤버(인스턴스 변수 x, y)값, 
        그리고 해당 인스턴스 변수들과 관련된 메서드 getXY() 를 사용하는 것이 가능하다.*/
    }
}

class Ex07_02_DrawShape {
    public static void main(String[] args) {
        Point[] p = {new Point(100, 100),
                     new Point(140, 50),
                     new Point(200, 100)};
        
        Triangle t = new Triangle(p);
        Circle c = new Circle(new Point(150, 150), 100);
        
        t.draw();
        c.draw();
    }
}