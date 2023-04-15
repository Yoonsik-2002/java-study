package chapter_06;
import java.util.Scanner;    

public class Ex06_5{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        
        // car_arr 객체배열 생성
        Car[] car_arr = new Car[3];
        
        // car_arr의 각 인자(참조변수)들에 객체를 생성하여 주소 저장
        for (int i = 0; i < car_arr.length; i++) {
            System.out.println("input name of the car : ");
            String name = scanner.nextLine();
            System.out.println("input price of the car : ");
            String price = scanner.nextLine();
            
            car_arr[i] = new Car(name, price);
        }
        
        // car_arr에 저장된 내용 출력
        System.out.println("------ List of cars ------");
        for (int i = 0; i < car_arr.length; i++) {
            System.out.println("[" + car_arr[i].name + " , " + car_arr[i].price + "]");
        }
    }
}