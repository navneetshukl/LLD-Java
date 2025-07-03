
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ElevatorController {

    private List<Elevator> elevators;
    private Queue<Request> pendingRequests;
    private int totalFloors;

    public ElevatorController(int numElevators, int elevatorCapacity, int totalFloors) {
        this.elevators = new ArrayList<>();
        this.pendingRequests = new LinkedList<>();
        this.totalFloors = totalFloors;

        // Initialize elevators
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(i + 1, elevatorCapacity));
        }
    }

    public void requestElevator(int floor, Direction direction) {
        if (floor < 1 || floor > totalFloors) {
            System.out.println("Invalid floor: " + floor);
            return;
        }

        Request request = new Request(floor, direction);
        System.out.println("Request received: Floor " + floor + " Direction " + direction);

        // try to assign the best elevator
        Elevator bestElevator = findBestElevator(request);
        if (bestElevator != null) {
            bestElevator.addDestination(floor);
            System.out.println("Request assigned to Elevator " + bestElevator.getElevatorId());
        } else {

            // Add to pending requests if no elevator available
            pendingRequests.offer(request);
            System.out.println("Request added to pending queue");
        }

    }

    // Internal request (from inside elevator)
    public void selectFloor(int elevatorId, int floor) {
        if (elevatorId < 1 || elevatorId > elevators.size()) {
            System.out.println("Invalid elevator ID: " + elevatorId);
            return;
        }

        if (floor < 1 || floor > totalFloors) {
            System.out.println("Invalid floor: " + floor);
            return;
        }

        Elevator elevator = elevators.get(elevatorId - 1);
        elevator.addDestination(floor);
        System.out.println("Floor " + floor + " selected in Elevator " + elevatorId);
    }

    private Elevator findBestElevator(Request request) {
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            if (elevator.canTakeRequest(request)) {
                int distance = elevator.getDistanceToServe(request);
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
        }
        return bestElevator;
    }

    // Process pending requests
    private void processPendingRequests() {
        Iterator<Request> iterator = pendingRequests.iterator();

        while (iterator.hasNext()) {
            Request request = iterator.next();
            Elevator bestElevator = findBestElevator(request);
            bestElevator.addDestination(request.getFloor());
            iterator.remove();
            System.out.println("Pending request processed: Floor " + request.getFloor());
        }
    }

    // step simulation - move all elevators
    public void step() {
        // Move all elevators

        for (Elevator elevator : elevators) {
            elevator.move();
        }

        // Process pending requests
        processPendingRequests();
    }

    // Get system status
    public void printStatus() {
        System.out.println("\n=== Elevator System Status ===");
        for (Elevator elevator : elevators) {
            System.out.println("Elevator " + elevator.getElevatorId()
                    + ": Floor " + elevator.getCurrentFloor()
                    + ", Direction " + elevator.getCurrentDirection()
                    + ", Status " + elevator.getStatus()
                    + ", Has Destinations: " + elevator.hasDestinations());
        }
        System.out.println("Pending Requests: " + pendingRequests.size());
        System.out.println("===============================\n");
    }
}


// ========== DESIGN PATTERNS EXPLANATION ==========
/*
 * EXISTING PATTERNS IN THE ORIGINAL CODE:
 * 
 * 1. STRATEGY PATTERN (Implicit):
 *    - findBestElevator() method implements a strategy
 *    - getNextDestination() uses SCAN algorithm strategy
 *    - These could be extracted into separate strategy classes
 * 
 * 2. FACADE PATTERN:
 *    - ElevatorController acts as a facade
 *    - Provides simple interface: requestElevator(), selectFloor()
 *    - Hides complex elevator coordination logic
 * 
 * 3. COMMAND PATTERN (Implicit):
 *    - Request class represents a command
 *    - Contains all info needed to execute the command
 *    - Could be enhanced with execute() method
 * 
 * 4. TEMPLATE METHOD PATTERN (Implicit):
 *    - move() method follows a template:
 *      1. Check if should move
 *      2. Move in direction
 *      3. Check if should stop
 *      4. Update direction
 * 
 * 5. OBSERVER PATTERN (Can be added):
 *    - System.out.println() statements are basic observers
 *    - Could be enhanced with proper observer interfaces
 */