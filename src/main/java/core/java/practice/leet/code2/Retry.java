package core.java.practice.leet.code2;

import java.util.concurrent.Callable;

public class Retry {

    public static <T> T retry(Callable<T> operation, int maxRetries)
            throws Exception {

        long delay = 1000; // 1 second

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                return operation.call();
            } catch (Exception e) {

                if (attempt == maxRetries) {
                    throw e;
                }

                Thread.sleep(delay);

                delay *= 2;
            }
        }

        throw new IllegalStateException("Unreachable");
    }
}
