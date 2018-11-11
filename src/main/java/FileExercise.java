import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class FileExercise {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        newFileIO();

        oldFileIO();


        serialize();
    }

    private static void newFileIO() throws IOException {
        Path path = Paths.get("/Users/abeljakov/IdeaProjects/sdacademy", "file.txt");
        Files.write(path, Arrays.asList("first", "second", "third", "fourth"));

        Path tempDir = Paths.get("/Users/abeljakov/IdeaProjects/sdacademy", "tempDir");
        Files.createDirectories(tempDir);
        //Files.createFile(Paths.get("/Users/abeljakov/IdeaProjects/sdacademy", "a.txt"));
        System.out.println(Files.isDirectory(tempDir));
        System.out.println(Files.isDirectory(path));
        System.out.println(new File(path.toUri()));
        System.out.println(Files.isExecutable(Paths.get("/usr/bin")));
        System.out.println(Files.isRegularFile(Paths.get("/usr/bin")));
        System.out.println(Files.isRegularFile(path));
        List<String> strings = Files.readAllLines(path);
        System.out.println(strings);
    }

    private static void oldFileIO() throws IOException {
        File file = new File("/Users/abeljakov/IdeaProjects/sdacademy", "file.txt");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))) {
            bufferedWriter.write("first");
            bufferedWriter.newLine();
            bufferedWriter.write("second");
            bufferedWriter.newLine();
            bufferedWriter.write("third");
            bufferedWriter.newLine();
            bufferedWriter.write("four");
            bufferedWriter.newLine();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }


    }

    private static void serialize() throws IOException, ClassNotFoundException {

        SerializablePerson person = new SerializablePerson("Aleksnadr", "Beljakov", 32);
        person.setOnline(true);
        System.out.println(person);

        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/abeljakov/IdeaProjects/sdacademy", "person.txt"))) {
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(person);
        }
        SerializablePerson deserializedPerson;
        try (FileInputStream fileInputStream = new FileInputStream(new File("/Users/abeljakov/IdeaProjects/sdacademy", "person.txt"))) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            deserializedPerson = (SerializablePerson) objectInputStream.readObject();
        }
        System.out.println(deserializedPerson);
    }
}
