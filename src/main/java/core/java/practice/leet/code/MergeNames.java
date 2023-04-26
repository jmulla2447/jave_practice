package core.java.practice.leet.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MergeNames {



    public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> uniqueString  = new HashSet<>(Arrays.asList(names1));
        uniqueString.addAll(Arrays.asList(names2)) ;
        String[] allNames = new String[uniqueString.size()];
        return uniqueString.toArray(allNames);
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}
