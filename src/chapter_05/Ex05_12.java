package chapter_05;

import java.util.Scanner;

class Ex05_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        String[] words = {"television", "computer", "mouse", "phone"};
        
        for (int i = 0; i < words.length; i++) {
            char[] question = words[i].toCharArray(); // String 배열의 요소를 char배열로 변환하여 char배열의 레퍼런스 변수 question에 저장
            
            for (int j = 0; j < question.length; j++) {
                int rand = (int)(Math.random() * question.length); // 0 ~ question.length - 1 까지에 해당하는 정수 중, 무작위로 하나 뽑아, rand에 저장
                
                char temp = question[0];
                question[0] = question[rand];
                question[rand] = temp;
            }
            
            System.out.printf("Q%d. %s의 정답을 입력하세요 > ", i + 1, new String(question));
            String answer = scanner.nextLine();
            
            if(words[i].equals(answer.trim()))
                System.out.printf("맞았습니다!%n%n");
            else 
                System.out.printf("틀렸습니다.%n%n");
        }
        
        scanner.close();
    }
}