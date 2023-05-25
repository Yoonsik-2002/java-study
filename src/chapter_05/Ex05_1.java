package chapter_05;

import java.util.Arrays;

public class Ex05_1 {
    public static void main(String[] args) {
        int[] ex_arr = {100, 90, 80, 70, 60};
        
        // for문 사용
        System.out.println("for문을 이용하여 배열에 저장된 값 출력");
        
        for(int i = 0; i < ex_arr.length ; i++)
        {
            System.out.print(ex_arr[i] + ", ");
        }
        System.out.println();    // 줄 바꿈
        System.out.println();
        
        
        // Arrays.toString() 메서드 사용
        System.out.println("Arrays.toString() 메서드를 사용하여 배열에 저장된 값들을 그대로 출력");
        
        System.out.println(Arrays.toString(ex_arr));
        System.out.println();
        
        
        // char형 배열을 대상으로 Arrays.toString() 메서드 사용
        System.out.println("Arrays.toString() 메서드를 사용하여 char형 배열에 저장된 값들을 출력");
        
        char[] ex_char_arr = {'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.println(Arrays.toString(ex_char_arr));
        System.out.println();
        
        
        // 배열을 가리키는 참조변수값을 출력 하기
        System.out.println("배열을 가리키는 참조변수 ex_arr을 print하기 ");
        
        System.out.println(ex_arr);
    }
}