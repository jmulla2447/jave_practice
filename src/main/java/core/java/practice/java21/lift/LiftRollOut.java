package core.java.practice.java21.lift;

import java.util.*;


public class LiftRollOut {

    private static final Random random = new Random();
    public static void main(String[] args) {
        System.out.println("=== How Many lift we need it ===");
        Scanner scanner = new Scanner(System.in);
        String liftInput = scanner.nextLine().trim();
        LiftController controller = new LiftController(Integer.parseInt(liftInput));

        //System.out.println("=== Multithreaded Lift System Active ===");
        //System.out.println("Enter requests in format: <Floor> <UP/DOWN> (e.g., '5 UP' or '2 DOWN')");
        //System.out.println("Type 'EXIT' to quit.\n");

        while (true) {

            if(userAtFloor() == 9) break;
            try {
                callLift(controller);
                callLift(controller);
            } catch (Exception e) {
                System.out.println("Invalid input format. Use: <Floor 1-10> <UP|DOWN>");
            }
        }
    }

    public static void callLift(LiftController controller){
        int needFloor = wentTo();
        Direction direction = needFloor < 0 ? Direction.DOWN : Direction.UP;
        int floor = Math.abs(needFloor);
        controller.pressButton(userAtFloor(), floor, direction);
    }

    public static int wentTo(){
        return random.nextInt(21) - 10;
    }

    public static int userAtFloor(){
        return random.nextInt(10) ;
    }
}
