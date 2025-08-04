public class main{
    public static void main(String[] args) {
        
        VehicleFactory factory=new VehicleFactory();
        Vehicle car=factory.createVehicle("car");
        Vehicle motorcycle=factory.createVehicle("motorcycle");
        Vehicle truck=factory.createVehicle("truck");

        car.drive();
        motorcycle.drive();
        truck.drive();
    }
}