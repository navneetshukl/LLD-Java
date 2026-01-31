public class Main {
    public static void main(String[] args) {

        TrafficLight light = new TrafficLight();

        for (int i = 0; i < 6; i++) {
            System.out.println("Current color: " + light.getColor());
            light.change();
        }
    }
}
