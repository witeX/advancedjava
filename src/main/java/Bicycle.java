import java.util.ArrayList;
import java.util.List;

public class Bicycle {
    private int maxSpeed = 40;
    private List<Integer> wheelSpeeds = new ArrayList<>();

    public int getMaxSpeed() {
        return maxSpeed;
    }

    protected void setMaxSpeed(int speed) {
        this.maxSpeed = speed;
    }

    public class Wheel {
        public void damage() {
            maxSpeed *= 0.5;
        }
    }

    public static class Mechanic {

        public void repair(Bicycle bicycle) {
            bicycle.maxSpeed += 10;
        }
    }
}