package chapter_07;

import java.util.Scanner;

class FinalCard {
    /* 상수지만 선언과 함께 초기화 하지 않고, 매개변수를 가지는 생성자를 통해, 인스턴스가 생성될 때 딱 한 번 초기화가 이루어짐.
    이후에 초기화는 불가능함 */
    final int NUMBER; 
    final String KIND;
    
    /* 카드의 크기(가로, 세로)는 모든 카드(인스턴스)가 같아야 하므로, 해당 클래스로부터
    생성되는 모든 인스턴스들이 공유하여, 모든 인스턴스가 같은 값을 가지게 되는 static 멤버변수로
    선언해 주었다. */
    
    static int width = 100;
    static int height = 250;
    
    FinalCard(int num, String kind) {
        NUMBER = num;
        KIND = kind;
    }
    
    FinalCard() { // 기본 생성자를 통하여 인스턴스를 생성하는 경우, 해당 인스턴스의 final 인스턴스 변수는 각각 1, king으로 초기화 됨
        this(1, "king");
    }
}

class Ex07_09_FinalCardTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        FinalCard[] cardArr = new FinalCard[52];
        
        int i; 
        int j;
        int temp = 0;
        
        for (i = 0; i < 4; i++) {
            String kind;
            
            System.out.println("Enter the kind of card");
            kind = scanner.nextLine();
            
            for (j = temp; j < (temp + 13); j++) {
                cardArr[j] = new FinalCard((j - i * 13) + 1, kind);
            }
            temp += 13;
        }
        
        for (int index = 0; index < 52; index++) {
            System.out.println("Kind : " + cardArr[index].KIND + ", Number : " + cardArr[index].NUMBER + ", width : " + cardArr[index].width + ", height : " + cardArr[index].height);
        }
    }
}

