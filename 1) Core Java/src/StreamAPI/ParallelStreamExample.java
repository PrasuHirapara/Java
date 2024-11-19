package StreamAPI;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(45, 46, 78, 1, 545, 95, 56, 34);

        list.parallelStream()
                .map(x -> x * 2)
                .forEach(System.out::println);
    }
}