package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Permutation1Test {

    @Test
    void permute() {
        Permutation1 permutation = new Permutation1();
        int[] a =  {1,2,3,4};
        System.out.println(permutation.permute(a));
    }
}
