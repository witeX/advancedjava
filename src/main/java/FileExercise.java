import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileExercise {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //oldFileIO();
        /*Path relativeFilePath = Paths.get("relative.txt");

        List<String> lines = Files.readAllLines(relativeFilePath);
        System.out.println(lines);

        relativeFilePath = Paths.get("src/srcrelative.txt");
        lines = Files.readAllLines(relativeFilePath);
        System.out.println(lines);


        relativeFilePath = Paths.get("src", "srcrelative.txt");
        lines = Files.readAllLines(relativeFilePath);
        System.out.println(lines);


        Path path = Paths.get("/Users/abeljakov/IdeaProjects/sdacademy/file.txt");
        List<String> strings = Files.readAllLines(path);
        System.out.println(strings);


        Path createFilePath = Paths.get("newFile.txt");
        List<String> myFileContent = new ArrayList<>();
        myFileContent.add("Here");
        myFileContent.add("is");
        myFileContent.add("new");
        myFileContent.add("file");
        Files.write(createFilePath, myFileContent);
        // Path winpath = Paths.get("C:/Users/abeljakov/IdeaProjects/sdacademy/file.txt");


        List<String> allLines = Files.readAllLines(Paths.get("input.txt"));
        Integer linesToRead = Integer.valueOf(allLines.get(0));
        List<String> linesToWrite = new ArrayList<>();
        for (int i = 1; i <= linesToRead; i++) {
            linesToWrite.add(allLines.get(i));
        }
        Files.write(Paths.get("output.txt"), linesToWrite);


        final Path newOutput = Paths.get("newOutput.txt");

        try (BufferedReader reader = Files.newBufferedReader(Paths.get("input.txt"))) {
            Integer amountToRead = Integer.valueOf(reader.readLine());
            try (BufferedWriter writer = Files.newBufferedWriter(newOutput)) {

                for (int i = 1; i <= amountToRead; i++) {
                    writer.write(reader.readLine());
                    writer.newLine();
                }
            }

        }

        Files.createDirectories(Paths.get("temp/1/2/3"));
        System.out.println(Files.isDirectory(
                Paths.get("temp/1/2/3")));

        System.out.println(Files.isDirectory(
                Paths.get("newOutput.txt")));*/
        /*newFileIO();

        oldFileIO();


        */
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

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
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
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        }


    }

    private static void serialize() throws IOException, ClassNotFoundException {

        SerializablePerson person = new SerializablePerson("Aleksnadr", "Beljakov", 32);
        person.setOnline(true);
        System.out.println(person);

        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("person.txt"))) {
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(person);
        }
        SerializablePerson deserializedPerson;
        try (FileInputStream fileInputStream = new FileInputStream(new File("person.txt"))) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            deserializedPerson = (SerializablePerson) objectInputStream.readObject();
        }
        System.out.println(deserializedPerson);
    }
}
