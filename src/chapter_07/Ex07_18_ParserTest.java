package chapter_07;

interface Parseable{
    /* 구문 분석작업을 수행하도록 설계된 추상메서드 Parse */
    public abstract void parse(String fileName); 
}

class XMLParser implements Parseable {  // 인터페이스 Parseable을 구현.
    public void parse(String fileName) {  // 오버라이딩된 메서드의 접근 제어자 범위는 기존 부모로부터 상속받은 메서드의 범위보다 넓거나 같아야 함.
        /* 구문 분석작업을 수행하는 코드 작성 */
        System.out.println(fileName + " - XML parsing completed");
    }
}

class HTMLParser implements Parseable {
    public void parse(String fileName) {
        /* 구문 분석작업을 수행하는 코드 작성 */
        System.out.println(fileName + " - HTML parsing completed");
    }
}

class ParserManager {
    public static Parseable getParser(String type) {
        if(type.equals("XML")) {
            XMLParser p = new XMLParser();
            return p;  // 반환 타입인 Parseable 인터페이스를 구현한 XMLParser클래스의 인스턴스를 반환.
            // return new XMLParser();
        } else {
            HTMLParser p = new HTMLParser();
            return p;  // 반환 타입인 Parseable 인터페이스를 구현한 HTMLParser클래스의 인스턴스를 반환.
            // reutrn new HTMLParser();
        }
    }
}

class Ex07_18_ParserTest {
    public static void main(String[] args) {
        Parseable parser = ParserManager.getParser("XML"); 
        // 인터페이스 Parseable 타입의 참조변수 parser로 해당 인터페이스를 구현한 XMLParser클래스의 인스턴스를 참조
        parser.parse("document.xml");
        
        parser = ParserManager.getParser("HTML");
        // 인터페이스 Parseable 타입의 참조변수 parser로 해당 인터페이스를 구현한 HTMLParser클래스의 인스턴스를 참조
        parser.parse("document2.html");
    }
}