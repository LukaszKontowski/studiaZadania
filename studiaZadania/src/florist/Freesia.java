package florist;

public class Freesia extends Flower {

    private static double flowerPrice = -1;

    protected Freesia() {
        this.setColor("żółty");
        this.setName("frezja");
    }

    protected Freesia(int numberOfFlowers) {
        super(numberOfFlowers);
        this.setColor("żółty");
        this.setName("frezja");
    }

    protected Freesia(double givenFlowerPrice) {
        flowerPrice = givenFlowerPrice;
    }

    public double getFlowerPrice() {
        return flowerPrice;
    }
}
