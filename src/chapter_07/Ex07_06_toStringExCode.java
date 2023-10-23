package chapter_07;

class ExCard {
  int cardNum;

  ExCard(int cardNum) {
    this.cardNum = cardNum;
  }
}

class Ex07_06_toStringExCode {
  public static void main(String[] args) {
    ExCard card = new ExCard(14);

    System.out.println(card);
  }
}

/* 결과 : chapter_07.ExCard@28d93b30

객체(card)가 인스턴스로 있는 클래스의 이름 'chapter_07.M_Card' + 기호문자 '@' + 객체의 부호 없는 16진수 해쉬코드 표기
'28d93b30' = 'chapter_07.M_Card@28d93b30' */