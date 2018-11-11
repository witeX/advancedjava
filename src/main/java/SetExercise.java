import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetExercise {


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");

        set.remove("Five");

        System.out.println(set);


        Set<Person> people = new HashSet<>();
        people.add(new Person("Aleksandr", "Beljakov"));
        people.add(new Person("Aleksandr", "Beljakov"));
        people.add(new Person("Aleksandr", "Beljakov"));
        people.add(new Person("Vasja", "Pupkin"));
        Person ivan = new Person("Ivan", "Ivanov");
        people.add(ivan);
        Person ivanov = new Person("Ivanov", "Ivan");
        people.add(ivanov);

        System.out.println(ivan.hashCode() + " = " + ivanov.hashCode());
        System.out.println(ivan.equals(ivanov));

        System.out.println(people);
    }
}
