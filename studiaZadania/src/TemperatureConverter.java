/**
 * Napisać program przekształcający dane o temperaturze podane w skali Fahrenheita
 * do skali Celsjusza. Dane wejściowe (temperatura w skali Fahrenheita)
 * podać w inicjacji odpowiedniej zmiennej w programie.
 */

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class TemperatureConverter {

    private static DecimalFormat df2 = new DecimalFormat("#.00", DecimalFormatSymbols.getInstance(Locale.US));

    private static double fahrenheitToCelsius(double fahrenheitTemp) {
        double celsiusTemp = Double.parseDouble(df2.format((fahrenheitTemp - 32.0)*(5.0/9.0)));
        return celsiusTemp;
    }

    public static void main(String[] args) {
        System.out.println(fahrenheitToCelsius(56.9764));
    }
}
