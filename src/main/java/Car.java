import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Car implements Serializable {
    private int maxSpeed = 50;
    private Set<Wheel> wheels =
            new HashSet<>(
                    Arrays.asList(
                            new Wheel(),                            new Wheel(),
                            new Wheel(),                            new Wheel()));

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public Set<Wheel> getWheels() {
        return wheels;
    }

    public class Wheel implements Serializable{
        private Wheel(){

        }
        private boolean health = true;

        public void damage() {
            if (health) {
                maxSpeed -= 10;
                health = false;
            }
        }

        @Override
        public String toString() {
            return "Wheel{" +
                    "health=" + health +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "maxSpeed=" + maxSpeed +
                ", wheels=" + wheels +
                '}';
    }
}
