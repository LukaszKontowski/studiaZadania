package florist;

public class Lilac extends Flower {

    private static double flowerPrice = -1;

    protected Lilac() {
        this.setColor("biały");
        this.setName("bez");
    }

    protected Lilac(int numberOfFlowers) {
        super(numberOfFlowers);
        this.setColor("biały");
        this.setName("bez");
    }

    protected Lilac(double givenFlowerPrice) {
        flowerPrice = givenFlowerPrice;
    }

    public double getFlowerPrice() {
        return flowerPrice;
    }
}
