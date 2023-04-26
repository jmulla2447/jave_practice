package core.java.practice.performance;

public class ComplexityCalulationUtil {

    public static void calculateComplexity(Runnable algorithm, int n) {
        long startTime = System.nanoTime();
        algorithm.run();
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Time complexity: O(f(n)), where f(n) = " + elapsedTime + " nanoseconds");
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Space complexity: O(g(n)), where g(n) = " + memoryUsed + " bytes");
    }
}
