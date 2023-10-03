package chapter_07;

class Tv {
 boolean power;  // 전원 상태(on/off) - boolean 타입의 멤버변수의 경우, 명시적 초기화를 해주지 않았을 시, 기본값인 (false)으로 자동 초기화 된다.
 int channel;  // 채널(up/down) - int 타입의 멤버변수의 경우, 명시적 초기화를 해주지 않았을 시, 기본값인 (0)으로 자동 초기화 된다.

 void power() {power = !power;}  // 현재 power의 값 -> 그 반대값 - 스위치 같은 기능(true or false)
 void channelUp() {++channel;}
 void channelDown() {--channel;}
}

class CaptionTv extends Tv {
 boolean caption;  // 캡션 기능(on/off)

 void displayCaption(String text) {
   if(caption) {  // 캡션 상태가 on(true)일 경우에만 text를 출력
     System.out.println(text);
   }
 }
}

public class Ex07_01_CaptionTvTest {
 public static void main(String[] args) {
   CaptionTv ctv = new CaptionTv();

   ctv.channel = 10;
   ctv.channelUp();
   System.out.println(ctv.channel);

   ctv.displayCaption("Hello, World");  // ctv의 caption이 기본값인 flase로 초기화 되어있기 때문에 작동X
   ctv.caption = true;
   ctv.displayCaption("Hello, World");  // caption을 true로 해주었기 때문에 작동O
 }
}