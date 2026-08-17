package core.java.practice.leet.code2.island;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IslandTest {

    @Test
    void countIslands() {
        int[][] input = {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 1, 1}
        };

        Grid grid = new Grid(input);

        Island island = new Island();

        int result = island.countIslands(grid);

        assertEquals(result, 2);
    }
}
