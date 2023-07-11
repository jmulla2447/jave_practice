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


    public static int[] findKthElement(int[] a, int k) {
//        List<Map.Entry<Integer, Long>> list = Arrays.stream(a)
//                .mapToObj(Integer::valueOf)
//                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
//                .entrySet()
//                .stream()
//                .filter(ele -> ele.getValue() >= 2);
        return null;
    }

    public static void main(String[] args) {
        NavigableSet<Double> ns = new TreeSet<>();
        ns.add(3d);
        ns.add(4d);
        ns.add(5d);
        ns.add(6d);
        ns.add(0d);
        ns.add(1d);
        ns.add(2d);


        // Get a reverse view of the navigable set
        NavigableSet<Double> reverseNs = ns.descendingSet();

        // Print the normal and reverse views
        System.out.println("Normal order: " + ns);
        System.out.println("Reverse order: " + reverseNs);

//        NavigableSet<Integer> threeOrMore = ns.tailSet(3, true);
//        System.out.println("3 or  more:  " + threeOrMore);
        System.out.println("lower(3): " + ns.lower(2.1d));
        System.out.println("floor(3): " + ns.floor(2.1d));
        System.out.println("higher(3): " + ns.higher(2.1d));
        System.out.println("ceiling(3): " + ns.ceiling(2.1d));

//        System.out.println("pollFirst(): " + ns.pollFirst());
//        System.out.println("Navigable Set:  " + ns);
//
//        System.out.println("pollLast(): " + ns.pollLast());
//        System.out.println("Navigable Set:  " + ns);
//
//        System.out.println("pollFirst(): " + ns.pollFirst());
//        System.out.println("Navigable Set:  " + ns);
//
//        System.out.println("pollFirst(): " + ns.pollFirst());
//        System.out.println("Navigable Set:  " + ns);
//
//        System.out.println("pollFirst(): " + ns.pollFirst());
//        System.out.println("Navigable Set:  " + ns);
//
//        System.out.println("pollFirst(): " + ns.pollFirst());
//        System.out.println("pollLast(): " + ns.pollLast());
    }

//    Given a String, find the first non-repeated character in it using Stream functions?
//    Given a String, find the first repeated character in it using Stream functions?

}
