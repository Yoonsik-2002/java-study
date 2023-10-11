package chapter_07;

class Shape {
    String color;
    
    void draw() {
        System.out.pritnf("[color = %s]%n", color); // printf()는 출력 후 줄바꿈X. 줄바꿈을 하려면, %n을 넣어주어야 한다. 
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
    
}