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
        set.add("Five");

        set.remove("Five");

        System.out.println(set);

    }
}
