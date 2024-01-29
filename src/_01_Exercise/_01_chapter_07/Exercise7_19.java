package _01_Exercise._01_chapter_07;

/* 구매자 클래스 */
class Buyer {
    int money = 1000;
    Product[] cart = new Product[3];
    int i = 0;
    
    void buy(Product p) {
        if(money >= p.price) {
            money = money - p.price;
            add(p);
        }
        else {
            System.out.println("the balance is unsufficient");
            System.exit(0);    
        }
    }
    
    void add(Product p) {
        if(i >= cart.length) {
            Product[] cart = new Product[(this.cart.length)*2];
            
            for (int i = 0; i < this.cart.length; i++) {
                cart[i] = this.cart[i];
            }
            
            this.cart = cart;
        }
        cart[i] = p;
        i++;
    }
    
    void summary() {
        int a_spent = 0;
        
        System.out.println("---- cart list ----");
        for(int i = 0; i < cart.length; i++) {
            if(cart[i] != null) {
                System.out.println(cart[i]);
                a_spent = a_spent + cart[i].price;
            }
            else {
                break;
            }
        }
        System.out.println();
        
        System.out.println("---- amount spent ----");
        System.out.println(a_spent);
        System.out.println();
        
        System.out.println("---- balance ----");
        System.out.println(money);
    }
}

/* 상품 클래스 */
class Product {
    int price;
    
    Product(int price) {
        this.price = price;
    }
    
    Product() {
        this(0);
    }
}

class Tv extends Product {
    Tv() {
        super(100);
    }
    
    public String toString() {
        return "Tv";
    }
}
           
class Computer extends Product {
    Computer() {
        super(200);
    }
    
    public String toString() {
        return "Computer";
    }
}

class Audio extends Product {
    Audio() {
        super(50);
    }
    
    public String toString() {
        return "Audio";
    }
}

class Phone extends Product {
    Phone() {
        super(300);
    }
    
    public String toString() {
        return "Phone";
    }
}

class Exercise7_19 {
    public static void main(String[] args) {
        Buyer b = new Buyer();
        
        b.buy(new Computer());
        b.buy(new Audio());
        b.buy(new Tv());
        b.buy(new Phone());
        // b.buy(new Phone());
        // b.buy(new Computer());
        
        b.summary();        
    }
}