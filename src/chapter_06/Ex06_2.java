package chapter_06;

class Ex06_2 {
    public static void main(String[] args) {
        Tv tv1 = new Tv();
        Tv tv2 = new Tv();
        
        System.out.println("tv1 의 채널값은 " + tv1.channel + " 입니다.");
        System.out.println("tv2 의 채널값은 " + tv2.channel + " 입니다.");
        
        tv1.channel = 7;
        System.out.println("tv1 의 채널값을 7로 변경하였습니다.");
        
        System.out.println("tv1 의 채널값은 " + tv1.channel + " 입니다.");
        System.out.println("tv2 의 채널값은 " + tv2.channel + " 입니다.");
    } 
}
    