package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TempChangeTest {

    @Test
    void changeTemp() {
        TempChange change = new TempChange();
        int[] temps  = {30,40,50,60};
        Arrays.stream(change.changeTemp(temps)).forEach(System.out::println);
    }
}
