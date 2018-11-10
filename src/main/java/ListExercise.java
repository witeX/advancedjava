import java.util.*;

public class ListExercise {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("One");
        list.add("TWo");
        list.add("Three");
        list.add("Four");
        list.add("Seven");

        System.out.println(list);

        //list.remove(1);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " as array");
        }

        for (String val : list) {
            System.out.println(val + " simple for");
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next + " iterator");
        }

        System.out.println("Element four in list " + list.contains("four"));
        System.out.println("Element joke not in list " + list.contains("joke"));


        list.remove("three");
        Iterator<String> removeIterator = list.iterator();
        while (removeIterator.hasNext()) {
            if (removeIterator.next().startsWith("Se")) {
                removeIterator.remove();
            }
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        System.out.println(list);

    }
}
