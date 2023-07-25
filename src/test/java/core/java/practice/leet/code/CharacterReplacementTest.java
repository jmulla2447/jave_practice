package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterReplacementTest {

    @Test
    void longesSubstringReplacement() {
        CharacterReplacement replacement = new CharacterReplacement();
        assertEquals(3,replacement.longesSubstringReplacement("BAAA", 2));
    }
}
