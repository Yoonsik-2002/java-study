package _01_Exercise._00_chapter_06;

public class Exercise6_6 {
    static boolean isNumber(String str) {
        // str이 비어있는 경우
        if(str == null || str.equals("")) {
            return false;
        }
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if(ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "123";
        System.out.println(str + "는 숫자입니까?" + isNumber(str));
        
        str = "123o";
        System.out.println(str + "는 숫자입니까?" + isNumber(str));
    }
}