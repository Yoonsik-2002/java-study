package chapter_06;

class Car2 {
    String color;
    String gearType;
    int door;
    
    Car2() { 
        this("white", "auto", 4);  // 생성자 Car2(String color, String gearType, int door) 호출
    }
    
    /* Car2() {
      color = white;
      gearType = auto;
      door = 4;
    }
    
    생성자 Car2() 내에서 생성자 Car2(String color, String gearYpe, int door)을 호출하는 방법을 통해
    코드를 더욱 간략히 하였다. 
    */
    
    Car2(String color) {
        this(color, "manual", 2);  // 생성자 Car2(String color, String gearType, int door) 호출
    }
    
    Car2(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}

public class Ex06_14{
    public static void main(String[] args) {
        // 인스턴스 생성
        Car2 c1 = new Car2();
        Car2 c2 = new Car2("orange");
        
        System.out.println("c1의 color : " + c1.color + "gearType : " + c1.gearType + "door : " + c1.door);
        System.out.println("c2의 color : " + c2.color + "gearType : " + c2.gearType + "door : " + c2.door);
        
    }
}