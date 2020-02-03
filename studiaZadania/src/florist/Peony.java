package florist;

public class Peony extends Flower {

    private static double flowerPrice = -1;

    protected Peony() {
        this.setColor("czerwony");
        this.setName("piwonia");
    }

    protected Peony(int numberOfFlowers) {
        super(numberOfFlowers);
        this.setColor("czerwony");
        this.setName("piwonia");
    }

    protected Peony(double givenFlowerPrice) {
        flowerPrice = givenFlowerPrice;
    }

    public double getFlowerPrice() {
        return flowerPrice;
    }
}
