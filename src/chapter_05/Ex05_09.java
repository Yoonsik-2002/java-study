package chapter_05;

class Ex05_09 {
    public static void main(String[] args) {
        int[][] score = {
            {100, 90, 80},
            {90, 100, 88},
            {100, 99, 70},
            {100, 89, 79},
            {100, 100, 100}
        };
        
        // 과목별 점수의 총 합을 저장하는 전역변수 kor_score, eng_score, math_score
        int kor_score = 0, eng_score = 0, math_score = 0;
        
        System.out.println("번호 국어 영어 수학 총합 평균");
        System.out.println("==================================");
        
        /*이차원 배열 score을 다루는 이중 for문 - 행 배열(score[0] ~ score[4])과 행 배열의 참조변수들이 가리키는  열 배열(score[0][0] ~ score[4][2])을 다룬다.
          행 배열이 0 인경우 - 열 배열 score[0][0], score[0][1], score[0][2] 이런식으로 행 배열이 1번 반복할 때, 열 배열은 3번 반복함. 
        */
        for (int i = 0; i < score.length; i++) {    // 2차원 배열 score의 행 배열 만큼(index 0 ~ 4) 반복 하는 for문 - 과목별 총 합을 구할때 사용
            int ind_sum = 0;    // 개인별 점수의 총 합을 저장하는 지역변수 ind_sum
            float ind_avg = 0.0f;    // 개인별 점수의 평균을 저장하는 지역변수 ind_avg 
            
            kor_score += score[i][0];
            eng_score += score[i][1];
            math_score += score[i][2];
            
            System.out.printf("%3d", i + 1); 
            for (int j = 0; j < score[i].length; j++) {
                ind_sum += score[i][j];    // 학생별 점수 총 합을 저장. 해당 반복문의 3번 반목이 완료되어 종료되면, ind_sum은 다시 0이 된다.(0부터 다시 반복하여 다음 학생의 점수의 총 합을 저장)
                System.out.printf("%5d", score[i][j]);
            }
            ind_avg = ind_sum / (float)score[i].length;    // int 형 값과 int 형 값의 / 연산에선 당연히 int형 결과가 나옴. 때문에, score.length를 float으로 형변환 해 주어, float 형의 결과가 나오게 함.
            System.out.printf("%5d %5f", ind_sum, ind_avg);
            System.out.println();
        }
        System.out.println("==================================");
        System.out.printf("%8d %4d %4d", kor_score, eng_score, math_score);    // 과목별 점수의 총 합을 출력
        System.out.println();
    }
}