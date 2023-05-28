package chapter_05;

class Ex05_6 {
    public static void main(String[] args) {
        int[] ball = new int[45];
        
        for (int i = 0; i < ball.length; i++) {
            ball[i] = i + 1;
        }
        
        // 배열의 인덱스가 i인 값과 ball의 45개의 인덱스중 임의의 한 인덱스에 저장된 값을 서로 바꿔서 값을 섞음
        // 결론적으로 ball의 인덱스 0, 1, 3, 4, 5 인것 까지 총 6개의 요소가 바뀌게 된다. 
        
        for (int i = 0; i < 6; i++) {
            int rand = (int)(Math.random() * 45);
            
            int temp = ball[i];
            ball[i] = ball[rand];
            ball[rand] = temp;
        }
        
        
        for (int i = 0; i < 6; i++) {
            System.out.printf("ball[%d] = %d%n", i, ball[i]);
        }
    }
}