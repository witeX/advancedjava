package objects;

import javax.swing.*;

public class Wolf implements Enemy, Active {
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
        return "Wolf{}";
    }

    @Override
    public void lookForHero() {
        System.out.println("Looking where is hero");
    }

    @Override
    public void enemySaySomething() {
        System.out.println("I'm wolf");
    }
}
