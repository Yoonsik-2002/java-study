package _01_Exercise._00_chapter_06;

public class Exercise6_8 {
    static int max(int[] arr) {
        if(arr == null || arr.length == 0) {
            return -999999;
        }
        
        int max_value = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            max_value = (max_value < arr[i])? max_value : arr[i];
        }
        return max_value;  
    }
    public static void main(String[] args) {
        int[] data = {3, 2, 9, 4, 7};
        System.out.println(java.util.Arrays.toString(data));
        System.out.println("최대값 : " + max(data));
        System.out.println("최대값 : " + max(null));
        System.out.println("최대값 : " + max(new int[] {}));
    }
}