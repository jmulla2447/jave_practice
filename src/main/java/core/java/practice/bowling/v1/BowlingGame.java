package core.java.practice.bowling.v1;

public class BowlingGame {
    private Frame[] frames;

    private int currentFrame;

    private int totalScore;

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
        if (currentFrame - 1 >= 0) frames[currentFrame - 1].addBonusRoll(pins);
        if (currentFrame - 2 >= 0) frames[currentFrame - 2].addBonusRoll(pins);

        if (current.isComplete(currentFrame) && currentFrame < 9) {
            currentFrame++;
        }
    }


}
