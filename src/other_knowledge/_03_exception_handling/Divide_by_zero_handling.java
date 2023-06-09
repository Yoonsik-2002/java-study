package _03_exception_handling;

import java.util.Scanner;

public class Divide_by_zero_handling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("나뉨수를 입력하세요 : ");
            int dividend = scanner.nextInt();
            
            System.out.println("나눗수를 입력하세요 : ");
            int divisor = scanner.nextInt();
            
            try {
                System.out.println(String.format("%d을(를) %d으로(로) 나누면 몫은 %d 입니다.", dividend, divisor, dividend/divisor));
                break;
            }
            catch (ArithmeticException e) {
                System.out.println("0으로 정수를 나눌 수 없습니다! 다시 입력하세요 !!");
            }
        }
    }
}