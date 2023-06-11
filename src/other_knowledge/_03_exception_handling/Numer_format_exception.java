package _03_exception_handling;

class Number_format_exception {
    public static void main(String[] args) {
        String[] num_arr = {"20", "30", "40", "3.141592", "50"};
        
        int i = 0; 
        
        try {
            for (i = 0; i < num_arr.length; i++) {
                int j = Integer.parseInt(num_arr[i]);
                System.out.println(String.format("정수로 변환된 값 : %d", j));
            }
        }
        catch (NumberFormatException e) {
            System.out.println(num_arr[i] + "는 정수로 변환할 수 없습니다.");
        }
    }
}