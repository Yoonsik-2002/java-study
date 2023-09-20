package _01_Exercise._00_chapter_06;

public class Exercise6_6 {
    static boolean isNumber(String str) {
        // str이 null 이거나, 빈 문자열인 경우 
        if(str == null || str.equals("")){
            return false;
        }
        
        // str이 숫자로만 이루어져 있는 경우 / 아닌 경우
        for(int i = 0; i < str.length(); i++) {  // 문자열의 길이를 구할 때는 String 클래스의 length() 메서드 사용, 배열의 길이를 구할 때는 length 사용!
            char ch = str.charAt(i);
            
            if(ch < 48 || ch > 57) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String str = null;
        System.out.println(str + "은 숫자로만 이루어져 있는가? " + isNumber(str));
        
        str = "123o";
        System.out.println(str + "은 숫자로만 이루어져 있는가? " + isNumber(str));
    }
}