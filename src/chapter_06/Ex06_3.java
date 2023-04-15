package chapter_06;

public class Ex06_3 {
    public static void main(String[] args) {
        // 객체배열 요소 하나하나에 객체를 생성하여 주소 저장
        Car[] car_arr = new Car[3];
        
        car_arr[0] = new Car("porsche 911", "326,000,000");
        car_arr[1] = new Car("mercedes gt 4door 63amg", "367,000,000");
        car_arr[2] = new Car("audi R8", "280,000,000");
        
        // car_arr에 저장된 내용 출력
        System.out.println("----- List of cars -----");
        for (int i = 0; i < car_arr.length; i++) {
            System.out.println("[" + car_arr[i].name + " , " + car_arr[i].price + "]");
        }
    }
}