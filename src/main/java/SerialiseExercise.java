import java.io.*;
import java.net.URI;
import java.nio.ByteBuffer;

public class SerialiseExercise {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person person = new Person("Alex", "Beljakov");
        person.setOnlineTime(100);
        System.out.println(person);
        System.out.println("----------------------");
        File file = new File("person.s");

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(person);
        }
        Person personFromFile;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            personFromFile = (Person) ois.readObject();
        }
        System.out.println(personFromFile);

        InputStream inputStream = URI.create("https://www.lipsum.com/").toURL().openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

    }
}
