public class TrafficLight {

    private TrafficState currentState;

    public TrafficLight() {
        // initial state is Red
        currentState = new RedLight();
    }

    public void setState(TrafficState state) {
        this.currentState = state;
    }

    // called by user to move to next state
    public void change() {
        currentState.next(this);
    }

    public String getColor() {
        return currentState.getColor();
    }
}
