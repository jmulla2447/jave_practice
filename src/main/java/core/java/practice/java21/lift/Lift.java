package core.java.practice.java21.lift;


import java.util.concurrent.ConcurrentSkipListSet;

class Lift implements Runnable {
    private final int id;
    private int currentFloor;
    private volatile Direction direction = Direction.IDLE;

    // Thread-safe set to store targets sorted by floor number
    private final ConcurrentSkipListSet<Integer> targets = new ConcurrentSkipListSet<>();

    public Lift(int id, int initialFloor) {
        this.id = id;
        this.currentFloor = initialFloor;
    }

    public int getId() { return id; }
    public int getCurrentFloor() { return currentFloor; }
    public Direction getDirection() { return direction; }

    public void addDestination(int floor) {
        targets.add(floor);
    }

    public int calculateCost(Request request) {
        int distance = Math.abs(this.currentFloor - request.getFloor());
        if (this.direction == Direction.IDLE) return distance;

        // Moving towards request in same direction
        if ((this.direction == Direction.UP && request.getDirection() == Direction.UP && request.getFloor() >= this.currentFloor) ||
                (this.direction == Direction.DOWN && request.getDirection() == Direction.DOWN && request.getFloor() <= this.currentFloor)) {
            return distance;
        }
        return distance + 10; // Penalty if moving away
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (targets.isEmpty()) {
                this.direction = Direction.IDLE;
                try {
                    Thread.sleep(200); // Poll interval when idle
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                continue;
            }

            // Determine next target floor based on current direction
            Integer targetFloor = getNextTarget();
            if (targetFloor == null) continue;

            if (targetFloor > currentFloor) {
                this.direction = Direction.UP;
                stepMove(1);
            } else if (targetFloor < currentFloor) {
                this.direction = Direction.DOWN;
                stepMove(-1);
            } else {
                // Arrived at destination
                targets.remove(currentFloor);
                System.out.println("\n[LIFT " + id + "] >>> Arrived at Floor " + currentFloor + " <<<");
                try {
                    Thread.sleep(1500); // Simulate doors opening/closing
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private Integer getNextTarget() {
        if (targets.isEmpty()) return null;
        if (direction == Direction.UP || direction == Direction.IDLE) {
            // Get nearest floor going up, otherwise get lowest target
            Integer higher = targets.ceiling(currentFloor);
            return higher != null ? higher : targets.first();
        } else {
            // Get nearest floor going down, otherwise get highest target
            Integer lower = targets.floor(currentFloor);
            return lower != null ? lower : targets.last();
        }
    }

    private void stepMove(int delta) {
        try {
            Thread.sleep(1000); // 1 second to move 1 floor
            currentFloor += delta;
            System.out.println("[LIFT " + id + "] Passing Floor " + currentFloor + " (" + direction + ")");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
