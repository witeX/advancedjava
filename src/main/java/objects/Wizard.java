package objects;

public class Wizard implements Hero, Comparable<Wizard> {

    private int power;
    private int defence;

    public Wizard(int power, int defence) {
        this.power = power;
        this.defence = defence;
    }

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
        System.out.println("wizard moved to " + direction);

    }

    @Override
    public int attacked(Player attacker, int attackPower, int attackZone) {
        return 0;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello world");
    }

    @Override
    public int compareTo(Wizard o) {
        int cpm = this.power - o.power;
        if (cpm == 0) {
            return this.defence - o.defence;
        }
        return cpm;
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "power=" + power +
                ", defence=" + defence +
                '}';
    }
}
