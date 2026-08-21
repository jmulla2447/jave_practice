package core.java.practice.java21.lift;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class LiftController {
    private final List<Lift> lifts = new ArrayList<>();
    private final ExecutorService executor;

    public LiftController(int numLifts) {
        executor = Executors.newFixedThreadPool(numLifts);
        for (int i = 1; i <= numLifts; i++) {
            Lift lift = new Lift(i, 1);
            lifts.add(lift);
            executor.submit(lift); // Start each lift thread
        }
    }

    public synchronized void pressButton(int userAtFloor, int floor, Direction direction) {
        Request request = new Request(floor, direction);
        Lift bestLift = null;
        int minCost = Integer.MAX_VALUE;

        for (Lift lift : lifts) {
            int cost = lift.calculateCost(request);
            if (cost < minCost) {
                minCost = cost;
                bestLift = lift;
            }
        }

        if (bestLift != null) {
            System.out.println("[DISPATCH] Assigned Lift " + bestLift.getId() + " to Floor " + floor);
            bestLift.addDestination(floor);
        }
    }

    public void shutdown() {
        executor.shutdownNow();
    }
}
