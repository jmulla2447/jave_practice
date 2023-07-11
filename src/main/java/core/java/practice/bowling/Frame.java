package core.java.practice.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    private List<Integer> rolls;

    private boolean strike;

    private boolean square;

    private int[] bonusRolls;

    public void setStrike(boolean strike) {
        this.strike = strike;
    }

    public void setSquare(boolean square) {
        this.square = square;
    }

    public Frame() {
        rolls = new ArrayList<>();
    }

    public void addRoll(int pins) {
        rolls.add(pins);
    }

    public List<Integer> getRollScore() {
        return rolls;
    }

    public boolean isCompleted(int currentFrame) {
        return   rolls.size() == 2;
    }

    public boolean isStrike(int currentFrame) {
        this.strike = rolls.size() == 1 && rolls.get(0) == 10 &&  currentFrame != 9;
        return this.strike;
    }

    public boolean isSquare(int currentFrame) {
        this.square = rolls.size() == 2 && (rolls.get(0) + rolls.get(1)) == 10 &&  currentFrame != 9;
        return this.square;
    }
}
