package core.java.practice.bowling.v1;

import java.util.stream.IntStream;

public class PlayBowlGame {
    public static void main(String[] args) {
//        allStrike();
        allNull();
//        allSquare();
    }

    private static void allSquare() {
        BowlingGame game = new BowlingGame();
        IntStream.range(0, 21).forEach(i -> game.roll(5));
    }

    private static void allNull() {
        BowlingGame game = new BowlingGame();

        // Example game sequence
        IntStream.range(0, 20).forEach(i -> game.roll(1));

    }

    private static void allStrike() {
        BowlingGame game = new BowlingGame();

        // Example game sequence
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);

        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(10);

        game.roll(10);
        game.roll(10);

    }
}
