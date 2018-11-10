package objects;

public class Wolf implements Enemy {
    @Override
    public int getHealthPoint() {
        return 0;
    }

    @Override
    public int getMaxHealthPoint() {
        return 0;
    }

    @Override
    public void move(String direction) {
        System.out.println("Wolf jumped to " + direction);
    }

    @Override
    public int attacked(Player attacker, int attackPower, int attackZone) {
        return 0;
    }
}
