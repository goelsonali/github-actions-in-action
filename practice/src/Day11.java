import java.util.List;

public class Day11 {

    static void task() {
        List<Integer> input = List.of(2,4,6,8);

        int sum = input.stream()
                .peek(i -> System.out.println("Current value: " + i))
                .map(i -> i*2)
                .peek(i -> System.out.println("Doubled value: " + i))
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Sum of doubled values: " + sum); // Sum of doubled values: 32

        // peek() does not modify the stream
    }

    static void main(String[] args) {
        task();
    }
}
