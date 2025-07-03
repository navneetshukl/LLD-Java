
import java.util.Set;
import java.util.TreeSet;

// Individual Elevator class
class Elevator {

    private int elevatorId;
    private int currentFloor;
    private Direction currentDirection;
    private ElevatorStatus status;
    private Set<Integer> destinationFloors;
    private int capacity;
    private int currentLoad;

    public Elevator(int elevatorId, int capacity) {
        this.elevatorId = elevatorId;
        this.currentFloor = 1;// starting at ground floor
        this.currentDirection = Direction.IDLE;
        this.status = ElevatorStatus.STOPPED;
        this.destinationFloors = new TreeSet<>();
        this.capacity = capacity;
        this.currentLoad = 0;
    }

// Add internal request (from inside elevator)
    public void addDestination(int floor) {
        if (floor != currentFloor) {
            destinationFloors.add(floor);
            updateDirection();
        }
    }

// Move elevator one floor in current direction
    public void move() {
        if (status != ElevatorStatus.MOVING) {
            return;
        }

        if (currentDirection == Direction.UP) {
            currentFloor++;
        } else if (currentDirection == Direction.DOWN) {
            currentFloor--;
        }

        // Check if we need to stop at current floor
        if (destinationFloors.contains(currentFloor)) {
            destinationFloors.remove(currentFloor);
            status = ElevatorStatus.STOPPED;
            System.out.println("Elevator " + elevatorId + " stopped at floor " + currentFloor);

            // Update direction after stopping
            updateDirection();
        }
    }

// Update elevator direction based on pending requests
    private void updateDirection() {
        if (destinationFloors.isEmpty()) {
            currentDirection = Direction.IDLE;
            status = ElevatorStatus.STOPPED;
            return;
        }

        // Find next destination
        Integer nextFloor = getNextDestination();
        if (nextFloor != null) {
            if (nextFloor > currentFloor) {
                currentDirection = Direction.UP;
            } else if (nextFloor < currentFloor) {
                currentDirection = Direction.DOWN;
            }
            status = ElevatorStatus.MOVING;
        }
    }

    // Get next destination based on current direction (SCAN algorithm)
    private Integer getNextDestination() {
        TreeSet<Integer> floors = (TreeSet<Integer>) destinationFloors;

        if (currentDirection == Direction.UP || currentDirection == Direction.IDLE) {
            // Get nearest floor above current floor
            Integer nextUp = floors.ceiling(currentFloor + 1);
            if (nextUp != null) {
                return nextUp;
            }

            // If no floors above, get highest floor below
            return floors.floor(currentFloor - 1);
        } else {
            // Get nearest floor below current floor
            Integer nextDown = floors.floor(currentFloor - 1);
            if (nextDown != null) {
                return nextDown;
            }

            // If no floors below, get lowest floor above
            return floors.ceiling(currentFloor + 1);
        }
    }

    // Check if elevator can take a request
    public boolean canTakeRequest(Request request) {
        if (status == ElevatorStatus.MAINTENANCE) {
            return false;
        }
        if (currentLoad >= capacity) {
            return false;
        }

        // If elevator is idle, it can take any request
        if (currentDirection == Direction.IDLE) {
            return true;
        }

        // If request is in same direction and elevator hasn't passed the floor
        if (request.getDirection() == currentDirection) {
            if (currentDirection == Direction.UP && request.getFloor() >= currentFloor) {
                return true;
            }
            if (currentDirection == Direction.DOWN && request.getFloor() <= currentFloor) {
                return true;
            }
        }

        return false;
    }
    // Calculate distance to serve a request

    public int getDistanceToServe(Request request) {
        if (currentDirection == Direction.IDLE) {
            return Math.abs(currentFloor - request.getFloor());
        }

        if (canTakeRequest(request)) {
            return Math.abs(currentFloor - request.getFloor());
        }

        // If can't serve directly, calculate total distance needed
        Integer furthestFloor = getFurthestDestination();
        if (furthestFloor != null) {
            return Math.abs(currentFloor - furthestFloor) + Math.abs(furthestFloor - request.getFloor());
        }

        return Integer.MAX_VALUE;
    }

    private Integer getFurthestDestination() {
        TreeSet<Integer> floors = (TreeSet<Integer>) destinationFloors;
        if (floors.isEmpty()) {
            return null;
        }

        if (currentDirection == Direction.UP) {
            return floors.last();
        } else {
            return floors.first();
        }
    }

    // Getters
    public int getElevatorId() {
        return elevatorId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public ElevatorStatus getStatus() {
        return status;
    }

    public boolean hasDestinations() {
        return !destinationFloors.isEmpty();
    }

    // For passenger entry/exit
    public void addPassenger() {
        if (currentLoad < capacity) {
            currentLoad++;

        }
    }

    public void removePassenger() {
        if (currentLoad > 0) {
            currentLoad--;

        }
    }

}
