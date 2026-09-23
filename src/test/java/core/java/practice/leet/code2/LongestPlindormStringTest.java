package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPlindormStringTest {

    @Test
    void fetchMaxPlindrom() {
        LongestPlindormString p =  new LongestPlindormString();
        String actual = p.fetchMaxPlindrom("forgeeksskeegfor");
        assertEquals("geeksskeeg", actual);

    }
}
