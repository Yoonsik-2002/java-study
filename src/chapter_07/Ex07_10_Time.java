package chapter_07;

import java.util.Scanner;

class Time {
    private int hour;
    private int minute;
    private int second;
    
    Time(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }
    
    public int getHour() { return hour; }
    public void setHour(int hour) {
        if(hour < 0 || hour > 23) return;
        this.hour = hour;
    }
    
    public int getMinute() { return minute; }
    public void setMinute(int minute) {
        if(minute < 0 || minute > 59) return;
        this.minute = minute;
    }
    
    public int getSecond() { return second; }
    public void setSecond(int second) {
        if(second < 0 || second > 59) return;
        this.second = second;
    }
    
    /* Object 클래스의 멤버인 toString() 메서드를 Time클래스에 맞게 오버라이딩.
       조상 클래스 Object 클래스의 toString()메서드의 접근지정자는 (default)이다. 
       
       메서드 오버라이딩 시, 접근 지정자의 범위는 조상 클래스의 메서드의 범위와 같거나
       넓어야 하기 때문에, (default) 아니면 public으로 지정해 주어야 함.
       
      기존 toString()메서드는 아래 형태를 가지는 객체의 문자로 된 표현을 리턴해준다.
      (객체가 인스턴스로서 존재하는 클래스의 이름 + @ + 16진수 해시코드) */
    public String toString() {
        return hour + ":" + minute + ":" + second;
    }
}

class Ex07_10_Time {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        int second = scanner.nextInt();
        
        Time time = new Time(hour, minute, second);
        
        /* System.out.println(time.toString()); 과 같다. 즉, time 인스턴스의 toString()메서드를 호출한 것과 같음.
        
           기본적으로 PrintStream 클래스의 출력 관련 메서드(print, println)를 통해 객체를 출력하도록 명령하는 경우
           자바 컴파일러가 내부적으로 객체의 문자로 된 표현을 리턴해주는 toString()메서드를 호출한다.
           
           때문에, print나 println메서드를 통해 객체를 출력해주고 싶은 경우, 객체.toString() 형태를 가질 필요가 없다. */
        System.out.println(time); 
        
        // time.hour = 22; - Time 클래스 외부에서, private 멤버변수 hour에 직접 접근하는 것은 불가. 
        
        time.setHour(time.getHour() + 1); // 현재 인스턴스 변수 time의 멤버변수 hour에 저장되어 있는 시간 + 1시간
        System.out.println(time.toString()); // System.out.println(time.toString()); 과 같다.
    }
}