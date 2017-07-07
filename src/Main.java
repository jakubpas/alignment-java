import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        Main app = new Main();
        String fileName = args[0];
        System.out.println(fileName);
        app.printFile(Aligment.align(app.readFile(fileName)));
    }

    public List<String> readFile(String fileName) {

        List<String> lines = new ArrayList<>();
        try {
            return Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            return lines;
        }
    }

    public void printFile(List<String> lines) {
        lines.forEach(System.out::println);
    }
}
