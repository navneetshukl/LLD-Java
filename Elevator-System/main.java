
public class main {

    public static void main(String[] args) {

        ElevatorController controller = new ElevatorController(3, 8, 10);

        controller.requestElevator(5, Direction.UP);
        controller.requestElevator(3, Direction.DOWN);
        controller.selectFloor(1, 7);
        controller.selectFloor(2, 1);

        // Run simulation for several steps
        for (int i = 0; i < 10; i++) {
            System.out.println("Step " + (i + 1));
            controller.step();
            controller.printStatus();
            try {
                Thread.sleep(1000); // Simulate time delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
