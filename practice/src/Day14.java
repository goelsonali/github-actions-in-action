import java.util.List;

public class Day14 {

    public static void task() {
        //streams and limit
        List<Integer> numbers = List.of(1,3,4,5,6,7,8,10,2);
        List<Integer> results = numbers.stream().filter(i -> i%2==0).limit(3).toList();
        System.out.println("Limited to 3 even numbers: " + results);

        //takeWhile

        results = numbers.stream().sorted().takeWhile( n -> n<= 5).toList();
        System.out.println("Numbers less than 5: " + results);

    }

    static void main(String[] args) {
        task();
    }
}
