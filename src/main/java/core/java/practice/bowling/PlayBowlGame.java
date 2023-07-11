package core.java.practice.bowling;

import java.util.stream.IntStream;

public class PlayBowlGame {
    public static void main(String[] args) {
//        allStrike();
//        allNull();
        allSquare();
    }

    private static void allSquare() {
        BowlingGame game = new BowlingGame();
        IntStream.range(0, 21).forEach(i -> game.roll(5));
        int[] frameScores = game.score();
        System.out.println("Frame Scores: ");
        for (int frame = 0; frame < 10; frame++) {
            System.out.println("Frame " + (frame + 1) + ": " + frameScores[frame]);
        }
    }

    private static void allNull() {
        BowlingGame game = new BowlingGame();

        // Example game sequence
        game.roll(0);
        game.roll(0);
        game.roll(0);
        game.roll(0);
        game.roll(0);

        game.roll(0);
        game.roll(0);
        game.roll(0);
        game.roll(0);
        game.roll(0);


        int[] frameScores = game.score();
        System.out.println("Frame Scores: ");
        for (int frame = 0; frame < 10; frame++) {
            System.out.println("Frame " + (frame + 1) + ": " + frameScores[frame]);
        }
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

        int[] frameScores = game.score();
        System.out.println("Frame Scores: ");
        for (int frame = 0; frame < 10; frame++) {
            System.out.println("Frame " + (frame + 1) + ": " + frameScores[frame]);
        }
    }
}
