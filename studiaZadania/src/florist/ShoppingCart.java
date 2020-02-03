package florist;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart extends HashMap<Flower, Integer> {

    private Customer customer;

    public ShoppingCart(HashMap<Flower, Integer> temporaryAmountOfWantedFlowers) {
        super(temporaryAmountOfWantedFlowers);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "Wózek właściciel " + customer.getName() + " -- pusto";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wózek właściciel ").append(customer.getName());
        for (Map.Entry<Flower, Integer> entry : this.entrySet()) {
            stringBuilder.append("\n")
                    .append(entry.getKey().getName()).append(", kolor: ")
                    .append(entry.getKey().getColor()).append(", ilość ")
                    .append(entry.getValue()).append(", cena ").append(entry.getKey().getFlowerPrice());
        }
        return stringBuilder.toString();
    }

}
