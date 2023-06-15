package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationTest {

    @Test
    void doCalculation() {
        Permutation permutation =  new Permutation();
        int[] a =  {1,2,3};
        System.out.println(permutation.permute(a));

        permutation =  new Permutation();
        a = new int[]{3, 2, 1};
        System.out.println(permutation.permute(a));
    }
}
