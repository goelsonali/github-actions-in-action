//anymatch, allMatch, noneMatch, findFirst, findAny

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Day12 {

    //Check has evens
    static void task() {
        List<Integer> input = List.of(1,2,3,4,6,8);

        boolean hasEven = input.stream().anyMatch(i -> i%2 == 0);
        boolean allEven = input.stream().allMatch(i -> i%2==0);
        Optional<Integer> findFirst = input.stream().filter(i -> i%2 == 0).findFirst();
        Optional<Integer> findAny = input.stream().filter(i -> i%2 ==0).findAny();

        System.out.println("Has any even values: " + hasEven);
        System.out.println("Has all even values: " + allEven);
        System.out.println("Find first even value: " + findFirst.get());
        System.out.println("Find any even value: " + findAny.get());



    }

    static void main(String[] args) {
        task();
    }

}
