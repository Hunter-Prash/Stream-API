import java.util.Comparator;
import java.util.List;

public class Test1 {
    static void main(String[] args) {
        List<String> names = List.of("Prashant", "Pramod", "Arun", "Divya", "Karthik");
        names.stream().forEach(i->System.out.println(i));

        List<Integer> x=List.of(10, 25, 3, 48, 7, 62, 15);
        x.stream().sorted().limit(2).forEach(i->System.out.println(i));

        List<Integer>y=List.of(5, 3, 5, 1, 3, 9, 1);
        y.stream().distinct().sorted(Comparator.reverseOrder()).forEach(i->System.out.println(i));
        
        Comparator<String> c=(a,b)->a.length()-b.length();
        names.stream().sorted(c).forEach(i->System.out.println(i));
    }
}
