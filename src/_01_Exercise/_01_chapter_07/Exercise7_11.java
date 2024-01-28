package _01_Exercise._01_chapter_07;

class Robot {}

class DanceRobot extends Robot {
    void dance() {
        System.out.println("start dance");
    }
}

class SingRobot extends Robot {
    void sing() {
        System.out.println("start sing");
    }
}


class DrawRobot extends Robot {
    void draw() {
        System.out.println("start draw");
    }
}

class Exercise7_11 {
    static void action(Robot r) {
        if(r instanceof DanceRobot) {  // 참조변수 r의 타입을 DanceRobot 타입으로 형변환 할 수 있는지 검사
            ((DanceRobot) r).dance();  // r의 타입을 Robot 에서 DanceRobot 타입으로 형변환(down-casting)
        }
        
        if(r instanceof SingRobot) {
            ((SingRobot) r).sing();
        }
        
        if(r instanceof DrawRobot) {
            ((DrawRobot) r).draw();
        }
    }
    
    public static void main(String[] args) {
        Robot[] array = {new DanceRobot(), new SingRobot(), new DrawRobot()};
        
        /* 
        Robot[] array = new Robot[3];
        array[0] = new DanceRobot();
        array[1] = new SingRobot();
        array[2] = new DrawRobot();
        */
        
        for(int i = 0; i < array.length; i++) {
            action(array[i]);
            /*
            static 메서드인 main메서드에서의 직접적인 호출. 만약 action메서드가 인스턴스 메서드인 경우, 
            main메서드 첫 줄에서 Exercise7_11 클래스의 인스턴스를 생성해 주어야 한다. 
            */
        }
    }
}

