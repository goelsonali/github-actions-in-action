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
        boolean notOdd = input.stream().noneMatch(i -> i%2!=0);
        Optional<Integer> findFirst = input.stream().filter(i -> i%2 == 0).findFirst();
        Optional<Integer> findAny = input.stream().filter(i -> i%2 ==0).findAny();

        System.out.println("Has any even values: " + hasEven);
        System.out.println("Has all even values: " + allEven);
        System.out.println("Has any odd values: " +notOdd);
        System.out.println("Find first even value: " + findFirst.get());
        System.out.println("Find any even value: " + findAny.get());

        List<String> words = List.of("apple", "banana", "avocado", "cherry", "date");
        //Check if any word start with 'a'
        boolean hasWordWithA = words.stream().anyMatch(s -> s.startsWith("a"));
        System.out.println("Any words starts with 'a': " + hasWordWithA);

        //Check if all words have length > 3
        //use peek.
        boolean allWordsWithLengthThree = words.stream().allMatch( s -> s.length() > 3 );
        System.out.println("Has all words length greater than 3: " + allWordsWithLengthThree);

        //Check none of the words is empty
        boolean noEmptyWord = words.stream().noneMatch(String::isEmpty);
        System.out.println("Has NO empty words: " +noEmptyWord);
    }

    static void main(String[] args) {
        task();
    }

}
