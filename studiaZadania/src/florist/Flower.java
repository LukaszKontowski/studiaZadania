package florist;

public abstract class Flower {

    //private double flowerPrice;
    private int numberOfFlowers;
    private String name;
    private String color;

    protected Flower() {}

    protected Flower(int givenNumberOfFlowers) {
        numberOfFlowers = givenNumberOfFlowers;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String givenColor) {
        color = givenColor;
    }

    /*public double getFlowerPrice() {
        return flowerPrice;
    }

    public void setFlowerPrice(double givenFlowerPrice) {
        flowerPrice = givenFlowerPrice;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String givenName) {
        name = givenName;
    }

    public int getNumberOfFlowers() {
        return numberOfFlowers;
    }

    public abstract double getFlowerPrice();
}
