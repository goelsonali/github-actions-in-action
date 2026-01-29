import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day9 {

    public static void task() {
        // groupingBy vs partitioningBy
        //if condition result yes/no -> partitionBy
        //if condition produces many keys -> groupingBy

        //partitioningBy divides data in 2 groups,
        //key -> boolean value -> predicate based

        //groupingBy
        //splits data into N groups.
        //key -> any_type value -> function based

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);
        Map<Boolean, List<Integer>> mapOfEvenAndOdd = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n%2== 0));
        System.out.println("Partitioning Example " + mapOfEvenAndOdd); // {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8]}

        Map<Integer, List<Integer>> groupByEven = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2));
        System.out.println("GroupingBy Example " + groupByEven);

        List<String> words = List.of("apple", "avocado", "banana", "berry", "date");
        Map<Character,List<String>> result = words.stream().collect(Collectors.groupingBy(w -> w.charAt(0)));
        System.out.println("GroupingBy words " + result);
    }

   static void main(String[] args) {
        task();
    }
}
