package core.java.practice.leet.code;

import java.util.LinkedList;

public class TempChange {

    public int[] changeTemp(int[] temps) {
        LinkedList<Integer> topStack = new LinkedList<>();
        int[] output = new int[temps.length];//[30,40,50,60]
        for (int i = 0; i < temps.length - 1; i++) {
            int j = i + 1;
            while (j <= temps.length - 1 && temps[i] >= temps[j]) {
                topStack.push(temps[j]);
                j++;
            }
            output[i] = j > temps.length - 1 ? 0 : topStack.size() + 1;
            topStack = new LinkedList<>();

        }
        return output;
    }
}
