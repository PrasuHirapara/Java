package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Creation {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        Stream<Integer> arrStream = Arrays.stream(arr);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        Stream<Integer> limit = Stream.iterate(0, x -> x + 1).limit(5);

        Stream<Integer> limit1 = Stream.generate(() -> (int) (Math.random() * 100)).limit(5);
    }
}
