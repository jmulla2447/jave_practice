package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentElementTest {

    @Test
    void topKFrequent() {

        int[] a = {1,1,1,2,2,3};
        TopKFrequentElements element =  new TopKFrequentElements();
        element.topKFrequent(a, 2);

    }
}
