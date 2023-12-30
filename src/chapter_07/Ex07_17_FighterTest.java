package chapter_07;

interface Movable {
    void move(int x, int y); // public abstract void move (int x, int y);
}

interface Attackable {
    void attack(Unit1 u); // public abstract void attack (int x, int y);
}

interface Fightable extends Movable, Attackable {} 
/* Mobeable 인터페이스와 Attackable 인터페이스를 다중 상속받아,
해당 인터페이스들이 가지고 있는 주상 메서드, move와 attack을 포함하고 있음.*/

class Unit1 {
    int currentHP;
    int x, y;
}

class Fighter extends Unit1 implements Fightable {
    public void move(int x, int y) {/* 내용 생략 */}
    public void attack(Unit1 u) {/* 내용 생략 */}
}

class Ex07_17_FighterTest {
    public static void main(String[] args) {
        Fighter f = new Fighter();
        
        if(f instanceof Unit1) {
            System.out.println("f는 Unit의 자손이다.");
        }
        
        if(f instanceof Movable) {
            System.out.println("f는 Movable 인터페이스를 구현하였다.");
        }
        
        if(f instanceof Attackable) {
            System.out.println("f는 Attackable 인터페이스를 구현하였다.");
        }
        
        if(f instanceof Fightable) {
            System.out.println("f는 Fightable 인터페이스를 구현하였다.");
        }
        
        if(f instanceof Object) {
            System.out.println("f는 Object 클래스의 자손이다.");
        }
    }
}