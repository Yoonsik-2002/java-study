package _03_exception_handling;

public class Array_exception {
    public static void main(String[] args) {
        int[] int_arr = new int[5];
        int_arr[0] = 0;
        
        try {
            for (int i = 0; i < int_arr.length; i++) {
                int_arr[i + 1] = i + int_arr[i];
                System.out.println(String.format("int_arr[%d] = %d", i, int_arr[i]));
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 인덱스가 범위를 벗어났습니다.");
        }
    }
}