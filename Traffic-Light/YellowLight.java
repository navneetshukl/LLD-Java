public class YellowLight implements TrafficState {

    @Override
    public void next(TrafficLight light) {
        System.out.println("Changing Yellow -> Red");
        light.setState(new RedLight());
    }

    @Override
    public String getColor() {
        return "Yellow";
    }
}
