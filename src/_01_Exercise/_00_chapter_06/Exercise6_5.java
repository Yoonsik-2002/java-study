package _01_Exercise._00_chapter_06;

import java.util.Arrays;

class Exercise6_5 {
    static int[] shuffle(int[] arr) {
        for (int i = 0; i < 20; i++) {
            int rand = (int)(Math.random() * arr.length);
            
            int temp = arr[0];
            arr[0] = arr[rand];
            arr[rand] = temp;
        }
        return arr;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
        
        System.out.println(Arrays.toString(shuffle(arr)));
    }
}