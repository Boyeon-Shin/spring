package hello.core.singleton;

public class StateFulService {
    
//    private int price;
    
    public int order(String name , int price) {
        System.out.println("name = " + name + ", price = " + price);
        return price;
//        this.price = price;
    }

    public void getPrice() {
//        return price;
    }
}
