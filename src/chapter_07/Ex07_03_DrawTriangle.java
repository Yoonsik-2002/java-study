package chapter_07;

class ExPoint {
    int x;
    int y;
    
    ExPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    ExPoint() {
        this(0, 0);
    }
    
    String getXY() {
        return "("+ x + "," + y + ")";
    }
}

class ExTriangle {
    ExPoint[] p = new ExPoint[3];  // Triangle 클래스를 구성하는 단위클래스 ExPoint타입의 객체배열 p선언. 해당 객체배열에는 ExTriangle을 이루는 3개의 점 객체가 저장됨
    
    ExTriangle(ExPoint[] p) {
        this.p = p;
    }
    
    void DrawTriangle() {
        System.out.printf("[p[0] = %s, p[1] = %s, p[2] = %s]%n", p[0].getXY(), p[1].getXY(), p[2].getXY());
    }
}

class Ex07_03_DrawTriangle {
    public static void main(String[] args) {
        /* Triangle 클래스를 구성하는, 좌표평면 위의 삼각형을 이루는 점을 표현하는 단위 클래스 ExPoint클래스의 
        객체3개를 저장하는 객체배열 p를 생성. 
        
        해당 객체배열을 이루는 객체들의 x좌표, y좌표를 나타내는 인스턴스 변수(멤버변수)x, y는
        생성자(ExPoint(int x, int y))에 의해 객체별로 독립적인 각기 다른 값으로 초기화됨 즉, 3개의 다른 위치에
        위치하는 점의 좌표 객체가 생성되고, 해당 객체들은 객체배열 p에 저장됨.
        
                         /--p[0] = new ExPoint(100, 100);
         ExPoint[] p ---|--p[1] = new ExPoint(140, 50);
                         \--p[2] = new ExPoint(200, 100);
        */
        
        
        ExPoint[] p = {new ExPoint(100, 100),
                       new ExPoint(140, 50),
                       new ExPoint(200, 100)};
        
        ExTriangle t = new ExTriangle(p); 
        /* 삼각형을 이루는 3개의 점을 나타내는 ExPoint객체 3개를 저장하고 있는 ExPoint타입의 객체 배열 p를
        생성자의 매개변수로 전달. 
        
        ExPoint 클래스와의 포함관계(ExTriangle has a ExPoint)를 가지고 있는 ExTriangle 클래스는 
        생성자를 통해 전달받은 ExPoint 클래스의 객체배열 p를 사용하는 것이 가능하다.
        (객체배열을 구성하는 객체의 멤버(멤버변수, 멤버함수) 모두 사용 가능)*/
        
        t.DrawTriangle();
    }
}