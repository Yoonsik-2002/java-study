package chapter_05;

import java.util.Arrays;

class Ex05_7 {
    public static void main(String[] args) {
        String[] str_arr = {"Cho", "Yoon", "Sik"};
        
        /* 
        String[] str_arr = new String[3];
        str_arr[0] = new String("Cho");
        str_arr[1] = new String("Yoon");
        str_arr[2] = new String("Sik");
        
        String[] str_arr = new String[3];
        str_arr[0] = "Cho";
        str_arr[1] = "Yoon";
        str_arr[2] = "Sik";
        
        String[] str_arr = new String[] {"Cho", "Yoon", "Sik"};
        String[] str_arr = {"Cho", "Yoon", "Sik"};
        */
        
        for (int i = 0; i < str_arr.length; i++) {
            System.out.println("str_arr[" + i + "] : " + str_arr[i]);
        }
        
        for (int i = 0; i < 100; i++) {
            int rand = (int)(Math.random() * 3);
            String temp = str_arr[0];
            str_arr[0] = str_arr[rand];
            str_arr[rand] = temp;
        }
        
        System.out.println(Arrays.toString(str_arr));
        
        /*
        String 클래스의 메서드 charAt과 subString으로 문자열을 다루는 코드.
        객체지향 언어인 Java는 문자열을 달랑 char배열로 다루지 않고, 
        문자열(char배열)과 해당 문자열과 관련된 메서드들을 String이라는 하나의 클래스로 묶어서 다룬다.
        즉, String 클래스는 [데이터 : 문자열(char배열)] 과 [문자열을 다루는 기능 : 메서드]를 하나로 묶어 확장한 개념이기 때문에
        C언어처럼 달랑 char배열을 사용하여 문자열을 다루는 것 보다 더욱 용이하고, 편리하다. 
        */
        String name = "ChoYoonSik";
        char use_chat = name.charAt(0);
        String use_substr = name.substring(3, 10);
        
        System.out.println(use_chat);
        System.out.println(use_substr);
    }
}