package core.java.practice.bowling.v1;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private List<Integer> rolls;

    private boolean strike;

    private boolean square;

    private int bonusRolls;
    private static int totalFrameScore;
    private boolean isScoreCal;

    private List<Integer> bonus;

    public void setStrike(boolean strike) {
        this.strike = strike;
    }

    public void setSquare(boolean square) {
        this.square = square;
    }

    public Frame() {
        rolls = new ArrayList<>();
        bonus = new ArrayList<>();
    }

    public void addRoll(int pins) {
        rolls.add(pins);
    }

    public List<Integer> getRollScore() {
        return rolls;
    }

    public boolean isComplete(int currentFrame) {
        return isStrike(currentFrame) || isSquare(currentFrame) || isFrameComplete(currentFrame);
    }

    public boolean isFrameComplete(int currentFrame) {
        isScoreCal = (currentFrame == 9 && rolls.get(0) == 10) ? rolls.size() == 3 : rolls.size() == 2;
        if (isScoreCal) {
            totalFrameScore += getFrameScore();
            System.out.println(totalFrameScore);
        }

        return isScoreCal;
    }

    private int getFrameScore() {
        if (this.strike) {
            return rolls.get(0);
        }
        return rolls.stream().reduce(0, Integer::sum);
    }

    public boolean isStrike(int currentFrame) {
        this.strike = rolls.size() == 1 && rolls.get(0) == 10 && currentFrame != 9;
        if (this.strike) bonusRolls = 2;
        return this.strike;
    }

    public boolean isSquare(int currentFrame) {
        this.square = rolls.size() == 2 && getFrameScore() == 10 && currentFrame != 9;
        if (this.square) bonusRolls = 1;
        return this.square;
    }

    public void addBonusRoll(int pins) {
        if (bonus.size() <= bonusRolls) {
            bonus.add(pins);
        }
        if (bonus.size() == bonusRolls && !isScoreCal) {
            isScoreCal = true;
            totalFrameScore += getFrameScore() + bonus.stream().reduce(0, Integer::sum);
            System.out.println(totalFrameScore);
        }
    }

}
