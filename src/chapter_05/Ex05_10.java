package chapter_05;

class Ex05_10 {
    public static void main(String[] args) {
        // 5명의 학생의 국, 영, 수 과목별 점수와 각 학생의 총 점과 평균 점수를 저장하는 이차원 배열 score 
        int[][] score  = {
            {100, 80, 90},
            {100, 70, 80},
            {90, 100, 100},
            {99, 87, 77},
            {100, 68, 80}
        };
        
        // 과목별 총 점을 저장하는 변수 kor_score, eng_score, math_score
        int kor_score = 0, eng_score = 0, math_score = 0;
        
        System.out.println("번호 국어 영어 수학 총점 평균");
        System.out.println("==================================");
        
        for(int i = 0; i < score.length; i++) {
            int sum = 0;
            float avg = 0.0f;
            
            kor_score += score[i][0];
            eng_score += score[i][1];
            math_score += score[i][2];
            
            System.out.printf("%3d", i + 1); // %3d의 의미 : 3자리 10진수로 출력한다는 뜻, System.out.printf("%3d", 10); 은 [공백 1칸]10으로 출력됨
            
            for(int j = 0; j < score[i].length; j++) {
                sum += score[i][j];
                System.out.printf("%5d", score[i][j]);
            }
            avg = sum / (float)score[i].length;
            System.out.println(String.format("%5d %6.2f", sum, avg));
        }
        System.out.println("==================================");
        System.out.println(String.format("%8d %4d %4d", kor_score, eng_score, math_score));
    }
}