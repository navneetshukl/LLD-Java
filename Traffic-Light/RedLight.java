public class RedLight implements TrafficState {

    @Override
    public void next(TrafficLight light) {
        System.out.println("Changing Red -> Green");
        light.setState(new GreenLight());
    }

    @Override
    public String getColor() {
        return "Red";
    }
}
