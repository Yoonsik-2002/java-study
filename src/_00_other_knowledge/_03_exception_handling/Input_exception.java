package _03_exception_handling;

import java.util.*;
// import java.util.Scanner;
// import java.util.InputMismatchException;

public class Input_exception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("please enter 3 integers");
        
        int sum = 0, num = 0;
        
        for (int i = 0; i < 3; i++) {
            System.out.printf("%d >> ", i);
            
            // exception handling
            try {
                num = scanner.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("It's not an integer. please enter it again!!");
                scanner.nextLine(); // 현재 입력 스트림에 남아있는 토큰을 지움
                
                i--; // 정수가 아닌 잘못된 값을 입력받은 for문의 회차는 count 하지 않기 때문에 i--;
                
                continue; // 다음 루프로!
            }
            sum += num;
        }
        System.out.println(String.format("합은 %d", sum));
        
        scanner.close();
    }
}