package core.java.practice.leet.code2.island;

public enum Direction {

    NORTH(-1, 0),
    EAST(0, 1),
    WEST(0, -1),
    SOUTH(1, 0);

    private final int xDelta;
    private final int yDelta;

    Direction(int xDelta, int yDelta) {
        this.xDelta = xDelta;
        this.yDelta = yDelta;
    }

    public int getXDelta() {
        return xDelta;
    }

    public int getYDelta() {
        return yDelta;
    }
}
