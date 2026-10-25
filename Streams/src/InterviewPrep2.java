import java.util.Arrays;
import java.util.List;

public class InterviewPrep2 {
    static void main() {
        List<Integer> numbers = Arrays.asList(5, 2, -8, 2, 3, 5, -9, 3);
        System.out.println(numbers.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0));

        // Fruits (good for startsWith, contains, joining)
        List<String> fruits = List.of("", "", "mango", "orange", "grape",
                "pineapple", "kiwi", "banana", "apple");

        System.out.println(fruits.stream().filter(i->i.length()!=0).findFirst().orElse("-1"));


    }
}
