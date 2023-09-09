package chapter_06.practical_question;

class TV{
    String name;
    int year;
    int size;
    
    TV(String name, int year, int size) {
        this.name = name;
        this.year = year;
        this.size = size;
    }
    
    void show() {
        System.out.println(name + "에서 만든" + year + "년형" + size + "인치 TV");
    }
}

public class Question_01 {
    public static void main(String[] args) {
        TV myTV = new TV("LG", 2019, 32);
        myTV.show();
    }
}