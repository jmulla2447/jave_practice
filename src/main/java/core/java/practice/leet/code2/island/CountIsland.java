package core.java.practice.leet.code2.island;

public class CountIsland {
    public static void main(String[] args) {

        int[][] input = {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 1, 1}
        };

        Grid grid = new Grid(input);

        Island island = new Island();

        int result = island.countIslands(grid);

        System.out.println("Number of Islands: " + result);
    }
}
