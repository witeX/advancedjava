import generics.GenericPlayerHolder;
import objects.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        GenericPlayerHolder<Hero> playerHolder = new GenericPlayerHolder<>(new Wizard(1, 2));
        playerHolder.getPlayer().sayHello();
        moveNorth(playerHolder);
        playerHolder.setPlayer(new Wizard(1, 2));
        GenericPlayerHolder<Wizard> wizardGenericPlayerHolder = new GenericPlayerHolder<>(new Wizard(1, 2));
        moveNorth(wizardGenericPlayerHolder);

        GenericPlayerHolder<Enemy> enemyHolder = new GenericPlayerHolder<>(new Wolf());
        enemyHolder.move("North");


        List<Wizard> wizards = new ArrayList<>();
        wizards.add(new Wizard(10, 2));
        wizards.add(new Wizard(2, 3));
        wizards.add(new Wizard(10, 5));
        wizards.add(new Wizard(2, 4));
        wizards.add(new Wizard(3, 4));
        System.out.println(wizards);
        Collections.sort(wizards);
        Collections.sort(wizards, new WizardComparator());
        System.out.println(wizards);

    }

    private static void moveNorth(GenericPlayerHolder<? extends Hero> holder) {
        holder.move("North");
    }

    private static class WizardComparator implements Comparator<Wizard> {
        @Override
        public int compare(Wizard o1, Wizard o2) {
            return o1.getMaxHealthPoint() - o2.getMaxHealthPoint();
        }
    }
}
