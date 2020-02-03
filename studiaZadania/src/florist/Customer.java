package florist;

import java.util.*;

public class Customer {
    private String name;
    private double cash;
    private ShoppingCart shoppingCart;
    private HashMap<Flower, Integer> temporaryAmountOfWantedFlowers;

    public Customer(String name, double cash) {
        this.name = name;
        this.cash = cash;
        temporaryAmountOfWantedFlowers = new HashMap<>();
        shoppingCart = new ShoppingCart(temporaryAmountOfWantedFlowers);
        shoppingCart.setCustomer(this);
    }

    public String getName() {
        return name;
    }

    public double getCash() {
        return cash;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void pay() {
        double totalCost = 0;
        temporaryAmountOfWantedFlowers.keySet().removeIf((Flower flower) -> flower.getFlowerPrice() == -1);
        shoppingCart.keySet().removeIf((Flower flower) -> flower.getFlowerPrice() == -1);
        Set<Map.Entry<Flower, Integer>> entrySet = temporaryAmountOfWantedFlowers.entrySet();
        List<Map.Entry<Flower, Integer>> listOfEntries = new ArrayList(entrySet);
        ListIterator<Map.Entry<Flower, Integer>> iterator = listOfEntries.listIterator();
        while (iterator.hasNext()) {
            if (totalCost + (iterator.next().getKey().getFlowerPrice() * iterator.previous().getValue()) <= cash) {
                totalCost += (iterator.next().getKey().getFlowerPrice() * iterator.previous().getValue());
                iterator.next();
            } else {
                temporaryAmountOfWantedFlowers.remove(iterator.next());
                iterator.remove();
            }
        }
        cash = cash - totalCost;
    }

    public void pack(Box customersBox) {
        this.getShoppingCart().clear();
        customersBox.putAll(temporaryAmountOfWantedFlowers);
    }

    public void get(Flower flower) {
        this.temporaryAmountOfWantedFlowers.put(flower, flower.getNumberOfFlowers());
        this.shoppingCart.put(flower, flower.getNumberOfFlowers());
    }

}
