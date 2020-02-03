package florist;

public class Rose extends Flower {

    private static double flowerPrice = -1;

    protected Rose() {
        this.setColor("czerwony");
        this.setName("róża");
    }

    protected Rose(int numberOfFlowers) {
        super(numberOfFlowers);
        this.setColor("czerwony");
        this.setName("róża");
    }

    protected Rose(double givenFlowerPrice) {
        flowerPrice = givenFlowerPrice;
    }

    public double getFlowerPrice() {
        return flowerPrice;
    }
}
