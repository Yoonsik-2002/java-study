package chapter_07;

interface Repairable {}

class Unit {
    int hitPoint;
    final int MAX_HP;
    
    Unit(int hp) {
        MAX_HP = hp;
    }
}

class GroundUnit extends Unit {
    GroundUnit(int hp) {
        super(hp);
    }
}

class AirUnit extends Unit {
    AirUnit(int hp) {
        super(hp);
    }
}

class Marine extends GroundUnit {
    Marine() {
        super(60);
        hitPoint = MAX_HP;
    }
    // ...
}

class Tank extends GroundUnit implements Repairable {
    Tank() {
        super(150);
        hitPoint = MAX_HP;
    }
    
    public String toString() {  // java.lang.Object클래스의 toString()메서드를 오버라이딩.
        return "Tank";
    }
}

class DropShip extends AirUnit implements Repairable {
    DropShip() {
        super(125);
        hitPoint = MAX_HP;
    }
    
    public String toString() {
        return "DropShip";
    }
}

class SCV extends GroundUnit implements Repairable {
    SCV() {
        super(60);
        hitPoint = MAX_HP;
    }
    
    void repair(Repairable r) {  
    /*
    Repairable 인터페이스를 구현하는 모든 기계화 유닛 클래스의 인스턴스를 매개변수로 넘겨받을 수 있게 하기위해 매개변수 타입을 Repairable로 함.
    하지만, Repairable 인터페이스는 비어있는 인터페이스로, 해당 타입의 참조변수로는 넘겨받은(참조하고 있는) 인스턴스의 멤버를 아무것도 사용할 수 없음.
    */
        
        if(r instanceof Unit) { 
            Unit u = (Unit)r;
        /*
        모든 유닛의 공통조상인 Unit 클래스 타입으로 참조변수를 형변환하여, MAX_HP, hitPoint멤버에 접근할 수 있게 함.
        
        (Repairabe 인터페이스를 구현한) 기계화 유닛만을 repair메서드의 매개변수에 전달하기 위해, 해당 메서드의 매개변수의
        타입을 Repairable로 지정해준 것이고, 해당 상태로는 넘겨받은 인스턴스의 멤버를 사용하는 것이 불가능하기 떄문에 모든 
        유닛의 공통조상인 Unit타입으로 참조변수를 형 변환 해준 것이다.
        
        1차적으로, Repairable 인터페이스를 구현한 기계화 유닛 클래스의 인스턴스만이 repair 메서드의 매개변수로 전달되는 것이 가능하다.
        하지만, 비어있는 인터페이스인 Repairable 타입의 참조변수로는, 현재 참조하고 있는 인스턴스의 어떠한 멤버도 사용하는 것이 불가능하다.
        
        때문에, 모든 유닛의 공통조상인 `Unit`타입으로 참조변수를 형 변환 해준 것이다. 어차피, repair 메서드로 들어올 수 있는 인스턴스는
        Repairable 인터페이스를 구현한 기계화 유닛 클래스의 인스턴스 밖에 없다. 
        
        이렇게 전달된 기계화 유닛 인스턴스를 가리키는 참조변수의 타입을 모든 유닛의 공통조상인 Unit으로 형변환 해줌으로써, MAX_HP와 
        hitPoint멤버를 사용하는 것이 가능해졌다.
        */
             
            while(u.hitPoint != u.MAX_HP) {
                u.hitPoint++;
            }
                System.out.println(u + "의 수리를 완료하였습니다.");
        }  
    }
}

class Ex07_19_RepairableTest {
    public static void main(String[] args) {
        Tank tank = new Tank();
        DropShip dropShip = new DropShip();
        SCV scv = new SCV();
        Marine marine = new Marine();
        
        scv.repair(tank);
        scv.repair(dropShip);
        /* 
        scv.repair(marine); 
        에러 발생 - 
        Marine 클래스는 기계화 유닛이 아니므로, Repairable 인터페이스를 구현하지 않음.
        때문에, Repariable 인터페이스 타입의 매개변수를 가지는 repair메서드에 Marine 클래스의 인스턴스를 전달하는 것은 불가능하다.
        */
    }
}