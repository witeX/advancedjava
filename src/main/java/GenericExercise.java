import objects.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class GenericExercise {

    public static void main(String[] args) {

/*
        List<Integer> ints = new ArrayList<>();
        ints.add(1);

        List<? extends Number> nums = ints;
        Number val = nums.get(0);
        System.out.println(val) ; // here is Integer = 1
        nums.add(22.23d); // compile error - double extends numbers, but real list is for nums is List<Integer> compiler protects us
        nums.add(1); // compile error

*/
        List<Hero> heroes = new ArrayList<>();
        List<? extends Player> players = heroes;

        List<Number> nums = new ArrayList<>();
        nums.add(1L);
        nums.add(2.d);
        List<? super Integer> ints = nums;
        ints.add(3);
        Object object = ints.get(0);
        //  ints.add(3.0d); // nums accept only Integer - compilation error
        System.out.println(nums);


        multipleBoundaries();
        multiGenerics();
    }

    public static <T> T getFirst(Collection<T> coll) {
        Iterator<T> iterator = coll.iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }

    public static Integer getFirstInt(List<Integer> list) {
        return list.isEmpty() ? null : list.get(0);
    }

    public static <T> T getFirst(List<T> list) {
        return list.isEmpty() ? null : list.get(0);
    }

    public static <T extends Number> T getMax(List<T> list) {
        T maxNum = null;
        for (T t : list) {
            if (maxNum == null) {
                maxNum = t;
            }else {
                if (t.doubleValue() > maxNum.doubleValue()) {
                    maxNum=t;
                }
            }
        }
        return maxNum;
    }

    private static void multipleBoundaries() {
        List<Wolf> wolves = new ArrayList<>();
        wolves.add(new Wolf());
        List<Zombie> zombies = new ArrayList<>();
        acceptActiveEnemies(wolves);
        //acceptActiveEnemies(zombies); //Can't compile: it's enemy but passive
        zombies.add(new Zombie());
        acceptPassiveEnemies(zombies);
    }

    private static <T extends Enemy & Active> void acceptActiveEnemies(List<T> activeEnemies) {
        for (T activeEnemy : activeEnemies) {
            activeEnemy.enemySaySomething();
            activeEnemy.lookForHero();
        }
    }

    private static <T extends Enemy & Passive> void acceptPassiveEnemies(List<T> passiveEnemies) {
        for (T passiveEnemy : passiveEnemies) {
            passiveEnemy.enemySaySomething();
            passiveEnemy.waitForHero();
        }
    }

    private static void multiGenerics() {
        List<KeyValue<String, Player>> players = new ArrayList<>();
        players.add(new KeyValue<String, Player>("Aleksandr", new Wizard(10, 5)));
        players.add(new KeyValue<>("Dmitri", new Wizard(10, 6)));
        players.add(new KeyValue<>("Konstantin", new Wizard(10, 3)));
        players.add(new KeyValue<>("Wold Aljosha", new Wolf()));
//        players.add(new NamedEnemy<String>("Named wolf", new Wolf()));


        List<KeyValue<String, ? extends Player>> wildcardPlayers = new ArrayList<>();
        wildcardPlayers.add(new KeyValue<>("Aleksandr", new Wizard(10, 5)));
        wildcardPlayers.add(new KeyValue<>("Dmitri", new Wizard(10, 6)));
        wildcardPlayers.add(new KeyValue<>("Konstantin", new Wizard(10, 3)));
        wildcardPlayers.add(new KeyValue<>("Wold Aljosha", new Wolf()));
        wildcardPlayers.add(new NamedEnemy<String>("Named wolf", new Wolf()));
        wildcardPlayers.add(new NamedEnemy<String>("Named wolf", new Zombie()));
        wildcardPlayers.add(new NamedHero<>("Named wizard", new Wizard(4, 3)));
        System.out.println(players);


        System.out.println(getFirst(wildcardPlayers));
        reverse(wildcardPlayers);
        System.out.println(wildcardPlayers);
    }

    public static void reverse(List<?> list) {
        rev(list);
    }

    private static <T> void rev(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            list.set(i, tmp.get(list.size() - i - 1));
        }
    }
}
