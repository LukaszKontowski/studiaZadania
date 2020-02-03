package letters;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TextFileGenerator {
    static void writeTextFile(String text) {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new
                FileOutputStream("Towary.txt"), "UTF-8"))) {
            out.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String createText() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 20_000; i++) {
            stringBuilder.append(i).append(" ").append(getWeight()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

        static int getWeight() {
            return (int)(Math.random() * 100);
        }

    public static void main(String[] args) {
        writeTextFile(createText());
    }

}
