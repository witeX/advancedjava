import java.util.Set;

public class VehicleMain {
    public static void main(String[] args) {
        Bicycle.Mechanic mechanic = new Bicycle.Mechanic();
        Bicycle bicycle = new Bicycle();
        System.out.println(bicycle.getMaxSpeed());

        Bicycle.Wheel wheel = bicycle.new Wheel();
        wheel.damage();

        System.out.println(bicycle.getMaxSpeed());
        mechanic.repair(bicycle);
        System.out.println(bicycle.getMaxSpeed());

        System.out.println("-===========");
        Car car = new Car();

        System.out.println(car.getMaxSpeed());
        for (Car.Wheel wheel1 : car.getWheels()) {
            wheel1.damage();
        }

        System.out.println(car.getMaxSpeed());

        for (Car.Wheel wheel1 : car.getWheels()) {
            wheel1.damage();
        }

        System.out.println(car.getMaxSpeed());
    }
}
