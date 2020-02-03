package florist;

import java.util.HashMap;
import java.util.Map;

public class Box extends HashMap<Flower, Integer> {
    private Customer customer;

    public Box(Customer customer) {
        this.customer = customer;
    }

    public static int valueOf(Box box, String color) {
        int totalValue = 0;
        for (Map.Entry<Flower, Integer> entry : box.entrySet()) {
            if (entry.getKey().getColor().equals(color)) {
                totalValue += (entry.getValue() * entry.getKey().getFlowerPrice());
            }
        }
        return totalValue;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Pudełko właściciel " + customer.getName() + " -- pusto";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pudełko właściciel ").append(customer.getName());
        for (Map.Entry<Flower, Integer> entry : this.entrySet()) {
            stringBuilder.append("\n")
                    .append(entry.getKey().getName()).append(", kolor: ")
                    .append(entry.getKey().getColor()).append(", ilość ")
                    .append(entry.getValue()).append(", cena ").append(entry.getKey().getFlowerPrice());
        }
        return stringBuilder.toString();
    }
}
