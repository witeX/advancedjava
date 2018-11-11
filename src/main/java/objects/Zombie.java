package objects;

public class Zombie implements Enemy, Passive {
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

    @Override
    public String toString() {
        return "Zombie{}";
    }

    @Override
    public void waitForHero() {
        System.out.println("Waiting for hero");
    }

    @Override
    public void enemySaySomething() {
        System.out.println("I'm zombie");
    }
}
