package core.java.practice.leet.code;

import java.util.*;

public class MinStack {
    private TreeMap<Integer, Integer> map;
    private List<Integer> order;

    public MinStack() {
        map = new TreeMap<>();
        order = new ArrayList<>();
    }

    public void push(int val) {
        map.put(val, val);
        order.add(val);
    }

    public void pop() {
        map.remove(order.remove(order.size() - 1));
    }

    public int top() {
        return map.get(order.remove(order.size() - 1));
    }

    public int getMin() {
        int val = map.remove(map.firstKey());
        order.remove(Integer.valueOf(val));
        return val;
    }
}
