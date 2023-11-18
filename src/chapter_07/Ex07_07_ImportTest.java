package chapter_07;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.out; // System.out을 out만으로 참조 가능

class Ex07_07_ImportTest {
    public static void main(String[] args) {
        Date today = new Date();
        
        SimpleDateFormat date = new SimpleDateFormat("yyyy/mm/dd");
        SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");
        
        out.println("오늘 날짜는 " + date.format(today));
        out.println("현재 시간은 " + time.format(today));
    }
}