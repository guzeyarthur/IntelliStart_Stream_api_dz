import util.StreamTool;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StartApp {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("a", "b", "c", "d", "E", "F", "G", "K");
        System.out.println(StreamTool.getNamesWithOddIndices(names));
        System.out.println(StreamTool.getSortAndUpperCase(names));
        List<String> numbers = Arrays.asList("1, 2, 0", "4, 5", "6", "66", "77, 88");
        System.out.println(StreamTool.getNumbersInList(numbers));
        StreamTool.getInfiniteRandomStream(10l, 25214903917l, 11l, pow(2,48))
                .peek((e) -> System.out.println(e))
                .limit(20)
                .collect(Collectors.toList());
        final Stream<Integer> first = Stream.of(1, 2, 3, 15, 20, 21, 24, 16);
        final Stream<Integer> second = Stream.of(9, 10, 11, 12, 13);
        final List<Integer> res = StreamTool.zip(first, second).collect(Collectors.toList());
        System.out.println(res);
    }

    private static long pow(long value, int powValue) {
        BigInteger a = new BigInteger(String.valueOf(value));
        return a.pow(powValue).longValue();
    }
}
