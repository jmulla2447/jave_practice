package core.java.practice.leet.code;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // Count the frequency of each element using a HashMap
        Map<Integer, Integer> frequencyMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(num -> num, num -> 1, Integer::sum));

        // Create a min heap using a PriorityQueue
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        // Add the entries from the frequency map to the min heap
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the element with the smallest frequency
            }
        }

        // Retrieve the top K frequent elements from the min heap

        return minHeap.stream().map(a -> a.getKey()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1,2,9,1,4,1,2,9,0};
        int k = 3;

        TopKFrequentElements elements = new TopKFrequentElements();
        List<Integer> topKFrequentElements = elements.topK1(nums, k);
        System.out.println("Top " + k + " frequent elements: " + topKFrequentElements);
    }

    public static List<Integer> topK(int[] e, int target) {
        //lowerFreq and HigherFreq need to add element into the
        int lowerFreq = 1, higherFreq = 1;
        Map<Integer, Integer> freqMap = new HashMap<>();
        LinkedList<Integer> res = new LinkedList<>();

        for (int i = 0; i < e.length; i++) {
            if (freqMap.containsKey(e[i])) {
                int freq = freqMap.get(e[i]);
                freq = ++freq;
                freqMap.put(e[i], freq);
                if (freq >= lowerFreq && !res.contains(e[i])) {
                    if(freq == lowerFreq) {
                        res.removeLast();
                        res.addLast(e[i]);
                    }else{
                        res.removeLast();
                        res.addFirst(e[i]);
                    }
                    if (freq >= higherFreq) {
                        higherFreq = freq;
                    } else if (freq > lowerFreq) {
                        lowerFreq = freq;
                    }
                }
                else if (res.contains(e[i])) {
                    res.remove(Integer.valueOf(e[i]));
                    res.addFirst(e[i]);
                    if (freq >= higherFreq) {
                        higherFreq = freq;
                    } else if (freq > lowerFreq) {
                        lowerFreq = freq;
                    }
                }
            } else {
                freqMap.put(e[i], 1);
                if (res.size() < target) {
                    res.add(e[i]);
                }
            }
        }
        return res;

    }

    LinkedList<Integer> res = new LinkedList<>();
    int lowerBound;

    public  List<Integer> topK1(int[] ele, int target) {
        int[] countingArr = new int[(int) (ele.length * 1.5)];
        int count = 0;
        //counting
        for (int i : ele) {
            count = countingArr[i];
            countingArr[i] = ++count;
            createResult(count,  target, i);
        }

        //22103101
        return res;
    }


    public void createResult(int freq, int target,int ele){
        if(res.size()<target){
            res.add(ele);
        } else if (freq > lowerBound){
            res.removeLast();
            res.addFirst(ele);
        }
        lowerBound = Math.max(lowerBound, freq);
    }

}
