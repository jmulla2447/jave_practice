package core.java.practice.leet.code2.island;

public class Island {

    public int countIslands(Grid grid) {

        int islandCount = 0;

        for (int x = 0; x < grid.getRows(); x++) {

            for (int y = 0; y < grid.getColumns(); y++) {

                // Skip water
                if (!grid.isLand(x, y)) {
                    continue;
                }

                // Skip already explored land
                if (grid.isVisited(x, y)) {
                    continue;
                }

                islandCount++;
                exploreIsland(grid, x, y, true);
            }
        }

        return islandCount;
    }

    private void exploreIsland(Grid grid, int x, int y, boolean conditionChecked) {
        if (!conditionChecked) {
            // Boundary check
            if (!grid.isValid(x, y)) {
                return;
            }

            // Water
            if (!grid.isLand(x, y)) {
                return;
            }

            // Already visited
            if (grid.isVisited(x, y)) {
                return;
            }
        }

        // Mark immediately
        grid.markVisited(x, y);

        // Explore four directions
        for (Direction direction : Direction.values()) {

            int newX = x + direction.getXDelta();
            int newY = y + direction.getYDelta();

            exploreIsland(grid, newX, newY, false);
        }
    }
}
