package chapter_06;

class Ex06_12 {
    public static void main(String[] args) {
        // 기본 생성자를 통해 생성된 인스턴스 c1
        Car1 c1 = new Car1();
        c1.color = "black";
        c1.gearType = "auto";
        c1.door = 4;
        
        System.out.println("기본 생성자를 통해 생성한 인스턴스 c1 - color : " + c1.color + "gearType : " + c1.gearType + "door : " + c1.door);
        
        // 매개변수가 있는 생성자를 통해 생성된 인스턴스 c2
        Car1 c2 = new Car1("orange", "auto", 2);
        
        System.out.println("매개변수가 있는 생성자를 통해 생성한 인스턴스 c2 - color : " + c2.color + "gearType : " + c2.gearType + "door : " + c2.door);
        
    }
}

class Car1 {
    String color;
    String gearType;
    int door;
    
    // 메서드 오버로딩을 통해 생성자 2개를 정의
    
    Car1() {} // 기본 생성자
    
    Car1(String c, String g, int d) { // 매개변수가 있는 생성자
        color = c;
        gearType = g;
        door = d;
    }
}