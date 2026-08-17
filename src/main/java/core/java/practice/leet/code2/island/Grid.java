package core.java.practice.leet.code2.island;

public class Grid {

    private static final int LAND = 1;

    private final int[][] cells;
    private final boolean[][] visited;

    public Grid(int[][] cells) {

        if (cells == null || cells.length == 0) {
            throw new IllegalArgumentException("Grid cannot be empty");
        }

        this.cells = cells;
        this.visited = new boolean[cells.length][cells[0].length];
    }

    public boolean isLand(int x, int y) {
        return cells[x][y] == LAND;
    }

    public boolean isVisited(int x, int y) {
        return visited[x][y];
    }

    public void markVisited(int x, int y) {
        visited[x][y] = true;
    }

    public boolean isValid(int x, int y) {
        return x >= 0 &&
                x < getRows() &&
                y >= 0 &&
                y < getColumns();
    }

    public int getRows() {
        return cells.length;
    }

    public int getColumns() {
        return cells[0].length;
    }

    public int getValue(int x, int y) {
        return cells[x][y];
    }
}
