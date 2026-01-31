public interface TrafficState {
    void next(TrafficLight light);   // move to next state
    String getColor();               // return current color
}
