/**
 * Zbudować klasę NumTeller ze statyczną metodą String say(int),
 * która zwraca podaną liczbę ze słownym przyrostkiem wg następującego wzoru:
 * 0 = 0-owy
 * 1 = 1-szy
 * 2 = 2-gi
 * 3 = 3-ci
 * 4 = 4-ty
 * 5 = 5-ty
 * 6 = 6-ty
 * 7 = 7-my
 * 8 = 8-my
 * 9-ty
 * 10-ty
 * 11-ty
 * 12-ty
 * ...
 * 20-ty
 * 21-szy
 * 22-gi
 * 23-ci
 * ...
 * itd.
 *
 * Uwaga: liczby mogą być dowolne (ujemne i duże dodatnie!).
 *
 * W klasie Main zdefiniować  metodę main, w której w (jednym) dialogu wejściowym
 * (JOptionPane.showInputDialog) podajemy trzy liczby całkowite, rozdzialone spacjami
 * i pokazujemy je w kolejnych wierszach na konsoli
 */

package numTeller;

public class NumTeller {

    public static String say(int number) {
        if (number == 0) {
            return "0-owy";
        }
        if (number % 1000000 == 0) {
            return number + "-owy";
        }
        if (number % 100 == 0) {
            return number + "-ny";
        }
        if (isExceptional(number)) {
            return number + "-ty";
        }

        int lastDigit = getLastDigit(number);
        switch (lastDigit) {
            case 0 :
            case 4 :
            case 5 :
            case 6 :
            case 9 :
                return (number + "-ty");
            case 1 : return (number + "-szy");
            case 2 : return (number + "-gi");
            case 3 : return (number + "-ci");
            case 7 :
            case 8 :
                return (number + "-my");
        }

        return null;	// in fact unreachable
    }

    private static boolean isExceptional(int number) {
        String numberAsText = Integer.toString(number);
        if (numberAsText.endsWith("11") ||
                numberAsText.endsWith("12") ||
                numberAsText.endsWith("13") ||
                numberAsText.endsWith("14") ||
                numberAsText.endsWith("15") ||
                numberAsText.endsWith("16") ||
                numberAsText.endsWith("17") ||
                numberAsText.endsWith("18")) {
            return true;
        } else {
            return false;
        }
    }

    private static int getLastDigit(int number) {
        int lastDigit = Math.abs(number % 10);
        return lastDigit;
    }
}
