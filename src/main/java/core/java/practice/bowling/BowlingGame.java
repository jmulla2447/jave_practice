package core.java.practice.bowling;

public class BowlingGame {
    private Frame[] frames;
    private int currentFrame;
    private int nextFrameIndex;
    private int currentFrameIndex;

    public BowlingGame() {
        frames = new Frame[10];
        currentFrame = 0;

        for (int i = 0; i < 10; i++) {
            frames[i] = new Frame();
        }
    }

    public void roll(int pins) {
        Frame current = frames[currentFrame];
        current.addRoll(pins);

        if (current.isCompleted(currentFrame) && currentFrame < 9) {
            currentFrame++;
        }
    }

    public int[] score() {
        int[] frameScores = new int[10];
        int totalScore = 0;


        for (currentFrameIndex = 0; currentFrameIndex < frames.length; currentFrameIndex++) {
            nextFrameIndex = currentFrameIndex + 1;
            if (frames[currentFrameIndex].isStrike(currentFrameIndex)) {
                totalScore += 10;
                if (frames[nextFrameIndex].isStrike(nextFrameIndex)) {
                    totalScore += (frames[nextFrameIndex].getRollScore().get(0) + frames[currentFrameIndex + 2].getRollScore().get(0));
                } else {
                    totalScore += (frames[nextFrameIndex].getRollScore().get(0) + frames[nextFrameIndex].getRollScore().get(1));
                }
            } else if (frames[currentFrameIndex].isSquare(currentFrameIndex)) {
                totalScore += 10;
                totalScore += currentFrameIndex <9? frames[nextFrameIndex].getRollScore().get(0) : frames[currentFrameIndex].getRollScore().stream().reduce(0, Integer::sum)-10;
            }else {
                totalScore += (frames[currentFrameIndex].getRollScore().stream().reduce(0, Integer::sum));
            }
            frameScores[currentFrameIndex] = totalScore;
        }

        return frameScores;
    }

}
