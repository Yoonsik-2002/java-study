package _01_Exercise._00_chapter_06;

public class Exercise6_8 {
    static int max(int[] arr) {
        if(arr != null || arr.length != 0) {
            int max_index = 0;
            
            for(int i = 1; i < arr.length; i++) {
                if(arr[max_index] < arr[i]) {
                    max_index = i;
                }
            }
            
            return arr[max_index];
        }
        else {
            return -999999;
        }
    }
    
    public static void main(String[] args) {
        int[] data = {3, 2, 9, 4, 7};
        System.out.println(java.util.Arrays.toString(data));
        System.out.println("최대값 : " + max(data));
        System.out.println("최대값 : " + max(null));
        System.out.println("최대값 : " + max(new int[] {}));
    }
}