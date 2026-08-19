package core.java.practice.java21.understand.thread1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SplittableRandom;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

class Main {
    static final class ScenarioResult {
        final String name;
        final long elapsedNanos;
        final long total;

        ScenarioResult(String name, long elapsedNanos, long total) {
            // Store outcome for printing.
            this.name = name;
            this.elapsedNanos = elapsedNanos;
            this.total = total;
        }
    }

    interface Scenario {
        // Runs scenario and returns summed count.
        long run(List<String> userIds, int threads, int incrementsPerThread);
    }

    public static void main(String[] args) {
        int threads = Math.max(2, Runtime.getRuntime().availableProcessors());
        int incrementsPerThread = 1_000_000;
        int userCount = 10_000;

        List<String> userIds = buildUserIds(userCount);
        long expected = (long) threads * (long) incrementsPerThread;

        System.out.println("-".repeat(66));
        System.out.println("Java version           : " + System.getProperty("java.version"));
        System.out.println("Threads                : " + threads);
        System.out.println("Increments per thread  : " + incrementsPerThread);
        System.out.println("User IDs               : " + userCount);
        System.out.println("Expected total         : " + expected);
        System.out.println("-".repeat(66));

        Scenario syncMapScenario = (ids, t, inc) -> runSynchronizedMap(ids, t, inc);
        Scenario chmAdderScenario = (ids, t, inc) -> runConcurrentHashMapLongAdder(ids, t, inc);

        // Warmup to reduce cold-start effects.
        runAndVerify("Warmup: synchronizedMap", syncMapScenario, userIds, threads, incrementsPerThread / 5, (long) threads * (incrementsPerThread / 5));
        runAndVerify("Warmup: CHM+LongAdder", chmAdderScenario, userIds, threads, incrementsPerThread / 5, (long) threads * (incrementsPerThread / 5));

        ScenarioResult r1 = timeScenario("synchronizedMap<Long>", syncMapScenario, userIds, threads, incrementsPerThread);
        verifyTotal(r1.name, r1.total, expected);
        printResult(r1, expected);

        ScenarioResult r2 = timeScenario("ConcurrentHashMap<LongAdder>", chmAdderScenario, userIds, threads, incrementsPerThread);
        verifyTotal(r2.name, r2.total, expected);
        printResult(r2, expected);

        System.out.println("-".repeat(66));
        System.out.println("Note: Marked non-runnable here because threads are disallowed in this sandbox.");
        System.out.println("-".repeat(66));
    }

    static List<String> buildUserIds(int userCount) {
        // Pre-create stable keys for both scenarios.
        List<String> ids = new ArrayList<>(userCount);
        for (int i = 0; i < userCount; i++) {
            ids.add("user-" + i);
        }
        return Collections.unmodifiableList(ids);
    }

    static ScenarioResult timeScenario(String name, Scenario scenario, List<String> userIds, int threads, int incrementsPerThread) {
        // Keep timing limited to the work.
        long start = System.nanoTime();
        long total = scenario.run(userIds, threads, incrementsPerThread);
        long end = System.nanoTime();
        return new ScenarioResult(name, end - start, total);
    }

    static void runAndVerify(String name, Scenario scenario, List<String> userIds, int threads, int incrementsPerThread, long expected) {
        // Verify warmup isn't broken.
        long total = scenario.run(userIds, threads, incrementsPerThread);
        verifyTotal(name, total, expected);
    }

    static void verifyTotal(String name, long actual, long expected) {
        // Fail fast on correctness issues.
        if (actual != expected) {
            throw new IllegalStateException(name + " total mismatch: actual=" + actual + " expected=" + expected);
        }
    }

    static void printResult(ScenarioResult r, long expectedOps) {
        // Report both time and throughput.
        double seconds = r.elapsedNanos / 1_000_000_000.0;
        double opsPerSec = expectedOps / seconds;
        System.out.println(r.name);
        System.out.printf("  Elapsed: %.3f s (%d ms)%n", seconds, r.elapsedNanos / 1_000_000);
        System.out.printf("  Throughput: %.2f ops/s%n", opsPerSec);
        System.out.println("  Verified total: " + r.total);
        System.out.println("-".repeat(66));
    }

    static long runSynchronizedMap(List<String> userIds, int threads, int incrementsPerThread) {
        Map<String, Long> map = Collections.synchronizedMap(new HashMap<>());
        Thread[] workers = new Thread[threads];

        for (int t = 0; t < threads; t++) {
            final int threadIndex = t;
            workers[t] = new Thread(() -> {
                // Deterministic per-thread random selection.
                SplittableRandom rnd = new SplittableRandom(0xC0FFEE ^ (long) threadIndex);
                int nUsers = userIds.size();

                // Spread increments across stable user keys.
                for (int i = 0; i < incrementsPerThread; i++) {
                    String user = userIds.get(rnd.nextInt(nUsers));
                    synchronized (map) {
                        Long cur = map.get(user);
                        map.put(user, cur == null ? 1L : cur + 1L);
                    }
                }
            });
            workers[t].start();
        }

        // Join all workers before summing counts.
        for (Thread w : workers) {
            try {
                w.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while joining", e);
            }
        }

        long sum = 0L;
        for (Long v : map.values()) {
            sum += v;
        }
        return sum;
    }

    static long runConcurrentHashMapLongAdder(List<String> userIds, int threads, int incrementsPerThread) {
        ConcurrentHashMap<String, LongAdder> map = new ConcurrentHashMap<>();
        Thread[] workers = new Thread[threads];

        for (int t = 0; t < threads; t++) {
            final int threadIndex = t;
            workers[t] = new Thread(() -> {
                // Deterministic per-thread random selection.
                SplittableRandom rnd = new SplittableRandom(0xC0FFEE ^ (long) threadIndex);
                int nUsers = userIds.size();

                // computeIfAbsent avoids extra locking.
                for (int i = 0; i < incrementsPerThread; i++) {
                    String user = userIds.get(rnd.nextInt(nUsers));
                    map.computeIfAbsent(user, k -> new LongAdder()).increment();
                }
            });
            workers[t].start();
        }

        // Join all workers before summing counts.
        for (Thread w : workers) {
            try {
                w.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while joining", e);
            }
        }

        long sum = 0L;
        for (LongAdder adder : map.values()) {
            sum += adder.longValue();
        }
        return sum;
    }
}
