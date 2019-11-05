/**
 * Napisać program obliczający koszt jakichś (dowolnie wybranych) zakupów w sklepie
 * i pokazujący sumaryczną wartość zakupów oraz procentowy udział w tej wartości
 * wartości poszczególnych produktów. Kupione produkty charakteryzowane są przez ilości i ceny
 * (np. jabłka - 1 kg , cena za kg - 3 zł).
 */

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

public class ShoppingSimulator {

    private static int NUMBER_OF_PRODUCTS;

    private static MathContext mathContext = new MathContext(4);

    private static DecimalFormat df = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.US));

    private static void doShopping() {
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
        System.out.println("Type in total number of products in current shopping:");
        NUMBER_OF_PRODUCTS = in.nextInt();

        String[] productNames = new String[NUMBER_OF_PRODUCTS];
        BigDecimal[] pricesPerKilo = new BigDecimal[NUMBER_OF_PRODUCTS];
        BigDecimal[] totalWeights = new BigDecimal[NUMBER_OF_PRODUCTS];
        BigDecimal[] finalPrices = new BigDecimal[NUMBER_OF_PRODUCTS];
        BigDecimal totalPrice = new BigDecimal(0.0, mathContext);

        for (int i = 1; i < (NUMBER_OF_PRODUCTS + 1); i++) {
            System.out.println("Type in the name of the " + i + ". product: ");
            do {
                productNames[i - 1] = in.nextLine();
            } while (productNames[i - 1].equals(""));

            System.out.println("Type in the price per Kilo of the " + i + ". product: ");
            pricesPerKilo[i - 1] = new BigDecimal(in.nextDouble(), mathContext);

            System.out.println("Type in the total weight of the " + i + ". product: ");
            totalWeights[i - 1] = new BigDecimal(in.nextDouble(), mathContext);
            finalPrices[i - 1] = pricesPerKilo[i - 1].multiply( totalWeights[i - 1], mathContext);

            System.out.println("Total price of "  + productNames[i - 1] + " = " + finalPrices[i - 1].setScale(2, RoundingMode.CEILING));
            totalPrice = totalPrice.add(finalPrices[i - 1]);
        }

        System.out.println("Total price of your shopping: " + totalPrice.setScale(2, RoundingMode.CEILING));
        for (int i = 1; i < (NUMBER_OF_PRODUCTS + 1); i++) {
            double percentageParticipation = Double.parseDouble(df.format((finalPrices[i - 1].divide(totalPrice, 5, RoundingMode.CEILING)).doubleValue() * 100));
            System.out.println("Percentage participation of " +
                    productNames[i - 1] + " in current shopping: " + percentageParticipation + "%");
        }
    }

    public static void main(String[] args) {
        doShopping();
    }
}
