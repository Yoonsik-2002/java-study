package chapter_05;

import java.util.Arrays;

public class Ex05_2 {
    public static void main(String[] args) {
        int[] ex_arr1 = new int[10];
        int[] ex_arr2 = new int[10];
        // int[] ex_arr3 = new int[] {100, 90, 80, 70, 60};
        int[] ex_arr3 = {100, 90, 80, 70, 60};
        char[] ex_char_arr = {'a', 'b', 'c', 'd', 'e'};
        
        for (int i = 0; i <= ex_arr1.length ; i++) {
            ex_arr1[i] = i + 1;
        }
        
        for (int i = 0; i < ex_arr2.length ; i++) {
            ex_arr2[i] = (int)(Math.random()*10) + 1;
        }
        
        for (int i = 0; i < ex_arr1.length ; i++) {
            System.out.println(ex_arr1[i] + ",");
        }
        
        System.out.println(Arrays.toString(ex_arr2));
        System.out.println(Arrays.toString(ex_char_arr));
        System.out.println(ex_arr3);
        System.out.println(ex_char_arr);
    }
}