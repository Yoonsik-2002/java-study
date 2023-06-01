package chapter_05;

class Ex05_8 {
    public static void main(String[] args) {
        int[][] score = {
                         {100, 90, 70},
                         {80, 60, 100}, 
                         {100, 90, 80},
                         {98, 77, 100},
        };
        int sum = 0;
        
        for(int i = 0; i < score.length; i++) {
            for(int j = 0; j < score[0].length; j++) {
                System.out.println(String.format("score[%d][%d] = %d\n", i, j, score[i][j]));
                
                sum += score[i][j];
            }
        }
        
        System.out.println("총합 : " + sum);
    }
}