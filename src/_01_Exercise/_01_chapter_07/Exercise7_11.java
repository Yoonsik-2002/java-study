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
    void action(Robot r) {
        if(r instanceof DanceRobot) {  // 해당 클래스 타입으로 형 변환이 가능한지 검사
            r.dance();  // 가능한 경우, Robot -> DanceRobot으로의 다운 캐스팅(Down Casting)이므로, 형변환 생략 불가능
        }
        
        else if(r instanceof SingRobot) {
            r.sing();
        }
        
        else if(r instanceof DrawRobot) {
            r.draw();
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
        }
    }
}

