// 총합과 평균 예제

package chapter_05;

class Ex05_03 {
    public static void main(String[] args) {
        int sum = 0; 
        float average = 0f;
        
        int[] score = {100, 90, 80, 80, 90, 100};
        
        for (int i = 0; i < score.length; i++) {
            sum = sum + score[i];
        }
        
        average = sum / (float)score.length;    // int 타입과 int 타입끼리의 연산은 int 타입의 값을 결과로 내보내기 때문에, 정확한 평균값을 얻지 못함. 그래서, score.length를 float 타입으로 변환하여 나눗셈 함
        
        System.out.println("총합 : " + sum);
        System.out.println("평균 : " + average);
    }
}
