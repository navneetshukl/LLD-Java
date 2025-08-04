
class VehicleFactory {

    public Vehicle createVehicle(String type) {
        if (type == null) {
            return null;
        }

        switch (type.toLowerCase()) {
            case "car" -> {
                return new car();
            }
            case "motorcycle" -> {
                return new motorcycle();
            }

            case "truck" -> {
                return new Truck();
            }
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + type);

        }
    }
}
