package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameTest {

    @Test
    void canJump() {

        JumpGame game = new JumpGame();
        boolean isPossible =  game.canJump(new int[]{2,3,1,1,4});
        assertTrue(isPossible);
    }

    @Test
    void canJumpFalse() {

        JumpGame game = new JumpGame();
        boolean isPossible =  game.canJump(new int[]{3,2,1,0,4});
        assertFalse(isPossible);
    }
}
