package core.java.practice.java8;

import java.util.ArrayList;
import java.util.List;

public class ArrayLIstNullBehavior {

    public static void main(String[] args) {
        List<String> list =  new ArrayList<>();
        list.add("J");
        list.add("P");
        list.add("P");
        list.add(null);
        System.out.println(list.indexOf("P"));
    }
}
