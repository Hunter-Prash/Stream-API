import java.util.Comparator;

class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class PriceComparator implements Comparator<Product>{
    @Override
    public int compare(Product p1,Product p2){
        return Integer.compare(p1.getPrice(), p2.getPrice());

    }


}