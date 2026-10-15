import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class MiniProject2 {
    String name;
    int price;

    public MiniProject2(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    static void main(String[] args) {
        List<String> productNames = Arrays.asList("Laptop", "Mouse", "Keyboard", "Monitor");//fill the name
        List<Integer> productPrices = Arrays.asList(60000, 500, 2000, 12000);//fill the price
        List<MiniProject2> products = new ArrayList<>();

        for (int index = 0; index < 4; index++) {
            products.add(new MiniProject2(productNames.get(index), productPrices.get(index)));
        }

        System.out.println(products.get(0));//MiniProject2@27716f4

        //Manually writing the comparatoer
        Comparator<MiniProject2> priceAscendingComparator =
                (firstProduct, secondProduct) ->
                        Integer.compare(firstProduct.getPrice(), secondProduct.getPrice());

        //manual comparison of 2 objects by price
        int priceComparisonResult =
                priceAscendingComparator.compare(products.get(0), products.get(1));
        //System.out.println(result);

        //sorting the whole list using streams via price
        products.stream()
                .sorted(priceAscendingComparator)
                .forEach(product -> System.out.println(product.getPrice()));

        //using Method referencing instead of manual comparator
        Comparator<MiniProject2> priceComparatorUsingMethodReference =
                Comparator.comparingInt(MiniProject2::getPrice);

        products.stream()
                .sorted(priceComparatorUsingMethodReference)
                .forEach(product -> System.out.println(product.getPrice()));

        //Manually writing the comparator
        Comparator<MiniProject2> nameAscendingComparator =
                (firstProduct, secondProduct) ->
                        firstProduct.getName().compareTo(secondProduct.getName());

        //manual comparison of 2 objects by name
        int nameComparisonResult =
                nameAscendingComparator.compare(products.get(0), products.get(1));

        //sorting the whole list using streams via name in descending order just add reversed
        products.stream()
                .sorted(nameAscendingComparator.reversed())
                .forEach(product -> System.out.println(product.getName()));

        //using Method referencing instead of manual comparator
        Comparator<MiniProject2>bydadfas=Comparator.comparing(MiniProject2::getName);
        products.stream().sorted(bydadfas).forEach(i-> System.out.println(i.getName()));


    }
}
