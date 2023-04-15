package chapter_06;

public class Ex06_4{
    public static void main(String[] args) {
        // 배열의 초기화 블록을 사용하여 객체배열 생성하기 
        Car[] car_arr = {new Car("porsche 911", "286,000,000"), new Car("mercedes 63amg gt 4door", "360,000,000"), new Car("audi R8", "238,000,000")};
        
        // car_arr에 저장된 내용 출력
        System.out.println("------ List of cars ------");
        for (int i = 0; i < car_arr.length; i++) {
            System.out.println("[" + car_arr[i].name + " , " + car_arr[i].price + "]");
        }
    }
}