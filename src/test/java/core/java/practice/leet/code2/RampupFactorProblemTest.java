package core.java.practice.leet.code2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RampupFactorProblemTest {

    @Test
    void totalWorkingMinute() {
        RampupFactorProblem problem = new RampupFactorProblem();
        assertEquals(25, problem.totalWorkingMinute("WWIIIWIII"));
    }

    @Test
    void totalWorkingMinuteWIII() {
        RampupFactorProblem problem = new RampupFactorProblem();
        assertEquals(5, problem.totalWorkingMinute("WIII"));
    }


    @Test
    void totalWorkingMinuteIIII() {
        RampupFactorProblem problem = new RampupFactorProblem();
        assertEquals(0, problem.totalWorkingMinute("IIII"));
    }

    @Test
    void totalWorkingMinuteWWWW() {
        RampupFactorProblem problem = new RampupFactorProblem();
        assertEquals(0, problem.totalWorkingMinute("WWWW"));
    }
}
