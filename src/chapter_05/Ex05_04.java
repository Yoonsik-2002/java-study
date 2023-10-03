package chapter_05;

class Ex05_04 {
    public static void main(String[] args) {
        int[] score = {66, 33, 48, 90, 80, 77, 100, 20};
        
        int max = score[0];
        int min = score[0];
        
        for (int i = 1; i < score.length; i++) {
            // 같은 시작점(index = 0)의 2개의 조건을 동시에 돌림.
            
            if(score[i] > max) {   // 만약 score[i]가 max보다 크면 max = score[i]
                max = score[i];
            } else if(score[i] < min) {   // 그리고 만약(조건 중첩) score[i]가 min 보다 작으면 min = score[i] (else if문은 새로운 조건을 추가하여 중첩 가능하다!)
                min = score[i];
            }
        }
        
        System.out.println("최대값 : " + max);
        System.out.println("최소값 : " + min);
    }
}
