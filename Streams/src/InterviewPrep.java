import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewPrep {

    static void main() {
        List<Integer> numbers = Arrays.asList(5, 2, -8, 2, 3, 5, -9, 3);

        //sum of even nos.
        Integer dsds=numbers.stream().filter(i->i%2==0).reduce(0,(a,b)->a+b);
        System.out.println(dsds + "==============================");

        // 2. orElse(default): safe, gives a fallback when empty
        System.out.println(numbers.stream().mapToInt(Integer::intValue).max().orElse(0));

        // sum of all numbers
        Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        // only non-negative numbers
        numbers.stream()
                .filter(n -> n >= 0)
                .forEach(n -> System.out.println(n));

        // descending order
        Comparator<Integer> naturalOrder = (a, b) -> Integer.compare(a, b);
        numbers.stream()
                .sorted(naturalOrder.reversed())
                .forEach(n -> System.out.println(n));

        List<String> names = List.of("Rahul", "Amit", "Priya", "Neha", "Vikram");

        String joinedNames = names.stream()
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(joinedNames);
    }
}