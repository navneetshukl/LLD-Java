public class GreenLight implements TrafficState {

    @Override
    public void next(TrafficLight light) {
        System.out.println("Changing Green -> Yellow");
        light.setState(new YellowLight());
    }

    @Override
    public String getColor() {
        return "Green";
    }
}
