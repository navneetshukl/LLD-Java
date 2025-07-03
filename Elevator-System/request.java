
import java.util.Objects;

// Class representing a request (both internal and external)

class Request {

    private int floor;
    private Direction direction;
    private long timestamp;

    public Request(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
        this.timestamp = System.currentTimeMillis();
    }

    public int getFloor() {
        return floor;
    }

    public Direction getDirection() {
        return direction;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Request request = (Request) obj;
        return floor == request.floor && direction == request.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(floor, direction);
    }
}
