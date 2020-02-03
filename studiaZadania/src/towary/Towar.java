package towary;

import java.util.ArrayList;
import java.util.List;

public class Towar {
    private static int counter = 0;
    private final int weight;

    public static final List<Towar> towary = new ArrayList<>();

    public Towar(int weight) {
        this.weight = weight;
        counter++;
        towary.add(this);
    }

    public static int getCounter() {
        return counter;
    }

    public int getWeight() {
        return weight;
    }
}
