package core.java.practice.leet.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> integerList = Arrays.stream(nums).mapToObj(Integer::valueOf).collect(Collectors.toCollection(LinkedList::new));
        if(nums.length == 1) return  List.of(integerList);
        int size  =  nums.length;
        for(int i= 0 ; i< size ;i ++){
           int no =  integerList.remove(i);
           result.addAll(doCalculation(integerList, no));
           size =  integerList.size();
        }
        return result;
    }
    public List<List<Integer>>  doCalculation(LinkedList<Integer> listInt, int no) {
        int move = listInt.size() - 1;
        List<List<Integer>> result = cornerMove(listInt, no);
        if (move > 0) result.addAll(betweenMove(listInt, no, move));
        return result;
    }

    private List<List<Integer>> betweenMove(LinkedList<Integer> a, int no, int len) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= len; i++) {
            result.add(addElement(i, no, a));
        }
        return result;
    }

    private List<List<Integer>> cornerMove(LinkedList<Integer> a, int no) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(addElement(true, no, a));
        result.add(addElement(false, no, a));
        return result;
    }

    private LinkedList<Integer> addElement(int index, int no, LinkedList<Integer> a) {
        LinkedList<Integer> temp = new LinkedList<>(a);
        temp.add(index, no);
        return temp;
    }

    private LinkedList<Integer> addElement(boolean isFirst, int no, LinkedList<Integer> a) {
        LinkedList<Integer> temp = new LinkedList<>(a);
        temp.addFirst(no);
        return temp;
    }
}
