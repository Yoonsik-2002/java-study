package chapter_06;

class Tv {
    // Tv 객체의 속성(멤버변수)
    String manufacturer;
    int price;
    int channel;
    boolean power;

    // Tv 객체의 기능(멤버변수)
    void power() { power = !power; }
    void channelUp() { channel++; }
    void channelDown(){ channel--; } 
}

public class Ex06_1 {
    public static void main(String[] args){
        Tv oled_tv;
        oled_tv = new Tv();

        oled_tv.manufacturer = "LG";
        oled_tv.channel = 6;
        oled_tv.channelUp();
        oled_tv.channelDown();
    
        System.out.println("현재 채널은" + oled_tv.channel + "입니다.");
    }
}