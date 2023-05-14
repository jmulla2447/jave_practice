package core.java.practice.leet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LURTest {


    @Test
    public void addCache() {
        //actual
        LUR lru = new LUR(3);
        //when
        lru.addCache(1);
        lru.addCache(2);
        lru.addCache(3);
        lru.addCache(4);
        lru.addCache(2);
        lru.addCache(1);
        //assert
        assertEquals(3, lru.getSize());
        lru.display();
    }
}
