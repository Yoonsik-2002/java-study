package _01_Exercise._01_chapter_07;

class MyTv2 {
    private boolean isPowerOn;
    private int channel;
    private int volume;
    
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 0;
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    
    public void Power() {
        isPowerOn = !isPowerOn;
    }
    
    public void setChannel(int n) {
        if(isPowerOn == true) {
            if(MIN_CHANNEL <= n && n <= MAX_CHANNEL){
                channel = n;
            }
            else {
                System.out.println("You entered an incorrect value.");
            }
        }
        else {
            return;  // 함수의 반환형이 void이기 때문에, return;을 통해 함수를 종료시킬 수 있다.
        }
    }
    
    public int getChannel() {
        if(isPowerOn == true) {
            return channel;
        }
        else {
            System.out.println("Tv is powered off.");
            return -1;  // 반환형이 있는 함수에서는 모든 분기에서 반환문을 포함해 주어야 한다. (반환문 누락 시, 에러 발생)
        }
    }
    
    public void setVolume(int n ) {
        if(isPowerOn == true) {
            if(MIN_VOLUME <= n && n <= MAX_VOLUME) {
                volume = n;
            }
            else {
                System.out.println("You entered an incorrect value.");
            }
        }else {
            return;  // 함수의 반환형이 void이기 때문에, return;을 통해 함수를 종료시킬 수 있다.
        }
    }
    
    public int getVolume() {
        if(isPowerOn == true) {
            return volume;
        }
        else {
            System.out.println("Tv is powered off.");
            return -1;  // 반환형이 있는 함수에서는 모든 분기에서 반환문을 포함해 주어야 한다. (반환문 누락 시, 에러 발생)
        }
    }
}

class Exercise7_10 {
    public static void main(String[] args) {
        MyTv2 tv = new MyTv2() {};
        
        tv.Power();
        
        /* MyTv2 클래스의 멤버변수 channel은 private로 정의되어 있기 때문에, 외부에서 직접 접근하는 것은 불가능하다. 
        외부에서는 오직 MyTv2 클래스에 public으로 정의되어 있는 메서드를 통해 값을 변경하고 가져올 수 있다. */
        tv.setChannel(10);
        System.out.println("current channel : " + tv.getChannel());
        
        /* MyTv2 클래스의 멤버변수 volume은 private로 정의되어 있기 때문에, 외부에서 직접 접근하는 것은 불가능하다. 
        외부에서는 오직 MyTv2 클래스에 public으로 정의되어 있는 메서드를 통해 값을 변경하고 가져올 수 있다. */
        tv.setVolume(20);
        System.out.println("current volume : " + tv.getVolume());
    }
}    