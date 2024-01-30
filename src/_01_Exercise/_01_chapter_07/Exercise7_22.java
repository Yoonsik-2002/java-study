package _01_Exercise._01_chapter_07;

import java.util.Scanner;

/* 도형의 x, y 좌표위치를 나타내는 Point 클래스 */
class Point {
    int x; 
    int y;
    
    Point() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("enter value of x");
        this.x = scanner.nextInt();
        System.out.prinlnt("enter value of y");
        this.y = scanner.nextInt();
        
        scanner.close();
    }
    
    public String toString() {
        return "x: " + x + "y: " + y;
    }
}

/* 도형을 나타내는 Shape 클래스 (Point 클래스와 포함관계) */
abstract class Shape {  // 추상 클래스 - 해당 클래스의 자손클래스는 반드시 해당 클래스의 추상 메서드를 구현해주어야 한다.(abstract는 이 점을 개발자에게 강조해주기 위해 사용됨)
    Point p;
    
    Shape(Point p) {  // x, y 좌표값을 원하는 값을 초기화 하여 Shape객체 생성
        this.p = p;
    }
    
    abstract double calcArea();  // 추상 메서드
    
    Point getPosition() {
        return p;
    }
    
    void setPosition() {
        this.p = p;
    }
}

class Circle extends Shape {
    double r;
    
    Circle() {
        Super(new Point());
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("enter value of radius");
        this.r = scanner.nextDouble();
        
        scanner.close();
    }
    
    double calcArea() {  // 상속받은 추상 클래스의 추상 메서드 구현
        return r * r * 3.14;
    }
}

class Rectangle extends Shape {
    double width;
    double height;
    
    Rectangle() {
        Super(new Point());
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("enter value of width");
        this.width = scanner.nextDouble();
        
        System.out.println("enter value of height");
        this.height = scanner.nextDouble();
        
        scanner.close();
    }
    
    double calcArea() {  // 상속받은 추상 클래스의 추상 메서드 구현
        return width * height;
    }
    
    boolean isSquare() {
        if(width == height)
            return true;
        else 
            return false;
    }
}