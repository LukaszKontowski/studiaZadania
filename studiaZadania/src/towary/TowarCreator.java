package towary;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TowarCreator extends Thread {
    public static boolean isDead = false;

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new
                InputStreamReader(new FileInputStream("../Towary.txt"), StandardCharsets.UTF_8))) {
            String line;
            int weight;
            int count = 0;
            synchronized (Towar.towary) {
                while((line = in.readLine()) != null) {
                    weight = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
                    new Towar(weight);
                    count++;
                    if (count % 100 == 0) {
                        Towar.towary.notify();
                        Towar.towary.wait();
                    }
                    if (count % 200 == 0) {
                        System.out.println("utworzono " + Towar.towary.size() + " obiektów");
                        //new Towar(weight);
                        WeightConsumer.shouldContinue = true;
                        Towar.towary.notify();
                        Towar.towary.wait();
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("utworzono " + Towar.towary.size() + " obiektów");
        isDead = true;
        WeightConsumer.shouldContinue = true;
        synchronized (Towar.towary) {
            Towar.towary.notify();
        }
    }
}
