package florist;

public class PriceList {

    private static PriceList instance = new PriceList();

    private PriceList() {}

    public static PriceList getInstance() {
        return instance;
    }

    Flower flower = null;

    public void put(String flowerName, double flowerPrice) {
        switch (flowerName) {
            case "bez" : flower = new Lilac(flowerPrice); break;
            case "frezja" : flower = new Freesia(flowerPrice); break;
            case "róża" : flower = new Rose(flowerPrice); break;
            case "piwonia" : flower = new Peony(flowerPrice); break;
            default:
                throw new IllegalStateException("Unexpected value: " + flowerName);
        }
    }
}
