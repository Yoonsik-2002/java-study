package _01_Exercise._00_chapter_06;

class MyTv {
    
    /* 멤버변수(클래스 변수, 인스턴스 변수) - 
    직접 초기화 해주지 않아도 해당 자료혀의 기본값으로 자동 초기화 된다.
    */
    boolean isPowerOn;
    int channel;
    int volume;
    
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 1;
    
    void turnOnOff() {
        if(isPowerOn == false) 
            isPowerOn = true;
        else 
            isPowerOn = false;
    }
    
    void volumeUp() {
        if(volume < MAX_VOLUME)
            volume ++;
    }
    
    void volumeDown() {
        if(volume > MIN_VOLUME)
            volume --;
    }
    
    void channelUp() {
        if (channel == MAX_CHANNEL) 
            channel = MIN_CHANNEL;
        else
            channel ++;
    }
    
    void channelDown() {
        if (channel == MIN_CHANNEL)
            channel = MAX_CHANNEL;
        else
            channel --;
    }
    
} // class MyTv

public class Exercise6_7 {
    public static void main(String[] args) {
        MyTv tv = new MyTv();
        
        tv.channel = 100;
        tv.volume = 0;
        System.out.println("CH: " + tv.channel + "," + "VO: " + tv.volume);
        
        tv.channelDown();
        tv.volumeDown();
        System.out.println("CH: " + tv.channel + "," + "VO: " + tv.volume);
        
        tv.volume = 100;
        tv.channelUp();
        tv.volumeUp();
        System.out.println("CH: " + tv.channel + "," + "VO: " + tv.volume);
    }
}