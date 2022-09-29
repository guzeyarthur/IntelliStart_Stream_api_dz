package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTool {
    public static List<String> getNamesWithOddIndices(List<String> names) { // TASK #1
        return names.stream()
                .filter(name -> names.indexOf(name)%2 == 1)
                .map(name -> names.indexOf(name) + ". " + name)
                .collect(Collectors.toList());
    }

    public static List<String> getSortAndUpperCase(List<String> elements) { // TASK #2
        return elements.stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.charAt(0)-a.charAt(0))
                .collect(Collectors.toList());
    }

    public static List<String> getNumbersInList(List<String> elements) { // TASK #3
        return elements.stream()
                .flatMap(p -> Arrays.stream(p.split(",")))
                .map(String::trim)
                .sorted()
                .collect(Collectors.toList());
    }

    public static Stream<Long> getInfiniteRandomStream(long seed, long a, long c, long m) { // TASK #4
        return Stream.iterate(seed, x -> 1*(a * x + c) % m);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) { // TASK #5
        final Iterator<T> firstIterator = first.iterator();
        final Iterator<T> secondIterator = second.iterator();
        final List<T> storage = new ArrayList<>();
        while (firstIterator.hasNext() || secondIterator.hasNext()) {
            final T fEl = firstIterator.next();
            storage.add(fEl);
            if (!firstIterator.hasNext()) {
                break;
            }

            final T sEl = secondIterator.next();
            storage.add(sEl);
            if (!secondIterator.hasNext()) {
                break;
            }
        }
        return storage.stream();
    }
}