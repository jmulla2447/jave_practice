package core.java.practice.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Practice {

    public static List<Integer> findOutOddNumberList(int[] a) {
        return Arrays.stream(a).filter(odd -> odd % 2 == 0).mapToObj(Integer::valueOf).collect(Collectors.toList());
    }

    public static List<Integer> findDuplicateElementList(int[] a) {
        Set<Integer> unique = new HashSet<>();
        return Arrays.stream(a).filter(no -> !unique.add(no)).mapToObj(Integer::valueOf).collect(Collectors.toList());
    }

    public static Character findFirstNonRepeatedChar(String input) {

        return input.chars() // Stream of String
                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey())
                .findFirst()
                .get();
    }

    public static Character findFirstRepeatedChar(String ip) {
        return ip.chars().mapToObj(c -> Character.toLowerCase(Character.valueOf((char) c)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(ele -> ele.getValue() > 1L)
                .map(ele -> ele.getKey())
                .findFirst()
                .get();
    }

//    Given a String, find the first non-repeated character in it using Stream functions?
//    Given a String, find the first repeated character in it using Stream functions?

}
