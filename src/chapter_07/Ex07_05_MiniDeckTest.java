package chapter_07;

class M_Card {
  int number;

  M_Card(int number) {
    this.number = number;
  }
}

class M_Deck {
  final static int CARD_MAX = 5;
  M_Card[] cardArr = new M_Card[CARD_MAX];

  M_Deck() {
    for (int i = 0; i < CARD_MAX; i++) {
      cardArr[i] = new M_Card(i + 1);
    }
  }

  void show() {
    for (int i = 0; i < cardArr.length; i++) {
      System.out.println("System.out.println() : " + cardArr[i]);
      System.out.println("Apply the toString() method : " + cardArr[i].toString());
      System.out.println("");
    }
  }
}

class Ex07_05_MiniDeckTest {
    public static void main(String[] args) {
        M_Deck d = new M_Deck();
        
        d.show();
    }
}
