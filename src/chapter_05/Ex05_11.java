package chapter_05;

import java.util.Scanner;

class Ex05_11 {
    public static void main(String[] args) {
        
         Scanner scanner = new Scanner(System.in);
        
        String[][] quiz = {
            {"Benefit", "혜택"},
            {"Attitude", "태도"},
            {"Community", "집단"},
            {"Contribute", "기여하다"},
            {"Adept", "능숙한"},
            {"Explain", "설명하다"},
            {"Intelligent", "지적인"},
            {"Sociable", "사교적인"},
            {"Training", "훈련"},
            {"Vote", "투표하다"}
        };
        
        System.out.println(String.format("%d 개의 단어 문제 준비 완료!", quiz.length));
        System.out.println();
        
        for (int i = 0; i < quiz.length ; i++) {
            System.out.printf("Quiz %d. %s의 뜻은? >> ", i + 1, quiz[i][0]);
            String tmp = scanner.nextLine();
            
            if (tmp.equals(quiz[i][1])) {
                System.out.printf("정답입니다!! %n%n");
            } else {
                System.out.printf("틀렸습니다. 정답은 %s입니다. %n%n", quiz[i][1]);
            }
        }
    }
}