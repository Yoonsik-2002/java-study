package chapter_05;

import java.util.Arrays;

class Ex05_05 {
    public static void main(String[] args) {
        int[] num_arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(num_arr));
        
        for (int i = 0; i < 100; i++) {
            int rand = ((int)(Math.random() * 10));
            
            int temp = num_arr[0];
            num_arr[0] = num_arr[rand];
            num_arr[rand] = temp;
        }
        
        System.out.println(Arrays.toString(num_arr));
        
    }
}